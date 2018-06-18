package com.journaldev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfiguration {

	@Bean
	public MyDAOBean getMyDAOBean() {
		return new MyDAOBean();
	}

	@Bean(name = { "getMyFileSystemBean", "MyFileSystemBean" }, initMethod = "init", destroyMethod = "destroy")
	public MyFileSystemBean getMyFileSystemBean() {
		return new MyFileSystemBean();
	}

}
