package com.journaldev.timeout;

import org.testng.annotations.Test;

public class TimeoutExample {

	@Test(timeOut = 300)
	public void foo() throws InterruptedException {
		Thread.sleep(200);
		System.out.println("foo method executed");
	}

	@Test(timeOut = 300)
	public void bar() throws InterruptedException {
		Thread.sleep(400);
		System.out.println("bar method executed");
	}
}
