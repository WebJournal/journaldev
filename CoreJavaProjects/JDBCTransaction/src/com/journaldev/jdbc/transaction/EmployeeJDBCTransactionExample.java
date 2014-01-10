package com.journaldev.jdbc.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeJDBCTransactionExample {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			
			//set auto commit to false
			con.setAutoCommit(false);

			EmployeeJDBCInsertExample.insertEmployeeData(con, 1, "Pankaj");

			EmployeeJDBCInsertExample.insertAddressData(con, 1, "Albany Dr", "San Jose", "USA");
			
			//now commit transaction
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				System.out.println("JDBC Transaction rolled back successfully");
			} catch (SQLException e1) {
				System.out.println("SQLException in rollback"+e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
