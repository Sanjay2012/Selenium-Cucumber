package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = ".//Features", 
				glue = "stepDefinitions", 
				dryRun = false, 
				monochrome = true, 
				plugin = {
						"pretty", "summary", "html:target/cucumber-reports/cucumber-pretty",
						"json:target/cucumber-reports/CucumberTestReport.json" }
				//tags="@Category"

)
public class TestRunner {

}
