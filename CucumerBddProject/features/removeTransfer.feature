@SanityTest @RegressionTest 
Feature: Validating remove transfer feature
  Verify that the remove transfer feature is working across the product

  #remove Transfer - admin only feature 
 
  Scenario Outline: Remove transfer - AH and train feature validation on itinerary page
    Given Login as a authenticated admin user
   And user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully
   And user fills the GCM form for "<departFrom>"
   And Check an itinerary got successfully costed
   And Get the count of transfers in the itinerary before removing the transfers
   And user navigate to itinerary page
   Then Click on remove transfer option
   And user clicks inclusion page
   Then Validate that the all the transfers in the itinerary are removed
   
     
    
     Examples: 
      | region    |  departFrom |
      | Europe    |  Chennai    |
      |New Zealand|  Chennai    |
     
     
Scenario Outline: Remove transfer - ferry feature validation on itinerary page
 Given Login as a authenticated admin user
 And user validates the costing flow for ferry "<region>"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form for "<departFrom>"
 And Check an itinerary got successfully costed
 And Get the count of transfers in the itinerary before removing the transfers
 And user navigate to itinerary page
 Then Click on remove transfer option
 And user clicks inclusion page
 Then Validate that the all the transfers in the itinerary are removed
   
      Examples: 
      | region    |  departFrom |
      |Thailand   |  Chennai    |