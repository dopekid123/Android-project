
Feature: Costing Flow for various regions and validating the same in Product and Plato

@costingFlow
Scenario Outline: Verify whether the lead source is recorded in Plato as SEO for Package itineraries which are traversed from Google

	When search the "<Query>" on google website 
	And click on the respective "<url>" showing on the results
	When Click on the "<clickOn>" button from the first package itinerary
 	Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
 	Then validate the itinerary is costed
 	Then Login into the plato using valid credentials and click on Sales dashboard
 	Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
 	Then Click on the Call Notes option to load the Call notes page
 	Then Click on Customer profile to validate the lead source as "<leadSource>"
 	
 	
	Examples: 
		|Query													|url																				|clickOn	|uName			|passwd|leadSource|
		|pickyourtrail greece packages	|https://pickyourtrail.com/packages/greece	|View Deal|8917374415 |666666|SEO				|

@costingFlow
 Scenario Outline: Verify whether the lead source is recorded in Plato as DIRECT for itinerary costed from our pickyourtrail.com
 
  Given launch the pickyourtrail website
 	Given Signup as a new user while creating itinerary for europe with "<region>", "<uName>", "<passwd>", and name "<name>"
  Then validate whether the Signup is successful
  Then Login into the plato using valid credentials and click on Sales dashboard
 	Then Search using itineraryId and validate the trail is showing on sales dashboard using "<uName>"
	Then Click on the Call Notes option to load the Call notes page
 	Then Click on Customer profile to validate the lead source as "<leadSource>"
  
  Examples: 
      |region      | uName     | passwd | name              |leadSource|
      | Europe     |9566605855 | 666666 | Signup PDG Europe |direct		 |
 


  Scenario Outline: Verify whether the itinerary is recorded in Plato after costing in the Product for MLE flow
  
  When search the "<Query>" on google website 
  And click on the respective "<url>" showing on the results
  Given Signup as a new user while creating itinerary for MLE with "<url>", "<uName>", "<passwd>", and name "<name>"
  Then validate whether the Signup is successful
  Then Login into the plato using valid credentials 
	Then Search the trail using itineraryId and validate the trail is showing on plato dashboard using "<uName>"
  
  
    Examples: 
      |Query                               | url                                             | uName     | passwd | name           |
      |pickyourtrail maldives-tour-packages| https://pickyourtrail.com/maldives-tour-packages|9566605855 | 666666 | Signup for MLE |
      
      

  Scenario Outline: Verify whether the itinerary is recorded in Plato after costing in the Product for Dubai flow
  
  When search the "<Query>" on google website 
  And click on the respective "<url>" showing on the results
  Given Signup as a new user while creating itinerary for dubai with "<region>", "<url>", "<uName>", "<passwd>", and name "<name>"
  Then validate whether the Signup is successful
  Then Login into the plato using valid credentials 
	Then Search the trail using itineraryId and validate the trail is showing on plato dashboard using "<uName>"
	
	    Examples: 
      |Query              | region | uName      | passwd | url                                     | name             |
      |pickyourtrail      | dubai  | 9566605855 | 666666 | https://pickyourtrail.com               | Signup PDG Dubai |
 