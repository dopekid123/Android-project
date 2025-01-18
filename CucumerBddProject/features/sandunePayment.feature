@FAS @Sandune @RegressionTest @Set3 @Test
Feature: Verify the Payment scenarios under sandune flow

Scenario Outline: Verify if user able to do third payment 100% directly
	Given Login as a authenticated user
  And User selects the region "<region>" from destination options
  And User chooses the month "<dubai_month>" for the trip
  And User selects the departing city "<dep_city>" from the dropdown
  And User selects the departure date "<dep_date>"
  And User selects the no.of.nights "<no_of_nights>" stay options
  And User selects the passenger details "<pax_details>" for the trip
  And User selects the activities from the activities list
  Then User validates the itinerary is created successfully
  Then User navigates from itinerary to inclusion page
  And user checks all the alerts and clicks continue to book 
	And get the itinerary id
	And user fills in the passenger details 
	And user reviews the cost and clicks make payment 
	And user makes the third payment directly without paying first and second payment
	And user fills the card details and make payment 
	Then validate that the payment is success 
	Then user should redirect to your vacations page from payment success page 
	
	Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | OCT        | Chennai  |       24 | 5 - 8 nights | Partner     |


#Commenting All the payment related scenarios since In product we have only one payment method
#Added the separate testcase for that above will remove that testcase once all the payments are enabled 
#in product

#3 Testcases
#Scenario Outline: Verify After First Payment User Should Redirect to Your Vacations Page in sandune
#	Given Login as a authenticated user
  #And User selects the region "<region>" from destination options
  #And User chooses the month "<dubai_month>" for the trip
  #And User selects the departing city "<dep_city>" from the dropdown
  #And User selects the departure date "<dep_date>"
  #And User selects the no.of.nights "<no_of_nights>" stay options
  #And User selects the passenger details "<pax_details>" for the trip
  #And User selects the activities from the activities list
  #Then User validates the itinerary is created successfully
  #Then User navigates from itinerary to inclusion page
  #And user checks all the alerts and clicks continue to book 
#	And get the itinerary id
#	And user fills in the passenger details 
#	And user reviews the cost and clicks make payment 
#And user makes the first payment 
#	And user fills the card details and make payment 
#	Then validate that the payment is success 
#	Then user should redirect to your vacations page from payment success page 
#	
#	Examples: 
      #| region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      #| dubai  | JUN        | Chennai  |       24 | 5 - 8 nights | Partner     |

#Same 2 scenarios are covered in yourvactions feature, so commenting below 2 scenarios
		
#	Scenario: Verify User Can Able To Make Second Payment From Your Vacations Page 
#	Given Login as a authenticated user without redirect to homepage 
#	When  validate the user land on your vacations page 
#	And   user navigates the booked itinerary in your vacations page
#	And   user navigates to payment tab 
#	And   user makes second payment from your vacations 
#	And   user fills the card details and make payment 
#	Then validate that the payment is success 
#	Then user should redirect to your vacations page from payment success page 
#		
#
  #Scenario: Verify User Can Able To Make Third Payment From Your Vacations Page 
#	Given Login as a authenticated user without redirect to homepage 
#	When  validate the user land on your vacations page 
#	And   user navigates the booked itinerary in your vacations page
#	And   user navigates to payment tab 
#	And   user makes third payment from your vacations page 
#	And   user fills the card details and make payment 
#	Then  validate that the payment is success 
#	Then  user should redirect to your vacations page from payment success page
#	
#	 