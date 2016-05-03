import java.sql.*;
/**
 * Created by candy on 16-5-3.
 */
public class Database {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "candy";
    public static void main(String arg[]){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); 两种写法加载ｊｄｂｃ驱动。
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            //建立链接
            Connection con = DriverManager.getConnection(url,user,password);
            //
            Statement ste =  con.createStatement();
            ResultSet res=ste.executeQuery("SELECT * from girls");
            while (res.next()){
                System.out.println("id:"+res.getInt("id")+"    "+"Name:"+res.getString("name"));
            }
            //记得销毁链接和状态对象
            ste.close();
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}


