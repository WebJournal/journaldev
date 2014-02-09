package com.journaldev.mail;

import java.util.Properties;

import javax.mail.Session;

public class SimpleEmail {
	
	public static void main(String[] args) {
		
		System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "relay.apple.com";
	    String emailID = "pkumar2@apple.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}
