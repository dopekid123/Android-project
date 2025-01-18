package gluecode;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class SanduneActivitiesGlue extends Kernel {

	public String activityChange_HD;

	@Then("^User navigates from itinerary to inclusion page$")
	public void user_navigates_from_itinerary_to_inclusion_page() throws Throwable {
		try {
			while(elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
			}
		}
		catch(Exception e) {}
		validateAssertion(elementDisplayed(dubaiPage.getInclusionHeader()));
		clickAction(dubaiPage.getInclusionHeader());
		

	}

	public void validate_the_activity_removed_successfully() throws Throwable {
		boolean isReomved = verifyExactText(activityPage.getActivitySlider_AfterRemove(), "Activity Removed!");
		Assert.assertTrue(isReomved);
		clickAction(activityPage.getActivity_SliderClose(), "User clicks on out side the silder to close");
	}

	@Then("^User replaces the activities in the itinerary page$")
	public void user_replaces_the_activities_in_the_itinerary_page() throws Throwable {
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));
			if ((!activity_HD.equals("At leisure")) && (!activity_HD.contains("flight back"))
					&& (!activity_HD.contains("Arrive in Dubai airport"))) {
				clickAction(dubaiPage.getActivityCardList().get(i));
				clickAction(activityPage.getActivitySlider_ViewSimilar(), "Activity alternate page from slider");
				while (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
				activityChange_HD = getText(dubaiPage.getActivityCardList().get(i));
				validateAssertion(!activity_HD.equalsIgnoreCase(activityChange_HD));
				break;
			}
		}
	}

	@Then("^User adds the activities in the itinerary page$")
	public void user_adds_the_activities_in_the_itinerary_page() throws Throwable {

		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));

			if (activity_HD.equals("At leisure")) {

				clickAction(dubaiPage.getActivityCardList().get(i));
				while (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
				activityChange_HD = getText(dubaiPage.getActivityCardList().get(i));
				validateAssertion(!activity_HD.equalsIgnoreCase(activityChange_HD));
				break;

			}
		}
	}

	@Then("^User removes the activities in the itinerary page$")
	public void user_removes_the_activities_in_the_itinerary_page() throws Throwable {

		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));
			if ((!activity_HD.equals("At leisure")) && (!activity_HD.contains("flight back"))
					&& (!activity_HD.contains("Arrive in Dubai airport"))) {
				clickAction(dubaiPage.getActivityCardList().get(i));
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();
				break;
			}

		}
	}
	

	@Then("^user selects the activity slot for filter validation$")
	public void user_selects_the_activity_slot_for_filter_validation() throws Throwable {
		clickAction(ip.getgotItPopup());
		Thread.sleep(500);
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		moveTo(driver, activityPage.getChangeActivityButtonInInclusions());
		Thread.sleep(1000);
		clickAction(activityPage.getChangeActivityButtonInInclusions());
		Thread.sleep(2000);
		clickAction(ip.getgotItPopup());
		Thread.sleep(500);
		clickAction(ip.getgotItPopup());
		waitForMe(activityPage.getActivityAlternate_Cards());
		Thread.sleep(1000);
	}	
}
