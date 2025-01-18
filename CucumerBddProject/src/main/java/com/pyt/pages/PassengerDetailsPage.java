package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassengerDetailsPage {
	
	//Book your trip button in the inclusions page 
	
	@FindBy(xpath="//button[@class='n-tracker-bookyourtrip btn btn-primary']")
	private WebElement bookYourTrip;

	//login
	
	public WebElement getBookYourTrip() {
		return bookYourTrip;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogIn() {
		return logIn;
	}

	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement logIn;

//Room 1 and adult-1 
	
	@FindBy(xpath="((//input[@name='salutation_0_0'])//following::i)[1]")
	private WebElement adult1SalutationMr;
	
	@FindBy(xpath="((//input[@name='salutation_0_0'])//following::i)[2]")
	private WebElement adult1SalutationMs;
	
	@FindBy(xpath="//input[@name='firstName_0_0']")
	private WebElement adult1FirstName ;
	
	@FindBy(xpath="//input[@name='lastName_0_0']")
	private WebElement adult1LastName;
	
	@FindBy(xpath="//input[@name='passportNumber_0_0']")
	private WebElement adult1PassportNumber;
	
	@FindBy(xpath="//input[@name='passportExpirationDate_0_0']")
	private WebElement adult1PassportExpirationDate;
	
	@FindBy(xpath="//input[@name='birthDay_0_0']")
	private WebElement adult1BirthDay;
	
	//Check live price button
	
	@FindBy(xpath="//span[@class='btn-txt'] | //form[@id='booking-travellers']/section//following::span")
	private WebElement reviewLiveCost;
	
	@FindBy(xpath="//div[contains(@class,'progress-pill')]")
	private WebElement livePriceLoading;
	
	@FindBy(xpath="//span[@class='caps-text-tiny bold color-grey']")
	private WebElement totalCostText;
	
	//use this element to find no of cards in the live price screen
	@FindBy(xpath="//div[@class='clearfix review-table']//a")
	private WebElement livePriceCardCount;
	
	//Show more button in the live price screen to expand the line item cards
	@FindBy(xpath="//button[contains(@class,'btn accord-btn collapsed')]")
	private WebElement showMoreButtonInLivePrice;
	
	@FindBy(xpath="//a[contains(text(),'Next, make payment ')]")
	private WebElement makePaymentLivePrice;
	
	public WebElement getMakePaymentLivePrice() {
		return makePaymentLivePrice;
	}

	public WebElement getShowMoreButtonInLivePrice() {
		return showMoreButtonInLivePrice;
	}

	public WebElement getLivePriceCardCount() {
		return livePriceCardCount;
	}

	public WebElement getTotalCostText() {
		return totalCostText;
	}

	public WebElement getLivePriceLoading() {
		return livePriceLoading;
	}
	
	//Room-1 and adult-2

	@FindBy(xpath="((//input[@name='salutation_0_1'])//following::i)[1]")
	private WebElement adult2SalutationMr;
	
	@FindBy(xpath="((//input[@name='salutation_0_1'])//following::i)[2]")
    private WebElement adult2SalutationMs;
	
	@FindBy(xpath="//input[@name='firstName_0_1']")
	private WebElement adult2FirstName;
	
	@FindBy(xpath="//input[@name='lastName_0_1']")
	private WebElement adult2LastName;
	
	@FindBy(xpath="//input[@name='passportNumber_0_1']")
	private WebElement adult2PassportNumber;
	
	@FindBy(xpath="//input[@name='passportExpirationDate_0_1']")
	private WebElement adult2PassportExpirationDate;
	
	@FindBy(xpath="//input[@name='birthDay_0_1']")
	private WebElement adult2BirthDay;
	
	
	@FindBy(xpath="//div[@class='btn-group meals-options ']/button/i[@class='veg-icon veg']")
	private WebElement meal;
	
	@FindBy(xpath = "//a[contains(text(),'Apply')]")
	private WebElement applyCoupon;

	@FindBy(xpath = "//input[1]")
	private WebElement enterCoupon;

	@FindBy(xpath = "//strong[starts-with(@class,'color-grey')]")
	private WebElement totalCost;

	@FindBy(xpath = "//button[contains(text(),'Apply Code')]")
	private WebElement applyCode;
	
	@FindBy(xpath="//i[contains(@class,'pyt-offer')]")
	private WebElement applydiscount;
	
	@FindBy(xpath="//input[@placeholder='Enter coupon code']")
	private WebElement entercouponcode;
	
	@FindBy(xpath="//a[contains(text(),'Apply')]")
	private WebElement apply;
	
	@FindBy(xpath="//li[contains(@class,'back-link')]")
	private WebElement backlink;
	
//	((//div[contains(@class,'DealsStyles__CouponBlock')])[2]//span)[1]
	@FindBy(xpath="//span[contains(@class,'DealsStyles__LoyaltyCreditPointsPill')]")
	private WebElement applyLoyality;
	
	@FindBy(xpath="//div[contains(@class,'DealsStyles__CouponBlock')]//input[@placeholder='Number of credits']")
	private WebElement enterLoyalityCredity;
	
	@FindBy(xpath="(//a[contains(text(),'Back to itinerary')])[2]")
	private WebElement livePriceBacktoItinerarybtn;
	
	
	@FindBy(xpath="//i[contains(@class,'pyt-exclamation')]")
	private WebElement pytExclamation;
	
	public WebElement getPytExclamation() {
		return pytExclamation;
	}

	public WebElement getLivePriceBacktoItinerarybtn() {
		return livePriceBacktoItinerarybtn;
	}
	
	
	public WebElement getEnterLoyality() {
		return enterLoyalityCredity;
	}
	
	public WebElement getApplyLoyality() {
		return applyLoyality;
	}
	
	public WebElement getBackLink() {
		return backlink;
	}
	
	public WebElement getApply() {
		return apply;
	}
	
	public WebElement getEntercouponcode() {
		return entercouponcode;
	}
	
	public WebElement getApplydiscount() {
		return applydiscount;
	}
	
	
	
	public WebElement getMeal() {
		return meal;
	}

	//Getters for Login and booktrip button

	public WebElement getbookYourTrip() {
		return bookYourTrip;
	}

	public WebElement getmobileNumber() {
		return mobileNumber;
	}

	public WebElement getpassWord() {
		return passWord;
	}

	public WebElement getlogIn() {
		return logIn;
	}
	
	//Getters for Room-1 and adult-1
	
	public WebElement getadult1SalutationMr() {
		return adult1SalutationMr;
	}

	public WebElement getadult1SalutationMs() {
		return adult1SalutationMs;
	}

	public WebElement getadult1FirstName() {
		return adult1FirstName;
	}
	
	public WebElement getadult1LastName() {
		return adult1LastName;
	}
	
	public WebElement getAdult1PassportNumber() {
		return adult1PassportNumber;
	}

	public WebElement getAdult1PassportExpirationDate() {
		return adult1PassportExpirationDate;
	}

	public WebElement getAdult1BirthDay() {
		return adult1BirthDay;
	}
	
    public WebElement getreviewLiveCost() {
		return reviewLiveCost;
	}
	
  //Getters for Room-1 and adult-2
    
    public WebElement getAdult2SalutationMr() {
		return adult2SalutationMr;
	}

	public WebElement getAdult2SalutationMs() {
		return adult2SalutationMs;
	}

	public WebElement getAdult2FirstName() {
		return adult2FirstName;
	}

	public WebElement getAdult2LastName() {
		return adult2LastName;
	}

	public WebElement getAdult2PassportNumber() {
		return adult2PassportNumber;
	}

	public WebElement getAdult2PassportExpirationDate() {
		return adult2PassportExpirationDate;
	}

	public WebElement getAdult2BirthDay() {
		return adult2BirthDay;
	}
   
	public WebElement getApplyCoupon() {
		return applyCoupon;
	}

	public WebElement getEnterCoupon() {
		return enterCoupon;
	}

	public WebElement getTotalCost() {
		return totalCost;
	}

	public WebElement getApplyCode() {
		return applyCode;
	}

}
