package com.journaldev.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.easymock.MockType;
import org.junit.jupiter.api.Test;

public class EasyMockNiceMockExample {

	@Test
	public void test() {
		ArrayList<Integer> mockList = mock(MockType.NICE, ArrayList.class);
		expect(mockList.add(10)).andReturn(true);
		expect(mockList.add(20)).andReturn(true);
		expect(mockList.size()).andReturn(2);
		expect(mockList.get(0)).andReturn(10);
		replay(mockList);

		mockList.add(10);
		mockList.add(20);
		// below will NOT throw exception because of nice mocking
		mockList.add(30);

		assertEquals(mockList.size(), 2);

		assertTrue(mockList.get(0) == 10);

	}
}
