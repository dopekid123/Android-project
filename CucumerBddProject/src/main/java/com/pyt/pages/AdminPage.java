package com.pyt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

	// Admin Discount Apply button for the other itinerary
	@FindBy(xpath = "//i[contains(@class,'pyt-edit') and contains(@class,'main-para')]")
	WebElement adminDiscountGlobaButton;

	// Admin Options DropDown

	@FindBy(xpath = "//div[contains(@class,'dropdown')]//a[contains(text(),'Send to PLATO')] | //div[contains(@class,'dropdown open')] | //div[contains(@class,'dropdown')]//span[contains(text(),'Send to PLATO')]")
	WebElement adminSendToPlatoOption;

	@FindBy(xpath = "//div[contains(@class,'dropdown')]//a[contains(text(),'Get better cost')] | //div[contains(@class,'dropdown')]//span[contains(text(),' Get better cost')]")
	WebElement adminGetBetterCost;

	@FindBy(xpath = "//div[contains(@class,'dropdown')]//a[contains(text(),'Share Itinerary')] | //div[contains(@class,'dropdown')]//span[contains(text(),' Share itinerary')]")
	WebElement adminShareItinerary;

	@FindBy(xpath = "//div[contains(@class,'dropdown')]//a[contains(text(),'Share PDF')] | //div[contains(@class,'dropdown')]//span[contains(text(),' Share PDF')]")
	WebElement adminSharePDF;

	@FindBy(xpath = "//div[contains(@class,'dropdown')]//a[contains(text(),'Cancellation Policy')] | //div[contains(@class,'dropdown')]//span[contains(text(),' Cancellation Policy')]")
	WebElement adminCancelationPolcyOption;

	@FindBy(xpath = "//div[contains(@class,'dropdown')]//a[contains(text(),'Update Locale')] | //div[contains(@class,'dropdown')]//span[contains(text(),' Update Locale')]")
	WebElement updateLocaleOption;

	@FindBy(xpath = "//a[contains(text(),'Enable')] | //span[contains(text(),' Enable split pricing for cust')]")
	WebElement adminSplitPricingForCustomers;

	@FindBy(xpath = "//button[contains(@class,'primary dropdown-toggle')] | //button[contains(@class,'downarrow-btn')]")
	WebElement adminOptionsDropdown;

	// ShareItinerary
	@FindBy(xpath = "//form[@id='share_itinerary_modal-form']//input")
	WebElement shareMobNo;

	@FindBy(xpath = "//button[contains(text(),'Fetch')]")
	WebElement sharefetchAcc;

	@FindBy(xpath = "//*[@id='share_itinerary_modal-form']//i[1]")
	WebElement shareExistemailId;

	@FindBy(xpath = "//select[@name='leadStatus']")
	WebElement shareleadStatusDropDown;

	@FindBy(xpath = "//option[@value='IN_TALKS']")
	WebElement shareleadStatusinTalks;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement shareContinueButton;

	@FindBy(xpath = "//*[text()='Your itinerary is on its way to your inbox.']")
	WebElement shareAlertMessage;

	@FindBy(xpath = "//button[@data-dismiss='modal']//i")
	WebElement shareAlertCloseButton;

	@FindBy(xpath = "//div[@class='modal-header']//div[contains(@class,'ChangeLocaleModal')]")
	WebElement updateLocaleModel;

	@FindBy(xpath = "//div[@class='modal-footer']//button[text()='Change']")
	WebElement changeOptionOnUpdateLocale;

	@FindBy(xpath = "//span[contains(text(),'Fetched User')]")
	WebElement fetchAccountDetails;

	@FindBy(xpath = "//div[contains(@class,'share-modal')]")
	WebElement shareItineraryModal;

	@FindBy(xpath = "//div[@name='stay']//b")
	WebElement hotelSplitPrice;

	@FindBy(xpath = "(//div[@name='transfer']//b)[1]")
	WebElement transferSplitPrice;

	@FindBy(xpath = "//button[@data-dismiss='modal']")
	WebElement shareItineraryAckMsgModalClose;

	@FindBy(xpath = "//textarea[@name='callNotes']")
	WebElement shareItineraryCallNotes;

	public WebElement getshareItineraryCallNotes() {
		return shareItineraryCallNotes;

	}

	public WebElement getShareItineraryAckMsgModalClose() {
		return shareItineraryAckMsgModalClose;

	}

	public WebElement getTransferSplitPrice() {
		return transferSplitPrice;
	}

	public WebElement getHotelSplitPrice() {
		return hotelSplitPrice;
	}

	public WebElement getShareItineraryModal() {
		return shareItineraryModal;
	}

	public WebElement getFetchAccountDetails() {
		return fetchAccountDetails;
	}

	public WebElement getChangeOptionOnUpdateLocale() {
		return changeOptionOnUpdateLocale;
	}

	public WebElement getUpdateLocaleModel() {
		return updateLocaleModel;
	}

	public WebElement getUpdateLocaleOption() {
		return updateLocaleOption;
	}

	public WebElement getAdminOptionsDropdown() {
		return adminOptionsDropdown;
	}

	public WebElement getShareMobNo() {
		return shareMobNo;
	}

	public WebElement getSharefetchAcc() {
		return sharefetchAcc;
	}

	public WebElement getShareExistemailId() {
		return shareExistemailId;
	}

	public WebElement getShareleadStatusDropDown() {
		return shareleadStatusDropDown;
	}

	public WebElement getShareleadStatusinTalks() {
		return shareleadStatusinTalks;
	}

	public WebElement getShareContinueButton() {
		return shareContinueButton;
	}

	public WebElement getShareAlertMessage() {
		return shareAlertMessage;
	}

	public WebElement getShareAlertCloseButton() {
		return shareAlertCloseButton;
	}

	public WebElement getadminOptionsDropdown() {
		return adminOptionsDropdown;
	}

	public WebElement getAdminDiscountGlobaButton() {
		return adminDiscountGlobaButton;
	}

	public WebElement getAdminSendToPlatoOption() {
		return adminSendToPlatoOption;
	}

	public WebElement getAdminGetBetterCost() {
		return adminGetBetterCost;
	}

	public WebElement getAdminShareItinerary() {
		return adminShareItinerary;
	}

	public WebElement getAdminSharePDF() {
		return adminSharePDF;
	}

	public WebElement getAdminCancelationPolcyOption() {
		return adminCancelationPolcyOption;
	}

	public WebElement getAdminSplitPricingForCustomers() {
		return adminSplitPricingForCustomers;
	}

}
