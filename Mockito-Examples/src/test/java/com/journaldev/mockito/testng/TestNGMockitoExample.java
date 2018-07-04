package com.journaldev.mockito.testng;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.journaldev.AddService;
import com.journaldev.CalcService;

public class TestNGMockitoExample {

	@Test(dataProvider = "dp")
	public void test_mock_object(int i, int j) {
		System.out.println("**--- Test testCalc executed ---**");

		AddService addService;
		CalcService calcService;

		addService = Mockito.mock(AddService.class);
		calcService = new CalcService(addService);

		int expected = i + j;
		when(addService.add(i, j)).thenReturn(expected);

		int actual = calcService.calc(i, j);

		assertEquals(expected, actual);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, 1 }, new Object[] { 2, 2 }, };
	}
}
