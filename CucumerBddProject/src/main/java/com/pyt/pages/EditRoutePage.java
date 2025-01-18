package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class EditRoutePage {
	
	@FindBy(xpath ="(//div[@class='veho-c-lesPJm veho-c-lesPJm-ibvZFBa-css']//button[text()='Add City'])[last()]")
	WebElement addCity;

	@FindBy(xpath ="(//div[@class='veho-c-lesPJm veho-c-lesPJm-ibvZFBa-css']//button[text()='Edit Route'])[last()]")
	WebElement editRouteCustomize;
	
    @FindBy(xpath ="(//span[@class='veho-c-lesPJm veho-c-lesPJm-ijlPlPt-css delete-icon'])[last()]")
	WebElement delete;
    
    @FindBy(xpath ="(//div[@role='dialog']//a[text()='Replace'])[last()]")
	WebElement replaceCity;
    
    @FindBy(xpath ="//button[text()='Update trip cost']")
	WebElement updateTripCost;
    
    @FindBy(xpath ="(//div[@role='dialog']//div[contains(@class,'edit-night-stay')]//span)[1]")
	WebElement countOfNights;
    
    @FindBy(xpath ="(//div[@role='dialog']//div[contains(@class,'edit-night-stay')]//button[2])[1]")
   	WebElement addNights;
    
    @FindBy(xpath ="(//div[@role='dialog']//div[contains(@class,'edit-night-stay')]//button[1])[1]")
   	WebElement deleteNights;
    
    @FindBy(xpath ="(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-igiaMTy-css'])[last()]")
	WebElement firstCityInItnCard;
    
    @FindBy(xpath ="(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-icUKOUd-css'])[last()]")
	WebElement firstCityInEditRoute;

    @FindBy(xpath ="//button[contains(text(),'Build itinerary')]")
	WebElement buildItinerary;
    
    @FindBy(xpath ="(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-igiaMTy-css'])[last()]")
    WebElement lastCityInEditRoute;	
    
    @FindBy(xpath ="(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-igTidRE-css'])[1]")
    WebElement nightsCountIti;	

	


	

    
    
    




	



	

	

	@FindBy(xpath ="(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-ijMXaVc-css'])[1]")
   	WebElement firstCityInYourRoute;
    
	@FindBy(xpath ="(//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-icUKOUd-css'])[1]")
	WebElement addAlternateCity;
	


	
	

	 @FindBy(xpath ="//button[contains(text(),'Update itinerary')]")
		WebElement updateItinerary;

	@FindBy(xpath ="/(//div[contains(@class,'days-counter')]//i[contains(@class,'pyt-plus')])[4]")
	WebElement addNight;

	@FindBy(xpath ="//div[contains(@class,'active')]//i[contains(@class,'pyt-minus')]")
	WebElement removeNight;

	@FindBy(xpath ="(//div[contains(@class,'days-counter')]//span)[1]")
	WebElement countOfNightsInYourRoute;

	@FindBy(xpath ="(//div[contains(@class,'row activity-title')]//span)[1]")
	WebElement countOfNightsInItnCard;

	@FindBy(xpath ="//span[text()='Transfer by ferry']")
	WebElement transferByFerry;
	
	
	
	@FindBys(@FindBy(xpath ="//div[contains(@class,'route-modal')]//following::i[contains(@class,'pyt-delete')]"))
	List<WebElement> deleteIcon;
	
	@FindBy(xpath="//div[contains(@class,'route-modal')]//following::i[contains(@class,'pyt-delete')][1]")
	WebElement editRouteFirstCity;
	
	@FindBy(xpath="//i[contains(@class,'pyt-delete')]/../div/span")
	WebElement editRouteCityNight;
	
	@FindBy(xpath="//i[contains(@class,'pyt-minus')]")
	WebElement editRouteCityMinus;
	
	@FindBy(xpath="//div[@class='days-counter']//i[contains(@class,'pyt-plus')]")
	WebElement editRouteCityPlus;
	
	@FindBy(xpath="(//div[contains(@class,'CardRow__DayNumberCard')]//span[2])[1]")
	WebElement itineraryStartDate;
	
	@FindBy(xpath="(//div[contains(@class,'CardRow__DayNumberCard')]//span[2])[2]")
	WebElement itinerarySecondDate;
	
	
	public WebElement getNightsCountIti() {
		return nightsCountIti;
	}

	
	public WebElement getLastCityInEditRoute() {
		return lastCityInEditRoute;
	}
	
	public WebElement getBuildItinerary() {
		return buildItinerary;
	}
	
	public WebElement getAddCity() {
		return addCity;
	}


	public WebElement getAddNights() {
		return addNights;
	}


	public WebElement getDeleteNights() {
		return deleteNights;
	}
	
	
	public WebElement getItinerarySecondDate() {
		return itinerarySecondDate;
	}

	
	public WebElement getItineraryStartDate() {
		return itineraryStartDate;
	}

	
	public WebElement getEditRouteCityPlus() {
		return editRouteCityPlus;
	}

	
	public WebElement getEditRouteCityMinus() {
		return editRouteCityMinus;
	}

	
	public WebElement getEditRouteCityNight() {
		return editRouteCityNight;
	}


	public WebElement getEditRouteFirstCity() {
		return editRouteFirstCity;
	}
	
	public List<WebElement> getDeleteIcon() {
		return deleteIcon;
	}

	
	public WebElement getEditRouteCustomize() {
		return editRouteCustomize;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getFirstCityInEditRoute() {
		return firstCityInEditRoute;
	}

	public WebElement getUpdateItinerary() {
		return updateItinerary;
	}

	public WebElement getFirstCityInYourRoute() {
		return firstCityInYourRoute;
	}

	public WebElement getFirstCityInItnCard() {
		return firstCityInItnCard;
	}

	public WebElement getAddCityInEditRoute() {
		return  addCity;
	}

	public WebElement getAddAlternateCity() {
		return   addAlternateCity;
	}

	public WebElement getReplaceCity() {
		return  replaceCity;
	}

	public WebElement getAddNight() {
		return  addNight;
	}

	public WebElement getRemoveNight() {
		return  removeNight;
	}

	public WebElement getCountOfNights() {
		return countOfNights;
	}

	public WebElement getCountOfNightsInYourRoute() {
		return countOfNightsInYourRoute;
	}

	public WebElement getCountOfNightsInItnCard() {
		return countOfNightsInItnCard;
	}

	public WebElement getTransferByFerry() {
		return transferByFerry;
	}
	
	public WebElement getUpdateTripCost() {
		return updateTripCost;
	}
	
}
