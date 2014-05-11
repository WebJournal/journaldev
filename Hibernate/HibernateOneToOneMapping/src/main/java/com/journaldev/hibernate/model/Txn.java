package com.journaldev.hibernate.model;

import java.util.Date;

public class Txn {

	private long id;
	private Date date;
	private double total;
	private Customer customer;
	
	@Override
	public String toString(){
		return id+", "+total+", "+customer.getName()+", "+customer.getEmail()+", "+customer.getAddress();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
