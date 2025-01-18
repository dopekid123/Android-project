package gluecode;

import static org.junit.Assume.assumeTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class FlightsGlue extends Kernel {

	protected void view_alternate_flights(String source) throws Throwable {

		if (source.contentEquals("International")) {

			try {
				waitForMe(flightPage.getFlightViewDetails());
				clickAction(flightPage.getFlightViewDetails(), "User views the Flight Details");
			} catch (NoSuchElementException e) {
				clickAction(inclusionNew.getRetryFlight());
//				pollingWait(flightPage.getFlightViewDetails(),15);
//				clickAction(flightPage.getFlightViewDetails(), "User views the Flight Details");
			} catch (Exception ex) {
				// ReporteraddStepLog("There are no International Flights displayed even after
				// retrying ");
			}

		} else if (source.contentEquals("Internal")) {

			try {

				waitForMe(flightPage.getChangeInternalFlight());
				clickAction(flightPage.getChangeInternalFlight(), "User views the internal flight details");

			} catch (NoSuchElementException e) {
				System.out.println("Retrying....");
				scrollByValue(200);
				clickAction(inclusionNew.getRetryFlight());

//				pollingWait(flightPage.getAvailableAlternateFlightsCount(),80);
				select_alternate_flight();
//				clickAction(flightPage.getChangeInternalFlight(), "User views the internal flight details");

				/*
				 * Commented by Nirmal on 27/07/2021 because "got It" popup is not available in
				 * alternates page pollingWait(ip.getgotItPopup(), 180);
				 * waitForMe(ip.getgotItPopup()); if(elementDisplayed(ip.getgotItPopup())) {
				 * 
				 * clickAction(ip.getgotItPopup()); }
				 */
			} catch (Exception ex) {
				// ReporteraddStepLog("There are no Internal Flights displayed even after
				// retrying");
			}
		}

//		try {
//			waitForMe(inclusion.getFlightChangeButton());
//			clickAction(inclusion.getFlightChangeButton());
//		} catch (NoSuchElementException e) {
//
//			//ReporteraddStepLog("Retrying the Flights");
//			clickAction(inclusionNew.getRetryFlight());
//		}
//		catch (Exception ex)
//		{
//			//ReporteraddStepLog("There are no Flights displayed even after retrying");
//		}
//
//		//For closing the smart filter popup
//		if(elementDisplayed(ip.getgotItPopup())) {
//
//			clickAction(ip.getgotItPopup());
//		}

	}

	protected void select_alternate_flight() throws Throwable {
		boolean flightsAvailable = true;

		try {
			/*
			 * Commented by Nirmal on 27/07/2021 because "got It" popup is not available in
			 * the alternates page
			 * 
			 * try { if (elementDisplayed(ip.getgotItPopup())) {
			 * 
			 * clickAction(ip.getgotItPopup()); } } catch (NoSuchElementException e) {
			 * 
			 * }
			 */

			try {
				System.out.println("Inside alternate try...");
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 150);

//				if(driver.findElements(By.xpath("//div[contains(@class,'NoItems__NoItems')]")).size() > 0)
//				{
//					System.out.println("Alternates are not available");
//					clickJavaScriptElement(flightPage.getBackToItinerary());
//					flightsAvailable=false;
//				}
//				

			} catch (Exception e) {
				if (flightPage.getOnwardMiddayFlights().isDisplayed()) {
					pollingWait(flightPage.getNoItemsAvailable(), 30);
					if (elementDisplayed(flightPage.getNoItemsAvailable())) {
						System.out.println("Alternates are not available");
						clickJavaScriptElement(flightPage.getBackToItinerary());
						flightsAvailable = false;
//						assumeTrue(false);
					}
				}
			}

//			popupClosure();
//			pollingWait(flightPage.getFlightReplaceFirstFlight(),180);

			if (flightsAvailable)
//			if(driver.findElements(By.xpath("(//section[@class='flight-card '])[1]")).size() > 0)
			{
				System.out.println("Alternate count: " + getText(flightPage.getAvailableAlternateFlightsCount()));

				scrollByValue(-750);
				clickAction(flightPage.getFlightReplaceFirstFlight(), "User selects the alternate Flight");
				waitForMe(flightPage.getflightAddToItineraryButton());
				clickAction(flightPage.getflightAddToItineraryButton(),
						"User adds the selected Flight to the itinerary ");

				if (driver.findElements(By.xpath("//button[@class='confirm']")).size() > 0) {
					Thread.sleep(4000);
					waitForMe(flightPage.getArrivalDateChanged());
					clickAction(flightPage.getArrivalDateChanged());
					clickAction(inclusion.getUpdateCost());
					waitForMe(inclusion.getBookNow());
					if (verifyStringNotEquals(getCurrentUrl(), "alternate-flights")) {
						// ReporteraddStepLog("Alternate flights has been added in the Inclusions
						// page");
						validateAssertion(elementDisplayed(inclusion.getBookNow()));
						System.out.println("Alternate flights has been added in the Inclusions page");
					}

				} else {
					waitForMe(inclusion.getBookNow());
					if (verifyStringNotEquals(getCurrentUrl(), "alternate-flights")) {
						// ReporteraddStepLog("Alternate flights has been added in the Inclusions
						// page");
						validateAssertion(elementDisplayed(inclusion.getBookNow()));
						System.out.println("Alternate flights has been added in the Inclusions page");
					}
				}
			}
//			else
//			{
//				//ReporteraddStepLog("There are no alternate flights to select");
//				assumeTrue(false);
//				
//				
//			}

		} catch (NoSuchElementException e) {
			System.out.println(("Alternate flights are not loading"));
			// ReporteraddStepLog("Alternate flights are not loading");
		}
	}

	protected void validate_selected_flight_details() throws Throwable {

		String onwDepTime = flightPage.getOnwDepTimeFromFlightCard().getText();
		String onwDepCity = flightPage.getOnwDepCityFromFlightCard().getText();
		String onwArrTime = flightPage.getOnwArrTimeFromFlightCard().getText();
		String onwArrCity = flightPage.getOnwArrCityFromFlightCard().getText();

		// div[@name='all-flight-panels']/div/section[1]//div[contains(@class,'mbottom')][1]//*/div[contains(@class,'route-details')]//*/div//b
	}

	@And("validate the flight change view")

	public void flight_Update() throws Throwable {

		view_alternate_flights("International");
		select_alternate_flight();

	}

	@And("^validate that smart filtered flight option is chosen successfully$")

	public void select_smart_filter() throws Throwable {

		/*
		 * Commented by Nirmal on 27/07/2021 The "Got It" popup is not shown in the
		 * current alternates page. Hence commenting this code
		 * 
		 * pollingWait(ip.getgotItPopup(), 15); //
		 * view_alternate_flights("International");
		 * if(elementDisplayed(ip.getgotItPopup())) { clickAction(ip.getgotItPopup()); }
		 * 
		 */

		try {
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 200);
			clickAction(flightPage.getFlightSmartFilter());

		} catch (Exception ex) {
			System.out.println("Alternate flights are not loading within the given 180 seconds timeout");
			Assert.fail();
		}

		try {
			
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 200);
			if(driver.findElements(By.xpath("//div[@class='option-header']/p")).size() < 0)
			{
				System.out.println("No alternate flights found for Smart filter. Hence costing with smart filter disabled");
				Thread.sleep(3000);
			}
			
			Thread.sleep(5000);
			

		} catch (Exception e) {
			System.out.println("No alternate flights found for Smart filter. Hence costing with smart filter disabled");
			Thread.sleep(3000);
			clickAction(flightPage.getFlightSmartFilter());
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);

		}

	}

	@And("^validate that direct flight option is chosen successfully$")

	public void select_direct_flights_filter() throws Throwable {

//		view_alternate_flights("International");
//		popupClosure();
		pollingWait(ip.getgotItPopup(), 180);
		waitForMe(ip.getgotItPopup());
		if (elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}

		waitForMe(flightPage.getDirectFlights());
		clickAction(flightPage.getDirectFlights(), "User chooses 'Direct' filter for flights");
		select_alternate_flight();

	}

	@And("^validate that one stop flight option is chosen successfully$")

	public void select_one_stop_flights_filter() throws Throwable {

		waitForMe(flightPage.getOneStopFlights());
		clickAction(flightPage.getOneStopFlights(), "User chooses '1 stop' filter for flights");
		select_alternate_flight();

	}

	@And("^validate that two stop flight option is chosen successfully$")

	public void select_two_stop_flights_filter() throws Throwable {

		waitForMe(flightPage.getTwoStopFlights());
		clickAction(flightPage.getTwoStopFlights(), "User chooses '2 stops' filter for flights");
		select_alternate_flight();

	}

	@And("^validate that early morning flight option for onward journey is chosen successfully$")

	public void select_dep_early_morning_flights_filter() throws Throwable {
		pollingWait(ip.getgotItPopup(), 180);
		waitForMe(ip.getgotItPopup());
		if (elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getOnwardEarlyMorningFlights());
		clickAction(flightPage.getOnwardEarlyMorningFlights(), "User chooses 'Early morning' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that early morning flight option for return journey is chosen successfully$")

	public void select_arr_early_morning_flights_filter() throws Throwable {
//		waitForMe(ip.getgotItPopup());
//		if(elementDisplayed(ip.getgotItPopup())) {
//
//			clickAction(ip.getgotItPopup());
//		}
		waitForMe(flightPage.getReturnEarlyMorningFlights());
		clickAction(flightPage.getReturnEarlyMorningFlights(), "User chooses 'Early morning' filter for return flight");
		select_alternate_flight();

	}

	@And("^validate that morning flight option for onward journey is chosen successfully$")

	public void select_dep_morning_flights_filter() throws Throwable {
		pollingWait(ip.getgotItPopup(), 180);
		waitForMe(ip.getgotItPopup());
		if (elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getOnwardMorningFlights());
		clickAction(flightPage.getOnwardMorningFlights(), "User chooses 'Morning' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that morning flight option for return journey is chosen successfully$")

	public void select_arr_morning_flights_filter() throws Throwable {
//		waitForMe(ip.getgotItPopup());		
//		if(elementDisplayed(ip.getgotItPopup())) {
//
//			clickAction(ip.getgotItPopup());
//		}

		waitForMe(flightPage.getReturnMorningFlights());
		clickAction(flightPage.getReturnMorningFlights(), "User chooses 'Morning' filter for return flight");
		select_alternate_flight();

	}

	@And("^validate that mid-day flight option for onward journey is chosen successfully$")

	public void select_dep_midday_flights_filter() throws Throwable {
		pollingWait(ip.getgotItPopup(), 180);
		waitForMe(ip.getgotItPopup());
		if (elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}

		waitForMe(flightPage.getOnwardMiddayFlights());
		clickAction(flightPage.getOnwardMiddayFlights(), "User chooses 'Mid-day' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that mid-day flight option for return journey is chosen successfully$")

	public void select_arr_midday_flights_filter() throws Throwable {

//		waitForMe(ip.getgotItPopup());
//		if(elementDisplayed(ip.getgotItPopup())) {
//
//			clickAction(ip.getgotItPopup());
//		}

		waitForMe(flightPage.getReturnMiddayFlights());
		clickAction(flightPage.getReturnMiddayFlights(), "User chooses 'Mid-day' filter for return flight");
		select_alternate_flight();

	}

	@And("^validate that night flight option for onward journey is chosen successfully$")

	public void select_dep_night_flights_filter() throws Throwable {

//		view_alternate_flights("International");
		pollingWait(ip.getgotItPopup(), 180);
		waitForMe(ip.getgotItPopup());
		if (elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}

		waitForMe(flightPage.getOnwardNightFlights());
		clickAction(flightPage.getOnwardNightFlights(), "User chooses 'Night' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that night flight option for return journey is chosen successfully$")

	public void select_arr_night_flights_filter() throws Throwable {

//		waitForMe(ip.getgotItPopup());
//		if(elementDisplayed(ip.getgotItPopup())) {
//
//			clickAction(ip.getgotItPopup());
//		}

		waitForMe(flightPage.getReturnNightFlights());
		clickAction(flightPage.getReturnNightFlights(), "User chooses 'Night' filter for return flight");
		select_alternate_flight();

	}

	@And("^validate that refundable option for flights is chosen successfully$")

	public void select_refundable_flights_filter() throws Throwable {

		pollingWait(ip.getgotItPopup(), 180);
		waitForMe(ip.getgotItPopup());
		if (elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}

		waitForMe(flightPage.getRefundableFlights());
		clickAction(flightPage.getRefundableFlights(), "User chooses 'Refundable' filter for flights");
		select_alternate_flight();

	}

	@And("^validate that non refundable option for flights is chosen successfully$")

	public void select_non_refundable_flights_filter() throws Throwable {

//		view_alternate_flights("International");
//		waitForMe(ip.getgotItPopup());
//		if(elementDisplayed(ip.getgotItPopup())) {
//
//			clickAction(ip.getgotItPopup());
//		}

		waitForMe(flightPage.getNonRefundableFlights());
		clickAction(flightPage.getNonRefundableFlights(), "User chooses 'Non Refundable' filter for flights");
		select_alternate_flight();

	}

	@And("^validate that more flight options in a flight card is displayed$")

	public void view_more_flight_options() throws Throwable {

//		view_alternate_flights("International");

		/*
		 * Commented by Nirmal on 02/08/2021 because there is no "Got It" popup
		 * displayed in the alternates page waitForMe(ip.getgotItPopup());
		 * if(elementDisplayed(ip.getgotItPopup())) {
		 * 
		 * clickAction(ip.getgotItPopup()); }
		 * 
		 */
		Thread.sleep(1000);
		waitForMe(flightPage.getMoreFlightOpts());
		clickAction(flightPage.getMoreFlightOpts(), "User chooses '+ more flight options' in a flight card");
	}

	@And("^validate that flight is chosen from displayed options$")

	public void choose_from_more_flight_options() throws Throwable {
		pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);
		scrollByValue(100);
		Thread.sleep(1000);
		clickAction(flightPage.chooseFlightOption(),
				"User chooses an option from '+ more flight options' in a flight card");
		Thread.sleep(1000);
		scrollTo(0);
		clickAction(flightPage.replaceWithinSameFlight(),
				"User clicks on 'Replace' after choosing flight from active flight card");

//		waitForMe(flightPage.getflightAddToItineraryButton());
//		clickAction(flightPage.getflightAddToItineraryButton(), "User adds the selected Flight to the itinerary ");

		if (driver.findElements(By.xpath("//button[@class='confirm']")).size() > 0) {

			Thread.sleep(5000);
			waitForMe(flightPage.getArrivalDateChanged());
			clickAction(flightPage.getArrivalDateChanged());
			waitForMe(inclusion.getBookNow());
			if (verifyStringNotEquals(getCurrentUrl(), "alternate-flights")) {
				// ReporteraddStepLog("Alternate flights has been added in the Inclusions
				// page");
			}
		} else {
			waitForMe(inclusion.getBookNow());
			if (verifyStringNotEquals(getCurrentUrl(), "alternate-flights")) {
				// ReporteraddStepLog("Alternate flights has been added in the Inclusions
				// page");
			}
		}

	}

	@And("^validate that internal flight is changed successfully$")

	public void change_internal_flight() throws Throwable {

		view_alternate_flights("Internal");
		select_alternate_flight();

	}

	@And("^validate that internal flight provider is changed successfully$")

	public void change_internal_flight_provider() throws Throwable {

		// Change Pyton as internal flight provider
		view_alternate_flights("Internal");
		/*
		 * Commented by Nirmal on 27/07/2021 because "got It" popup is not available in
		 * the alternates page
		 * 
		 * pollingWait(ip.getgotItPopup(), 180); waitForMe(ip.getgotItPopup());
		 * 
		 * if(elementDisplayed(ip.getgotItPopup())) {
		 * 
		 * clickAction(ip.getgotItPopup()); }
		 */

		waitForMe(flightPage.getChangePyton());
		clickAction(flightPage.getChangePyton(), "User changes Pyton as source provider for internal flights");
		select_alternate_flight();

		// Change Skypicker as internal flight provider
		view_alternate_flights("Internal");
		waitForMe(flightPage.getChangeSkypicker());
		clickAction(flightPage.getChangeSkypicker(), "User changes Skypicker as source provider for internal flights");
		select_alternate_flight();
	}

	@And("^validate changing the flight is done$")

	public void validate_the_changing_the_flight() throws Throwable {

		if (elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}

		select_alternate_flight();

	}

	@Then("^validate that internal flight section is displaying$")
	public void validate_that_internal_flight_section_is_displaying() throws Throwable {
		validateAssertion(elementDisplayed(flightPage.getInternalFlightAPI()));
	}

	@Then("^validate that number of stop flight filter options$")
	public void no_Of_Stops_Filter() throws Throwable {
		try {
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 150);
		} catch (Exception e) {
			System.out.println("No Alternate Flights are available");
			assumeTrue(false);
		}
		List<String> stopFilter = new ArrayList<String>();
		stopFilter.add("Direct");
		stopFilter.add("1 stop");
		stopFilter.add("2 stops");
		for (int i = 0; i < stopFilter.size(); i++) {
			System.out.println("Validating " + stopFilter.get(i) + " filter in Flights Alternate");
			switch (stopFilter.get(i)) {
			case "1 stop": {
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 150);
				Thread.sleep(2000);
				clickAction(flightPage.getOneStopFlights(), "User chooses '1 stop' filter for flights");
				validateFlightFilters(stopFilter.get(i));
				clickAction(flightPage.getOneStopFlights(), "User chooses '1 stop' filter for flights");
				Thread.sleep(2000);
				break;
			}
			case "2 stops": {
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 150);
				Thread.sleep(2000);
				clickAction(flightPage.getTwoStopFlights(), "User chooses '2 stops' filter for flights");
				validateFlightFilters(stopFilter.get(i));
				Thread.sleep(2000);
				break;
			}
			case "Direct": {
				clickAction(flightPage.getDirectFlights(), "User chooses 'Direct' filter for flights");
				Thread.sleep(2000);
				validateFlightFilters(stopFilter.get(i));
				clickAction(flightPage.getDirectFlights(), "User chooses 'Direct' filter for flights");
				Thread.sleep(2000);
				break;
			}
			}
		}

	}

	public void validateFlightFilters(String filter) throws Throwable {
		try {
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);
		} catch (Exception e) {
			System.out.println("No alternate flight found for " + filter);
		}
		validate_the_filter_applied_successfully(filter);
	}

	@Then("^validate that onward journey flight filter options$")
	public void validate_that_onward_journey_flight_filter() throws Throwable {
		try {
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);
		} catch (Exception e) {
			System.out.println("No Alternate Flights are available");
			assumeTrue(false);
		}
		/*
		 * Commented by Nirmal on 27/07/2021 because of "No Got It" popup in Alternates
		 * page popupClosure(); popupClosure();
		 */
		List<String> departureFilter = new ArrayList<String>();
		departureFilter.add("Early Morning");
		departureFilter.add("Morning");
		departureFilter.add("Mid-Day");
		departureFilter.add("Night");
		for (int i = 0; i < departureFilter.size(); i++) {
			switch (departureFilter.get(i)) {
			case "Early Morning": {
				pollingWait(trainsPage.getOnwardEarlyMorningTrains(),30);
				scrolltoElement(trainsPage.getOnwardEarlyMorningTrains());
				clickAction(trainsPage.getOnwardEarlyMorningTrains(),
						"User chooses 'Early morning' filter for onward train");
				validateFlightFilters(departureFilter.get(i));
				scrolltoElement(trainsPage.getOnwardEarlyMorningTrains());
				clickAction(trainsPage.getOnwardEarlyMorningTrains(),
						"User chooses 'Early morning' filter for onward train");
				break;
			}
			case "Morning": {
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);
				scrolltoElement(trainsPage.getOnwardMorningTrains());
				clickAction(trainsPage.getOnwardMorningTrains());
				validateFlightFilters(departureFilter.get(i));
				scrolltoElement(trainsPage.getOnwardMorningTrains());
				clickAction(trainsPage.getOnwardMorningTrains());
				break;
			}
			case "Mid-Day": {
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);
				scrolltoElement(trainsPage.getOnwardMiddayTrains());
				clickAction(trainsPage.getOnwardMiddayTrains());
				validateFlightFilters(departureFilter.get(i));
				scrolltoElement(trainsPage.getOnwardMiddayTrains());
				clickAction(trainsPage.getOnwardMiddayTrains());
				break;
			}
			case "Night": {
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 180);
				scrolltoElement(trainsPage.getOnwardNightTrains());
				clickAction(trainsPage.getOnwardNightTrains());
				validateFlightFilters(departureFilter.get(i));
				replaceflight();
				System.out.println("Onward flight updated using filter");
				break;
			}
			}
		}

	}

	@Then("^validate that flight payment filter options$")
	public void payment_Option_Filter() throws Throwable {
		try {
			pollingWait(flightPage.getAvailableAlternateFlightsCount(), 200);
		} catch (Exception e) {
			System.out.println("No Alternate Flights arw available");
			assumeTrue(false);
		}
		/*
		 * Commented by Nirmal on 27/07/2021 because of "No Got It" popup in Alternates
		 * page popupClosure(); popupClosure();
		 */
		List<String> paymentFilter = new ArrayList<String>();
		paymentFilter.add("Refundable");
		paymentFilter.add("Non Refundable");
		for (int i = 0; i < paymentFilter.size(); i++) {
			try {
				if (elementDisplayed(flightPage.getRefundableFlights())) {
					System.out.println("Validating " + paymentFilter.get(i) + " filter in Flights Alternate");
					switch (paymentFilter.get(i)) {
					case "Refundable": {
						clickAction(flightPage.getRefundableFlights(),
								"User chooses 'Refundable' filter for flights");
						validateFlightFilters(paymentFilter.get(i));
						List<WebElement> refundableFlights = driver.findElements(By.xpath("//span[text()='Refundable']"));
						
						if(refundableFlights.size() >0) {
							for(int j = 1; j<2; j++) {
								hoverWebelement(refundableFlights.get(j));
								String refundablePills = getText(refundableFlights.get(j));
								Assert.assertEquals(refundablePills, "Refundable");
							}
							
						}
						
						clickAction(flightPage.getRefundableFlights(),
								"User chooses 'Refundable' filter for flights");
						break;
					}
					case "Non Refundable": {
						pollingWait(flightPage.getAvailableAlternateFlightsCount(), 200);
						clickAction(flightPage.getNonRefundableFlights(),
								"User chooses 'Non Refundable' filter for flights");
						validateFlightFilters(paymentFilter.get(i));
						List<WebElement> nonRefundableFlights = driver.findElements(By.xpath("//span[text()='Non Refundable']"));
						
						if(nonRefundableFlights.size() >0) {
						for(int j = 1; j<2; j++) {
							hoverWebelement(nonRefundableFlights.get(j));
							String nonRefundablePills = getText(nonRefundableFlights.get(j));
							Assert.assertEquals(nonRefundablePills, "Non Refundable");
						}
						}
						replaceflight();
						break;
					}
					}
				}

			} catch (Exception e) {
				System.out.println("Payment filter not available");
				Assert.fail();
			}
		}
	}

	@Then("^user selects the alternate flight from the alternate flight section$")
	public void user_selects_the_alternate_flight_from_the_alternate_flight_section() throws Throwable {
		replaceflight();
	}

	@Given("user validates the costing flow for selected {string}")
	public void user_validates_the_costing_flow_for_selected(String region) {
		itineraryCostingFlow(region);
	}

	@Then("validate that flights changed using smart filter")
	public void validate_that_flights_changed_using_smart_filter() {
		replaceflight();
	}

	@Then("validate that number of stop filter options")
	public void validate_that_number_of_stop_filter_options() throws Throwable {
		flightStopFilter();
	}

	@Given("Signup to the application with valid username and password with {string} and {string}")
	public void signup_to_the_application_with_valid_username_and_password_with(String uName, String passwd) {
		signUpAsExistingUser(uName, passwd);
	}

	@Then("validate whether Flight view details is selected")
	public void validate_whether_flight_view_details_is_selected() {
		clickflightsViewDetails();
	}

	@Then("validate whether existing flight removed")
	public void validate_whether_existing_flight_removed() {
		removeFlights();
	}

	@Then("validate whether All functions in flight page working as expected")
	public void validate_whether_all_functions_in_flight_page_working_as_expected() {
		validateAllFlightsFunctionalities();
	}
	
	@Then("Add the flights in edit details option")
	public void add_the_flights_in_edit_details_option() throws InterruptedException {
		try
		{
			isElementVisible(flightPage.getEditDetails(), 30);
			scrolltoElement(flightPage.getEditDetails());
			clickAction(flightPage.getEditDetails());
			
			scrolltoElement(flightPage.getDepartureFrom());
			isElementVisible(flightPage.getDepartureFrom(), 25);
			clickAction(flightPage.getDepartureFrom());
			
			scrolltoElement(flightPage.getChennaiMAA());
			isElementVisible(flightPage.getChennaiMAA(), 25);
			clickAction(flightPage.getChennaiMAA());
			
			scrolltoElement(flightPage.getDepartureDate());
			isElementVisible(flightPage.getDepartureDate(), 25);
			clickAction(flightPage.getDepartureDate());
			
			isElementVisible(flightPage.getDepartureday(), 25);
			scrolltoElement(flightPage.getDepartureday());
			clickAction(flightPage.getDepartureday());
			
			isElementVisible(flightPage.getViewPrice(), 25);
			scrolltoElement(flightPage.getViewPrice());
			clickDisbledJavaScriptElement(flightPage.getViewPrice());
		//	switchWindows();
			Thread.sleep(2000);
		//	switchWindows();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
		
	}
	

	@Then("Switch to flights itinerary")
	public void switch_to_flights_itinerary() throws InterruptedException {
		try {
			Thread.sleep(15000);
			pageRefresh();
			pollingWaitWithoutClickable(flightPage.getCheckFlightPrice(), 60);
			scrolltoElement(flightPage.getCheckFlightPrice());
			hoverWebelement(flightPage.getCheckFlightPrice());
			clickAction(flightPage.getCheckFlightPrice());
			switchWindows();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
       
	}





}
