#@FAS   @SpeedBali @Set1

Feature: Speedbali Flow
  Executes all test scenarios for verifying functionality of Bali Listing Page flow.

  Scenario Outline: User flow - Verify costing from Bali landing page with user given duration and group type
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    Then Click on the price filter for bali
    And Choose price range per person as for Bali "<priceRange>"
    Then Verify that results are shown for price range for bali "<priceRange>"

    Examples: 
      | region | departFrom | groupType | priceRange   |
      | Bali   | Chennai    | Family    | 1to1.2lacs   |
      | Bali   | Delhi      | Family    | 1.2to1.6lacs |
      | Bali   | Kolkata    | Family    | 1.6to2.0lacs |
      | Bali   | Bengaluru  | Friends   | Above2lacs   |
      | Bali   | Mumbai     | Friends   | 1.6to2.0lacs |

  Scenario Outline: User flow - Verify results in Bali listing page with star category filter options
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    Then Click on the star category filter for Bali
    And Choose star category for bali as "<starCategory>"
    Then Verify that results are shown for star category "<starCategory>"

    Examples: 
      | region | departFrom | groupType | starCategory |
      | Bali   | Chennai    | Family    | 4 Star       |
      | Bali   | Delhi      | Family    | 5 Star       |
      | Bali   | Kolkata    | Friends   | 5 Star       |
      | Bali   | Kolkata    | Friends   | 4 Star       |
      | Bali   | Delhi      | Friends   | 4 Star       |

  Scenario Outline: User flow - Verify results in Bali listing page with villa type filter options
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    Then Click on the villa type filter for bali
    And Choose villa type for bali as "<villaType>"
    Then Verify that results are shown for villa type for Bali "<villaType>"

    Examples: 
      | region | departFrom | villaType          | groupType |
      | Bali   | Chennai    | Private Pool Villa | Family    |
      | Bali   | Delhi      | Garden View        | Friends   |
      | Bali   | Kolkata    | Deluxe Room        | Family    |
      | Bali   | Kolkata    | Garden View        | Friends   |
      | Bali   | Kolkata    | Garden View        | Family    |
      | Bali   | Kolkata    | Private Pool Villa | Friends   |

  Scenario Outline: User Flow- Verify Filter retentions on Refresh and navigation to Listing Pages with Bali Crums
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    Then Click on the villa type filter for bali
    And Choose villa type for bali as "<villaType>"
    Then Verify that results are shown for villa type for Bali on refresh "<villaType>"
    Then Click the Bali Crums
    And Verify that landing page is loaded as expected for Bali

    Examples: 
      | region | departFrom | villaType          | groupType |
      | Bali   | Chennai    | Private Pool Villa | Family    |
      | Bali   | Delhi      | Garden View        | Friends   |
      | Bali   | Chennai    | Private Pool Villa | Friends   |
      | Bali   | Delhi      | Garden View        | Family    |

  Scenario Outline: User FLow- Verify the Inclusions Page pop up on clicking Unlock Deal on Hotel Card for Logged In user
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    And Click the Unlock Deal button
    Then Verify the appearance of inclusions page

    Examples: 
      | region | departFrom | groupType |
      | Bali   | Chennai    | Family    |
      | Bali   | Delhi      | Friends   |
      | Bali   | Kolkata    | Family    |
      | Bali   | Kolkata    | Friends   |
      | Bali   | Delhi      | Family    |
      | Bali   | Chennai    | Friends   |

  Scenario Outline: Verify the Inclusions Page pop up on clicking Hotel Cards for a loggedIn User
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    And Click on Hotel card
    Then Verify the appearance of inclusions page

    Examples: 
      | region | departFrom | groupType |
      | Bali   | Chennai    | Family    |
      | Bali   | Delhi      | Friends   |
      | Bali   | Kolkata    | Friends   |
      | Bali   | Chennai    | Friends   |

  Scenario Outline: Verify the Inclusions Page pop up on clicking Hotel Cards for a Un-logged User
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    And Click on Hotel card
    Then Login from signup modal for Speedbali inclusions Page
    Then Verify the appearance of inclusions page

    Examples: 
      | region | departFrom | groupType |
      | Bali   | Chennai    | Family    |
      | Bali   | Delhi      | Friends   |
      | Bali   | Kolkata    | Friends   |
      | Bali   | Chennai    | Friends   |
      | Bali   | Delhi      | Family    |

  Scenario Outline: User FLow- Verify the Inclusions Page pop up on clicking Unlock Deal on Hotel Card for Un-Logged In user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    And Click on Hotel card
    Then Login from signup modal for Speedbali inclusions Page
    Then Verify the appearance of inclusions page

    Examples: 
      | region | departFrom | groupType |
      | Bali   | Chennai    | Family    |
      | Bali   | Delhi      | Friends   |
      | Bali   | Delhi      | Family    |

  Scenario Outline: Verify the behaviour of Filter reset on a no result page
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    Then Click on the villa type filter for bali
    And Choose villa type for bali as "<villaType>"
    Then Click on the star category filter for Bali
    And Choose star category for bali as "<starCategory>"
    Then Click on the price filter for bali
    And Choose price range per person as for Bali "<priceRange>"
    Then Verify the no results message
    Then Click on the villa type filter for bali
    Then Reset villaType filter
    And Reset starCateory filter "<starCategory>"
    Then Click on the price filter for bali
    And Reset priceRange filter
    Then Verify that valid results are displayed in listing page for Bali

    Examples: 
      | region | departFrom | groupType | villaType          | starCategory | priceRange |
      | Bali   | Chennai    | Family    | Private Pool Villa | 4 Star       | Above2lacs |
      | Bali   | Delhi      | Friends   | Garden View        | 5 Star       | 1to1.2lacs |

  Scenario Outline: User FLow- Verify the booking of an Itinerary as User
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali
    And Click on Hotel card
    Then Login from signup modal for Speedbali inclusions Page
    Then Verify the appearance of inclusions page
    And Complete the booking as User
    And user fills in the passenger details
    Then Complete the payments
    And user makes first payment for customised percentage of pay
    And user fills the card details and make payment
    Then validate that the payment is success

    Examples: 
      | region | departFrom | groupType |
      | Bali   | Chennai    | Family    |
      | Bali   | Delhi      | Friends   |
