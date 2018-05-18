package com.journaldev.access;

import com.journaldev.access.TestA;

public class TestB {

	public static void main(String args[]){
		TestA.methodPublic();
		TestA.methodProtected();
		TestA.methodDefault();
		
	}
	
	public static void methodPublic(){
		
	}
	
	protected static void methodProtected(){
		
	}
	
	static void methodDefault(){
		
	}
	
	private static void methodPrivate(){}

	
}
