package com.journaldev.jdbc.preparedstatement.in;

public class JDBCPreparedStatementINTest {

	private static int[] ids = {1,2,3,4,5,6,7,8,9,10};
	
	public static void main(String[] args) {
		
		JDBCPreparedStatementSingle.printData(ids);
		
		System.out.println("*********");
		
		JDBCPreparedStatementDynamic.printData(ids);
		
		System.out.println("*********");
		
		JDBCPreparedStatementNULL.printData(new int[]{1,2,3,4,5});
	}

}
