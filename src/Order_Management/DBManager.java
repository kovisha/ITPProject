package Order_Management;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	private static String url = "jdbc:mysql://localhost:3306/udssuper";
	private static String userName = "root";
	private static String password = "M@ng@th@9093";
    private static Connection con;
   
    public static Connection getConection() {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url , userName , password);
        }
        catch (Exception e) {
            System.out.println("Database connection is not success!!!");
        }
        return con;
    }

}
