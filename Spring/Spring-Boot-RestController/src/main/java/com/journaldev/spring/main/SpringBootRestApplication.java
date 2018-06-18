package com.journaldev.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.journaldev.spring", exclude = {com.journaldev.spring.controller.EmployeeRestController.class })
public class SpringBootRestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootRestApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		for (String s : beans)
			System.out.println(s);
	}
}
