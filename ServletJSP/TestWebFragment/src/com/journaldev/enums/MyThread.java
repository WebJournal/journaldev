package com.journaldev.enums;

public class MyThread implements Runnable {

	public MyThread() {
	}

	@Override
	public void run() {
		System.out.println("Name="+Thread.currentThread().getName());
	}

}
