import java.sql.*;



/**
 * Created by candy on 16-5-3.
 */
public class main {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "candy";

    public static void main(String arg[]){
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection con = DriverManager.getConnection(url,user,password);
            PreparedStatement ste = con.prepareStatement(
                    "INSERT INTO girls(id,name) VALUES (2,'hanfeng')");



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
