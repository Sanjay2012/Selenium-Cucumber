#Author: sanjaywaware04@gmail.com
Feature: Admin Login and Add new Customer 

@Test 
Scenario: Login page validation 

	Given User launch chrome browser 
	When User open the url "https://admin-demo.nopcommerce.com/login" 
	Then verify the page should contain text as "Welcome, please sign in!" 
	Then verify the email filed 
	Then verify the password filed 
	Then verify remember me checkbox 
	Then verify the login button status
	When user enter invalid credentials 
	And click on login btn
	Then verify the error messge as "Login was unsuccessful. Please correct the errors and try again." upon entering invalid credentials
	And close the browser 
	
@RegressionTest 
Scenario: As a user i can login successfully with valid credentials 
	Given User launch chrome browser 
	When User open the url "https://admin-demo.nopcommerce.com/login" 
	And user enter email as "admin@yourstore.com" and Password as "admin" 
	And click on login btn 
	Then page title should be "Dashboard / nopCommerce administration" 
	When user click on logout link 
	Then page title should be "Your store. Login" 
	And close the browser 
	
	
@RegressionTest 
Scenario Outline: Login Data driven 
	Given User launch chrome browser 
	When User open the url "https://admin-demo.nopcommerce.com/login" 
	And user enter email as "<username>" and Password as "<password>" 
	And click on login btn 
	Then page title should be "Dashboard / nopCommerce administration" 
	When user click on logout link 
	Then page title should be "Your store. Login" 
	And close the browser 
	
	Examples: 
	
		|username|password|
		|admin@yourstore.com|admin|
		
		
		
	