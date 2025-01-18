@FAS @Transfers @InclusionsFlow @Ferry @RegressionTest @Set1 @kube
Feature: Ferry Flow
  Verify the Ferry flow across the product

  @SmokeTest @RegressionTest @Test
  Scenario Outline: Validate the ferry transfer in the Inclusion page
    Given Login as a authenticated admin user
    And user validates the costing flow for ferry "<region>"
    Then validate that the Ferry section is displayed in Edit Route and Inclusion Page

    Examples: 
      | region   |
      | Thailand |