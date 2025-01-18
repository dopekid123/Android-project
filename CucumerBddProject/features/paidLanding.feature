@paidLanding
Feature: Validating Paid and SEO Landing pages and also fetching hotels below 3 star

  @paidLanding
  Scenario Outline: Validate Paid Landing pages and also fetching hotels below 3 stars
    Given User reads the urls from the input csv file "<paidLandingUrlsPath>"
    Then User navigates to the url and sign up to the itinerary with valid username, name and password "<uName>", "<name>" and "<passwd>" and fetches the "<properties>" below three stars

    #Then mail the urls to the required stakeholders "<toMail>" and "<ccMail>"
    Examples: 
      | paidLandingUrlsPath                | uName      | name                | passwd | toMail                   | ccMail                     | properties                    |
      | /configuration/paidlandingurls.csv | 8917374415 | Paid landing signup | 666666 | nirmal@pickyourtrail.com | dinesh.m@pickyourtrail.com | paidpropertiesbelow3stars.csv |

 
  @paidLanding
  Scenario Outline: Validate SEO Landing pages and also fetching hotels below 3 stars
    Given User reads the urls from the input csv file "<paidLandingUrlsPath>"
    Then User navigates to the url and sign up to the itinerary with valid username, name and password "<uName>", "<name>" and "<passwd>" and fetches the "<properties>" below three stars

    #Then mail the urls to the required stakeholders "<toMail>" and "<ccMail>"
    Examples: 
      | paidLandingUrlsPath               | uName      | name                | passwd | toMail                   | ccMail                     | properties                   |
      | /configuration/seolandingurls.csv | 8917374415 | Paid landing signup | 666666 | nirmal@pickyourtrail.com | dinesh.m@pickyourtrail.com | seopropertiesbelow3stars.csv |
