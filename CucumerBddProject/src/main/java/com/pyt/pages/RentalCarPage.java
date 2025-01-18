package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RentalCarPage {

	// Rental car filters under type category
	@FindBy(xpath = "//a[@value='economy']")
	WebElement economyFilterRentalCar;

	@FindBy(xpath = "//a[@value='compact']")
	WebElement compactFilterRentalCar;

	@FindBy(xpath = "//a[@value='value standard']")
	WebElement valueStandardFilterRentalCar;

	@FindBy(xpath = "//a[@value='standard']")
	WebElement standardFilterRentalCar;

	@FindBy(xpath = "//a[@value='value suv (awd)']")
	WebElement ValueSuvAwdFilterRentalCar;

	@FindBy(xpath = "//a[@value='suv (awd)']")
	WebElement SuvAwdFilterRentalCar;

	@FindBy(xpath = "//a[@value='value minivan']")
	WebElement valueMinivanRentalCar;

	@FindBy(xpath = "//a[@value='intermediate 4×4']")
	WebElement intermediateFilterRentalCar;

	@FindBy(xpath = "//a[@title='Large 4x4']")
	WebElement largeFilterRentalCar;

	@FindBy(xpath = "//a[@title='Premium 4x4']")
	WebElement premiumFilterRentalCar;

	@FindBy(xpath = "//a[@title='11 seater van']")
	WebElement seaterVanFilterRentalCar;

	@FindBy(xpath = "//a[@value='executive']")
	WebElement executiveFilterRentalCar;

	@FindBy(xpath = "//a[@value='suv']")
	WebElement suvFilterRentalCar;

	// Rental car filter under suited for category persons

	@FindBy(xpath = "//a[@value='5']")
	WebElement suitedForFiveFilterRentalCar;

	@FindBy(xpath = "//a[@value='7']")
	WebElement suitedForSevenFilterRentalCar;

	@FindBy(xpath = "//a[@value='11']")
	WebElement suitedForElevenFilterRentalCar;

	// Transmission filter
	@FindBy(xpath = "//a[@value='auto']")
	WebElement automaticFilterRentalCar;

	@FindBy(xpath = "//a[@value='air conditioning']")
	WebElement airconditioningFilterRentalCar;

	// Rental car card in the alternate page
	@FindBy(xpath = "//div[@class='rentalcar-card']")
	WebElement rentalCarCardInAlternatePage;

	// Type filter
	@FindBy(xpath = "//div[contains(text(),'Type')]")
	WebElement typecategoryFilterRentalCar;

	// Suited for filter
	@FindBy(xpath = "//div[contains(text(),'Suited for')]")
	WebElement suitedForCategoryFilterRentalCar;

	// Transmission filter
	@FindBy(xpath = "//div[contains(text(),'Transmission')]")
	WebElement transmissionCategoryFilterRentalCar;

	@FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']")
	WebElement alertCardIfNetworkFailedRentalCar;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okButtonInAlertCard;

	@FindBy(xpath = "(//div[@class='rentalcar-card']//p)[2]")
	WebElement rentalCarFilterValidation;

	@FindBy(xpath = "//button[@class='back-link']")
	WebElement backToItineraryRentalCar;

	// button in transfer section- using it for New zealand itinerary rental car
	// change button
	@FindBy(xpath = "//div[contains(@name,'transfer')]//button")
	WebElement tranferButton;

	// Rental car cards in alternate page
	@FindBy(xpath = "//div[@class='rentalcar-card']")
	WebElement rentalCarCardAlternate;

	// Replace button in Rental car card in rental car alternate page
	@FindBy(xpath = "(//button[contains(text(),'Replace')])[1]")
	WebElement replaceButtonRentalCarAlternate;

	// Rental car insurance options
	@FindBy(xpath = "(//input[@name='insuranceOptions']//following::i)[1]")
	WebElement basicInsuranceRentalCar;

	@FindBy(xpath = "(//input[@name='insuranceOptions']//following::i)[2]")
	WebElement accidentDamageExcessRentalCar;

	@FindBy(xpath = "(//input[@name='insuranceOptions']//following::i)[3]")
	WebElement totalProtectionPackageRentalCar;

	// Apply button in the change insurance modal for rental car insurance
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement applyButtonInChangeInsuranceModal;

	@FindBy(xpath = "//p[contains(@class,'small-heading')]")
	WebElement nooptionfound;

	public WebElement getNoOptionFound() {
		return nooptionfound;
	}
	
	public WebElement getApplyButtonInChangeInsuranceModal() {
		return applyButtonInChangeInsuranceModal;
	}

	public WebElement getBasicInsuranceRentalCar() {
		return basicInsuranceRentalCar;
	}

	public WebElement getAccidentDamageExcessRentalCar() {
		return accidentDamageExcessRentalCar;
	}

	public WebElement getTotalProtectionPackageRentalCar() {
		return totalProtectionPackageRentalCar;
	}

	public WebElement getTranferButton() {
		return tranferButton;
	}

	public WebElement getRentalCarCardAlternate() {
		return rentalCarCardAlternate;
	}

	public WebElement getReplaceButtonRentalCarAlternate() {
		return replaceButtonRentalCarAlternate;
	}

	public WebElement getBackToItineraryRentalCar() {
		return backToItineraryRentalCar;
	}

	public WebElement getRentalCarFilterValidation() {
		return rentalCarFilterValidation;
	}

	public WebElement getAlertCardIfNetworkFailedRentalCar() {
		return alertCardIfNetworkFailedRentalCar;
	}

	public WebElement getOkButtonInAlertCard() {
		return okButtonInAlertCard;
	}

	public WebElement getTypecategoryFilterRentalCar() {
		return typecategoryFilterRentalCar;
	}

	public WebElement getSuitedForCategoryFilterRentalCar() {
		return suitedForCategoryFilterRentalCar;
	}

	public WebElement getTransmissionCategoryFilterRentalCar() {
		return transmissionCategoryFilterRentalCar;
	}

	// div[contains(text(),'Transmission')]
	public WebElement getRentalCarCardInAlternatePage() {
		return rentalCarCardInAlternatePage;
	}

	public WebElement getEconomyFilterRentalCar() {
		return economyFilterRentalCar;
	}

	public WebElement getCompactFilterRentalCar() {
		return compactFilterRentalCar;
	}

	public WebElement getValueStandardFilterRentalCar() {
		return valueStandardFilterRentalCar;
	}

	public WebElement getStandardFilterRentalCar() {
		return standardFilterRentalCar;
	}

	public WebElement getValueSuvAwdFilterRentalCar() {
		return ValueSuvAwdFilterRentalCar;
	}

	public WebElement getSuvAwdFilterRentalCar() {
		return SuvAwdFilterRentalCar;
	}

	public WebElement getValueMinivanRentalCar() {
		return valueMinivanRentalCar;
	}

	public WebElement getSuitedForFiveFilterRentalCar() {
		return suitedForFiveFilterRentalCar;
	}

	public WebElement getSuitedForSevenFilterRentalCar() {
		return suitedForSevenFilterRentalCar;
	}

	public WebElement getAutomaticFilterRentalCar() {
		return automaticFilterRentalCar;
	}

	public WebElement getAirconditioningFilterRentalCar() {
		return airconditioningFilterRentalCar;
	}

	public WebElement getIntermediateFilterRentalCar() {
		return intermediateFilterRentalCar;
	}

	public WebElement getLargeFilterRentalCar() {
		return largeFilterRentalCar;
	}

	public WebElement getPremiumFilterRentalCar() {
		return premiumFilterRentalCar;
	}

	public WebElement getSeaterVanFilterRentalCar() {
		return seaterVanFilterRentalCar;
	}

	public WebElement getSuitedForElevenFilterRentalCar() {
		return suitedForElevenFilterRentalCar;
	}

	public WebElement getExecutiveFilterRentalCar() {
		return executiveFilterRentalCar;
	}

	public WebElement getSuvFilterRentalCar() {
		return suvFilterRentalCar;
	}

}
