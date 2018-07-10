package com.journaldev.injectmocksservices;

//For Property Setter Based @InjectMocks injection
public class AppServices1 {

	private EmailService emailService;
	private SMSService smsService;

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void setSmsService(SMSService smsService) {
		this.smsService = smsService;
	}

	public boolean sendSMS(String msg) {
		return smsService.send(msg);
	}

	public boolean sendEmail(String msg) {
		return emailService.send(msg);
	}

}
