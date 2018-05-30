package com.journaldev.main;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class Test5SuiteListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("TestNG suite default output directory = "+suite.getOutputDirectory());
		}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("TestNG invoked methods = " +suite.getAllInvokedMethods());
	}

}
