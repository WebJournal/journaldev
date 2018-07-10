package com.journaldev.injectmocksservices;

public class EmailService implements Service {

	@Override
	public boolean send(String msg) {
		System.out.println("Sending email");
		return true;
	}

}
