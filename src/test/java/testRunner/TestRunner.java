package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = ".//Features/searchCustomer.feature", glue = "stepDefinitions", dryRun = false, monochrome = true, plugin = {
		"pretty", "summary", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json" }, tags="@Smoke"

)
public class TestRunner {

}
