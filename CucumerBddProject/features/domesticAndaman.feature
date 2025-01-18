#@RegressionTest @SanityTest
Feature: Domestic andaman Listing Page Flow
  

  Scenario Outline: User flow - Verify results in andaman listing page with price filter options
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    Then Verify that domestic landing page is loaded as expected
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    Then Search for all available packages
    Then Verify that valid results are displayed in listing page
    Then Check the inclusion page of andaman itinerary from listing page
    
    
Examples: 
      | region   | departFrom |
      | Andaman and Nicobar Islands | Chennai |

  Scenario Outline: User flow - Verify results in andaman listing page by modifying GCM details - Departure City
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    Then Verify that domestic landing page is loaded as expected
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    Then Search for all available packages
    Then Verify that valid results are displayed in listing page
    Then Click on the GCM pill and update departure city "<depChoice>"
    Then Click on Search available packages
    Then Verify that valid results are displayed in listing page

    Examples: 
      | region   | departFrom | depChoice |
      | Andaman and Nicobar Islands | Chennai  | Delhi |
      
      
   Scenario Outline: User flow - Choose resorts from all categories in landing page and cost them
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    Then Verify that domestic landing page is loaded as expected
    Then Click on a resort card for the category in andaman "<category>"
    Then unlock and cost the itineary and validate the itinerary page
      
  	Examples: 
	    |region|category|
	    |Andaman and Nicobar Islands|Recommended for you|
      
      
