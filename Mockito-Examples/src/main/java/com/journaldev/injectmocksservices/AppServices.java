package com.journaldev.injectmocksservices;

//For Constructor Based @InjectMocks injection
public class AppServices {

	private EmailService emailService;
	private SMSService smsService;

	public AppServices(EmailService emailService, SMSService smsService) {
		this.emailService = emailService;
		this.smsService = smsService;
	}

	public boolean sendSMS(String msg) {
		return smsService.send(msg);
	}

	public boolean sendEmail(String msg) {
		return emailService.send(msg);
	}
}
