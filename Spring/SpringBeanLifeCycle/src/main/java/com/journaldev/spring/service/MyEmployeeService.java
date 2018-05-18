package com.journaldev.spring.service;

import com.journaldev.spring.bean.Employee;

public class MyEmployeeService{

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public MyEmployeeService(){
		System.out.println("MyEmployeeService no-args constructor called");
	}

	public void destroy() throws Exception {
		System.out.println("MyEmployeeService Closing resources");
	}

	public void init() throws Exception {
		System.out.println("MyEmployeeService initializing to dummy value");
		if(employee.getName() == null){
			employee.setName("Pankaj");
		}
	}
}
