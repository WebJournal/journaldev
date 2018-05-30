package com.journaldev.listeners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Test3TestListener.class, Test3SuiteListener.class})
public class Test3 {

	@Test
	public void test() {
		System.out.println("Test3 test method");
	}
	
	@Test(dataProvider = "dp")
	public void testString(String s) {
		System.out.println("Test3 testString method, input = "+s);
	}
	
	@DataProvider
	public Object[] dp() {
		return new Object[] {"A", "B"};
	}
	
}
