package com.journaldev.randomnumber;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {

	public static void main(String[] args) {
		Runnable runnable = new MyRunnable();

		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(runnable);
			t.setName("MyRunnable-Thread-" + i);
			t.start();
		}
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + "::" + ThreadLocalRandom.current().nextInt());
	}

}
