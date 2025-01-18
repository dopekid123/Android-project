Feature: Staycation deals pax details page validation


Scenario Outline: Verify the fields are disabled in the pax details page for logged in user
Given  Login as a authenticated user
Then Navigate to deals staycation page
Then Choose the "<destination>" from the destination filter
Then Click on the city card
Then Verify if user navigated to respective deals details page
Then Click the book this modal and verify the pax details fields are disabled


Examples:
  |destination|
  |India|
  
  
Scenario Outline: Verify the fields are disabled in the pax details page for logged in user in details page header
Then Navigate to deals staycation page
Then Choose the "<destination>" from the destination filter
Then Click on the city card
Then Verify if user navigated to respective deals details page
Then Login as a user on deals details page via header
Then Click the book this modal and verify the pax details fields are disabled

Examples:
  |destination|
  |India|
 
   
Scenario Outline: Verify the fields are disabled in the pax details page for newly signed in user in details page header
Then Navigate to deals staycation page
Then Choose the "<destination>" from the destination filter
Then Click on the city card
Then Verify if user navigated to respective deals details page
Then Sign up as a new user on deals details page via header
Then Click the book this modal and verify the pax details fields are disabled

Examples:
  |destination|
  |India|
 
 
Scenario Outline: Verify the fields are disabled in the pax details page for logged in user in details page header
Then Navigate to deals staycation page
Then Choose the "<destination>" from the destination filter
Then Click on the city card
Then Verify if user navigated to respective deals details page
Then Login as a user on deals details page 
Then Click the book this modal and verify the pax details fields are disabled

Examples:
  |destination|
  |India|
 
 
 Scenario Outline: Verify the fields are disabled in the pax details page for newly signed up user in details page header
Then Navigate to deals staycation page
Then Choose the "<destination>" from the destination filter
Then Click on the city card
Then Verify if user navigated to respective deals details page
Then Sign up as a new user via deals details page
Then Click the book this modal and verify the pax details fields are disabled


Examples:
  |destination|
  |India|
  
  
 