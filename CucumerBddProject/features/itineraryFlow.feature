@ItineraryFlow @RegressionTest @Set2
Feature: Itinerary Flow across the product
 Verify the itinerary flow across the product

#Background:
#Given Login as a authenticated user

@SmokeTest @RegressionTest 
Scenario Outline: Costing flow validation
Then user validates the costing flow for "<region>"
Then validate that the itinerary is created succesfully
           
 Examples:
 |region|
 |Australia|
 |Europe| 
 