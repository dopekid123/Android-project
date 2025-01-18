package com.pyt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//User initial after login 
	@FindBy(xpath="//span[@class='user-initials']")
	private WebElement userInitialPostLogin;

	public WebElement getUserInitialPostLogin() {
		return userInitialPostLogin;
	}

	// PICK YOUR TRAIL LOGO // Added valentine logo kindly remove that xpath after 14 th feb.
    @FindBy(xpath = "//a[contains(@class,'pytlogo')] | //img[contains(@src,'pickyourtrail-logo')] | //img[contains(@src,'pyt_valentine')]")
	private WebElement PytLogo;
	
	
	//
	@FindBy(linkText = "Login")
	private WebElement login;

	@FindBy(linkText = "Testimonials")
	private WebElement testimonials;

	@FindBy(linkText = "Guides")
	private WebElement guides;
	
	@FindBy(xpath="//ul/li/span[contains(text(),'Guides')]")
	private WebElement guidesBreadCrumbInGuidesPage;

	@FindBy(xpath = "//*[contains(text(),'About Us')]")
	private WebElement aboutUs;
	
	@FindBy(xpath="//li[@class='active']/a[contains(text(),'About')]")
	private WebElement aboutTabInAboutUsPage;

	@FindBy(xpath="//a[contains(text(),'Careers')]")
	private WebElement careers;

	@FindBy(linkText = "Blog")
	private WebElement blog;
	
	@FindBy(xpath="//img[@alt='Pickyourtrail Blog']")
	private WebElement blogIconInBlogPage;

	@FindBy(xpath = "//i[@class='vehoicon-ion-more']")
	private WebElement vehoIcon;

	@FindBy(linkText = "Visa")
	private WebElement visa;

	@FindBy(linkText = "FAQ")
	private WebElement faq;

	@FindBy(xpath = "//*[contains(@class,'n-tracker-header-contact')]")
	private WebElement contactUs;
	
	@FindBy(xpath="(//li[contains(@class,'header-submenu')])[2]")
	private WebElement headerSubmenu;

	@FindBy(xpath = "//button[text()='Start Planning'] | //i[contains(@class,'pyt-search')] | //*[contains(@class,'Home__HeroBanner')]")
	private WebElement startPlanningNowButton;

	@FindBy(linkText = "+91 9790733699")
	private WebElement callNumber;

	// recently booked itinerary

	@FindBy(xpath = "(//div[contains(@class,'emojiMapMarker')]/span)[1]")
	private WebElement recentlyBookedItinerary;
	
	@FindBy(xpath = "//*[contains(@class,'PromoSection__PromoContainer')]")
	private WebElement promoSection;
	
	// visa on arrival card

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-visaonarrival-card'])[1]")
	private WebElement visaOnArrivalItinerary;

	// Great family 👪 holidays

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-familyholidays-card'])[1]")
	private WebElement familVacationItinerary;

	@FindBy(xpath = "(//*[@class='pull-right btn btn-default btn-outline btn-sm n-tracker-familyholidays-exploremore'])")
	private WebElement familyVacationExplore;
	
	// Romantic 💑 holidays

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-romanticholidays-card'])[1]")
	private WebElement romanticHolidaysItinerary;

	// Adventure 🏄‍ trips
	@FindBy(xpath = "//a[contains(@class,'adventuretrip-exploremore')]")
	private WebElement adventureTripsItinerary;

	// Beach 🏖️ vacations

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-beachvacations-card'])[2]")
	private WebElement beachVacationItinerary;
	
	//Paid Campaign Page for Australia
	
	@FindBy(xpath = "//a[contains(text(),'Explore Australia')]")
	private WebElement auspkg;
	
	@FindBy(xpath ="//a[contains(@class,'adventuretrip-exploremore')]")
	   public WebElement adventureTripsPackages;
	
	@FindBy(xpath ="(//a[contains(text(),'Your vacations')])[2]")
	   public WebElement yourVacationsFromHomePage;
	
	
	@FindBy(xpath ="//div[contains(@class,'Navbar__Avatar')]")
	public WebElement userLoggedInitial;
	
	@FindBy(xpath ="//p[@class='booked-txt']")
	public WebElement bookedItinerayFromHomePage;
	
	@FindBy(xpath ="//i[contains(@class,'pyt-search')]")
	public WebElement searchDestination;
	
	@FindBy(xpath="(//a[contains(@href,'honeymoon')]//div)[1]")
	public WebElement packageSlugItineraryHomePage;
	
	@FindBy(xpath="//p[contains(text(),'No, thanks')]")
	public WebElement signupoffer;
	
	@FindBy(xpath="(//div[@id='verify-block-header']//i)[1]")
	public WebElement emailnotify;
	
	@FindBy(xpath="(//div//a[contains(@href, 'maldives-tour-packages')])[2]")
	public WebElement bannerMaldives;
	
	@FindBy(xpath="(//div//a[contains(@href, 'dxb')])[3]")
	public WebElement bannerDubai;
	
	@FindBy(xpath="(//div//a[contains(@href, 'eur')])[4]")
	public WebElement bannerEurope;
	
	@FindBy(xpath="(//div//a[contains(@href, 'tha')])[4]")
	public WebElement bannerThailand;
	
	@FindBy(xpath="(//div//a[contains(@href, 'idn')])[2]")
	public WebElement bannerBali;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Austria')]")
	public WebElement bannerAustria;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Finland')]")
	public WebElement bannerFinland;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Norway')]")
	public WebElement bannerNorway;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Italy')]")
	public WebElement bannerItaly;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Switzerland')]")
	public WebElement bannerSwitzerland;
	
	@FindBy(xpath="//div//img[contains(@alt, 'France')]")
	public WebElement bannerFrance;
	
	@FindBy(xpath="//div//img[contains(@alt, 'United Kingdom')]")
	public WebElement bannerUk;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Turkey')]")
	public WebElement bannerTurkey;
	
	@FindBy(xpath="//div//img[contains(@alt, 'Spain')]")
	public WebElement bannerSpain;
	
	@FindBy(xpath="//div//img[contains(@alt, 'aze')]")
	public WebElement bannerAzerbaijan;
	
	@FindBy(xpath="(//div//a[contains(@href, 'aus')])[4]")
	public WebElement bannerAustralia;
	
	@FindBy(xpath="(//div//a[contains(@href, 'nz')])[2]")
	public WebElement bannerNewzealand;
	
	@FindBy(xpath="(//div//a[contains(@href, 'sin')])[5]")
	public WebElement bannerSingapore;
	
	@FindBy(xpath="(//div//a[contains(@href, 'vnm')])[2]")
	public WebElement bannerVietnam;
	
	@FindBy(xpath="(//div//a[contains(@href, 'lka')])[3]")
	public WebElement bannerSrilanka;
	
	@FindBy(xpath="//div[contains(@id,'radix-:R64jm:-trigger-radix-:r0:')] | //nav[@aria-label='Main']//li[7]")
	public WebElement loginAvatar;
	
	@FindBy(xpath="//nav[@aria-label='Main']//li[5]")
	public WebElement globalLoginAvatar;
	
	@FindBy(xpath="(//div//a[contains(@href, 'php')])")
	public WebElement bannerPhilippines;
	
	@FindBy(xpath="(//div//a[contains(@href, 'mly')])[3]")
	public WebElement bannerMalaysia;
	
	@FindBy(xpath="(//div//a[contains(@href, 'jpn')])")
	public WebElement bannerJapan;
	
	@FindBy(xpath="(//div//a[contains(@href, 'dnk')])")
	public WebElement bannerDenmark;
	
	@FindBy(xpath="(//div//a[contains(@href, 'ice')])[1]")
	public WebElement bannerIceland;
	
	@FindBy(xpath="(//div//a[contains(@href, 'swe')])[3]")
	public WebElement bannerSweden;
	
	public WebElement getbannerSweden() {
		return bannerSweden;
	}
	
	public WebElement getbannerIceland() {
		return bannerIceland;
	}
	
	public WebElement getbannerDenmark() {
		return bannerDenmark;
	}
	
	public WebElement getbannerJapan() {
		return bannerJapan;
	}
	
	public WebElement getbannerMalaysia() {
		return bannerMalaysia;
	}
	
	public WebElement getbannerPhilippines() {
		return bannerPhilippines;
	}
	
	public WebElement getloginAvatar() {
		return loginAvatar;
	}
	
	public WebElement getbannerSrilanka() {
		return bannerSrilanka;
	}
	
	public WebElement getbannerVietnam() {
		return bannerVietnam;
	}
	
	public WebElement getbannerSingapore() {
		return bannerSingapore;
	}
	
	public WebElement getbannerNewzealand() {
		return bannerNewzealand;
	}
	
	public WebElement getbannerAustralia() {
		return bannerAustralia;
	}
	
	public WebElement getbannerAzerbaijan() {
		return bannerAzerbaijan;
	}
	
	public WebElement getbannerSpain() {
		return bannerSpain;
	}
	
	public WebElement getbannerTurkey() {
		return bannerTurkey;
	}
	
	public WebElement getbannerUk() {
		return bannerUk;
	}
	
	public WebElement getbannerFrance() {
		return bannerFrance;
	}
	
	public WebElement getbannerSwitzerland() {
		return bannerSwitzerland;
	}
	
	public WebElement getbannerItaly() {
		return bannerItaly;
	}
	
	public WebElement getbannerNorway() {
		return bannerNorway;
	}
	
	public WebElement getbannerFinland() {
		return bannerFinland;
	}
	
	public WebElement getbannerAustria() {
		return bannerAustria;
	}
	
	public WebElement getbannerBali() {
		return bannerBali;
	}
	
	public WebElement getbannerThailand() {
		return bannerThailand;
	}
	
	public WebElement getbannerEurope() {
		return bannerEurope;
	}
	
	public WebElement getbannerDubai() {
		return bannerDubai;
	}
	
	public WebElement getbannerMaldives() {
		return bannerMaldives;
	}
	
	public WebElement getEmailNotify() {
		return emailnotify;
	}
	
	public WebElement getBlogIconInBlogPage() {
		return blogIconInBlogPage;
	}
	
	public WebElement getHeaderSubmenu() {
		return headerSubmenu;
	}
	
	public WebElement getSignupOffer() {
		return signupoffer;
	}

	public WebElement getPackageSlugItineraryHomePage() {
		return packageSlugItineraryHomePage;
	}

	public WebElement getSearchDestination() {
        return searchDestination;
    }
	
	public WebElement getUserLoggedInitial() {
        return userLoggedInitial;
    }

	public WebElement getAdventureTripsPackages() {
        return  adventureTripsPackages;
    }

	// recently booked itinerary
	public WebElement getrecentlyBookedItinerary() {
		return recentlyBookedItinerary;
	}

//visaOnArrivalItinerary
	public WebElement getvisaOnArrivalItinerary() {
		return visaOnArrivalItinerary;
	}

	// familVacationItinerary
	public WebElement getfamilVacationItinerary() {
		return familVacationItinerary;
	}

//romanticHolidaysItinerary
	public WebElement getromanticHolidaysItinerary() {
		return romanticHolidaysItinerary;
	}

	// adventureTripsItinerary
	public WebElement getadventureTripsItinerary() {
		return adventureTripsItinerary;
	}

	// beachVacationItinerary
	public WebElement getbeachVacationItinerary() {
		return beachVacationItinerary;
	}

	public WebElement getstartPlanningNowButton() {
		return startPlanningNowButton;
	}

	public WebElement getPytLogo() {
		return PytLogo;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getTestimonials() {
		return testimonials;
	}

	public WebElement getGuides() {
		return guides;
	}

	public WebElement getAboutUs() {
		return aboutUs;
	}

	public WebElement getCareers() {
		return careers;
	}

	public WebElement getBlog() {
		return blog;
	}

	public WebElement getVehoIcon() {
		return vehoIcon;
	}

	public WebElement getVisa() {
		return visa;
	}

	public WebElement getFaq() {
		return faq;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getCallNumber() {
		return callNumber;
	}

	public WebElement getExploreFamilyVacations()
	{
		return familyVacationExplore;
	}
	
	public WebElement goToAusPaidCampaignPage()
	{
		return auspkg;
	}
	
	public WebElement getYourVactionsFromHomePage()
	{
		return yourVacationsFromHomePage;
	}
	
	public WebElement getBookedItinerayFromHomePage()
	{
		return bookedItinerayFromHomePage;
	}
	
	public WebElement getPromoSection()
	{
		return promoSection;
	}
	
	public WebElement getGuidesBreadCrumbInGuidesPage() {
		return guidesBreadCrumbInGuidesPage;
	}
	
	public WebElement getAboutTabInAboutUsPage() {
		return aboutTabInAboutUsPage;
	}
	
	public WebElement getGlobalLoginAvatar() {
		return globalLoginAvatar;
	}
	
}
