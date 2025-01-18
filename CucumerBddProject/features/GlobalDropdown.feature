@SanityTest @RegressionTest
Feature: Global Dropdown validation on multiple pages 
	Verify the Global dropdown feature on various pages


Scenario Outline: Verify the global dropdown feature on home page 
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	
	
	Examples: 
		|Destination| 
		|UnitedArabEmirates | 
		|India|
		|UnitedStates|
		
