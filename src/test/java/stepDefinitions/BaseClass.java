package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPo ;
	public AddNewCustomerPage addCustPo;
	
	// generating random string
	public static String randomstring() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}

}
