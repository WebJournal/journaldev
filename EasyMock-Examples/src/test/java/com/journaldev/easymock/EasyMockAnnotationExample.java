package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.journaldev.utils.Calculator;
import com.journaldev.utils.MathUtils;

public class EasyMockAnnotationExample {

	@Mock
	private Calculator mockCalculator;

	@TestSubject
	private MathUtils mathUtils = new MathUtils(mockCalculator);

	@BeforeEach
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
