@FAS @InclusionsFlow @RegressionTest @Flights @Set2 	
Feature: Validation of block card for flight 


Scenario Outline: Verify the block card for international flight 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And  Check an itinerary got successfully costed 
	And  get the date checkin and format the date 
	And  get the date checkout and format the date 
	And  fill the details of the flight block card for the international flight-round trip "<departureCityRoute1>","<arrivalCityRoute1>","<departureCityRoute2>","<arrivalCityRoute2>" 
	Then check the flight block card posted successfully 
	And remove the block car and verify removed successfully 
	
	Examples: 
		|departFrom|region|departureCityRoute1|arrivalCityRoute1|departureCityRoute2|arrivalCityRoute2|
		|Chennai|Europe|chennai|wanaka|wanaka|chennai|
		

Scenario Outline: Verify the block card for internal flight 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>","<cities>"
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And  Check an itinerary got successfully costed 
	And  get the internal date and format the date 
	And  fill the details of the flight block card for the internal flight-one way 
	Then check the flight block card posted successfully 
	And remove the block card for internal flight and verify removed successfully 
	
	Examples: 
		|departFrom|region|cities|
		|Chennai|Europe|Madrid,Budapest|
		
		

Scenario Outline: Verify the block card for international flight with multiple route 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And  Check an itinerary got successfully costed 
	And  get the date checkin and format the date 
	And  get the date checkout and format the date 
	And fill the details of the flight block card for the international flight-round trip with multiple route 
	Then check the flight block card posted successfully 
	
	Examples: 
		|departFrom|region|
		|Chennai|Europe|

			
Scenario Outline: Remove block card and verify the api international flight 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And  Check an itinerary got successfully costed 
	And  get the date checkin and format the date 
	And  get the date checkout and format the date 
	And  fill the details of the flight block card for the international flight-round trip "<departureCityRoute1>","<arrivalCityRoute1>","<departureCityRoute2>","<arrivalCityRoute2>" 
	Then check the flight block card posted successfully 
	And remove the block car and verify removed successfully 
	Then click add button in international flight 
	Then validate changing the flight is done 
	
	Examples: 
		|departFrom|region|departureCityRoute1|arrivalCityRoute1|departureCityRoute2|arrivalCityRoute2|
		|Chennai|Europe|chennai|wanaka|wanaka|chennai|
						
	