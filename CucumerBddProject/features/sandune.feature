@FAS @Sandune @RegressionTest @Set3 @SanityTest 
Feature: Validation the end to end user flow for sandune

  #1 Testcase
  #This testcase is to verify end-to-end PDG flow for sandune
  
  Scenario Outline: End to End user PDG flow validation for sandune
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
     And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | Dubai, United Arab Emirates  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     |
