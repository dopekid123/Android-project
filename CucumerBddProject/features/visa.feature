@FAS @InclusionsFlow @RegressionTest @Set3 @Test
Feature: Validation of Visa feature by adding and removing the visa in the inclusion page

  @SmokeTest
  Scenario Outline: Adding the visa by admin
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that user is able to remove and add the visa

    Examples: 
      | region |
      | Rome   |

  @reg
  Scenario Outline: Adding the visa by user
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    #Then validate that user is able to add the visa
    Then validate that user is able to remove and add the visa

    Examples: 
      | region |
      | Rome   |
