package com.journaldev.servlet.async;

public class TestNormalServlet {

	public static final String url = "http://localhost:8080/AsyncServletExample/LongRunningServlet?time=8000";

	public static void main(String[] args) {
		ReadURLThread readUrl = new ReadURLThread(url);

		// hit server hard with lot of requests
		for (int i = 0; i < 20; i++) {
			Thread t = new Thread(readUrl);
			t.setName("Thread" + i);
			t.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
