package com.journaldev.mockito.testng;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.journaldev.AddService;
import com.journaldev.CalcService;

public class TestNGMockAnnotationExample {

	CalcService calcService;

	@Mock
	private AddService addService;

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod TestNGMockAnnotationExample");
		MockitoAnnotations.initMocks(this);
	}

	@Test(dataProvider = "dp")
	public void test_mock_annotation(int i, int j) {
		System.out.println("**--- Test testCalc executed ---**");

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
