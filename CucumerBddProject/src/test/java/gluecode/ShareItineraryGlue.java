package gluecode;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class ShareItineraryGlue extends Kernel {

	@Then("share the itinerary to the existing {string} through mobile number and validate the functionality")
	public void share_the_itinerary_to_the_existing_through_mobile_number_and_validate_the_functionality(String user) throws InterruptedException {
		shareThroughMobile(user);
		shareItineraryToExistingUser();
		
	}


	@Then("share the itinerary to the existing {string} through email id and validate the functionality")
	public void share_the_itinerary_to_the_existing_through_email_id_and_validate_the_functionality(String user) throws InterruptedException {
		shareThroughEmail(user);
		shareItineraryToExistingUser();

	
	}



	@Then("share the itinerary to the new {string} with {string} {string} and validate the functionality")
	public void share_the_itinerary_to_the_new_with_and_validate_the_functionality(String user, String name, String email) throws InterruptedException {
		shareThroughMobile(user);
		shareItineraryToNewUser(name, email);
	
	}



	@Then("share the itinerary to the existing {string} through mobile number and validate the functionality in Maldives")
	public void share_the_itinerary_to_the_existing_through_mobile_number_and_validate_the_functionality_in_maldives(String user) throws InterruptedException {
		shareThroughMobile(user);
		shareItineraryToExistingUser();

	
	}


	@Then("share the itinerary to the existing {string} through mail id and validate the functionality in Maldives")
	public void share_the_itinerary_to_the_existing_through_mail_id_and_validate_the_functionality_in_maldives(String user) throws InterruptedException {
		shareThroughEmail(user);
		shareItineraryToExistingUser();
	
	}


	@Then("share the itinerary to the new {string} with {string} {string} and validate the functionality in Maldives")
	public void share_the_itinerary_to_the_new_with_and_validate_the_functionality_in_maldives(String user, String name, String email) throws InterruptedException {
		shareThroughMobile(user);
		shareItineraryToNewUser(name, email);

	
	}

}
