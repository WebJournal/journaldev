package com.journaldev.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class EasyMockMethodTestNGExample {

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

	}
}
