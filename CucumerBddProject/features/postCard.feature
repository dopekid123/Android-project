@FAS @RegressionTest @Postcard @Set3  
Feature: Validation of Post card Feature

@SmokeTest @Test
Scenario: Validate The Postcard For Logged In User 
Given Login as a authenticated user
When  user typing unsupported destination
And   user selecting vacation details in the postcard page
And   check the name and email and phone number field is disabled
Then  validate the postcard submitted successfully

#Commented out the signup scenario due to data dependency
#@SmokeTest
#Scenario Outline: Validate The Postcard For New User
#Given user land on home page without login
#When  user typing unsupported destination
#And   user selecting vacation details in the postcard page
#And   user type the new name number and email "<name>","<number>","<email>"
#Then  validate the postcard submitted successfully
#Then  verify the user should logged in successfully
#
#Examples:
#|name|email|number|
#|Newpost|newemailgsgs@gmail.com|6383534200|
#
# 

#Submit Postcard With New Number and Registered Email
#Submit Postcard With Registered Number and New Email 
Scenario Outline: Submit Postcard With Combination of New and Registered Credential
Given user land on home page without login
When  user typing unsupported destination
And   user selecting vacation details in the postcard page
And   user type the new name number and email "<name>","<number>","<email>"
Then   Validate the alert message
Examples:
|name|email|number|
|old mail new num|meenatchi@pickyourtrail.com|9399332233|
|new mail old num|postcardoldmail@gsgs.com|6383589200|



Scenario: Validate The Postcard For Inside India
Given user land on home page without login
When  user typing city inside city
And   submit user name and email id details
Then validate the success response


