package com.journaldev.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DataSourceTest {

	public static void main(String[] args) {
		
		testDataSource("mysql");
		System.out.println("**********");
		testDataSource("oracle");

	}

	private static void testDataSource(String dbType) {
		DataSource ds = null;
		if("mysql".equals(dbType)){
			ds = MyDataSourceFactory.getMySQLDataSource();
		}else if("oracle".equals(dbType)){
			ds = MyDataSourceFactory.getOracleDataSource();
		}else{
			System.out.println("invalid db type");
			return;
		}
		
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
