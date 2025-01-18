@FAS @UserFlow @PostBuild @RegressionTest @Set2 
Feature: User Itinerary Flow 
 Verify the itinerary flow across the product

Background:
Given Login as a authenticated user


#This scenario will check for the successful itinerary creation for existing registered user
@SmokeTest @RegressionTest
Scenario Outline: Itinearay creation validation
 And user validates the costing flow for "<region>"
 Then validate that the itinerary is created succesfully
 Examples:
 |region|
 |Thailand|
 |Europe|
 |Australia|

 
#This scenario will check for the successful itinerary creation for new user
@SmokeTest @RegressionTest
Scenario Outline: Itinearay creation validation
 Given user validates the costing flow for "<region>"
 Then validate that the itinerary is created succesfully
 Examples:
 |region|
 |Europe|
 |Australia|
 |Bali|
 
  
 #As of now, payU don't have option to cancel the payment - Feb26 
 #scenario will check for the PDG flow along with Modification of Flights/Hotel/Activity during itinerary creation  and 
 #validates the cancel transaction
#@SmokeTest @RegressionTest @fix
#Scenario Outline: End to End user PDG flow validation - cancel transaction
 #Given Login as a authenticated user
 #And user validates the costing flow for "<region>"
 #Then validate that the itinerary is created succesfully
 #And user fills the GCM form
 #And user checks all the alerts and clicks continue to book
 #And user fills in the passenger details
 #And user reviews the cost and clicks make payment
 #And user makes the full payment
 #And user fills the card details and cancel payment in payU
 #Then validate that the payment is cancelled
 #And user cancels the transaction
 #Then validate that the user is navigated back to the inclusion screen after cancelation
          
 #Examples:
 #|region|
 #|Australia|
# |South Africa|
 
#scenario will check for the PDG flow along with Modification of Flights/Hotel/Activity during itinerary creation
#Handled the soldout scenario
#Commented by sharmila - 29-07-2021 - The same use case is addressed in your vacation feature file 
#Scenario name :   Scenario Outline: Verify After First Payment User Should Redirect to Your Vacations Page

#@SmokeTest @RegressionTest 
#Scenario Outline: End to End user PDG flow validation
 #And user validates the costing flow for "<region>"
 #Then validate that the itinerary is created succesfully
 #And user fills the GCM form
 #And user checks all the alerts and clicks continue to book
 #And user fills in the passenger details
 #Then user Verifies if there is any sold out line item in the live price screen
 #And user makes the full payment
 #And user fills the card details and make payment
 #Then validate that the payment is success
          #
 #Examples:
 #|region|
 #|Europe|

 
@SmokeTest @RegressionTest @SanityTest 
Scenario Outline: User Flow Inclusions Page Validation 
 And user validates the costing flow for "<region>"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 And Check an itinerary got successfully costed
 And user clicks inclusion page
 Then validate that the Flight section is displayed
 Then validate that the Hotel section is displayed
 Then validate that the Activity section is displayed
 Then validate that the Transfer section is displayed
 Then validate that the Visa and insurance section is displayed
 Then validate that the Summary section is displayed
 Then validate that the Pass section is displayed
  Examples:
 |region|
 |Europe|
 |Australia|
 
@SanityTest 
Scenario Outline: User Flow Inclusions Page Validation 
 And user validates the short hand destinatiom costing flow for "<region>"
 And user validates the costing time period for "<region>"
 Then validate that the Flight section is displayed
 Then validate that the Hotel section is displayed
 Then validate that the Activity section is displayed
 Then validate that the Transfer section is displayed
 Then validate that the Visa and insurance section is displayed
 Then validate that the Summary section is displayed
 Then validate that the Pass section is displayed
  Examples:
 |region|
 |Singapore|
 |Switzerland|
 

