@FAS @RegressionTest @CostingFlow @SanityTest 
Feature: Verify the costing flow across the product 


Scenario Outline: Validate the costing flow time period for long haul and short haul by selecting cities 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And user validates the costing time period for "<region>" 
	
	Examples: 
		|region      |
		|Thailand     |
		|Bali         | 
		|Europe      |
		|Australia   |
		|New Zealand |
		
		
		#Added the testcase for costing an single destinations
		
		
Scenario Outline: Validate the costing flow time for short haul destination by without selecting cities
	And user validates the short hand destinatiom costing flow for "<region>" 
	Then validate that the itinerary is created succesfully for single destination 
	And user login with "<uName>" and "<passwd>" for single destination 
	And user validates the costing time period for "<region>" 
	
	Examples: 
		| region   | uName      | passwd      |
		| Singapore | 9344700243 | travelisfun |
		| Switzerland | 9344700243 | travelisfun |
		
		

  
  