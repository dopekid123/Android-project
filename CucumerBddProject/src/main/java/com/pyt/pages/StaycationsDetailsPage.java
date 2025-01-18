package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class StaycationsDetailsPage {
	
	
	@FindBy(xpath = "(//div[@label='Number of nights'])[1]")
	WebElement nightsDropdown;
	
	@FindBy(xpath = "//h2[contains(text(),'What’s included?')]")
	WebElement whatsIncluded;
	
	@FindBy(xpath = "//div[contains(@class,'UpgradeButton')]")
	WebElement roomUpgradeDropdown;
	
	
	@FindBy(xpath = "(//div[@id='current-room']//p)[1]")
	WebElement currentRoomTitle;
	
	@FindBy(xpath = "(//section[@name='room-upgrade']//p)[1]")
	WebElement alternateRoomTitle;
	
	@FindBy(xpath = "(//section[@name='room-upgrade']//button)[1]")
	WebElement selectRoomButton;
	
	
	@FindBy(xpath = "(//section[@name='room-upgrade']//p[@class='sc-dxgOiQ fpuJOT'])[1]")
	WebElement alternateRoomPrice;
	
	@FindBy(xpath="(//div[contains(@class,'DealTitleCard__CardHeaderTitle')])//h1 | //section[@name='deals-about']/..//h1[contains(@class,'PageTitleSEO__MainTitle')]")
	WebElement dealTitle;
	
	@FindBy(xpath="(//input[@placeholder='Date of booking'])")
	WebElement dateinput;
	
	@FindBy(xpath="(//div[contains(@class,'datepicker__input')])")
	 WebElement datepicker;
	
	@FindBy(xpath="(//li[contains(@class,'next-active last-active')])")
	 WebElement nextactivedate;
	
	@FindBy(xpath="(//button[contains(text(),'Continue')])")
	WebElement continuebutton;
	
	@FindBy(xpath="(//button[contains(text(),'Book this deal')])")
	WebElement bookthisdeal;
	
	@FindBy(xpath="//input[@placeholder='Name' and @disabled ]")
	WebElement nameDisabledPaxDetails;
	
	@FindBy(xpath="//input[@placeholder='Email' and @disabled ]")
	WebElement emailDisabledPaxDetails;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number' and @disabled ]")
	WebElement mobileNumDisbledPaxDetails;
	
	@FindBy(xpath="//input[@placeholder='Birthday']")
	WebElement birthDayPaxDetails;
	
	@FindBy(xpath="//button[contains(text(),'Book this deal')] | //button[contains(text(),'Pay only 20% to book')]")
	WebElement bookThisDealButtonPaxDetails;
	
	@FindBy(xpath="//section[@name='deals-inclusions']//div[@label='Number of nights']//input")
	WebElement defaultRoomNightInput;
	
	@FindBy(xpath="(//span[contains(@class,'DealsStyles__DiscountPercentage')])[1]")
	WebElement sidePanelNight;
	
	@FindBy(xpath="//strong[@itemprop='highPrice']")
	WebElement sidePanelPrice;
	
	public WebElement getsidePanelPrice() {
		return sidePanelPrice;
	}
	
	public WebElement getsidePanelNight() {
		return sidePanelNight;
	}
	
	public WebElement getDefaultRoomNightInput() {
		return defaultRoomNightInput;
	}
	
	public WebElement getBookThisDealButtonPaxDetails() {
		return bookThisDealButtonPaxDetails;
	}

	public WebElement getBirthDayPaxDetails() {
		return birthDayPaxDetails;
	}

	public WebElement getMobileNumDisbledPaxDetails() {
		return mobileNumDisbledPaxDetails;
	}

	public WebElement getEmailDisabledPaxDetails() {
		return emailDisabledPaxDetails;
	}

	public WebElement getNameDisabledPaxDetails() {
		return nameDisabledPaxDetails;
	}


	@FindBy(xpath="(//div[contains(@class,'DealsStyles__PriceRow')]//strong)")
	WebElement priceonbookingscreen;
	
	@FindBy(xpath="//b[contains(@class,'DealsStyles__StrikedPrice')]")
	WebElement strikedPriceOnBookingScreen;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponText')]")
	WebElement CouponText;
	

	@FindBy(xpath="//span[contains(text(),'Details')]/following-sibling::p")
	WebElement dateandmonthonbookingscreen;
	
	@FindBy(xpath="//input[@name='name']")
	 WebElement adultcountfield;
	
	@FindBy(xpath="//span[text()='Chat with us for more options']")
	 WebElement chatwithus;
	
	@FindBy(xpath="//a[@data-testid='whatsapp_www_header_logo_link']")
	 WebElement whatsapplogo;
	
	@FindBy(xpath="//strong[@itemprop='highPrice']")
    WebElement totalpriceondetailspage;
	
	@FindBy(xpath="//i[@itemprop='lowPrice']")
	WebElement strikedPriceDetailsPage;
	
	@FindBy(xpath="//p[contains(text(),'Travellers')]/../i[contains(@class,'pyt-close')]")
	WebElement travellersmodelclosebtn;
	
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__ReviewWrapper')]/div/p/i[contains(@class,'pyt-heart')]")
	WebElement applyLoyaltyCredits;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'Apply Loyalty Credits')]")
	WebElement enableApplyLoyaltyCredits;
	
	@FindBy(xpath="//span[contains(@class,'DealsStyles__LoyaltyCreditPointsPill')]")
	WebElement loyaltycreditcoins;
	
	public WebElement getLoyaltycreditcoins() {
		return loyaltycreditcoins;
	}

	public WebElement getEnableApplyLoyaltyCredits() {
		return enableApplyLoyaltyCredits;
	}


	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//i[contains(@class,'pyt-close-circle')]")
	WebElement offerClose;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'HSBCDOM')]")
	WebElement enableapplyHsbc;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'HSBCINT')]")
	WebElement enableapplyHsbcpdf;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'HDFCFLY')]")
	WebElement enableApplyHdfcpdg;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'ICICIAPAY')]")
	WebElement enableApplyIcicpdg;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'Apply discount / referral coupon')]")
	WebElement enablecouponcode;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'ICICIAPAY')]")
	WebElement enableICICDeals;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(text(),'HDFCSTAY')]")
	WebElement enableHdfcDeals;
	
	public WebElement getEnableApplyHdfcpdg() {
		return enableApplyHdfcpdg;
	}

	public WebElement getEnableApplyIcicpdg() {
		return enableApplyIcicpdg;
	}

	public WebElement getEnablecouponcode() {
		return enablecouponcode;
	}
	public WebElement getEnableapplyHsbcpdf() {
		return enableapplyHsbcpdf;
	}

	public WebElement getEnableICICDeals() {
		return enableICICDeals;
	}

	public WebElement getEnableHdfcDeals() {
		return enableHdfcDeals;
	}

	public WebElement getEnableapplyHsbc() {
		return enableapplyHsbc;
	}


	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//span[contains(@class,'DealsStyles__OfferDiscription')]")
	WebElement applyHsbc;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]/p/i[contains(@class,'pyt-heart')]")
	WebElement applyLoyaltyCreditPdg;
	
	public WebElement getApplyLoyaltyCreditPdg() {
		return applyLoyaltyCreditPdg;
	}

	public WebElement getApplyHsbc() {
		return applyHsbc;
	}

	public WebElement getOfferClose() {
		return offerClose;
	}

	public WebElement getApplyloyaltycredits() {
		return applyLoyaltyCredits;
	}

	public WebElement getStrikedPriceOnBookingScreen() {
		return strikedPriceOnBookingScreen;
	}
	
	public WebElement getCouponText() {
		return CouponText;
	}

	
	public WebElement getTravellersmodelclosebtn() {
		return travellersmodelclosebtn;
	}
	
	public WebElement getStrikedPriceDetailsPage() {
		return strikedPriceDetailsPage;
	}

	public WebElement getTotalPriceOnDetailsPage() {
		return totalpriceondetailspage;
	}
	
	public WebElement getWhatsAppLogo() {
		return whatsapplogo;
	}
	
	public WebElement getChatwithus() {
		return chatwithus;
	}
	
	public WebElement getAdultCountField() {
		return adultcountfield;
	}
	
	public WebElement getDateAndMonthOnbookingscreen() {
		return dateandmonthonbookingscreen;
	}
	
	public WebElement getPriceonbookingscreen() {
		return priceonbookingscreen;
	}
	

	public WebElement getBookthisdeal() {
		return bookthisdeal;
	}
	
	public WebElement getContinueButton() {
		return continuebutton;
	}
	
	public WebElement getNextActiveDate() {
		return nextactivedate;
	}
	
	public WebElement getDatePicker() {
		return datepicker;
	}
	
	public WebElement getDateInput() {
		return dateinput;
	}
	
	public WebElement getDealTitle() {
		return dealTitle;
	}
	
	public WebElement getNightsDropdown() {
		return nightsDropdown;
	}

	public WebElement getwhatsIncluded() {
		return whatsIncluded;
	}
	
	public WebElement getRoomUpgradeDropdown() {
		return roomUpgradeDropdown;
	}
	
	public WebElement getCurrentRoomTitle() {
		return currentRoomTitle;
	}
	
	public WebElement getAlternateRoomTitle() {
		return alternateRoomTitle;
	}
	
	public WebElement getSelectRoomButton() {
		return selectRoomButton;
	}
	
	public WebElement getAlternateRoomPrice() {
		return alternateRoomPrice;
	}

	
}
