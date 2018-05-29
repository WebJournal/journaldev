package com.journaldev.utils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtils {
	@Test(dataProvider = "dp", priority=1)
	public void test_add(Integer x, Integer y) {
		Utils u = new Utils();
		Assert.assertEquals(u.add(x, y), x + y);
	}

	@Test(dataProvider = "dp", priority=2)
	public void test_subtract(Integer x, Integer y) {
		Utils u = new Utils();
		Assert.assertEquals(u.subtract(x, y), x - y);
	}

	@Test(dataProvider = "dpName", priority=3)
	public void test_setName(String s) {
		Utils.setName(s);
		Assert.assertEquals(Utils.NAME, s);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, 1 }, new Object[] { 2, 2 }, };
	}

	@DataProvider
	public Object[][] dpName() {
		return new Object[][] { new Object[] { "Utils" }, new Object[] { "MyUtils" }, };
	}

}
