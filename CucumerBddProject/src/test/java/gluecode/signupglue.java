/*
package gluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class signupglue extends Kernel {

	@Given("^Signup as a new user from landing page$")
	public void signup_as_a_new_user_from_landing_page() throws Throwable {
		validateAssertion(SignupFromLandingPageTest("NewUser"));

	}

	@Given("^Signup as a existing user from landing page$")
	public void signup_as_a_existing_user_from_landing_page() throws Throwable {

		validateAssertion(SignupFromLandingPageTest("ExistingCredentials"));

	}

	@Given("^Signup with existing email ID and new mobile number from landing page$")
	public void signup_with_existing_email_ID_and_new_mobile_number_from_landing_page() throws Throwable {

		validateAssertion(SignupFromLandingPageTest("ExistingEmail"));
		
	}

	@Given("^Signup with new email ID and existing mobile number from landing page$")
	public void signup_with_new_email_ID_and_existing_mobile_number_from_landing_page() throws Throwable {

		validateAssertion(SignupFromLandingPageTest("ExistingMobile"));
		
	}

	
//Validate the sign up modal in the GCM

	@Given("^Signup as new user from GCM page with \"([^\"]*)\"$")
	public void signup_as_new_user_from_GCM_page_with(String region) throws Throwable {
		validateAssertion(signupThroughPage("GCM",region));
		}
	
	@Given("^Signup as new user via Calculate trip cost CTA with \"([^\"]*)\"$")
	public void signup_as_new_user_via_Calculate_trip_cost_CTA_with(String region) throws Throwable {
		validateAssertion(signupThroughPage("CTC",region));
	}

	
	@Given("^Signup as new user from header login link in itinerary page with \"([^\"]*)\"$")
	public void signup_as_new_user_from_header_login_link_in_itinerary_page_with(String region) throws Throwable {
	validateAssertion(SignupFromGCMPageHeaderLink(region));
		

	}
	
	
//Validate the sign up modal in the Packages page	
	
	@Given("^Signup as new user from Packages page with \"([^\"]*)\"$")
	public void signup_as_new_user_from_Packages_page_with(String region) throws Throwable {
		validateAssertion(signupThroughPage("Packages",region));
	}

	@Given("^Signup as new user from header login link in packages page with \"([^\"]*)\"$")
	public void signup_as_new_user_from_header_login_link_in_packages_page_with(String region) throws Throwable {
		validateAssertion(SignupFromPackagesPageHeaderLink(region));
		

	}

	
//Validate the sign up modal in the Vacations page	
	
	@Given("^Signup as new user from Vacations page with \"([^\"]*)\"$")
	public void signup_as_new_user_from_Vacations_page_with(String region) throws Throwable {
		validateAssertion(signupThroughPage("Vacations",region));
	}
	
	@Then("^Sign up as a new user via deals details page$")
	public void sign_up_as_a_new_user_via_deals_details_page() throws Throwable {
		clickAction(sDetails.getBookThisDealButtonPaxDetails());
		typeText(sp.getUsername(), newuser);
		typeText(sp.getEmail(), newemail);
		Thread.sleep(1000);
		typeText(sp.getMobileNumber(), newmobile);
		Thread.sleep(1000);
		clickAction(gcm.getSignUpCta());
	}




}
*/
