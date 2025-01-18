@FAS @Sandune @RegressionTest @Set3
Feature: Validation the activities under sandune

  #12 Testcases
  #User replaces the activity in the itinerary page for sandune
  Scenario Outline: User replaces the activity in the itinerary page for sandune
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User replaces the activities in the itinerary page
    Then User removes the activities in the itinerary page
    Then User adds the activities in the itinerary page

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  # Activity in inclusion page under sandune
  #	User Change the Activity In Inclusions Page for sandune via alternate page
  @Test
  Scenario Outline: User Change the Activity Post Costing In Inclusions Page
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    Then validate that the Activity section is displayed
    And user change the activity from inclusions via alternate page
    Then validate the activity added from inclusions successfully
    Then validate the activity removal flow

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #Activity filter validation for sandune
  #User validates the time slot filter in alternate page for sandune
  Scenario Outline: Activity Filter Validation Slot Wise For Time Slot Filters
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    And user selects the activity slot for filter validation
    And verify all the time slot filters after costing
    And verify all the activity duration filters after costing
    And verify all the transfer and group type filters after costing
    And verify all the Interests filters after costing
    And verify all the other filters after costing

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |
