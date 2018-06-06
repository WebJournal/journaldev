package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Value;

public class DBConnection {

	@Value("${DB_DRIVER_CLASS}")
	private String driverClass;
	@Value("${DB_URL}")
	private String dbURL;
	@Value("${DB_USERNAME}")
	private String userName;
	@Value("${DB_PASSWORD}")
	private char[] password;

	public DBConnection() {
	}

	public void printDBConfigs() {
		System.out.println("Driver Class = " + driverClass);
		System.out.println("DB URL = " + dbURL);
		System.out.println("User Name = " + userName);

		// Never do below in production environment :D
		System.out.println("Password = " + String.valueOf(password));
	}
}
