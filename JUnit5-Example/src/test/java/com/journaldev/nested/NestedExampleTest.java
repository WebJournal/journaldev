package com.journaldev.nested;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class NestedExampleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll - Outer Class");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll - Outer Class");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("@BeforeEach - Outer Class");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("@AfterEach - Outer Class");
	}

	@Test
	void outer_test() {
		System.out.println("Outer Class test method");
	}

	@Nested
	@TestInstance(Lifecycle.PER_CLASS)
	class InnerClass {
		@BeforeAll
		void setUpBeforeClassInner() throws Exception {
			System.out.println("@BeforeAll - Inner Class");
		}

		@AfterAll
		void tearDownAfterClassInner() throws Exception {
			System.out.println("@AfterAll - Inner Class");
		}

		@BeforeEach
		void setUp() throws Exception {
			System.out.println("@BeforeEach - Inner Class");
		}

		@AfterEach
		void tearDown() throws Exception {
			System.out.println("@AfterEach - Inner Class");
		}

		@Test
		void inner_test() {
			System.out.println("Inner Class test method");
		}
	}
}
