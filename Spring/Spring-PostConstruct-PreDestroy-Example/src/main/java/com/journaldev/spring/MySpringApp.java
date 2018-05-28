package com.journaldev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySpringApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyConfiguration.class);
		ctx.refresh();

		MyBean mb1 = ctx.getBean(MyBean.class);
		System.out.println(mb1.hashCode());

		MyBean mb2 = ctx.getBean(MyBean.class);
		System.out.println(mb2.hashCode());

		ctx.close();
	}

}
