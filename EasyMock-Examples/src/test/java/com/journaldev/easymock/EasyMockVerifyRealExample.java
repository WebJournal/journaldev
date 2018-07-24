package com.journaldev.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EasyMockVerifyRealExample {

	ArrayList<Integer> mockList;

	@BeforeEach
	public void setup() {
		mockList = mock(ArrayList.class);
	}

	@Test
	public void test() {
		expect(mockList.add(10)).andReturn(true);
		expect(mockList.get(0)).andReturn(10);
		replay(mockList);

		mockList.add(10);
		assertTrue(mockList.get(0) == 10);
	}

	@AfterEach
	public void teardown() {
		verify(mockList);
	}

}
