package com.journaldev.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WelcomeAction extends ActionSupport implements ModelDriven<User> {

	@Override
	public String execute(){
		return SUCCESS;
	}
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
