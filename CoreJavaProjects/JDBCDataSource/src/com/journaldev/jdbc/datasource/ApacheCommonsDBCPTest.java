package com.journaldev.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ApacheCommonsDBCPTest {

	public static void main(String[] args) {
		testDBCPDataSource("mysql");
		System.out.println("**********");
		testDBCPDataSource("oracle");
	}

	private static void testDBCPDataSource(String dbType) {
		DataSource ds = DBCPDataSourceFactory.getDataSource(dbType);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select empid, name from Employee");
			while(rs.next()){
				System.out.println("Employee ID="+rs.getInt("empid")+", Name="+rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
