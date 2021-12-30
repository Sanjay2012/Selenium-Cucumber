# Author: sanjaywaware04@gmail.com
Feature: Search newly added customer 


Background: Admin user login 
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


@SmokeTest 
Scenario: As a admin i can search custermer by EmailId using search button
	And enter customer email 
	And click on search button 
	Then user found email in search table 
	And close the browser 
	
	
@SmokeTest
Scenario: As a admin i can search custermer by Name with search button 
	And enter customers First and Last Name 
	And click on search button 
	Then user found customers Name in table 
	And close the browser 
	