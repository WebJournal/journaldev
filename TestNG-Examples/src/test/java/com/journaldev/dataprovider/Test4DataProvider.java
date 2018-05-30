package com.journaldev.dataprovider;

import org.testng.annotations.DataProvider;

public class Test4DataProvider {

	@DataProvider(parallel = true, name = "fooDP", indices = { 1, 3, 5, 7, 9 })
	public static Object[] dp() {
		Object[] ints = new Object[100];
		for (int i = 0; i < 100; i++) {
			ints[i] = 100 + i;
		}
		// indices don't cause exceptions
		// ints[0] = 0;ints[1] = 1;ints[2] = 2;
		return ints;
	}
}
