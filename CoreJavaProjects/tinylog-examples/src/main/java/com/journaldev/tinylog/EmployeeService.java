package com.journaldev.tinylog;

import org.tinylog.Logger;

public class EmployeeService {

	public Employee createEmployee(int i, String n) {
		Logger.info("Creating Employee with ID = " + i + " and Name = " + n);
		Employee emp = new Employee();
		emp.setId(i);
		emp.setName(n);
		return emp;
	}
	
}
