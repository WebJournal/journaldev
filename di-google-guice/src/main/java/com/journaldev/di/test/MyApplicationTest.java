package com.journaldev.di.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.journaldev.di.consumer.MyApplication;
import com.journaldev.di.services.MessageService;
import com.journaldev.di.services.MockMessageService;

public class MyApplicationTest {

	private Injector injector;
	
	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new AbstractModule() {
			
			@Override
			protected void configure() {
				bind(MessageService.class).to(MockMessageService.class);
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		injector = null;
	}

	@Test
	public void test() {
		MyApplication appTest = injector.getInstance(MyApplication.class);
		Assert.assertEquals(true, appTest.sendMessage("Hi Pankaj", "pankaj@abc.com"));;
	}

}
