package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustemerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPo ;
	public AddNewCustomerPage addCustPo;
	public SearchCustemerPage searchCustPo;
	
	// generating random string
	public static String randomstring() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}

}
