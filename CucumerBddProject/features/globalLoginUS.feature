@globalLoginTest
Feature: Global user login scenarios for US


Scenario Outline: Global user login for US using home page header with valid username and password
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login as a authenticated global user "<user>"
	Then validate whether user logged in successfully


	Examples: 
		| Destination	| user			| 
		| US 					| us 				|
		| US 					| adminus 	|
		

Scenario Outline: Global user login for US using home page header with valid username and incorrect password
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login with valid "<username>" and incorrect "<password>" for global "<user>"
	Then Login should be unsuccessful for global for incorrect password


	Examples: 
		| Destination	| user 	| username			| password|
		| US 					|  us 	|	8610957812		| 7890		|
		

Scenario Outline: Global user login for US using home page header with invalid username and incorrect password
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login with valid "<username>" and incorrect "<password>" for global "<user>"
	Then Login should be unsuccessful for global for incorrect username and incorrect password


	Examples: 
		| Destination	| user 	| username			| password|
		| US 					|  us		|	861095781			| 123			|

Scenario Outline: Validate whether the application traverses back to the Home page after closing the login screen for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Validate whether closing the login screen traverses back to the global home page


	Examples: 
		| Destination	| user 	| username			| password|
		| US 					|  us		|	8610957812		| 123			|
		
Scenario Outline: Validate whether entering incorrect mobile number throws error in Forgot password screen for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Then Validate whether entering incorrect mobile number throws error in Forgot password screen for global


	Examples: 
		| Destination	| user 	|
		| US 					|  us		|
		
Scenario Outline: Validate whether the costing is happening through the View Deal button of packages page for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password				|
		| packages/australia 	| View Deal |US 					|  USTest				|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| packages/australia 	| View Deal |US 					|  USTest				|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|

Scenario Outline: Validate whether costing is not happening when we enter incorrect password with valid email in the packages page for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and incorrect credentials "<mobileNo>" "<password>" "<countryCode>"
	Then Login should be unsuccessful for global for incorrect password for "<countryCode>" 

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password			|countryCode|
		| packages/australia 	| View Deal |US 					|  USTest			|meenatchi@pickyourtrail.com 	|8610957812	|1234					|+91				|
		| packages/australia 	| View Deal |US 					|  USTest			|meenatchi@pickyourtrail.com 	|8610957812	|1234					|+971				|


Scenario Outline: Admin - Validate whether costing is not happening when we enter incorrect password with valid email in the packages page for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and incorrect credentials "<mobileNo>" "<password>" "<countryCode>"
	Then Login should be unsuccessful for global for incorrect password for "<countryCode>" 

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password			|countryCode|
		| packages/australia 	| View Deal |US 					|  USTest			|meenatchi@pickyourtrail.com 	|6383589200	|travel				|+91				|
		| packages/australia 	| View Deal |US 					|  USTest			|meenatchi@pickyourtrail.com 	|6383589200	|travel				|+971				|


Scenario Outline: Validate whether costing is not happening when we enter incorrect mobileNo with valid email in the packages page for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and incorrect mobileNo "<mobileNo>" "<password>" "<countryCode>" "<incorrectMobileNo>"
	Then Login should be unsuccessful for global for incorrect mobileNo for "<countryCode>" 

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password			|countryCode|incorrectMobileNo|
		| packages/australia 	| View Deal |US 					|  USTest				|meenatchi@pickyourtrail.com 	|8610957812	|1234					|+91				|861095781				|

	
Scenario Outline: Validate whether the costing is happening for MLE as logged in user in PDG flow for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login as a authenticated global user "<user>"
	Then validate whether user logged in successfully
	And Navigate to global landing page for "<region>"
  And Verify that landing page is loaded as expected
	When Click on the "<clickOn>" button from the first package itinerary
	And Validate whether the costing has happened successfully for global
	

		Examples: 
		| Destination	| user			| region	|clickOn			|passengerName|	mailId												|mobileNo		|password				|
		| US					| us 				|Maldives	|View Details	|USTest				|krithikanalluraj25@gmail.com 	|8610957812	|12345					|
		| US					| adminus 	|Maldives	|View Details	|USTest				|meenatchi@pickyourtrail.com 		|6383589200	|travelisfun		|
		
Scenario Outline: Validate whether the login and costing is happening for MLE by entering Lead passenger info in PDG flow for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And Navigate to global landing page for "<region>"
  And Verify that landing page is loaded as expected
	When Click on the "<clickOn>" button from the first package itinerary
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global
	

		Examples: 
		| Destination	| user			| region	|clickOn				|passengerName|	mailId											|mobileNo		|password				|
		| US 					| us				|Maldives	|View Details		|USTest				|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| US 					| adminus 	|Maldives	|View Details		|USTest				|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|
		

Scenario Outline: Validate whether the costing is happening for Thailand by entering Lead passenger info in PDG flow for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And Navigate to global landing page for "<region>"
	Then Enter the details for Global PDG flow for Thailand
  Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global
		#Admin not working for thailand, so commented
  
  Examples: 
		| Destination	| user			| region	|passengerName|	mailId											|mobileNo		|password				|
		| US 					| us 				|Thailand	|USTest				|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
#		| US 					| adminus 	|Thailand	|USTest				|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|


Scenario Outline: Validate whether the costing is happening for Europe through the slug of packages page for US locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password				|
		| packages/europe 		| slug 			|US 					|  USTest				|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| packages/europe 		| slug 			|US 					|  USTest				|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|