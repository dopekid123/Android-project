@sanityforloginsignUp @cbrloginsignup @regression @sanity

Feature: Validating Signup Feature
  Verify that the Signup feature is working across the product

  # Validating Header Signup
  # Valid Mobile Number and OTP
  
     # Signup PDG through Europe 
   @sanityforloginsignUp
   Scenario Outline: Signup validation as a new user in europe flow (PDG)
    Given Signup as a new user while creating itinerary for europe with "<region>", "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
     
    Examples: 
      | region | uName      | passwd | name |
      | Europe | 9566605855 | 666666 | Signup PDG Europe |
      
    
   
    @sanityforloginsignUp
  Scenario Outline: Signup validation as a new user in MLE flow
  	And Navigate to landing page for "<region>"
  	And Verify that landing page is loaded as expected
    Given Signup as a new user while creating itinerary for MLE listing with "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"

    Examples: 
      | uName      | passwd | region     | name           |
      | 9566605855 | 666666 | Maldives   | Signup for MLE |


   # Signup PDG through Dubai 
     @sanityforloginsignUp 
   Scenario Outline: Signup validation as a new user in dubai flow (PDG)
    Given Signup as a new user while creating itinerary for dubai with "<region>", "<url>", "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful
    Then Login into the plato using valid credentials and click on Sales dashboard
    Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
    

    Examples: 
      | region | uName      | passwd | url | name |
      | dubai  | 9566605855 | 666666 | https://pickyourtrail.com/customize/dxb | Signup PDG Dubai |
  
      
   
  # Signup validation as a new user from landing page
  @sanityforloginsignUp 
  Scenario Outline: Signup validation as a new user from landing page 
    Given Signup to the application with valid username and password with "<uName>", "<passwd>", and name "<name>"
    Then validate whether the Signup is successful 

    Examples: 
      | uName      | passwd | name | 
      | 9566605855 | 666666 | Valid Signup |
      

  # Signup should be unsuccessful with valid mobile number and incorrect OTP
  @sanityforloginsignUp 
  Scenario Outline: Signup should be unsuccessful with valid mobile number and incorrect OTP
    Given Signup to the application with valid username and invalid password with "<uName>", "<invalidPasswd>" and name "<name>"
    Then validate whether the Signup is unsuccessful

    Examples: 
      | uName      | invalidPasswd | name |
      | 9566605855 | 666688        | Signup with invalid otp |
      

  # Signup should be unsuccessful with invalid mobile number
  @sanityforloginsignUp 
  Scenario Outline: Signup should be unsuccessful with invalid mobile number
    Given Signup to the application with invalid username with "<invalidUName>"
    Then validate whether the Signup is unsuccessful

    Examples: 
      | invalidUName |
      | 1111111111   |
      

  # Closing OTP Screen
  @sanityforloginsignUp 
  Scenario Outline: Validate whether the application traverses back to the Home page after closing the OTP screen
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen
    And Close the OTP dialog box and validate whether the confirmation popup appears
    Then Click on No button to traverse back to the OTP screen
    And Close the OTP dialog box and validate whether the confirmation popup appears
    Then Again click on Yes button to navigate to the Home page

    Examples: 
      | uName      | name |
      | 9566605855 | Closing otp test |
      

  # Resend OTP
  @sanityforloginsignUp 
  Scenario Outline: Validate whether the Resend OTP functionality works
    Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen
    When Click on Resend OTP button and wait for 20 seconds
    Then Enter the resent "<passwd>" to Signup to the application
    Then validate whether the Signup is successful

    Examples: 
      | uName      | passwd | name |
      | 9566605855 | 666666 | Resend OTP Test |
      

  # Changing Mobile Number
  #Scenario Outline: Validate whether the user is able to change the mobile number from the OTP screen
    #Given Signup to the application with valid username "<firstNo>" and name "<name>"
    #When Click on the edit icon for changing the mobile number
    #Then Signup to the application with valid username, password and name with "<secondNo>" , "<passwd>" and "<secName>"
    #Then validate whether the Signup is successful
#
    #Examples: 
      #| firstNo    | secondNo   | passwd | name | secName |
      #| 9566605855 | 9176054867 | 666666 | Testing Changing mobile | Entering second mobile number |


  # Signup with Expired OTP (Commenting because we are satisfying the intended functionality)
  #@sanityforloginsignUp
  #Scenario Outline: Validate successful signup with expired otp
   #Given Enter a valid mobile number "<uName>" and name "<name>" page should navigate to the OTP screen
   #When Click on Resend OTP button and wait for 20 seconds
   #Then Enter the resent "<passwd>" to Signup to the application
   #Then validate whether the Signup is unsuccessful
  #
   #Examples: 
   #| uName      | passwd | name |
   #| 9566605855 | 666668 | Signup with expired OTP |  