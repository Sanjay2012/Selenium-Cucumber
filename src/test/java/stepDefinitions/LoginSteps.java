package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;

public class LoginSteps extends BaseClass{


	@Given("^User launch chrome browser$")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPo = new LoginPage(driver);
		
		
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
		loginPo.enterUsername(uname);
		loginPo.enterPassword(pass);
	}

	@When("^click on login btn$")
	public void click_on_login_button() throws InterruptedException {
		loginPo.clickLogin();
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
		loginPo.clickLogout();
		Thread.sleep(3000);
	}

	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}
	
	
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addCustPo=new AddNewCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCustPo.getPageTitle());
		
		Thread.sleep(3000);
		
		String dashbordTitle=driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		Assert.assertEquals("Dashboard", dashbordTitle);
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(5000);
		addCustPo.clickCustomerMenu();

	}

	@When("click on customers menuItem")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCustPo.clickCustomerLink();

	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCustPo.clickOnAddButton();
		Thread.sleep(3000);
	    
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCustPo.getPageTitle());
		
		String actual=driver.findElement(By.xpath("//h1[@class='float-left']")).getText();
		String expected="Add a new customer back to customer list";
		Assert.assertEquals(expected, actual);

	}

	
	@When("user enter customer info")
	public void user_enter_customer_info() {
		String email=randomstring()+"@gmail.com";
		addCustPo.setEmail(email);
		addCustPo.setPassword("Shiv@123");
		addCustPo.setFirstName("Shiv");
		addCustPo.setLastName("Kumar");
		addCustPo.setGender("Male");
		addCustPo.setDOB("1/30/1990");    // M/DD/YYYY
		addCustPo.setCompany("Made Easy CTC");
		//addCustPo.setCustomerRole("Registered");
		addCustPo.setManagerOfVender("Vendor 1");
		addCustPo.setAdminComment("This is for testing");
	}
	

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCustPo.clickOnSaveButton();
		Thread.sleep(3000);
	
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String ConfirmMessage) {
		
//		String actual=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
//		String expected="The new customer has been added successfully.";
//		Assert.assertEquals(expected, actual);
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));

	}

}