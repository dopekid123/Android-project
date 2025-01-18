@FAS @InclusionsFlow @RegressionTest @Set2 
Feature: Validation of block card for other section 

@Test 
Scenario Outline: Add custom card for other section 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	And fill and post the other block cards form"<title>","<source>","<ourCost>","<publishedCost>","<reason>" 
	Then validate the other block card posted successfully 
	Then delete the other custom card and verify it 
	
	Examples: 
		|region|title|source|ourCost|publishedCost|reason|
		|Australia|Title of the block card|Rental car|4000|5000|Transit Visa|
		
		
Scenario Outline: Check the other custom card can be added more than ten times 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	Then fill and post the other block cards form for ten times "<title>","<source>","<ourCost>","<publishedCost>","<reason>" 
	
	Examples: 
		|region|title|source|ourCost|publishedCost|reason|
		|Australia|Title of the block card|Rental car|4000|5000|Transit Visa|
		
		
	