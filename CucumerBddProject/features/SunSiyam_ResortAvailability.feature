@sales
Feature: Sharing Resort availability for Sun Siyam Group to appropriate stakeholders

  Scenario Outline: Sharing Resort availability for Sun Siyam Group to appropriate stakeholders
    Given launch the Sun Siyam website "<url>" and close the popup
    And capture the full page screenshot and change another resort
    Then mail the captured screenshot with subject "<subject>" and body to the required stakeholders "<toMail>" and "<ccMail>"
   
  Examples: 
      | url    |subject|toMail|ccMail|
      | https://siyam.ssrsys.com/wp-login.php | Sun Siyam Resort Availability Mail| curators@pickyourtrail.com |dwaraka@pickyourtrail.com,qa@pickyourtrail.com|