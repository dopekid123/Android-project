@Flights @InclusionsFlow @RegressionTest @Set2
Feature: Flights Admin Flow - Verify the flights flow across the product

  #This test case verifies changing international flights using smart filter option as an admin user
  @SmokeTest
  Scenario Outline: Admin Flow validate smart filter and number of stop filter
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that smart filtered flight option is chosen successfully
    Then validate that number of stop flight filter options

    Examples: 
      | region    | departFrom |
      | Europe | Chennai    |

  Scenario Outline: Admin Flow validate that onward journey flight filter options
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate whether Flight change is selected
    Then validate that onward journey flight filter options

    Examples: 
      | region | departFrom |
      | Europe | Chennai    |


  #This test case verifies choosing a refundable and non-refundable international flight as an admin user
  Scenario Outline: Admin Flow validate that flight payment filter options
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate whether Flight change is selected
    Then validate that flight payment filter options

    Examples: 
      | region | departFrom |
      | Europe | Chennai    |

  #This test case verifies choosing 'Show More' option for international flight as an admin user
  Scenario Outline: Admin Flow Choose Flight From More Available Options in Flight Card
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate whether Flight change is selected
    Then validate that more flight options in a flight card is displayed
    Then validate that flight is chosen from displayed options

    Examples: 
      | region      | departFrom |
      | New Zealand | Chennai    |
      
  #This test case verifies choosing flight after changing internal flight provider as an admin user
  @Test
  Scenario Outline: Admin Flow Change Internal Flight Provider
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that internal flight provider is changed successfully

    Examples: 
      | region | departFrom |
      | Europe | Chennai    |
