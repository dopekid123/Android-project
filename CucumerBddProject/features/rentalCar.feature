@FAS @Transfers @InclusionsFlow @RegressionTest @RentalCar @Set3
Feature: Validatation of Rental car

  @SmokeTest @SanityTest
  Scenario Outline: User Change The Rental Car From The Itinerary
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    Then validate that the Transfer section is displayed
    And user click on transfer tab
    And change the rental car
    Then validate the rental car changed succesfully

    Examples: 
      | region     |
      | Queenstown |

  Scenario Outline: Verify The User Change The Insurance Type Of The Rental Car
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    Then validate that the Transfer section is displayed
    Then user change the insurance and validate the insurance applied successfully

    Examples: 
      | region     |
      | Queenstown |

  Scenario Outline: Filter Validation For The Rental Car
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    Then validate that the Transfer section is displayed
    And user click on transfer tab
    Then apply economy filter and validate the filter applied successfully
    Then apply compact filter and validate the filter applied successfully
    Then apply executive filter and validate the filter applied successfully
    Then apply suv filter and validate the filter applied successfully
    Then apply intermediate filter and validate the filter applied successfully
    Then apply large filter and validate the filter applied successfully
    Then apply premium filter and validate the filter applied successfully
    Then apply seater van filter and validate the filter applied successfully
    Then apply suited for five filter and validate the filter applied successfully
    Then apply suited for seven filter and validate the filter applied successfully
    Then apply suited for eleven filter and validate the filter applied successfully
    Then apply automatic filter and validate the filter applied successfully

    #Commented by sharmila - 27-07-2021 - Below filters aren't available on product
    #Then apply air conditioning filter and validate the filter applied successfully
    #Then apply value standard filter and validate the filter applied successfully
    #Then apply standard filter and validate the filter applied successfully
    #Then apply value suv (awd) filter and validate the filter applied successfully
    Examples: 
      | region     |
      | Queenstown |
