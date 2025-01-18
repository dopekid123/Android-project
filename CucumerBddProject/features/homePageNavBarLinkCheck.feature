@RegressionTest @Test 
Feature: Home page navigation bar link checks 

 
Scenario: Verify the links are redirecting properly in the home page nav bar - guides,blog,about us 
	Given user land on home page without login 
	And click aboutUs link and verify its working
    And click careers link and verify its working  
	And click guides link and verify its working 
	

Scenario: Verify the links are redirecting properly in the home page nav bar- testimonial,visa,faq,contact us 
	Given user land on home page without login 
	And click testimonial link and verify its working 
    And click faq link and verify its working 
	And click contactUs link and verify its working 
	And click visa link and verify its working 
    And click blog link and verify its working 
	