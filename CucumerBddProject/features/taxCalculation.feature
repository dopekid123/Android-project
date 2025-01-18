@RegressionTest
Feature: Verify the tax calculation on the product
  Validating GST and TCS calculation on product

  @SanityTest 
  Scenario Outline: Validate the GST and TCS calculation on product
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And Calculate the GST of the itinerary from trip cost for "<region>"
    And Calculate the TCS of the itinerary from trip cost

    Examples: 
      | region   | departFrom |
      | Europe   | Chennai    |

  
  
 @SanityTest 
  Scenario Outline: Validate the GST and TCS calculation on product
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And Calculate the GST of the itinerary from trip cost for "<region>"
    And Calculate the TCS of the itinerary from trip cost

    Examples: 
      | region   | departFrom |
      | Singapore| Chennai    |

   
   Scenario Outline: Verify GST and TCS aren't available for global
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And Verify GST and TCS aren't available for global

    Examples: 
      | region | departFrom |
      | Europe | Chennai    |

  #Validate the tcs calculation after applying overall discount
  Scenario Outline: Apply overall discount for the itinerary on tripcost and validate the tcs calculation
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing for applying overall discount price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify if the discount is applied for entire itinerary
     And Calculate the GST of the itinerary from trip cost for "<region>"
    And Calculate the TCS of the itinerary from trip cost

    Examples: 
      | region    | departFrom | discountamt | lineitem | category |
      | Europe    | Chennai    |         500 | more     | price    |

  Scenario Outline: Validate the tcs calculation after applying coupon code on live price screen
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And get the count of the inclusions card count from the inclusions page
    And user checks all the alerts and clicks continue to book
    And user fills in the passenger details
    And apply "<couponcode>" in live price screen
    Then Validate the "<amt>" is applied on tripcost and check tcs is calcualted on top of that for "<scenario>"

    Examples: 
      | region    | departFrom | discountamt | lineitem | category | amt | couponcode  | scenaro    |
      | Australia | Chennai    |         500 | more     | price    | 500 | PYTAJAY2160 | couponcode |

  Scenario Outline: Validate the tcs calculation after applying Loyality credit on live price screen
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And get the count of the inclusions card count from the inclusions page
    And user checks all the alerts and clicks continue to book
    And user fills in the passenger details
    And apply loyality credit "<amt>" in live price screen
    Then Validate the "<amt>" is applied on tripcost and check tcs is calcualted on top of that for "<scenario>"

    Examples: 
      | region      | departFrom | discountamt | lineitem | category | amt  | scenario       |
      | New Zealand | Chennai    |         500 | more     | price    | 3000 | loyalitycredit |

  
  Scenario Outline: Verify the tcs is applied on each payment card 
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And user checks all the alerts and clicks continue to book
    And get the itinerary id
    And user fills in the passenger details
    And Fetch the tripcost and GST amount from inclusion page for calculating tcs on each card
    And  user checks all the alerts and clicks continue to book
    And user fills in the passenger details
    And user reviews the cost and clicks make payment
    And user validates each card contains respective tcs value

    Examples: 
      | region    |
      | Australia |
