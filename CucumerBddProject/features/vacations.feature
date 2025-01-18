@FAS @CampaignPages @RegressionTest @SanityTest
Feature: Vacations Page Validation

  @SmokeTest
  Scenario: Verify the Pickyourtrail logo shouldn't redirect to home page in vacations page
    When redirect to vacations page
    Then click the pyt logo and validate the logo shouldn't be clickable

  Scenario: Verify the PDG flow link from vacations page
    When redirect to vacations page
    Then validate the PDG flow link from vacations page

  Scenario: Verify the FAQ in the vacations page
    When redirect to vacations page
    Then verify the vacations page contains faq Section
