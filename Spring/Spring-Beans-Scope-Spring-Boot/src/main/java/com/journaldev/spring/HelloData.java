package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloData {

	@Autowired
	private Customer customer;
	
	@RequestMapping("/nameRS")
	public String helloRS() {
		return customer.getDataRequestScope().getName();
	}
	
	@RequestMapping("/nameSSUpdated")
	public String helloSSUpdated() {
		customer.getDataSessionScope().setName("Session Scope Updated");
		return customer.getDataSessionScope().getName();
	}
	
	@RequestMapping("/nameSS")
	public String helloSS() {
		return customer.getDataSessionScope().getName();
	}
}
