@RegressionTest @Speedboat @SanityTest
Feature: Speedboat Uncosted Resort Details Flow


 
  Scenario Outline: User flow - Choose resorts from all categories in landing page and cost them
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on the resort card for the category "<category>" and select resort name "<Hotelname>"
    #Then Click on a resort card for the category "<category>"
    And  Verify that resort details page is opened
    Then Click on Check Availability button
    And user fills the GCM form of maldives for "<departFrom>"
    And Verify that valid results are displayed in costed details page
    
  	Examples: 
	  |region  |category                |Hotelname                  |departFrom |
	  |Maldives|For the Honeymooners    |Coco Bodu Hithi            |Chennai|
    |Maldives|Best Overwater Villa    |South Palm Resort Maldives  |Chennai|
    |Maldives|Kid Friendly Resorts    |Adaaran Select Hudhuran Fushi|Chennai|
    |Maldives|Seaplane Only           |Brennia Kottefaru |Chennai|
	    #	    |Maldives|Pocket Savers          	|Bengaluru|Makunudu Island| - Commenting out since its not their in the product
	    

