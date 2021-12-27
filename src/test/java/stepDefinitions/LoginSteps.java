package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {

	public WebDriver driver;
	public LoginPage lp;

	@Given("^User launch chrome browser$")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		lp = new LoginPage(driver);
	}

	@When("^User open the url \"([^\"]*)\"$")
	public void user_open_the_url(String url) {
		driver.get(url);

	}

	@Then("verify the page should contain text as {string}")
	public void verify_the_page_should_contain_text_as(String exp) {
		String act = driver.findElement(By.xpath("//strong[contains(.,'Welcome, please sign in!')]")).getText();
		Assert.assertEquals(exp, act);
	}

	@Then("verify the email filed")
	public void verify_the_email_filed() {
		boolean Email = driver.findElement(By.xpath("//input[@id='Email']")).isEnabled();
		Assert.assertEquals(Email, true);

	}

	@Then("verify the password filed")
	public void verify_the_password_filed() {

		boolean pwd = driver.findElement(By.xpath("//input[@id='Password']")).isEnabled();
		Assert.assertEquals(pwd, true);
	}

	@Then("verify remember me checkbox")
	public void verify_remember_me_checkbox() {
		boolean checkbox = driver.findElement(By.xpath("//input[@id='RememberMe']")).isEnabled();
		Assert.assertEquals(checkbox, true);
	}

	@Then("verify the login button status")
	public void verify_the_login_button_status() {
		boolean checkbox = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		Assert.assertEquals(checkbox, true);
	}

	/*@Then("verify the error messge upon entering invalid credentials")
	public void verify_the_error_messge_upon_entering_invalid_credentials() {
		String expected = "Login was unsuccessful. Please correct the errors and try again.";
		String errormsg = driver
				.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
		Assert.assertEquals(expected, errormsg);
	}*/

	@When("^user enter email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enter_email_as_and_Password_as(String uname, String pass) {
		lp.enterUsername(uname);
		lp.enterPassword(pass);
	}

	@When("^click on login btn$")
	public void click_on_login_button() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());

		}
	}

	@When("^user click on logout link$")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
		;
	}

}