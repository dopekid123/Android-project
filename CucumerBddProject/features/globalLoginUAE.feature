Feature: Global user login scenarios for UAE


Scenario Outline: Global user GCM-login through PDG flow
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And Global user signup and login flow for "<Fields>" 
	And Check an itinerary got successfully costed 
	
	Examples: 
		| Destination| region |Fields|
		| UAE | Europe |ExistingMailandMobile|
#		| UnitedArabEmirates | Europe |ExistingMail|
		
Scenario Outline: Global user login using home page header 
	Given Login as a authenticated global user "<user>"
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And Global user fills the gcm form "<Nationality>" 
	And Check an itinerary got successfully costed 
	Examples: 
		| Destination| region |Nationality|user|
		| UnitedArabEmirates | Europe |Andorra|uae|

			
Scenario Outline: Global user GCM-login through packages page flow
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Then User navigate to packages page "<region>"
	And Global user fills the gcm form for packages page "<Fields>" 
	And Check an itinerary got successfully costed 
	Examples: 
		| Destination |Fields|region |
		| UnitedArabEmirates |ExistingMailandMobile| Europe |
#		| UnitedArabEmirates |ExistingMail|

		
Scenario Outline: Global user header login through package page flow
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Then Login from package page using Header login via already got an account with "<region>"
   Examples: 
		| Destination |region|
		| UnitedArabEmirates |Europe|
		
		
Scenario Outline: Global user header login through PDG flow
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given Regular login through headers login from Itinerary page with "<region>"
	
	 Examples: 
		| Destination |region|
		| UnitedArabEmirates |Europe|
		

Scenario Outline: Global user GCM-login through PDG flow validate mobile no is mandatory field
	When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And Global user signup and login flow for "<Fields>" 
#	And Check an itinerary got successfully costed // This step is not required because get-cost will be disabled in the previous step itself

	Examples: 
		| Destination| region |Fields|
		| UnitedArabEmirates | Europe |ExistingMailAE|

@globalLoginTest	
Scenario Outline: Global user login for UAE using home page header with valid username and password
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login as a authenticated global user "<user>"
	Then validate whether user logged in successfully


	Examples: 
		| Destination	| user			| 
		| UAE 				| uae 			|
		| UAE 				| adminuae 	|

@globalLoginTest
Scenario Outline: Global user login for UAE using home page header with valid username and incorrect password
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login with valid "<username>" and incorrect "<password>" for global "<user>"
	Then Login should be unsuccessful for global for incorrect password


	Examples: 
		| Destination	| user 	| username			| password|
		| UAE 				|  uae	|	8610957812		| 123			|
		
@globalLoginTest
Scenario Outline: Global user login for UAE using home page header with invalid username and incorrect password
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login with valid "<username>" and incorrect "<password>" for global "<user>"
	Then Login should be unsuccessful for global for incorrect username and incorrect password


	Examples: 
		| Destination	| user 	| username			| password|
		| UAE 				|  uae	|	861095781		| 123			|

@globalLoginTest	
Scenario Outline: Validate whether the application traverses back to the Home page after closing the login screen for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Validate whether closing the login screen traverses back to the global home page


	Examples: 
		| Destination	| user 	| username			| password|
		| UAE 				|  uae	|	8610957812		| 123			|

@globalLoginTest		
Scenario Outline: Validate whether entering incorrect mobile number throws error in Forgot password screen for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Then Validate whether entering incorrect mobile number throws error in Forgot password screen for global


	Examples: 
		| Destination	| user 	|
		| UAE 				|  uae	|

@globalLoginTest		
Scenario Outline: Validate whether the costing is happening through the View Deal button of packages page for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password				|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|

@globalLoginTest
Scenario Outline: Validate whether costing is not happening when we enter incorrect password with valid email in the packages page for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and incorrect credentials "<mobileNo>" "<password>" "<countryCode>"
	Then Login should be unsuccessful for global for incorrect password for "<countryCode>" 

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password			|countryCode|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|1234					|+91				|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|1234					|+971				|

@globalLoginTest
Scenario Outline: Admin - Validate whether costing is not happening when we enter incorrect password with valid email in the packages page for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and incorrect credentials "<mobileNo>" "<password>" "<countryCode>"
	Then Login should be unsuccessful for global for incorrect password for "<countryCode>" 

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password			|countryCode|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travel				|+91				|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travel				|+971				|

@globalLoginTest
Scenario Outline: Validate whether costing is not happening when we enter incorrect mobileNo with valid email in the packages page for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and incorrect mobileNo "<mobileNo>" "<password>" "<countryCode>" "<incorrectMobileNo>"
	Then Login should be unsuccessful for global for incorrect mobileNo for "<countryCode>" 

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password			|countryCode|incorrectMobileNo|
		| packages/australia 	| View Deal |UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|1234					|+91				|861095781				|

@globalLoginTest
Scenario Outline: Validate whether the costing is happening for MLE as logged in user in PDG flow for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Given Login as a authenticated global user "<user>"
	Then validate whether user logged in successfully
	And Navigate to global landing page for "<region>"
  And Verify that landing page is loaded as expected
	When Click on the "<clickOn>" button from the first package itinerary
	And Validate whether the costing has happened successfully for global
	

		Examples: 
		| Destination	| user			| region	|clickOn				|passengerName|	mailId												|mobileNo		|password				|
		| UAE 				| uae 			|Maldives	|View Details		|UAETest			|krithikanalluraj25@gmail.com 	|8610957812	|12345					|
		| UAE 				| adminuae 	|Maldives	|View Details		|UAETest			|meenatchi@pickyourtrail.com 		|6383589200	|travelisfun		|
	
@globalLoginTest		
Scenario Outline: Validate whether the login and costing is happening for MLE by entering Lead passenger info in PDG flow for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	And Navigate to global landing page for "<region>"
  And Verify that landing page is loaded as expected
	When Click on the "<clickOn>" button from the first package itinerary
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global
	

		Examples: 
		| Destination	| user			| region	|clickOn				|passengerName|	mailId											|mobileNo		|password				|
		| UAE 				| uae 			|Maldives	|View Details		|UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| UAE 				| adminuae 	|Maldives	|View Details		|UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|

@globalLoginTest
Scenario Outline: Validate whether the costing is happening for Thailand by entering Lead passenger info in PDG flow for UAE locale
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
		| UAE 				| uae 			|Thailand	|UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
#		| UAE 				| adminuae 	|Thailand	|UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|

@globalLoginTest
Scenario Outline: Validate whether the costing is happening for Europe through the slug of packages page for UAE locale
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not
	Given User navigates to the global "<packages>" page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global

	Examples: 
		| packages        		| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password				|
		| packages/europe 		| slug 			|UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| packages/europe 		| slug 			|UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|