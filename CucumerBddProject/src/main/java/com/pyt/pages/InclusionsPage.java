package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class InclusionsPage {

	@FindBy(xpath = ("(//*[contains(@class,'tracker-hotelchangebtn')])[1]"))
	WebElement hotelChangeButton;

	@FindBy(xpath = ("(//span[text()='Change'])[1]"))
	WebElement flightChangebutton;

	@FindBy(xpath = ("//button[contains(@class,'change-train')]"))
	WebElement flightRetrybutton;

	@FindBy(xpath = ("(//*[contains(@class,'tracker-actchangebtn')])[1]"))
	WebElement activityChangebutton;

	@FindBy(xpath = "//*[contains(text(),\"What’s included?\")]")
	WebElement inclusionsTab;

	@FindBy(xpath = "//*[contains(text(),'Day wise plan')]")
	WebElement itineraryTab;

	@FindBy(xpath = ("(//i[@class=\"vehoicon-close\"])[2]"))
	WebElement vehioClose;

	// Hotel CRUD operations

	// Change Hotel

	@FindBy(xpath = ("(//section[@class='change-data grid-list']//img)[1]"))
	WebElement changeHotel;

	// choose Hotel;

	@FindBy(xpath = "//button[contains(text(),'Choose')]")
	WebElement chooseHotel;

	// Book this trip button in the itinerary page
	// @FindBy(xpath = "n-tracker-boookyourtrip btn btn-primary")
	@FindBy(xpath = "(//div[@id='itinerary_page']//button)[1]")
	WebElement bookThisTrip;

	@FindBy(xpath = "//li[@class='flight-tab']")
	WebElement flightTab;

	@FindBy(xpath = "//li[@class='hotel-tab']")
	WebElement hotelTab;

	@FindBy(xpath = "//li[@class='activity-tab']")
	WebElement activityTab;

	@FindBy(xpath = "//li[@class='transfer-tab']")
	WebElement transferTab;

	@FindBy(xpath = "//li[@class='visa-insurance-tab']")
	WebElement visaTab;

	@FindBy(xpath = "//li[@class='flight-tab']//*/span[@class='WebRupee']")
	WebElement flightSplit;

	@FindBy(xpath = "//li[@class='hotel-tab']//*/span[@class='WebRupee']")
	WebElement hotelSplit;

	@FindBy(xpath = "//li[@class='activity-tab']//*/span[@class='WebRupee']")
	WebElement activitySplit;

	@FindBy(xpath = "//li[@class='transfer-tab']//*/span[@class='WebRupee']")
	WebElement transferSplit;

	@FindBy(xpath = "//li[@class='visa-insurance-tab']//*/span[@class='WebRupee']")
	WebElement visaSplit;

	@FindBy(xpath = "//button[@class='dropdown-toggle btn btn-primary']")
	WebElement bookTripDropdown;

	@FindBy(xpath = "//a[@role='menuitem']/span")
	WebElement getBetterCostOpt;

	@FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']/h2")
	WebElement betterCostAlert;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	WebElement acceptBetterCost;

	@FindBy(xpath = "//div[@class='dropdown open btn-group btn-group-primary']//*/span[@class='vehoicon-map']")
	WebElement shareItineraryOpt;

	@FindBy(xpath = "//div[@class='dropdown open btn-group btn-group-primary']//*/span[@class='vehoicon-arrow-up']")
	WebElement sendToPlatoOpt;

	@FindBy(xpath = "//div[@class='dropdown open btn-group btn-group-primary']//*/span[@class='vehoicon-receipt']")
	WebElement custSplitPrice;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement fetchMobileNoAcc;

	@FindBy(xpath = "//button[contains(text(),'Fetch accounts')]")
	WebElement fetchAccounts;

	@FindBy(xpath = "//span[contains(text(),'.com')]")
	WebElement userEmailForShare;

	@FindBy(xpath = "//input[@name='subject']")
	WebElement emailSubject;

	@FindBy(xpath = "//select[@name='travelerType']")
	WebElement travelerDropdown;

	@FindBy(xpath = "//select[@name='travelerType']/option[4]")
	WebElement travelerType;

	@FindBy(xpath = "//select[@name='purposeOfTravel']")
	WebElement travelPurpose;

	@FindBy(xpath = "//select[@name='purposeOfTravel']/option[3]")
	WebElement setTravelPurpose;

	@FindBy(xpath = "//select[@name='leadStatus']")
	WebElement leadStatus;

	@FindBy(xpath = "//select[@name='leadStatus']/option[3]")
	WebElement setLeadStatus;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement continueOpt;

	@FindBy(xpath = "//div[@class='modal changes modal-sticky-footer fade in container share-modal']//*/h2")
	WebElement shareConfirmation;

	@FindBy(xpath = "//div[@class='modal-footer']/*/i[@class='vehoicon-close']")
	WebElement closeShareAlert;

	@FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']/h2")
	WebElement platoSuccess;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	WebElement closePlatoAlert;

	@FindBy(xpath = "//span[@class='user-initials']")
	WebElement userInitials;

	@FindBy(xpath = "//*/a[contains(text(),'Logout')]")
	WebElement logout;

	// book now button in the inclusions page
//	@FindBy(xpath = "//button[@class='btn btn-xl btn-primary']")
//	@FindBy(xpath = "//button[text()='Book now'] | //button[text()='Review Inclusions'] | (//div[text()='Book this trip'])[1] | (//button[text()='Book this trip'])[1] | //span[text()='Book this trip']")
	@FindBy(xpath = "(//button/span[text()='Book this trip'])[1]")
	WebElement bookNow;

	/**
	 * Couldn't able to identify the insurance change button xpath so adding
	 * chropath result as a place holder once we get tracker class,I will update
	 * this -Meenatchi
	 **/
	
	
	//Insurace Area page elements
	@FindBy(xpath = "(//div[@name='more']//span[text()='Change'])[1]")
	WebElement insuranceChange;

	// Delete button in the insurance inclusions card
	@FindBy(xpath = "(//div[@name='more']//section[@class='veho-c-lesPJm']//span[text()='Remove'])[1]")
	WebElement insuranceDelete;

	@FindBy(xpath = "(//span[text()='50K Silver Plan'])[1]")
	WebElement insuranceType50kSilverPlan;

	// 4 type of insurance in the insurance modal
	@FindBy(xpath = "(//span[text()='100K Silver Plan'])[1]")
	WebElement insuranceType100kSilverPlan;

	@FindBy(xpath = "(//span[text()='100K Gold Plan'])[1]")
	WebElement insuranceType100kGoldPlan;

	@FindBy(xpath = "(//span[text()='250K Gold Plan'])[1]")
	WebElement insuranceType250kGoldPlan;

	// Apply button in the change insurance modal
	@FindBy(xpath = "//span[text()='Apply Insurance']")
	WebElement insuranceApply;

	@FindBy(xpath = "//div[text()='Policy updated successfully']")
	WebElement policyAddedSuccessfully;

	// Add button insurance
	@FindBy(xpath = "(//div[@name='more']//section[@class='veho-c-lesPJm']//span[text()='Add'])[1]")
	WebElement insuranceAdd;
	
	@FindBy(xpath = "(//div[@id='price-cta-wrapper']//*[name()='span'])[1]")
	WebElement totalcost;
	
	@FindBy(xpath = "//span[text()='View split pricing']")
	WebElement viewFullPricing;
	
	@FindBy(xpath = "//span[text()='Insurance (1)']")
	List<WebElement> insuranceRightPanel;
	
	@FindBy(xpath = "//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iiFLMQp-css']")
	WebElement planInCard;
	
	// Insurance type in inclusions card
	@FindBy(xpath = "//p[@class='small-heading']")
	WebElement insuranceTypeInInclusions;

	// Costing animation element
	@FindBy(xpath = "//div[contains(@class,'animation-holder')]")
	WebElement costingAnimation;

	// Android app link from the summary card
	@FindBy(xpath = "//img[@alt='Android App']")
	WebElement androidAppLinkInclusion;

	// IOS app link from the summary card
	@FindBy(xpath = "//img[@alt='ios App']")
	WebElement iosAppLinkInclusions;

	// summary card entire section
	@FindBy(xpath = "//section[@class='total-cost']")
	WebElement summaryCardEntireSection;

	// Change insurance button in the rental car card
	@FindBy(xpath = "(//div[contains(@name,'transfer')]//span[contains(text(),' Change')])[1]")
	WebElement insuranceChangeLinkInRentalCar;

	// transfer tab section in the inclusions header
	@FindBy(xpath = "(//span[contains(@class,'ItineraryNavigation__Tab')])[4]")
	WebElement transferTabInclusions;

	// Activtiy tab in the inclusions header
	@FindBy(xpath = "(//span[contains(@class,'ItineraryNavigation__Tab')])[5]")
	WebElement activityTabInclusions;

	// Flight tab in the inclusions header
	@FindBy(xpath = "(//span[contains(@class,'ItineraryNavigation__Tab')])[2]")
	WebElement flightTabInclusions;

	// Hotel tab in the inclusions header
	@FindBy(xpath = "(//span[contains(@class,'ItineraryNavigation__Tab')])[3]")
	WebElement hotelTabInclusions;

	// visa tab in the inclusion header
	@FindBy(xpath = "//section[contains(@class,'section-tab-links')]//a[contains(text(),'Visa')]")
	WebElement visaTabInclusions;

	@FindBy(xpath = "//*[@class='visa']//*[text()='Add']")
	WebElement visaAddButton;

	// update cost
	@FindBy(xpath = "(//button[contains(text(),'Update Cost')])[1]")
	WebElement updateCostButton;

	@FindBy(xpath = "//button[text()='Update trip cost'] | //div//button[text()='Update trip cost']")
	WebElement updateCost;

	@FindBy(xpath = "//*[@id='title_editable']")
	WebElement itineraryTitle;

	@FindBy(xpath = "//button[contains(text(),'Book this trip') and @disabled] |  //button[contains(text(),'Review Inclusions') and @disabled]")
	WebElement bookandreviewbutton;

	@FindBy(xpath = "//i[contains(@class,'pyt-more-fill')]")
	WebElement morepilloninclusion;

	@FindBy(xpath = "//div[@name='all-pass-panels']//section[contains(@class,'inclusion-box')]//h4")
	WebElement swissPassCard;

	@FindBy(xpath = "//div[@name='all-pass-panels']//section[contains(@class,'inclusion-box')]//button")
	WebElement swissPassCustomizeBtn;

	@FindBy(xpath = "//div[contains(@class,'EditComboModal')]//i[contains(@class,'pyt-close')]")
	WebElement swissPassCloseBtn;

	@FindBy(xpath = "//label[contains(text(),'Combo starting date')]//following::input")
	WebElement swissPassComboDate;

	@FindBy(xpath = "//span[contains(@class,'ItineraryNavigation__Tab')]//span[contains(text(),'Activity')] | //span[contains(@class,'ItineraryNavigation__Tab')]//span[contains(text(),'Activities')]")
	WebElement activityNavigatorInclusions;

	@FindBy(xpath = "//span[contains(text(),'Stay')]")
	WebElement stayTab;
	
	public WebElement getPlanInCard() {
		return planInCard;
	}

	public WebElement getInsuranceType50kSilverPlan() {
		return insuranceType50kSilverPlan;
	}

	public WebElement getInsuranceType100kSilverPlan() {
		return insuranceType100kSilverPlan;
	}

	public WebElement getInsuranceType250kGoldPlan() {
		return insuranceType250kGoldPlan;
	}

	public WebElement getPolicyAddedSuccessfully() {
		return policyAddedSuccessfully;
	}

	public WebElement getTotalcost() {
		return totalcost;
	}

	public WebElement getViewFullPricing() {
		return viewFullPricing;
	}

	public List<WebElement> getInsuranceRightPanel() {
		return insuranceRightPanel;
	}

	public WebElement getActivitNavigatorInclusions() {
		return activityNavigatorInclusions;
	}

	public WebElement getSwissPassComboDate() {
		return swissPassComboDate;
	}

	public WebElement getSwissPassCloseBtn() {
		return swissPassCloseBtn;
	}

	public WebElement getSwissPassCustomizeBtn() {
		return swissPassCustomizeBtn;
	}

	public WebElement getSwissPassCard() {
		return swissPassCard;
	}

	public WebElement getMorePillOnInclusion() {
		return morepilloninclusion;
	}

	public WebElement getBookandReviewButton() {
		return bookandreviewbutton;
	}

	public WebElement getItineraryTitle() {
		return itineraryTitle;
	}

	public WebElement getUpdateCost() {
		return updateCost;
	}

	public WebElement getUpdateCostButton() {
		return updateCostButton;
	}

	public WebElement getActivityTabInclusions() {
		return activityTabInclusions;
	}

	public WebElement getHotelTabInclusions() {
		return hotelTabInclusions;
	}

	public WebElement getVisaTabInclusions() {
		return visaTabInclusions;
	}

	public WebElement getFlightTabInclusions() {
		return flightTabInclusions;
	}

	public WebElement getTransferTabInclusions() {
		return transferTabInclusions;
	}

	public WebElement getInsuranceChangeLinkInRentalCar() {
		return insuranceChangeLinkInRentalCar;
	}

	public WebElement getAndroidAppLinkInclusion() {
		return androidAppLinkInclusion;
	}

	public WebElement getIosAppLinkInclusions() {
		return iosAppLinkInclusions;
	}

	public WebElement getSummaryCardEntireSection() {
		return summaryCardEntireSection;
	}

	public WebElement getInsuranceAdd() {
		return insuranceAdd;
	}

	public WebElement getCostingAnimation() {
		return costingAnimation;
	}

	public WebElement getInsuranceTypeInclusions() {
		return insuranceTypeInInclusions;
	}

	public WebElement getInsuranceApply() {
		return insuranceApply;
	}


	public WebElement getInsuranceType100kGoldPlan() {
		return insuranceType100kGoldPlan;
	}

	public WebElement getInsuranceChange() {
		return insuranceChange;
	}

	public WebElement getInsuranceDelete() {
		return insuranceDelete;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getBookThisTrip() {
		return bookThisTrip;
	}

	public WebElement gethotelChangeButton() {
		return hotelChangeButton;
	}

	public WebElement getFlightChangeButton() {
		return flightChangebutton;
	}

	public WebElement getActivityChangeButton() {
		return activityChangebutton;
	}

	public WebElement getinclusionsTab() {
		return inclusionsTab;
	}

	public WebElement getitineraryTab() {
		return itineraryTab;
	}

	public WebElement getvehioClose() {
		return vehioClose;
	}

	// Change hotels

	public WebElement getChangehotel() {
		return changeHotel;
	}

	public WebElement getChooseHotel() {
		return chooseHotel;
	}

	public WebElement getFlightSplit() {
		return flightSplit;
	}

	public WebElement getHotelSplit() {
		return hotelSplit;
	}

	public WebElement getTransferSplit() {
		return transferSplit;
	}

	public WebElement getActivitySplit() {
		return activitySplit;
	}

	public WebElement getVisaSplit() {
		return visaSplit;
	}

	public WebElement getBookTripDropdown() {
		return bookTripDropdown;
	}

	public WebElement getBetterCost() {
		return getBetterCostOpt;
	}

	public WebElement getBetterCostAlert() {
		return betterCostAlert;
	}

	public WebElement acceptBetterCostAlert() {
		return acceptBetterCost;
	}

	public WebElement getShareItinerary() {
		return shareItineraryOpt;
	}

	public WebElement inputCustMobileNo() {
		return fetchMobileNoAcc;
	}

	public WebElement getFetchAccounts() {
		return fetchAccounts;
	}

	public WebElement selectUserAccount() {
		return userEmailForShare;
	}

	public WebElement setEmailSubject() {
		return emailSubject;
	}

	public WebElement getTravelerDropdown() {
		return travelerDropdown;
	}

	public WebElement chooseTravelerType() {
		return travelerType;
	}

	public WebElement getTravelPurposeOpt() {
		return travelPurpose;
	}

	public WebElement chooseTravelPurpose() {
		return setTravelPurpose;
	}

	public WebElement getLeadStatusOpt() {
		return leadStatus;
	}

	public WebElement chooseLeadStatus() {
		return setLeadStatus;
	}

	public WebElement getContinue() {
		return continueOpt;
	}

	public WebElement getShareConfirmation() {
		return shareConfirmation;
	}

	public WebElement exitShareAlert() {
		return closeShareAlert;
	}

	public WebElement chooseSendToPlato() {
		return sendToPlatoOpt;
	}

	public WebElement getPlatoStatus() {
		return platoSuccess;
	}

	public WebElement exitPlatoAlert() {
		return closePlatoAlert;
	}

	public WebElement getSplitPriceOpt() {
		return custSplitPrice;
	}

	public WebElement getUserInitials() {
		return userInitials;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getVisaAddButton() {
		return visaAddButton;
	}

	public WebElement getFlightRetrybutton() {
		return flightRetrybutton;
	}
	
	public WebElement getStayTab() {
		return stayTab;
	}


}
