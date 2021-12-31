package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	
	// Initialize driver

			public LoginPage(WebDriver rdriver) {
				ldriver=rdriver;
				PageFactory.initElements(ldriver, this);
			}
	
	
	// Admin Login Elements
	
	@FindBy(id="Email") public WebElement txtEmail;
	@FindBy(id="Password") public WebElement txtPassword;
	@FindBy(xpath="//*[@type=\"submit\"]") public WebElement loginBtn;
	@FindBy(xpath="//a[@href='/logout']") public WebElement logoutlnk;
	
	
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
