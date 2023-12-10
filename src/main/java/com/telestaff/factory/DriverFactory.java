package com.telestaff.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("Value of browser : "+browser);
		if(browser.equals("chrome")) {
			
			tdriver.set(new ChromeDriver());
			
		}
		else if(browser.equals("firefox")) {
			tdriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Browser name provided invalid : "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

}
