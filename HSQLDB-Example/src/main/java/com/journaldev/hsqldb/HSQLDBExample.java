package com.journaldev.hsqldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HSQLDBExample {

	public static void main(String[] args) {
		Connection con = HSQLDBConnection.getConnection();
		System.out.println("Connection Obtained");

		try {
			PreparedStatement ps = con.prepareStatement(
					"select id, firstName, lastName from customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID = " + rs.getInt("id") + 
						", Name = " + rs.getString("firstName") + " "
						+ rs.getString("lastName"));
			}
			rs.close();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
