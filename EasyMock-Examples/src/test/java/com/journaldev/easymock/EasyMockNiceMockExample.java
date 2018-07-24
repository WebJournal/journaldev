package com.journaldev.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.easymock.Mock;
import org.easymock.MockType;
import org.junit.jupiter.api.Test;

public class EasyMockNiceMockExample {

	@Mock(MockType.STRICT)
	Object obj;
	
	@Mock(type=MockType.NICE)
	Object obj1;
	
	@Test
	public void test() {
		ArrayList<Integer> mockList = mock(MockType.NICE, ArrayList.class);
		expect(mockList.add(10)).andReturn(true);
		expect(mockList.size()).andReturn(2);
		expect(mockList.get(0)).andReturn(10);
		replay(mockList);

		mockList.add(10);
		// below will NOT throw exception because of nice mocking
		boolean b = mockList.add(30);
		assertFalse(b);

		assertEquals(mockList.size(), 2);

		assertTrue(mockList.get(0) == 10);
		//verify won't throw error for unexpected calls for nice mock
		verify(mockList);
	}
}
