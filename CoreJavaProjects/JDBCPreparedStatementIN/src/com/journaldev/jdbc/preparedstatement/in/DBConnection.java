package com.journaldev.jdbc.preparedstatement.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() {
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);

			// load the Driver Class
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));

			// create the connection now
			con = DriverManager.getConnection(props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
		} catch (SQLException e) {
			System.out.println("Check database is UP and configs are correct");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Looks like db.property file has some issues");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Please include JDBC API jar in classpath");
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("File Close issue, lets ignore it.");
			}
		}
		return con;
	}
}
