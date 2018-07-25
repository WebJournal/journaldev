package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.journaldev.utils.StringUtils;

public class EasyMockPartialMockingExample {

	@Test
	public void test() {
		StringUtils mock = partialMockBuilder(StringUtils.class)
					.addMockedMethod("toUpperCase").createMock();
		
		expect(mock.toUpperCase("java")).andReturn("JAVA");
		replay(mock);
				
		//real method will be called, check the console
		mock.print("java");
		
		//testing mocked method
		assertEquals("JAVA", mock.toUpperCase("java"));
		verify(mock);
	}
}