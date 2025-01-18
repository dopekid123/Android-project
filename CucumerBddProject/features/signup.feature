@Signup   
Feature: Validating Signup Feature
  Verify that the Signup feature is working across the product

@SmokeTest @test
Scenario: Signup validation as a new user from landing page
Given Signup as a new user from landing page

  
Scenario: Signup validation as a existing user from landing page
Given Signup as a existing user from landing page

 
Scenario: Signup validation with old email Id from landing page
Given Signup with existing email ID and new mobile number from landing page

 
Scenario: Signup validation with old mobile no from landing page
Given Signup with new email ID and existing mobile number from landing page



#Following three scenarios validates the signup in the itinerary page via GCM,CTC,Headerlogin

#This test case validates the signup via GCM using Get trip cost CTA

  @SmokeTest
Scenario Outline: Signup validation as a new user using GCM
Given Signup as new user from GCM page with "<region>"

Examples:
|region|
|Bali|

#This test case validates the signup via GCM using Calculate trip cost CTA

 
Scenario Outline: Signup validation as a new using CTC 
Given Signup as new user via Calculate trip cost CTA with "<region>"
Examples:
|region|
|Bali|


#This test case validates the signup via Header login

 
Scenario Outline: Signup validation as a new user from header login from itinerary page
Given Signup as new user from header login link in itinerary page with "<region>"
Examples:
|region|
|Bali|


#This test case validates the signup via GCM using Customize CTA in Packages page

 
Scenario Outline: Signup validation as a new user from Packages page
Given Signup as new user from Packages page with "<region>"
Examples:
|region|
|Bali|



#This test case validates the signup via Header login from packages page

@SmokeTest
Scenario Outline: Signup validation as a new user from header login from packages page
Given Signup as new user from header login link in packages page with "<region>"

Examples:
|region|
|Bali|



#This test case validates the signup via GCM using Customize CTA in Vacations page

@SmokeTest
Scenario Outline: Signup validation as a new user from Vacations page
Given Signup as new user from Vacations page with "<region>"

Examples:
|region|
|Bali|


