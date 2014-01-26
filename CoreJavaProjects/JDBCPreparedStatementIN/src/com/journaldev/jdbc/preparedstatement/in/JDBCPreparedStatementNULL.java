package com.journaldev.jdbc.preparedstatement.in;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatementNULL {

	private static final String QUERY = "select empid, name from Employee where empid in ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final int PARAM_SIZE = 10;
	public static void printData(int[] ids){
		
		if(ids.length > PARAM_SIZE){
			System.out.println("Maximum input size supported is "+PARAM_SIZE);
			//in real life, we can write logic to execute in batches, for simplicity I am returning
			return;
		}
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(QUERY);
			
			int i = 1;
			for(; i <=ids.length; i++){
				ps.setInt(i, ids[i-1]);
			}
			
			//set null for remaining ones
			for(; i<=PARAM_SIZE;i++){
				ps.setNull(i, java.sql.Types.INTEGER);
			}
			
			rs = ps.executeQuery();
				
			while(rs.next()){
				System.out.println("Employee ID="+rs.getInt("empid")+", Name="+rs.getString("name"));
			}
				
			//close the resultset here
			try{
				rs.close();
			} catch(SQLException e){}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
