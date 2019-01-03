package com.journaldev.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {
	private String name;
	private double salary;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "::" + name + "::" + salary;
	}

}
