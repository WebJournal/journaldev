package com.journaldev.access;

public class ChildClass extends SuperClass {

	public ChildClass(String str){
		//access super class constructor with super keyword
		super();
		
		//access child class method
		test();
		
		//use super to access super class method
		super.test();
	}
	
	@Override
	public void test(){
		System.out.println("child class test method");
	}
	
	public static void main(String args[]){
		Object str = new String("abc");
		
		if(str instanceof String){
			System.out.println("String value:"+str);
		}
		
		if(str instanceof Integer){
			System.out.println("Integer value:"+str);
		}
	}
}
