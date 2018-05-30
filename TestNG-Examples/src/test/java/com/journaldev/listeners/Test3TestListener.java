package com.journaldev.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Test3TestListener implements ITestListener{

	public Test3TestListener() {
		System.out.println("Test3Listener constructor");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started. "+result.getStartMillis());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success. "+result.getEndMillis());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed. "+result.getTestName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped. "+result.getTestName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Context Name = "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getPassedTests());
	}
}
