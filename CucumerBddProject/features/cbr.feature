@regression @cbrloginsignup

Feature: Validating Call Back request Feature

  @sanity @cbr
  Scenario Outline: Posting CBR on the Packages page as an already logged-in user
    Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
    Then validate whether the login is successful
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    And post cbr form
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages         | uName      | passwd |
      | packages/europe  | 8917374415 | 666666 |

  @sanity @cbr
  Scenario Outline: Posting CBR on the Packages page as an existing user
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>"
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages        | uName      | passwd | emailid                     | name     |
      | packages/bali | 8917374415 | 666666 | automationdemotest@mail.com | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Packages page as a new user
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>"
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages             | uName      | passwd | emailid                         | name     |
      | packages/switzerland | 9176054867 | 666666 | testingswitzerlandcbr@gmail.com | Techuser |
  
  @cbr
  Scenario Outline: Posting CBR in the Packages page as a new maiid and an existing user number
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>"
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages           | uName      | passwd | emailid                          | name     |
      | packages/singapore | 8917374415 | 666666 | testingsingaporecbrnew@gmail.com | Techuser |
  
  @cbr
  Scenario Outline: Posting CBR in the Packages page as a new mobile number and an existing mailid
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>"
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages             | uName      | passwd | emailid                     | name     |
      | packages/switzerland | 9566605855 | 666666 | automationdemotest@mail.com | Techuser |

  @cbr @sanity
  Scenario Outline: Posting CBR on the Vacations page as an already logged-in user
    Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
    Then validate whether the login is successful
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    And post cbr form
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages         | uName      | passwd |
      | vacations/bali | 8917374415 | 666666 |

  @cbr @sanity
  Scenario Outline: Posting CBR on the Vacations page as an existing user
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
     Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages       | uName      | passwd | emailid                     | name     |
      | vacations/bali | 8917374415 | 666666 | automationdemotest@mail.com | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Vacations page as a new user
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages            | uName      | passwd | emailid                               | name     |
      | vacations/singapore | 9176054867 | 666666 | testingsingaporecbrvacation@gmail.com | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Vacations page as a new email and an existing user number
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages           | uName      | passwd | emailid                          | name     |
      | vacations/thailand | 8917374415 | 666666 | testingthailandcbr@gmail.com     | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Vacations page with a new mobile number and an existing email
    Given User navigates to the "<packages>" page
    And user opens the cbr from packages page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages            | uName      | passwd | emailid                     | name     |
      | vacations/singapore | 9566605855 | 666666 | automationdemotest@mail.com | Techuser |


  Scenario Outline: Posting CBR on the itinerary page as an already logged-in user
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then Click on the request callback CTA in the itinerary page
    And post cbr form without preferred region
    Then Validate the CBR successfully popsted message in the itinerary page

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 8917374415 | 666666 |

  
  @cbr @sanity
  Scenario Outline: Posting CBR on the Maldives Listing page as an already logged-in user
    Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
    Then validate whether the Signup is successful
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on the request callbact CTA in the listing page
    And post cbr form without preferred region
    Then Validate the CBR successfully popsted message in the itinerary page

    Examples: 
      | uName      | passwd | region   |
      | 8917374415 | 666666 | Maldives |

  @cbr @sanity
  Scenario Outline: Posting CBR on the Maldives Listing page as an existing user
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on the request callbact CTA in the listing page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" in the Maldives page
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | region   | uName      | passwd | emailid                     | name     |
      | Maldives | 8917374415 | 666666 | automationdemotest@mail.com | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Maldives Listing page as a new user
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on the request callbact CTA in the listing page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" in the Maldives page
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | region   | uName      | passwd | emailid                        | name     |
      | Maldives | 9176054867 | 666666 | testingmaldivescbr@gmail.com   | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Maldives Listing page with a new email and an existing user number
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on the request callbact CTA in the listing page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" in the Maldives page
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | region   | uName      | passwd | emailid                           | name     |
      | Maldives | 8917374415 | 666666 | testingmaldivescbrmle@gmail.com   | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Maldives Listing page with a new mobile number and an existing email
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on the request callbact CTA in the listing page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" in the Maldives page
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | region   | uName      | passwd | emailid                     | name     |
      | Maldives | 9566605855 | 666666 | automationdemotest@mail.com | Techuser |

  
  @cbr @sanity
  Scenario Outline: Posting CBR on the Destination page as an already logged-in user
    Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
    Then validate whether the login is successful
    Given User navigates to the "<packages>" page
    And user opens the cbr from destination page
    Then Validate the CBR successfully posted message in destination page

    Examples: 
      | packages 					| uName      | passwd |
      | tourism/europe    | 8917374415 | 666666 |

  @cbr
  Scenario Outline: Posting CBR in the Destination page as existing user
    Given User navigates to the "<packages>" page
    Then user enters "<name>" "<uName>" and "<emailid>" in the destination page
    Then User enters "<passwd>" and submit the CBR form
    Then Validate whether Oops message with already account exists

    Examples: 
      | packages 						| uName      | passwd | emailid                     | name     |
      | tourism/europe     	| 8917374415 | 666666 | automationdemotest@gmail.com | Techuser |

  @cbr
  Scenario Outline: Posting CBR in the Destination page as new user
    Given User navigates to the "<packages>" page
    Then user enters "<name>" "<uName>" and "<emailid>" in the destination page
    Then User enters "<passwd>" and submit the CBR form
    Then Validate the CBR successfully posted message in packages page

    Examples: 
      | packages 						| uName      | passwd | emailid                    | name     |
      | tourism/europe      | 9176054867 | 666666 | testingbalicbr@gmail.com   | Techuser |

  @cbr
  Scenario Outline: Posting CBR in the Destination page as new mailid and existing user number
    Given User navigates to the "<packages>" page
    Then user enters "<name>" "<uName>" and "<emailid>" in the destination page
    Then User enters "<passwd>" and submit the CBR form
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages					 | uName      | passwd | emailid                             | name     |
      | tourism/europe     | 8917374415 | 666666 | testingbalidestinationcbr@gmail.com | Techuser |

  @cbr
  Scenario Outline: Posting CBR in the Destination page as new mobile number and existing mailid
    Given User navigates to the "<packages>" page
    Then user enters "<name>" "<uName>" and "<emailid>" in the destination page
    Then User enters "<passwd>" and submit the CBR form
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages 						| uName      | passwd | emailid                     | name     |
      | tourism/europe     	| 9566605855 | 666666 | automationdemotest@mail.com | Techuser |

  @cbr @sanity
  Scenario Outline: Posting CBR on the Journeys page as an already logged-in user
    Then Login to the application with valid username and password with "<uName>" and "<passwd>" through Header
    Then validate whether the login is successful
    Given User navigates to the "<packages>" page
    And user opens the cbr from journeys page
    Then Validate CBR posted in the Journeys page successfully

    Examples: 
      | packages                                     | uName      | passwd |
      | journeys/best-of-lisbon-madrid-and-barcelona | 8917374415 | 666666 |

  @cbr
  Scenario Outline: Posting CBR on the Journeys page as an existing user
    Given User navigates to the "<packages>" page
    And user opens the cbr from journeys page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate CBR posted in the Journeys page successfully

    Examples: 
      | packages                                     | uName      | passwd | emailid                     | name     |
      | journeys/best-of-lisbon-madrid-and-barcelona | 8917374415 | 666666 | automationdemotest@mail.com | Techuser |
 
  @cbr
  Scenario Outline: Posting CBR on the Journeys page as a new user
    Given User navigates to the "<packages>" page
    And user opens the cbr from journeys page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate CBR posted in the Journeys page successfully

    Examples: 
      | packages                                     | uName      | passwd | emailid                        | name     |
      | journeys/best-of-lisbon-madrid-and-barcelona | 9566605855 | 666666 | testingjorneycbr@gmail.com     | Techuser |

  @cbr
  Scenario Outline: Posting CBR on the Journeys page with a new email and an existing user number
    Given User navigates to the "<packages>" page
    And user opens the cbr from journeys page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages                                     | uName      | passwd | emailid                        | name     |
      | journeys/best-of-lisbon-madrid-and-barcelona | 8917374415 | 666666 | testingbarcelonacbr@gmail.com  | Techuser |
 
  @cbr
  Scenario Outline: Posting CBR on the Journeys page with a new mobile number and an existing email
    Given User navigates to the "<packages>" page
    And user opens the cbr from journeys page
    Then Enter the "<uName>" "<passwd>" "<name>" "<emailid>" without preferred region
    Then Validate the CBR request is not posting in the packages page

    Examples: 
      | packages                                     | uName      | passwd | emailid                     | name     |
      | journeys/best-of-lisbon-madrid-and-barcelona | 9566605855 | 666666 | automationdemotest@mail.com | Techuser |
