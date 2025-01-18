package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingReviewPage {

	@FindBy(xpath = "//section[@class='booking-pages-content']//a[contains(@href,'make-payment')]")
	private WebElement makePaymentButton;
    
	@FindBy(xpath = "//button[contains(text(),'Book now')]")
	private WebElement bookNowButton;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement continueToBooking;
	
	@FindBy(xpath = "(//a[contains(text(),'Next, make payment')])[1]")
	private WebElement nextMakePayment;
	
	@FindBy(xpath = "//a[@class='btn btn-xl btn-primary']")
	private WebElement changeYourBookings;
	
	@FindBy(xpath = "(//span[contains(@class,'ItineraryNavigation__Tab')])[1]")
	private WebElement itineraryButton;
	
	@FindBy(xpath = "(//span[contains(@class,'ItineraryNavigation__Tab')])[2]")
	private WebElement inclusionButton;
	
	
	@FindBy(xpath = "//a[contains(text(),'Review Costs')]")
	private WebElement reviewCost;
	
	@FindBy(xpath = "//button[contains(text(),'Unlock price')]")
	private WebElement unlockPrice;
	
	public WebElement getUnlockPrice() {
		return unlockPrice;
	}
	
	public WebElement getInclusionButton() {
		return inclusionButton;
		
	}
	
	public WebElement getReviewCost() {
		return reviewCost;
		
	}
	
	public WebElement getItineraryButton() {
		return itineraryButton;
		
	}
	
	
	public WebElement getChangeBooking() {
		return changeYourBookings;
		
	}
	
	public WebElement getmakePaymentButton() {
		return makePaymentButton;
	}
	
	public WebElement getbookNowButton() {
		return bookNowButton;
	}
	
	public WebElement getContinueToBooking() {
		return continueToBooking;
	}
	
	public WebElement getNextMakePayment() {
		return nextMakePayment;
	}


}
