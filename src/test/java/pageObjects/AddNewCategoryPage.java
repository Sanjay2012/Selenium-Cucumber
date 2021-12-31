package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitHelper;

public class AddNewCategoryPage{
	
	public WebDriver ldriver;
	WaitHelper waitHelper;
	JavascriptExecutor executor = (JavascriptExecutor) ldriver;

	// Initialize driver

	public AddNewCategoryPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper=new WaitHelper(ldriver);
	}
	
	// WebElements
	
	By catlogMenu=By.xpath("//p[normalize-space()='Catalog']");
	By categoriesItem=By.xpath("//p[normalize-space()='Categories']");
	By categotyPageTitle=By.xpath("//h1[normalize-space()='Categories']");
	By addBtn=By.xpath("//a[@class='btn btn-primary']");
	
	
	By companyNameTxt=By.xpath("//input[@id='SearchCategoryName']");
	By searchBtn=By.xpath("//button[@id='search-categories']");
	By table=By.xpath("//*[@id=\"categories-grid\"]");
	By tableCol=By.xpath("//*[@id=\"categories-grid\"]/tbody/tr");
	By tableRows=By.xpath("//*[@id=\"categories-grid\"]/tbody/tr/td");
	
	By catName=By.xpath("//input[@id='Name']");
	By description=By.xpath("//body//p");
	By parentCategory=By.xpath("//select[@class='form-control valid']");
	By saveBtn=By.xpath("//button[@name='save']");

	public void clickCatlogMenu() throws InterruptedException {
		ldriver.findElement(catlogMenu).click();
		Thread.sleep(3000);
		
	}

	public void clickOnCategoryMenuItm() throws InterruptedException {
		ldriver.findElement(categoriesItem).click();
		Thread.sleep(3000);
		
	}
	
	public void clickOnAddNewButton() throws InterruptedException {
		ldriver.findElement(addBtn).click();
		Thread.sleep(3000);

	}


	public void setcategoryName(String productCategory) throws InterruptedException {
		ldriver.findElement(catName).sendKeys(productCategory);
		Thread.sleep(2000);
		
		
	}

	public void addCatDescription(String desc) {
		WebDriverWait t = new WebDriverWait(ldriver, 10); 
		t.until(ExpectedConditions.visibilityOf(ldriver.findElement(description)));
		ldriver.findElement(description).sendKeys(desc);
		
//		ldriver.findElement(description);
//		executor.executeScript("arguments[0].value='desc';", description);
//		
	}

	public void setParentCategory(String txt) {
//		WebDriverWait wait = new WebDriverWait(ldriver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(parentCategory));
		Select parentCat=new Select(ldriver.findElement(parentCategory));
		parentCat.selectByVisibleText(txt);
	}

	public void clickOnSaveBtn() {
		ldriver.findElement(saveBtn).click();
		
	}


	

	
	
	

}
