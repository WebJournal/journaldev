package com.journaldev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.journaldev.spring");
		context.refresh();
		System.out.println("Spring Context Refreshed");
		// Getting Bean by Class
		MyDAOBean myDAOBean = context.getBean(MyDAOBean.class);
		System.out.println(myDAOBean);

		MyFileSystemBean myFileSystemBean = (MyFileSystemBean) context.getBean("getMyFileSystemBean");
		System.out.println(myFileSystemBean);

		MyFileSystemBean myFileSystemBean1 = (MyFileSystemBean) context.getBean("MyFileSystemBean");
		System.out.println(myFileSystemBean1);

		context.close();
	}

}
