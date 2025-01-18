@FAS @Login @RegressionTest @Set2 @loginRevamp
Feature: Validating Login Feature
  Verify that the Login feature is working across the product

  #Login validation in GCM page 
  @SmokeTest @RegressionTest @Test 
  Scenario Outline: Login validation in GCM page
    Then Login to the application with valid username and password with "<uName>" and "<passwd>"
    Then Logout and navigate to home page
    Then Login from signup modal by entering registered user data and then logging in
    Then Logout and navigate to home page
    Then Login to the application with valid username and invalid password with "<uName>" and "<invalidPasswd>"
    Then Login to the application with invalid username and valid password with "<invalideUserName>" and "<passwd>"
    Given Login as a authenticated user from GCM page with "<region>"

    Examples: 
      | region    | uName      | passwd      | invalideUserName | invalidPasswd  |
      | Australia | 9344700243 | travelisfun |       9876543210 | JustAJunkValue |

  #Login Validation from Landing page via already have an account 
  @RegressionTest 
  Scenario: Login Validation from the signup modal by choosing Already have an account
    Then Login from signup modal via Already have an account CTA with valid credentials
    Then Logout and navigate to home page
    Then Login from signup modal via Already have an account CTA with invalid username
    Then Login from signup modal via Already have an account CTA with invalid password
    Then Login from signup modal via Already have an account CTA with invalid credentials

  #Header Login validation from Itinerary page 
  @RegressionTest 
  Scenario Outline: Login validation from Itinerary page header login via already got an account
    Given Login from Itinerary page using Header login via already got an account with "<region>"
    Then Logout and navigate to home page
    Given Regular login through headers login from Itinerary page with "<region>"

    Examples: 
      | region    |
      | Australia |

  #Header Login validation from packages pages
  #Commenting the four lines since the header login is removed from /packages page 
  @RegressionTest  
  Scenario Outline: Login validation from packages page header login
    Given Login from package page using Header login via already got an account with "<region>"
    Then Logout and navigate to home page
    Given Regular login through headers login from packages page with "<region>"
    Then Logout and navigate to home page
    Given Login from packages page using customize option "<region>"
    Then Logout and navigate to home page

    Examples: 
      | region    |
      | Australia |

  #Login validation from Paid campaign pages 
  @RegressionTest 
  Scenario Outline: Login using customize option from any one of the packages in Australia paid campaign page in PYT
    Given Login from paid campaign page using custiomize option via already got an account with "<region>"
    Then Logout and navigate to home page
    Given Login from paid campaign page via Signup as existing user with "<region>"
    Then Logout and navigate to home page
    Given Login from paid campaign page via GCM Signup with "<region>"

    Examples: 
      | region    |
      | Australia |

  #Login validation from PDG flow using GCM 
  @RegressionTest  @SanityTest 
  Scenario Outline: Login validation from PDG Flow using GCM via already got an account
    Given Login from PDG Flow using GCM via already got an account with "<region>"
    Then Logout and navigate to home page for "<Url>" 
    Given Login from PDG Flow using GCM via Signup as existing user with "<region>"

    Examples: 
      | region    |Url|
      | Australia |au |
      
  
