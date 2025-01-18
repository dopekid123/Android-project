@Speedboat  @RegressionTest
Feature: Speedboat Flow
  Executes all test scenarios for verifying functionality of Maldives flow.

@SanityTest 
  Scenario Outline: User flow - Verify costing from Maldives landing page with default and given duration and group type
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    Then Verify that landing page is loaded as expected
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    Then Search for all available packages
    Then Verify that valid results are displayed in listing page
    And Navigate to landing page for "<region>"
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    And Enter the duration of stay as "<duration>"
    And Add custom adult and child and room config as "<groupType>","<roomCount>"
    Then Search for all available packages
    Then Verify that valid results are displaying with room config and child option in url
    Then Verify the resorts are getting listed on the listing page

    Examples: 
      | region   | departFrom | duration | groupType | roomCount |
      | Maldives | Chennai    |        4 | Family    |         1 |


  Scenario Outline: Admin flow - Verify costing from Maldives landing page with default duration and group type
    Given Login as a authenticated admin user
    And Navigate to landing page for "<region>"
    Then Verify that landing page is loaded as expected
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    Then Search for all available packages
    Then Verify that valid results are displayed in listing page
    And Navigate to landing page for "<region>"
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    And Enter the duration of stay as "<duration>"
    And Add custom adult and child and room config as "<groupType>","<roomCount>"
    Then Search for all available packages
    Then Verify that valid results are displaying with room config and child option in url
    
    Examples: 
      | region   | departFrom | duration | groupType | roomCount |
      | Maldives | Chennai    |        4 | Family    |         1 |
      
   #The same scenario can be seen in the speedboatuncosteddetails feature, therefore commenting on this now.
   #Scenario Outline: User flow - Choose resorts from all categories in landing page and cost them
    #Given Login as a authenticated user
    #And Navigate to landing page for "<region>"
    #And Verify that landing page is loaded as expected
    #Then Click on a resort card for the category "<category>"
    #And Verify that resort details page is opened
    #Then Click on Check Availability button
    #And Enter the departure location as "<depChoice>"
    #And Enter the departure date
    #Then Click on Search available packages
    #And Verify that valid results are displayed in costed details page
    #
  #	Examples: 
#	    |region|category|depChoice|
#	    |Maldives|For the Honeymooners|Chennai|
#	    
	    
##PDG flow for maldives - If user selects maldives from PDG flow packages should open
 @RegressionTest 
 Scenario Outline: User flow - Verify costing from Maldives landing page with default and given duration and group type
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    
    Examples: 
      |region|
      |maldives|
      