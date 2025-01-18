@RegressionTest 
Feature: Validating remove activities feature
  Verify that the remove activity feature is working across the product

  #remove activity - admin only feature 
  @SanityTest
  Scenario Outline: Remove activity feature validation on itinerary page
    Given Login as a authenticated admin user
   And user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully
   And user fills the GCM form for "<departFrom>"
   And Check an itinerary got successfully costed
   Then Check if there is any default activities available on itinerary if not add the activity
   Then Click on remove activity option
   Then validate the activities got removed
  
    
    
    
    Examples: 
      | region    |  departFrom |
      | Europe    |  Chennai     |
      
