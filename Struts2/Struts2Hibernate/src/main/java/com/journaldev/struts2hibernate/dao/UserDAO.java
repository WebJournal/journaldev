package com.journaldev.struts2hibernate.dao;

import com.journaldev.struts2hibernate.model.User;

public interface UserDAO {

	User getUserByCredentials(String userId, String password);
}
