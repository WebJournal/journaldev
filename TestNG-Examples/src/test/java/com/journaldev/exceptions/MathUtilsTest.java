package com.journaldev.exceptions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;

public class MathUtilsTest {
	@Test(dataProvider = "dp", expectedExceptions = {ArithmeticException.class, NullPointerException.class },
			expectedExceptionsMessageRegExp = ".* by zero*.")
	public void f(Integer x, Integer y) {
		MathUtils mu = new MathUtils();
		assertEquals(mu.divide(x, y), x / y);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 4, 0 } };
	}
}
