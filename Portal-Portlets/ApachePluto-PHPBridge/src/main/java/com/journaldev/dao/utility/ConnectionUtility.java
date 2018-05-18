package com.journaldev.dao.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtility {
	
	private static ConnectionUtility connectionUtiliy = null;
	
	private Connection connection = null;
	
	private ConnectionUtility() {
	}
	
	public static ConnectionUtility getInstance() throws IOException, IllegalAccessException, SQLException, ClassNotFoundException{
		// Synchronized against connectionUtility instance
		synchronized(ConnectionUtility.class){
			// Check whether the connectionUtility is null or not
			if(connectionUtiliy == null){
				// Create a properties instance
				Properties properties = new Properties();
				// Load properties from classpath
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
				// Set connection with connectionUtility
				connectionUtiliy = new ConnectionUtility();
				// Load driver class
				Class.forName("com.mysql.jdbc.Driver");
				// Create connection
				connectionUtiliy.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/journaldev", properties));
			}
			return connectionUtiliy;
		}
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		if(connection.isClosed()){
			// Create a properties instance
			Properties properties = new Properties();
			// Load properties from classpath
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
			// Load driver class
			Class.forName("com.mysql.jdbc.Driver");
			// Create connection
			connectionUtiliy.setConnection(DriverManager.getConnection("jdbc:mysql://10.10.90.3:3306/journaldev", properties));
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
