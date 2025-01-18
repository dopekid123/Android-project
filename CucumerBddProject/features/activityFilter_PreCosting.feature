@Activities @RegressionTest @Set1 
@Test
Feature: Filter validation of Activity filter - Pre Costing
  Scenario Outline: Activity Filter Validation Slot Wise For Time Slot Filters
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And verify all the time slot filters

    Examples: 
      | region    |
      | Australia |

  Scenario Outline: Activity Filter Validation Slot Wise For Activity Duration Filter
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And verify all the activity duration filters

    Examples: 
      | region    |
      | Australia |

  Scenario Outline: Activity Filter Validation Slot Wise For Transfer Filter and Group Type
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And verify all the transfer and group type filters

    Examples: 
      | region    |
      | Australia |

  Scenario Outline: Activity Filter Validation Slot Wise For  Interest Filter
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    Then verify all the Interests filters

    Examples: 
      | region    |
      | Australia |

  Scenario Outline: Activity Filter Validation Slot Wise For Other Filter
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And verify all the other filters

    Examples: 
      | region    |
      | Australia |