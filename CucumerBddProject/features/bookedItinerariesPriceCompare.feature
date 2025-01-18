@FAS @Set1
Feature: Comparing Booked Itinerary Prices

  @getPrice
  Scenario Outline: Get Costed Itinerary prices
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user checks all the alerts and clicks continue to book
    And user fills in the passenger details
    Then get created itinerary details "<region>" , "<clearFlag>" , "<itineraryStatus>"
    And user reviews the cost and clicks make payment
    And user makes the full payment
    And user fills the card details and make payment
    Then validate that the payment is success

    Examples: 
      | region      | clearFlag | itineraryStatus |
      | Australia   | true      | booked          |
      | Europe      | false     | booked          |
      | New Zealand | false     | booked          |
      | Thailand    | false     | booked          |

  @getPrice
  Scenario Outline: Get Costed Itinerary price for sandune
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    And user checks all the alerts and clicks continue to book
    And user fills in the passenger details
    Then get created itinerary details "<region>" , "<clearFlag>" , "<itineraryStatus>"
    And user reviews the cost and clicks make payment
    And user makes the full payment
    And user fills the card details and make payment
    Then validate that the payment is success

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details | clearFlag | itineraryStatus |
      | dubai  | May         | Chennai  |       22 | 5 - 8 nights | Partner     | false     | booked          |

  @comparePrice
  Scenario Outline: Get Booked Itinerary deatils after build deployed and compare
    Then get "<itineraryStatus>" itinerary details to compare
    Then compare both the "<itineraryStatus>" itinerary prices

    Examples: 
      | itineraryStatus |
      | booked          |
