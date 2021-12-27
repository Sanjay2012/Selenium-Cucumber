package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	// Initialize driver

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Elements
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;

	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	@CacheLookup
	WebElement loginBtn;
	
	
	@FindBy(xpath="//a[@href='/logout']")
	@CacheLookup
	WebElement logoutlnk;
	
	
	// Actions
	
	public void enterUsername(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	
	public void enterPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginBtn.click();
		
	}
	
	public void clickLogout() {
		logoutlnk.click();
		
	}
	
}
