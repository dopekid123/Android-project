@FAS @Sandune @RegressionTest @Set3 
Feature: Flights User Flow for sandune
  Verify the flights flow in sandune flow

#  ### User flow scenarios ###
#This test case verifies changing flights using smart filter option as a regular user in sandune flow
@SmokeTest  
 Scenario Outline: Sandune - User Flow - validate smart filter and number of stop filter
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the flight trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that smart filtered flight option is chosen successfully
    Then validate that number of stop flight filter options

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | OCT       | Delhi  |       30 | 5 - 8 nights | Partner     |

  #This test case verifies choosing an early morning international flight for onward and return journey as a regular user in sandune flow
@Test 
  Scenario Outline: Sandune User Flow Onward Flights Validation 
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the flight trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    Then validate whether Flight change is selected
  	 Then validate that onward journey flight filter options
    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | OCT        | Delhi  |       30 | 5 - 8 nights | Partner     |


  #This test case verifies choosing a refundable and non-refundable international flight as a regular user in sandune flow
  Scenario Outline: User Flow Choosing Refundable and Non-refundable Flights Validation under sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the flight trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    Then validate whether Flight change is selected
    Then validate that flight payment filter options

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | OCT        | Delhi  |       30 | 5 - 8 nights | Partner     |
