package com.journaldev.jaxrs.service;

import com.journaldev.jaxrs.model.Person;
import com.journaldev.jaxrs.model.Response;

public interface PersonService {

	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	public Person getPerson(int id);
	
	public Person[] getAllPersons();

}
