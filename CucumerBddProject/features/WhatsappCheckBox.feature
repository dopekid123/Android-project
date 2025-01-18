@RegressionTest @Set3  
Feature: Verify the whatsapp checkbox functionality whether its enabled or disabled

  #Whatsapp checkbox scenario - Dubai flow GCM 
 
 @Test
  Scenario Outline: Verify the functionality of checkbox before click and after click
    Given User selects the region "<region>" from destination options
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departing city "<dep_city>" from the dropdown
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    And User verifies if the checkbox is enabled by default
    And User validates that checkbox got unchecked after clicking on checkbox

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | NOV        | Chennai  |       22 | 5 - 8 nights | Partner     |

  # Landing page login modal
  
  Scenario: Verify the functionality of checkbox before click and after click on landing page GCM
    Given User validates by default that the checkbox got enabled for landing page GCM
    Then User validates that checkbox got unchecked after clicking on checkbox for landing page GCM

  # Itinerary page GCM modal
  
  Scenario Outline: Verify the functionality of checkbox before click and after click on itinerary page GCM
    Given User validates by default that the checkbox got enabled for itinerary page GCM "<region>"
    Then User validates that checkbox got unchecked after clicking on checkbox for itinerary page GCM "<region>"

    Examples: 
      | region    |
      | Australia |
