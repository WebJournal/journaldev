package com.journaldev.mockito.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class JUnitMockitoStubExceptions {

	@SuppressWarnings("unchecked")
	@Test
	void test() {
		List<String> list = mock(List.class);
		when(list.size()).thenThrow(new RuntimeException("size() method not supported"));

		Exception exception = assertThrows(RuntimeException.class, () -> list.size());
		assertEquals("size() method not supported", exception.getMessage());
	}
}
