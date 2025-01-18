package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class TransfersPage {

	@FindBy(xpath = "//section[@class='veho-c-lesPJm veho-c-lesPJm-icHGgAD-css']//span[contains(text(),'Transfer')]")
	WebElement transferHeader;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Add'])[1]")
	WebElement addCarTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Remove'])[1]")
	WebElement removeCarTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Change to shared'])[1]")
	WebElement changeToSharedCarTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Change to private'])[1]")
	WebElement changeToPrivateCarTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Shared transfer'])[1]")
	WebElement sharedProperty;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Private transfer'])[1]")
	WebElement privateProperty;

	@FindBy(xpath = "//div[@name='transfer']")
	WebElement transferSection;

	@FindBy(xpath = "//section[@class='veho-c-gnuJZI']//span[contains(text(),'Transfer')]/following::span[1]")
	WebElement transferPriceRightPanel;

	@FindBy(xpath = "//div[@class='veho-c-lesPJm veho-c-lesPJm-igVhGOw-css']//span[text()='Transfer by train']")
	WebElement transferByTrain;

	@FindBy(xpath = "//div[@class='veho-c-lesPJm veho-c-lesPJm-igVhGOw-css']//span[text()='Transfer by flight']")
	WebElement transferByFlight;

	@FindBy(xpath = "(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iejZlOR-css transfer-mode' and contains(text(),'Transfer by')])[last()]")
	WebElement transferBy;

	@FindBy(xpath = "//div[@class='veho-c-lesPJm veho-c-lesPJm-igVhGOw-css']//span[text()='Transfer by car']")
	WebElement transferByCar;

	@FindBy(xpath = "//div[@class='veho-c-lesPJm veho-c-lesPJm-igVhGOw-css']//span[text()='Transfer by ferry']")
	WebElement transferByFerry;

	@FindBy(xpath = "(//a[text()='Replace Transfer'])[last()]")
	WebElement replaceTransfers;

	@FindBy(xpath = "//span[text()='TRAIN']")
	WebElement replaceTrain;

	@FindBy(xpath = "//span[text()='FLIGHT']")
	WebElement replaceFlight;

	@FindBy(xpath = "//button[text()='Update trip cost']")
	WebElement updateTripCost;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm'])[1]//span[text()='Add Train'])[1]")
	WebElement addTrainTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm'])[1]//span[text()='Remove'])[1]")
	WebElement removeTrainTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm'])[1]//span[text()='Change'])[1]")
	WebElement changeTrainTransfer;

	@FindBy(xpath = "(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-ieYIPfs-css'])[1]")
	WebElement changeTrain;

	@FindBy(xpath = "(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-ieYIPfs-css'])[1]")
	WebElement changeTrainPrice;

	@FindBy(xpath = "//span[text()='Remove Transfers']")
	WebElement removeTransfers;

	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceed;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[1]//span[text()='Change'])[1]")
	WebElement changeRentalCarTransfer;

	@FindBy(xpath = "(//button[text()='Replace'])[1]")
	WebElement replaceRentalCarTransfer;

	@FindBy(xpath = "(//div[@class='veho-c-lesPJm veho-c-lesPJm-ieQURTg-css'])[1]")
	WebElement replaceRentalCarCard;

	@FindBy(xpath = "(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iePlzkE-css'])[1]")
	WebElement replaceRentalCarPrice;

	@FindBy(xpath = "//span[text()='FERRY']")
	WebElement replaceFerry;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[last()]//span[text()='Remove'])[1]")
	WebElement removeFerryTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[last()]//span[text()='Add'])[1]")
	WebElement addFerryTransfer;

	@FindBy(xpath = "((//div[@name='transfer']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css'])[last()]//span[text()='Change'])[1]")
	WebElement changeFerryTransfer;

	@FindBy(xpath = "(//button[text()='Replace'])[1]")
	WebElement changeFerry;

	@FindBy(xpath = "(//span[text()='Price'])[1]/following::span[1]")
	WebElement changeFerryPrice;

	@FindBy(xpath = "//span[text()='CAR']")
	WebElement replaceCar;

	@FindBy(xpath = "//span[text()='View split pricing']")
	WebElement viewFullPricing;

	public WebElement getTransferBy() {
		return transferBy;
	}

	public WebElement getReplaceRentalCarCard() {
		return replaceRentalCarCard;
	}

	public WebElement getViewFullPricing() {
		return viewFullPricing;
	}

	public WebElement getTransferByFerry() {
		return transferByFerry;
	}

	public WebElement getTransferByCar() {
		return transferByCar;
	}

	public WebElement getTransferHeader() {
		return transferHeader;
	}

	public WebElement getAddCarTransfer() {
		return addCarTransfer;
	}

	public WebElement getRemoveCarTransfer() {
		return removeCarTransfer;
	}

	public WebElement getChangeToSharedCarTransfer() {
		return changeToSharedCarTransfer;
	}

	public WebElement getChangeToPrivateCarTransfer() {
		return changeToPrivateCarTransfer;
	}

	public WebElement getSharedProperty() {
		return sharedProperty;
	}

	public WebElement getPrivateProperty() {
		return privateProperty;
	}

	public WebElement getTransferSection() {
		return transferSection;
	}

	public WebElement getTransferPriceRightPanel() {
		return transferPriceRightPanel;
	}

	public WebElement getTransferByTrain() {
		return transferByTrain;
	}

	public WebElement getTransferByFlight() {
		return transferByFlight;
	}

	public WebElement getReplaceTransfers() {
		return replaceTransfers;
	}

	public WebElement getReplaceTrain() {
		return replaceTrain;
	}

	public WebElement getReplaceFlight() {
		return replaceFlight;
	}

	public WebElement getUpdateTripCost() {
		return updateTripCost;
	}

	public WebElement getAddTrainTransfer() {
		return addTrainTransfer;
	}

	public WebElement getRemoveTrainTransfer() {
		return removeTrainTransfer;
	}

	public WebElement getChangeTrainTransfer() {
		return changeTrainTransfer;
	}

	public WebElement getChangeTrain() {
		return changeTrain;
	}

	public WebElement getChangeTrainPrice() {
		return changeTrainPrice;
	}

	public WebElement getProceed() {
		return proceed;
	}

	public WebElement getChangeRentalCarTransfer() {
		return changeRentalCarTransfer;
	}

	public WebElement getReplaceRentalCarTransfer() {
		return replaceRentalCarTransfer;
	}

	public WebElement getReplaceRentalCarPrice() {
		return replaceRentalCarPrice;
	}

	public WebElement getReplaceFerry() {
		return replaceFerry;
	}

	public WebElement getRemoveFerryTransfer() {
		return removeFerryTransfer;
	}

	public WebElement getAddFerryTransfer() {
		return addFerryTransfer;
	}

	public WebElement getChangeFerryTransfer() {
		return changeFerryTransfer;
	}

	public WebElement getChangeFerry() {
		return changeFerry;
	}

	public WebElement getChangeFerryPrice() {
		return changeFerryPrice;
	}

	public WebElement getReplaceCar() {
		return replaceCar;
	}

	@FindBy(xpath = "//span[contains(text(),'Proceed')]")
	WebElement removeTransfersProceed;

	@FindBys(@FindBy(xpath = "//div[@name='transfer']//h4"))
	List<WebElement> transferNames;

	@FindBy(xpath = "(//div[@name='transfer']//h4)//following::div[4]//p")
	WebElement removeTransfersText;

	public WebElement getRemoveTransfersText() {
		return removeTransfersText;
	}

	public List<WebElement> getTransferNames() {
		return transferNames;
	}

	public WebElement getRemoveTransfers() {
		return removeTransfers;
	}

	public WebElement getRemoveTransfersProceed() {
		return removeTransfersProceed;
	}

}
