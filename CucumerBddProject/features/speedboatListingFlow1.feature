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
  @speedboatListing @sanity
  Scenario Outline: User flow - Validating the edit details filter with 2 Adults & 1 Room in the speedboat listing page 
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validate the Edit details functionality in the listing page
  
	Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|


  @speedboatListing @sanity
	Scenario Outline: Validating the PYT Recommended filter in the Maldives listing page
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validate Pyt Recommended filter in listing page
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	@speedboatListing @sanity
	Scenario Outline: Validating the Price range filter in the Maldives listing page
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validate the price range filter in listing page
  
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	
	@speedboatListing
	Scenario Outline: Validating the Star category filter in the Maldives listing page
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  And Validate the star category filter in listing page
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	
	@speedboatListing
	Scenario Outline: Validating the Villa Type filter in the Maldives listing page
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validate the villa type filter in listing page
  
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	
	
	@speedboatListing
	Scenario Outline: Validating the Others filter in the Maldives listing page
  Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
	Then validate whether the Signup is successful
	And Navigate to landing page for "<region>"
  And Verify that landing page is loaded as expected
  Then Validate the other filter in listing page
  Examples:
	|uName			|passwd| region  |
	|8917374415	|666666| Maldives|
	