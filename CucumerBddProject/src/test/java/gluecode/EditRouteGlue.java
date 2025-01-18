package gluecode;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class EditRouteGlue extends Kernel {


	String editrouteFirstCity;



	/*Remove the first city in edit route modal and validate that the first city
    is removed from your route modal and from the itinerary card */


	@Then("^Click on customize option and validate if the city is removed or not$")
	public void remove_city() throws Throwable {

		String beforeDeleteYourRoute;
		String beforeDeleteItnCard;
		String afterDeleteYourRoute;
		String afterDeleteItnCard;
        if(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
        beforeDeleteYourRoute = getText(ed.getFirstCityInYourRoute());
		beforeDeleteItnCard =  getText(ed.getFirstCityInItnCard());
		clickAction(ed.getEditRouteCustomize());
		clickJavaScriptElement(ed.getDelete());
		waitForMe(ed.getEditRouteCustomize());
		afterDeleteYourRoute= getText(ed.getFirstCityInYourRoute());
		afterDeleteItnCard =  getText(ed.getFirstCityInItnCard());
		validateAssertion(!beforeDeleteYourRoute.equalsIgnoreCase(afterDeleteYourRoute));
		
	}


	/*Add the first city in edit route modal and validate that the first city
    is added into your route modal and the itinerary card */

	@Then("^Click on customize option and validate if the city is added or not$")
	public void  add_city() throws Throwable {
		String  alternateCity;
		String editRouteAlternateCity;
		String yourRouteAlternateCity;
		String itnRowAlternateCity;
		if(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		clickAction(ed.getEditRouteCustomize());
        Thread.sleep(1000);
		clickAction(ed.getAddCityInEditRoute());

		alternateCity =	getAttribute(ed.getAddAlternateCity(), "alt");

		clickAction(ed.getAddAlternateCity());

		Thread.sleep(2000);

		editRouteAlternateCity = getText(ed.getFirstCityInEditRoute());
			clickJavaScriptElement(ed.getUpdateItinerary());
//			pageRefresh();
			pollingWait(ed.getFirstCityInYourRoute(), 40);
			Thread.sleep(5000);
			scrolltoElement(ed.getFirstCityInYourRoute());
			yourRouteAlternateCity=ed.getFirstCityInYourRoute().getText();
			System.out.println("yourRouteAlternateCity--"+yourRouteAlternateCity);
			System.out.println("alternateCity--"+alternateCity);
			validateAssertion(alternateCity.equals(yourRouteAlternateCity)); //Validate that the added city is showing in Your route modal
	}

	/*Replace the city from edit route modal and validate that the replaced city is shown in
	 edit route modal,Your route and the itinerary card */

	@Then("^Click on customize option and validate if the city is replaced by another city or not$")
	public void replace_City() throws Throwable {

		String  alternateCity;
		String itnRowAlternateCity;
		if(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
        clickAction(ed.getEditRouteCustomize());
        Thread.sleep(1000);
		clickAction(ed.getReplaceCity());
		alternateCity =	getAttribute(ed.getAddAlternateCity(), "alt");
		clickAction(ed.getAddAlternateCity());
		clickJavaScriptElement(ed.getUpdateItinerary());
		waitForMe(ed.getEditRouteCustomize());
		Thread.sleep(5000);
		itnRowAlternateCity = getText(ed.getFirstCityInItnCard());
		String editRouteAlternateCity = getText(ed.getFirstCityInEditRoute());
		if (alternateCity.equals(editRouteAlternateCity)) {
			clickAction(ed.getUpdateItinerary());
			Thread.sleep(2000);
			itnRowAlternateCity = getText(ed.getFirstCityInItnCard());
			validateAssertion(alternateCity.equals(itnRowAlternateCity));
		}
	}
			



	/* Add a night in edit route modal and validate that the same night is added into your route
	 modal and the itinerary card */

	@Then("^Click on customize option and validate if the night is added or not$")
	public void add_Night() throws Throwable {

		String beforeAddNightsCount;
		String afterAddNightsCount;

		 if(elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
			}

		clickAction(ed.getEditRouteCustomize());

		beforeAddNightsCount = getText(ed.getCountOfNights());
		System.out.println(beforeAddNightsCount);

		if(verifyEnabled(ed.getAddNight()))
		{
			clickJavaScriptElement(ed.getAddNight());

			afterAddNightsCount = getText(ed.getCountOfNights());
			System.out.println(afterAddNightsCount);

			if(beforeAddNightsCount != afterAddNightsCount) {
				clickJavaScriptElement(ed.getUpdateItinerary());
				waitForMe(ed.getEditRouteCustomize());
				Thread.sleep(2000);
				hoverWebelement(ed.getCountOfNightsInYourRoute());
validateAssertion(afterAddNightsCount.equals(getText(ed.getCountOfNightsInYourRoute())));
						
			}

		}
	}

	/* Remove a night in edit route modal and validate that the same night is removed from your route
	modal and the itinerary card */

	@Then("^Click on customize option and validate if the night is removed or not$")
	public void remove_Night() throws Throwable {

		String beforeRemovalNightsCount;
		String afterRemovalNightsCount;

		 if(elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
			}
		clickAction(ed.getEditRouteCustomize());

		beforeRemovalNightsCount = getText(ed.getCountOfNights());
		System.out.println(beforeRemovalNightsCount);

		if(verifyEnabled(ed.getRemoveNight()))
		{
			clickJavaScriptElement(ed.getRemoveNight());

			afterRemovalNightsCount = getText(ed.getCountOfNights());
			System.out.println(afterRemovalNightsCount);

			if(beforeRemovalNightsCount != afterRemovalNightsCount) {
				clickJavaScriptElement(ed.getUpdateItinerary());
				waitForMe(ed.getEditRouteCustomize());
				Thread.sleep(2000);
				hoverWebelement(ed.getCountOfNightsInYourRoute());

				validateAssertion(afterRemovalNightsCount.equals(getText(ed.getCountOfNightsInYourRoute())));
						
			}
		}
	}
	



	@Then("validate the replace city functionality on the itinerary page")
	public void validate_the_replace_city_functionality_on_the_itinerary_page() throws InterruptedException {
		//scrollUp();
	//	pageRefresh();
		//	hoverWebelement(ed.getAddCity());
	//	pollingWaitWithoutClickable(ed.getAddCity(), 30);
		scrolltoElement(ed.getFirstCityInItnCard());
		String firstCityIti = ed.getFirstCityInItnCard().getText();
		System.out.println(firstCityIti);
		
		scrolltoElement(ed.getEditRouteCustomize());
		clickDisbledJavaScriptElement(ed.getEditRouteCustomize());
		
		pollingWaitWithoutClickable(ed.getReplaceCity(), 10);
		clickAction(ed.getReplaceCity());
		
		String firstCityEdit = ed.getFirstCityInEditRoute().getText();
		System.out.println(firstCityEdit);
		
		clickAction(ed.getFirstCityInEditRoute());
		Thread.sleep(2000);
		
		
		try {
			pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
			clickDisbledJavaScriptElement(ed.getBuildItinerary());
			Thread.sleep(2000);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		Thread.sleep(7000);
		
		try {
			clickDisbledJavaScriptElement(ed.getUpdateTripCost());
			Thread.sleep(15000);
			pageRefresh();
			pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		scrolltoElement(ed.getFirstCityInItnCard());
		String firstCityItiAdded = ed.getFirstCityInItnCard().getText();
		System.out.println(firstCityItiAdded);
		
		if(firstCityItiAdded.equals(firstCityEdit)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Unable to replace the city in the itinerary");
		}
		

	
	}


	@Then("validate the add city functionality on the itinerary page")
	public void validate_the_add_city_functionality_on_the_itinerary_page() throws InterruptedException {
		pageRefresh();
		//	hoverWebelement(ed.getAddCity());
	//	pollingWaitWithoutClickable(ed.getAddCity(), 30);
	//	scrolltoElement(ed.getAddCity());
	//	pollingWaitWithoutClickable(ed.getAddCity(), 20);
		
		Thread.sleep(4000);
		clickDisbledJavaScriptElement(ed.getAddCity());
		Thread.sleep(2000);
		scrolltoElement(ed.getFirstCityInEditRoute());
		String firstCityEdit = ed.getFirstCityInEditRoute().getText();
		System.out.println(firstCityEdit);
		
		clickAction(ed.getFirstCityInEditRoute());
		Thread.sleep(2000);
		
		try {
		pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
		clickDisbledJavaScriptElement(ed.getBuildItinerary());
		Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(10000);
		
		try {
			clickDisbledJavaScriptElement(ed.getUpdateTripCost());
			Thread.sleep(15000);
			pageRefresh();
			pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	//	pollingWaitWithoutClickable(ed.getLastCityInEditRoute(), 15);
		
		scrolltoElement(ed.getLastCityInEditRoute());
		
		String lastCityItiAdded = ed.getLastCityInEditRoute().getText();
		System.out.println(lastCityItiAdded);
		
		if(firstCityEdit.equals(lastCityItiAdded)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Unable to add the city in the itinerary");
		}
		

	
	}




	@Then("validate the delete city functionality on the itinerary page")
	public void validate_the_delete_city_functionality_on_the_itinerary_page() throws InterruptedException {
	//	scrolltoElement(ed.getAddCity());
		pageRefresh();
		Thread.sleep(4000);
		clickDisbledJavaScriptElement(ed.getAddCity());
		
		clickAction(ed.getFirstCityInEditRoute());
		Thread.sleep(2000);
		
		try {
			pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
			clickDisbledJavaScriptElement(ed.getBuildItinerary());
			Thread.sleep(2000);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		try {
			pollingWaitWithoutClickable(ed.getUpdateTripCost(), 20);
			clickDisbledJavaScriptElement(ed.getUpdateTripCost());
			Thread.sleep(15000);
			pageRefresh();
			pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		scrolltoElement(ed.getFirstCityInItnCard());
		
		String firstCity = ed.getFirstCityInItnCard().getText();
		System.out.println(firstCity);
		
		Thread.sleep(2000);
		
	//	scrolltoElement(ed.getEditRouteCustomize());
		clickAction(ed.getEditRouteCustomize());
		
		pollingWaitWithoutClickable(ed.getDelete(), 10);
		clickAction(ed.getDelete());
		
		pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
		clickDisbledJavaScriptElement(ed.getBuildItinerary());
		
		Thread.sleep(10000);
		
		try {
			pollingWaitWithoutClickable(ed.getUpdateTripCost(), 20);
			clickDisbledJavaScriptElement(ed.getUpdateTripCost());
			Thread.sleep(15000);
			pageRefresh();
			pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		pageRefresh();
		
		pollingWaitWithoutClickable(ed.getFirstCityInItnCard(), 30);
		
		String changedFirstCity = ed.getFirstCityInItnCard().getText();
		System.out.println(changedFirstCity);
		
		try {
		Assert.assertNotEquals(changedFirstCity, firstCity);
		}
		catch (Exception e) {
			Assert.fail("Unable to delete the city in the itinerary");
		}
		
	}



	@Then("validate the add and remove nights functionality on the itinerary page")
	public void validate_the_add_and_remove_nights_functionality_on_the_itinerary_page() throws InterruptedException {
	pageRefresh();
	Thread.sleep(4000);
//	clickDisbledJavaScriptElement(ed.getAddCity());
		
		//add nights in the itinerary
		scrolltoElement(ed.getEditRouteCustomize());
		clickDisbledJavaScriptElement(ed.getEditRouteCustomize());
		scrolltoElement(ed.getCountOfNights());
		
		String nightsFirstCity = ed.getCountOfNights().getText();
		System.out.println(nightsFirstCity);
		
		String nightsCount = nightsFirstCity.replaceAll("[^0-9]", "");
		int totalNightsCount = Integer.parseInt(nightsCount);
		
		pageRefresh();
		scrolltoElement(ed.getEditRouteCustomize());
		clickDisbledJavaScriptElement(ed.getEditRouteCustomize());
		
		scrolltoElement(ed.getAddNights());
		doubleClick(driver, ed.getAddNights());
	//	clickDisbledJavaScriptElement(ed.getAddNights());
		
//		pollingWaitWithoutClickable(ed.getAddNights(), 15);
//		clickDisbledJavaScriptElement(ed.getAddNights());
		
		pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
		clickDisbledJavaScriptElement(ed.getBuildItinerary());
		Thread.sleep(2000);
		
		try {
			clickDisbledJavaScriptElement(ed.getUpdateTripCost());
			Thread.sleep(15000);
			pageRefresh();
			pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		scrolltoElement(ed.getEditRouteCustomize());
		clickDisbledJavaScriptElement(ed.getEditRouteCustomize());
		
		pollingWaitWithoutClickable(ed.getCountOfNights(), 15);
		String changedNightsFirstCity = ed.getCountOfNights().getText();
		System.out.println(changedNightsFirstCity);
		
		String changedNightsCount = changedNightsFirstCity.replaceAll("[^0-9]", "");
		int changedTotalNightsCount = Integer.parseInt(changedNightsCount);
		
		if(changedTotalNightsCount == totalNightsCount + 2) {
			Assert.assertTrue(true);
			
//			pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
//			clickDisbledJavaScriptElement(ed.getBuildItinerary());
//			
//			Thread.sleep(7000);
			
//			try {
//				clickDisbledJavaScriptElement(ed.getUpdateTripCost());
//				Thread.sleep(15000);
//				pageRefresh();
//				pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
//				
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
			
			pageRefresh();
			scrolltoElement(ed.getNightsCountIti());
			String itineraryNightsCount = ed.getNightsCountIti().getText();
			
			String itiNightsCount = itineraryNightsCount.replaceAll("[^0-9]", "");
			int itiTotalNightsCount = Integer.parseInt(itiNightsCount);
			
			if(itiTotalNightsCount == totalNightsCount + 2) {
				Assert.assertTrue(true);
			}
			
			
		}
		else {
			Assert.fail("Unable to add extra nights in the itinerary");
		}
		
		
		
		//remove nights in the itinerary
		try {
			scrolltoElement(ed.getEditRouteCustomize());
		clickAction(ed.getEditRouteCustomize());
		}
		catch(Exception e){
			pollingWaitWithoutClickable(ed.getEditRouteCustomize(), 15);
			clickAction(ed.getEditRouteCustomize());
		}
		
		scrolltoElement(ed.getCountOfNights());
		String nightsFirstCitynew = ed.getCountOfNights().getText();
		System.out.println(nightsFirstCitynew);
		
		String nightsCountnew = nightsFirstCitynew.replaceAll("[^0-9]", "");
		int totalNightsCountnew = Integer.parseInt(nightsCountnew);
		
		scrolltoElement(ed.getDeleteNights());
		doubleClick(driver, ed.getDeleteNights());
		
//		pollingWaitWithoutClickable(ed.getDeleteNights(), 15);
//		clickAction(ed.getDeleteNights());
		
		scrolltoElement(ed.getBuildItinerary());
		clickDisbledJavaScriptElement(ed.getBuildItinerary());
		Thread.sleep(2000);
		
		try {
			clickDisbledJavaScriptElement(ed.getUpdateTripCost());
			Thread.sleep(15000);
			pageRefresh();
			scrolltoElement(inclusion.getBookNow());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		scrolltoElement(ed.getEditRouteCustomize());
		clickDisbledJavaScriptElement(ed.getEditRouteCustomize());
		
		scrolltoElement(ed.getCountOfNights());
		String changedNightsFirstCitynew = ed.getCountOfNights().getText();
		System.out.println(changedNightsFirstCitynew);
		
		String changedNightsCountnew = changedNightsFirstCitynew.replaceAll("[^0-9]", "");
		int changedTotalNightsCountnew = Integer.parseInt(changedNightsCountnew);
		
		if(changedTotalNightsCountnew == totalNightsCountnew - 2) {
			Assert.assertTrue(true);
			
//			pollingWaitWithoutClickable(ed.getBuildItinerary(), 10);
//			clickDisbledJavaScriptElement(ed.getBuildItinerary());
//			
//			Thread.sleep(7000);
			
//			try {
//				clickDisbledJavaScriptElement(ed.getUpdateTripCost());
//				Thread.sleep(15000);
//				pageRefresh();
//				pollingWaitWithoutClickable(inclusion.getBookNow(), 50);
//				
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
			
			pageRefresh();
			scrolltoElement(ed.getNightsCountIti());
			String itineraryNightsCountnew = ed.getNightsCountIti().getText();
			
			String itiNightsCountnew = itineraryNightsCountnew.replaceAll("[^0-9]", "");
			int itiTotalNightsCountnew = Integer.parseInt(itiNightsCountnew);
			
			if(itiTotalNightsCountnew == totalNightsCountnew - 2) {
				Assert.assertTrue(true);
			}
			
			
		}
		else {
			Assert.fail("Unable to delete extra nights in the itinerary");
		}

	
	}
	
}


