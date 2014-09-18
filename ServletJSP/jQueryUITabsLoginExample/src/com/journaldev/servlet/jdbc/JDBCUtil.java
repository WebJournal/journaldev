package com.journaldev.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
private static Connection connection = null;

public static Connection getConnection() {
	if (connection != null)
		return connection;
	else {
		// database URL
		String dbUrl = "jdbc:mysql://localhost/TestDB";
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		// set the url, username and password for the database
		connection = DriverManager.getConnection(dbUrl, "pankaj", "pankaj123");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	}
}