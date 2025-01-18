package gluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class signupRevampGlue extends Kernel{
	
	
	
	@Then("^signup from landing page using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_from_landing_page_using_and_and(String name, String emailid, String mobileno) throws Throwable {
    validateAssertion(SignupFromLandingPageTest("NewUser",name,emailid,mobileno));
	
	}




	@Then("^Signup as new user from GCM page with \"([^\"]*)\" using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_GCM_page_with_using_and_and(String region, String name, String emailid, String mobileno) throws Throwable {
		validateAssertion(signupThroughPage("GCM",region,name,emailid,mobileno));
	}
	
	
	@Given("^Signup as new user from header login link in itinerary page with \"([^\"]*)\" using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_header_login_link_in_itinerary_page_with_using_and_and(String region, String name, String emailid, String mobileno) throws Throwable {

		validateAssertion(SignupFromGCMPageHeaderLink(region,name,emailid,mobileno));
	}
	
	
	@Given("^Signup as new user from Packages page v-one with \"([^\"]*)\" using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_Packages_page_v_one_with_using_and_and(String region, String name, String emailid, String mobileno) throws Throwable {
		validateAssertion(signupThroughPage("Packages",region,name,emailid,mobileno));
	
	}

	@Given("^Signup as new user from Packages page v-two with \"([^\"]*)\" using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_Packages_page_v_two_with_using_and_and(String region, String name, String emailid, String mobileno) throws Throwable {
		validateAssertion(signupThroughPage("Packages",region,name,emailid,mobileno));
	}
	
	@Given("^Signup as new user from vacations page with \"([^\"]*)\" using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_vacations_page_with_using_and_and(String region, String name, String emailid, String mobileno) throws Throwable {
		validateAssertion(signupThroughPage("Vacations",region,name,emailid,mobileno));
	}
	
	@Then("^Signup as new user from speedboat listing page using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_speedboat_listing_page_using_and_and(String name, String emailid, String mobileno) throws Throwable {
		validateAssertion(signupThroughPage("Speedboat","Maldives",name,emailid,mobileno));

	}


	

}
