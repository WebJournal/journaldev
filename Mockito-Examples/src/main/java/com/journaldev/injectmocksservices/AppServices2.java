package com.journaldev.injectmocksservices;

//For Field Based @InjectMocks injection
public class AppServices2 {

	private EmailService emailService;
	private SMSService smsService;

	public boolean sendSMS(String msg) {
		return smsService.send(msg);
	}

	public boolean sendEmail(String msg) {
		return emailService.send(msg);
	}

}
