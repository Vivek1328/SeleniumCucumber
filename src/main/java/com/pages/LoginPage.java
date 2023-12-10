package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	private WebDriver driver;
	
	private By emailId= By.id("email");
	private By password= By.id("pass");
	private By signInbButton= By.id("send2");
	private By forgotPasswordLink = By.linkText("Forgot Your Password?");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isForgotPwdLinkExist() {
	return	driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterpwd(String Password) {
		driver.findElement(password).sendKeys(Password);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(signInbButton).click();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
    public AccountsPage getLogin(String username, String passw) {
    	System.out.println("Signing into the application");
    	driver.findElement(emailId).sendKeys(username);
    	driver.findElement(password).sendKeys(passw);
    	driver.findElement(signInbButton).click();
    	// If method is landing to the next page then its method responsibility to give the object of landing page 
    	// Thats why Account page obj got return 
    	return new AccountsPage(driver);
    }
}
