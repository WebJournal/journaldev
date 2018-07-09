package com.journaldev.mockito.argumentmatchers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MockitoArgumentMatchersExamples {

	@Test
	void test() {
		Foo mockFoo = mock(Foo.class);

		// Argument Matchers than static arguments
		when(mockFoo.bool(anyString(), anyInt(), any(Object.class))).thenReturn(true);
		assertTrue(mockFoo.bool("A", 1, "A"));
		assertTrue(mockFoo.bool("B", 10, new Object()));
		assertTrue(mockFoo.bool("false", 10, new Object()));

		// every argument should be argument matcher
		// use eq() when we have to use static value
		when(mockFoo.bool(eq("false"), anyInt(), any(Object.class))).thenReturn(false);
		assertFalse(mockFoo.bool("false", 10, new Object()));

		when(mockFoo.in(anyBoolean(), anyList())).thenReturn(10);

		// Arrays and Additional Matchers for rare cases
		when(mockFoo.bar(any(byte[].class), aryEq(new String[] { "A", "B" }), gt(10))).thenReturn(11);
		assertEquals(11, mockFoo.bar("abc".getBytes(), new String[] { "A", "B" }, 20));
		assertEquals(11, mockFoo.bar("xyz".getBytes(), new String[] { "A", "B" }, 99));
		
		// argument matchers with verify
		verify(mockFoo, atLeast(0)).bool(anyString(), anyInt(), any(Object.class));
		verify(mockFoo, atLeast(0)).bool(eq("false"), anyInt(), any(Object.class));

	}
}

class Foo {
	boolean bool(String str, int i, Object obj) {
		return false;
	}

	int in(boolean b, List<String> strs) {
		return 0;
	}

	int bar(byte[] bytes, String[] s, int i) {
		return 0;
	}
}
