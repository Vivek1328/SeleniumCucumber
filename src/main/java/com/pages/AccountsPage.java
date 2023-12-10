package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By Accountlist = By.xpath("//div[@id='block-collapsible-nav']/ul/li");

	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTile() {
		return driver.getTitle();
	}
	
	public int getSideMenuCount() {
		System.out.println("Printing the count");
		int size=driver.findElements(Accountlist).size();
		System.out.println(size);
		return size;
	}
	
	public List getSideMenuText() {
		System.out.println("Getting the Account list");
		List<String> values= new ArrayList<>();
		List<WebElement> accountHeaderList=driver.findElements(Accountlist);
		System.out.println("Storing into list");
		for(WebElement e:accountHeaderList) {
			String Text=e.getText();
			if(Text.isEmpty()) {
				continue;
			}
			else {
				System.out.println(Text);
				values.add(Text);
			}
		}
		
		return values;
	}
	
	
}
