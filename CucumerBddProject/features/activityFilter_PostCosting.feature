@FAS @Activities @RegressionTest @PostCosting @Set1 @Test
Feature: Filter validation of Activity filter - Post Costing
  Scenario Outline: Activity Filter Validation For Filters After costing In Inclusions page
    Given Login as a authenticated user
    #Commenting the rencently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And validate that the Activity section is displayed
    And user navigate to activity alternate page from the inclusions page
   And verify all the time slot filters after costing
    And verify all the activity duration filters after costing
    And verify all the transfer and group type filters after costing
    And verify all the Interests filters after costing
    And verify all the other filters after costing

    Examples: 
      | region    | 
      | Australia |