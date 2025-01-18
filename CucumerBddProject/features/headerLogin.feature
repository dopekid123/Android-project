@RegressionTest @SanityTest @Login
Feature: Header Login Validation on all over products

 
  Scenario Outline: Header login validation on various pages
    Given user navigates to the following "<Url>" page
    And Header Login as a authenticated user "<Url>"
    Then Validate the corresponding page is showing after logged in "<Url>"
    Then Logout and navigate to home page for "<Url>"

    Examples: 
      | Url                        |
      | Uncosted-maldives-packages |
      | Uncosted-packages          |
      | deals                      |
      | holiday-packages           |
      #|maldives-tour-packages|
      | testimonials               |
      | contact-us                 |
      | faq                        |
      | careers                    |
      | about-us                   |
