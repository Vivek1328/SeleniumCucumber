package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.telestaff.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {
 
	
	
	private LoginPage page= new LoginPage(DriverFactory.getDriver());
	private AccountsPage accSteps;
	private String title;
	@Given("User has logged in to application")
	public void user_has_logged_in_to_application(DataTable dataTable) {
		List<Map<String,String>>data=dataTable.asMaps(String.class, String.class);
		String username=data.get(0).get("username");
		String password=data.get(0).get("password");
		
		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/");
		accSteps=page.getLogin(username, password);
	    	}

	@Given("I am on Account page")
	public void i_am_on_account_page() {
	    System.out.println("I am on Account page");
	}

	@When("I gets the title of the webpage")
	public void i_gets_the_title_of_the_webpage() {
		title=accSteps.getTile();
	}

	@Then("I print the webpage title")
	public void i_print_the_webpage_title() {
	    System.out.println(title);
	}

	@Then("User gets on Login page")
	public void user_gets_on_login_page(DataTable dataTable) {
	    List<String>expectedlist=dataTable.asList();
	    System.out.println(expectedlist);
	    
	    List<String>Actual=accSteps.getSideMenuText();
	    System.out.println(Actual);
	   // Assert.assertTrue(expectedlist.containsAll(Actual));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {
		Assert.assertTrue(accSteps.getSideMenuCount()==int1);
	}


}
