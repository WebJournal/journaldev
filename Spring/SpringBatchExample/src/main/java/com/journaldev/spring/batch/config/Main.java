package com.journaldev.spring.batch.config;

import org.springframework.boot.SpringApplication;

public class Main {
	  public static void main(String [] args) {
	    System.exit(SpringApplication.exit(SpringApplication.run(
	        BatchConfiguration.class, args)));
	  }
	}
