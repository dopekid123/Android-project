@shareItinerary @sanity
Feature: Share itinerary feature sanity
  Validating the share itinerary functionality

  Scenario Outline: Verifying by sharing the itinerary to the existing user through mobile number
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then share the itinerary to the existing "<user>" through mobile number and validate the functionality
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | packages        | clickOn   | uName      | passwd | user       |
      | packages/europe | View Deal | 6383589200 | 666666 | 8917374415 |


  Scenario Outline: Verifying by sharing the itinerary to the existing user through email id
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then share the itinerary to the existing "<user>" through email id and validate the functionality
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | packages           | clickOn   | uName      | passwd | user                        |
      | packages/australia | View Deal | 6383589200 | 666666 | automationdemotest@mail.com |


  Scenario Outline: Verifying by sharing the itinerary to the new user
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then share the itinerary to the new "<user>" with "<name>" "<email>" and validate the functionality
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | packages        | clickOn   | uName      | passwd | user       | name   | email                         |
      | packages/europe | View Deal | 6383589200 | 666666 | 9566605855 | QATEST | shareitinerarytest06@mail.com |


  Scenario Outline: Verifying by sharing the itinerary to the existing user in Maldives through mobile number
    Given Login as a existing user while creating itinerary for MLE with "<url>", "<uName>" and "<passwd>"
    And validate whether the login is successful and successfully created the itinerary
    Then validate the itinerary is costed
    Then share the itinerary to the existing "<user>" through mobile number and validate the functionality in Maldives
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | url                                              | uName      | passwd | user       |
      | https://pickyourtrail.com/maldives-tour-packages | 6383589200 | 666666 | 8917374415 |


  Scenario Outline: Verifying by sharing the itinerary to the existing user in Maldives through mail id
    Given Login as a existing user while creating itinerary for MLE with "<url>", "<uName>" and "<passwd>"
    And validate whether the login is successful and successfully created the itinerary
    Then validate the itinerary is costed
    Then share the itinerary to the existing "<user>" through mail id and validate the functionality in Maldives
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | url                                              | uName      | passwd | user                        |
      | https://pickyourtrail.com/maldives-tour-packages | 6383589200 | 666666 | automationdemotest@mail.com |


  Scenario Outline: Verifying by sharing the itinerary to the new user in Maldives
    Given Login as a existing user while creating itinerary for MLE with "<url>", "<uName>" and "<passwd>"
    And validate whether the login is successful and successfully created the itinerary
    Then validate the itinerary is costed
    Then share the itinerary to the new "<user>" with "<name>" "<email>" and validate the functionality in Maldives
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | url                                              | uName      | passwd | user       | name   | email                            |
      | https://pickyourtrail.com/maldives-tour-packages | 6383589200 | 666666 | 9566605855 | QATEST | shareitinerarytestmle08@mail.com |
