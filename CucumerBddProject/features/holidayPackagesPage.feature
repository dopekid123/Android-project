@RegressionTest @PackagesPage @SanityTest
Feature: Holiday Packages Page Validation

@Test12
Scenario Outline: Holiday Packages Page Validation for Popular Destinations
 Given Login as a authenticated user
 And user navigates to the "<packages>" page
 And user navigates to the "<dubaiPackages>" page
 And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
 And Check an itinerary got successfully costed
 And user navigates to the "<maldivesPackages>" page
 And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
 And Check an itinerary got successfully costed
 
 
 
 Examples:
 	|packages        |dubaiPackages |maldivesPackages |clickOn  |departFrom|
 	|holiday-packages|packages/dubai|packages/maldives|Customise|Chennai   |
 	|holiday-packages|packages/dubai|packages/maldives|slug     |Chennai   |
 

 Scenario Outline: Holiday Packages Page Validation for Popular Destinations
 Given Login as a authenticated user
 And user navigates to the "<packages>" page
 And user navigates to the "<thailandPackages>" page
 And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
 And Check an itinerary got successfully costed
 And user navigates to the "<turkeyPackages>" page
 And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
 And Check an itinerary got successfully costed
 And user navigates to the "<greecePackages>" page
 And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
 And Check an itinerary got successfully costed
 
 Examples:
 	|packages        |thailandPackages |turkeyPackages |greecePackages |clickOn  |departFrom|
 	|holiday-packages|packages/thailand|packages/turkey|packages/greece|customise|Chennai   |
	|holiday-packages|packages/thailand|packages/turkey|packages/greece|slug     |Chennai   |


Scenario Outline: Holiday package Page Validation for Packages Destinations
 	Given Login as a authenticated user
 	And user navigates to the "<packages>" page
  And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
 	And Check an itinerary got successfully costed
 
 	
 	
 Examples:
 |packages                | clickOn   |departFrom|
 |honeymoon-packages/europe      | customise |Chennai   |
 |honeymoon-packages/maldives      | slug      |Chennai   |
 |family-packages         | customise |Chennai   |
 |family-packages         | slug      |Chennai   |
 |visa-on-arrival-packages| customise |Chennai   |
 |visa-on-arrival-packages| slug      |Chennai   |
 |adventure-packages      | customise |Chennai   |
 |adventure-packages      | slug      |Chennai   |
