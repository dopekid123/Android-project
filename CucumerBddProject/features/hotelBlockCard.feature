@FAS @Hotels @InclusionsFlow @RegressionTest @Set2
Feature: Validation of block card for Hotel

  @Test  
  Scenario Outline: Add custom card for hotel with non DB hotel and remove it
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And validate the details and user removes the hotel
    And user adds the hotel custom card for "<hotelName>","<provider>","<reason>","<roomName>","<internetCost>","<mealType>","<inclusionTitle>","<roomInclusions>","<fee>"
    Then verify the block card posted successfully for hotel
    Then remove the block card and verify it
    

    Examples: 
      | region    | hotelName    | provider | reason                       | roomName  | internetCost | mealType | inclusionTitle | roomInclusions | fee  |
      | Australia | Non DB Hotel | EXPEDIA  | Specific hotel NA on product | room name |         4000 | AI       | Test           | Testing        | 1000 |

  @PostBuild 
  Scenario Outline: Add custom card for hotel with DB hotel and remove it
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And validate the details and user removes the hotel
    And user adds the hotel custom card for "<hotelName>","<provider>","<reason>","<roomName>","<internetCost>","<mealType>","<inclusionTitle>","<roomInclusions>","<fee>"
    Then verify the block card posted successfully for hotel
    Then remove the block card and verify it

    Examples: 
      | region    | hotelName | provider | reason                       | roomName  | internetCost | mealType | inclusionTitle | roomInclusions | fee  |
      | Australia | Hotel     | EXPEDIA  | Specific hotel NA on product | room name |         4000 | AI       | Test           | Testing        | 1000 |
      
