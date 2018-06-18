package com.journaldev.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.journaldev.spring", exclude = {
		org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration.class,
		org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration.class })
public class SpringBootRestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootRestApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		for (String s : beans)
			System.out.println(s);
	}
}
