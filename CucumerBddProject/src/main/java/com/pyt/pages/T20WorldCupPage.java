package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class T20WorldCupPage {

	@FindBy(xpath = "//*[text()='Plan for Men’s World Cup']")
	WebElement mensWorldCup;

	@FindBy(xpath = "//*[text()='Plan for Women’s World Cup']")
	WebElement womensWorldCup;

	@FindBy(xpath = "//*[text()='Our customer stories']")
	WebElement customerStory;

	@FindBy(xpath = "//*[text()='Discover']")
	WebElement discover;

	@FindBy(xpath = "//*[text()='Experience']")
	WebElement experience;

	@FindBy(xpath = "//*[text()='Indulge']")
	WebElement indulge;

	@FindBy(xpath = "(//*[text()='View Itinerary'])[1]")
	WebElement viewItinerary;

	@FindBy(xpath = "(//*[text()='Reserve'])[1]")
	WebElement reserve;

	@FindBy(xpath = "//*[text()=\"What’s included?\"]")
	WebElement inclusions;

	@FindBy(xpath = "//*[text()='Request call back']")
	WebElement cbr;

	public WebElement getMensWorldCup() {
		return mensWorldCup;
	}

	public WebElement getWomensWorldCup() {
		return womensWorldCup;
	}

	public WebElement getCustomerStory() {
		return customerStory;
	}

	public WebElement getDiscover() {
		return discover;
	}

	public WebElement getExperience() {
		return experience;
	}

	public WebElement getIndulge() {
		return indulge;
	}

	public WebElement getViewItinerary() {
		return viewItinerary;
	}

	public WebElement getReserve() {
		return reserve;
	}

	public WebElement getInclusions() {
		return inclusions;
	}

	public WebElement getcbr() {
		return cbr;
	}

}
