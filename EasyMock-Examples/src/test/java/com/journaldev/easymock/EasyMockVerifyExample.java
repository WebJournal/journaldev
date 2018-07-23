package com.journaldev.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class EasyMockVerifyExample {

	@Test
	public void test() {
		ArrayList<Integer> mockList = mock(ArrayList.class);
		expect(mockList.add(10)).andReturn(true);
		expect(mockList.add(20)).andReturn(true);
		expect(mockList.size()).andReturn(2);
		expect(mockList.get(0)).andReturn(10);
		replay(mockList);

		mockList.add(10);
		mockList.add(20);
		assertTrue(mockList.get(0) == 10);
		assertEquals(mockList.size(), 2);

		verify(mockList);
	}
}
