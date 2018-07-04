package com.journaldev.mockito.testng;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class TestNGMockitoSingleElement {

	@SuppressWarnings("unchecked")
	@Test
	public void mock_concrete_class() {
		ArrayList<String> mockedList = mock(ArrayList.class);

		when(mockedList.get(0)).thenReturn("first-element");

		System.out.println(mockedList.get(0));
		assertEquals("first-element", mockedList.get(0));

		// "null" gets printed as get(1) is not stubbed
		System.out.println(mockedList.get(1));
	}
}
