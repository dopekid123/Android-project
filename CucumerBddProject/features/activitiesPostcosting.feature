@FAS @Activities @InclusionsFlow @RegressionTest @Set1 
Feature: Activities PostCosting Flow
  Verify the Activity flow of post costing

  #Verify the Activity slider presents
  @RegressionTest @SmokeTest 
  Scenario Outline: Verify the activity slider post costing
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    Then validate the activity slider in the itinerary page

    Examples: 
      | region    |
      | Australia |

  #User Changing activity in full day slot using activity slider from alternate page
  @RegressionTest @SmokeTest
  Scenario Outline: User Changing, Removing and Adding the activity using activity slider After Costing
    Given Login as a authenticated user
    When user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user change and validate the activity in all three slot
    Then user remove the all three slot activity and validate the activity removed
    And user add the activity in all three slot

    Examples: 
      | region    |
      | Australia |

  @RegressionTest @SmokeTest @SanityTest  
  Scenario Outline: User Adding, Changing and Removing the Activity Post Costing via alternate Page In Inclusions Page
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    Then validate that the Activity section is displayed
    And user change the activity from inclusions via alternate page
    Then validate the activity added from inclusions successfully
    And user change the activity from inclusions via details page
    Then validate the activity added from inclusions successfully
    Then validate the activity removal flow

    Examples: 
      | region |
      | Europe |
