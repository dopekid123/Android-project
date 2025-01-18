@BI
Feature: Capture screenshot in BI Dashboard and mail to the stakeholders
  To Capture screenshot in BI Dashboard and mail to the stakeholders


  Scenario Outline: Capture screenshot in BI Dashboard
    Given launch the BI dashboard "<url>"
    And capture the screenshot of the entire page with name "<screenshotName>"
    Then mail the captured screenshot with subject "<subject>" and body "<body>" to the required stakeholders "<toMail>" and "<ccMail>"
   
  Examples: 
      | url    | screenshotName | subject | body | toMail | ccMail |
      | r=eyJrIjoiZGIxMjY0OWYtMDJlYy00ZDMyLTg4ZWItMWM0MjE5OWQ1ZjFjIiwidCI6IjQ0YzIyMTcxLTEwYzUtNGQ0Zi05MWZjLTEzOGJhMTEyZjMxMiJ9 | Homepage | BI Dashboard Report | BI Dashboard | nirmal@pickyourtrail.com | meenatchi@pickyourtrail.com,sharmila@pickyourtrail.com | 
      | r=eyJrIjoiZGIxMjY0OWYtMDJlYy00ZDMyLTg4ZWItMWM0MjE5OWQ1ZjFjIiwidCI6IjQ0YzIyMTcxLTEwYzUtNGQ0Zi05MWZjLTEzOGJhMTEyZjMxMiJ9 | Secondpage | BI Dashboard Report | BI Dashboard | nirmal@pickyourtrail.com | meenatchi@pickyourtrail.com,sharmila@pickyourtrail.com | 