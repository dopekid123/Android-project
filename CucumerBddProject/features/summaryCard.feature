@FAS @RegressionTest @Set1
Feature: Summary card validation for the inclusions in the itinerary 

#Scenario Outline: Validate the summary card details with inclusions line item
#   Given Login as a authenticated admin user
#   And  user validates the costing flow for "<region>"
#   Then validate that the itinerary is created succesfully
#   And  user fills the GCM form 
#   And  Check an itinerary got successfully costed
#   Then compare the inclusions list aganist the inclusions page line item 
# 
# Examples: 
#		|region|
#		|Europe|

# Testcase Id (TC-154)
@RegressionTest @Test
Scenario Outline: Validate the Android App Link From The Summary Card
   Given Login as a authenticated admin user
   And  user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully
   And  user fills the GCM form 
   And Check an itinerary got successfully costed
   Then validate the android app link in the summary tab
 
 Examples: 
		|region|
		|Europe|

# Testcase Id (TC-155)	
@RegressionTest	@Test
Scenario Outline: Validate the IOS App Link From The Summary Card
   Given Login as a authenticated admin user
   And  user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully
   And  user fills the GCM form 
   And Check an itinerary got successfully costed
   Then validate the ios app link in the summary tab
 
 Examples: 
		|region|
		|Europe|