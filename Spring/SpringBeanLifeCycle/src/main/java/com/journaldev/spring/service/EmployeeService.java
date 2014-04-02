package com.journaldev.spring.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.journaldev.spring.bean.Employee;

public class EmployeeService implements InitializingBean, DisposableBean{

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public EmployeeService(){
		System.out.println("EmployeeService no-args constructor called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("EmployeeService Closing resources");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("EmployeeService initializing to dummy value");
		if(employee.getName() == null){
			employee.setName("Pankaj");
		}
	}
}
