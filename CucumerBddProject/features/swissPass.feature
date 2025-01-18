@RegressionTest 

Feature: Validate the swiss pass logic on the switzerland itinerary created

  #The below scenario validate both swisspass card and activity logic
  Scenario Outline: Validate the swiss pass logic on the switzerland itinerary
    And user validates the short hand destinatiom costing flow for "<region>"
    Then validate that the itinerary is created succesfully for single destination
    And user login with "<uName>" and "<passwd>" for single destination
    And user validates the costing time period for "<region>"
    And Remove the extra cities in the itinerary
    And Validate the swisspass for following "<days>"

    Examples: 
      | region      | uName      | passwd      | days                         |
      | Switzerland | 6383589200 | travelisfun | 3,4,5,6,7,8,9,10,11,15,16,17 |
