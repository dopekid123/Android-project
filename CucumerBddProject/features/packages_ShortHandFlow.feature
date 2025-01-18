Feature: Packages page short hand destination flow
  Validating the packages page short hand destination flow
  
#Short hand flow has been removed from product on packages flow.
Scenario Outline: Validating the short hand destination on packages page
Given Login as a authenticated user
Then navigate to short hand flow packages page for "<region>" 
And Select an itinerary title and verify the uncosted page is displaying
Then unlock and cost the itineary and validate the itinerary page

Examples:
|region|
|singapore|


  
  