package com.journaldev.mockito.mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoInjectMockAnnotationExample {

	@Mock
	List<String> mockList;
	
	//@InjectMock creates an instance of the class and 
	//injects the mocks that are marked with the annotations @Mock into it.
	@InjectMocks
	Fruits mockFruits;
	
	@BeforeEach
	public void setup() {
		//if we don't call below, we will get NullPointerException
		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		when(mockList.get(0)).thenReturn("Apple");
		when(mockList.size()).thenReturn(1);
		assertEquals("Apple", mockList.get(0));
		assertEquals(1, mockList.size());
		
		//mockFruits names is using mockList, below asserts confirm it
		assertEquals("Apple", mockFruits.getNames().get(0));
		assertEquals(1, mockFruits.getNames().size());	
		
		mockList.add(1, "Mango");
		//below will print null because mockList.get(1) is not stubbed
		System.out.println(mockList.get(1));
	}
	
}

class Fruits{
	private List<String> names;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
}
