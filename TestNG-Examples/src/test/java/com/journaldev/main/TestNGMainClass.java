package com.journaldev.main;

import org.testng.TestNG;

public class TestNGMainClass {

	public static void main(String[] args) {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { Test5.class });
		testSuite.addListener(new Test5SuiteListener());
		testSuite.setDefaultSuiteName("My Test Suite");
		testSuite.setDefaultTestName("My Test");
		testSuite.setOutputDirectory("/Users/pankaj/temp/testng-output");
		testSuite.run();
	}

}
