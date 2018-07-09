package com.journaldev.mockito.spy;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MockitoSpyExample {

	@Test
	void test() {
		List<String> list = new ArrayList<>();
		List<String> spyOnList = spy(list);
		

		spyOnList.add("A");
		assertEquals(1, spyOnList.size());
		assertEquals("A", spyOnList.get(0));

		spyOnList.add("E");
		assertEquals(2, spyOnList.size());
		assertEquals("E", spyOnList.get(1));

		when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());
	}
}
