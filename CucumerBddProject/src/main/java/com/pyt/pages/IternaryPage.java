package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IternaryPage {

	@FindBy(xpath = "//div/*/button[contains(text(),'Calculate trip cost')]")
	WebElement getCalculateCost;

	@FindBy(xpath = "//*[contains(text(),'Day wise plan')]")
	WebElement itineraryPage;

	@FindBy(xpath = "//a[contains(text(),'Got It')]")
	WebElement gotit;

	@FindBy(xpath = "//*/div/*[contains(text(),'Login')]")
	public WebElement getLoginItn;

	@FindBy(xpath = ("(//div[@id='itinerary_page']//*/button[contains(text(),'Get latest cost')])[1]"))
	WebElement getLatestCostbeforescroll;

	@FindBy(xpath = ("(//div[@id='itinerary_page']//*/button[contains(text(),'Get trip cost')])[1]"))
	WebElement getTripCostbeforescroll;

	@FindBy(xpath = "//h1[@id='title_editable']")
	WebElement itineraryH1Element;

	@FindBy(xpath = "//a[contains(@class,'rsc-header-close-button')]/i")
	WebElement chatBotClose;

	@FindBy(xpath = "//*[contains(@class,'PriceCol')]//b | //*[contains(@class,'price-col')]//strong")
	WebElement itineraryCost;

	@FindBy(xpath = "//button[contains(text(),'View your personalised itinerary')]")
	WebElement gcmSignupButtom;

	@FindBy(xpath = "//span[contains(text(),'More')]")
	WebElement morePill;

	@FindBy(xpath = "//button[contains(@class,'get-cost-modal-get-cost')]")
	WebElement getCostModelGetCost;

	@FindBy(xpath = "//div[@class='__floater__body']//a[text()='Got It']")
	WebElement EditRouteFloaterClose;

	public WebElement getEditRouteClose() {
		return EditRouteFloaterClose;
	}

	public WebElement getCostModelGetCost() {
		return getCostModelGetCost;
	}

	public WebElement getMorePill() {
		return morePill;
	}

	public WebElement getGcmSignupButton() {
		return gcmSignupButtom;
	}

	public WebElement getItineraryH1Element() {
		return itineraryH1Element;
	}

	public WebElement getItineraryPage() {
		return itineraryPage;
	}

	public WebElement getCalculateCost() {
		return getCalculateCost;
	}

	public WebElement getgotit() {
		return gotit;
	}

	public WebElement getItnLogin() {
		return getLoginItn;
	}

	public WebElement getLatestCostBeforeScroll() {
		return getLatestCostbeforescroll;
	}

	public WebElement getTripCostBeforeScroll() {
		return getTripCostbeforescroll;
	}

	public WebElement getChatBotClose() {
		return chatBotClose;
	}

	public WebElement getItineraryCost() {
		return itineraryCost;
	}

}
