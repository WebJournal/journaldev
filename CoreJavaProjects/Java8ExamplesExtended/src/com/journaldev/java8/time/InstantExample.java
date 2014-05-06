package com.journaldev.java8.time;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

	public static void main(String[] args) {
		//Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = "+timestamp);
		
		//Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = "+specificTime);
		
		//Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);
	}

}
