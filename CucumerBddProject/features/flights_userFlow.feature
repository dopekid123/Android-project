@Flights @InclusionsFlow @RegressionTest @Set2 @sanity
Feature: Flights User Flow
  Verify the flights flow across the product

  ### User flow scenarios ###
  #This test case verifies changing flights using smart filter option as a regular user
   @sanityForFlightsAlternate
  Scenario Outline: Validate that Smart filter options working as expected
    Given Signup as a new user while creating itinerary for europe with "<region>", "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that smart filtered flight option is chosen successfully
    Then validate that flights changed using smart filter

    Examples: 
      | uName      | passwd | name              | region |
      | 9176054867 | 666666 | Test Smart filter | Europe |

  #This test case verifies choosing an early morning international flight for onward journey as a regular user
  @sanityForFlightsAlternate
  Scenario Outline: Validate that departure time filter options working as expected
    Given Signup as a new user while creating itinerary for europe with "<region>", "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that onward journey flight filter options

    Examples: 
      | uName      | passwd | name                       | region |
      | 9176054867 | 666666 | Test Onward Journey Filter | Europe |

  #This test case verifies choosing a refundable and non-refundable international flight as a regular user
  @sanityForFlightsAlternate
  Scenario Outline: Validate that Payment flight filter option working as expected
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that flight payment filter options

    Examples: 
      | packages      | clickOn   | uName      | passwd | name                       | region |
      | packages/bali | View Deal | 8917374415 | 666666 | Test flight payment filter | Europe |

  #This test case verifies stop filter in international flight as a regular user
   @sanityForFlightsAlternate
  Scenario Outline: Validate that Stop filter option working as expected
    Given Signup as a new user while creating itinerary for europe with "<region>", "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that number of stop filter options

   Examples: 
      | region | uName      | passwd |      name         |
      | Europe | 9176054867 | 666666 | Signup PDG Europe |

  #This test case verifies removing international flight as a admin user
  @sanityForFlightsAlternate
  Scenario Outline: Validate that Removing international flight option working as expected
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight view details is selected
    Then validate whether existing flight removed

     Examples: 
      | packages        | clickOn   | uName      | passwd | region |
      | packages/europe | View Deal | 6383589200 | 666666 | Europe |

  #This test case verifies View more flights, back to list and back to itinerary functions working as expected
  @sanityForFlightsAlternate
  Scenario Outline: Validate that View more flights, back to list and back to itinerary functions working as expected
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight view details is selected
    Then validate whether All functions in flight page working as expected

    Examples: 
      | packages        | clickOn   | uName      | passwd | region |
      | packages/europe | View Deal | 8917374415 | 666666 | Europe |


  @sanityForFlightsAlternate
  Scenario Outline: Verify if user able to change the international flight
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then user selects the alternate flight from the alternate flight section

    Examples: 
      | packages      | clickOn   | uName      | passwd |  region |
      | packages/bali | View Deal | 8917374415 | 666666 |  Europe |
