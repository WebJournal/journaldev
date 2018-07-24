package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.journaldev.utils.StringUtils;

public class EasyMockExceptionExample {

	@Test
	public void test() {
		StringUtils mock = mock(StringUtils.class);
		
		expect(mock.toUpperCase(null)).andThrow(new IllegalArgumentException("NULL is not a valid argument"));
		replay(mock);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mock.toUpperCase(null));
		assertEquals("NULL is not a valid argument", exception.getMessage());
		
		verify(mock);
	}
}
