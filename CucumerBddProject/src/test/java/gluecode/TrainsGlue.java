package gluecode;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class TrainsGlue extends Kernel {

	@Then("^validate that the Train section is displayed$")

	public void view_alternate_Trains() throws Throwable {
		try {
			Thread.sleep(5000);
			elementExist(trainsPage.getTrainChangeButton());
			scrolltoElement(trainsPage.getTrainChangeButton());
			} catch (NoSuchElementException e) {
			System.out.println("Alternative train option not available");
		}

	}



	@Then("^validate that the alternate train is selected$")

	public void select_alternate_Trains() throws Throwable {
		clickAction(trainsPage.getTrainChangeButton());
		try {
			waitForMe(trainsPage.getTrainReplaceButton());
			if (elementExist(trainsPage.getTrainReplaceButton())){
				clickAction(trainsPage.getTrainReplaceButton());
			}
		}catch(NoSuchElementException e) {
			System.out.println("No trains available to replace");
			//			e.printStackTrace();
		}
	}
	
	
	
	public void Validate_Filter_Options() throws Throwable {
		try {
		String noTrainCardText= getText(trainsPage.getNoTrainsOptions());
		System.out.println("no Train card Text: "+noTrainCardText);
		if( noTrainCardText.contains("No other trains") )
		{
			System.out.println("Inside no train");
			waitForMe(trainsPage.getBackToInclusions());
			clickAction(trainsPage.getBackToInclusions());
		}
		else if(elementExist(trainsPage.getTrainReplaceButton())){
			clickAction(trainsPage.getTrainReplaceButton());
		}
		String currentUrl = getCurrentUrl();
		validateAssertion(currentUrl.contains("alternate-trains"));
//		Assert.assertFalse(currentUrl.contains("alternate-trains"),"User in alternate-trains page");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}



	@Then("^validate that number of stop train filter options$")
	public void validate_that_one_stop_Train_option_is_chosen() throws Throwable {
		waitForMe(trainsPage.getTrainChangeButton());
		clickAction(trainsPage.getTrainChangeButton());
		List<String> stopFilter = new ArrayList<String>();
		stopFilter.add("one stop");
		stopFilter.add("two stop");
		stopFilter.add("no stop");
		for(int i=0;i<stopFilter.size();i++) {
		switch(stopFilter.get(i)) {
			case "one stop": {
				clickAction(trainsPage.getOneStopTrains(), "User chooses 'one stop' filter for flights");
				String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
				boolean noTrain = noTrainCardText.contains("No other trains");
				if (!noTrain) {
					validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
				}else {
					System.out.println("No trains available");
				}
				clickAction(trainsPage.getOneStopTrains(), "User chooses 'one stop' filter for flights");
				Thread.sleep(1000);
				break;
			}
		case "two stop":{
			clickAction(trainsPage.getTwoStopTrains(), "User chooses 'two stop' filter for flights");
			String noTrainCardText= getText(trainsPage.getNoTrainsOptions());
			boolean noTrain = noTrainCardText.contains("No other trains");
			if (!noTrain) {
				validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
			}else {
				System.out.println("No trains available");
			}
			clickAction(trainsPage.getTwoStopTrains(), "User chooses 'two stop' filter for flights");
			Thread.sleep(1000);
			break;
		}
		case "no stop":{
			clickAction(trainsPage.getNoStopTrains(), "User chooses 'no stop' filter for flights");
			String noTrainCardText= getText(trainsPage.getNoTrainsOptions());
			boolean noTrain = noTrainCardText.contains("No other trains");
			if (!noTrain) {
				validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
			}else {
				System.out.println("No trains available");
			}
			clickAction(trainsPage.getNoStopTrains(), "User chooses 'no stop' filter for flights");
			Thread.sleep(1000);
			break;
		}
		}
		}
	}

	@Then("^validate that onward journey train filter options$")
	public void validate_that_early_morning_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {
		List<String> departureFilter = new ArrayList<String>();
		departureFilter.add("early morning");
		departureFilter.add("morning");
		departureFilter.add("mid day");
		departureFilter.add("evenig");
		departureFilter.add("night");
		for(int i=0;i<departureFilter.size();i++) {
			switch(departureFilter.get(i)) {
				case "early morning": {
					clickAction(trainsPage.getOnwardEarlyMorningTrains(), "User chooses 'Early morning' filter for onward train");
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getOnwardEarlyMorningTrains(), "User chooses 'Early morning' filter for onward train");
					Thread.sleep(1000);
					break;
				}
				case "morning": {
					clickAction(trainsPage.getOnwardMorningTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getOnwardMorningTrains());
					Thread.sleep(1000);
					break;
				}
				case "mid day": {
					clickAction(trainsPage.getOnwardMiddayTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getOnwardMiddayTrains());					
					Thread.sleep(1000);
					break;
				}
				case "evening": {
					clickAction(trainsPage.getOnwardEveningTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getOnwardEveningTrains());
					Thread.sleep(1000);
					break;
				}
				case "night": {
					clickAction(trainsPage.getOnwardNightTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getOnwardNightTrains());
					Thread.sleep(1000);
					break;
				}
			}
		}
		
	}

	@Then("^validate that return journey train filter options$")
	public void validate_that_early_morning_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		List<String> departureFilter = new ArrayList<String>();
		departureFilter.add("early morning");
		departureFilter.add("morning");
		departureFilter.add("mid day");
		departureFilter.add("evenig");
		departureFilter.add("night");
		for(int i=0;i<departureFilter.size();i++) {
			switch(departureFilter.get(i)) {
				case "early morning": {
					clickAction(trainsPage.getReturnEarlyMorningTrains(), "User chooses 'Early morning' filter for onward train");
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getReturnEarlyMorningTrains(), "User chooses 'Early morning' filter for onward train");
					Thread.sleep(1000);
					break;
				}
				case "morning": {
					clickAction(trainsPage.getReturnMorningTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getReturnMorningTrains());
					Thread.sleep(1000);
					break;
				}
				case "mid day": {
					clickAction(trainsPage.getReturnMiddayTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getReturnMiddayTrains());					
					Thread.sleep(1000);
					break;
				}
				case "evening": {
					clickAction(trainsPage.getReturnEveningTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getReturnEveningTrains());
					Thread.sleep(1000);
					break;
				}
				case "night": {
					clickAction(trainsPage.getReturnNightTrains());
					String noTrainCardText = getText(trainsPage.getNoTrainsOptions());
					boolean noTrain = noTrainCardText.contains("No other trains");
					if (!noTrain) {
						validateAssertion(elementDisplayed(trainsPage.getTrainReplaceButton()));
					}else {
						System.out.println("No trains available");
					}
					clickAction(trainsPage.getReturnNightTrains());
					Thread.sleep(1000);
					break;
				}
			}
		}
		

	}

	@Then("^validate that morning trains option for onward journey is chosen succeffully$")
	public void validate_that_morning_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardMorningTrains(), "User chooses 'Morning' filter for onward train");
		Validate_Filter_Options();

	}

	@Then("^validate that morning trains option for return journey is chosen succeffully$")
	public void validate_that_morning_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnMorningTrains(), "User chooses 'Morning' filter for return trains");
		Validate_Filter_Options();

	}

	@Then("^validate that mid-day trains option for onward journey is chosen succeffully$")
	public void validate_that_mid_day_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardMiddayTrains(), "User chooses 'Mid-day' filter for onward trains");
		Validate_Filter_Options();

	}

	@Then("^validate that mid-day trains option for return journey is chosen succeffully$")
	public void validate_that_mid_day_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnMiddayTrains(), "User chooses 'Mid-day' filter for return trains");
		Validate_Filter_Options();

	}

	@Then("^validate that night trains option for onward journey is chosen succeffully$")
	public void validate_that_night_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardNightTrains(), "User chooses 'Night' filter for onward trains");
		Validate_Filter_Options();

	}

	@Then("^validate that night trains option for return journey is chosen succeffully$")
	public void validate_that_night_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnNightTrains(), "User chooses 'Night' filter for return trains");
		Validate_Filter_Options();
	}
	
	@Then("^validate that evening trains option for onward journey is chosen succeffully$")
	public void validate_that_evening_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardEveningTrains(), "User chooses 'Night' filter for return trains");
		Validate_Filter_Options();
	}

	@Then("^validate that evening trains option for return journey is chosen succeffully$")
	public void validate_that_evening_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnEveningTrains(), "User chooses 'Night' filter for return trains");
		Validate_Filter_Options();
	}
	
	
	

}
