#@bannerCardGlobal

Feature: Validating all banner cards in UAE Home page


Scenario Outline: Validating Singapore banner card under Trending Destinations of UAE home page
  When  User selects the "<Destination>" from the global dropdown 
	Then Validate the respective "<Destination>" homepage is displaying or not 
	Then Click on Singapore banner card under Trending Destinations in global home page
	When Click on the "<clickOn>" button from the first package itinerary
	Then Click on View Price
	And Enter the valid passenger details "<passengerName>", "<mailId>" and credentials "<mobileNo>" "<password>"
	And Validate whether the costing has happened successfully for global

	Examples: 
		| Destination	| user			| clickOn   | Destination	| passengerName |mailId												|mobileNo		|password				|
		| UAE 				| uae 			|View Deal 	|UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|8610957812	|12345					|
		| UAE 				| adminuae 	|View Deal 	|UAE 					|  UAETest			|meenatchi@pickyourtrail.com 	|6383589200	|travelisfun		|

  
  
