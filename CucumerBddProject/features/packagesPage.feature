#@CampaignPages @RegressionTest @PackagesPage @Set1
Feature: Packages page flow
  Validating the packages page dropdown
  
#This test case validates the combination of destination and theme filters in packages page.

#Specify the no.of.Itineraries to be costed for the particular combination of filter in Configuration file under PackagesPageValidation variable.
#Steps to execute:
#1.Count the total no.of destination in the destination filter
#2.And select a destination from the destination filter
#3.Count the total no.of.themes in the theme filter.
#4.And select a theme from the theme filter.
#5.Then calculate the total no.of.itineraries for each theme according to the destination selected in the destination filter.
#6.Validate each itinerary by costing with the use of configuration file packagespagevalidation variable.
@RegressionTest  @SmokeTest 
Scenario: PackagesPageValidation
 Given Login as a authenticated user
 Then user validates the packages page


 