#@FAS  @SpeedBali @Set1
Feature: Speedbali Flow
  Executes all test scenarios for verifying functionality of Bali flow.

  Scenario Outline: User flow - Verify navigation to Bali home page
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali

    Examples: 
      | region |
      | Bali   |

  Scenario Outline: User flow - Verify costing from Bali landing page with user given duration and group type
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali

    Examples: 
      | region | departFrom | groupType |
      | Bali   | Chennai    | Family    |
      | Bali   | Delhi      | Family    |
      | Bali   | Kolkata    | Family    |
      | Bali   | Bengaluru  | Friends   |
      | Bali   | Mumbai     | Friends   |

  Scenario Outline: User flow - Verify costing from Bali landing page with default duration and group type
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali

    Examples: 
      | region | departFrom     |
      | Bali   | Chennai        |
      | Bali   | Outside India  |
      | Bali   | Flights Booked |

  #This testcase is to verify if user able to select the duration from minimum limit 4 to maximum limit 8 duartion of stay
  Scenario Outline: User flow - Verify costing from Bali landing page with user given duration and group type
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the duration of stay for bali as "<duration>"
    And Enter the group type for bali as "<groupType>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for Bali

    Examples: 
      | region | departFrom | duration | groupType |
      | Bali   | Chennai    |        4 | Family    |
      | Bali   | Delhi      |        5 | Family    |
      | Bali   | Kolkata    |        6 | Family    |
      | Bali   | Kolkata    |        7 | Family    |
      | Bali   | Kolkata    |        8 | Family    |
      | Bali   | Bengaluru  |        4 | Friends   |
      | Bali   | Mumbai     |        5 | Friends   |
      | Bali   | Chennai    |        6 | Friends   |
      | Bali   | Kolkata    |        7 | Friends   |
      | Bali   | Kolkata    |        8 | Friends   |
      | Bali   | Delhi      |        4 | Solo      |
      | Bali   | Kolkata    |        5 | Solo      |
      | Bali   | Bengaluru  |        6 | Solo      |
      | Bali   | Chennai    |        7 | Solo      |
      | Bali   | Hyderabad  |        8 | Solo      |

  #Scenario Outline: User flow - Verify costing from Bali landing page with custom room configuration
    #Given Login as a authenticated user
    #And Navigate to landing page for bali "<region>"
    #Then Verify that landing page is loaded as expected for Bali
    #Then Enter the departure location as  for bali "<departFrom>"
    #And Enter the departure date for bali
    #And Add rooms to the bali itinerary with group type and additional room count as "<groupType>","<roomCount>"
    #Then Search for all available packages for bali
    #Then Verify that valid results are displayed in listing page
#
    #Examples: 
      #| region | departFrom | groupType | roomCount |
      #| Bali   | Chennai    | Family    |         1 |
      #| Bali   | Hyderabad  | Family    |         2 |
      #| Bali   | Kolkata    | Family    |         3 |
      #| Bali   | Bengaluru  | Family    |         4 |

  Scenario Outline: User flow - Verify costing from Bali landing page with adult and child configuration
    Given Login as a authenticated user
    And Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Enter the departure location as  for bali "<departFrom>"
    And Enter the departure date for bali
    And Enter the room config with adult and child count for bali as "<adultCount>","<childCount>","<childAge>"
    Then Search for all available packages for bali
    Then Verify that valid results are displayed in listing page for speedbali "<adultCount>","<childCount>"

    Examples: 
      | region | departFrom | groupType | adultCount | childCount | childAge |
      | Bali   | Chennai    | Family    |          2 |          1 |        1 |
      | Bali   | Delhi      | Family    |          3 |          1 |        2 |
      | Bali   | Kolkata    | Family    |          4 |          1 |        5 |
      | Bali   | Bengaluru  | Friends   |          5 |          1 |        8 |

  #This test case is to verify the view all deals functionality for logged in and non-logged in user.
  Scenario Outline: Verify view all deals functionality for non-logged in user
    Given Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Verify by clicking on view all deals GCM should popup
    Then verify if the user able to view the itinerary

    Examples: 
      | region |
      | Bali   |

  Scenario Outline: Verify view all deals functionality for logged in user
    Given Login as a authenticated user
    Given Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then Verify by clicking on view all deals GCM should popup
    Then verify if the user able to view the itinerary

    Examples: 
      | region |
      | Bali   |

  Scenario Outline: Logged in user - Verify the packages on home page
    Given Login as a authenticated user
    Given Navigate to landing page for bali "<region>"
    Then Verify that landing page is loaded as expected for Bali
    Then click the packages on home page and verify the itinerary page is loading "<packages>"
    Then Verify if user able to view the GCM while clicking on elements in the itinerary page "<elements>"
    Then validate user able to cost the itinerary

    Examples: 
      | region | packages         | elements        |
      | Bali   | honeymoon        | included?       |
      | Bali   | adventure        | included?       |
      | Bali   | privatepoolvilla | included?       |
      | Bali   | family           | included?       |
      | Bali   | honeymoon        | Get latest cost |
      | Bali   | adventure        | Get latest cost |
      | Bali   | privatepoolvilla | Get latest cost |
      | Bali   | family           | Get latest cost |
      | Bali   | honeymoon        | Route overview  |
      | Bali   | adventure        | Route overview  |
      | Bali   | privatepoolvilla | Route overview  |
      | Bali   | family           | Route overview  |
