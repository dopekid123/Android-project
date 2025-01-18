package gluecode;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class InclusionsPageGlue extends Kernel {

	@And("^user clicks inclusion page")
	public void navigates_InclusionPage() throws Throwable {
		pollingWait(inclusionNew.getInclusionsTabLink(), 40);
		Thread.sleep(3000);
		pollingWait(inclusionNew.getHotelSection(), 40);
		clickAction(inclusionNew.getInclusionsTabLink(), "User Navigates to Inclusions  page");

	}

	@Then("^validate that the Flight section is displayed")
	public void validate_FlightsPanel() throws Throwable {
	//	switchWindows();
		isElementVisible(inclusionNew.getFlightSection(), 40);
		if (inclusionNew.getFlightSection().isDisplayed()) {
		//	scrolltoElement(inclusionNew.getFlightSection());
			Assert.assertTrue(true);
			System.out.println("Flights displayed in the inclusion page");
		}else {
			Assert.fail();
			System.out.println("Flights is not displayed in the inclusion page");
		}
	}

	@Then("^validate that the Activity section is displayed")
	public void validate_ActivityPanel() throws Throwable {
		elementExist(inclusionNew.getActivitySection());
	}

	@Then("^validate that the Transfer section is displayed")
	public void validate_TransferPanel() throws Throwable {
		elementExist(inclusionNew.getTransferSection());
	}

	@Then("^validate that the Hotel section is displayed")
	public void validate_HotelPanel() throws Throwable {
		Thread.sleep(4000);
        scrollDown();
		scrolltoElement(activityPage.getInclusions());
		clickAction(activityPage.getInclusions());
		clickAction(hotelPage.getStays());
		try {
			validateAssertion(elementDisplayed(inclusionNew.getHotelSection()));
			System.out.println("Hotels displayed in the itinerary");

		} catch (Exception e) {
			System.out.println("Hotels not displayed in the itinerary");
			e.printStackTrace();
		}
	}

	@Then("^validate that the Visa and insurance section is displayed")
	public void validate_VisHotePanel() throws Throwable {
		elementExist(inclusionNew.getVisaSection());
	}

	@Then("^validate that the Pass section is displayed")
	public void validate_PassPanel() throws Throwable {
		elementExist(inclusionNew.getPassSection());
	}

	@Then("^validate that the Summary section is displayed")
	public void validate_SummaryPanelPanel() throws Throwable {
		elementExist(inclusionNew.getSummarySection());
	}

	@Then("^validate whether Flight change is selected$")
	public void validate_whether_Flight_change_is_selected() throws Throwable {
	//	switchWindows();
	//	scrolltoElement(inclusionNew.getFlightSection());
		try {
//			waitForMe(inclusion.getFlightChangeButton());
			pollingWait(inclusion.getFlightChangeButton(), 30);
			scrolltoElement(inclusion.getFlightChangeButton());
			clickAction(inclusion.getFlightChangeButton());
//			pollingWait(ip.getgotItPopup(), 120);
			
		} catch (NoSuchElementException e) {
			pollingWait(inclusionNew.getRetryFlight(),30);
			scrolltoElement(inclusionNew.getRetryFlight());
			clickAction(inclusionNew.getRetryFlight());
			pollingWait(ip.getgotItPopup(), 60);

		} catch (Exception ex) {
			System.out.println("There are no Flights displayed ");
			// ReporteraddStepLog("There are no Flights displayed ");
		}
	}
	





}
