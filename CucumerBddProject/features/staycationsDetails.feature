@staycation
Feature: Staycation Details page validation

#Note : The URL on the data its not constant so we need to update the data according to the
#scenarios used - If any bugs found first check data

#Not customizable deal in the data
Scenario Outline: Verify if the deal have customizable room option or not
  Given Login as a authenticated user
  Then Navigate to respective "<deals>" via URL
  #Then Select the "<deals>" from best-staycation deals listing page
  Then validate whether the deal is customizable deal or not
  
  Examples:
  |deals|
  |book-2-nights-stay-at-the-ibnii-eco-luxury-resort-coorg-and-get-the-third-night-free-with-all-meals-activities|

#Customizable deal in the data
Scenario Outline: Verify if the deal have customizable room option or not
  Given Login as a authenticated user
  Then Navigate to respective "<deals>" via URL
  Then validate whether the deal is customizable deal or not
  
  Examples:
  |deals|
  |2-nights-stay-at-the-serai-kabini|
  
 

 #This testcase is to validate whether user able to change the no.of.nights for default room type.
 Scenario Outline: Change the default night option on the current selection resort room option
  Given Login as a authenticated user
  Then Navigate to respective "<deals>" via URL
  Then validate whether the deal is customizable deal or not
  Then Change the default night option on the current room option
  
  Examples:
  |deals| 
  |2-nights-stay-at-the-serai-kabini|
  

Scenario Outline: Verify if user able to select the alternate room in the same resort
  Given Login as a authenticated user
 Then Navigate to respective "<deals>" via URL
  Then validate whether the deal is customizable deal or not
  Then change the default room type with alternate room type
  
  
  Examples:
  |deals|
  |a-divine-stay-at-radisson-blu-temple-bay-with-breakfast-dinner|  
    
 
Scenario Outline: Verify if user changes the nights the price needs to be changed
  Given Login as a authenticated user
  Then Navigate to respective "<deals>" via URL
  Then validate whether the deal is customizable deal or not
  Then change the no.of.nights and validate the price got changed or not
  
  
  Examples:
  |deals|
  |2-nights-stay-at-the-serai-kabini|  

#Commenting out this scenario -  Deals listing page has been changed
#Scenario Outline: Verify the user able to navigate to deals details page for indian static deal
#Given  Login as a authenticated user
#Then Navigate to deals staycation page
#Then Choose the "<destination>" from the destination filter
#Then Click on the city card
#Then Verify if user navigated to respective deals details page
  #
  #Examples:
  #|destination|
  #|India|
   
   
Scenario Outline: Validate if user can able to change the date for the selected deal
Given  Login as a authenticated user
Then Navigate to respective "<deals>" via URL
#Then Choose the "<destination>" from the destination filter
#Then Click on the city card
#Then Verify if user navigated to respective deals details page
Then Click on the date field and change the date and verify the date is got selected
Then Verify the dates are get changed in passenger details screen

  
  Examples:
  |deals|
  |2-nights-stay-at-the-serai-kabini| 
  
#Commenting out this scenario -  Deals listing page has been changed - Need to add new TC
 #Scenario Outline: Verify the user able to navigate to deals details page 
 #Given  Login as a authenticated user
 #Then Navigate to deals staycation page
 #Then Choose the "<destination>" from the destination filter
 #Then Click on the city card
 #Then Verify if user navigated to respective deals details page
#Examples:
  #|destination|
  #|Maldives|
  #|India|
  
Scenario Outline: Validate the adult count field on the deals details page
Given  Login as a authenticated user
Then Navigate to respective "<deals>" via URL
#Then Navigate to deals staycation page
#Then Choose the "<destination>" from the destination filter
#Then Click on the city card
#Then Verify if user navigated to respective deals details page
Then validate the adult count field on the deals details page
Then verify the adult count details on passenger screen
  
 Examples:
  |deals|
  |2-nights-stay-at-the-serai-kabini| 
  

Scenario Outline: Verify the total price on the deals details page and validate the same on passenger screen 
Given  Login as a authenticated user
Then Navigate to respective "<deals>" via URL
#Then Navigate to deals staycation page
#Then Choose the "<destination>" from the destination filter
#Then Click on the city card
#Then Verify if user navigated to respective deals details page
Then Validate the total price on deals details page
Then Verify the price on passenger screen
  
 Examples:
  |deals|
|a-divine-stay-at-radisson-blu-temple-bay-with-breakfast-dinner|
 

Scenario Outline: Verify the total price and striked price present in the details page and same on passenger screen
Given  Login as a authenticated user
Then Navigate to respective "<deals>" via URL
#Given  Login as a authenticated user
#Then Navigate to deals staycation page
#Then Choose the "<destination>" from the destination filter
#Then Click on the city card
#Then Verify if user navigated to respective deals details page
Then Validate the striked price on deals details page
Then Verify the striked price on passenger screen
  
 Examples:
  |deals|
  |2-nights-stay-at-the-serai-kabini| 
  


  