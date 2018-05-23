package com.journaldev.spring;

import org.springframework.context.annotation.Scope;
import java.time.LocalDateTime;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DataSessionScope {

	private String name = "Session Scope";
	
	public DataSessionScope() {
		System.out.println("DataSessionScope Constructor Called at "+LocalDateTime.now());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
