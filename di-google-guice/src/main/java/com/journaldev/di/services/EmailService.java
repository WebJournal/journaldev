package com.journaldev.di.services;

import javax.inject.Singleton;

//import com.google.inject.Singleton;

@Singleton
public class EmailService implements MessageService {

	public boolean sendMessage(String msg, String receipient) {
		//some fancy code to send email
		System.out.println("Email Message sent to "+receipient+" with message="+msg);
		return true;
	}

}
