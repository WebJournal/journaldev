package com.journaldev.model;

public class Address {

	private String address;

	public Address() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		return "Address="+address;
	}
}
