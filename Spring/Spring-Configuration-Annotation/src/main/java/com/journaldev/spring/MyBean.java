package com.journaldev.spring;

public class MyBean {

	public MyBean() {
		System.out.println("MyBean instance created");
	}
	
	public void init() {
		System.out.println("MyBean Resources Initialized");
	}
}
