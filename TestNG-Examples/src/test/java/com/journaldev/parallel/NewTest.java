package com.journaldev.parallel;

import java.time.LocalDateTime;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	@Test(dataProvider = "dp")
	public void foo(Integer n) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Foo Executing Input = " + n);
	}
	
	@Test(dataProvider = "dp")
	public void bar(Integer n) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Bar Executing Input = " + n);
	}

	@DataProvider
	public Object[] dp() {
		Object[] ints = new Object[100];
		for (int i = 0; i < 100; i++)
			ints[i] = i;
		return ints;
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test Time = " + LocalDateTime.now());
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Time = " + LocalDateTime.now());
	}

}
