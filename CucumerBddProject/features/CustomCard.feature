@customcard @sanity
Feature: Custom card feature sanity
   Validate custom card functionality in the itinerary

  Scenario Outline: Validate able to add the custom item in the itinerary
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
     Then Add the flights in edit details option
    And validate able to add the custom item in the itinerary

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |


  Scenario Outline: After closing the custom item popup, validate that it leads to new itinerary page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And After closing the custom item popup, validate that it leads to new itinerary page

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 6383589200 | 666666 |


  Scenario Outline: After closing the custom item popup, validate that it leads to new itinerary page in mle
    Given Login as a existing user while creating itinerary for MLE with "<url>", "<uName>" and "<passwd>"
    And validate whether the login is successful and successfully created the itinerary
    Then validate the itinerary is costed
    And After closing the custom item popup, validate that it leads to new itinerary page in mle

    Examples: 
      | url                                              | uName      | passwd |
      | https://pickyourtrail.com/maldives-tour-packages | 6383589200 | 666666 |

  Scenario Outline: Validate able to add and edit the custom card in the itinerary for Maldives
    Given Login as a existing user while creating itinerary for MLE with "<url>", "<uName>" and "<passwd>"
    And validate whether the login is successful and successfully created the itinerary
    And validate able to add and edit the custom item in the mle itinerary

    Examples: 
      | url                                              | uName      | passwd |
      | https://pickyourtrail.com/maldives-tour-packages | 6383589200 | 666666 |

  Scenario Outline: Validate able to edit and remove the custom item in the itinerary
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Add the flights in edit details option
    And validate able to add the custom item in the itinerary
    And validate able to edit and remove the custom item in the itinerary

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |
