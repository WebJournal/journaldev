package com.journaldev.java8.staticmethod;

public class Child extends Base{

//	public static String toString(){
//		System.out.println("Child foo called");
//		return "";
//	}
	
	public static void main(String[] args) {
		Base child = new Child();
		Base base = null;
		
		base.foo();
		child.foo();
	}

}
