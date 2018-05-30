package com.journaldev.dataprovider;

import org.testng.annotations.Test;

public class Test4 {
	@Test(dataProvider = "fooDP", dataProviderClass = Test4DataProvider.class)
	public void foo(Integer n) {
		System.out.println("Inside foo, input = " + n);
	}
}
