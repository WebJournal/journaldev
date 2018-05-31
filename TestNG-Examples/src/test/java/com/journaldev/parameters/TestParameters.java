package com.journaldev.parameters;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {

	@Test
	@Parameters("arguments")
	public void singleParameterTest(String s) {
		System.out.println("Testing for input parameter = " + s);
	}

	@Test
	@Parameters({ "id", "name" })
	public void multipleParameterTest(int id, String s) {
		System.out.println("Testing for multiple input parameter = " + id + " and " + s);
	}

	@BeforeSuite
	@Parameters("before_suite")
	public void beforeSuite(String s) {
		System.out.println("Before Suite Parameter = " + s);
	}

	@AfterSuite
	@Parameters("after_suite")
	public void afterSuite(@Optional("Default Parameter") String s) {
		System.out.println("After Suite Parameter = " + s);

	}

}
