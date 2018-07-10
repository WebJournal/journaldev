package com.journaldev.mockito.injectmocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.journaldev.injectmocksservices.AppServices;
import com.journaldev.injectmocksservices.AppServices1;
import com.journaldev.injectmocksservices.AppServices2;
import com.journaldev.injectmocksservices.EmailService;
import com.journaldev.injectmocksservices.SMSService;

class MockitoInjectMocksExamples extends BaseTestCase {

	@Mock EmailService emailService;
	
	@Mock SMSService smsService;
	
	@InjectMocks AppServices appServicesConstructorInjectionMock;
	
	@InjectMocks AppServices1 appServicesSetterInjectionMock;
	
	@InjectMocks AppServices2 appServicesFieldInjectionMock;
	
	@Test
	void test_constructor_injection_mock() {
		when(appServicesConstructorInjectionMock.sendEmail("Email")).thenReturn(true);
		when(appServicesConstructorInjectionMock.sendSMS(anyString())).thenReturn(true);
		
		assertTrue(appServicesConstructorInjectionMock.sendEmail("Email"));
		assertFalse(appServicesConstructorInjectionMock.sendEmail("Unstubbed Email"));
		
		assertTrue(appServicesConstructorInjectionMock.sendSMS("SMS"));
		
	}
	
	@Test
	void test_setter_injection_mock() {
		when(appServicesSetterInjectionMock.sendEmail("New Email")).thenReturn(true);
		when(appServicesSetterInjectionMock.sendSMS(anyString())).thenReturn(true);
		
		assertTrue(appServicesSetterInjectionMock.sendEmail("New Email"));
		assertFalse(appServicesSetterInjectionMock.sendEmail("Unstubbed Email"));
		
		assertTrue(appServicesSetterInjectionMock.sendSMS("SMS"));
		
	}

	@Test
	void test_field_injection_mock() {
		when(appServicesFieldInjectionMock.sendEmail(anyString())).thenReturn(true);
		when(appServicesFieldInjectionMock.sendSMS(anyString())).thenReturn(true);
		
		assertTrue(appServicesFieldInjectionMock.sendEmail("Email"));
		assertTrue(appServicesFieldInjectionMock.sendEmail("New Email"));
		
		assertTrue(appServicesFieldInjectionMock.sendSMS("SMS"));
		
	}
}
