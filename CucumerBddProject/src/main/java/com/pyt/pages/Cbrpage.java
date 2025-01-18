package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cbrpage {

	@FindBy(xpath="//button[contains(@class,'PackagesStyles__WAButton')]")
	WebElement packagesCbr;

	@FindBy(xpath="//button[contains(text(),'Talk to us')]")
	WebElement homePageCbr;
	
	@FindBy(xpath="//*[text()='Share Details']")
	WebElement vacationsCbr;
	
	@FindBy(xpath="//input[@placeholder='Your name']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	WebElement phonenumber;
	
	//Email
	@FindBy(xpath="//input[@placeholder='Email'] | //input[@placeholder='Email address']")
	WebElement email;
	
	//Preferred Time 
	@FindBy(xpath="//select[@name='preferredTime']")
	WebElement preferredTime;
	
	@FindBy(xpath="//input[@id='preferredRegion']")
	WebElement preferredRegion;
	
	@FindBy(xpath="//span[text()='Bali']")
	WebElement regionBali;
	
	//CBR submit button
	@FindBy(xpath="//button[contains(text(),'Request callback')] | //button[text()='Get best quotes'] | (//span[text()='Request Callback'])[last()]")
	WebElement cBrSubmitButton;
	
	@FindBy(xpath="//h5[@class='medium-heading bold fade mbottom-small']")
	WebElement successfulCBRPackage;
	
	@FindBy(xpath="//button[@class='btn btn-link no-padding']")
	WebElement keepBrowsing;
	
	@FindBy(xpath = "//a[@class='logo n-tracker-pytlogo'] | //div[@class='logo-mark']")
	WebElement pytLogo;
	
	@FindBy(xpath="//div[@class='col-md-12 logo-img']//span//img")
	WebElement vacationsPytLogo;

	@FindBy(xpath="//a[@class='logo n-tracker-pytlogo']//img")
	WebElement packagesPytLogo;
	
	@FindBy(xpath="//h3[@class='bold mt-0 fade']")
	WebElement happyToHelp;
	
	@FindBy(xpath="//div[@class='right-col vertical-center']/a")
	WebElement firstPackage;
	
	@FindBy(xpath="//input[@placeholder='Departing from']")
	WebElement departingFrom;
	
	@FindBy(xpath="//a[text()='Chennai, IN']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='departure-date-get-cost']")
	WebElement departureDate;

	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--wed react-datepicker__day--selected']")
	WebElement currentDate;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block tracker-get-cost-modal-update-cost']")
	WebElement getCost;
	
	@FindBy(xpath="//p[contains(text(),'Got a question? Talk to us!')]")
	WebElement inclusionTravelCons;
	
	//a[contains(text(),'Talk to our travel')]
	@FindBy(xpath="//button[contains(text(),'Talk to us')] | //span[contains(text(),'Talk to an Expert')] | //button[contains(text(),'Talk to an Expert')]")
	WebElement itineraryTravelCons;
	
	//Text message in the alert 
	@FindBy(xpath="//p[contains(text(),'An account with the given credentials already')]")
	WebElement alertMsgCbrExisting;
	
	//Text message in the vacation page alert 
		@FindBy(xpath="//*[text()='Thanks! We will call you within 48 hours.']")
		WebElement alertMsgVactionCbr;
		
	//Ok button in the Alert message user trying to submit CBR with existing credential
	@FindBy(xpath="//button[@class='confirm']")
	WebElement okButtonInAlert;
	
	//Close button in CBR modal
	@FindBy(xpath="(//i[contains(@class,'pyt-close')])[2]")
	WebElement closeCbrModal;
	
	//CBR from inclusions page
	@FindBy(xpath="//i[contains(@class,'pyt-phone')]")
	WebElement cbrFromInclusions;
	
	@FindBy(xpath="//*[text()='As Seen On']")
	WebElement customerStories;
	
	@FindBy(xpath="//*[text()='Nah, keep browsing']")
	WebElement cbrCloseVacations;
	
	@FindBy(xpath="//div[contains(@class,'minimize')]")
	WebElement packagesChatClose;
	
	@FindBy(xpath="(//span[contains(text(),'Request')])[1]")
	WebElement requestCallbackCTA;
	
	@FindBy(xpath="(//span[text()='Request call back'])[2]")
	WebElement mlerequestCallbackCTA;
	
	@FindBy(xpath="//span[contains(text(),'We have received your details.')]")
	WebElement CBRSuccessfullmsg;
	
	@FindBy(xpath="//span[contains(text(),'Our travel experts will get in touch with you shortly!')]")
	WebElement TravelExpertsmsg;
	
	@FindBy(xpath="//button[text()='Okay, Got it!']")
	WebElement okaygotIt;
	
	@FindBy(xpath="//span[text()='request callback']")
	WebElement requestCallback;
	
	@FindBy(xpath="(//span[text()='Request Callback'])[2]")
	WebElement destinationRequestCallback;
	
	@FindBy(xpath="//span[contains(text(),'Our travel experts will get in touch with you within 24 hours!')]")
	WebElement destinationTravelExpertsmsg;
	
	@FindBy(xpath="//button[text()='Enquire Now']")
	WebElement enquireNow;
	
	@FindBy(xpath="//button[text()='Get best quotes']")
	WebElement getBestQuotes;
	
	@FindBy(xpath="(//input[@id='name'])[last()]")
	WebElement cbrName;
	
	@FindBy(xpath=" (//input[@id='name'])[1]")
	WebElement cbrNameSpeedboat;
	
	@FindBy(xpath="(//input[@id='name'])[2]")
	WebElement destinationCbrName;
	
	@FindBy(xpath="(//input[@id='mobileNumber'])[2]")
	WebElement destinationCbrMobile;
	
	@FindBy(xpath="(//input[@id='email'])[2]")
	WebElement destinationCbrEmail;
	
	@FindBy(xpath="(//input[@id='name'])[1]")
	WebElement mleCbrName;
	
	@FindBy(xpath="(//input[@id='mobileNumber'])[last()]")
	WebElement cbrMobile;
	
	@FindBy(xpath="//input[@type='number'] | //input[@id='mobileNumber']")
	WebElement cbrMobileSpeedboat;
	
	@FindBy(xpath="//input[@id='name'and @type='number']")
	WebElement mlecbrMobile;
	
	@FindBy(xpath="(//input[@id='email'])[last()]")
	WebElement cbrEmail;
	
	@FindBy(xpath="//input[@id='email']" )
	WebElement cbrEmailSpeedboat;
	
	@FindBy(xpath="(//input[@id='name'])[4]")
	WebElement mleCbrEmail;

	@FindBy(xpath="//button[text()='Place Request'] | //button[text()='Get best quotes']")
	WebElement placeRequest;
	
	@FindBy(xpath="//span[contains(text(),'An account with the given credentials already exists please login or provide different credentials to continue')]")
	WebElement oopsError;
	
	public WebElement getCbrEmailSpeedboat() {
		return cbrEmailSpeedboat;
	}
	
	public WebElement getCbrMobileSpeedboat() {
		return cbrMobileSpeedboat;
	}
	
	public WebElement getCbrNameSpeedboat() {
		return cbrNameSpeedboat;
	}

	
	public WebElement getDestinationcbrName() {
		return destinationCbrName;
	}

	public WebElement getDestinationcbrMobile() {
		return destinationCbrMobile;
	}

	public WebElement getDestinationcbrEmail() {
		return destinationCbrEmail;
	}
	
	public WebElement getPreferredRegion() {
		return preferredRegion;
	}

	public WebElement getRegionBali() {
		return regionBali;
	}
	
	public WebElement getMlecbrName() {
		return mleCbrName;
	}

	public WebElement getMlecbrMobile() {
		return mlecbrMobile;
	}

	public WebElement getMlecbrEmail() {
		return mleCbrEmail;
	}
	
	
	public WebElement getOopsError() {
		return oopsError;
	}

	public WebElement getCbrName() {
		return cbrName;
	}

	public WebElement getCbrMobile() {
		return cbrMobile;
	}

	public WebElement getCbrEmail() {
		return cbrEmail;
	}

	public WebElement getPlaceRequest() {
		return placeRequest;
	}

	public WebElement getEnquireNow() {
		return enquireNow;
	}

	public WebElement getGetBestQuotes() {
		return getBestQuotes;
	}

	public WebElement getDestinationTravelExpertsmsg() {
		return destinationTravelExpertsmsg;
	}

	public WebElement getDestinationrequestCallback() {
		return destinationRequestCallback;
	}

	public WebElement getMlerequestCallbackCTA() {
		return mlerequestCallbackCTA;
	}

	public WebElement getRequestCallback() {
		return requestCallback;
	}

	public WebElement getRequestCallbackCTA() {
		return requestCallbackCTA;
	}
	
	public WebElement getCBRSuccessfullmsg() {
		return CBRSuccessfullmsg;
	}

	public WebElement getTravelExpertsmsg() {
		return TravelExpertsmsg;
	}

	public WebElement getOkaygotIt() {
		return okaygotIt;
	}

	public WebElement getPackagesChatClose() {
		return packagesChatClose;
	}
	
	public WebElement getCbrFromInclusions() {
		return cbrFromInclusions;
	}

	public WebElement getAlertMsgCbrExisting() {
		return alertMsgCbrExisting;
	}

	public WebElement getOkButtonInAlert() {
		return okButtonInAlert;
	}

	public WebElement getCloseCbrModal() {
		return closeCbrModal;
	}
	
	
	public WebElement getItineraryTravelCons() {
		return itineraryTravelCons;
	}

	public WebElement getTravelConsultant() {
		return inclusionTravelCons;
	}

	public WebElement getGetCost() {
		return getCost;
	}

	public WebElement getCurrentDate() {
		return currentDate;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}
	
	public WebElement getCity() {
		return city;
	}

	public WebElement getDepartingFrom() {
		return departingFrom;
	}

	public WebElement getFirstPackage() {
		return firstPackage;
	}

	public WebElement getHappyToHelp() {
		return happyToHelp;
	}

	public WebElement getVacationsPytLogo() {
		return vacationsPytLogo;
	}

	public WebElement getPytLogo() {
		return pytLogo;
	}

	public WebElement getKeepBrowsing() {
		return keepBrowsing;
	}

	public WebElement getSuccessfulCBRPackage() {
		return successfulCBRPackage;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPreferredTime() {
		return preferredTime;
	}
	
	public WebElement getPackagesCbr() {
		return packagesCbr;
	}

	public WebElement getHomePageCbr() {
		return homePageCbr;
	}

	public WebElement getcBrSubmitButton() {
		return cBrSubmitButton;
	}

	public WebElement getPackagesPytLogo() {
		return packagesPytLogo;
	}

	public WebElement getCustomerStory() {
		return customerStories;
	}
	
	public WebElement getVacationsCbr() {
		return vacationsCbr;
	}
	
	public WebElement getVactionCbrAlertMsg() {
		return alertMsgVactionCbr;
	}
	public WebElement getCbrCloseVacations() {
		return cbrCloseVacations;
	}
	
}
