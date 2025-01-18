Feature: Applying admin price on global for each line item

  
  Scenario Outline: Verify if admin able to apply overall discount on a global itinerary
    Given Login as a authenticated admin user
    When User selects the "<Destination>" from the global dropdown
    Then Validate the respective "<Destination>" homepage is displaying or not
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And Global user fills the gcm form "<Nationality>"
    And Check an itinerary got successfully costed
    And validate that the edit icon is showing for applying overall discount price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify if the discount is applied for entire itinerary

    Examples: 
      | Destination        | region      | Nationality | discountamt | lineitem | category |
      | UnitedArabEmirates | Europe      | Andorra     |         500 | more     | price    |
