package gluecode;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class RemoveActivities extends Kernel{
	
	ActivitiesGlue actGlue = new ActivitiesGlue();
	CbrValidationGlue cbrGlue = new CbrValidationGlue();
	public static int inclusionActivityCount=0;
	int activitySize  = 0;
	
	@Then("^Check if there is any default activities available on itinerary if not add the activity$")
	public void check_if_there_is_any_default_activities_available_on_itinerary_if_not_add_the_activity() throws Throwable {
		
	activitySize =	activityPage.getActivityNavigator().size();
	if(activitySize <= 0) {
		
		cbrGlue.user_navigate_to_itinerary_page();
		actGlue.user_add_the_activity();
		String activitycnt = inclusion.getActivitNavigatorInclusions().getText();
		inclusionActivityCount=Integer.parseInt(activitycnt.replaceAll("[^0-9]", ""));
		if(inclusionActivityCount >= 0) {
			validateAssertion(true);
		}
		Assert.assertTrue(elementDisplayed(activityPage.getRemoveActivity()));
		
		}
	
	}
	
	@Then("^Click on remove activity option$")
	public void click_on_remove_activity_option() throws Throwable {

	clickAction(activityPage.getRemoveActivity());
	Thread.sleep(1000);
	clickAction(activityPage.getRemoveActivitiesProceed());
	

	}

	@Then("^validate the activities got removed$")
	public void validate_the_activities_got_removed() throws Throwable {

		activitySize =	activityPage.getActivityNavigator().size();
		if(activitySize <= 0) {
			Assert.assertTrue(true);
		}
		Assert.assertTrue((elementDisplayed(activityPage.getRemoveActivity())) == false );
	
	}



	
	
	
	
}
