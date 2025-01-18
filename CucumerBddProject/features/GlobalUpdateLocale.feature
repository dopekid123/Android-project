@RegressionTest
Feature: Global Update locale feature for admin
	Verify the admin feature Global update locale


Scenario: Verify the global update locale feature on inclusion page
Given Login as a authenticated admin user
 And user validates the costing flow for "Australia"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 And Check an itinerary got successfully costed
 Then Validate the update locale feature





	
	