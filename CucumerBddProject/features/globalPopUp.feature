@RegressionTest @SanityTest
Feature: Verification of global popup scenarios

Scenario Outline: Global user login using home page header 
	And user type the locale manually on the url and validate the popup "<locale>"

	
	Examples:
	|locale|
	|ae|
	|us|
	|india|
	

