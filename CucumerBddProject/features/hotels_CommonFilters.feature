@sanity
Feature: Hotels Alternate page 
  Verify the Hotels flow across the product

  @hotelsSanity
  Scenario Outline: Validate the change and remove hotels in the itinerary as admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And user views the details of the hotel
    Then user removes the hotel and confirms
    And user Adds an hotel
    Then validates hotel added succesfully

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/europe    | View Deal | 6383589200 | 666666 |

  @hotelsSanity
  Scenario Outline: Validate the change hotels in the itinerary as user
   Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And user views the details of the hotel
    And user changes the hotel and select an alternative
    Then validates hotel added succesfully

   Examples: 
      | packages             | clickOn   | uName      | passwd |
      | packages/europe      | View Deal | 8917374415 | 666666 |

  @hotelsSanity
  Scenario Outline: Validating after closing the split stay popup it redirects to the new flow as user
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    Then validate that after closing the split stay it redirecting to the new itinerary

    Examples: 
      | packages            | clickOn   | uName      | passwd |
      | packages/europe      | View Deal | 8917374415 | 666666 |

   @hotelsSanity
  Scenario Outline: Validating the split stay option as user
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    Then add the split stay night in the itinerary
    Then validate the split stay added successfully in the itinerary

    Examples: 
      | packages            | clickOn   | uName      | passwd |
      | packages/europe      | View Deal | 8917374415 | 666666 |

  @hotelsSanity
  Scenario Outline: Validating Hotel Cancellation policy Filters in the Hotel Alternate Page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And check hotel options available in the alternate
    Then apply the refundable filter in map view and validate the filter applied succesfully

    Examples: 
      | packages                | clickOn   | uName      | passwd |
      | packages/switzerland    | View Deal | 8917374415 | 666666 |

  @hotelsSanity
  Scenario Outline: Validating Hotel Star Filters In the Hotel Alternate Page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And check hotel options available in the alternate
    Then apply the star filters and validate the filter applied succesfully

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

   @hotelsSanity
  Scenario Outline: Validating Hotel inclusions Filter In the Hotel Alternate Page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And check hotel options available in the alternate
    Then apply the inclusions filters in hotel alternate and validate the filter applied successfully

    Examples: 
      | packages               | clickOn   | uName      | passwd |
      | packages/switzerland   | View Deal | 8917374415 | 666666 |

    @hotelsSanity
  Scenario Outline: Validate the change dates option for stays as admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Add the flights in edit details option
    Then validate that the Hotel section is displayed
    Then Add the early checkin and checkout date and validate it

    Examples:  
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

    @hotelsSanity
  Scenario Outline: Validating Hotel Cheapest price Filter In the Hotel Alternate Page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate that the Hotel section is displayed
    And check hotel options available in the alternate
    Then apply sorting and validate the sort applied successfully

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

