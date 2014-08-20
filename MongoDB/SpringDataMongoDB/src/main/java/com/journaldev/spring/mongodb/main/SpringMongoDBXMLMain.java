package com.journaldev.spring.mongodb.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.mongodb.dao.PersonDAO;
import com.journaldev.spring.mongodb.model.Person;

public class SpringMongoDBXMLMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
		
		Person p = new Person(null, "PankajKr", "Bangalore, India");
		
		//create
		personDAO.create(p);
		System.out.println("Generated ID="+p.getId());
		
		//read
		Person p1 = personDAO.readById(p.getId());
		System.out.println("Retrieved Person="+p1);
		
		//update
		p1.setName("David");p1.setAddress("SFO, USA");
		personDAO.update(p1);
		Person temp = personDAO.readById(p1.getId());
		System.out.println("Retrieved Person after update="+temp);
		
		//delete
		int count = personDAO.deleteById(p1.getId());
		System.out.println("Number of records deleted="+count);
		
		ctx.close();

	}

}
