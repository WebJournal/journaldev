package com.journaldev.csv;

public class Employee {

	private int id;
	private String name;
	private String role;
	private String salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString(){
		return "\nID="+getId()+"::Name"+getName()+"::Role="+getRole()+"::Salary="+getSalary();
	}
}
