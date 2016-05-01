import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by candy on 16-4-30.
 */
public class main {
    public static void main(String arg[]) {
        try {
            Option option = new Option();
            option.readdata();
            option.Sortbyfirst();
            for (int m = 0;m<option.i;m++){
                System.out.println(option.arrayList.get(m));
            }
            option.outputdata();
        } catch (Exception e) {
        }
    }
}

class Option {
    ArrayList<String> arrayList = new ArrayList<String>();
    int i = 0;
    public void readdata() throws Exception {
        RandomAccessFile instream = new RandomAccessFile("in.txt", "r");
        String str;
        while (true) {
            str = instream.readLine();
            if (str == null)
                break;
            else {
                arrayList.add(str);
                i++;
            }
        }
        instream.close();
    }

    public void Sortbyfirst() {
        Collections.sort(arrayList, new sort());
    }

    public void outputdata() throws Exception {
        File file = new File("out.txt");
        file.delete();
        RandomAccessFile outstream = new RandomAccessFile("out.txt", "rw");
        for (int k = 0; k < i; k++) {
            outstream.writeBytes(arrayList.get(k) + "\n");
        }

    }
}


class sort implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String str1 = (String) o1;
        String str2 = (String) o2;
        return str1.compareTo(str2);
    }
}

