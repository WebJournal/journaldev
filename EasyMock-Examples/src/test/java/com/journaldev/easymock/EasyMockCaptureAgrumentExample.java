package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.easymock.Capture;
import org.easymock.CaptureType;
import org.junit.jupiter.api.Test;

import com.journaldev.utils.MathUtils;

public class EasyMockCaptureAgrumentExample {

	@Test
	public void test_single_call_arg_capture() {
		ArrayList<String> mockList = mock(ArrayList.class);
		Capture<String> captureSingleArgument = newCapture();
		expect(mockList.add(capture(captureSingleArgument))).andReturn(true);
		replay(mockList);

		assertTrue(mockList.add("Hello Pankaj"));
		
		System.out.println(captureSingleArgument.getValue());
		
		verify(mockList);
	}
	
	@Test
	public void test_multiple_calls_args_catcher() {
		ArrayList<Integer> mockList = mock(ArrayList.class);
		Capture<Integer> captureArguments = newCapture(CaptureType.ALL);
		expect(mockList.add(captureInt(captureArguments))).andReturn(true).times(2);
		replay(mockList);

		assertTrue(mockList.add(10));
		assertTrue(mockList.add(20));
		
		System.out.println(captureArguments.getValues());
		
		verify(mockList);
	}
	
	@Test
	public void test_multiple_args_catcher() {
		MathUtils mock = mock(MathUtils.class);
		Capture<Integer> captureArguments = newCapture(CaptureType.ALL);

		expect(mock.add(captureInt(captureArguments), captureInt(captureArguments))).andReturn(10).times(2);
		replay(mock);

		assertEquals(mock.add(0,10), 10);
		assertEquals(mock.add(1, 9), 10);
		
		System.out.println(captureArguments.getValues());

		verify(mock);
	}
}