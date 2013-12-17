package com.journaldev.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OraclePreparedStatement;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class GetDBObjectSize {

	public static void main(String[] args) throws Exception {
		getDBObjectSize("NEXUS_DBA.RECTANGLE");
	}
	
	public static void getDBObjectSize(String dbObjName) throws Exception {

		Connection connection = getConnection();

		try {
			StructDescriptor structDBDescriptor = StructDescriptor
					.createDescriptor(dbObjName, connection);
			System.out.println(structDBDescriptor.getJavaClassName());
			System.out.println("Length of the DB Object :"
					+ structDBDescriptor.getLength());
			// Object rectObjArray[] =
			// createDBObj(structDBDescriptor.getLength());
			// STRUCT colStruct1 = new STRUCT(structDBDescriptor, connection,
			// rectObjArray);
			// String proc = "Begin " + "NEXUS_DBA.testobjectoverload (?);End;";
			//
			// OraclePreparedStatement ps =
			// (OraclePreparedStatement)connection.prepareStatement(proc);
			//
			// ps.setSTRUCT(1, colStruct1);
			// int i = ps.executeUpdate();
			// System.out.println("After calling update - Value of update " +
			// i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	private static Connection getConnection() throws Exception {
		Connection connection = null;
		Class.forName("oracle.jdbc.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@//chomper.corp.apple.com:1871/nexusd",
				"nexus_user", "poiuytyrewqasdfghjklzx");
		return connection;
	}

	private static void closeConnection(Connection connection)
			throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	public static Object[] createDBObj(int length) {
		Object rectangleObject[] = null;
		rectangleObject = new Object[length];
		rectangleObject[0] = 10;
		// rectangleObject[1] = 20;
		// rectangleObject[2] = 200;
		return rectangleObject;
	}

	

}
