package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlockCardPage {

	@FindBy(xpath = "//div[@class='clearfix']")
	private List<WebElement> routeCardBlockCard;

	@FindBy(xpath = "(//section[@class='inclusion-box   error']//button[contains(text(),'Add Custom Item')])[1]")
	private WebElement blockCardFlightInternational;

	@FindBy(xpath = "//div[contains(@name,'flight')]//section[2]//button[contains(text(),'Add Custom Item')]")
	private WebElement blockCardFlightInternal;

	@FindBy(xpath = "//button[contains(text(),'ROUND TRIP')]")
	private WebElement roundTripFlightBlockCard;

	@FindBy(xpath = "//button[contains(text(),'One Way')]")
	private WebElement oneWayFlightBlockCard;

	@FindBy(xpath = "//button[contains(text(),'Multi City')]")
	private WebElement multipleCityFlightBlockCard;

	@FindBy(xpath = "(//*[contains(text(),'Internet Source')]/..//div)[1]")
	private WebElement flightBlockCardInternerSource;

	@FindBy(xpath = "//*[text()='Reason for Block card']")
	private WebElement reasonForFlightBlockCard;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Internet Cost')]")
	private WebElement internetCostFlightBlockCard;

	@FindBy(xpath = "//input[contains(@name,'carrierName')]/../div")
	private List<WebElement> airlineCodeFlightBlockCard;

	@FindBy(xpath = "//input[@name='flightNumber']")
	private List<WebElement> flightNumberBlockCard;

	@FindBy(xpath = "//label[text()='Departure City']/../div")
	private List<WebElement> departureCityFlightBlockCard;

	@FindBy(xpath = "//input[@name='arrivalCity']/../div")
	private List<WebElement> arrivalCityFlightBlockCard;


	@FindBy(xpath = "(//div[contains(@name,'stay')]//div/section[1]//span)[2]")
	private WebElement hotelCheckinDateInclusionFlightBlockCard;

	@FindBy(xpath = "//span[contains(text(),'Add Route')]")
	private List<WebElement> addRouteFlightBlockCard;

	@FindBy(xpath = "//label[text()='Departure Time']/..//input[@placeholder='HH:mm']")
	private List<WebElement> departureTimeFlightBlockCard;

	@FindBy(xpath = "//label[text()='Arrival Time']/..//input[@placeholder='HH:mm']")
	private List<WebElement> arrivalTimeFlightBlockCard;

	@FindBy(xpath = "//label[text()='Departure Date']/../div/input")
	private List<WebElement> departureDateFlightBlockCard;

	@FindBy(xpath = "//label[text()='Arrival Date']/../div/input")
	private List<WebElement> arrivalDateFlightBlockCard;

	@FindBy(xpath = "//input[@class='rc-time-picker-panel-input']")
	private WebElement timeFlightBlockCard;

	@FindBy(xpath = "//input[@type='number' and @placeholder='2']")
	private List<WebElement> baggageFlightBlockCard;

	@FindBy(xpath = "//div[contains(@name,'flight')]//button[contains(text(),'Edit Card')]")
	private WebElement editCardButtonFlightBlockCard;

	@FindBy(xpath = "(//div[contains(@name,'flight')]//section[2]//p/span)[1]")
	private WebElement internalFlightDepartureDate;

	// Xpath for hotel block card form
	@FindBy(xpath = "(//div[contains(@name,'stay')]//button[contains(text(),'Add Custom Item')])[1]")
	private WebElement blockCardHotel;

	// @FindBy(xpath="//input[@name='hotel-name']/../div")
	// @FindBy(xpath="//div[contains(text(),'Name of the hotel')]")
	@FindBy(xpath = "//div[contains(text(),'Name of the hotel')]/..")
	private WebElement hotelNameBlockCard;

	@FindBy(xpath = "//div[contains(text(),'Internet Provider')]/..")
	private WebElement internetProviderHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Free Wireless')]/..//button[contains(@class,'active')]")
	private WebElement wirelessActiveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Free Breakfast')]/..//button[contains(text(),'Yes')]")
	private WebElement breakFastActiveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Refundable')]/..//button[contains(text(),'Yes')]")
	private WebElement refundableActiveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Ac Available')]/..//button[contains(text(),'Yes')]")
	private WebElement acActiveHotelBlock;

	@FindBy(xpath = "//button[contains(text(),'Save & Create')]")
	private WebElement saveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'* All the fileds are madatory')]")
	private WebElement alertHotelBlockCard;

	@FindBy(xpath = "//input[@placeholder='Check in Date' and contains(@disabled,'')]")
	private WebElement checkInDateOfHotelFromBlockCard;

	@FindBy(xpath = "//input[@placeholder='Check out Date' and contains(@disabled,'')]")
	private WebElement checkOutDateOfHotelFromBlockCard;

	@FindBy(xpath = "//input[@placeholder='City Name' and contains(@disabled,'')]")
	private WebElement cityNameHotelBlockCard;

	@FindBy(xpath = "//div[contains(@class,'Collapsible__trigger is-open  panel-heading accordion-toggle')]")
	private WebElement roomPanelOpenHotelBlockCard;

	@FindBy(xpath = "//div[contains(@class,'Collapsible__trigger is-closed  panel-heading accordion-toggle')]")
	private WebElement roomPanelCloseHotelBlockCard;

	@FindBy(xpath = "//input[@name='roomDescription']")
	private WebElement roomCategoryHotelBlockCard;

	@FindBy(xpath = "//input[contains(@placeholder,'Internet Cost')]")
	private WebElement internetCostHotelBlockCard;

	@FindBy(xpath = "//input[@name='taRating']")
	private WebElement taRatingHotelBlockCard;

	@FindBy(xpath = "//input[@name='starRating']")
	private WebElement starRatingHotelBlockCard;

	@FindBy(xpath = "//div[@name='stay']//button[contains(text(),'Edit Card')]")
	private WebElement editCardButtonHotelBlockCard;

	@FindBy(xpath = "//input[@name='reasonForBlockCard']/../div")
	private WebElement reasonSectionHotelBlockCard;

	@FindBy(xpath = "//section[@class='inclusion-box cursor-pointer  error']//div/h4")
	private WebElement hotelCityNameAfterRemoved_InclusionCard;

	@FindBy(xpath = "//section[@class='inclusion-box cursor-pointer  error']//div//p/span[1]")
	private WebElement checkInDateAfterRemoved_InclusionCard;

	@FindBy(xpath = "//section[@class='inclusion-box cursor-pointer  error']//div//p/span[2]")
	private WebElement checkOutDateAfterRemoved_InclusionCard;

	@FindBy(xpath = "//p[contains(text(),'* All the fileds are madatory')]")
	private WebElement mandatoryFieldAlertHotelBlockCard;

	@FindBy(xpath = "//div[contains(@class,'menu')]/div/div[1]")
	private WebElement dbHotelFirstElementBlockCard;

	// Xpath for other block card form
	@FindBy(xpath = "//div[@name='all-others-panels']/../div/button[contains(text(),'Add Custom Item')]")
	private WebElement othersBlockCard;

	@FindBy(xpath = "//div[@name='all-others-panels']/../div/button[contains(text(),'Add Custom Item') and @disabled]")
	private WebElement otherBlockCardDisabled;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleFieldOtherBlockCard;

	@FindBy(xpath = "//input[@name='source']")
	private WebElement sourceFieldOtherBlockCard;

	@FindBy(xpath = "//div[contains(@class,'DraftEditor-editorContainer')]")
	private WebElement descFieldOtherBlockCard;

	@FindBy(xpath = "//input[@name='ourCost']")
	private WebElement costFieldOtherBlockCard;

	@FindBy(xpath = "//input[@name='publishedCost']")
	private WebElement publishedCostFieldOtherBlockCard;

	@FindBy(xpath = "//div[@name='all-others-panels']//button[contains(text(),'Edit Card')]")
	private WebElement editCardButtonOtherBlockCard;

	@FindBy(xpath = "//*[text()='Reason']")
	private WebElement reasonFieldOtherBlockCard;

	@FindBy(xpath = "//div[@name='all-others-panels']//button/i")
	private WebElement deleteButtonOtherBlockCard;

	@FindBy(xpath = "//div[contains(@name,'all-others-panels')]")
	private WebElement otherBlockCardInclusion;
	
	@FindBy(xpath = "//label[contains(text(),'Meal type')]/../div")
	private WebElement mealTypeonBlockCard;

	
	@FindBy(xpath = "//input[@placeholder='Inclusions title']")
	private WebElement customInclusionTitle;
	
	@FindBy(xpath = "//div[@class='DraftEditor-editorContainer']")
	private WebElement customInclusionTextEditor;
	
	
	@FindBy(xpath = "//label[contains(text(),'Start Date')]/../div")
	private WebElement cancellationStartDate;
	
	@FindBy(xpath = "//label[contains(text(),'End Date')]/../div")
	private WebElement cancellationEndDate;
	
	@FindBy(xpath = "//div[contains(@class,'react-datepicker__day--today')]")
	private WebElement cancellationCurrentDate;
	
	@FindBy(xpath = "//input[@placeholder='Fee']")
	private WebElement cancellatioFee;
	
	
	@FindBy(xpath = "//span[text()='Add Custom Item']")
	WebElement hotelBlockCard;
	
	@FindBy(xpath = "(//div[contains(@class,'css-1hwfws3')]//input[@type='text'])[1]")
	WebElement nameOfHotel;
	
	@FindBy(xpath = "//label[text()='Internet Source']//following::div[1]")
	WebElement internetProvider;
	
	@FindBy(xpath = "//div[text()='Reason for block card']")
	WebElement reasonForBlockCard;
	
	@FindBy(xpath="//input[@id='checkInTime']")
	WebElement checkInTime;
	
	@FindBy(xpath="//input[@id='checkOutTime']")
	WebElement checkOutTime;
	
	@FindBy(xpath="(//div[contains(text(),'Room')])[1]")
	WebElement room;
	
	@FindBy(xpath="//input[@placeholder='Room Category']")
	WebElement roomCategory;
	
	@FindBy(xpath="//input[@placeholder='Net Cost']")
	WebElement netCost;
	
	@FindBy(xpath="//input[@placeholder='Fee']")
	WebElement fee;
	
	@FindBy(xpath="//div[text()='EXPEDIA']")
	WebElement internetSourceOption;
	
	@FindBy(xpath = "//div[text()='Specific hotel NA on product']")
	WebElement reasonForBlockCardOption;
	
	@FindBy(xpath="//button[text()='Save & Create']")
	WebElement saveAndCreate;
	
	@FindBy(xpath="(//span[text()='Edit Card'])[1]")
	WebElement editCard;
	
	@FindBy(xpath="//i[@class='pyt-close-16 close-icon']")
	WebElement closeCustomItem;
	
	@FindBy(xpath="//input[@placeholder='Trip Advisor Rating']")
	WebElement tripAdvisorRating;
	
	@FindBy(xpath="//input[@placeholder='Star Rating']")
	WebElement starRating;
	
	@FindBy(xpath="//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-idrafvI-css']")
	WebElement cardPrice;
	
	@FindBy(xpath="(//span[text()='Add Block Card'])[1]")
	WebElement activityBlockCard;
	
	@FindBy(xpath="//input[@id='activityId']")
	WebElement activitySelectActivity;
	
	@FindBy(xpath="(//li[contains(@id,'downshift')])[1]")
	WebElement selectActivityOption;
	
	@FindBy(xpath="//input[@id='pickupTime']")
	WebElement activityPickUpTime;
	
	@FindBy(xpath="//input[@id='startTime']")
	WebElement activityStartTime;
	
	@FindBy(xpath="//input[@id='ourCost']")
	WebElement activityOurCost;
	
	@FindBy(xpath="//input[@id='publishedCost']")
	WebElement activityPublishedCost;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement activityDescription;
	
	@FindBy(xpath="//input[@id='cancellationTimelineList.0.fee']")
	WebElement activityFee;
	
	@FindBy(xpath="//span[text()='Save & create']")
	WebElement activitySaveAndCreate;
	
	@FindBy(xpath="//div[text()='Block Card']//following::div[text()='Remove']")
	WebElement activityBlockCardRemove;
	
	@FindBy(xpath="//div[@name='activities']")
	WebElement activities;
	
	@FindBy(xpath="//span[text()='Your Trip']")
	WebElement dayByDay;
	
	@FindBy(xpath="//label[text()='Name of Hotel']/following::div[@class=' css-1uccc91-singleValue'][1]")
	WebElement hotelName;
	
	@FindBy(xpath="//div[@name='stay']")
	WebElement stays;
	
	@FindBy(xpath="//div[@name='activities']")
	List<WebElement> activitiesSection;
	
	
	
	
	
	
	
	
	
	
	public List<WebElement> getActivitiesSection() {
		return activitiesSection;
	}

	public WebElement getHotelName() {
		return hotelName;
	}

	public WebElement getStays() {
		return stays;
	}

	public WebElement getDayByDay() {
		return dayByDay;
	}

	public WebElement getActivityBlockCard() {
		return activityBlockCard;
	}

	public WebElement getActivitySelectActivity() {
		return activitySelectActivity;
	}

	public WebElement getSelectActivityOption() {
		return selectActivityOption;
	}

	public WebElement getActivityPickUpTime() {
		return activityPickUpTime;
	}

	public WebElement getActivityStartTime() {
		return activityStartTime;
	}

	public WebElement getActivityOurCost() {
		return activityOurCost;
	}

	public WebElement getActivityPublishedCost() {
		return activityPublishedCost;
	}

	public WebElement getActivityDescription() {
		return activityDescription;
	}

	public WebElement getActivityFee() {
		return activityFee;
	}

	public WebElement getActivitySaveAndCreate() {
		return activitySaveAndCreate;
	}

	public WebElement getActivityBlockCardRemove() {
		return activityBlockCardRemove;
	}

	public WebElement getActivities() {
		return activities;
	}

	public WebElement getCardPrice() {
		return cardPrice;
	}

	public WebElement getTripAdvisorRating() {
		return tripAdvisorRating;
	}

	public WebElement getStarRating() {
		return starRating;
	}

	public WebElement getMealTypeonBlockCard() {
		return mealTypeonBlockCard;
	}

	public WebElement getCancellatioFee() {
		return cancellatioFee;
	}

	public WebElement getHotelBlockCard() {
		return hotelBlockCard;
	}

	public WebElement getNameOfHotel() {
		return nameOfHotel;
	}

	public WebElement getInternetProvider() {
		return internetProvider;
	}

	public WebElement getReasonForBlockCard() {
		return reasonForBlockCard;
	}

	public WebElement getCheckInTime() {
		return checkInTime;
	}

	public WebElement getCheckOutTime() {
		return checkOutTime;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRoomCategory() {
		return roomCategory;
	}

	public WebElement getNetCost() {
		return netCost;
	}

	public WebElement getFee() {
		return fee;
	}

	public WebElement getInternetSourceOption() {
		return internetSourceOption;
	}

	public WebElement getReasonForBlockCardOption() {
		return reasonForBlockCardOption;
	}

	public WebElement getSaveAndCreate() {
		return saveAndCreate;
	}

	public WebElement getEditCard() {
		return editCard;
	}

	public WebElement getCloseCustomItem() {
		return closeCustomItem;
	}

	public WebElement getCancellationFee() {
		return cancellatioFee;
	}
	
	public WebElement getCancellationCurrentDate() {
		return cancellationCurrentDate;
	}
	
	public WebElement getCancellationStartDate() {
		return cancellationStartDate;
	}
	public WebElement getCancellationEndDate() {
		return cancellationEndDate;
	}
	
	public WebElement getCustomInclusionTextEditor() {
		return customInclusionTextEditor;
	}
	
	
	public WebElement getCustomInclusionTitle() {
		return customInclusionTitle;
	}

	public WebElement getMealTypeSectionHotelBlockCard() {
		return mealTypeonBlockCard;
	}

	public List<WebElement> getRouteCardBlockCard() {
		return routeCardBlockCard;
	}

	public WebElement getInternalFlightDepartureDate() {
		return internalFlightDepartureDate;
	}

	public List<WebElement> getBaggageFlightBlockCard() {
		return baggageFlightBlockCard;
	}

	public WebElement getTimeFlightBlockCard() {
		return timeFlightBlockCard;
	}

	public List<WebElement> getDepartureDateFlightBlockCard() {
		return departureDateFlightBlockCard;
	}

	public List<WebElement> getArrivalDateFlightBlockCard() {
		return arrivalDateFlightBlockCard;
	}

	public List<WebElement> getAddRouteFlightBlockCard() {
		return addRouteFlightBlockCard;
	}

	public List<WebElement> getDepartureTimeFlightBlockCard() {
		return departureTimeFlightBlockCard;
	}

	public WebElement getHotelCheckinDateInclusionFlightBlockCard() {
		return hotelCheckinDateInclusionFlightBlockCard;
	}

	public List<WebElement> getArrivalTimeFlightBlockCard() {
		return arrivalTimeFlightBlockCard;
	}

	public List<WebElement> getArrivalCityFlightBlockCard() {
		return arrivalCityFlightBlockCard;
	}

	public List<WebElement> getDepartureCityFlightBlockCard() {
		return departureCityFlightBlockCard;
	}

	public List<WebElement> getFlightNumberBlockCard() {
		return flightNumberBlockCard;
	}

	public List<WebElement> getAirlineCodeFlightBlockCard() {
		return airlineCodeFlightBlockCard;
	}

	public WebElement getOneWayFlightBlockCard() {
		return oneWayFlightBlockCard;
	}

	public WebElement getMultipleCityFlightBlockCard() {
		return multipleCityFlightBlockCard;
	}

	public WebElement getRoundTripFlightBlockCard() {
		return roundTripFlightBlockCard;
	}

	public WebElement getReasonForFlightBlockCard() {
		return reasonForFlightBlockCard;
	}

	public WebElement getInternetCostFlightBlockCard() {
		return internetCostFlightBlockCard;
	}

	public WebElement getOtherBlockCardDisabled() {
		return otherBlockCardDisabled;
	}

	public WebElement getPublishedCostFieldOtherBlockCard() {
		return publishedCostFieldOtherBlockCard;
	}

	public WebElement getOtherBlockCardInclusion() {
		return otherBlockCardInclusion;
	}

	public WebElement getDeleteButtonOtherBlockCard() {
		return deleteButtonOtherBlockCard;
	}

	public WebElement getReasonFieldOtherBlockCard() {
		return reasonFieldOtherBlockCard;
	}

	public WebElement getEditCardButtonOtherBlockCard() {
		return editCardButtonOtherBlockCard;
	}

	public WebElement getTitleFieldOtherBlockCard() {
		return titleFieldOtherBlockCard;
	}

	public WebElement getSourceFieldOtherBlockCard() {
		return sourceFieldOtherBlockCard;
	}

	public WebElement getDescFieldOtherBlockCard() {
		return descFieldOtherBlockCard;
	}

	public WebElement getCostFieldOtherBlockCard() {
		return costFieldOtherBlockCard;
	}

	public WebElement getOthersBlockCard() {
		return othersBlockCard;
	}

	public WebElement getDbHotelFirstElementBlockCard() {
		return dbHotelFirstElementBlockCard;
	}

	public WebElement getMandatoryFieldAlertHotelBlockCard() {
		return mandatoryFieldAlertHotelBlockCard;
	}

	public WebElement getHotelCityNameAfterRemoved_InclusionCard() {
		return hotelCityNameAfterRemoved_InclusionCard;
	}

	public WebElement getCheckInDateAfterRemoved_InclusionCard() {
		return checkInDateAfterRemoved_InclusionCard;
	}

	public WebElement getCheckOutDateAfterRemoved_InclusionCard() {
		return checkOutDateAfterRemoved_InclusionCard;
	}

	public WebElement getReasonSectionHotelBlockCard() {
		return reasonSectionHotelBlockCard;
	}

	public WebElement getEditCardButtonHotelBlockCard() {
		return editCardButtonHotelBlockCard;
	}

	public WebElement getStarRatingHotelBlockCard() {
		return starRatingHotelBlockCard;
	}

	public WebElement getTaRatingHotelBlockCard() {
		return taRatingHotelBlockCard;
	}

	public WebElement getSaveHotelBlockCard() {
		return saveHotelBlockCard;
	}

	public WebElement getBreakFastActiveHotelBlockCard() {
		return breakFastActiveHotelBlockCard;
	}

	public WebElement getRefundableActiveHotelBlockCard() {
		return refundableActiveHotelBlockCard;
	}

	public WebElement getAcActiveHotelBlock() {
		return acActiveHotelBlock;
	}

	public WebElement getAlertHotelBlockCard() {
		return alertHotelBlockCard;
	}

	public WebElement getCheckInDateOfHotelFromBlockCard() {
		return checkInDateOfHotelFromBlockCard;
	}

	public WebElement getCheckOutDateOfHotelFromBlockCard() {
		return checkOutDateOfHotelFromBlockCard;
	}

	public WebElement getCityNameHotelBlockCard() {
		return cityNameHotelBlockCard;
	}

	public WebElement getRoomPanelOpenHotelBlockCard() {
		return roomPanelOpenHotelBlockCard;
	}

	public WebElement getRoomPanelCloseHotelBlockCard() {
		return roomPanelCloseHotelBlockCard;
	}

	public WebElement getRoomCategoryHotelBlockCard() {
		return roomCategoryHotelBlockCard;
	}

	public WebElement getInternetCostHotelBlockCard() {
		return internetCostHotelBlockCard;
	}

	public WebElement getBlockCardFlightInternational() {
		return blockCardFlightInternational;
	}

	public WebElement getBlockCardFlightInternal() {
		return blockCardFlightInternal;
	}

	public WebElement getBlockCardHotel() {
		return blockCardHotel;
	}

	public WebElement getFlightBlockCardInternerSource() {
		return flightBlockCardInternerSource;
	}

	public WebElement getHotelNameBlockCard() {
		return hotelNameBlockCard;
	}

	public WebElement getInternetProviderHotelBlockCard() {
		return internetProviderHotelBlockCard;
	}

	public WebElement getWirelessActiveHotelBlockCard() {
		return wirelessActiveHotelBlockCard;
	}

	public WebElement getEditCardButtonFlightBlockCard() {
		return editCardButtonFlightBlockCard;
	}

}
