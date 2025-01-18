Feature: Custom Block Card Creation

  Scenario Outline: Create custom block card with different sources and entities
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Dubai banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully
    Then User clicks the custom block card button
    And User is on the custom block card page
    When User enters the title
    And User selects the source as "<Source>"
    And User enters the description
    And User selects the entity as "<Entity>"
    And User enters the our cost and published cost
    And User selects the reason for the block card as "<Reason>"
    And User enters the date
    And User enters the fee
    And clicks on the save and create button
    Then The card should be created successfully

    Examples: 
      | Page                       | Title          | Source   | Description | Entity   | Reason      |
      | packages/australia         | Activity Card  | EXPEDIA  | Test        | Activity | Valid Reason |

      
      
      #| Flight Card    | EXPEDIA   | Test  | Flights   |
      #| Hotel Card     | EXPEDIA   | Test  | Hotels    |
      #| Insurance Card | EXPEDIA   | Test  | Insurance |
      #| Activity Card  | HOTELBEDS | Test  | Activity  |
      #| Flight Card    | HOTELBEDS | Test  | Flights   |
      #| Activity Card  | TBO       | Test  | Activity  |
      #| Flight Card    | QPX       | Test  | Flights   |
