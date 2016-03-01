package managers;

import java.sql.*;

public final class DBConnectionManager {
	
	private static String url = "jdbc:mysql://cse.unl.edu:3306/pluddy";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "pluddy";   
    private static String password = "nemo6856";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("[DBConnectionManager] - Driver Not Found"); 
        	e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("[DBConnectionManager] - Failed to create the database connection."); 
        }
        System.out.println("[DBConnectionManager] - Connected to " + url);
        return con;
    }
}
