package com.journaldev.selenium.firefox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoDriverExample {

	public static void main(String[] args) {
		//specify the location of GeckoDriver for Firefox browser automation
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://journaldev.com");
		String PageTitle = driver.getTitle();
		System.out.println("Page Title is:" + PageTitle);
		driver.close();
	}
}
