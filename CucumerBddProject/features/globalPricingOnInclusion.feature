@RegressionTest
Feature: Global Pricing validation on Inclusion page
  Verify the Global Pricing validation on Inclusion pages

  @SanityTest
  Scenario Outline: Verify the pricing showing on inclusion page corresponding to the destination selected
    When User selects the "<Destination>" from the global dropdown
    Then Validate the respective "<Destination>" homepage is displaying or not
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And Global user fills the GCM with mandatory for "<Destination>","<region>","<fields>"
    And Check an itinerary got successfully costed
    Then Validate the currency showing on inclusion is corresponding to the "<Destination>" selected

    Examples: 
      | Destination        | region | fields       |
      | India              | Europe | ExistingMail |
      | UnitedStates       | Europe | ExistingMail |
#      | UnitedArabEmirates | Europe | ExistingMail |

