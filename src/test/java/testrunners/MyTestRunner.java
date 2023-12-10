package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/feature/AccountPage.feature"},
                 glue= {"stepdefinations","appHooks"},
 plugin= {"pretty","rerun:target/failedrerun.txt"}
)





public class MyTestRunner {
	
	
	//vivlv@yopmail.com

}
