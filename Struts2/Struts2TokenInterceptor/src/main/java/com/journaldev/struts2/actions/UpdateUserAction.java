package com.journaldev.struts2.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserAction extends ActionSupport {

	@Override
	public String execute() {
		System.out.println("Update Request Arrived to Action Class");
		//setting update time in action class
		setUpdateTime(new Date());
		return SUCCESS;
	}
	
	@Override
	public void validate(){
		if(isEmpty(getName())){
			addActionError("Name can't be empty");
		}
		if(isEmpty(getAddress())){
			addActionError("Address can't be empty");
		}
	}
	
	//java bean variables
	private String name;
	private String address;
	private Date updateTime;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	private boolean isEmpty(String str) {
		
		return str == null ? true:(str.equals("") ? true:false);
	}

}
