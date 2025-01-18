@cbrloginsignup @regression 
Feature: Validating Login Feature
  Verify that the Login feature is working across the product

  @sanityforloginsignUp @sanity
  Scenario Outline: Validate whether login is successful through the "View Deal" button
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed

    #Then Login into the plato using valid credentials and click on Sales dashboard
    #Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/australia | View Deal | 8917374415 | 666666 |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Validate whether login is unsuccessful for valid mobile number and incorrect OTP through the "View Deal" button
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and invalid password with "<uName>" and "<passwd>"

    Examples: 
      | packages        | clickOn   | uName      | passwd |
      | packages/europe | View Deal | 6383589200 | 666667 |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Validate whether login is unsuccessful with invalid mobile number through the "View Deal" button
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through "<page>" with invalid username and password with "<uName>" and "<passwd>"

    Examples: 
      | packages           | clickOn   | uName    | passwd | page     |
      | packages/australia | View Deal | 11111111 | 666666 | packages |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Validate whether the application traverses back to the Packages page (no confirmation popup) after closing the OTP screen in Packages Page (View Deal)
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Given Enter a valid mobile number "<uName>" in "<page>" and page should navigate to the OTP screen
    And Close the OTP dialog box and validate whether there is no confirmation popup appears in packages

    Examples: 
      | packages      | clickOn   | uName      | page     |
      | packages/europe | View Deal | 8917374415 | packages |

  #Scenario Outline: Validate whether the Resend OTP functionality works in Packages Page (View Deal)
  #
  #Given User navigates to the "<packages>" page
  #When Click on the "<clickOn>" button from the first package itinerary
  #Given Enter a valid mobile number "<uName>" and page should navigate to the OTP screen
  #When Click on Resend OTP button and wait for 20 seconds
  #Then Enter the resent "<passwd>" to login to the application
  #Then validate whether the login is successful
  #
  #
  #Examples:
  #	|packages       |clickOn  |uName			|
  #	|packages/bali  |View Deal |8917374415	|
  @sanityforloginsignUp @sanity
  Scenario Outline: Validate whether the user is able to change the mobile number from the OTP screen in Packages Page (View Deal)
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen in packages
    When Click on the edit icon for changing the mobile number in packages page
    Then Login to the application with valid second number "<secondNo>" and password "<passwd>"
    Then validate the itinerary is costed

    Examples: 
      | packages        | clickOn   | uName      | secondNo   | passwd | name               |
      | packages/europe | View Deal | 9566605855 | 8917374415 | 666666 | Test change number |

  #Scenario Outline: Validate whether login is successful through the package slug
  #Given User navigates to the "<packages>" page
  #When Click on the "<clickOn>" button from the first package itinerary
  #Then Login to the application with valid username and password with "<uName>" and "<passwd>"
  #Then validate the itineary is costed
  #
  #
  #Examples:
  #	|packages       |clickOn |uName|passwd|
  #	|packages/bali  |slug    |8917374415	|666666|
  @loginWithProdOtp @sanityforloginsignUp @sanity
  Scenario Outline: Validating whether OTP is getting generated and sent by the SMS provider.
    Given Hit the Post API to fetch the OTP and validate whether OTP is sent

    # 	Then Login to the application with valid username "<uName>" and with the generated OTP
    #	Then validate whether the login is successful
    Examples: 
      | uName      |
      | 9080934240 |

  Scenario Outline: Login validation as a existing user in europe flow (PDG)
    Given Login as a existing user while creating itinerary for europe with "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful

    Examples: 
      | region | uName      | passwd |
      | Europe | 8917374415 | 666666 |

  Scenario Outline: Login validation as a existing user in europe flow (PDG) with Paris Barcelona city
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |

  Scenario Outline: Login validation as a existing user in Thainad flow (PDG)
    Given Login as a existing user while creating itinerary for Thailand "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful

    Examples: 
      | region   | uName      | passwd |
      | Thailand | 6383589200 | 666666 |

  @LoginMLE
  Scenario Outline: Login validation as a existing user in MLE flow
    Given Login as a existing user while creating itinerary for MLE with "<url>", "<uName>" and "<passwd>"
    And validate whether the login is successful and successfully created the itinerary

    Examples: 
      | url                                              | uName      | passwd |
      | https://pickyourtrail.com/maldives-tour-packages | 6383589200 | 666666 |
