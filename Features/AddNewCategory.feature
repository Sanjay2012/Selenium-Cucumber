# Author: sanjaywaware04@gmail.com
Feature: Add new Category

@Category
Scenario: As a admin i can add new product category from dashboard 

	Given User launch chrome browser 
	When User open the url "https://admin-demo.nopcommerce.com/login" 
	And user enter email as "admin@yourstore.com" and Password as "admin" 
	And click on login btn 
	Then user can view Dashboard 
	When user click on catlog menu 
	And click on catagories menuItem
	Then user should land on Categories page 
	And click on Add new button on Categories page
	Then user can view add new category page 
	When user enter category information 
	And click on save button present on Add Category Page 
	Then user can view "The new category has been added successfully." message on page
	And close the browser