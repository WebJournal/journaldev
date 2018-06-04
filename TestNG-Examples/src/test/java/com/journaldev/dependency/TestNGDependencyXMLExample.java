package com.journaldev.dependency;

import org.testng.annotations.Test;

public class TestNGDependencyXMLExample {

	@Test(groups = "pre-tests")
	public void init() {
		System.out.println("init resources");
	}

	@Test(groups = "tests")
	public void insert() {
		System.out.println("inserting demo data");
	}

	@Test(groups = "tests")
	public void select() {
		System.out.println("selecting demo data");
	}

	@Test(groups = "tests")
	public void update() {
		System.out.println("updating demo data");
	}

	@Test(groups = "tests")
	public void delete() {
		System.out.println("deleting demo data");
	}

	@Test(groups = "post-tests")
	public void cleanup() {
		System.out.println("closing resources");
	}
}
