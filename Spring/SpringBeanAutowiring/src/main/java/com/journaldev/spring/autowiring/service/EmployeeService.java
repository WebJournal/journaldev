package com.journaldev.spring.autowiring.service;

import com.journaldev.spring.autowiring.model.Employee;

public class EmployeeService {

	private Employee employee;

	// constructor is used for autowiring by constructor
	public EmployeeService(Employee emp) {
		System.out.println("Autowiring by constructor used");
		this.employee = emp;
	}

	// default constructor to avoid BeanInstantiationException for autowiring
	// byName or byType
	public EmployeeService() {
		System.out.println("Default Constructor used");
	}

	// used for autowire byName and byType
	public void setEmployee(Employee emp) {
		this.employee = emp;
	}

	public Employee getEmployee() {
		return this.employee;
	}
}
