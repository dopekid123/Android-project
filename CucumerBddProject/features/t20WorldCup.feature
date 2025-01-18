#@RegressionTest @T20
Feature: T20 World Cup men and women flow
  Validating the t20 world cup men and women flow
  
  Scenario Outline: Verifying the T20 men and women world cup itinerary
    Given Select the T-twenty world cup for "<type>"
    And Choose the "<itinerary_type>"
    And Select one of the itinerary card from list of itinerary cards
    Then Validate the request call back form is appearing

    Examples: 
      | type  | itinerary_type |
      | men   | Discover       |
      | men   | Experience     |
      | men   | Indulge        |
      | women | Discover       |
      | women | Experience     |
      | women | Indulge        |
