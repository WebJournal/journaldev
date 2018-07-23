package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.testng.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.journaldev.utils.Calculator;
import com.journaldev.utils.MathUtils;

public class EasyMockAnnotationTestNGExample {

	@Mock
	private Calculator mockCalculator;

	@TestSubject
	private MathUtils mathUtils = new MathUtils(mockCalculator);

	@BeforeMethod
	public void setup() {
		EasyMockSupport.injectMocks(this);
	}

	@Test
	public void test() {
		expect(mockCalculator.add(1, 1)).andReturn(2);
		expect(mockCalculator.multiply(10, 10)).andReturn(100);
		replay(mockCalculator);

		assertEquals(mathUtils.add(1, 1), 2);
		assertEquals(mathUtils.multiply(10, 10), 100);
	}
}
