@RegressionTest
Feature: Global user signup scenarios 


Scenario Outline: Global user GCM-signup scenario's 
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And Global user signup and login flow for "<Fields>" 
	And Check an itinerary got successfully costed 
	
	Examples: 
		| Destination| region |Fields|
		| UnitedArabEmirates | Europe |NewEmail|
		| UnitedArabEmirates | Europe |NewMailandMobile|