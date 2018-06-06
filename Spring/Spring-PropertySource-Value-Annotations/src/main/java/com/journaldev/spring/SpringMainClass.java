package com.journaldev.spring;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.journaldev.spring");
		context.refresh();

		DBConnection dbConnection = context.getBean(DBConnection.class);

		Connection con = dbConnection.getConnection();

		System.out.println(con.getMetaData().getDatabaseProductName());
		System.out.println(con.getMetaData().getDatabaseProductVersion());

		// close the spring context
		context.close();
	}

}
