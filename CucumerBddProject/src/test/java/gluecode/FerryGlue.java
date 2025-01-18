package gluecode;

import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class FerryGlue extends Kernel {
	
	@Then("^validate that the Ferry section is displayed in Edit Route and Inclusion Page$")
	public void validate_that_the_Ferry_section_is_displayed() throws Throwable {
		try {
//			waitForMe(ed.getFirstCityInYourRoute(),60);
//			clickAction(inclusion.getitineraryTab(),"user navigate to Itinerary tab");
			if (!elementExist(ed.getTransferByFerry())) {
				hoverWebelement(ferryPage.getFlightInYourRoute());
				
				if(elementExist(ferryPage.getReplaceTransfer())) {
				clickAction(ferryPage.getReplaceTransfer());
				clickAction(ferryPage.getAlternateFerry());
				Thread.sleep(500);
				clickAction(ed.getUpdateTripCost());
				pollingWait(inclusion.getBookNow(),150);
				clickAction(inclusion.getActivityTabInclusions());
				Thread.sleep(500);
              validateAssertion(elementExist(inclusionNew.getFerrySection()));
				System.out.println("Ferry section is displayed in inclusion page");
				}
				else {
					System.out.println("Ferry option isn't available on replace option");
				}
				
			}else {
				validateAssertion(elementExist(ed.getTransferByFerry()));
				clickAction(inclusion.getActivityTabInclusions());
				Thread.sleep(500);
				validateAssertion(elementExist(inclusionNew.getFerrySection()));
				System.out.println("Ferry section is displayed on both Itinerary page and Inclusion page");
				
			}
		} catch (NoSuchElementException e) {
			System.out.println("There is an issue on ferry line item - Its not available");
              e.printStackTrace();
		}
	}

	@Then("^validate the ferry is changed$")
	public void validate_the_ferry_change_view() throws Throwable {
		scrollToView(ferryPage.getFerrySection());
		moveTo(driver, ferryPage.getFerrySection());
	    clickAction(ferryPage.getFerrySection());
	    validate_String_Contains(getCurrentUrl(), "ferry-deatils");
	    System.out.println("Ferry is validated");
	}






















}
