@RegressionTest @sanity
Feature: Edit Route Modal in the itinerary
  Validate the functionality of each element in the edit route modal

  @sanityforeditroute
  Scenario Outline: Validate the Replace city functionality on the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the replace city functionality on the itinerary page 

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Add city functionality on the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the add city functionality on the itinerary page

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 6383589200 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Delete city functionality on the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the delete city functionality on the itinerary page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Add and Remove nights functionality on the itinerary page as Admin
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the add and remove nights functionality on the itinerary page

    Examples: 
      | packages                | clickOn   | uName      | passwd |
      | packages/switzerland    | View Deal | 6383589200 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Replace city functionality on the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the replace city functionality on the itinerary page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Add city functionality on the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the add city functionality on the itinerary page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Delete city functionality on the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the delete city functionality on the itinerary page

    Examples: 
      | packages           | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 8917374415 | 666666 |

  @sanityforeditroute
  Scenario Outline: Validate the Add and Remove nights functionality on the itinerary page as User
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate the add and remove nights functionality on the itinerary page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

