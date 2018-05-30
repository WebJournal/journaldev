package com.journaldev.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 {

	private String str;
	
	public Test1(String s) {
		this.str = s;
	}
	
	@Test
	public void test1() {
		System.out.println("Test1 test method. str = "+str);
	}
}
