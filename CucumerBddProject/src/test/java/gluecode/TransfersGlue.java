package gluecode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class TransfersGlue extends Kernel {

	@Then("validate able to add the car transfer on the itinerary page")
	public void validate_able_to_add_the_car_transfer_on_the_itinerary_page() throws InterruptedException {

		// Removing All Transfers in the Itinerary
	//	pageRefresh();
		
    //    scrollDown();
	//	scrolltoElement(ed.getAddCity());
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());

		scrolltoElementAndClick(transfersPage.getTransferHeader());

		// Clicking on Add Transfer in the First Car Transfer card
		pollingWaitWithoutClickable(transfersPage.getAddCarTransfer(), 15);
		clickAction(transfersPage.getAddCarTransfer());
		Thread.sleep(2000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		// Checking Added car price in the right side - view Full pricing
		pollingWaitWithoutClickable(transfersPage.getViewFullPricing(), 15);
		clickAction(transfersPage.getViewFullPricing());
		Thread.sleep(2000);
		scrolltoElement(transfersPage.getTransferPriceRightPanel());

		String transfersPrice = transfersPage.getTransferPriceRightPanel().getText();
		String price = transfersPrice.replaceAll("[^0-9]", "");
		int priceOfTansfers = Integer.parseInt(price);

		System.out.println("Added Transfer price = " + priceOfTansfers);

		try {
			if (priceOfTansfers > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Add Car tansfer is not working in the itinerary");
			}
		} catch (Exception e) {
			Assert.fail("Add Car tansfer is not working in the itinerary");
		}

	}

	@Then("validate able to remove the car transfer on the itinerary page")
	public void validate_able_to_remove_the_car_transfer_on_the_itinerary_page() throws InterruptedException {

		// Removing All Transfers in the Itinerary
	//	pageRefresh();
    //    scrollDown();
		scrolltoElement(activityPage.getInclusions());
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElement(transfersPage.getProceed());
		actionsClick(transfersPage.getProceed());
		Thread.sleep(1000);

	//	scrolltoElement(transfersPage.getTransferHeader());
		actionsClick(transfersPage.getTransferHeader());
		Thread.sleep(1000);

		// Clicking on Add Transfer in the First Car Transfer card
		pollingWaitWithoutClickable(transfersPage.getAddCarTransfer(), 15);
		scrolltoElement(transfersPage.getAddCarTransfer());
		clickDisbledJavaScriptElement(transfersPage.getAddCarTransfer());
		Thread.sleep(2000);

		// Clicking on Remove Transfer in the First Car Transfer card
		pollingWaitWithoutClickable(transfersPage.getRemoveCarTransfer(), 15);
		scrolltoElement(transfersPage.getRemoveCarTransfer());
		clickDisbledJavaScriptElement(transfersPage.getRemoveCarTransfer());

		if (transfersPage.getAddCarTransfer().isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Remove Car tansfer is not working in the itinerary");
		}
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		scrolltoElement(blockCard.getDayByDay());
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		// Checking Removed car price in the right side - view Full pricing
		if(elementExist(transfersPage.getViewFullPricing()))
		{
			scrolltoElement(transfersPage.getViewFullPricing());
			clickDisbledJavaScriptElement(transfersPage.getViewFullPricing());
		}

		List<WebElement> TransfersRightSidePrice = driver.findElements(
				By.xpath("//div[contains(@id,'radix')]//span[contains(text(),'Transfers')]"));

		if (TransfersRightSidePrice.size() < 1) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Removed Car tansfer price is showing in the Right side panel");
		}

	}

	@Then("validate able to change the car transfer to private and shared on the itinerary page")
	public void validate_able_to_change_the_car_transfer_to_private_and_shared_on_the_itinerary_page()
			throws InterruptedException {

		// Removing All Transfers in the Itinerary
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());

		scrolltoElementAndClick(transfersPage.getTransferHeader());

		pollingWaitWithoutClickable(transfersPage.getAddCarTransfer(), 15);
		clickAction(transfersPage.getAddCarTransfer());
		Thread.sleep(3000);

		// Clicking on Change to shared in the First Car Transfer card
		scrolltoElement(transfersPage.getChangeToSharedCarTransfer());
		clickAction(transfersPage.getChangeToSharedCarTransfer());

		try {
			if (transfersPage.getSharedProperty().isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Change to shared is not working.");
			}
		} catch (Exception e) {
			Assert.fail("Change to Shared is not working.");
		}

		// Clicking on Change to private in the First Car Transfer card
		pollingWaitWithoutClickable(transfersPage.getChangeToPrivateCarTransfer(), 15);
		clickAction(transfersPage.getChangeToPrivateCarTransfer());

		try {
			if (transfersPage.getPrivateProperty().isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Change to Private is not working.");
			}
		} catch (Exception e) {
			Assert.fail("Change to Shared is not working.");
		}

	}

	@Then("validate able to change the car transfer to private and shared on the itinerary page as User")
	public void validate_able_to_change_the_car_transfer_to_private_and_shared_on_the_itinerary_page_as_user()
			throws InterruptedException {
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElementAndClick(transfersPage.getTransferHeader());

		// Clicking on Change to shared in the First Car Transfer card
		pollingWaitWithoutClickable(transfersPage.getChangeToSharedCarTransfer(), 15);
		clickAction(transfersPage.getChangeToSharedCarTransfer());

		try {
			if (transfersPage.getSharedProperty().isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Change to shared is not working.");
			}
		} catch (Exception e) {
			Assert.fail("Change to Shared is not working.");
		}

		// Clicking on Change to private in the First Car Transfer card
		pollingWaitWithoutClickable(transfersPage.getChangeToPrivateCarTransfer(), 15);
		clickAction(transfersPage.getChangeToPrivateCarTransfer());

		try {
			if (transfersPage.getPrivateProperty().isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Change to Private is not working.");
			}
		} catch (Exception e) {
			Assert.fail("Change to Shared is not working.");
		}
	}

	@Then("validate able to add the train transfer")
	public void validate_able_to_add_the_train_transfer() throws InterruptedException {

		// Removing All Transfers in the Itinerary
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElementAndClick(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		//clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		//scrolltoElement(transfersPage.getProceed());
		
		scrolltoElement(transfersPage.getProceed());
		clickDisbledJavaScriptElement(transfersPage.getProceed());
		Thread.sleep(1000);

		scrolltoElement(transfersPage.getTransferHeader());
		actionsClick(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		// Clicking on Add Train Transfer in the First Train Transfer card
		pollingWaitWithoutClickable(transfersPage.getAddTrainTransfer(), 20);
		scrolltoElement(transfersPage.getAddTrainTransfer());
		clickDisbledJavaScriptElement(transfersPage.getAddTrainTransfer());
		Thread.sleep(2000);

		// Taking first train cost in the alternate page
		pollingWaitWithoutClickable(transfersPage.getChangeTrainPrice(), 20);
		String trainPrice = transfersPage.getChangeTrainPrice().getText();
		String price = trainPrice.replaceAll("[^0-9]", "");
		int priceOfTrain = Integer.parseInt(price);
		System.out.println("Train price in Card = " + priceOfTrain);

		
		scrolltoElement(transfersPage.getChangeTrain());
		clickAction(transfersPage.getChangeTrain());
		
		Thread.sleep(3000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		
		Thread.sleep(2000);

		if(elementExist(transfersPage.getViewFullPricing()))
		{
			scrolltoElement(transfersPage.getViewFullPricing());
			clickDisbledJavaScriptElement(transfersPage.getViewFullPricing());
		}
		
		Thread.sleep(2000);

		// Validating Train cost in the itinerary
		if (elementExist(transfersPage.getTransferPriceRightPanel())) {
			String rightPrice = transfersPage.getTransferPriceRightPanel().getText();
			String Right = rightPrice.replaceAll("[^0-9]", "");
			int priceOfTrainTransfer = Integer.parseInt(Right);
			System.out.println("Train price in Right side panel = " + priceOfTrainTransfer);
			try {
				if (priceOfTrainTransfer == priceOfTrain) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("Added train transfer price is showing different in the Right side panel");
				}
			} catch (Exception e) {
				Assert.fail("Added train transfer price is showing different in the Right side panel");
			}
		} else {
			Assert.fail("Added train transfer is not added in the Right side panel");
		}

	}

	@Then("validate able to remove the train transfer")
	public void validate_able_to_remove_the_train_transfer() throws InterruptedException {
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());

		scrolltoElementAndClick(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getAddTrainTransfer(), 15);
		clickAction(transfersPage.getAddTrainTransfer());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeTrainPrice(), 15);
		String trainPrice = transfersPage.getChangeTrainPrice().getText();
		String price = trainPrice.replaceAll("[^0-9]", "");
		int priceOfTrain = Integer.parseInt(price);
		System.out.println("Train price in Card = " + priceOfTrain);

		pollingWaitWithoutClickable(transfersPage.getChangeTrain(), 15);
		clickAction(transfersPage.getChangeTrain());

		pollingWaitWithoutClickable(transfersPage.getRemoveTrainTransfer(), 15);
		clickAction(transfersPage.getRemoveTrainTransfer());

		pollingWaitWithoutClickable(transfersPage.getTransferHeader(), 15);
		try {
			pollingWaitWithoutClickable(transfersPage.getAddTrainTransfer(), 15);
			transfersPage.getAddTrainTransfer().isDisplayed();

		} catch (Exception e) {
			Assert.fail("Remove Train tansfer is not working");
		}

		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		
		Thread.sleep(2000);
		scrolltoElement(transfersPage.getViewFullPricing());
		clickAction(transfersPage.getViewFullPricing());
		
		Thread.sleep(2000);

		List<WebElement> TransfersRightSidePrice = driver.findElements(
				By.xpath("//section[@class='veho-c-ctwQem']//span[contains(text(),'Transfers')]/following::span[1]"));

		if (TransfersRightSidePrice.size() < 1) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Removed Train tansfer price is showing in the Right side panel");
		}

	}

	@Then("validate able to change the train transfer")
	public void validate_able_to_change_the_train_transfer() throws InterruptedException {
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		
		scrolltoElement(transfersPage.getProceed());
		clickDisbledJavaScriptElement(transfersPage.getProceed());
		Thread.sleep(1000);

		scrolltoElementAndClick(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getAddTrainTransfer(), 15);
		scrolltoElement(transfersPage.getAddTrainTransfer());
		clickDisbledJavaScriptElement(transfersPage.getAddTrainTransfer());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeTrain(), 15);
		scrolltoElement(transfersPage.getChangeTrain());
		clickDisbledJavaScriptElement(transfersPage.getChangeTrain());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeTrainTransfer(), 15);
		scrolltoElement(transfersPage.getChangeTrainTransfer());
		clickDisbledJavaScriptElement(transfersPage.getChangeTrainTransfer());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeTrainPrice(), 20);
		String trainPrice = transfersPage.getChangeTrainPrice().getText();
		String price = trainPrice.replaceAll("[^0-9]", "");
		int priceOfTrain = Integer.parseInt(price);
		System.out.println("Train price in Card = " + priceOfTrain);

		pollingWaitWithoutClickable(transfersPage.getChangeTrain(), 15);
		scrolltoElement(transfersPage.getChangeTrain());
		clickAction(transfersPage.getChangeTrain());
		
		Thread.sleep(3000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		scrolltoElement(blockCard.getDayByDay());
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getViewFullPricing(), 15);
		scrolltoElement(transfersPage.getViewFullPricing());
		clickAction(transfersPage.getViewFullPricing());
		
		Thread.sleep(2000);

		if (transfersPage.getTransferPriceRightPanel().isDisplayed()) {
			String rightPrice = transfersPage.getTransferPriceRightPanel().getText();
			String Right = rightPrice.replaceAll("[^0-9]", "");
			int priceOfTrainTransfer = Integer.parseInt(Right);
			System.out.println("Train price in Right side panel = " + priceOfTrainTransfer);
			try {
				if (priceOfTrainTransfer == priceOfTrain) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("Changed train transfer price is showing different in the Right side panel");
				}
			} catch (Exception e) {
				Assert.fail("Changed train transfer price is showing different in the Right side panel");
			}
		} else {
			Assert.fail("Changed train transfer is not added in the Right side panel");
		}

	}

	@Then("validate able to replace the transfer in the itinerary")
	public void validate_able_to_replace_the_transfer_in_the_itinerary() throws InterruptedException {
		hoverWebelement(transfersPage.getTransferBy());
		scrolltoElementAndClick(transfersPage.getReplaceTransfers());
		Thread.sleep(2000);

		if (transfersPage.getReplaceTrain().isSelected()) {
			pollingWaitWithoutClickable(transfersPage.getReplaceFlight(), 15);
			clickAction(transfersPage.getReplaceFlight());

			pollingWaitWithoutClickable(transfersPage.getUpdateTripCost(), 15);
			clickAction(transfersPage.getUpdateTripCost());

			try {
				pollingWaitWithoutClickable(transfersPage.getTransferByFlight(), 30);
				Assert.assertTrue(transfersPage.getTransferByFlight().isDisplayed());
			} catch (Exception e) {
				Assert.fail("Replace transfer is not working in the itinerary page");
			}
		} else if (transfersPage.getReplaceFlight().isSelected()) {
			pollingWaitWithoutClickable(transfersPage.getReplaceTrain(), 15);
			clickAction(transfersPage.getReplaceTrain());

			pollingWaitWithoutClickable(transfersPage.getUpdateTripCost(), 15);
			clickAction(transfersPage.getUpdateTripCost());

			try {
				pollingWaitWithoutClickable(transfersPage.getTransferByTrain(), 30);
				Assert.assertTrue(transfersPage.getTransferByTrain().isDisplayed());
			} catch (Exception e) {
				Assert.fail("Replace transfer is not working in the itinerary page");
			}
		}

	}

	@Then("validate able to change the Rental car transfer")
	public void then_validate_able_to_change_the_rental_car_transfer() throws InterruptedException {
	//	pageRefresh();
     //   scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());

		scrolltoElementAndClick(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeRentalCarTransfer(), 15);
		clickAction(transfersPage.getChangeRentalCarTransfer());
		Thread.sleep(2000);
		pollingWaitWithoutClickable(transfersPage.getReplaceRentalCarPrice(), 15);
		String rentalCarPrice = transfersPage.getReplaceRentalCarPrice().getText();
		String price = rentalCarPrice.replaceAll("[^0-9]", "");
		int priceOfRentalCar = Integer.parseInt(price);
		System.out.println("Rental car price in Card = " + priceOfRentalCar);

		pollingWaitWithoutClickable(transfersPage.getReplaceRentalCarCard(), 15);
		hoverWebelement(transfersPage.getReplaceRentalCarCard());
		Thread.sleep(1000);
		pollingWaitWithoutClickable(transfersPage.getReplaceRentalCarTransfer(), 15);
		clickDisbledJavaScriptElement(transfersPage.getReplaceRentalCarTransfer());
		Thread.sleep(2000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getViewFullPricing(), 15);
		clickAction(transfersPage.getViewFullPricing());
		Thread.sleep(3000);

		if (transfersPage.getTransferPriceRightPanel().isDisplayed()) {
			String rightPrice = transfersPage.getTransferPriceRightPanel().getText();
			String Right = rightPrice.replaceAll("[^0-9]", "");
			int priceOfTRentalRight = Integer.parseInt(Right);
			System.out.println("Rental car price in Right side panel = " + priceOfTRentalRight);
			try {
				if (priceOfRentalCar == priceOfTRentalRight) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("Changed rental car transfer price is showing different in the Right side panel");
				}
			} catch (Exception e) {
				Assert.fail("Changed rental car transfer price is showing different in the Right side panel");
			}
		} else {
			Assert.fail("Changed rental car transfer is not added in the Right side panel");
		}

	}

	@Then("validate able to add the Ferry transfer")
	public void validate_able_to_add_the_ferry_transfer() throws InterruptedException {
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());
		Thread.sleep(3000);
		scrolltoElement(blockCard.getDayByDay());
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		Thread.sleep(2000);

		hoverWebelement(transfersPage.getTransferBy());
		scrolltoElementAndClick(transfersPage.getReplaceTransfers());
		pollingWaitWithoutClickable(transfersPage.getReplaceFerry(), 15);
		clickAction(transfersPage.getReplaceFerry());

		pollingWaitWithoutClickable(transfersPage.getUpdateTripCost(), 15);
		clickAction(transfersPage.getUpdateTripCost());
		Thread.sleep(3000);
		
//		scrollDown();
			
		scrolltoElement(activityPage.getInclusions());
	    clickAction(activityPage.getInclusions());

		pollingWaitWithoutClickable(transfersPage.getTransferHeader(), 15);
		clickAction(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getRemoveFerryTransfer(), 15);
		clickAction(transfersPage.getRemoveFerryTransfer());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getAddFerryTransfer(), 15);
		clickAction(transfersPage.getAddFerryTransfer());
		Thread.sleep(2000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		pollingWaitWithoutClickable(transfersPage.getViewFullPricing(), 15);
		clickAction(transfersPage.getViewFullPricing());
		
		Thread.sleep(2000);

		try {
			if (transfersPage.getTransferPriceRightPanel().isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Add Ferry transfer is not working in the right side panel");
			}
		} catch (Exception e) {
			Assert.fail("Add Ferry transfer is not working in the right side panel");
		}

	}

	@Then("validate able to remove the Ferry transfer")
	public void validate_able_to_remove_the_ferry_transfer() throws InterruptedException {
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());
		Thread.sleep(3000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		hoverWebelement(transfersPage.getTransferBy());
		scrolltoElementAndClick(transfersPage.getReplaceTransfers());
		pollingWaitWithoutClickable(transfersPage.getReplaceFerry(), 15);
		clickAction(transfersPage.getReplaceFerry());

		pollingWaitWithoutClickable(transfersPage.getUpdateTripCost(), 15);
		clickAction(transfersPage.getUpdateTripCost());
		Thread.sleep(3000);
		
	//	scrollDown();
		
	    pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
	    clickAction(activityPage.getInclusions());

	    scrolltoElementAndClick(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getRemoveFerryTransfer(), 15);
		clickAction(transfersPage.getRemoveFerryTransfer());
		Thread.sleep(2000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		scrolltoElement(transfersPage.getViewFullPricing());
		clickAction(transfersPage.getViewFullPricing());
		
		Thread.sleep(2000);

		List<WebElement> TransfersRightSidePrice = driver.findElements(
				By.xpath("//section[@class='veho-c-ctwQem']//span[contains(text(),'Transfers')]/following::span[1]"));

		if (TransfersRightSidePrice.size() < 1) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Removed Ferry tansfer price is showing in the Right side panel");
		}

	}

	@Then("validate able to change the Ferry transfer")
	public void validate_able_to_change_the_ferry_transfer() throws InterruptedException {
	//	pageRefresh();
    //    scrollDown();
		
        clickJavaScriptElement(activityPage.getInclusions());
		scrolltoElement(transfersPage.getRemoveTransfers());
		clickDisbledJavaScriptElement(transfersPage.getRemoveTransfers());
		Thread.sleep(2000);
		scrolltoElementAndClick(transfersPage.getProceed());

		Thread.sleep(3000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		hoverWebelement(transfersPage.getTransferBy());
		scrolltoElementAndClick(transfersPage.getReplaceTransfers());
		scrolltoElement(transfersPage.getReplaceFerry());
		clickAction(transfersPage.getReplaceFerry());

		pollingWaitWithoutClickable(transfersPage.getUpdateTripCost(), 15);
		clickAction(transfersPage.getUpdateTripCost());
		Thread.sleep(3000);
		
	//	scrollDown();
		
		scrolltoElement(activityPage.getInclusions());
	    clickAction(activityPage.getInclusions());

	    scrolltoElementAndClick(transfersPage.getTransferHeader());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeFerryTransfer(), 15);
		clickAction(transfersPage.getChangeFerryTransfer());
		Thread.sleep(2000);

		pollingWaitWithoutClickable(transfersPage.getChangeFerryPrice(), 15);
		String ferryPrice = transfersPage.getChangeFerryPrice().getText();
		String price = ferryPrice.replaceAll("[^0-9]", "");
		int priceOfFerry = Integer.parseInt(price);
		System.out.println("Train price in Card = " + priceOfFerry);

		pollingWaitWithoutClickable(transfersPage.getChangeFerry(), 15);
		scrolltoElement(transfersPage.getChangeFerry());
		clickDisbledJavaScriptElement(transfersPage.getChangeFerry());
		Thread.sleep(2000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		pollingWaitWithoutClickable(transfersPage.getViewFullPricing(), 15);
		clickAction(transfersPage.getViewFullPricing());
		
		Thread.sleep(2000);

		if (transfersPage.getTransferPriceRightPanel().isDisplayed()) {
			String rightPrice = transfersPage.getTransferPriceRightPanel().getText();
			String Right = rightPrice.replaceAll("[^0-9]", "");
			int priceOfFerryTransfer = Integer.parseInt(Right);
			System.out.println("Ferry price in Right side panel = " + priceOfFerryTransfer);
			try {
				if (priceOfFerryTransfer == priceOfFerry) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("Changed Ferry transfer price is showing different in the Right side panel");
				}
			} catch (Exception e) {
				Assert.fail("Changed Ferry transfer price is showing different in the Right side panel");
			}
		} else {
			Assert.fail("Changed Ferry transfer is not added in the Right side panel");
		}

	}

}
