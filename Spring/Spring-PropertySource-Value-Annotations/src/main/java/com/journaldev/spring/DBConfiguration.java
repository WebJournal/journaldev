package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration

//@PropertySources({
//@PropertySource("classpath:db.properties"),
//@PropertySource(value = "classpath:root.properties", ignoreResourceNotFound=true)})

//@PropertySource("file:${HOME}/db.properties")

@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:root.properties", ignoreResourceNotFound=true)
public class DBConfiguration {

	@Autowired
    Environment env;
	
	@Value("${APP_NAME_NOT_FOUND:Default}")
	private String defaultAppName;
	
	@Value("${HOME}")
	private String homeDir;
	
	@Bean
    public DBConnection getDBConnection() {
		printValues(null);
		System.out.println("Getting DBConnection Bean for App: "+env.getProperty("APP_NAME"));
		//DBConnection dbConnection = new DBConnection(env.getProperty("DB_DRIVER_CLASS"), env.getProperty("DB_URL"), env.getProperty("DB_USERNAME"), env.getProperty("DB_PASSWORD").toCharArray());
        DBConnection dbConnection = new DBConnection();
		return dbConnection;
    }
	
	public void printValues(@Value("test") String s) {
		System.out.println("Input Argument "+s);
		System.out.println("Home Directory = "+homeDir);
		System.out.println("Default App Name = "+defaultAppName);

	}
}
