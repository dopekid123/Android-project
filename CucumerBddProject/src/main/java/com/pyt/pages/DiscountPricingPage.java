package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountPricingPage {

	// Hotel xpath
	
	@FindBy(xpath = "(//div[@name='stay']//b)[1]")
	private WebElement hotelPrice;

	@FindBy(xpath = "(//i[contains(@class,'pyt-edit')])[2]")
	private WebElement discountIcon;

	@FindBy(xpath = "(//div[@name='stay']//section[contains(@class,'inclusion-box')])[1]")
	private WebElement hotelPanel;

	@FindBy(xpath = "//div[contains(text(),'Update pricing')]")
	private WebElement rateMatchPanel;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement adminPriceField;

	@FindBy(xpath = "//span[contains(text(),'Update')]")
	private WebElement rateMatchUpdate;

	@FindBy(xpath = "//span[contains(@class,'discount-ribbon')]")
	private WebElement adminPriceLabel;

	@FindBy(xpath = "//span[contains(@class,'GetCostingDetails')]")
	private WebElement ChangePassengerInfo;

	// Flight xpath

	@FindBy(xpath = "(//div[@name='flight']//i[contains(@class,'pyt-edit')])[1]")
	private WebElement flightdiscountIcon;

	@FindBy(xpath = "(//div[@name='all-flight-panels']//b)[1]")
	private WebElement flightPrice;

	@FindBy(xpath = "//span[contains(text(),'Flight')]")
	private WebElement flightCount;

	@FindBy(xpath = "//a[text()='Activity ']//span")
	private WebElement activityCount;

	@FindBy(xpath = "//input[@placeholder='Type your other source']")
	private WebElement airportHotelSourceText;

	@FindBy(xpath = "//a[text()='Transfer ']//span")
	private WebElement transferCount;

	@FindBy(xpath = "//button[contains(text(),'Change to shared')]/../../div/following::i[contains(@class,'pyt-edit')]")
	private List<WebElement> transferEditOptions;
	
	@FindBy(xpath = "//button[contains(text(),'Change to')]")
	private WebElement transferType;
	
	@FindBy(xpath = "//span[contains(text(),'Stay')]")
	private WebElement hotelCount;
	
	@FindBy(xpath = "//div[contains(@class,'RightSidePanel__Price')]//b | (//aside[contains(@class,'update-card')]//b)[2]")
	private WebElement totalItineraryCost;
	
	@FindBy(xpath = "//span[contains(@class,'SplitPrice__ShowMoreBtn')]")
	private WebElement viewfullsplitprice;
	
	//New XPath --> Adding Buffer
	
	@FindBy(xpath = "//div[contains(text(),'Add Buffer')]")
	private WebElement addBuffer;
	

	@FindBy(xpath = "//input[@placeholder='Add amount here']")
	private WebElement newDealSizeField;
	
	@FindBy(xpath = "//input[@placeholder='Select reason']")
	private WebElement reasonField;
	
	@FindBy(xpath = "//input[@placeholder='Select manager']")
	private WebElement managerField;
	
	@FindBy(xpath = "(//div[text()='Add Buffer'])[2]")
	private WebElement addBufferCTA;
	
	@FindBy(xpath = "//div[text()='Confirm changes']")
	private WebElement confirmChangesCTA;
	
	@FindBy(xpath = "//aside[@class='price-card']//p//i[contains(@class,'cursor-pointer')]")
	private WebElement overallEditPriceIcon;
	
	public WebElement getOverallEditPriceIcon() {
		return overallEditPriceIcon;

	}
	
	public WebElement getConfirmChangesCTA() {
		return confirmChangesCTA;

	}
	
	public WebElement getAddBufferCTA() {
		return addBufferCTA;

	}
	
	public WebElement getManagerField() {
		return managerField;

	}
	public WebElement getReasonField() {
		return reasonField;

	}
    public WebElement getNewDealSizeField() {
		return newDealSizeField;

	}
	public WebElement getAddBuffer() {
		return addBuffer;

	}
	
	////New XPath --> Adding Discount
	
	
	
	@FindBy(xpath = "//div[contains(text(),'Add Discount')]")
	private WebElement addDiscount;
	
	@FindBy(xpath = "(//div[text()='Add Discount'])[2]")
	private WebElement addDiscountCTA;
	
	public WebElement getAddDiscountCTA() {
		return addDiscountCTA;

	}
	
	
	
	public WebElement getAddDiscount() {
		return addDiscount;

	}
	
	
	
	
	
	
	
	
	
	
	public WebElement getViewFullSplitPricing() {
		return viewfullsplitprice;

	}
	
	public WebElement getTotalItineraryCost() {
		return totalItineraryCost;

	}
	
	public WebElement getHotelCount() {
		return hotelCount;

	}
	
	public WebElement getTransferType() {
		return transferType;

	}


	public List<WebElement> getTransferEditOptions() {
		return transferEditOptions;

	}

	public WebElement getTransferCount() {
		return transferCount;

	}

	public WebElement getairportHotelSourceText() {
		return airportHotelSourceText;

	}

	public WebElement getActivityCount() {
		return activityCount;
	}

	public WebElement getFlightCount() {
		return flightCount;
	}

	public WebElement getFlightDiscountIcon() {
		return flightdiscountIcon;
	}

	public WebElement getChangePassengerInfo() {
		return ChangePassengerInfo;
	}

	public WebElement getAdminPricelabel() {
		return adminPriceLabel;
	}

	public WebElement getRateMatchUpdate() {
		return rateMatchUpdate;
	}

	public WebElement getAdminPriceField() {
		return adminPriceField;
	}

	public WebElement getDiscountIcon() {
		return discountIcon;
	}

	public WebElement getHotelPrice() {
		return hotelPrice;
	}

	public WebElement getHotelPanel() {
		return hotelPanel;
	}

	public WebElement getRateMatchPanel() {
		return rateMatchPanel;

	}

}
