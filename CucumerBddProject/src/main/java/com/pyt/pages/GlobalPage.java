package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GlobalPage  {

	@FindBy(xpath = "//ul[@data-orientation='horizontal']/li[6]")
	WebElement globalicon;
	
	@FindBys(@FindBy(xpath = "(//a[contains(text(),'United Arab Emirates')])[2]//parent::div/parent::ul"))
	List<WebElement> globalDropdownList;
	
	@FindBy(xpath = "//section[contains(@class,'DesktopCards__RootWrapper')]//strong")
	WebElement	currencyonhomepagecards;
	
	@FindBy(xpath="//label[text()='Nationality']/../input")
	WebElement nationalityDropDownGlobal;
	
	@FindBy(xpath="//div[contains(@class,'CountryConfirmationDialog')]")
	WebElement globalCountryConfirmationPopup;
	
	@FindBy(xpath="//div[contains(@class,'CountryConfirmationDialog')]//button[contains(text(),'United States')]")
	WebElement globalPopUpUsButton;
	
	@FindBy(xpath="//div[contains(@class,'CountryConfirmationDialog')]//button[contains(text(),'India')]")
	WebElement globalPopUpIndiaButton;
	
	@FindBy(xpath="//div[contains(@class,'CountryConfirmationDialog')]//button[contains(text(),'UAE')]")
    WebElement globalPopUpUaeButton;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter Email')]")
    WebElement globalUserName;
	
	@FindBy(xpath="//input[contains(@class,'country-code')]")
    WebElement globalCountryCode;
	
	@FindBy(xpath="//span[contains(text(),'Invalid username or password')]")
    WebElement globalIncorrectCredentials;
	
	@FindBy(xpath="//span[text()='Enter your valid mobile number']")
    WebElement globalIncorrectUsername;
	
	@FindBy(xpath="//span[text()='Registered mobile number is not valid']")
    WebElement globalInvalidUsername;
	
	@FindBy(xpath="//button[contains(@class,'pull-right')]")
    WebElement globalCloseLoginScreen;
	
	@FindBy(xpath="//span[text()='Forgot password?']")
    WebElement globalForgotPwd;
	
	@FindBy(xpath="//button[text()='Get OTP']")
    WebElement globalGetOtp;
	
	@FindBy(xpath="//span[text()='Enter your registered mobile number and click Get OTP']")
    WebElement invalidMobileNoInOtpScreen;
	
	@FindBy(xpath="//button[normalize-space()='View Price']")
    WebElement viewPrice;
	
	@FindBy(xpath="(//input[@id='name'])[1]")
    WebElement leadPassengerName;
	
	@FindBy(xpath="(//input[@id='name'])[4]")
    WebElement leadPassengerEmailId;
	
	@FindBy(xpath="(//input[@id='name'])[5]")
    WebElement leadPassengerCountryCode;
	
	@FindBy(xpath="(//input[@id='name'])[6]")
    WebElement leadPassengerMobileNo;
	
	@FindBy(xpath="//input[@name='mobileNumber']")
    WebElement leadPassengerMobileNoInLogin;
	
	@FindBy(xpath="//input[@type='password']")
    WebElement leadPassengerPasswordInLogin;
	
	@FindBy(xpath="//span[text()='Login']")
    WebElement leadPassengerLogin;
	
	@FindBy(xpath="//span[text()='Get Cost']")
    WebElement leadPassengerGetCost;
	
	@FindBy(xpath="//span[text()='All Inclusive']/../div/span")
    WebElement globalInclusionsCost;
	
	@FindBy(xpath="//span[contains(text(),'Your password was recently changed')] | //span[contains(text(),'Invalid username or password')]")
    WebElement globalPasswordError;
	
	@FindBy(xpath="//img[@test='packages/singapore']")
    WebElement singaporePackagesUnderTrendingDestinations;
	
	@FindBy(xpath="(//img[@test='packages/maldives'])[2]")
    WebElement maldivesPackagesUnderLongWeeked;
	
	@FindBy(xpath="//img[@test='packages/mauritius']")
    WebElement mauritiusPackagesUnderVisaOnArrival;
	
	@FindBy(xpath="//img[contains(@alt,'packages/vietnam')]")
    WebElement vietnamPackagesUnderQuickGetAway;
	
	@FindBy(xpath="//img[contains(@alt,'themed-media-cards-packages/greece')]")
    WebElement greecePackagesUnderEuropeanHolidays;
	
	@FindBy(xpath="(//img[@alt='themed-media-cards-packages/singapore'])[2]")
    WebElement singaporeUnderSouthAsianVacations;
	
	public WebElement getSingaporePackagesUnderTrendingDestinations() {
		return singaporePackagesUnderTrendingDestinations;
	}

	public WebElement getMaldivesPackagesUnderLongWeeked() {
		return maldivesPackagesUnderLongWeeked;
	}

	public WebElement getMauritiusPackagesUnderVisaOnArrival() {
		return mauritiusPackagesUnderVisaOnArrival;
	}

	public WebElement getVietnamPackagesUnderQuickGetAway() {
		return vietnamPackagesUnderQuickGetAway;
	}

	public WebElement getGreecePackagesUnderEuropeanHolidays() {
		return greecePackagesUnderEuropeanHolidays;
	}

	public WebElement getSingaporeUnderSouthAsianVacations() {
		return singaporeUnderSouthAsianVacations;
	}
	
	public WebElement getGlobalPasswordError() {
		return globalPasswordError;
	}

	public WebElement getGlobalInclusionsCost() {
		return globalInclusionsCost;
	}

	public WebElement getLeadPassengerGetCost() {
		return leadPassengerGetCost;
	}

	public WebElement getViewPrice() {
		return viewPrice;
	}

	public WebElement getLeadPassengerName() {
		return leadPassengerName;
	}

	public WebElement getLeadPassengerEmailId() {
		return leadPassengerEmailId;
	}

	public WebElement getLeadPassengerCountryCode() {
		return leadPassengerCountryCode;
	}

	public WebElement getLeadPassengerMobileNo() {
		return leadPassengerMobileNo;
	}

	public WebElement getLeadPassengerMobileNoInLogin() {
		return leadPassengerMobileNoInLogin;
	}

	public WebElement getLeadPassengerPasswordInLogin() {
		return leadPassengerPasswordInLogin;
	}

	public WebElement getLeadPassengerLogin() {
		return leadPassengerLogin;
	}
	
	public WebElement getGlobalForgotPwd() {
		return globalForgotPwd;
	}

	public WebElement getGlobalGetOtp() {
		return globalGetOtp;
	}

	public WebElement getInvalidMobileNoInOtpScreen() {
		return invalidMobileNoInOtpScreen;
	}

	public WebElement getGlobalCloseLoginScreen() {
		return globalCloseLoginScreen;
	}

	public WebElement getGlobalInvalidUsername() {
		return globalInvalidUsername;
	}

	public WebElement getGlobalIncorrectUsername() {
		return globalIncorrectUsername;
	}

	public WebElement getGlobalIncorrectCredentials() {
		return globalIncorrectCredentials;
	}

	public WebElement getGlobalCountryCode() {
		return globalCountryCode;
	}

	public WebElement getGlobalUserName() {
		return globalUserName;
	}

	public WebElement getGlobalPassword() {
		return globalPassword;
	}

	public WebElement getGlobalLoginButton() {
		return globalLoginButton;
	}

	@FindBy(xpath="//input[@placeholder='Password']")
    WebElement globalPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement globalLoginButton;
	
	
	public WebElement getGlobalPopUpUaeButton() {
		return globalPopUpUaeButton;
	}

	public WebElement getGlobalPopUpUsButton() {
		return globalPopUpUsButton;
	}
	
	public WebElement getGlobalPopUpIndiaButton() {
		return globalPopUpIndiaButton;
	}

	public WebElement getGlobalCountryConfirmationPopup() {
		return globalCountryConfirmationPopup;
	}

	public WebElement getNationalityDropDownGlobal() {
		return nationalityDropDownGlobal;
	}

	public WebElement getGlobalIcon() {
		return globalicon;
	}

	public List<WebElement> getGlobalDropdownList() {
		return globalDropdownList;
	}

	public WebElement getCurrencyOnHomePageCards() {
		return currencyonhomepagecards;
	}

}









