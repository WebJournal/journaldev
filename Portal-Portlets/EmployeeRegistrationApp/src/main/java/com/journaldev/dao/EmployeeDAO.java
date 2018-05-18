package com.journaldev.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.journaldev.dao.utility.ConnectionUtility;
import com.journaldev.data.Employee;


public class EmployeeDAO {
	
	public static EmployeeDAO employeeDAO = null;
	
	private EmployeeDAO(){
		
	}
	
	public static EmployeeDAO getInstance(){
		synchronized(EmployeeDAO.class){
			if(employeeDAO == null){
				employeeDAO = new EmployeeDAO();	
			}
			
		}
		return employeeDAO;
	}
	
	public Employee createEmployee(Employee employee) throws SQLException, IllegalAccessException, IOException, ClassNotFoundException{
		// Get connection instance
		Connection connection = ConnectionUtility.getInstance().getConnection();
		// Create Prepared Statement
		PreparedStatement query = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?)");
		// Set variables
		query.setInt(1, employee.getId());
		query.setString(2, employee.getName());
		query.setString(3, employee.getJob());
		query.setInt(4, employee.getSalary());
		
		try {
			// Execute
			query.execute();
			// Return employee instance
			return employee;
		}
		catch(Exception e){
			// Close statement
			query.close();
			// Close connection
			connection.close();
			// Throw another exception for notifying the Servlet
			throw new SQLException(e);
		}
	}
	
	public boolean deleteEmployee(Employee employee){
		return false;
	}
	
	public boolean updateEmployee(Employee employee, int employeeId){
		return false;
	}
}
