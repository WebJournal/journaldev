package com.journaldev.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="TRANSACTION")
public class Txn1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="txn_id")
	private long id;
	
	@Column(name="txn_date")
	private Date date;
	
	@Column(name="txn_total")
	private double total;
	
	@OneToOne(mappedBy="txn")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Customer1 customer;
	
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
	public Customer1 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}
	
}
