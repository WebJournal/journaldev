package com.journaldev.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				MyConfiguration.class);
		MyService service = ctx.getBean(MyService.class);
		
		service.log("Hi");
		
		MyService newService = ctx.getBean(MyService.class);
		System.out.println("service hashcode="+service.hashCode());
		System.out.println("newService hashcode="+newService.hashCode());
		ctx.close();
	}

}
