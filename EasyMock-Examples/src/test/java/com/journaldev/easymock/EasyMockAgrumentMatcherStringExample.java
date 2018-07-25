package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EasyMockAgrumentMatcherStringExample {

	@Test
	public void test() {
		List<String> mock = mock(ArrayList.class);
		
		expect(mock.add(startsWith("Java"))).andReturn(true);
		expect(mock.add(endsWith("Dev"))).andReturn(true);
		expect(mock.add(contains("Pyt"))).andReturn(true);
		expect(mock.add(matches("^[abc]d."))).andReturn(true);
		expect(mock.add(find("[9]{3}"))).andReturn(true);

		replay(mock);
		
		//startsWith Java
		assertTrue(mock.add("Java World"));
		//endsWith Dev
		assertTrue(mock.add("JournalDev"));
		//contains Pyt
		assertTrue(mock.add("Python"));
		//matches ads
		assertTrue(mock.add("ads"));
		// 999 is one of substring
		assertTrue(mock.add("ABC999DDD")); 

		verify(mock);
	}
}