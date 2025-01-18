@FAS @Sandune @RegressionTest @Set3 
Feature: Validation of hotels flow for sandune - Common Filters

  #Login as admin user and  validate that
  #No of hotels displayed in the header and actual no of hotels are equal
  #Remove Hotel
  #Add Hotel
  @SmokeTest @RegressionTest @PostBuild
  Scenario Outline: Admin Flow of Hotel validation on sandune flow
    Given Login as a authenticated admin user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user views the details of the hotel
    Then user removes the hotel and confirms
    And user Adds an hotel
    Then validates hotel added succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details | dep_city |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     | Chennai  |

  #Login as Registered  user and  validate that
  #No of hotels displayed in the header and actual no of hotels are equal
  #Remove Hotel does not exist
  #Change the existing hotel to other hotel
  @SmokeTest @RegressionTest
  Scenario Outline: User Flow of hotel Validation on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user views the details of the hotel
    And user changes the hotel and select an alternative
    Then validates hotel added succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details | dep_city |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     | Chennai  |



  Scenario Outline: Hotel Star Filters Validation In Hotel Alternate Page on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply the star filters and validate the filter applied succesfully
    Then apply the inclusions filters in hotel alternate and validate the filter applied successfully
    Then apply the refundable filter in map view and validate the filter applied succesfully
    Then apply the hotel filter in map view and validate the filter applied succesfully
    Then apply sorting and validate the sort applied successfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details | dep_city |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     | Chennai  |


Scenario Outline: Hotel Star Filters Validation In Hotel card Alternate Page on sandune flow
	Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
 	  And Check hotel options available in the alternate and validate the hotel name 
 	 
    

  Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details | dep_city |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     | Chennai  |

 
#commenting - since we have an issues on those testcases in product
 
  #This testcase is to validate if the user able to add the split stay hotel for sandune flow
  #@SmokeTest
  #Scenario Outline: User adds the split stay hotel in an inclusion page under sandune flow
    #Given Login as a authenticated user
    #And User selects the region "<region>" from destination options
    #And User chooses the month "<dubai_month>" for the trip
    #And User selects the departing city "<dep_city>" from the dropdown
    #And User selects the departure date "<dep_date>"
    #And User selects the no.of.nights "<no_of_nights>" stay options
    #And User selects the passenger details "<pax_details>" for the trip
    #And User selects the activities from the activities list
    #Then User validates the itinerary is created successfully
    #Then User Validate that the hotel section is displayed
    #Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    #And user adds the split stay hotel
    #Then User Validate that the hotel section is displayed
    #Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
#
    #Examples: 
      #| region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      #| dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     |
#
  #This testcase is to validate if the user able to delete the split stay hotel for sandune flow
  #Scenario Outline: User delete the split stay hotel in an inclusion page under sandune flow
    #Given Login as a authenticated user
    #And User selects the region "<region>" from destination options
    #And User chooses the month "<dubai_month>" for the trip
    #And User selects the departing city "<dep_city>" from the dropdown
    #And User selects the departure date "<dep_date>"
    #And User selects the no.of.nights "<no_of_nights>" stay options
    #And User selects the passenger details "<pax_details>" for the trip
    #And User selects the activities from the activities list
    #Then User validates the itinerary is created successfully
    #Then User Validate that the hotel section is displayed
    #Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    #Then User Validate that the hotel section is displayed
    #Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    #And user adds the split stay hotel
    #And user delete the split stay hotel selected
#
    #Examples: 
      #| region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      #| dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     |
