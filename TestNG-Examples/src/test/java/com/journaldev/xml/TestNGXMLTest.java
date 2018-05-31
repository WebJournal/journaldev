package com.journaldev.xml;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGXMLTest {
	@Test(dataProvider = "dp", priority=1)
	public void test_add(Integer x, Integer y) {
		Utils u = new Utils();
		Assert.assertEquals(u.add(x, y), x + y);
	}

	@Test(dataProvider = "dpName", priority=3, groups="setName")
	public void test_setName(String s) {
		Utils.setName(s);
		Assert.assertEquals(Utils.NAME, s);
	}
	
	@Test
	@Parameters("name")
	public void test_name(@Optional("NA") String s) {
		System.out.println("Input parameter = "+s);
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
