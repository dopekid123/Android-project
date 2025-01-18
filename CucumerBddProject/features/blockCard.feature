@blockCard
Feature: Block card fetaure sanity
   Validate Block card functionality in the itinerary

  @sanity @blockCardSanity
  Scenario Outline: Validate by adding and removing a block card for the hotel in the itinerary
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And user views the details of the hotel
    Then user removes the hotel and confirms
    And validate by adding and removing a block card for the hotel in the itinerary

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 6383589200 | 666666 |

  @sanity @blockCardSanity
  Scenario Outline: Validate by adding and removing a block card for the activity in the itinerary
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate by adding and removing a block card for the activity in the itinerary

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 6383589200 | 666666 |


  Scenario Outline: Validate by adding and removing a block card for the internal flight in the itinerary
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    And validate by adding and removing a block card for the internal flight in the itinerary

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |
