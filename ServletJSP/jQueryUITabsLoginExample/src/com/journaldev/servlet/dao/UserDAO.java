package com.journaldev.servlet.dao;

import com.journaldev.servlet.model.User;

public interface UserDAO {

	public int createUser(User user);
	
	public User loginUser(User user);
	
}
