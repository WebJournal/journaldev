package com.journaldev.displayname;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("MyTestClass")
public class DisplayNameTest {

	@Test
	void dummy() {
		//dummy test
	}
	@Test
	@DisplayName("Example Test Method with No Business Logic")
	void test() {
		assertTrue(3 > 0);
	}
	
	@Test
	@DisplayName("MyTestMethod ☺")
	void test1(TestInfo testInfo) {
		assertEquals("MyTestMethod ☺", testInfo.getDisplayName());
	}
}
