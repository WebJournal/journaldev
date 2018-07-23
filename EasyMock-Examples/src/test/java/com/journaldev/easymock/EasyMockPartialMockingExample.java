package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.easymock.MockType;
import org.junit.jupiter.api.Test;

import com.journaldev.utils.StringUtils;

public class EasyMockPartialMockingExample {

	@Test
	public void test() {
		StringUtils mock = partialMockBuilder(StringUtils.class).addMockedMethod("toUpperCase").createMock();
		
		expect(mock.toUpperCase("java")).andReturn("JAVA");
		replay(mock);
		
		assertEquals(mock.toUpperCase("java"), "JAVA");
		
		//real method will be called, check the console
		mock.print("java");
	}
}