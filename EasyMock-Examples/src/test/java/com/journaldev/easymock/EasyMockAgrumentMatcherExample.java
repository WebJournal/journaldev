package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class EasyMockAgrumentMatcherExample {

	@Test
	public void test() {
		ArrayList<Object> mockList = mock(ArrayList.class);
		expect(mockList.add(anyInt())).andReturn(true);
		expect(mockList.add(anyString())).andReturn(false);
		replay(mockList);

		assertTrue(mockList.add(10));
		assertFalse(mockList.add("Hi"));
		
		verify(mockList);
	}
}
