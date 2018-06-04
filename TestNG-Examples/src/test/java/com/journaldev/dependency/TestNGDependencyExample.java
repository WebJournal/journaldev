package com.journaldev.dependency;

import org.testng.annotations.Test;

public class TestNGDependencyExample {

	@Test(groups = "pre-tests")
	public void init() {
		System.out.println("init resources");
	}

	@Test(groups = "tests", dependsOnGroups = "pre-tests")
	public void insert() {
		System.out.println("inserting demo data");
	}

	@Test(dependsOnMethods = "insert", groups = "tests")
	public void select() {
		System.out.println("selecting demo data");
	}

	@Test(dependsOnMethods = "select", groups = "tests")
	public void update() {
		System.out.println("updating demo data");
	}

	//NOTE: We can just specify dependsOnMethods= "update" and get same result
	@Test(dependsOnMethods = { "insert", "update" }, groups = "tests")
	public void delete() {
		System.out.println("deleting demo data");
	}

	@Test(dependsOnGroups = "tests")
	public void cleanup() {
		System.out.println("closing resources");
	}
}
