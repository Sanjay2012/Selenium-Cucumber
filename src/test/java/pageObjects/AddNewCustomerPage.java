package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	public WebDriver ldriver;
	JavascriptExecutor executor = (JavascriptExecutor) ldriver;

	// Initialize driver

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Add customer Elements

	By customerMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customerMenuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By addButton = By.xpath("//a[@class='btn btn-primary']");
	By emailid = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@name='Password']");
	By firstName = By.xpath("//input[@name='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	By male = By.xpath("//input[@id='Gender_Male']");
	By female=By.xpath("//input[@id='Gender_Female']");
	By date=By.xpath("//input[@id='DateOfBirth']");
	
	By companyName = By.xpath("//input[@id='Company']");
	By taxExemptedCheck = By.xpath("//input[@id='IsTaxExempt']");
	
	By customerRole = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
	By lstItemAdmin=By.xpath("//li[contains(text(),'Administrators')]");
	By lstItemForumMod=By.xpath("//li[contains(.,'Forum Moderators')]");
	By lstItemGuest=By.xpath("//li[contains(text(),'Guests')]");
	By lstItemVendor=By.xpath("//li[contains(text(),'Vendors')]");
	By lstItemRegister=By.xpath("//li[contains(text(),'Registered')]");
	
	By drpmngVenderRole=By.xpath("//select[@id='VendorId']");
	By noVenderRoleItem=By.xpath("//option[@value='0']");
	By vender1Item=By.xpath("//option[@value='1']");
	By venser2Item=By.xpath("//option[@value='2']");
	
	By adminComment = By.xpath("//textarea[@id='AdminComment']");
	By saveButton = By.xpath("//button[@name='save']");

	// Actions
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	

	public void clickCustomerMenu() throws InterruptedException {
				Thread.sleep(3000);	
				ldriver.findElement(customerMenu).click();
				
				
//		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
//		executor.executeScript("arguments[0].click();", customerMenu);

	}

	public void clickCustomerLink() throws InterruptedException {
		ldriver.findElement(customerMenuItem).click();
		Thread.sleep(3000);

	}

	public void clickOnAddButton() throws InterruptedException {
		ldriver.findElement(addButton).click();
		Thread.sleep(3000);

	}

	/*
	 * public void customerInfo() {
		ldriver.findElement(emailid).sendKeys("Sanjay2020@0n.in");
		ldriver.findElement(firstName).sendKeys("Shivansh");
		ldriver.findElement(lastName).sendKeys("Kapoor");
		ldriver.findElement(malecheck).click();
		ldriver.findElement(companyName).sendKeys("MadeEasy CTC");
		ldriver.findElement(taxExemptedCheck).click();
		ldriver.findElement(newsDropdown).click();
		ldriver.findElement(listValue1).click();
		ldriver.findElement(adminComment).sendKeys("Register new Customer");

	}
	*/

	public void setEmail(String email) {
		ldriver.findElement(emailid).sendKeys(email);
		
	}

	public void setPassword(String pass) {
		ldriver.findElement(password).sendKeys(pass);
		
	}

	public void setFirstName(String name) {
		ldriver.findElement(firstName).sendKeys(name);
		
	}

	public void setLastName(String lName) {
		ldriver.findElement(lastName).sendKeys(lName);
		
	}
	
	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(male).click();
			
		}
		else if (gender.equals("Female")) {
			ldriver.findElement(female).click();
			
		}
		else {
			ldriver.findElement(male).click();
		}
		
	}

	public void setDOB(String DOB) {
		ldriver.findElement(date).sendKeys(DOB);

		
	}
	
	public void setCompany(String company) {
		ldriver.findElement(companyName).sendKeys(company);

	}
	
	public void taxExemptionStatus(){
		ldriver.findElement(taxExemptedCheck).click();
		
	}
	
	
	public void setCustomerRole(String role) {
		
		ldriver.findElement(customerRole).click();
		WebElement lstItem = null;
		
		if (role.equals("Administrators")) {
			ldriver.findElement(lstItemAdmin);
		}
		else if (role.equals("Guests")) {
			ldriver.findElement(lstItemGuest);
			
		}
		else if (role.equals("Registered")) {
			ldriver.findElement(lstItemRegister);
			
		}
		else if (role.equals("Vnders")) {
			ldriver.findElement(lstItemVendor);
			
		}
		else {
			ldriver.findElement(lstItemGuest);
		}
		
		//lstItem.click();
		
		executor.executeScript("arguments[0].click();", lstItem);

	}
	
	public void setManagerOfVender(String value) {
		Select drp=new Select(ldriver.findElement(drpmngVenderRole));
		drp.selectByVisibleText(value);
	}
	
	
	public void setAdminComment(String comment) {
		ldriver.findElement(adminComment).sendKeys(comment);

	}
	public void clickOnSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(saveButton).click();
		
		//executor.executeScript("arguments[0].click();", saveButton);
		
	}

	

	
	
	

	


	



}
