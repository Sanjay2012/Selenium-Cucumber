package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustemerPage {
	
	public WebDriver ldriver;
	WaitHelper waitHelper;
	JavascriptExecutor executor = (JavascriptExecutor) ldriver;

	// Initialize driver

	public SearchCustemerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper=new WaitHelper(ldriver);
	}

	// Add customer Elements
	
	@FindBy(xpath="//input[@id='SearchEmail']") 
	WebElement emailId;
	
	@FindBy(xpath="//button[@id='search-customers']") 
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]")
	WebElement table;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td") 
	List<WebElement> tableColumns;
	
	
	@FindBy(xpath="//*[@id=\"SearchFirstName\"]")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"SearchLastName\"]")
	WebElement lastName;
	
	

	// Actions
	
	public void clickSearch() {
		searchBtn.click();
		waitHelper.WaitForElement(searchBtn, 5);
		
	}
	
	public int getRowCount() {
		return(tableRows.size());
	}
	
	public int getColumnCount() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag=false;
		String emailId=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]")).getText();
		System.out.println(emailId);		
		if (emailId.equals(email)) {			
			flag=true;
		}
		
	return flag;
		
	}

	public void setEmail(String email) {
		emailId.sendKeys(email);
		waitHelper.WaitForElement(emailId, 10);
		
	}
	
	//----- to search email in table without search button

	public boolean searchCustomerByEmailInTable(String email) {
		
		boolean flag=false;
		
		for (int i = 1; i <=getRowCount(); i++) {
			String emailId=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[i]/td[2]")).getText();
			System.out.println(emailId);
			
			if (emailId.equals(email)) {
				flag=true;
			}
		}

		return flag;
		

	}
	
	//----------------

	public void setFullName(String firstName2, String lastName2) {
		firstName.sendKeys(firstName2);
		waitHelper.WaitForElement(firstName, 10);
		lastName.sendKeys(lastName2);
		waitHelper.WaitForElement(lastName, 10);
	}
	
	
	public boolean searchCustomerByName(String fullName) {
		
		boolean flag=false;
		String name=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[3]")).getText();
		System.out.println(name);		
		if (name.equals(fullName)) {			
			flag=true;
		}
		
	return flag;
		
	}



}
