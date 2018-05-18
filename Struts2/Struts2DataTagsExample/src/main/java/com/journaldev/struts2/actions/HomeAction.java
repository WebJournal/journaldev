package com.journaldev.struts2.actions;

import com.journaldev.struts2.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(){
		user = new User();
		user.setName("Pankaj Kumar");
		user.setGender("Male");
		
		return SUCCESS;
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
