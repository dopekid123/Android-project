@cbrloginsignup @regression 
Feature: Validating Login Feature
  Verify that the Login feature is working across the product

  @sanityforloginsignUp @sanity 
  Scenario Outline: Login should be successful with valid username and OTP
    Then Login to the application with valid username and password with "<uName>" and "<passwd>"
    Then validate whether the login is successful

    Examples: 
      | uName      | passwd |
      | 8917374415 | 666666 |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Login should be unsuccessful with valid mobile number and incorrect OTP
    Then Login to the application with valid username and password with "<uName>" and "<passwd>"
    Then validate whether the Signup is unsuccessful

    Examples: 
      | uName      | passwd |
      | 8917374415 | 666688 |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Login should be unsuccessful with invalid mobile number
    Then Login to the application through "<page>" with invalid username and password with "<uName>" and "<passwd>"

    Examples: 
      | uName      | passwd | page |
      | 1234567890 | 666688 | home |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Validate whether the application traverses back to the Home page after closing the OTP screen
    Given Enter a valid mobile number "<uName>" in "<page>" and page should navigate to the OTP screen
    And Close the OTP dialog box and validate whether the confirmation popup appears in packages
    Then Click on No button to traverse back to the OTP screen
    And Close the OTP dialog box and validate whether the confirmation popup appears in packages
    Then Again click on Yes button to navigate to the Home page

    Examples: 
      | uName      | page |
      | 8917374415 | home |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Validate whether the Resend OTP functionality works
    Given Enter a valid mobile number "<uName>" in "<page>" and page should navigate to the OTP screen
    When Click on Resend OTP button and wait for 20 seconds
    Then Enter the resent "<passwd>" to login to the application
    Then validate whether the Signup is successful

    Examples: 
      | uName      | passwd | page |
      | 8917374415 | 666666 | home |

  @sanityforloginsignUp @sanity 
  Scenario Outline: Validate whether the user is able to change the mobile number from the OTP screen
    Given Enter a valid mobile number "<firstNo>" in "<page>" and page should navigate to the OTP screen
    When Click on the edit icon for changing the mobile number in packages page
    Then Change to "<secondNo>" "<passwd>" and  and proceed with login
    #Then validate whether the login is successful
    Then validate whether the Signup is successful

    Examples: 
      | firstNo    | secondNo   | passwd | page |
      | 8917374415 | 8917374415 | 666666 | home |