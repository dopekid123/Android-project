@sanityforloginsignUp @cbrloginsignup @regression @sanity
Feature: Validating Signup Feature
  Verify that the Signup feature is working across the product

  # Validating Signup for packages
  # Signup through Packages
  @sanityforloginsignUp @testalldestination
  Scenario Outline: Validate whether Signup is successful through the "View Deal" button (Packages)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Then Signup to the application with valid username, name and password "<uName>", "<name>" and "<passwd>"
    Then validate the itinerary is costed
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | packages           | uName      | name                  | passwd |
      | packages/australia | 9176054867 | packages valid signup | 666666 |
      | packages/japan     | 9176054867 | packages valid signup | 666666 |
      | packages/singapore | 9176054867 | packages valid signup | 666666 |
      | packages/bali      | 9176054867 | packages valid signup | 666666 |

  # Signup with expired otp in Packages
  @sanityforloginsignUp
  Scenario Outline: Validate whether Signup with expired otp is unsuccessful through the "View Deal" button (Packages)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen in packages
    Then Wait for 32 seconds and enter "<passwd>"
    Then validate whether the Signup is unsuccessful

    Examples: 
      | packages           | uName      | name                 | passwd |
      | packages/australia | 9566605855 | Expired OTP packages | 666668 |

  # Signup with invalid OTP in Packages
  @sanityforloginsignUp
  Scenario Outline: Validate whether Signup is unsuccessful for valid mobile number and incorrect OTP through the "View Deal" button (Packages)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Then Signup to the application with valid username, name and invalid password "<uName>", "<invalidPasswd>" and "<name>"
    Then validate whether the Signup is unsuccessful

    Examples: 
      | packages        | uName      | invalidPasswd | name                    |
      | packages/europe | 9566605855 |        666688 | Signup with invalid OTP |

  # Signup with invalid mobile number in packages
  @sanityforloginsignUp
  Scenario Outline: Validate whether Signup is unsuccessful with invalid mobile number through the "View Deal" button (Packages)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Then Signup to the application with invalid username in packages with "<invaliduName>"
    Then validate whether the Signup is unsuccessful

    Examples: 
      | packages        | clickOn   | invaliduName |
      | packages/europe | View Deal |   1111111111 |

  # Closing otp Screen while signing up in Packages
  @sanityforloginsignUp
  Scenario Outline: Validate whether the application traverses back to the Packages page after closing the OTP screen in Packages Page (View Deal)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen in packages
    And Close the OTP dialog box and validate whether there is no confirmation popup appears in packages

    Examples: 
      | packages           | clickOn   | uName      | name                    |
      | packages/australia | View Deal | 9566605855 | closing otp in packages |

  # Resend OTP Functionality in Packages
  @sanityforloginsignUp
  Scenario Outline: Validate whether the Resend OTP functionality works in Packages Page (View Deal)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen in packages
    When Click on Resend OTP button and wait for 25 seconds in packages page
    Then Enter the resent "<passwd>" in packages to Signup to the application
    Then validate whether the Signup is successful and successfully created the itinerary through packages

    Examples: 
      | packages        | clickOn   | uName      | passwd | name                        |
      | packages/europe | View Deal | 9566605855 | 666666 | Resend OTP Test in Packages |

  # Changing Mobile Number while signup in packages
  @sanityforloginsignUp
  Scenario Outline: Validate whether the user is able to change the mobile number from the OTP screen in Packages Page (View Deal)
    Given User navigates to the "<packages>" page
    When Click on the View Deal button from the first package itinerary
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen in packages
    When Click on the edit icon for changing the mobile number in packages page
    Then Signup to the application with valid username and password with "<secondNo>", "<secondname>" and "<passwd>" in packages
    Then validate whether the Signup is successful and successfully created the itinerary through packages

    Examples: 
      | packages           | clickOn   | uName      | secondNo   | passwd | name               | secondname             |
      | packages/australia | View Deal | 9566605855 | 9566605855 | 666666 | Test change number | Signup with new number |

  # Signup through packages slug
  #@sanityforloginsignUp
  Scenario Outline: Validate whether Signup is successful through the package slug
    Given User navigates to the "<packages>" page
    When Click on the title from the first package itinerary
    Then Signup to the application with valid username, name and password "<uName>", "<name>" and "<passwd>" through slug.
    Then validate the itinerary is costed
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | packages        | uName      | passwd | name                         |
      | packages/europe | 9176054867 | 666666 | Signup through uncosted page |
