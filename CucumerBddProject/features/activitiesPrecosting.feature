@Activities @ItineraryFlow @RegressionTest @sanity
Feature: Activities Precosting Flow
  Verify the Activity flow pre-costing With Pre-Login/Post-Login

  @activityForSanity
  Scenario Outline: Validate the change activity in the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the Change Activity in the itinerary page as Admin

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the remove activity in the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the Remove Activity in the itinerary page as Admin

    Examples: 
      | packages             | clickOn   | uName      | passwd |
      | packages/switzerland | View Deal | 6383589200 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the add activity in the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the Add Activity in the itinerary page as Admin

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the change activity in the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the Change Activity in the itinerary page as Admin

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the remove activity in the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the Remove Activity in the itinerary page as Admin

    Examples: 
      | packages          | clickOn   | uName      | passwd |
      | packages/europe   | View Deal | 8917374415 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the add activity in the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the Add Activity in the itinerary page as Admin

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the transfer filter in the alternate page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the transfer filter the alternate page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the group type filter in the alternate page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the group type filter in the alternate page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the pyt recommended filter in the alternate page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And validate the pyt recommended filter in the alternate page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @activityForSanity
  Scenario Outline: Validate the time slot filter in the alternate page
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    And verify all the time slot filters

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 8917374415 | 666666 |
