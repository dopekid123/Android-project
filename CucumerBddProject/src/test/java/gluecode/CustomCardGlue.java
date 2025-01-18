package gluecode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class CustomCardGlue extends Kernel {
	protected String currentUrl;

	@Then("validate able to add the custom item in the itinerary")
	public void validate_able_to_add_the_custom_item_in_the_itinerary() throws InterruptedException, AWTException {
		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("It is showing the old itinerary page without view in the URL");
		}

		pollingWaitWithoutClickable(inclusion.getTotalcost(), 45);
		String totalCost = inclusion.getTotalcost().getText();
		String cost = totalCost.replaceAll("[^0-9]", "");
		int actualTotalCost = Integer.parseInt(cost);
		System.out.println(actualTotalCost);
		
//		pageRefresh();
//		
//        scrollDown();
		
		hoverWebelement(activityPage.getInclusions());
		clickAction(activityPage.getInclusions());

		//Adding custom card
		scrolltoElementAndClick(customcard.getAddCustomItem());

		pollingWaitWithoutClickable(customcard.getCardTitle(), 20);
		clickDisbledJavaScriptElement(customcard.getCardTitle());
		typeText(customcard.getCardTitle(), "Test Activity Custom Card");

		pollingWaitWithoutClickable(customcard.getSource(), 10);
		clickAction(customcard.getSource());

		Thread.sleep(1000);

		clickDisbledJavaScriptElement(customcard.getViatorSource());

		clickDisbledJavaScriptElement(customcard.getDescription());
		typeText(customcard.getDescription(), "Custom card Test HOD");

		clickAction(customcard.getEntity());
		Thread.sleep(1000);

		clickDisbledJavaScriptElement(customcard.getEntityOption());
		Thread.sleep(1000);

		typeText(customcard.getOurCost(), "10000");

		typeText(customcard.getPublishedCost(), "12000");

		clickAction(customcard.getReason());
		Thread.sleep(1000);

		clickDisbledJavaScriptElement(customcard.getReasonOption());
		Thread.sleep(1000);

		clickAction(customcard.getInclusionDate());
		Thread.sleep(2000);
		
		customcard.getInclusionDate().sendKeys("11" );
		Thread.sleep(1000);
		
	//	clickDisbledJavaScriptElement(customcard.getInclusionDatePicker());

		typeText(customcard.getFee(), "12000");

		clickAction(customcard.getSaveAndCreate());
		Thread.sleep(5000);

		try {
			Assert.assertTrue(customcard.getEditCustomItem().isDisplayed());
		} catch (Exception e) {
			Assert.fail("Added custom card is not added in the itinerary");
		}
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		pollingWaitWithoutClickable(inclusion.getTotalcost(), 20);
		String changedtotalCost = inclusion.getTotalcost().getText();
		String changedcost = changedtotalCost.replaceAll("[^0-9]", "");
		int changedactualTotalCost = Integer.parseInt(changedcost);

		System.out.println(changedactualTotalCost);
		
		//Validating custom card price in Total cost
		if (actualTotalCost < changedactualTotalCost) {
			Assert.assertTrue(true);

		} else {
			Assert.fail("After added the custom card, cost is not added in the itinerary");
		}

		//Validating custom card in Right side panel
		clickJavaScriptElement(customcard.getViewFullPricing());
		if (customcard.getOtherRight().isDisplayed()) {
			String CustomCardCost = customcard.getOtherCostRight().getText();
			String cardcost = CustomCardCost.replaceAll("[^0-9]", "");
			int actualCardCost = Integer.parseInt(cardcost);
			if (actualCardCost == 12000) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Cost is showing different in the Others Right side panel of the itinerary");
			}

		}

	}

	@Given("validate able to add and edit the custom item in the mle itinerary")
	public void validate_able_to_add_and_edit_the_custom_item_in_the_mle_itinerary() throws InterruptedException {
		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
			System.out.println("Current URL - " +currentUrl);
		} else {
			Assert.fail("It is showing the old itinerary page without view in the URL");
		}
		
//        scrollDown();
//		
//		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
//		clickAction(activityPage.getInclusions());

		//Adding Custom card in MLE
		pollingWaitWithoutClickable(customcard.getAddCustomItem(), 30);
		scrolltoElementAndClick(customcard.getAddCustomItem());
		
//		pollingWaitWithoutClickable(customcard.getNameOfHotel(), 10);
//		typeText(customcard.getNameOfHotel(), "Dhigufaru Island Resort");
		
		pollingWaitWithoutClickable(customcard.getInternetSource(), 10);
		clickAction(customcard.getInternetSource());
		
		pollingWaitWithoutClickable(customcard.getInternetSourceOption(), 10);
		clickAction(customcard.getInternetSourceOption());
		
		pollingWaitWithoutClickable(customcard.getReasonForBlockCard(), 10);
		clickAction(customcard.getReasonForBlockCard());
		
		pollingWaitWithoutClickable(customcard.getReasonForBlockCardOption(), 10);
		clickAction(customcard.getReasonForBlockCardOption());
		
		Actions action = new Actions(driver);
		
	    action.moveToElement(customcard.getCheckInTime()).click().perform(); 
	    Thread.sleep(1000);
	    customcard.getCheckInTime().sendKeys("1100AM");
	    
	    Thread.sleep(1000);
	    
		action.moveToElement(customcard.getCheckOutTime()).click().perform(); 
		Thread.sleep(1000);
		customcard.getCheckOutTime().sendKeys("1100AM");
	    
	    Thread.sleep(1000);
		
		pollingWaitWithoutClickable(customcard.getRoom(), 10);
		clickAction(customcard.getRoom());
		
		typeText(customcard.getRoomCategory(), "3N at Beach Villa & 1N at Water Villa");
		
		typeText(customcard.getNetCost(), "50000");
		
		typeText(customcard.getFee(), "50000");
		
		pollingWaitWithoutClickable(customcard.getSaveAndCreate(), 10);
		clickAction(customcard.getSaveAndCreate());
		
		driver.get(currentUrl);
		
		try {
		pollingWaitWithoutClickable(customcard.getCardmle(), 30);
		customcard.getCardmle().isDisplayed();
		}
		catch (Exception e) {
			Assert.fail("Added custom card is not shown in the itinerary");
		}
		String customcardText = customcard.getCardmle().getText();
		
		if(customcardText.contains("3N at Beach Villa & 1N at Water Villa")) {
			System.out.println("Custom card created successfully for Maldives");
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Unable to add the custom card in Maldives");
		}
		
		
		//Closing card and check it is navigating to the new itinerary page
		pollingWaitWithoutClickable(customcard.getCardmle(), 20);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", customcard.getCustomcardmle());

		pollingWaitWithoutClickable(customcard.getCloseCustomItem(), 20);
		clickAction(customcard.getCloseCustomItem());
		Thread.sleep(2000);
		
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
			System.out.println("After closing the MLE edit custom card popup, it leads to new itinerary page with view in the URL");
		} else {
			Assert.fail("After closing the MLE edit custom card popup, it leads to old itinerary page without view in the URL");
		}
		
		driver.get(currentUrl);
		
		//Editing Custom card in MLE
		pollingWaitWithoutClickable(customcard.getCardmle(), 20);
		executor.executeScript("arguments[0].click();", customcard.getCustomcardmle());
		
		pollingWaitWithoutClickable(customcard.getRoom(), 20);
		clickAction(customcard.getRoom());
		
		pollingWaitWithoutClickable(customcard.getRoomCategory(), 20);
		typeText(customcard.getRoomCategory(), "5N at Beach Villa & 2N at Water Villa");
		
		pollingWaitWithoutClickable(customcard.getSaveAndCreate(), 10);
		clickAction(customcard.getSaveAndCreate());
		
		driver.get(currentUrl);
		
		pollingWaitWithoutClickable(customcard.getCardmle(), 30);
		
		String changedcustomcardText = customcard.getCardmle().getText();
		
		if(changedcustomcardText.contains("5N at Beach Villa & 2N at Water Villa")) {
			Assert.assertTrue(true);
			System.out.println("Custom card edited successfully for Maldives");
		}
		else {
			Assert.fail("Unable to edit the custom card in Maldives");
		}
		
		
		
		

	}

	@Then("Check after closing the edit popup it leads to new itinerary page")
	public void check_after_closing_the_edit_popup_it_leads_to_new_itinerary_page() throws InterruptedException {
		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {	
			Assert.assertTrue(true);
		} else {
			Assert.fail("It is showing the old itinerary page without view in the URL");
		}

		pollingWaitWithoutClickable(inclusion.getTotalcost(), 20);
		String totalCost = inclusion.getTotalcost().getText();
		String cost = totalCost.replaceAll("[^0-9]", "");
		int actualTotalCost = Integer.parseInt(cost);
		System.out.println(actualTotalCost);

		pageRefresh();
		
        scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		pollingWaitWithoutClickable(customcard.getAddCustomItem(), 30);
		scrolltoElementAndClick(customcard.getAddCustomItem());

		pollingWaitWithoutClickable(customcard.getCardTitle(), 10);
		typeText(customcard.getCardTitle(), "Test Activity Custom Card");

		pollingWaitWithoutClickable(customcard.getSource(), 10);
		clickAction(customcard.getSource());

		Thread.sleep(1000);

		clickAction(customcard.getViatorSource());

		clickDisbledJavaScriptElement(customcard.getDescription());
		typeText(customcard.getDescription(), "Custom card Test HOD");

		clickAction(customcard.getEntity());
		Thread.sleep(1000);

		clickAction(customcard.getEntityOption());
		Thread.sleep(1000);

		typeText(customcard.getOurCost(), "10000");

		typeText(customcard.getPublishedCost(), "12000");

		clickAction(customcard.getReason());
		Thread.sleep(1000);

		clickAction(customcard.getReasonOption());
		Thread.sleep(1000);

		clickAction(customcard.getInclusionDate());
		Thread.sleep(2000);
		clickAction(customcard.getInclusionDatePicker());

		typeText(customcard.getFee(), "12000");

		clickAction(customcard.getSaveAndCreate());

		try {
			Assert.assertTrue(customcard.getEditCustomItem().isDisplayed());
		} catch (Exception e) {
			Assert.fail("Added custom card is not added in the itinerary");
		}
		
		pollingWaitWithoutClickable(customcard.getEditCustomItem(), 20);
		clickAction(customcard.getEditCustomItem());
		
		pollingWaitWithoutClickable(customcard.getCloseCustomItem(), 20);
		clickAction(customcard.getCloseCustomItem());
		Thread.sleep(2000);
		
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("After closing the edit custom card popup, it leads to old itinerary page without view in the URL");
		}

	}

	@Then("validate able to edit and remove the custom item in the itinerary")
	public void validate_able_to_edit_and_remove_the_custom_item_in_the_itinerary() throws InterruptedException {
        scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		try {
			Assert.assertTrue(customcard.getEditCustomItem().isDisplayed());
		} catch (Exception e) {
			Assert.fail("Added custom card is not added in the itinerary");
		}
		
		
		pollingWaitWithoutClickable(customcard.getEditCustomItem(), 20);
		clickAction(customcard.getEditCustomItem());
		
		pollingWaitWithoutClickable(customcard.getCloseCustomItem(), 30);
		clickDisbledJavaScriptElement(customcard.getCloseCustomItem());

		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
			System.out.println(
					"After closing the Edit custom card popup, it is showing the new itinerary page with URL as view");
		} else {
			Assert.fail(
					"After closing the Edit custom card popup, it is showing the old itinerary page without view in the URL");
		}
		
		pollingWaitWithoutClickable(customcard.getEditCustomItem(), 20);
		clickAction(customcard.getEditCustomItem());
		
		pollingWaitWithoutClickable(customcard.getPublishedCost(), 20);
		customcard.getPublishedCost().clear();
		typeText(customcard.getPublishedCost(), "15000");
		
		clickAction(customcard.getSaveAndCreate());
		Thread.sleep(5000);
		
		try {
			pollingWaitWithoutClickable(customcard.getEditCustomItem(), 30);
			Assert.assertTrue(customcard.getEditCustomItem().isDisplayed());
		} catch (Exception e) {
			Assert.fail("Added custom card is not added in the itinerary");
		}
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		
		clickAction(customcard.getViewFullPricing());
		if (customcard.getOtherRight().isDisplayed()) {
			String CustomCardCost = customcard.getOtherCostRight().getText();
			String cardcost = CustomCardCost.replaceAll("[^0-9]", "");
			int actualCardCost = Integer.parseInt(cardcost);
			if (actualCardCost == 15000) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Edited Published Cost is showing different in the Others Right side panel of the itinerary");
			}

		}
		
		scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(customcard.getRemoveCustomItem(), 20);
		clickAction(customcard.getRemoveCustomItem());
		Thread.sleep(5000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		
		clickAction(customcard.getViewFullPricing());
		
		List<WebElement> others = driver.findElements(By.xpath("//span[contains(text(),'Other')]"));
		
		if(others.size() <= 0) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("After removing the custom card, cost is still added in the right side panel");
		}
		

	}

	@Then("After closing the custom item popup, validate that it leads to new itinerary page")
	public void after_closing_the_custom_item_popup_validate_that_it_leads_to_new_itinerary_page() throws InterruptedException {
		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("It is showing the old itinerary page without view in the URL");
		}
		pageRefresh();

        scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());   
		pollingWaitWithoutClickable(customcard.getAddCustomItem(), 30);
		scrolltoElementAndClick(customcard.getAddCustomItem());

		pollingWaitWithoutClickable(customcard.getCloseCustomItem(), 30);
		clickDisbledJavaScriptElement(customcard.getCloseCustomItem());

		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
			System.out.println(
					"After closing the custom card popup, it is showing the new itinerary page with URL as view");
		} else {
			Assert.fail(
					"After closing the custom card popup, it is showing the old itinerary page without view in the URL");
		}
	}

	@Then("After closing the custom item popup, validate that it leads to new itinerary page in mle")
	public void after_closing_the_custom_item_popup_validate_that_it_leads_to_new_itinerary_page_in_mle() throws InterruptedException {
		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("It is showing the old itinerary page without view in the URL");
		}

//		pageRefresh();
//        scrollDown();
//		
//		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
//		clickAction(activityPage.getInclusions());
		pollingWaitWithoutClickable(customcard.getAddCustomItem(), 30);
		scrolltoElementAndClick(customcard.getAddCustomItem());

		pollingWaitWithoutClickable(customcard.getCloseCustomItem(), 30);
		clickDisbledJavaScriptElement(customcard.getCloseCustomItem());

		currentUrl = getCurrentUrl();
		if (currentUrl.contains("view")) {
			Assert.assertTrue(true);
			System.out.println(
					"After closing the custom card popup, it is showing the new itinerary page with URL as view");
		} else {
			Assert.fail(
					"After closing the custom card popup, it is showing the old itinerary page without view in the URL");
		}
	}

}
