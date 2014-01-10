package com.journaldev.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {
	
	private static final String QUERY = "select id,name,email,country,password from Users";

	public static void main(String[] args) {
				
		//using try-with-resources to avoid closing resources (boiler plate code)
		try(Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY)) {	
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				System.out.println(id + "," +name+ "," +email+ "," +country+ "," +password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
