package com.journaldev.jdbc.storedproc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCStoredProcedureRead {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement stmt = null;
		
		//Read User Inputs
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Employee ID (int):");
		int id = Integer.parseInt(input.nextLine());
		
		try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call getEmployee(?,?,?,?,?)}");
			stmt.setInt(1, id);
			
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			
			stmt.execute();
			
			//read the OUT parameter now
			String name = stmt.getString(2);
			String role = stmt.getString(3);
			String city = stmt.getString(4);
			String country = stmt.getString(5);
			
			if(name !=null){
			System.out.println("Employee Name="+name+",Role="+role+",City="+city+",Country="+country);
			}else{
				System.out.println("Employee Not Found with ID"+id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
