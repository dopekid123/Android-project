@Transfers @InclusionsFlow @RegressionTest @Trains @Set2
Feature: Validating Trains feature in the inclusion page

  #This test case verifies changing trains as an user
  @SmokeTest @SanityTest
  Scenario Outline: User Flow validating the change view options on train
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Train section is displayed
    Then validate that the alternate train is selected

    Examples: 
      | region |
      | Rome   |

  #This test case validates all the train filter options as an user
  @SmokeTest  
  Scenario Outline: Train Filters Validation
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Train section is displayed
    Then validate that number of stop train filter options
    Then validate that onward journey train filter options
    Then validate that return journey train filter options

    Examples: 
      | region |
      | Rome   |
