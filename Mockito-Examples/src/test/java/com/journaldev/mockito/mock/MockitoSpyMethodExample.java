package com.journaldev.mockito.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MockitoSpyMethodExample {

	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		List<String> spyOnList = spy(list);
		
		when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());
		
		//calling real methods since below methods are not stubbed
		spyOnList.add("Pankaj");
		spyOnList.add("Meghna");
		assertEquals("Pankaj", spyOnList.get(0));
		assertEquals("Meghna", spyOnList.get(1));
	}
	
}
