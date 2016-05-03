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
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement ste =  con.createStatement();
            ResultSet res=ste.executeQuery("SELECT * from girls");
            while (res.next()){
                System.out.println("id:"+res.getInt("id")+"    "+"Name:"+res.getString("name"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Driver wrong");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("sql wrong");
        }
    }

}
