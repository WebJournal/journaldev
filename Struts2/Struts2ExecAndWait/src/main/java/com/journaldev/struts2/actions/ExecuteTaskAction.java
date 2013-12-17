package com.journaldev.struts2.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class ExecuteTaskAction extends ActionSupport {

	@Override
	public String execute() {
		//process task for given time
		System.out.println("Starting execution. Current time: "+new Date());
		processTask();
		System.out.println("Ending execution. Current time: "+new Date());
		return SUCCESS;
	}

	private void processTask() {
		System.out.println("Time to process:"+processingTime);
		try {
			Thread.sleep(getProcessingTime()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int processingTime;

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	
}
