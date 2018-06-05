package com.journaldev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.journaldev.spring");
		context.refresh();

		//MathService ms = context.getBean(MathService.class);
		MathService ms = (MathService) context.getBean("ms");

		int add = ms.add(1, 2);
		System.out.println("Addition of 1 and 2 = " + add);

		int subtract = ms.subtract(2, 1);
		System.out.println("Subtraction of 2 and 1 = " + subtract);
		
		//close the spring context
		context.close();
	}

}
