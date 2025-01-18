@RegressionTest
Feature: Verify custom Installment functionality on product 


Scenario Outline: Verify Custom Installment option showing on packages pages 
	Given Login as a authenticated admin user 
	Then user navigates to the "<maldivesPackages>" page 
	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>" 
	And Check an itinerary got successfully costed 
	Then Verify custom Installment option are showing 
	
	
	Examples: 
		|maldivesPackages     |clickOn  |departFrom|
		|packages/maldives    |Customise|Chennai   |
		
@SanityTest 
Scenario Outline: Verify Custom Installment option is showing to user after sharing thr itinerary on packages flow 
	Given Login as a authenticated admin user 
	Then user navigates to the "<maldivesPackages>" page 
	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>" 
	And Check an itinerary got successfully costed 
	Then Verify custom Installment option are showing 
	Then Calculate the first and second Instalment amount from total cost 
	Then click on the create custom instalment link 
	Then Validate the first and second instalement on custom Instalment modal 
	Then Add the reason for instalment and create instalment 
	Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin 
	Then Validate the share itinerary workflow 
	Then Validate the split pricing workflow 
	Then Logout and navigate to home page for "<Url>" 
	Given Login as a authenticated user 
	And Navigate to the admin shared itinerary as an user 
	And Validate the first default amount is showing for user on above book now header 
    Then Validate the first and second instalement amount on payment screen
	
	Examples: 
		|maldivesPackages     |clickOn  |departFrom|Url|
		|packages/maldives    |Customise|Chennai   |maldives|
		

Scenario Outline: Verify Custom Installment option showing on speedboat flow 
	Given Login as a authenticated admin user 
	And Navigate to landing page for "<region>" 
	Then Verify that landing page is loaded as expected 
	Then Enter the departure location as "<departFrom>" 
	And Enter the departure date 
	Then Search for all available packages 
	Then Verify that valid results are displayed in listing page 
	And Check an itinerary got successfully costed 
	Then Verify custom Installment option are showing 
	
	Examples: 
		| region   | departFrom | duration | groupType | roomCount |
		| Maldives | Chennai    |        4 | Family    |         1 |
		
@SanityTest 
Scenario Outline: Verify Custom Installment option is showing to user after sharing thr itinerary on speedboat flow 
	Given Login as a authenticated admin user 
	And Navigate to landing page for "<region>" 
	Then Verify that landing page is loaded as expected 
	Then Enter the departure location as "<departFrom>" 
	And Enter the departure date 
	Then Search for all available packages 
	Then Verify that valid results are displayed in listing page 
	And Check an itinerary got successfully costed 
	Then Verify custom Installment option are showing 
	Then Calculate the first and second Instalment amount from total cost 
	Then click on the create custom instalment link 
	Then Validate the first and second instalement on custom Instalment modal 
	Then Add the reason for instalment and create instalment 
	Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin 
	Then Validate the share itinerary workflow 
	Then Validate the split pricing workflow 
	Then Logout and navigate to home page for "<Url>" 
	Given Login as a authenticated user 
	And Navigate to the admin shared itinerary as an user 
	And Validate the first default amount is showing for user on above book now header 
	Then Validate the first and second instalement amount on payment screen
	
	Examples: 
		| region   | departFrom | duration | groupType | roomCount |Url|
		| Maldives | Chennai    |        4 | Family    |         1 |maldives|
