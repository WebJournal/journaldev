package com.journaldev.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class TestNGFactory {

	@Factory(dataProvider = "dp")
	public Object[] getTestClasses(String s) {
		Object[] tests = new Object[2];
		tests[0] = new Test1(s);
		tests[1] = new Test2();
		return tests;
	}
	
	@DataProvider
	public Object[] dp() {
		return new Object[] {"A", "B"};
	}
}
