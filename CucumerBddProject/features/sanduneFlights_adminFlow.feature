@FAS @Sandune @RegressionTest @Set3 
Feature: Flights Admin Flow for sandune
  Verify the flights flow in sandune flow

  #This test case verifies changing international flights using smart filter option as an admin user in sandune flow
  @SmokeTest @Test   
  Scenario Outline: Sandune Flow - validate smart filter and number of stop filter
    Given Login as a authenticated admin user
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
      | dubai  | OCT       | Delhi  |        30 | 5 - 8 nights | Partner     |

 
  #This test case verifies choosing a Direct, 1 Stop and 2 Stop flight using filter option as an admin user in sandune flow
 
  Scenario Outline: Sandune Flow - Admin Flow validate that onward journey flight filter options
    Given Login as a authenticated admin user
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
      | dubai  | OCT        | Delhi  |        30 | 5 - 8 nights | Partner     |


  #This test case verifies choosing an early morning flight for onward and return journey as an admin user in sandune flow
   
  Scenario Outline: Sandune Flow - Admin Flow validate that flight payment filter options
    Given Login as a authenticated admin user
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
      | dubai  | OCT        | Delhi  |        30 | 5 - 8 nights | Partner     |


  #This test case verifies choosing 'Show More' option for international flight as an admin user in sandune flow
 
  Scenario Outline: Admin Flow Choose Flight From More Available Options in Flight Card under sandune flow
    Given Login as a authenticated admin user
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
    Then validate that more flight options in a flight card is displayed
    Then validate that flight is chosen from displayed options

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | OCT       | Delhi  |        30 | 5 - 8 nights | Partner     |
