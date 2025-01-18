package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PackagesPage {

//Packages Dropdown
	@FindBy(xpath = "//*[text()='Destinations']")
	WebElement packagesPageCityDropdown;

//Themes Dropdown

	@FindBy(xpath = "//*[text()='Interests']")
	WebElement packagesPageThemesDropdown;

//Themes options 

//Newly Weds

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='For the Newly weds']")
	WebElement packagesPageNewlyWeds;

//Family Specials

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Family Specials']")
	WebElement packagesPageFamilySpecials;

	@FindBy(xpath = "//*[@id='packagesContent']/div/section[2]/div[3]/a")
	WebElement selectedFamilyPkg;

	// *[@id="packagesContent"]/div/section[1]/div[3]/a

//Beach Lovers

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Beach Lovers']")
	WebElement packagesPageBeachLovers;

//adventure-packages

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Adrenaline Junkies']")
	WebElement packagesPageAdrenalineJunkies;

//visa-on-arrival-packages

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Visa on arrival']")
	WebElement packagesPageVisaonArrival;

//Destinations Options 

//City Destinarion -- Europe 
	@FindBy(xpath = "//li[@class='tracker-pkg-destination']//input[@value='europe']//following-sibling::span[1]")
	WebElement packagesPageCityEurope;

//City Destinarion -- Australia 
	@FindBy(xpath = "//li[@class='tracker-pkg-destination']//input[@value='australia']")
	WebElement packagesPageCityAustralia;

//City Destinarion -- New - Zealand 
	@FindBy(xpath = "//li[@class='tracker-pkg-destination']//input[@value='new-zealand']")
	WebElement packagesPageCityNweZealand;

//Aus paid campaign package choice
	@FindBy(xpath = "//a[@class='btn btn-primary tracker-campaign-custombtn']")
	WebElement auspaidpkg;

	@FindBy(xpath = "//section[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]")
	WebElement firstPackage;

	@FindBy(xpath = "//button[text()='Get Cost']")
	WebElement PackageGetCost;

	@FindBy(xpath = "//button[contains(text(),'Get trip cost')] | //button[text()='View Price']")
	WebElement packageGettripcost;

	@FindBy(xpath = "(//a[@class='btn btn-primary tracker-campaign-custombtn'])[1]")
	WebElement customizeButton;

	@FindBy(xpath = "(//button[text()='Create your personalised itinerary'])[1]")
	WebElement pdgFlowLinkFromPackage;

	@FindBy(xpath = "//img[contains(@alt,'PickYourTrail.com')]")
	WebElement vacationPagePytLogo;

	@FindBy(xpath = "//div[@id='faq']")
	WebElement faqSectionVacations;

	@FindBy(xpath = "//*[@class='trust-footer']")
	WebElement trustFooterInPackageVacations;

	@FindBy(xpath = "//button[contains(text(),'Customise')][1] | //div[contains(text(),'Customise')][1] | (//button[text()='View Deal'])[1]")
	WebElement customizeCta;

	@FindBy(xpath = "//a[contains(text(),'Customize')][1]")
	WebElement vacationsCustomizeCta;

	@FindBy(xpath = "(//div[@id='packages-cards']//a[contains(@href,'/packages')])[1]")
	WebElement packageTitle;

	@FindBy(xpath = "//section[@name='day-by-day']")
	WebElement daybydayPlan;

	@FindBy(xpath = "//p[contains(text(),'Packages')]")
	WebElement landingPagePackages;

	@FindBy(xpath = "//a[@href='packages/dubai']")
	WebElement dubaiPackages;

	@FindBy(xpath = "//a[@href='packages/thailand']")
	WebElement thailandPackages;

	@FindBy(xpath = "//a[@href='packages/turkey']")
	WebElement turkeyPackages;

	@FindBy(xpath = "//a[@href='packages/greece']")
	WebElement greecePackages;

	@FindBy(xpath = "//a[@href='packages/maldives']")
	WebElement maldivesPackages;

	@FindBy(xpath = "//button[text()='View all packages']")
	WebElement viewAllPackages;

	@FindBy(xpath = "(//span[contains(text(),'View')])[1]")
	WebElement firstPackageCustomize;

	@FindBy(xpath = "(//div[@id='packagesContent']//a)[1] | (//div[@id='packages-cards']//a)[1]")
	WebElement firstPackageSlug;

	@FindBy(xpath = "(//button[contains(text(),'Send Enquiry')])[1]")
	WebElement firstPackageSendEnquiry;

	@FindBy(xpath = "//span[contains(text(),'Search your favourite destination')]")
	WebElement packagesSearchTextbox;

	@FindBy(xpath = "(//button[text()='Login'])[2]")
	WebElement loginButton;

	@FindBy(xpath = "(//button[text()='View Deal'])[1] | (//span[text()='View Details'])[last()] | (//button[contains(text(),'Check availability')])[1] | (//span[text()='Unlock Deal'])[1] | //button[text()='View Details'])[1]")
	WebElement viewdealbutton;

	@FindBy(xpath = "//input[@type='number'] | //input[@placeholder='Enter your mobile number']")
	WebElement entermobileno;

//	@FindBy(xpath = "(//input[@id='name' and contains(@class,'atom-web-c-wyZRQ-ieCiLPC-css')])[1] | //input[contains(@placeholder,'Name')]")
	@FindBy(xpath = "//input[contains(@placeholder,'Enter Name')]")
	WebElement entername;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continuebutton;

	@FindBy(xpath = "//span[text()='Enter OTP']/../../*[name()='svg'] | //span[text()='Enter OTP']/../..//button//*[name()='svg']")
	WebElement closeotpbutton;

	@FindBy(xpath = "(//button[text()='No'])[1]")
	WebElement nobutton;

	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	WebElement yesbutton;

	@FindBy(xpath = "(//button[contains(text(),'Check availability')])[1]")
	WebElement checkAvailabiltyCTA;
	
	@FindBy(xpath = "(//div[@role='dialog']//*[name()='svg'])[4]")
	WebElement closeButton;
	
	@FindBy(xpath = "(//button[contains(text(),'View')])[1] | (//button[text()='View Deal'])[2] | (//span[text()='View Details'])[1] | (//button[text()='View Deal'])[1] | (//button[contains(text(),'Check availability')])[1]  | (//div[@id='packages-cards']//span[text()='View Details'])[1]")
	WebElement firstViewdealbutton;

	public WebElement getFirstViewdealbutton() {
		return firstViewdealbutton;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getCheckAvailabiltyCTA() {
		return checkAvailabiltyCTA;
	}

	public WebElement getpackageGettripcost() {
		return packageGettripcost;
	}

	public WebElement getyesbutton() {
		return yesbutton;
	}

	public WebElement getnobutton() {
		return nobutton;
	}

	public WebElement getcloseotpbutton() {
		return closeotpbutton;
	}

	public WebElement getcontinuebutton() {
		return continuebutton;
	}

	public WebElement getentername() {
		return entername;
	}

	public WebElement getentermobileno() {
		return entermobileno;
	}

	public WebElement getviewdealbutton() {
		return viewdealbutton;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getPackagesSearchTextbox() {
		return packagesSearchTextbox;
	}

	public WebElement getfirstPackageSendEnquiry() {
		return firstPackageSendEnquiry;
	}

	public WebElement getfirstPackageSlug() {
		return firstPackageSlug;
	}

	public WebElement getfirstPackageCustomize() {
		return firstPackageCustomize;
	}

	public WebElement getViewAllPackages() {
		return viewAllPackages;
	}

	public WebElement getDubaiPackages() {
		return dubaiPackages;
	}

	public WebElement getthailandPackages() {
		return thailandPackages;
	}

	public WebElement getturkeyPackages() {
		return turkeyPackages;
	}

	public WebElement getgreecePackages() {
		return greecePackages;
	}

	public WebElement getmaldivesPackages() {
		return maldivesPackages;
	}

	public WebElement getLandingPagePackages() {
		return landingPagePackages;
	}

	public WebElement getDayByDayPlan() {
		return daybydayPlan;
	}

	public WebElement getPackageTitle() {
		return packageTitle;
	}

	public WebElement getVacationsCustomizeCta() {
		return vacationsCustomizeCta;
	}

	public WebElement getCustomizeCta() {
		return customizeCta;
	}

	public WebElement getTrustFooterInPackageVacations() {
		return trustFooterInPackageVacations;
	}

	public WebElement getFaqSectionVacations() {
		return faqSectionVacations;
	}

	public WebElement getPdgFlowLinkFromPackage() {
		return pdgFlowLinkFromPackage;
	}

	public WebElement getVacationPagePytLogo() {
		return vacationPagePytLogo;
	}

	public WebElement getCustomizeButton() {
		return customizeButton;
	}

	public WebElement getPackageGetCost() {
		return PackageGetCost;
	}

	public WebElement getFirstPackage() {
		return firstPackage;
	}

	public WebElement getCityDropdown() {
		return packagesPageCityDropdown;
	}

	public WebElement getCityEurope() {
		return packagesPageCityEurope;
	}

	public WebElement getPackagesPageCityDropdown() {
		return packagesPageCityDropdown;
	}

	public WebElement getPackagesPageThemesDropdown() {
		return packagesPageThemesDropdown;
	}

	public WebElement getPackagesPageNewlyWeds() {
		return packagesPageNewlyWeds;
	}

	public WebElement getPackagesPageFamilySpecials() {
		return packagesPageFamilySpecials;
	}

	public WebElement getPackagesPageBeachLovers() {
		return packagesPageBeachLovers;
	}

	public WebElement getPackagesPageAdrenalineJunkies() {
		return packagesPageAdrenalineJunkies;
	}

	public WebElement getPackagesPageVisaonArrival() {
		return packagesPageVisaonArrival;
	}

	public WebElement getPackagesPageCityEurope() {
		return packagesPageCityEurope;
	}

	public WebElement getPackagesPageCityAustralia() {
		return packagesPageCityAustralia;
	}

	public WebElement getPackagesPageCityNweZealand() {
		return packagesPageCityNweZealand;
	}

	public WebElement getFamilyVacationPackage() {
		return selectedFamilyPkg;
	}

	public WebElement getAusPaidPackage() {
		return auspaidpkg;
	}

}
