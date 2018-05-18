package com.journaldev.access;

public class SuperClass {

	public SuperClass(){
	}
	
	public SuperClass(int i){}
	
	public void test(){
		System.out.println("super class test method");
		System.gc();
		Runtime.getRuntime().gc();
	}
}
