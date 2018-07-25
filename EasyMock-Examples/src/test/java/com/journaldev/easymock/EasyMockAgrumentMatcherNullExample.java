package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EasyMockAgrumentMatcherNullExample {

	@Test
	public void test() {
		List<Object> mock = mock(ArrayList.class);
		
		expect(mock.add(isNull())).andReturn(true);
		expect(mock.add(notNull())).andReturn(false);
		replay(mock);
		
		assertTrue(mock.add(null));
		assertFalse(mock.add("Hi"));

	}
}