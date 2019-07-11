package com.journaldev.tinylog;

import org.tinylog.Logger;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Logger.tag("MAIN").debug("Program Started");
		
		EmployeeService empService = new EmployeeService();

		Employee emp = empService.createEmployee(10, "Pankaj");

		System.out.println("Employee ID = " + emp.getId());
		System.out.println("Employee Name = " + emp.getName());

		Logger.tag("MAIN").debug("Program Finished");

	}

}
