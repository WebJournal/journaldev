package com.journaldev.spring.mongodb.model;

import org.springframework.data.annotation.Id;

public class Person {

	//id will be used for storing MongoDB _id
	@Id
	private String id;
	
	private String name;
	private String address;
	
	public Person(){}
	public Person(String i, String n, String a){
		this.id=i;
		this.name=n;
		this.address=a;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString(){
		return id+"::"+name+"::"+address;
	}
}
