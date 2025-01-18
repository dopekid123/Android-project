package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizePage {

	
	@FindBy(xpath="//input[@placeholder='Pick your destination']")
	private WebElement landingSearchBox;
	
	@FindBy(css="li:nth-child(1) a:nth-child(1)")
	private WebElement regionSelection;
	
	//Recently Booked Itinerary
	@FindBy(xpath="(//div[@class='booking-card n-tracker-rb-itinerary'])[1]")
	private WebElement rbItinerary;
	
	//Visa on arrival 🚀 destinations
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-visaonarrival-card'])[1]")
	private WebElement visaOnArriItinerary;
	
	//Great family 👪 holidays
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-familyholidays-card'])[1]")
	private WebElement familyHolidaysItinerary;
	
	// Romantic 💑 holidays
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-romanticholidays-card'])[1]")
	private WebElement romanticHolidaysItineary;
	//Adventure 🏄‍ trips
			
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-adventuretrip-card'])[1]")
	private WebElement adventureTrips;

	@FindBy(xpath="//span[contains(text(),'travelling to')]")
	private WebElement departureCityLink;
	
//	@FindBy(xpath="//div[@class='atom-web-c-lesPJm atom-web-c-bqYwTd atom-web-c-kPTeuJ'] | //div[@class='atom-web-c-lesPJm atom-web-c-bqYwTd atom-web-c-dnYJad']")
	@FindBy(xpath="//button[text()='View Details']")
	private WebElement maldivesListingCardPresent;
	
	@FindBy(xpath="//span[@class='atom-web-c-kZvpKt atom-web-c-kZvpKt-iMVRpC-size-3 atom-web-c-kZvpKt-iepkrur-css']")
	private WebElement nightsListingPage;
	
	public WebElement getNightsListingPage() {
		return nightsListingPage;
	}
	
	public WebElement getlandingSearchBox() {
		return landingSearchBox;
	}
	public WebElement getregionSelection() {
		return regionSelection;
	}
	
	public WebElement getDepartureCitySelection() {
		return departureCityLink;
	}
	public WebElement getMaldivesListingCardPresent() {
		return maldivesListingCardPresent;
	}
}
