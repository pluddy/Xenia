package managers;

import java.sql.*;

import org.apache.log4j.Logger;

public final class DBConnectionManager {
	
	final static Logger log = Logger.getLogger(DBConnectionManager.class.getName());
	
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
            log.error("Driver Not Found", e); 
        	e.printStackTrace();
        	return null;
        } catch (SQLException e) {
        	log.error("Failed to create the database connection.", e); 
        	return null;
        }
        log.info("Connected to " + url);
        return con;
    }
}
