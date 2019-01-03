package com.journaldev.jaxws.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.journaldev.jaxws.beans.Person;
import com.journaldev.jaxws.service.PersonService;

public class SOAPPublisherClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:8080/JAXWS-Tomcat/personWS?wsdl");
		//check above URL in browser, you should see WSDL file
		
		//creating QName using targetNamespace and name
		QName qname = new QName("http://service.jaxws.journaldev.com/", "PersonServiceImplService"); 
		
		Service service = Service.create(wsdlURL, qname);  
		
		//We need to pass interface and model beans to client
		PersonService ps = service.getPort(PersonService.class);
		
		Person p1 = new Person(); p1.setName("Pankaj"); p1.setId(1); p1.setAge(30);
		Person p2 = new Person(); p2.setName("Meghna"); p2.setId(2); p2.setAge(25);
		
		//add person
		System.out.println("Add Person Status="+ps.addPerson(p1));
		System.out.println("Add Person Status="+ps.addPerson(p2));
		
		//get person
		System.out.println(ps.getPerson(1));
		
		//get all persons
		System.out.println(Arrays.asList(ps.getAllPersons()));
		
		//delete person
		System.out.println("Delete Person Status="+ps.deletePerson(2));
		
		//get all persons
		System.out.println(Arrays.asList(ps.getAllPersons()));
		
	}

}
