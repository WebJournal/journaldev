package com.journaldev.struts2.interceptors;

import com.journaldev.struts2.models.User;


public interface UserAware {

	public void setUser(User user);
}
