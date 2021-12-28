# Author: sanjaywaware04@gmail.com
Feature: Add new Customer

@RegressionTest
Scenario: As a admin i can add new customer from dashboard 

	Given User launch chrome browser 
	When User open the url "https://admin-demo.nopcommerce.com/login" 
	And user enter email as "admin@yourstore.com" and Password as "admin" 
	And click on login btn 
	Then user can view Dashboard 
	When user click on customers menu 
	And click on customers menuItem 
	And click on Add new button 
	Then user can view add new customer page 
	When user enter customer info 
	And click on save button 
	Then user can view confirmation message "The new customer has been added successfully." 
	And close the browser
	