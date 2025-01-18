 @Speedboat @RegressionTest @CBRPlusSignupSanity
Feature: Speedboat Listing Page Flow
  Executes all test scenarios for verifying functionality of listing page in Maldives flow.
  
  #Commented the below scenarios on Feb 23rd 2024 because of flow change for Maldives through PDG
  
  #Flow change: Creating an itinerary for Maldives through PDG will lead to listing page directly instead of speedboat landing page
  
  #Scenario Outline: User flow - Verify results in Maldives listing page with price filter options
    #Given Login as a authenticated user
    #And Navigate to landing page for "<region>"
    #Then Verify that landing page is loaded as expected
    #Then Enter the departure location as "<departFrom>"
    #And Enter the departure date
    #Then Search for all available packages
    #Then Verify that valid results are displayed in listing page
    #Then Validate the price range filter in listing page
    #And Validate the star category filter in listing page
    #Then Validate the villa type filter in listing page
    #Then Validate the Meal filter in listing page
    #Then Validate the other filter in listing page
    #
#
    #Examples: 
      #| region   | departFrom |
      #| Maldives | Chennai    |
#
  #Scenario Outline: User flow - Verify results in Maldives listing page by modifying GCM details - Departure City
    #Given Login as a authenticated user
    #And Navigate to landing page for "<region>"
    #Then Verify that landing page is loaded as expected
    #Then Enter the departure location as "<departFrom>"
    #And Enter the departure date
    #Then Search for all available packages
    #Then Verify that valid results are displayed in listing page
    #Then Click on the GCM pill and update departure city "<depChoice>"
    #Then Click on Search available packages
    #Then Verify that valid results are displayed in listing page
#
    #Examples: 
      #| region   | departFrom | depChoice |
      #| Maldives | Chennai    | Delhi     |

  
  #Current flow: An maldives itinerary created through PDG will directly navigate to listing page instead of speedboat home/landing page 
 

 @speedboatListing
	Scenario Outline: Validating the Edit details with 4 Nights and passenger as solo
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validating the Edit details with 4 Nights and passenger as solo
  #Then Login into the plato using valid credentials and click on Sales dashboard
  #Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	#@speedboatListing (commented on Jan 10th 2025) because of data not available for this config in the backend
	Scenario Outline: Validating the Edit details with 5 Nights and passenger as Family with 2 Rooms & 2 Children & 2 Adults
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validating the Edit details with 5 Nights and passenger as Family with 2 Rooms & 2 Children & 2 Adults on each
  #Then Login into the plato using valid credentials and click on Sales dashboard
  #Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	#@speedboatListing (commented on Jan 10th 2025) because of data not available for this config in the backend
	Scenario Outline: Validating the Edit details with 6 Nights and passenger as Friends with 3 Rooms - 4 Adults, 3 Adults & 2 Adults
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validating the Edit details with Six Nights and passenger as Friends with Three Rooms - Four Adults, Three Adults & Two Adults on each
  #Then Login into the plato using valid credentials and click on Sales dashboard
  #Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	@speedboatListing @sanity
	Scenario Outline: Validating by adding the maximum number of Rooms and Delete Rooms functionality in the Edit details
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validating by adding the maximum number of Rooms and Delete Rooms functionality in the Edit details
 
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|