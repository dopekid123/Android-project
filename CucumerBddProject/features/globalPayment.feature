@RegressionTest
Feature: Global user payment scenarios 

Scenario Outline: Verify the global user able to make payment
	Given Login as a authenticated user 
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And Global user fills the gcm form "<Nationality>" 
	And Check an itinerary got successfully costed 
	And Global user clicks the book now button
    And user fills in the passenger details 
	And user reviews the cost and clicks make payment 
    And user makes the third payment directly without paying first and second payment
   	And user fills the card details and make payment 
	Then validate that the payment is success 
	Then user should redirect to your vacations page from payment success page
	 
	Examples: 
		| Destination| region |Nationality|
		| UnitedArabEmirates | Australia |Andorra|
