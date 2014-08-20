package com.journaldev.spring.mongodb.dao;

import com.journaldev.spring.mongodb.model.Person;

public interface PersonDAO {

	public void create(Person p);
	
	public Person readById(String id);
	
	public void update(Person p);
	
	public int deleteById(String id);
}
