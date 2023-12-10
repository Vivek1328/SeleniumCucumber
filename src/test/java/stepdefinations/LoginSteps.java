package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.telestaff.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	//this will return the current driver instance
	private LoginPage login= new LoginPage(DriverFactory.getDriver());
	
	@Given("I enter the telestaff url")
	public void i_enter_the_telestaff_url() {
	    DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/");
	}

	
	
	@Given("I navigate to login page")
	public void i_navigate_to_login_page() {
		String pageTitle=login.getLoginPageTitle();
	    System.out.println(pageTitle);
	}

	@When("I enter email addess {string}")
	public void i_enter_email_addess(String string) {
	    login.enterUserName(string);
	}
	
	

	@When("I enter password {string}")
	public void i_enter_password(String string) {
	    login.enterpwd(string);
	}

	@Then("I verify that forgot password fild exists")
	public void i_verify_that_forgot_password_fild_exists() {
	boolean status=login.isForgotPwdLinkExist();
    Assert.assertTrue(status);
    
	}

	@Then("I verify that user logged in successfully")
	public void i_verify_that_user_logged_in_successfully() {
	    login.clickOnLoginButton();
	}
	
	
}
