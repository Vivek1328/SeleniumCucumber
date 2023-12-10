package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.telestaff.factory.DriverFactory;
import com.telestaff.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	
	
	private WebDriver driver;
	private DriverFactory driverfactory;
	private ConfigReader reader;
	Properties prop;
	
	
	
	@Before(order=0)
	public void getProperty() {
		reader= new ConfigReader();
		prop=reader.init_properties();
	}

	@Before(order=1)
	public void lounchBrowser() {
		System.out.println("For Testing");
		String bowserName=prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver=driverfactory.init_driver(bowserName);
		
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String name = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", name);
		}
		
	}
	
}
