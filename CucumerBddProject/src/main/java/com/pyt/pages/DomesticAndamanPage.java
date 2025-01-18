package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DomesticAndamanPage {
	
	@FindBy(xpath="(//div[contains(@class,'n-tracker-domestic_andaman-recommended-for-you')])[1]")
	private WebElement amRecommendedForYou;

	@FindBy(xpath="(//div[contains(@class,'n-tracker-domestic_andaman-romantic-holidays')])[1]")
	private WebElement amForRomanticHoliday;
	
	@FindBy(xpath="(//div[contains(@class,'n-tracker-domestic_andaman-family-vacations')])[1]")
	private WebElement amFamilyVacation;
	
	@FindBy(xpath="(//div[contains(@class,'n-tracker-domestic_andaman-nature-adventure')])[1]")
	private WebElement amNatureAdventure;
	
	@FindBy(xpath="//section[contains(@class,'CardComponentWrapper')]")
	private WebElement amItineraryCardInListingPage;
	
	@FindBy(xpath="//section[contains(@class,'ListingPage__NoResultsSection')]")
	private WebElement noSearchResults;
	
	public WebElement getNoSearchResults() {
		return noSearchResults;
	}

	public WebElement getAmItineraryCardInListingPage() {
		return amItineraryCardInListingPage;
	}

	public WebElement getAmRecommendedForYou() {
		return amRecommendedForYou;
	}

	public WebElement getAmForRomanticHoliday() {
		return amForRomanticHoliday;
	}

	public WebElement getAmFamilyVacation() {
		return amFamilyVacation;
	}

	public WebElement getAmNatureAdventure() {
		return amNatureAdventure;
	}

}
