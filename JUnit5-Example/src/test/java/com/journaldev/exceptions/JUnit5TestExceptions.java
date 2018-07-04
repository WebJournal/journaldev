package com.journaldev.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit5TestExceptions {

	@Test
	void test() {
		String str = null;
		assertThrows(NullPointerException.class, () -> str.length());
		
		Foo foo = new Foo();
		Exception exception = assertThrows(Exception.class, () -> foo.foo());
		assertEquals("Exception Message", exception.getMessage());
	}

}

class Foo {
	void foo() throws Exception {
		throw new Exception("Exception Message");
	}
}
