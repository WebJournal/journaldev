package com.journaldev.servlet.async;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadURLThread implements Runnable {

	private String url;

	public ReadURLThread(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		try {
			URL test = new URL(this.url);
			URLConnection uc = test.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream()));
			String inputLine;
			StringBuilder sb = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}
			in.close();
			System.out.println(Thread.currentThread().getName()
					+ "Response Data:" + sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
