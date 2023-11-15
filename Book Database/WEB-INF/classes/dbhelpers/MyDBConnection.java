/**
 * 
 */
package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  author vc
 */
public class MyDBConnection {
	private static final String dbURL = "jdbc:mysql://scifi-library.cc5af58jaqxk.us-east-1.rds.amazonaws.com/";
	private static final String dbName = "scif_library";
	private static final String dbUser = "mist4630";
	private static final String dbPwd = "wordpass";
	
	private static Connection connection = null;
	
	private MyDBConnection () {}
	
	@SuppressWarnings("deprecation")
	public static Connection getConnection() {
		
		String url = dbURL + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, dbUser, dbPwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// NOTE: Errors that occur here will show in the Console, but will not
			// stop the web app from running. These errors could be handled better.
			e.printStackTrace();
		}
		
		if (connection == null) {
			throw new RuntimeException("Error connecting to database.");
		}
		
		return connection;
	
	}
	
	
}
