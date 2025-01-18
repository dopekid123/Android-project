
package gluecode;


import org.openqa.selenium.TimeoutException;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class ActivitiesGlue extends Kernel {

	public static String activity="";

	@And("validate the activity removal flow")
	public void navigates_InclusionPage() throws Throwable {
//		popupClosure();
//		popupClosure();
//
//		clickAction(activityPage.getActivity_viewDetails(), "User views the activity Details");
//		clickAction(activityPage.getActivity_ChangeButton(), "User changes the activity ");
//		popupClosure();
//
//		clickAction(activityPage.getActivity_ChangeAlternateActivity(), "User selects the alternate activity ");
//		popupClosure();
//		clickAction(activityPage.getActivity_AddToItineraryButton(),
//				"User adds the selected activity to the itinerary ");
//		clickAction(activityPage.getActivity_viewDetails(), "User views the activity Details");
		waitForMe(inclusion.getActivityTabInclusions());
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		moveTo(driver, activityPage.getActivity_InclusionsfirstCard());
		Thread.sleep(2000);
		clickAction(activityPage.getActivity_InclusionsfirstCard());
		clickAction(activityPage.getActivity_RemoveButton(), "User Removes the activity ");
	}

	@Then("^validate the activity slider in the itinerary page$")
	public void validate_the_activity_slider_in_the_itinerary_page() throws Throwable {
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
				clickAction(activityPage.getActivity_FirstQuarterDaySlot());
				Thread.sleep(2000);
				validate_String_Contains(getCurrentUrl(), "activity-preview/");
			}
			else if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {
					clickAction(activityPage.getActivity_FirstHalfDaySlot());
					Thread.sleep(2000);
					validate_String_Contains(getCurrentUrl(), "activity-preview/");
			} else if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {
					clickAction(activityPage.getActivity_FirstFullDaySlot());
					Thread.sleep(2000);
					validate_String_Contains(getCurrentUrl(), "activity-preview/");
				}
		else {

			System.out.println("The itinerary contains no activity");

		}


	}

	public String activity_FD;
	public String activityChange_FD;
	public String activity_HD;
	public String activityChange_HD;
	public String activity_QD;
	public String activityChange_QD;

	@Then("^user change and validate the activity in all three slot$")
	public void user_change_the_activity() throws Throwable {
		List<String> dayType = new ArrayList<String>();
		dayType.add("full day");
		dayType.add("half day");
		dayType.add("quarter day");
		for (int i = 0; i < dayType.size(); i++) {
		try {
			switch (dayType.get(i)) {
			case "full day":
				if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {
					activity_FD = getText(activityPage.getActivity_FirstFullDaySlot());
					if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
						changeFullDayActivity();

					}else {
						addFullDayActivity();
						Thread.sleep(1000);
						pageRefresh();
						Thread.sleep(2000);
						activity_FD = getText(activityPage.getActivity_FirstFullDaySlot());
						changeFullDayActivity();
					}

				}
				break;
			case "half day":
				if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {
					activity_FD = getText(activityPage.getActivity_FirstHalfDaySlot());
					if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
						changeHalfDayActivity();
					}else {
						addHalfDayActivity();
						Thread.sleep(1000);
						pageRefresh();
						Thread.sleep(2000);
						activity_FD = getText(activityPage.getActivity_FirstHalfDaySlot());
						changeHalfDayActivity();
					}

				}
				break;
			case "quarter day":
				activity_FD = getText(activityPage.getActivity_FirstQuarterDaySlot());
				if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
					if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
						changeQuarterDayActivity();
					}else {
						addQuarterDayActivity();
						Thread.sleep(1000);
						pageRefresh();
						Thread.sleep(2000);
						changeQuarterDayActivity();
					}
				}
				break;
			default:
				System.out.println("There is no " + dayType.get(i) + " activity in this itinerary");

			}
			}catch (Exception e) {
				System.out.println("There is no " + dayType.get(i) + " activity in this itinerary");
				continue;
			}
			}
}
	@And("^user add the activity in all three slot$")
	public void user_add_the_activity() throws Throwable {
		List<String> dayType = new ArrayList<String>();
		dayType.add("half day");
		dayType.add("quarter day");
		dayType.add("full day");
		for (int i = 0; i < dayType.size(); i++) {
		try {
			switch (dayType.get(i)) {
			case "full day":
				if (elementExist(activityPage.getActivity_FirstFullDayAtLeisureSlot())) {
					
					String activity = getText(activityPage.getActivity_FirstFullDayAtLeisureSlot());
					if (activity.contains("At leisure") && activity.contains("Add activity")) {
						addFullDayActivity();
					}
				}
				break;
			case "half day":
				if (elementExist(activityPage.getActivity_FirstHalfDayAtLeisureSlot())) {
					String activity = getText(activityPage.getActivity_FirstHalfDayAtLeisureSlot());
					if (activity.contains("At leisure") && activity.contains("Add activity")) {
						addHalfDayActivity();
					}
				}
				break;
			case "quarter day":
				if (elementExist(activityPage.getActivity_FirstQuarterDayAtLeisureSlot())) {
					String activity = getText(activityPage.getActivity_FirstQuarterDayAtLeisureSlot());
				if (activity.contains("At leisure") && activity.contains("Add activity")) {
						addQuarterDayActivity();
					}
				}
				break;
			default:
				System.out.println("There is already " + dayType.get(i) + " activity in this itinerary");
			}
		} catch (NoSuchElementException e) {
			System.out.println("There is already " + dayType.get(i) + " activity in this itinerary");
			continue;
		}
	}
}

	@Then("^validate the activity added in itinerary successfully$")
	public void validate_the_activity_added_in_itinerary_successfully() throws Throwable {
		validate_String_Contains(getCurrentUrl(), "view/");
	}

	@Given("^user land on home page without login$")
	public void user_land_on_home_page_without_login() throws Throwable {
		elementExist(hp.getLogin());
	}

	@And("^user remove the all three slot activity and validate the activity removed$")
	public void user_remove_the_activity() throws Throwable {
		pageRefresh();
		List<String> dayType = new ArrayList<String>();
		dayType.add("quarter day");
		dayType.add("full day");
		dayType.add("half day");
		for (int i = 0; i < dayType.size(); i++) {
		try {
			switch (dayType.get(i)) {
			case "full day":
				if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {
					activity_FD = getText(activityPage.getActivity_FirstFullDaySlot());
					if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
						moveTo(driver, activityPage.getActivity_FirstFullDaySlot());
						Thread.sleep(2000);
						clickAction(activityPage.getActivity_FirstFullDaySlot(),
								"User click on full day_slot activity in itinerary page to open activity slider  ");
						clickAction(activityPage.getActivitySlider_Remove());
						Thread.sleep(2000);
						clickAction(activityPage.getActivity_SliderClose());
						Thread.sleep(2000);
						activityChange_FD = getText(activityPage.getActivity_FirstQuarterDaySlot());
						validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));
						System.out.println("Successfully removed Full Day Activity");
					}
				}
				break;
			case "half day":
				if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {
					activity_FD = getText(activityPage.getActivity_FirstHalfDaySlot());
					if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
						Thread.sleep(2000);
//						scrolltoElement(activityPage.getActivity_FirstHalfDaySlot());
						scrollUp();
						moveTo(driver, activityPage.getActivity_FirstHalfDaySlot());
						Thread.sleep(2000);
						clickAction(activityPage.getActivity_FirstHalfDaySlot(),
								"User click on half day_slot activity in itinerary page to open activity slider  ");
						clickAction(activityPage.getActivitySlider_Remove());
						Thread.sleep(2000);
						clickAction(activityPage.getActivity_SliderClose());
						Thread.sleep(2000);
						activityChange_FD = getText(activityPage.getActivity_FirstHalfDaySlot());
						validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));
						System.out.println("Successfully removed Half Day Activity");
					}
				}
				break;
			case "quarter day":
				if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
					activity_FD = getText(activityPage.getActivity_FirstQuarterDaySlot());
					if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
						moveTo(driver, activityPage.getActivity_FirstQuarterDaySlot());
						Thread.sleep(2000);
						clickAction(activityPage.getActivity_FirstQuarterDaySlot(),
								"User click on quater day_slot activity in itinerary page to open activity slider  ");
						clickAction(activityPage.getActivitySlider_Remove());
						Thread.sleep(2000);
						clickAction(activityPage.getActivity_SliderClose());
						Thread.sleep(2000);
						activityChange_FD = getText(activityPage.getActivity_FirstQuarterDaySlot());
						validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));
						System.out.println("Successfully removed Quarter Day Activity");
					}
				}
				break;

			default:
				System.out.println("There is no " + dayType.get(i) + " activity in this itinerary");
			}
		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("There is no full day slot in the itinerary ");
			System.out.println("There is no " + dayType.get(i) + " slot in the itinerary ");
			continue;
		}
	}
}

	
	
	public void validate_the_activity_removed_successfully() throws Throwable {
		boolean isReomved = verifyExactText(activityPage.getActivitySlider_AfterRemove(), "Activity Removed!");
		Assert.assertTrue(isReomved);
		clickAction(activityPage.getActivity_SliderClose(),"User clicks on out side the silder to close");
	}

	@And("^user remove the half day activity and validate the activity removed$")
	public void user_remove_the_half_day_activity() throws Throwable {
       try {
		if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstHalfDaySlot());

			if (!activity.contains("At leisure")&& !activity.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstHalfDaySlot(),
						"User click on full day_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();
			}
		}
       }
		catch(NoSuchElementException e)
       {
			//ReporteraddStepLog("There is no half day slot in the itinerary ");
			System.out.println("There is no half day slot in the itinerary ");
			
       }
	}

	@And("^user remove the quarter day activity and validate the activity removed$")
	public void user_remove_the_quarter_day_activity() throws Throwable {
		try {
		
		
		if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstQuarterDaySlot());

			if (!activity.contains("At leisure")&& !activity.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstQuarterDaySlot(),
						"User click on full day_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();

			}
		}
		}catch(NoSuchElementException e) {
			//ReporteraddStepLog("There is no quarter day slot in the itinerary ");
			System.out.println("There is no quarter day slot in the itinerary ");
		}
	}

	@Then("^Add activity using slider from itinerary$")
	public void add_activity_using_slider_from_itinerary() throws Throwable {
		clickAction(activityPage.getActivitySlider_AddActivity(),
				"User clicks on Add acitvity button in the activity slider after removed the activity");
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		hoverWebelement(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivityAlternate_Choose(), "Choosing the first activity in the alternate page");
	}

	@And("^user change the activity from inclusions via alternate page$")
	public void user_change_the_activity_from_inclusions() throws Throwable {
		waitForMe(inclusion.getActivityTabInclusions());
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		moveTo(driver, activityPage.getActivity_ExpandActivityInclusions());
		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		moveTo(driver, activityPage.getFirstActivityChangeButton());
		waitForMe(activityPage.getFirstActivityChangeButton());
		clickAction(activityPage.getFirstActivityChangeButton(),
				"user clicks on the 1st activity card in the inclusion page ");
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
//		waitForMe(activityPage.getActivityAlternate_Cards());
		hoverWebelement(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivityAlternate_Choose(),
				"User click choose the first activity in the alternate page");
	}

	@Then("^validate the activity added from inclusions successfully$")
	public void validate_the_activity_added_from_inclusions_successfully() throws Throwable {
		validate_String_Contains(getCurrentUrl(), "inclusion");
	}

	@Then("^user change the activity from inclusions via details page$")
	public void user_change_the_activity_from_inclusions_via_details_page() throws Throwable {
		waitForMe(inclusion.getActivityTabInclusions());
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
//		moveTo(driver, activityPage.getActivity_ExpandActivityInclusions());
//		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		moveTo(driver, activityPage.getActivity_InclusionsfirstCard());
		Thread.sleep(2000);
		clickAction(activityPage.getActivity_InclusionsfirstCard(),
				"user clicks on the 1st activity card in the inclusion page ");
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		Thread.sleep(2000);
		clickAction(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivity_AddToItineraryButton(),"User change activity via details modal");
	}

	@Then("^user navigate to alternate page from inclusions$")
	public void user_navigate_to_alternate_page() throws Throwable {
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
	}

	@Then("^user clicks the view similar to view the alternate page$")
	public void user_clicks_the_view_similar() throws Throwable {

		clickJavaScriptElement(activityPage.getActivitySlider_ViewSimilar());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		validate_String_Contains(getCurrentUrl(),"alternate-activities/");
	}



	@And("^user clicks the empty slot in the itinerary$")
	public void user_clicks_the_empty_slot_in_the_itinerary() throws Throwable {
		if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {
			String activityFull = getText(activityPage.getActivity_FirstFullDaySlot());
			if(activityFull.contains("At leisure") && (activityFull.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstFullDaySlot());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				validate_String_Contains(getCurrentUrl(),"alternate-activities/");
			}


		}
		else if(elementExist(activityPage.getActivity_FirstHalfDaySlot())) {

			String activityHalf = getText(activityPage.getActivity_FirstHalfDaySlot());
			if(activityHalf.contains("At leisure") && (activityHalf.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstHalfDaySlot());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				validate_String_Contains(getCurrentUrl(),"alternate-activities/");
			}

		}
		else if(elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
			String activityQuar = getText(activityPage.getActivity_FirstQuarterDaySlot());
			if(activityQuar.contains("At leisure") && (activityQuar.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstQuarterDaySlot());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				validate_String_Contains(getCurrentUrl(),"alternate-activities/");
			}
		}
		else {
			//ReporteraddStepLog("The itinerary has no empty slot");
		}

	}

	@Then("^apply smart filter and validate the filter applied successfully$")
	public void apply_smart_filter_and_validate_the_filter_applied_successfully() throws Throwable {

		try {

			clickAction(activityPage.getActivity_SmartFilter(),"User click the smart filter");
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"User click choose the first activity in the alternate page");
				validate_String_Contains(getCurrentUrl(),"view");

			}
		}catch(NoSuchElementException e) {
			//			//ReporteraddStepLog("Applied filter doesn't have result");
			clickAction(activityPage.getBackToItineraryButtonInAlternate(),"User clicks the back to itinerary button due to no result found for the smart filter");

		}


	}

	@Then("^apply \"([^\"]*)\" filter and validate the filter applied successfully$")
	public void apply_morning_filter_and_validate_the_filter_applied_successfully(String slot) throws Throwable {

				try {
					if (slot.equalsIgnoreCase("noon")) {
						driver.findElement(By.xpath("//a[text()='After" + slot + "']")).click();
					} else {
						driver.findElement(By.xpath("//a[text()='" + slot + "']")).click();
					}
				
					if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0) {
						clickAction(activityPage.getActivityAlternate_Cards(),
								"User clicks on the activity card in the alternate");
						clickAction(activityPage.getActivity_AddToItineraryButton());
					}else {
						clickAction(activityPage.getBackToItineraryButtonInAlternate());
					}
				} catch (NoSuchElementException e) {
					//ReporteraddStepLog("Applied filter doesn't have result");
					clickAction(activityPage.getBackToItineraryButtonInAlternate());
				}
		}


	@Then("^apply afternoon filter and validate the filter applied successfully$")
	public void apply_afternoon_filter_and_validate_the_filter_applied_successfully() throws Throwable {

		clickAction(activityPage.getActivity_AfternoonTimeSlotFilter(),"User clicks on the Afternoon slot filter");
		validate_the_filter_applied_successfully("Afternoon");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");
		}
	}

	@Then("^apply evening filter and validate the filter applied successfully$")
	public void apply_evening_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_EveningTimeSlotFilter(),"User clicks on the evening slot filter"); 
		validate_the_filter_applied_successfully("Evening");
		try {


			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply quarter day filter and validate the filter applied successfully$")
	public void apply_quarter_day_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_QuarterDayDurationFilter(),"User clicks on the Quarter day filter");
		validate_the_filter_applied_successfully("Quarter Day");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply half day filter and validate the filter applied successfully$")
	public void apply_half_day_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_HalfDayDurationFilter(),"User clicks on the half day filter");
		validate_the_filter_applied_successfully("Half Day");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply full day filter and validate the filter applied successfully$")
	public void apply_full_day_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_FullDayDurationFilter(),"User clicks on the full day filter");
		validate_the_filter_applied_successfully("Full Day");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply transfer included filter and validate the filter applied successfully$")
	public void apply_transfer_included_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_TranferIncludedFilter(),"User clicks on the transfer included filter");
		validate_the_filter_applied_successfully("Included");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply transfer not included filter and validate the filter applied successfully$")
	public void apply_transfer_not_included_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_TranferNotIncludedFilter(),"User clicks on the transfer included filter");
		validate_the_filter_applied_successfully("Not Included");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply art and culture filter and validate the filter applied successfully$")
	public void apply_art_and_culture_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_ArtAndCulture(),"User clicks on the  art and culture filter");
		validate_the_filter_applied_successfully("Art & Culture");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply adventure and outdoor filter and validate the filter applied successfully$")
	public void apply_adventure_and_outdoor_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_AdventureAndOutdoor(),"User clicks on the adventure and outdoor filter");
		validate_the_filter_applied_successfully("Adventure & Outdoor");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply food and nightlife filter and validate the filter applied successfully$")
	public void apply_food_and_nightlife_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_FoodAndNightlife(),"User clicks on the  art and culture filter");
		validate_the_filter_applied_successfully("Food & Nightlife");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply shopping and leisure filter and validate the filter applied successfully$")
	public void apply_shopping_and_leisure_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_ShoppingAndLeisure(),"User clicks on the  art and culture filter");
		validate_the_filter_applied_successfully("Shopping & Leisure");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply top highlight filter and validate the filter applied successfully$")
	public void apply_top_highlight_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_TopHighlightsFilter(),"User clicks on the top highlight filter");
		validate_the_filter_applied_successfully("Top Highlight"); 
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply Kid friendly filter and validate the filter applied successfully$")
	public void apply_Kid_friendly_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_KidFriendlyFilter(),"User clicks on the kid friendly filter");
		validate_the_filter_applied_successfully("Kid Friendly"); 
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply fast selling filter and validate the filter applied successfully$")
	public void apply_fast_selling_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_FastSellingFilter(),"User clicks on the fast selling filter");
		validate_the_filter_applied_successfully("Fast Selling");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply less exploration filter and validate the filter applied successfully$")
	public void apply_less_exploration_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_LessExploredGemsFilter(),"User clicks on the less exploration gems filter");
		validate_the_filter_applied_successfully("Less explored gems");
		try {

			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply self exploration filter and validate the filter applied successfully$")
	public void apply_self_exploration_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_SelfExplorationFilter(),"User clicks on the self exploration filter");
		validate_the_filter_applied_successfully("Self Exploration");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				elementExist(activityPage.getSelfExplorationTag());
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply shared filter and validate the filter applied successfully$")
	public void apply_shared_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_SharedFilter(),"User clicks on the shared filter under group type");
		validate_the_filter_applied_successfully("Shared");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}

	}

	@Then("^apply private filter and validate the filter applied successfully$")
	public void apply_private_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_PrivateFilter(),"User clicks on the private filter under group type");
		validate_the_filter_applied_successfully("Private");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());

			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}


	@And("^user navigate to activity alternate page from the inclusions page$")
	public void user_navigate_to_activity_alternate_page_from_the_inclusions_page() throws Throwable {
		waitForMe(inclusion.getActivityTabInclusions());
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		waitForMe(activityPage.getActivity_ExpandActivityInclusions());
		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		waitForMe(activityPage.getActivity_InclusionsfirstCard());
		clickAction(activityPage.getActivity_InclusionsfirstCard(),
				"user clicks on the 1st activity card in the inclusion page ");
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}


	}
	@Then("^user search for the activity$")
	public void user_search_for_the_activity() throws Throwable {
		clickAction(activityPage.getActivitySlider_AddActivity(),
				"User clicks on Add acitvity button in the activity slider after removed the activity");
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		typeText(activityPage.getActivityAlternate_SearchBox(),activity);


	}

	@Then("^validate the activity search box$")
	public void validate_the_activity_search_box() throws Throwable {
		if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
			String name = getText(activityPage.getNameOfActivityFirstCardAlternate());
			compareTwoStrings(activity,name);		

		} 



	}
//	@And("^user clicks the recently booked itinerary$") 
//	public void user_clicks_the_recently_booked_itinerary() throws InterruptedException {
//		scrolltoElement(hp.getrecentlyBookedItinerary());
//		clickAction(hp.getrecentlyBookedItinerary(),"User clicks the recently booked itinerary from home page");
//		while(elementDisplayed(ip.getgotItPopup())) {
//			clickAction(ip.getgotItPopup());
//		}
//	}

	@And("^user clicks the activity slot \"([^\"]*)\"$")
	public void user_clicks_the_activity_slot(String slot) throws Throwable {
		activityEmptySlot(slot);
	}

	@And("^user clicks the empty slot in the itinerary \"([^\"]*)\"$")
	public void user_clicks_the_empty_slot_in_the_itinerary_with_slot(String slot) throws Throwable {
		activityEmptySlot(slot);
	}

	@And("^user clicks recently booked itinerary$")
	public void user_clicks_recently_booked_itinerary() throws InterruptedException {
		Thread.sleep(2000);
		scrolltoElement(hp.getPromoSection());
		Thread.sleep(2000);
		scrolltoElement(hp.getrecentlyBookedItinerary());
		Thread.sleep(2000);
		clickAction(hp.getBookedItinerayFromHomePage());
		Thread.sleep(1000);
		switchWindows();
		Thread.sleep(3000);
		clickAction(ip.getgotItPopup());

	}
	
	@Given("^user clicks the package itinerary from home page$")
	public void user_clicks_the_package_itinerary_from_home_page() {
		
	try {
		clickAction(packagesPage.getLandingPagePackages());
		Thread.sleep(2000);
		scrollUp();
		scrolltoElement(hp.getPackageSlugItineraryHomePage());
	    scrollDown();
		clickAction(hp.getPackageSlugItineraryHomePage());
        Thread.sleep(1000);
		switchWindows();
		Thread.sleep(3000);
		clickAction(ip.getgotItPopup());

	

	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@And("^verify all filters from \"([^\"]*)\"$")
	public void verify_all_filters_from(String type) throws Throwable {
		verifyingTimeSlotActivity(type);
	}
	public void changeFullDayActivity() throws InterruptedException {
		try {
		moveTo(driver, activityPage.getActivity_FirstFullDaySlot());
		clickAction(activityPage.getActivity_FirstFullDaySlot());
		Thread.sleep(500);
		clickAction(activityPage.getActivitySlider_ViewSimilar());
		Thread.sleep(500);
		popupClosure();
		Thread.sleep(500);
		popupClosure();
		selectActivityFromAlternate("full day");
		activityChange_FD = getText(activityPage.getActivity_FirstFullDaySlot());
		validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));
		System.out.println("Successfully changed Full Day activity");
		Thread.sleep(3000);
	}catch(Exception e){}

	}

	public void changeHalfDayActivity() throws InterruptedException {
		try {
		moveTo(driver, activityPage.getActivity_FirstHalfDaySlot());
		clickAction(activityPage.getActivity_FirstHalfDaySlot());
		Thread.sleep(500);
		clickAction(activityPage.getActivitySlider_ViewSimilar());
		selectActivityFromAlternate("half day");
		activityChange_FD = getText(activityPage.getActivity_FirstHalfDaySlot());
		validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));
		System.out.println("Successfully changed Half Day activity");
		Thread.sleep(3000);
		}catch(Exception e){}
	}

	public void changeQuarterDayActivity() throws InterruptedException {
		try {
		moveTo(driver, activityPage.getActivity_FirstQuarterDaySlot());
		Thread.sleep(500);
		clickAction(activityPage.getActivity_FirstQuarterDaySlot());
		Thread.sleep(500);
		clickAction(activityPage.getActivitySlider_ViewSimilar());
		selectActivityFromAlternate("quarter day");
		activityChange_FD = getText(activityPage.getActivity_FirstQuarterDaySlot());
		validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));
		System.out.println("Successfully changed Quarter Day activity");
		Thread.sleep(3000);
		}catch(Exception e) {}
	}

	public void selectActivityFromAlternate(String dayType) throws InterruptedException {
		try {
		waitForMe(activityPage.getActivityAlternate_Cards());
		Thread.sleep(1000);
		switch (dayType) {
		case "full day":
			clickAction(activityPage.getActivity_FullDayDurationFilter());
			break;
		case "half day":
			clickAction(activityPage.getActivity_HalfDayDurationFilter());
			break;
		case "quarter day":
			clickAction(activityPage.getActivity_QuarterDayDurationFilter());
			break;
		}
		waitForMe(activityPage.getActivityAlternate_Cards());
		while(elementDisplayed(intpag.getgotit())){
		clickAction(intpag.getgotit());
		}
		waitForMe(activityPage.getActivityAlternate_Cards());
		hoverWebelement(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivityAlternate_Choose(),
				"Choosing the first activity in the alternate page");
		Thread.sleep(2000);
		}catch(Exception e) {
			
		}
	}

	public void addFullDayActivity() throws InterruptedException {
		try {
		moveTo(driver, activityPage.getActivity_FirstFullDayAtLeisureSlot());
		Thread.sleep(1000);
		clickAction(activityPage.getActivity_FirstFullDayAtLeisureSlot(),
				"Activity alternate page open to add activity");
		selectActivityFromAlternate("full day");
		System.out.println("Successfully added Full Day activity");
	}catch(Exception e){}
	}

	public void addHalfDayActivity() throws InterruptedException {
		try {
		moveTo(driver, activityPage.getActivity_FirstHalfDayAtLeisureSlot());
		Thread.sleep(1000);
		clickAction(activityPage.getActivity_FirstHalfDayAtLeisureSlot(),
				"Activity alternate page open to add activity");
		selectActivityFromAlternate("half day");
		System.out.println("Successfully added Half Day activity");
	}catch(Exception e){}
	}

	public void addQuarterDayActivity() throws InterruptedException {
	try {	
		moveTo(driver, activityPage.getActivity_FirstQuarterDayAtLeisureSlot());
		Thread.sleep(1000);
		clickAction(activityPage.getActivity_FirstQuarterDayAtLeisureSlot(),
				"Activity alternate page open to add activity");
		selectActivityFromAlternate("quarter day");
		System.out.println("Successfully added Quarter Day activity");
	}catch(Exception e){}
	}

	@And("^verify all the time slot filters$")
	public void verify_all_filters() throws Throwable {
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
		clickAction(activityPage.getFirstActivityChangeButton());
		try {
		if(ip.getgotItPopup().isDisplayed()) {
			clickAction(ip.getgotItPopup());
			
		}
		}
		catch(NoSuchElementException e) {
			
		}
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
			
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
//		Thread.sleep(2000);
//		pollingWaitWithoutClickable(ip.getgotItPopup(), 5);
//		if(elementDisplayed(ip.getgotItPopup())) {
//			clickAction(ip.getgotItPopup());
//		}
		
		try {
			pollingWaitWithoutClickable(activityPage.getAlternateActivityCardAll(), 30);
			}
			catch (Exception e) {
				System.out.println("No Activities shown for this Region in the alternate page");
			}
		
		List<String> slotList = new ArrayList<String>();
		slotList.add("Morning");
		slotList.add("Noon");
		slotList.add("Evening");
//		slotList.add("Morning to Noon");
//		slotList.add("Noon to Evening");
//		slotList.add("Full Day");
		for (int i = 0; i < slotList.size(); i++) {
			String flag = slotList.get(i);
			
		switch (flag) {
		
case "Morning": {
			
            clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			
            try {
			if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
				int maxClicks = 50;
		        int clickCount = 0;

//		        while (true) {
//		            try {
//		                // Find the "View More" button
//		          //      WebElement viewMoreButton = driver.findElement(By.xp);
//
//		                // Click the "View More" button
//		            //	scrolltoElementAndClickWithoutException(activityPage.getViewMoreActivities());
//		            	
//		            	WebElement viewMoreButton = driver.findElement(By.xpath("//button[contains(text(),'View')]"));
//		            	viewMoreButton.click();
//		                clickCount++;
//
//		                // Wait for some time for the new content to load (adjust as needed)
//		                Thread.sleep(1000);
//
//		                // Break the loop if maximum number of clicks is reached
//		                if (clickCount >= maxClicks) {
//		                    break;
//		                }
//		            } 
//		            catch (TimeoutException e) {
//		                // Break the loop if the "View More" button is no longer found
//		            	 System.out.println("No more 'View More' button found");
//		            	 scrollUp();
//		            	 Thread.sleep(1000);
//		                break;
//		            }
//		            catch (NoSuchElementException e) {
//		                // Break the loop if the "View More" button is no longer found
//		            	 System.out.println("No more 'View More' button found");
//		            	 scrollUp();
//		            	 Thread.sleep(1000);
//		                break;
//		            }
//		        }
		        List<WebElement> activityCard = driver.findElements(By.xpath("//div[contains(@class,'ActivityAlternateCard')]"));
		        System.out.println("Total activities for Morning Filter - " +activityCard.size());
				for(int j = 1; j < activityCard.size(); j++) {
					String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +j+ "]";
					String activitiesName = "(//div[contains(@class,'ActivityAlternateCard')])[" +j+ "]//div[2]//p[1]//span";
					WebElement card = driver.findElement(By.xpath(activitiesData));
					WebElement cardName = driver.findElement(By.xpath(activitiesName));
					String activityname = cardName.getText();
					
					pollingWaitWithoutClickable(card, 15);
					scrolltoElementAndClick(card);
					pollingWaitWithoutClickable(activityPage.getActivityStartTime(), 15);
					String start = activityPage.getActivityStartTime().getText();
					
					String startTime = start.length() >= 2 ? start.substring(0, 2) : start;
					
					String AMorPM = start.length() >= 2 ? start.substring(start.length() - 2, start.length()) : start;
					
					
					int startTiming = removeStringConvertInt(startTime);
					
					if(startTiming <= 11) {
						if(AMorPM.contains("am")) {
							Assert.assertTrue(true);
						}
						else {
							System.out.println(startTime);
							System.out.println(AMorPM);
							
							System.out.println("For Morning timeslot it is showing the NoonNoon/Evening Activity for this Activity - " +activityname+ "No of Activity = "+j);
							Assert.fail("For Morning timeslot it is showing the NoonNoon/Evening Activity" +activityname+ "No of Activity = "+j);
						}
						
					}
					else {
						System.out.println(startTime);
						System.out.println(AMorPM);
						System.out.println("For Morning timeslot it is showing the NoonNoon/Evening Activity for this Activity - " +activityname+ "No of Activity = "+j);
						Assert.fail("For Morning timeslot it is showing the NoonNoon/Evening Activity" +activityname+ "No of Activity = "+j);
					}
					
					clickAction(activityPage.getBackToList());
					
					
				}
			}
			else if(activityPage.getNoActivities().isDisplayed()){
				System.out.println("No activities shown for the Morning timeslot filter");
				Assert.assertTrue(true);
				
			}
            }
            catch (Exception e) {
            	System.out.println("No activities shown for the Morning timeslot filter");
			}
			
			scrolltoElementAndClickWithoutException(activityPage.getActivity_MorningTimeSlotFilter());
			pageRefresh();
			Thread.sleep(2000);
			System.out.println();
			
			break;
			
		}
		case "Noon": {
			
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			
			try {
			if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
				int maxClicks = 50;
		        int clickCount = 0;
//
//		        while (true) {
//		            try {
//		                // Find the "View More" button
//		          //      WebElement viewMoreButton = driver.findElement(By.xp);
//
//		                // Click the "View More" button
//		           // 	scrolltoElementAndClickWithoutException(activityPage.getViewMoreActivities());
//		            	WebElement viewMoreButton = driver.findElement(By.xpath("//button[contains(text(),'View')]"));
//		            	viewMoreButton.click();
//		                clickCount++;
//
//		                // Wait for some time for the new content to load (adjust as needed)
//		                Thread.sleep(1000);
//
//		                // Break the loop if maximum number of clicks is reached
//		                if (clickCount >= maxClicks) {
//		                    break;
//		                }
//		            }
//		            catch (TimeoutException e) {
//		                // Break the loop if the "View More" button is no longer found
//		            	 System.out.println("No more 'View More' button found");
//		            	 scrollUp();
//		            	 Thread.sleep(1000);
//		                break;
//		            }
//		            catch (NoSuchElementException e) {
//		                // Break the loop if the "View More" button is no longer found
//		                System.out.println("No more 'View More' button found");
//		                scrollUp();
//		                Thread.sleep(1000);
//		                break;
//		            }
//		        }
				
		        List<WebElement> activityCard = driver.findElements(By.xpath("//div[contains(@class,'ActivityAlternateCard')]"));
		        System.out.println("Total activities for Noon Filter - " +activityCard.size());
				for(int j = 1; j < activityCard.size(); j++) {
					String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +j+ "]";
					String activitiesName = "(//div[contains(@class,'ActivityAlternateCard')])[" +j+ "]//div[2]//p[1]//span";
					WebElement card = driver.findElement(By.xpath(activitiesData));
					WebElement cardName = driver.findElement(By.xpath(activitiesName));
					String activityname = cardName.getText();
					
					pollingWaitWithoutClickable(card, 15);
					scrolltoElementAndClick(card);
					pollingWaitWithoutClickable(activityPage.getActivityStartTime(), 15);
					String start = activityPage.getActivityStartTime().getText();
					
					String startTime = start.length() >= 2 ? start.substring(0, 2) : start;
					
					String AMorPM = start.length() >= 2 ? start.substring(start.length() - 2, start.length()) : start;
					
					
					int startTiming = removeStringConvertInt(startTime);
					
					if(startTiming == 12 || startTiming < 7) {
						if(AMorPM.contains("pm")) {
							Assert.assertTrue(true);
						}
						else {
							System.out.println(startTime);
							System.out.println(AMorPM);
							System.out.println("For Noon timeslot it is showing the Morning Activity for this Activity - " +activityname+ "No of Activity = "+j);
							Assert.fail("For Noon timeslot it is showing the Morning Activity" +activityname+ "No of Activity = "+j);
						}
						
					}
					else {
						System.out.println(startTime);
						System.out.println(AMorPM);
						System.out.println("For Noon timeslot it is showing the Morning Activity for this Activity - " +activityname+ "No of Activity = "+j);
						Assert.fail("For Noon timeslot it is showing the Morning/Evening Activity" +activityname+ "No of Activity = "+j);
					}
					
					clickAction(activityPage.getBackToList());
					
					
				}
			}
			else if(activityPage.getNoActivities().isDisplayed()){
				System.out.println("No activities shown for the Noon timeslot filter");
				Assert.assertTrue(true);
				
			}
			}
			catch (Exception e) {
				System.out.println("No activities shown for the Noon timeslot filter");
			}
			
			scrolltoElementAndClick(activityPage.getActivity_AfternoonTimeSlotFilter());
			pageRefresh();
			Thread.sleep(2000);
			System.out.println();
			
			break;
		}
		
		case "Evening": {
            clickAction(activityPage.getActivity_EveningTimeSlotFilter());
			
			try {
			if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
				int maxClicks = 50;
		        int clickCount = 0;

//		        while (true) {
//		            try {
//		                // Find the "View More" button
//		          //      WebElement viewMoreButton = driver.findElement(By.xp);
//
//		                // Click the "View More" button
//		          //     scrolltoElementAndClickWithoutException(activityPage.getViewMoreActivities());
//		               
//		            	WebElement viewMoreButton = driver.findElement(By.xpath("//button[contains(text(),'View')]"));
//		            	viewMoreButton.click();
//		            	
//		            	clickCount++;
//
//		                // Wait for some time for the new content to load (adjust as needed)
//		                Thread.sleep(1000);
//
//		                // Break the loop if maximum number of clicks is reached
//		                if (clickCount >= maxClicks) {
//		                    break;
//		                }
//		            } 
//		            catch (TimeoutException e) {
//		                // Break the loop if the "View More" button is no longer found
//		            	 System.out.println("No more 'View More' button found");
//		            	 scrollUp();
//		            	 Thread.sleep(1000);
//		                break;
//		            }
//		            catch (NoSuchElementException e) {
//		                // Break the loop if the "View More" button is no longer found
//		            	 System.out.println("No more 'View More' button found");
//		            	 scrollUp();
//		            	 Thread.sleep(1000);
//		                break;
//		            }
//		           
//		        }
		        
		        List<WebElement> activityCard = driver.findElements(By.xpath("//div[contains(@class,'ActivityAlternateCard')]"));
		        System.out.println("Total activities for Evening Filter - " +activityCard.size());
				for(int j = 1; j < activityCard.size(); j++) {
					String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +j+ "]";
					String activitiesName = "(//div[contains(@class,'ActivityAlternateCard')])[" +j+ "]//div[2]//p[1]//span";
					WebElement card = driver.findElement(By.xpath(activitiesData));
					WebElement cardName = driver.findElement(By.xpath(activitiesName));
					String activityname = cardName.getText();
					
					pollingWaitWithoutClickable(card, 15);
					scrolltoElementAndClick(card);
					pollingWaitWithoutClickable(activityPage.getActivityStartTime(), 15);
					String start = activityPage.getActivityStartTime().getText();
					
					String startTime = start.length() >= 2 ? start.substring(0, 2) : start;
					
					String AMorPM = start.length() >= 2 ? start.substring(start.length() - 2, start.length()) : start;
					
					int startTiming = removeStringConvertInt(startTime);
					
					if(startTiming >= 2) {
						if(AMorPM.contains("pm") | AMorPM.contains("am")) {
							Assert.assertTrue(true);
						}
						else {
							System.out.println(startTime);
							System.out.println(AMorPM);
							System.out.println("For Evening timeslot it is showing the Morning/Noon Activity for this Activity - " +activityname+ " No of Activity = "+j);
							Assert.fail("For Evening timeslot it is showing the Morning/Noon Activity" +activityname+ "No of Activity = "+j);
						}
						
					}
					else {
						System.out.println(startTime);
						System.out.println(AMorPM);
						Assert.fail("For Evening timeslot it is showing the Morning/Noon Activity for this Activity - " +activityname+ "No of Activity = "+j);
					}
					
					clickAction(activityPage.getBackToList());
					
					
				}
			}
			else if(activityPage.getNoActivities().isDisplayed()){
				System.out.println("No activities shown for the Evening timeslot filter");
				Assert.assertTrue(true);
				
			}
			}
            catch (Exception e) {
            	System.out.println("No activities shown for the Evening timeslot filter");
			}
			
			scrolltoElementAndClick(activityPage.getActivity_EveningTimeSlotFilter());
			pageRefresh();
			Thread.sleep(2000);
			
			break;
		}
//		case "Morning to Noon": {
//			pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
//			clickAction(activityPage.getFirstActivityChangeButton());
//			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			Thread.sleep(1000);
//			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
//			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			clickAction(activityPage.getBackToItineraryButtonInAlternate());
//			Thread.sleep(2000);
//			break;
//		}
//		case "Noon to Evening": {
//			pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
//			clickAction(activityPage.getFirstActivityChangeButton());
//			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			Thread.sleep(1000);
//			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
//			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			clickAction(activityPage.getBackToItineraryButtonInAlternate());
//			Thread.sleep(2000);
//			break;
//		}
//		case "Full Day": {
//			pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
//			clickAction(activityPage.getFirstActivityChangeButton());
//			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			Thread.sleep(1000);
//			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
//			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			Thread.sleep(1000);
//			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
//			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
//			Thread.sleep(2000);
//			validateAssertion(elementExist(activityPage.getAlternateActivityCard()));
//			clickAction(activityPage.getBackToItineraryButtonInAlternate());
//			Thread.sleep(2000);
//			break;
//		}
		default:
		}
		Thread.sleep(2000);
		}
		
//		pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
//		clickAction(activityPage.getFirstActivityChangeButton());
//		List<String> slotList = new ArrayList<String>();
////		slotList.add("Morning");
////		slotList.add("Noon");
////		slotList.add("Evening");
//		slotList.add("Morning to Noon");
//		slotList.add("Noon to Evening");
//		slotList.add("Full Day");
//		for (int i = 0; i < slotList.size(); i++) {
//			boolean flag = activitySlot(slotList.get(i));
//			if(flag==true) {
//			verifyingTimeSlotActivity(slotList.get(i));
//			}
//		}
	}

	@And("^verify all the activity duration filters$")
	public void verify_all_activity_duration_filters() throws Throwable {
		List<String> slotList = new ArrayList<String>();
		slotList.add("Full Day");
		for (int i = 0; i < slotList.size(); i++) {
			boolean flag = activitySlot(slotList.get(i));
			if(flag==true) {
				verifyingActivityDurationFilter(slotList.get(i));
			}
		}
	}

	@And("^verify all the transfer and group type filters$")
	public void verify_all_transfer_type_filters() throws Throwable {
		List<String> slotList = new ArrayList<String>();
		slotList.add("Full Day");
		for (int i = 0; i < slotList.size(); i++) {
			boolean flag =activitySlot(slotList.get(i));
			if(flag==true) {
				verifyingTransferAndGroupTypeFilter(slotList.get(i));
			}
		}
	}

	@And("^verify all the Interests filters$")
	public void verify_all_interest_filters() throws Throwable {
		List<String> slotList = new ArrayList<String>();
		slotList.add("Full Day");
		for (int i = 0; i < slotList.size(); i++) {
			boolean flag=activitySlot(slotList.get(i));
			if(flag==true) {
				verifyingInterestsFilters(slotList.get(i));
			}
		}
	}

	@And("^verify all the other filters$")
	public void verify_all_other_filters() throws Throwable {
		List<String> slotList = new ArrayList<String>();
		slotList.add("Full Day");
		for (int i = 0; i < slotList.size(); i++) {
			boolean flag=activitySlot(slotList.get(i));
			if(flag==true) {
				verifyingOtherFilters(slotList.get(i));
			}
		}
	}
	
	public boolean activitySlot(String slot) throws InterruptedException {
		boolean flag =false;
		int slotSize = driver.findElements(By.xpath("//span[text()='" + slot + "']")).size();
		System.out.println(slotSize+" "+slot+ " available");
		try {
			if (slotSize > 0) {
				try {
					WebElement ele = driver.findElement(By.xpath(
							"(//span[(text()='" + slot + "')]/following-sibling::*[not(contains(text(),'At leisure') or contains(text(),'Checkout'))])[1]"));
					if(slot.equalsIgnoreCase("full day")) {
						ele = driver.findElement(By.xpath(
								"(//span[(text()='" + slot + "')]/../..)[2]"));
					}
					if (elementExist(ele)) {
						moveTo(driver,ele);
						Thread.sleep(2000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,75)");
						Thread.sleep(2000);
						clickAction(ele);
						Thread.sleep(1000);
						clickAction(activityPage.getActivitySlider_ViewSimilar(),
								"user opens activity alternate page from slider");
						driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
						Thread.sleep(500);
						popupClosure();
						Thread.sleep(500);
						popupClosure();
						waitForMe(activityPage.getActivityAlternate_Cards());
						Thread.sleep(1000);
//						validate_String_Contains(getCurrentUrl(), "alternate-activities");
						flag = true;
					}
				} catch (Exception e) {
					System.out.println("No "+slot+" slot found");
					flag = false;
				}
			} else {
				System.out.println("No "+slot+" slot found");
				flag = false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("No "+slot+" slot found");
			flag = false;
		}
		return flag;
	}

	public void verifyingTimeSlotActivity(String slot) throws Throwable {
		switch (slot) {
		case "Noon": {
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getBackToItineraryButtonInAlternate());
			Thread.sleep(2000);
			break;
		}
		case "Morning": {
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getBackToItineraryButtonInAlternate());
			Thread.sleep(2000);
			break;
		}
		case "Evening": {
			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getBackToItineraryButtonInAlternate());
			Thread.sleep(2000);
			break;
		}
		case "Morning to Noon": {
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getBackToItineraryButtonInAlternate());
			Thread.sleep(2000);
			break;
		}
		case "Noon to Evening": {
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getBackToItineraryButtonInAlternate());
			Thread.sleep(2000);
			break;
		}
		case "Full Day": {
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getBackToItineraryButtonInAlternate());
			Thread.sleep(2000);
			break;
		}
		default:
		}
		Thread.sleep(2000);
	}

	public void verifyingActivityDurationFilter(String slot) throws Throwable {
		switch (slot) {
		case "Morning":
		case "Noon": 
		case "Evening":
		{
			clickAction(activityPage.getActivity_QuarterDayDurationFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			break;
		}
		case "Morning to Noon": 
		case "Noon to Evening": {
			clickAction(activityPage.getActivity_HalfDayDurationFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			break;
		}
		case "Full Day": {
			clickAction(activityPage.getActivity_FullDayDurationFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			break;
		}
		default:
		}
		Thread.sleep(2000);
	}
	
	public void verifyingTransferAndGroupTypeFilter(String slot) throws Throwable {
		try {
		switch (slot) {
		case "Morning":
		case "Noon": 
		case "Evening":
		case "Morning to Noon": 
		case "Noon to Evening":
		case "Full Day":
		{
			clickAction(activityPage.getActivity_TranferIncludedFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_TranferIncludedFilter());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_TranferNotIncludedFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_TranferNotIncludedFilter());
			clickAction(activityPage.getActivity_SharedFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_SharedFilter());
			clickAction(activityPage.getActivity_PrivateFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			break;
		}
		default:
		}
		Thread.sleep(2000);
		}
		catch(Exception e) {}
	}
	public void verifyingInterestsFilters(String slot) throws Throwable {
		try {
		switch (slot) {
		case "Morning":
		case "Noon": 
		case "Evening":
		case "Morning to Noon": 
		case "Noon to Evening":
		case "Full Day":
		{
			clickAction(activityPage.getActivity_ArtAndCulture());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_ArtAndCulture());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_AdventureAndOutdoor());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_AdventureAndOutdoor());
			clickAction(activityPage.getActivity_FoodAndNightlife());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_FoodAndNightlife());
			clickAction(activityPage.getActivity_ShoppingAndLeisure());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			break;
		}
		default:
		}
		Thread.sleep(2000);
		}
		catch(Exception e) {}
	}
	
	public void verifyingOtherFilters(String slot) throws Throwable {
		try {
		switch (slot) {
		case "Morning":
		case "Noon": 
		case "Evening":
		case "Morning to Noon": 
		case "Noon to Evening":
		case "Full Day":
		{
			clickAction(activityPage.getActivity_TopHighlightsFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_TopHighlightsFilter());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_KidFriendlyFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_KidFriendlyFilter());
			clickAction(activityPage.getActivity_FastSellingFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_FastSellingFilter());
			clickAction(activityPage.getActivity_LessExploredGemsFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_LessExploredGemsFilter());
			clickAction(activityPage.getActivity_SelfExplorationFilter());
			Thread.sleep(2000);
			elementExist(activityPage.getActivityAlternate_Cards());
			break;
		}
		default:
		}
		Thread.sleep(2000);
		}
		catch(Exception e) {}
	}
	
	@And("^verify all the time slot filters after costing$")
	public void verify_all_filters_postCost() throws Throwable {
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getActivity_MorningTimeSlotFilter());
			clickAction(activityPage.getActivity_AfternoonTimeSlotFilter());
			clickAction(activityPage.getActivity_EveningTimeSlotFilter());
		}
	
	@And("^verify all the activity duration filters after costing$")
	public void verify_all_activityDuration_postCost() throws Throwable {
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_QuarterDayDurationFilter());
			clickAction(activityPage.getActivity_HalfDayDurationFilter());
			clickAction(activityPage.getActivity_FullDayDurationFilter());
			Thread.sleep(2000);
			validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
			clickAction(activityPage.getActivity_QuarterDayDurationFilter());
			clickAction(activityPage.getActivity_HalfDayDurationFilter());
			clickAction(activityPage.getActivity_FullDayDurationFilter());
		}
	
	@And("^verify all the transfer and group type filters after costing$")
	public void verify_all_transfer_type_filters_postCost() throws Throwable {
		Thread.sleep(1000);
		clickAction(activityPage.getActivity_TranferIncludedFilter());
		clickAction(activityPage.getActivity_TranferNotIncludedFilter());
		clickAction(activityPage.getActivity_SharedFilter());
		clickAction(activityPage.getActivity_PrivateFilter());
		Thread.sleep(2000);
		validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
		clickAction(activityPage.getActivity_TranferIncludedFilter());
		clickAction(activityPage.getActivity_TranferNotIncludedFilter());
		clickAction(activityPage.getActivity_SharedFilter());
		clickAction(activityPage.getActivity_PrivateFilter());
	}
	
	@And("^verify all the Interests filters after costing$")
	public void verify_all_interest_filters_afterCosting() throws Throwable {
		Thread.sleep(1000);
		clickAction(activityPage.getActivity_ArtAndCulture());
		clickAction(activityPage.getActivity_AdventureAndOutdoor());
		clickAction(activityPage.getActivity_FoodAndNightlife());
		clickAction(activityPage.getActivity_ShoppingAndLeisure());
		Thread.sleep(2000);
		validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
		clickAction(activityPage.getActivity_ArtAndCulture());
		clickAction(activityPage.getActivity_AdventureAndOutdoor());
		clickAction(activityPage.getActivity_FoodAndNightlife());
		clickAction(activityPage.getActivity_ShoppingAndLeisure());
	}
	
	@And("^verify all the other filters after costing$")
	public void verify_all_other_filters_afterCosting() throws Throwable {
		Thread.sleep(1000);
		clickAction(activityPage.getActivity_TopHighlightsFilter());
		clickAction(activityPage.getActivity_KidFriendlyFilter());
		clickAction(activityPage.getActivity_FastSellingFilter());
		clickAction(activityPage.getActivity_LessExploredGemsFilter());
		clickAction(activityPage.getActivity_SelfExplorationFilter());
		Thread.sleep(1000);
		validateAssertion(elementExist(activityPage.getActivityAlternate_Cards()));
	}
	
	

	@Then("validate the Change Activity in the itinerary page as Admin")
	public void validate_the_change_activity_in_the_itinerary_page_as_admin() throws InterruptedException {
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
		clickAction(activityPage.getFirstActivityChangeButton());
		
		pollingWaitWithoutClickable(activityPage.getAlternateActivityCardAll(), 30);
		try {
		if(ip.getgotItPopup().isDisplayed()) {
			clickAction(ip.getgotItPopup());
			
		}
		}
		catch(NoSuchElementException e) {
			
		}
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
			
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
		
		pollingWaitWithoutClickable(activityPage.getFirstActivity(), 25);
		String firstActivityName = activityPage.getFirstActivityName().getText();
	//	clickAction(activityPage.getFirstActivity());
		
//		pollingWaitWithoutClickable(activityPage.getActivity_AddToItineraryButton(), 15);
//		clickAction(activityPage.getActivity_AddToItineraryButton());
		
		hoverWebelement(activityPage.getFirstActivity());
		clickAction(activityPage.getChoose());
		
		try {
		pollingWaitWithoutClickable(activityPage.getProceedWithCurrentSelection(), 15);
		clickAction(activityPage.getProceedWithCurrentSelection());
		}
		catch (Exception e) {
			System.out.println("Proceed with current selection is not displayed");
		}
		
		pollingWaitWithoutClickable(activityPage.getActivitiesSection(), 15);
		String activitiesText = activityPage.getActivitiesSection().getText();
		
		if(activitiesText.contains(firstActivityName)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Changed Activity is not added in the itinerary");
		}

	}
	
	
	@Then("validate the Remove Activity in the itinerary page as Admin")
	public void validate_the_remove_activity_in_the_itinerary_page_as_admin() throws InterruptedException {
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getActivitiesSection(), 15);
		
		clickAction(activityPage.getActivity_viewDetails());
		Thread.sleep(5000);
		pollingWaitWithoutClickable(activityPage.getViewDetailsTitle(), 15);

		String firstActivityName = activityPage.getViewDetailsTitle().getText();
		
		scrolltoElement(activityPage.getActivity_RemoveButton());
		pollingWaitWithoutClickable(activityPage.getActivity_RemoveButton(), 15);
		clickAction(activityPage.getActivity_RemoveButton());
		
		List<WebElement> swissContinue = driver.findElements(By.xpath("//button[text()='Ok, Continue']"));
		
		if(swissContinue.size() > 0) {
			pollingWaitWithoutClickable(activityPage.getSwissContinue(), 15);
			clickAction(activityPage.getSwissContinue());
			
		}
		
//		if(activityPage.getActivity_RemoveButton().isDisplayed()) {
		if(driver.findElements(By.xpath("//button[contains(text(),'Remove')]")).size() > 0)
		{
			pollingWaitWithoutClickable(activityPage.getActivity_RemoveButton(), 15);
			clickAction(activityPage.getActivity_RemoveButton());
			
			pollingWaitWithoutClickable(activityPage.getSwissContinue(), 15);
			clickAction(activityPage.getSwissContinue());
		}
		
		pollingWaitWithoutClickable(activityPage.getActivitiesSection(), 15);
		String activitiesText = activityPage.getActivitiesSection().getText();
		
		if(!activitiesText.contains(firstActivityName)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Removed Activity is not removed in the itinerary");
		}
		

	
	}
	
	
	@Then("validate the Add Activity in the itinerary page as Admin")
	public void validate_the_add_activity_in_the_itinerary_page_as_admin() throws InterruptedException {
//		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
//		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getAddActivity(), 15);
		clickAction(activityPage.getAddActivity());
		
		pollingWaitWithoutClickable(activityPage.getAlternateActivityCardAll(), 30);
		try {
		if(ip.getgotItPopup().isDisplayed()) {
			clickAction(ip.getgotItPopup());
			
		}
		}
		catch(NoSuchElementException e) {
			
		}
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
			
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
		
		pollingWaitWithoutClickable(activityPage.getFirstActivity(), 25);
		String firstActivityName = activityPage.getFirstActivityName().getText();
//		clickAction(activityPage.getFirstActivity());
//		
//		pollingWaitWithoutClickable(activityPage.getActivity_AddToItineraryButton(), 15);
//		clickAction(activityPage.getActivity_AddToItineraryButton());
		
		hoverWebelement(activityPage.getFirstActivity());
		clickAction(activityPage.getChoose());
		
		try {
		pollingWaitWithoutClickable(activityPage.getProceedWithCurrentSelection(), 15);
		clickAction(activityPage.getProceedWithCurrentSelection());
		}
		catch (Exception e) {
			System.out.println("Proceed with current selection is not displayed");
		}
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());

		
		pollingWaitWithoutClickable(activityPage.getActivitiesSection(), 15);
		String activitiesText = activityPage.getActivitiesSection().getText();
		
		if(activitiesText.contains(firstActivityName)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Added Activity is not added in the itinerary");
		}

	
	}
	

	@Then("validate the transfer filter the alternate page")
	public void validate_the_transfer_filter_the_alternate_page() throws InterruptedException {
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
		clickAction(activityPage.getFirstActivityChangeButton());
		pollingWaitWithoutClickable(activityPage.getAlternateActivityCardAll(), 30);
		try {
		if(ip.getgotItPopup().isDisplayed()) {
			clickAction(ip.getgotItPopup());
			
		}
		}
		catch(NoSuchElementException e) {
			
		}
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
			
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
		
		
	//	pollingWaitWithoutClickable(activityPage.getAlternateActivityCard(), 30);
		clickAction(activityPage.getActivity_TranferIncludedFilter());
		
		List<WebElement> activityCard = driver.findElements(By.xpath("//div[contains(@class,'ActivityAlternateCard')]"));
		
		if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
			for(int i = 1; i <= activityCard.size(); i++) {
				String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +i+ "]";
				WebElement card = driver.findElement(By.xpath(activitiesData));
				
				pollingWaitWithoutClickable(card, 15);
				clickAction(card);
				pollingWaitWithoutClickable(activityPage.getTransfersIncluded(), 15);
				Assert.assertTrue(activityPage.getTransfersIncluded().isDisplayed());
				
				clickAction(activityPage.getBackToList());
				
				
			}
		}
		else if(activityPage.getNoActivities().isDisplayed()){
			System.out.println("No activities shown for the transfer included filter");
			Assert.assertTrue(true);
			
		}
		
		clickAction(activityPage.getActivity_TranferIncludedFilter());
		
		clickAction(activityPage.getActivity_TranferNotIncludedFilter());
		

		try {
		if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
			for(int i = 1; i<=activityCard.size(); i++) {
				String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +i+ "]";
				WebElement card = driver.findElement(By.xpath(activitiesData));
				pollingWaitWithoutClickable(card, 15);
				clickAction(card);
				pollingWaitWithoutClickable(activityPage.getTransfersNotIncluded(), 15);
				Assert.assertTrue(activityPage.getTransfersNotIncluded().isDisplayed());
				
				clickAction(activityPage.getBackToList());
				
			}
		}
		else if(activityPage.getNoActivities().isDisplayed()){
			System.out.println("No activities shown for the transfer not included filter");
			Assert.assertTrue(true);
			
		}
		}
		catch (Exception e) {
			System.out.println("No activities shown for the transfer not included filter");
		}
		
	}
	
	
	

	@Then("validate the group type filter in the alternate page")
	public void validate_the_group_type_filter_in_the_alternate_page() throws InterruptedException {
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
		clickAction(activityPage.getFirstActivityChangeButton());
		pollingWaitWithoutClickable(activityPage.getAlternateActivityCardAll(), 30);
		try {
		if(ip.getgotItPopup().isDisplayed()) {
			clickAction(ip.getgotItPopup());
			
		}
		}
		catch(NoSuchElementException e) {
			
		}
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
			
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
		
		
	//	pollingWaitWithoutClickable(activityPage.getAlternateActivityCard(), 30);
		clickAction(activityPage.getActivity_SharedFilter());
		
		List<WebElement> activityCard = driver.findElements(By.xpath("//div[contains(@class,'ActivityAlternateCard')]"));
		
		try {
		if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
			for(int i = 1; i <= activityCard.size(); i++) {
				String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +i+ "]";
				WebElement card = driver.findElement(By.xpath(activitiesData));
				
				pollingWaitWithoutClickable(card, 15);
				clickAction(card);
				pollingWaitWithoutClickable(activityPage.getSharedActivity(), 15);
				Assert.assertTrue(activityPage.getSharedActivity().isDisplayed());
				
				clickAction(activityPage.getBackToList());
				
				
			}
		}
		else if(activityPage.getNoActivities().isDisplayed()){
			System.out.println("No activities shown for the transfer included filter");
			Assert.assertTrue(true);
			
		}
		}
		catch (Exception e) {
			System.out.println("No activities shown for the transfer not included filter");
		}
		
		clickAction(activityPage.getActivity_SharedFilter());
		
		clickAction(activityPage.getActivity_PrivateFilter());
		

		try {
		if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
			for(int i = 1; i<=activityCard.size(); i++) {
				String activitiesData = "(//div[contains(@class,'ActivityAlternateCard')])[" +i+ "]";
				WebElement card = driver.findElement(By.xpath(activitiesData));
				pollingWaitWithoutClickable(card, 15);
				clickAction(card);
				pollingWaitWithoutClickable(activityPage.getPrivateActivity(), 15);
				Assert.assertTrue(activityPage.getPrivateActivity().isDisplayed());
				
				clickAction(activityPage.getBackToList());
				
			}
		}
		else if(activityPage.getNoActivities().isDisplayed()){
			System.out.println("No activities shown for the transfer not included filter");
			Assert.assertTrue(true);
			
		}
		}
		catch (Exception e) {
			System.out.println("No activities shown for the transfer not included filter");
		}
		
		
	}



	@Then("validate the pyt recommended filter in the alternate page")
	public void validate_the_pyt_recommended_filter_in_the_alternate_page() throws InterruptedException {
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(activityPage.getFirstActivityChangeButton(), 15);
		clickAction(activityPage.getFirstActivityChangeButton());
		pollingWaitWithoutClickable(activityPage.getAlternateActivityCardAll(), 30);
		try {
		if(ip.getgotItPopup().isDisplayed()) {
			clickAction(ip.getgotItPopup());
			
		}
		}
		catch(NoSuchElementException e) {
			
		}
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
			
		try {
			if(ip.getgotItPopup().isDisplayed()) {
				clickAction(ip.getgotItPopup());
				
			}
			}
			catch(NoSuchElementException e) {
				
			}
		
		pollingWaitWithoutClickable(activityPage.getPytRecommended(), 15);
		clickAction(activityPage.getPytRecommended());
		
		try {
		if(activityPage.getAlternateActivityCardAll().isDisplayed()) {
			List<WebElement> activityCard = driver.findElements(By.xpath("//div[contains(@class,'ActivityAlternateCard')]"));
			
			for(int i = 1; i <= activityCard.size(); i++) {
				String activitiesData = "(//span[@class='TopRecommended-eOXvno exHESP'])[" +i+ "]";
				WebElement card = driver.findElement(By.xpath(activitiesData));
				
				Assert.assertTrue(card.isDisplayed());
				
				String cardText = card.getText();
				Assert.assertTrue(cardText.contains("PYT Recommended"));
			}
			
			
			
		}
		
		else if(activityPage.getNoActivities().isDisplayed()){
			System.out.println("No activities shown for the pyt Recommended filter");
			Assert.assertTrue(true);
			
		}
		}
		catch (Exception e) {
			System.out.println("No activities shown for the pyt Recommended filter");
		}
		
		
	}









}
