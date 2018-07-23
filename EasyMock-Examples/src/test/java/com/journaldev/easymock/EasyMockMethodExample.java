package com.journaldev.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class EasyMockMethodExample {

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
		// below will throw exception because it's not mocked
		//mockList.add(30);

		assertTrue(mockList.get(0) == 10);

		assertEquals(mockList.size(), 2);

		//Iterator Style Mocking
		reset(mockList);
		expect(mockList.size()).andReturn(1).times(2)
			.andReturn(2).times(1)
			.andReturn(4);
		replay(mockList);
		
		assertEquals(mockList.size(), 1);
		assertEquals(mockList.size(), 1);
		assertEquals(mockList.size(), 2);
		assertEquals(mockList.size(), 4);
	}
}
