package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

//Will change the xpath after getting the tracker class

public class SandunePage {

	@FindBy(xpath = "//span[contains(text(),'Done! Build itinerary')] | //button[contains(text(),'Build itinerary')]")
	WebElement dubaiBuildItinerary;

	@FindBy(xpath = "//button[contains(text(),'Review Inclusions')]")
	WebElement dubaiReviewInclusions;

	@FindBy(xpath = "(//*[contains(@class,'ItineraryNavigation__Tab')])[2]")
	WebElement dubaiInclusionsTab;

	@FindBy(xpath = "//span[contains(text(),'Add split stay')]")
	WebElement dubaiSplitStay;

	@FindBy(xpath = "//select[contains(@class,'order-select')]")
	WebElement orderOfStay;

	@FindBy(xpath = "//select[contains(@class,'order-select')]//option[@value='START']")
	WebElement beginningStay;

	@FindBy(xpath = "//select[contains(@class,'order-select')]//option[@value='END']")
	WebElement endStay;

	@FindBy(xpath = "(//*[@class='pyt-close-16'])[1]")
	WebElement pytClose;

	@FindBy(xpath = "//select[contains(@class,'days-select')]")
	WebElement durationOfStay;

	@FindBy(xpath = "//select[contains(@class,'days-select')]//option[2]")
	WebElement durationOfDay;

	@FindBy(xpath = "//button[contains(text(),'Find hotels')]")
	WebElement findHotels;

	@FindBy(xpath = "//section[@class='hotel_card'][1]")
	WebElement hotelCard;

	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement addToItineraryCta;

	@FindBy(xpath = "//div[@name='stay']//i[contains(@class,'pyt-delete')]")
	WebElement deleteSplitStayHotel;

	@FindBy(xpath = "//div[contains(@class,'sweet-alert')]")
	WebElement deleteHotelAlert;

	@FindBy(xpath = "//div[contains(@class,'sweet-alert')]//button[@class='confirm']")
	WebElement deleteHotelConfirmButton;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'activity-header')]/following-sibling::p"))
	private List<WebElement> activityCardList;

	@FindBy(xpath = "//span[contains(@class,'pos-r')]")
	WebElement depCityLink;

	@FindBy(xpath = "//button[text()='View Similar']")
	WebElement activitySimiliarCta;

	@FindBy(xpath = "(//div[@name='transfer']//button[contains(text(),'Change to shared')])[1]")
	WebElement airportHotelTransfer;

	@FindBy(xpath = "(//div[@name='transfer']//button[contains(text(),'Change to shared')])[2]")
	WebElement hotelAirportTransfer;

//	@FindBy(xpath = "//a[contains(text(),'Hotel')]/span")
	@FindBy(xpath = "//i[contains(@class,'hotel')]//following-sibling::span")
	WebElement hotelCount;

	@FindBy(xpath = "//input[@placeholder='Search cities']")
	WebElement searchCity;

	@FindBy(xpath = "//li[contains(@class,'List__ListItem')]")
	WebElement firstSearchedCity;

	@FindBy(xpath = "(//span[contains(@class,'Calender__Arrow')])[2]")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//span[contains(text(),'1')] | (//span[contains(text(),'1')])[1]")
	WebElement dateOneButton;

	@FindBy(xpath = "//*[contains(text(),'Your stay at Dubai')]")
	WebElement splitStayModalText;

	@FindBy(xpath = "//span[contains(@class,'ItineraryNavigation__Tab')]//i[contains(@class,'pyt-hotel-fill')]")
	WebElement navigatetostaysinclusion;

	public WebElement getFirsthotelname() {
		return firsthotelname;
	}

	@FindBy(xpath = "//div[contains(@name,'stay')]//button[contains(text(),'Change')]")
	WebElement changeHotelInclusion;

	@FindBy(xpath = "(//div[contains(@name,'stay')]//div[contains(@class,'row vertical-center item-header')])[1]//h4")
	WebElement firsthotelname;

	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement detailsPageAddToItinneraryButton;

	@FindBy(xpath = "(//section[contains(@class,'hotel_card')])[1]//span[contains(@class,'small-heading bold')]")
	WebElement hotel_firsthotelname;

	//@FindBy(xpath = "//span[text()='December']")
	@FindBy(xpath = "(//section)[2]//div[contains(@class,'tick')]//following::span[1]")
	WebElement depmonth;
	

	@FindBy(xpath = "//a[text()='Chennai, MAA']")
	WebElement chndepcity;
	
	@FindBy(xpath = "//span[text()='2-3 nights'] | //span[text()='6-9 Days'] | //span[text()='5-6 nights'] |//span[text()='3-5 Days']")
	WebElement depdays;
	
	@FindBy(xpath = "//span[text()='Solo']")
	WebElement solostaytype;
	
	@FindBy(xpath = "//span[text()='Ferrari World']")
	WebElement dubaiactivityferrariworld;
	
	@FindBy(xpath = "//span[text()='Desert Safari Tour']")
	WebElement dubaiactivitydesertsafari;
	
	
	
	
	
	
	public WebElement getdubaiactivitydesertsafari() {
		return dubaiactivitydesertsafari;
	}
	
	
	
	public WebElement getdubaiactivityferrariworld() {
		return dubaiactivityferrariworld;
	}
	
	
	public WebElement getdepdays() {
		return depdays;
	}
	
	
	public WebElement getsolostaytype() {
		return solostaytype;
	}
	
	
	public WebElement getchnDepcity() {
		return chndepcity;
	}
	
	
	public WebElement getDepmonth() {
		return depmonth;
	}
	
	
	public WebElement getHotel_firsthotelname() {
		return hotel_firsthotelname;
	}

	public WebElement getDetailsPageAddToItinneraryButton() {
		return detailsPageAddToItinneraryButton;
	}

	public WebElement getChangeHotelInclusion() {
		return changeHotelInclusion;
	}

	public WebElement getNavigatetostaysinclusion() {
		return navigatetostaysinclusion;
	}

	public WebElement getSplitStayModalText() {
		return splitStayModalText;
	}

	public WebElement getFirstSearchedCity() {
		return firstSearchedCity;
	}

	public WebElement getSearchCity() {
		return searchCity;
	}

	public WebElement getHotelAirportTransfer() {
		return hotelAirportTransfer;

	}

	public WebElement getAirportHotelTransfer() {
		return airportHotelTransfer;

	}

	public WebElement getActivitySimiliarCta() {
		return activitySimiliarCta;

	}

	public WebElement getDepCityLink() {
		return depCityLink;
	}

	public List<WebElement> getActivityCardList() {
		return activityCardList;
	}

	public WebElement getDeleteHotelConfirm() {
		return deleteHotelConfirmButton;
	}

	public WebElement getDeleteHotelAlert() {
		return deleteHotelAlert;
	}

	public WebElement getDeleteHotel() {
		return deleteSplitStayHotel;
	}

	public WebElement getAddToItineraryCta() {
		return addToItineraryCta;
	}

	public WebElement getHotelCard() {
		return hotelCard;
	}

	public WebElement getFindHotels() {
		return findHotels;
	}

	public WebElement getDurationOfDay() {
		return durationOfDay;
	}

	public WebElement getDurationOfStay() {
		return durationOfStay;
	}

	public WebElement getPytClose() {
		return pytClose;
	}

	public WebElement getOrderOfStay() {
		return orderOfStay;
	}

	public WebElement getBeginningStay() {
		return beginningStay;
	}

	public WebElement getEndStay() {
		return endStay;
	}

	public WebElement getAddSplitStay() {
		return dubaiSplitStay;
	}

	public WebElement getInclusionHeader() {
		return dubaiInclusionsTab;
	}

	public WebElement getBuildItinerary() {
		return dubaiBuildItinerary;
	}

	public WebElement getReviewInclusions() {
		return dubaiReviewInclusions;
	}

	public WebElement getHotelCount() {
		return hotelCount;
	}

	public WebElement getnextMonthArrow() {
		return nextMonthArrow;
	}

	public WebElement getDateOneButton() {
		return dateOneButton;
	}

}
