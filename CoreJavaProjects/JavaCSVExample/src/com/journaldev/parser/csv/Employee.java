package com.journaldev.parser.csv;

public class Employee {

	private String id;
	private String name;
	private String role;
	private String salary;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		return "ID="+id+",Name="+name+",Role="+role+",Salary="+salary+"\n";
	}
}
