@Pricing @DiscountPricing @Set1  @RegressionTest
Feature: Applying admin price for each line item

 
 @SanityTest
  Scenario Outline: Verify if admin able to apply buffer and discount on overall deal size
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
     And Hover over the tooltip and fetch the Tripcost, TCS and GST price of the itinerary
    And validate that the edit icon is showing for applying overall discount price
    And Fill the buffer form to add the buffer amount by entering new deal size
    And validate the new deal size have been reflected after applying the discount or buffer
    Then Navigate back to inclusion page
    And Validate that the applied discount or buffer has been applied on top of trip cost
    And After applying discount or buffer validate the total cost of the itinerary 
    And validate that the edit icon is showing for applying overall discount price
    And Fill the discount form to apply discount by entering new deal size
    And validate the new deal size have been reflected after applying the discount or buffer
    Then Navigate back to inclusion page
    And Validate that the applied discount or buffer has been applied on top of trip cost
    And After applying discount or buffer validate the total cost of the itinerary 
    
    
   Examples: 
      | region | departFrom |
      | Europe | Chennai    |
      
      
    