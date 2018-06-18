package com.journaldev.spring.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private int id;
	private String name;
	
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
	
	public Employee() {
	}

	public Employee(int i, String n) {
		this.id = i;
		this.name = n;
	}
	
	@Override
	public String toString() {
		return id + "," + name;
	}
	
}
