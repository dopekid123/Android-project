@loginRevamp @SanityTest
Feature: Signup flow validation across the product


Scenario Outline: signup validation on landing page
	Then signup from landing page using "<name>" and "<emailid>" and "<mobileno>" 
	
	Examples: 
		|name|emailid|mobileno|
		|usergreece1|usergreece8079433178@pyt.com|8079433178|

		

Scenario Outline: signup validation via PDG flow GCM using Get trip cost CTA for long haul destination
Then Signup as new user from GCM page with "<region>" using "<name>" and "<emailid>" and "<mobileno>" 
	
	Examples: 
		|region|name|emailid|mobileno|
		|Europe|usergreece2|usergreece7931351509@pyt.com|7931351509|


Scenario Outline: Signup validation as a new user from header login from itinerary page
Given Signup as new user from header login link in itinerary page with "<region>" using "<name>" and "<emailid>" and "<mobileno>"

Examples: 
		|region|name|emailid|mobileno|
		|Europe|usergreece3|usergreece8072784636@pyt.com|8072784636|
		
		

Scenario Outline: Signup validation as a new user from Packages page v1
Given Signup as new user from Packages page v-one with "<region>" using "<name>" and "<emailid>" and "<mobileno>" 

Examples:
|region|name|emailid|mobileno|
|Maldives|usergreece4|usergreece8240455876@pyt.com|8240455876|



Scenario Outline: Signup validation as a new user from Packages page v2
Given Signup as new user from Packages page v-two with "<region>" using "<name>" and "<emailid>" and "<mobileno>" 

Examples:
|region|name|emailid|mobileno|
|Dubai|usergreece5|usergreece7193819144@pyt.com|7193819144|



Scenario Outline: Signup validation as a new user from vacations page
Given Signup as new user from vacations page with "<region>" using "<name>" and "<emailid>" and "<mobileno>" 

Examples:
|region|name|emailid|mobileno|
|Australia|usergreece6|usergreece7337036724@pyt.com|7337036724|


#speedboat signup flow 
Scenario Outline: Signup validation as a new user from speedboat flow page
  And Navigate to landing page for "<region>"
    Then Verify that landing page is loaded as expected
    Then Enter the departure location as "<departFrom>"
    And Enter the departure date
    Then Search for all available packages
    Then Verify that valid results are displayed in listing page
    Then Signup as new user from speedboat listing page using "<name>" and "<emailid>" and "<mobileno>" 
    
Examples:
 | region   | departFrom |name|emailid|mobileno|
 | Maldives | Chennai    |usergreece7|usergreece7525984983@pyt.com|7525984983|

    
    