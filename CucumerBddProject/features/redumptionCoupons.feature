Feature: Validation of KAJALPYT coupons

  Scenario Outline: Validate The application of KAJALPYT coupon For multiple User
    Given Login to the application with valid username and password with "<user>" and "<passwd>"
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user checks all the alerts and clicks continue to book
    And user fills in the passenger details
    And apply the coupon and verify the application of discount

    Examples: 
      | region    | user       | passwd      |
      | Australia | 9444422016 | travelisfun |
      | Thailand  | 9840097352 | travelisfun |
      | Canada    | 9840097352 | travelisfun |
