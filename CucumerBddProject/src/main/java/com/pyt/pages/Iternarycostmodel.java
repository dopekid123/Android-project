package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Iternarycostmodel {
	
	@FindBy(xpath="//button[contains(text(),'Get trip cost')]")
	WebElement TripCostButton;

	@FindBy(xpath="//input[@placeholder='Departing from'] | //input[@placeholder='Search cities']")
	WebElement departingCity;
	
	@FindBy(xpath="//input[@placeholder='Departing on']")
	WebElement departingOnCitydate;
	
	@FindBy(xpath="(//form[@action='#']/div[2]//input)[2]")
	WebElement arrivalOn;
	
	@FindBy(xpath= "//form[@action='#']/div[2]//input")
	WebElement departureDate;
	
	@FindBy(xpath = "(//button[contains(text(),'Get Cost')])[1]")
    WebElement getCostinGCM;
	
	@FindBy(xpath="(//div[contains(@class,'react-datepicker') and text()='3'])[2]")
	WebElement departingOnCitydate20;
	
	@FindBy(xpath="//div[contains(@class,'keyboard-selected') or contains(@class,'day--selected')]")
	WebElement departingOnCurrentDate;	
	
	@FindBy(xpath="//input[@class = 'form-control react-datepicker-ignore-onclickoutside']")
	WebElement datePicker;
	
	@FindBy(xpath="//input[@placeholder='Choose Departure city...']")
	WebElement depatureCityPackagesGcm;
	
	@FindBy(xpath="//span[@class = 'Select-value-label']")
	WebElement numOfPassengers;
	
	@FindBy(xpath="//input[@placeholder = 'Your name']")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@placeholder = 'Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	
	@FindBy(xpath="//input[@placeholder = 'Email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@placeholder = 'Mobile Number']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name = 'itinerary_name']")
	WebElement itineraryName;
	
	@FindBy(xpath=("(//div[@id='itinerary_page']//*/button[contains(text(),'Get trip cost')])[1] | (//div[@id='itinerary_page']//*/button[contains(text(),'Get latest cost')])[1] | //div[text()='View Trip Cost'] | //button[text()='Unlock price'] | //button[contains(text(),'Check availability')]"))
	WebElement calculateTripCostButton;
	
	@FindBy(xpath="//li[contains(text(),'Chennai, IN')]")
	WebElement departingFromChennai;
	
	@FindBy(xpath="//button[contains(text(),'Outside India')]")
	WebElement departingOutsideindia;
	
	@FindBy(xpath="//*[contains(text(),'Coimbatore')]")
	WebElement departingFromCoimbatore;
	
	@FindBy(xpath="//div[contains(@class,'react-datepicker__input-container')]")
	WebElement datepickerContainer;
	
	@FindBy(xpath = "//button[contains(text(),‘Book your trip’)]")
    private WebElement costingDelay;
	
	
	@FindBy(xpath = "//button[contains(text(),'Couple')]")
	WebElement passengerDetails;
	
	@FindBy(xpath="//button[contains(text(),'Solo')]")
	WebElement passengerDetailsSolo;
	
	@FindBy(xpath = "//button[contains(@class,'get-cost')] | //div[contains(text(),'View Trip Cost')] | //div[contains(text(),'total trip cost')] | //div[contains(text(),'View trip cost')]")
	WebElement gcmGetCost;
	
	@FindBy(xpath="//button[contains(@class,'update-cost')]")
	WebElement gcmUpdateCost;
	
	@FindBy(xpath="//span[text()='BLR']")
	WebElement DepartureCityBang;
	
	@FindBy(xpath="//label[contains(@class,'custom-options')]/i")
	WebElement arrivalCityCheckBox;
	
	@FindBy(xpath="//input[@placeholder='Arriving to']")
	WebElement arrivalCity;
	
	@FindBy(xpath="(//p[contains(@class,'UserIntent')])[3]")
	WebElement maldivesUserIntent;
	
	@FindBy(xpath="//*[contains(text(),'Bengaluru')]")
	WebElement departingFromBengaluru;
	

	@FindBy(xpath="//ul[contains(@class,'CalendarPicker__DateWrapper')]//li[@class='active'] | //div[contains(@class,'mobile-datepicker')]//li[@class='active'] | //p[contains(@class,'month-title')]/../ul//li[@class='active']")
	WebElement departurecalendarpicker;
	
	@FindBy(xpath="//div[contains(text(),'View trip cost')] | //div[contains(text(),'Continue')] | //div[contains(text(),'View Trip Cost')]")
	WebElement  viewTripCost;
	
	@FindBy(xpath="//div[contains(text(),'Edit Details')]")
	WebElement  packEditTrip;
	
	@FindBy(xpath="//section[contains(text(),'Couple')]")
	WebElement paxConfig;
	
	@FindBy(xpath="//section[text()='4 Nights']")
	WebElement nights;
	
	public WebElement getnights() {
		return nights;
	}

	public WebElement getPaxConfig() {
		return paxConfig;
	}

	
	public WebElement getPackEditTrip() {
		return packEditTrip;
	}

	
	public WebElement getViewTripCost() {
		return viewTripCost;
	}

	public WebElement getDeparturecalendarpicker() {
		return departurecalendarpicker;
	}

	public WebElement getDepatureCityPackagesGcm() {
		return depatureCityPackagesGcm;
	}
	
	public WebElement getDepartureDate() {
		return departureDate;
	}
	
	public WebElement getPassengerDetailsSolo() {
		return passengerDetailsSolo;
	}
	
	public WebElement getmaldivesUserIntent() {
		return maldivesUserIntent;
	}
	
	public WebElement getdepartingFromBengaluru() {
		return departingFromCoimbatore;
	}
	
	public WebElement getArrivalCity() {
		return arrivalCity;
		 }
	
	public WebElement getArrivalCityCheckBox() {
		return arrivalCityCheckBox;
		 }
	
	public WebElement getGcmUpdateCost() {
		return gcmUpdateCost;
		 }
	
	public WebElement getGetCostContinue() {
		return gcmGetCost;
		 }
	
	
	public WebElement getTravellingPassengersType() {
		return passengerDetails;
		 }
		    
    public WebElement getCostingDelay() {
	return costingDelay;
	 }
	
	public WebElement getdatepickerContainer() {
		return datepickerContainer;
	}
	
	public WebElement getdepartingFromCoimbatore() {
		return departingFromCoimbatore;
	}
	
	public WebElement getdepartingOutsideindia() {
		return departingOutsideindia;
	}
	
	public WebElement getdepartingFromChennai() {
		return departingFromChennai;
	}

	public WebElement getcalculateTripCostButton() {
		return calculateTripCostButton;
	}
	public WebElement getTripCostButton() {
		return TripCostButton;
	}

	public WebElement getDepartingCity() {
		return departingCity;
	}

	public WebElement getDepartingOnCitydate() {
		return departingOnCitydate;
	}
	
	public WebElement getDepartingOnCitydate20() {
		return departingOnCitydate20;
	}
	
	public WebElement getDepartingOnCurrentDate() {
		return departingOnCurrentDate;
	}

	public WebElement getDatePicker() {
		return datePicker;
	}

	public WebElement getNumOfPassengers() {
		return numOfPassengers;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getItineraryName() {
		return itineraryName;
	}
	
	public WebElement getLogin() {
		return login;
	}
	
	
	public WebElement getPasssword() {
		return password;
	}
	
	public WebElement getArrivalOn() {
		return arrivalOn;
	}
	public WebElement getgetCostinGCM() {
        return getCostinGCM;
    }

}
