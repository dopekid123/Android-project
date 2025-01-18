 @Pricing @DiscountPricing @Set1 
Feature: Applying admin price for each line item

  #Hotel Scenario
  #1. Verify if admin able to apply discount
  #2. Applied discount should be retained after changing the departure city for the hotel
  #3. Applied discount should be retained after changing the arrival city
  
  
  Scenario Outline: Verify if admin able to apply discount for a hotel
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Hotel section is displayed
    Then Validate that the edit icon is showing for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | lineitem | category | discountamt |
      | Europe | Chennai    | stay     | common   |          10 |

  #Flight Scenario
  #International flight scenarios
  #1. Verify if admin able to apply discount for a International flight
  #2. Applied discount should not get retained after changing the departure city for International flight
  
  Scenario Outline: Verify if admin able to apply discount for a International flight
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Flight section is displayed
    Then Validate that the edit icon is showing on "<flight>" for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for a "<category>"

    Examples: 
      | region | departFrom | lineitem | flight        | category | discountamt |
      | Europe | Chennai    | flight   | international | common   |          10 |

  #Internal flight scenarios
  #1. Verify if admin able to apply discount for a Internal flight
  #2. Applied discount should not get retained after changing the departure city for internal flight
  
  Scenario Outline: Verify if admin able to apply discount for a Internal flight
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that internal flight section is displaying
    Then Validate that the edit icon is showing on "<flight>" for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | flight   | category | lineitem | discountamt |
      | Europe   | Chennai    | internal | internal | flight   |          10 |

  #Activity scenario
  #1. Verify if admin able to apply discount for a activity
  #2. Applied discount should be retained after changing the departure city for the activity
  #3. Applied discount should be retained after changing the arrival city for the activity
  Scenario Outline: Verify if admin able to apply discount for a activity
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Activity section is displayed
    Then Validate that the edit icon is showing on activity for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for an activity
    Then change the arrival city and update cost
    Then validate that the applied discount got retained for an activity

    Examples: 
      | region | departFrom | lineitem   | category | discountamt |
      | Europe | Chennai    | activities | activity |          10 |

  #Transfer scenario
  #Train scenario
  #1. Verify if admin able to apply discount for a train
  #2. Applied discount should be retained after changing the departure city for the train
  #3. Applied discount should be retained after changing the arrival city for the train
  
  Scenario Outline: Verify if admin able to apply discount for a train
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Train section is displayed
    Then validate that the edit icon is showing on train for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | lineitem | category | discountamt |
      | Rome   | Chennai    | transfer | train    |          10 |

  #airport-Hotel transfer
  #1. Verify if admin able to apply discount for a airport-hotel transfer
  #2. Applied discount should be retained after changing the departure city for the airport-hotel transfer
  #3. Applied discount should be retained after changing the arrival city for the airport-hotel transfer
  #4. Applied discount should not get retained after changing the transfer type
 
  Scenario Outline: Verify if admin able to apply discount for a airport-hotel transfer
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on airport-hotel transfer for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then verify the admin price label is showing
    
    Examples: 
      | region    | departFrom | lineitem | category   | discountamt |
      | Australia | Chennai    | transfer | AHtransfer |          10 |

 #Added the separate testcase for airport hotel with transfer type
 Scenario Outline: Verify if admin able to apply discount for a airport-hotel transfer with transfer type
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on airport-hotel transfer with transfer type for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the transfer type of AH transfer
    Then validate that the applied discount got retained for a "<category>"

    Examples: 
      | region    | departFrom | lineitem | category   | discountamt |
      | Australia | Chennai    | transfer | AHtransfer |          10 |

 
  #Rental car scenario
  #1. Verify if admin able to apply discount for a rental car
  #2. Applied discount should be retained after changing the departure city for Rental car
  #3. Applied discount should be retained after changing the arrival city for Rental car
  
  Scenario Outline: Verify if admin able to apply discount for a rental car
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on rental car transfer for applying admin price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then verify the admin price label is showing

    Examples: 
      | region      | departFrom | lineitem | category  | discountamt |
      | New Zealand | Chennai    | transfer | rentalcar |          10 |

  #Scenario Outline: User flow - Verify costing from Bali landing page with custom room configuration
  #Given Login as a authenticated admin user
  #And Navigate to landing page for bali "<region>"
  #Then Verify that landing page is loaded as expected for Bali
  #Then Enter the departure location as  for bali "<departFrom>"
  #And Enter the departure date for bali
  #And Add rooms to the bali itinerary with group type and additional room count as "<groupType>","<roomCount>"
  #Then Search for all available packages for bali
  #Then Verify that valid results are displayed in listing page
  #And Click on Hotel card
  #Then Verify the appearance of inclusions page
  #Then validate that the Hotel section is displayed
  #Then Validate that the edit icon is showing for applying admin price
  #
  #Examples:
  #| region | departFrom | groupType | roomCount |
  #| Bali   | Chennai    | Family    |         2 |
  
  Scenario Outline: Verify if admin able to apply overall discount for an itinerary
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing for applying overall discount price
    Then Apply "<discountamt>" on the "<lineitem>" for the "<category>" price
    Then verify if the discount is applied for entire itinerary

    Examples: 
      | region      | departFrom | discountamt | lineitem | category |
      | New Zealand | Chennai    |         500 | more     | price    |
