@RegressionTest @Speedboat
Feature: Speedboat Uncosted Resort Details Flow

  Scenario Outline: User flow - Cost resorts from landing page and change room type in full stay options
    Given Login as a authenticated user
    Then Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on a resort card for the category "<category>"
    And Verify that resort details page is opened
    Then Click on Check Availability button
    And Enter the departure location as "<depChoice>"
    And Enter the departure date
    Then Click on Search available packages
    And Verify that valid results are displayed in costed details page
    Then Click on change room option
    And Choose a room from the alternate full stay options available
    
  	Examples: 
	    |region|category|depChoice|
	    |Maldives|For the Honeymooners|Chennai|
	    |Maldives|Best Overwater Villa|Delhi|
	    |Maldives|Kid Friendly Resorts|Kolkata|
	    |Maldives|Great Indian Food|Bengaluru|
	    |Maldives|Seaplane Only|Mumbai|
#	    |Maldives|Closest to Airport|Chennai|
	
	 
  Scenario Outline: User flow - Cost resorts from landing page and change room type in split stay options
    Given Login as a authenticated user
    Then Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on a resort card for the category "<category>"
    And Verify that resort details page is opened
    Then Click on Check Availability button
    And Enter the departure location as "<depChoice>"
    And Enter the departure date
    Then Click on Search available packages
    And Verify that valid results are displayed in costed details page
    Then Click on change room option
    And Choose a room from the alternate split stay options available
    
  	Examples: 
	    |region|category|depChoice|
	    |Maldives|For the Honeymooners|Chennai|
	    |Maldives|Best Overwater Villa|Delhi|
	    |Maldives|Kid Friendly Resorts|Kolkata|
	    |Maldives|Great Indian Food|Bengaluru|
	    |Maldives|Seaplane Only|Mumbai|
#	    |Maldives|Closest to Airport|Chennai|

