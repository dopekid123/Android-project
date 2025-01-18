@RegressionTest @PackagesPage @SanityTest 
Feature: Verify Coupon and loyality code on product 

#Commented - Since deals aren't selling the market focus has been changed so deals getting expired while running this script.
#Scenario Outline: Verify if user able to apply coupon on deals page 
#	Given  Login as a authenticated user 
#	Then Navigate to respective "<deals>" via URL 
#	Then Validate the total price on deals details page 
#	Then Verify the price on passenger screen 
#	Then apply "<couponcode>" in live price screen 
#	Then Validate coupon code is displayed or not 
#	Then Validate after coupon code discounted price on passenger screen 
#	Then Validate after applied coupon code offer loyality and HSBC offer should be disabled 
#	Then Validate once user removes the coupon other offers such as loyality and HSBC offer should be enabled 
#	
#	Examples: 
#		|deals                                    | couponcode  |
#		|2-nights-stay-at-the-tamara-coorg_2      |PYTAJAY2160  |
#		
		

Scenario Outline: Verify if user is able to apply coupon on pdf flow page. 
	Given  Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed 
	And get the count of the inclusions card count from the inclusions page 
	And user checks all the alerts and clicks continue to book 
	And user fills in the passenger details 
	Then user Verifies if there is any sold out line item in the live price screen 
	And apply "<couponcode>" in live price screen 
	Then Validate after applied coupon code offer loyality and HSBC offer should be disabled 
	Then Validate once user removes the coupon other offers such as loyality and HSBC offer should be enabled on pdf flow 
	
	Examples: 
		| region    | departFrom | discountamt | lineitem | category | couponcode  |
		| Australia    | Chennai    |         500 | more     | price    | PYTAJAY2160 |
		
	
Scenario Outline: Verify if user able to apply loyalty code on International page and also validating whether other offers are disabled after applying loyalty credits 
	Given Login as a authenticated admin user 
	And user navigates to the "<Accounts>" page 
	And verify total loyality coins in my account section 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed 
	And get the count of the inclusions card count from the inclusions page 
	And user checks all the alerts and clicks continue to book 
	And user fills in the passenger details 
	Then user Verifies if there is any sold out line item in the live price screen 
	And verify loyality on your account section amount should be shown on respective deals and International page 
	And verify loyality with "<Amount>" is applied or not and verify the amount deduction- International 
	
	Examples: 
		|Accounts| region    | departFrom | discountamt | lineitem | category | Amount        |
		|account | Australia    | Chennai    |         500 | more     | price    |0,3010,1500    |
		
#Commented - Since deals aren't selling the market focus has been changed so deals getting expired while running this script.		
		
#Scenario Outline: Verify if user able to apply loyalty code on deals page and also validating whether other offers are disabled after applying loyalty credits 
#	Given Login as a authenticated admin user 
#	And user navigates to the "<Accounts>" page 
#	And verify total loyality coins in my account section 
#	Then Navigate to respective "<deals>" via URL 
#	Then Validate the total price on deals details page 
#	Then Verify the price on passenger screen 
#	And verify loyality on your account section amount should be shown on respective deals and International page 
#	And verify loyality with "<Amount>" is applied or not and verify the amount deduction- International 
#	Then Validate after loyalty code discounted price on passenger screen 
#	
#	
#	Examples: 
#		|Accounts|deals                                    |couponcode  | Amount   |
#		|account |2-nights-stay-at-the-tamara-coorg_2      |PYTAJAY2160 |0,3010,10 |
