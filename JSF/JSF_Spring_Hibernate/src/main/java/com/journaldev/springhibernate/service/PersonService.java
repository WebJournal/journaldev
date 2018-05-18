package com.journaldev.springhibernate.service;

import java.util.List;

import com.journaldev.springhibernate.model.Person;
 
public interface PersonService {
 
    public void addPerson(Person p);
    public List<Person> listPersons();
     
}