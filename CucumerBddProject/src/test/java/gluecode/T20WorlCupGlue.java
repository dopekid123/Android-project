package gluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class T20WorlCupGlue extends Kernel {

	/**
	 * This function chooses the T-20 men and women link from the Pickyourtrail home
	 * page.
	 **/

	@Given("^Select the T-twenty world cup for \"([^\"]*)\"$")
	public void select_the_T_twenty_world_cup_for(String type) throws Throwable {
		scrolltoElement(t20.getCustomerStory());
		if (type.equals("men")) {
			waitForMe(t20.getMensWorldCup());
			scrolltoElement(t20.getMensWorldCup());
			clickAction(t20.getMensWorldCup());
		} else if (type.equals("women")) {
			waitForMe(t20.getWomensWorldCup());
			scrolltoElement(t20.getWomensWorldCup());
			clickAction(t20.getWomensWorldCup());
		}
	}

	/**
	 * This function chooses the itinerary category from the T-20 men and women page
	 * such as Discover,Experience,Indulge.
	 **/

	@Given("^Choose the \"([^\"]*)\"$")
	public void choose_the(String itinerary_type) throws Throwable {
		waitForMe(t20.getDiscover());
		scrolltoElement(t20.getDiscover());
		switch (itinerary_type) {
		case "Discover": {
			waitForMe(t20.getDiscover());
			clickAction(t20.getDiscover());
			break;
		}

		case "Experience": {
			waitForMe(t20.getExperience());
			clickAction(t20.getExperience());
			break;
		}

		case "Indulge": {
			waitForMe(t20.getIndulge());
			clickAction(t20.getIndulge());
			break;
		}
		default: {
			System.out.println("Please check your Itinerary Type");
		}

		}

	}

	/**
	 * This function chooses the itinerary from one of the itinerary category and
	 * validate that the itinerary is created by using reserve button in the
	 * itinerary page.
	 **/

	@Given("^Select one of the itinerary card from list of itinerary cards$")
	public void select_one_of_the_itinerary_card_from_list_of_itinerary_cards() throws Throwable {
		waitForMe(t20.getViewItinerary());
		clickAction(t20.getViewItinerary());
		switchWindows();
		validateAssertion(elementExist(t20.getReserve()));

	}

	/**
	 * validate the CBR form is opening or not in the inclusion page for T-20 men
	 * and women.
	 */
	@Then("^Validate the request call back form is appearing$")
	public void validate_the_request_call_back_form_is_appearing() throws Throwable {
		clickAction(t20.getInclusions());
		waitForMe(t20.getReserve());
		clickAction(t20.getReserve());
		validateAssertion(elementExist(t20.getcbr()));

	}

}
