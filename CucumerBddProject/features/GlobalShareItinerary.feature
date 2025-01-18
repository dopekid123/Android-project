@RegressionTest
Feature: Validate the share itinerary flow for global user
Validate the share itinerary flow for global user3
       
 Scenario: Admin share Itinerary validation
 Given Login as a authenticated admin user
 And user validates the costing flow for "Australia"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 And Check an itinerary got successfully costed
 Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin
 Then Validate the global share itinerary workflow