@RegressionTest @Set2 @SanityTest @localsanity 
Feature: Validation of live price screen test cases

@RegressionTest @SmokeTest 
Scenario Outline: Verify inclusions card count with live price screen cards count 
 Given Login as a authenticated user
  And  user validates the costing flow for "<region>"
  Then validate that the itinerary is created succesfully
  And  user fills the GCM form 
  And  Check an itinerary got successfully costed
  And  get the count of the inclusions card count from the inclusions page 
  And  user checks all the alerts and clicks continue to book
  And  user fills in the passenger details
  And  get the count of the inclusions card from the live price page 
  Then validate the both count are same 
  
  Examples:
 |region|
 |Australia|
# |Europe|
 #|Bali|
  
 
 @RegressionTest @SmokeTest @Sandune 
 Scenario Outline: Verify inclusions card count with live price screen cards count for sandune
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
  And  get the count of the inclusions card count from the inclusions page 
  And  user checks all the alerts and clicks continue to book
  And  user fills in the passenger details
  And  get the count of the inclusions card from the live price page 
  Then validate the both count are same 
  
   Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | Dubai, United Arab Emirates  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  
  
  
  
  
  
  
  
  