@FAS @CustomerEnagagement @RegressionTest @Set3 
Feature: Verify the Your vacations page scenarios

  @SmokeTest 
  Scenario: User Delete The Saved Itinerary From Your Vacations Page
    Given Login as a authenticated user without redirect to homepage
    When validate the user land on your vacations page
    And user opens saved itinerary
    And user rename the itinerary
    And user delete the itinerary
    Then validate the itinerary got deleted successfully


  Scenario: Verify The Booked Itinerary From Your Vacations Page
    Given Login as a authenticated user without redirect to homepage
    When validate the user land on your vacations page
    And user opens the booked itinerary in your vacations page
    Then validate the itinerary shouldn't customizable

   
  Scenario: User Selects The Saved itinerary And Updating The Cost Of The Itinerary
    Given Login as a authenticated user without redirect to homepage
    When validate the user land on your vacations page
    And user opens saved itinerary
    And select the itinerary from saved itinerary page
    Then do update cost if the itinerary is stale costed
    
    
#Have changed the first payment step to third payment[i.e., 100 percent payment]

  Scenario Outline: Verify After First Payment User Should Redirect to Your Vacations Page
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And user checks all the alerts and clicks continue to book
    And get the itinerary id
    And user fills in the passenger details 
	  And user reviews the cost and clicks make payment 
	  And user makes the third payment directly without paying first and second payment
   	And user fills the card details and make payment 
	  Then validate that the payment is success 
	  Then user should redirect to your vacations page from payment success page 
	    
	    Examples: 
      | region    |
      | Australia |


#Commenting by Nirmal on 28/07/2021 because the product has been customized to have only one payment. So commenting the first and second payment

#  Scenario: Verify User Can Able To Make Second Payment From Your Vacations Page
#    Given Login as a authenticated user without redirect to homepage
#    When validate the user land on your vacations page
#    And user navigates the booked itinerary in your vacations page
#    And user navigates to payment tab
#    And user makes second payment from your vacations
#    And user fills the card details and make payment
#    Then validate that the payment is success
#    Then user should redirect to your vacations page from payment success page
#
#
#  Scenario: Verify User Can Able To Make Third Payment From Your Vacations Page
#    Given Login as a authenticated user without redirect to homepage
#    When validate the user land on your vacations page
#    And user navigates the booked itinerary in your vacations page
#    And user navigates to payment tab
#    And user makes third payment from your vacations page
#    And user fills the card details and make payment
#    Then validate that the payment is success
#    Then user should redirect to your vacations page from payment success page
