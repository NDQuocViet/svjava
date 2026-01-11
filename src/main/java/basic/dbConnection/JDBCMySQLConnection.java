package basic.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SuppressWarnings("deprecation")
public class JDBCMySQLConnection {
	static private String CON_STRING = "jdbc:mysql://localhost:4406/ecom"
			+ "?useUnicode=true&useSSL=false&characterEncoding=UTF-8";
	static private String USERNAME = "root";
	static private String PASSWORD = "Ab@123456";
	
	static private Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
		}
		return connection;
	}
	
	public static void closeConnection() throws Exception{
		connection.close();
	}
	
	public static void main(String[] args) {
		
	}
}
