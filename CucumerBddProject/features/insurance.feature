@InclusionsFlow @Insurance @RegressionTest @sanity
Feature: Insurance validation in the itinerary page

  @sanityForInsurance
  Scenario Outline: Validate Remove Insurance in the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the remove insurance functionality in the itinerary page as Admin

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

  @sanityForInsurance
  Scenario Outline: Validate Add Insurance in the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the add insurance functionality in the itinerary page as Admin

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 6383589200 | 666666 |

  @sanityForInsurance
  Scenario Outline: Validate Change Insurance in the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the change insurance functionality in the itinerary page as Admin

    Examples: 
      | packages             | clickOn   | uName      | passwd |
      | packages/switzerland | View Deal | 6383589200 | 666666 |

  @sanityForInsurance
  Scenario Outline: Validate Remove Insurance in the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the remove insurance functionality in the itinerary page as User

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @sanityForInsurance
  Scenario Outline: Validate Add Insurance in the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the add insurance functionality in the itinerary page as User

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @sanityForInsurance
  Scenario Outline: Validate Change Insurance in the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the change insurance functionality in the itinerary page as User

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 8917374415 | 666666 |
