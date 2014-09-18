package com.journaldev.servlet.model;

public class User {
	
	private String name;
	private String email;
	private String password;
	private String address;
	
	public User(){}
	
	public User(String name, String email, String password, String address){
		this.name=name;
		this.email=email;
		this.password=password;
		this.address=address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
