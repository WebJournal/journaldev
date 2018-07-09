package com.journaldev.mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class MockitoSpyAnnotationExample {

	@Spy
	Utils mockUtils;
	
	@Spy
	List<String> spyList = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		when(mockUtils.process(1, 1)).thenReturn(5);
		//mocked method
		assertEquals(5, mockUtils.process(1, 1));
		//real method called since it's not stubbed
		assertEquals(20, mockUtils.process(19, 1));
		
		when(spyList.size()).thenReturn(5);
		assertEquals(5, spyList.size());
		
		spyList.add("Pankaj");
		spyList.add("Lisa");
		assertEquals("Pankaj", spyList.get(0));
		assertEquals("Lisa", spyList.get(1));
	}
	
}

class Utils{
		
	public int process(int x, int y) {
		System.out.println("Input Params = "+x+","+y);
		return x+y;
	}
}
