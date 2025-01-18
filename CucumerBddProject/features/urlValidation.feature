#Feature file to validate URLs from Sitemap and Sitemap-itineraries.xml

@UrlValidation @CustomerEngagement @PostBuild
Feature: URL Validation
  Performs validation of URL's available in product sitemap.xml and sitemap-itineraries.xml

  Scenario: Perform URL validation on product
    Given initiate URL validation script on product
    Then send the report to all stakeholders

