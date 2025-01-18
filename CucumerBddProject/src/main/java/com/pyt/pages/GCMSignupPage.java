package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GCMSignupPage {
	
	@FindBy(xpath = "//input[@placeholder='Departing from']")
	private WebElement depbox;
	
	@FindBy(xpath = "//*/span[text()='MAA']")
	private WebElement depFrom;
	
	@FindBy(xpath = "//input[@placeholder='Departing on']")
	private WebElement datebox;
	
	@FindBy(xpath = "//button[text()='Get Cost']")
	private WebElement getCost;
	
	@FindBy(xpath = "//span[text()='Get latest cost']")
	private WebElement getLatestCost;
	
	@FindBy(xpath = "//div[@class='react-datepicker']/button[2]")
	private WebElement chooseNextMonth;
	
	@FindBy(xpath = "//div[@class='react-datepicker']/button")
	private WebElement chooseNextMonth1;

	@FindBy(xpath = "//label[@class='custom-options no-padding']/i")
	private WebElement intlFlights;

	@FindBy(xpath = "(//i[contains(@class,'pyt-close')])[3]")
	private WebElement closeGCMModal;
	
	@FindBy(xpath = "//div[@class='react-datepicker__month']/div[3]/div[1]")
	private WebElement chooseDate;
	
	@FindBy(xpath = "//*/p/a[text()='login to continue']")
	private WebElement gcmPageLogin;
	
	@FindBy(xpath = "//b[contains(text(),'adults')]")
	private WebElement editTrip;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block tracker-get-cost-modal-update-cost']")
	private WebElement updateCost;
	
	@FindBy(xpath= "//div[@class='animation-holder text-center']")
	private WebElement costingAnimation;
	
	@FindBy(xpath= "//button[contains(@class,'signup-cta-in-modal')]")
    private WebElement signUpCta;
	
	@FindBy(xpath="//div[contains(text(),'Lead Passenger Name')]/../input | //input[@placeholder='Your name'] | //label[contains(text(),'Lead Passenger Name')]/../input")
	private WebElement leadPassengerNameGlobal;


	@FindBy(xpath="//label[text()='Nationality']/../input")
	private WebElement nationalityGlobal;

	@FindBy(xpath="//label[text()='Arrival on']/../input")
	private WebElement arrivalOnGlobal;
	
    @FindBy(xpath="//label[text()='Email ID']/../input | //input[@placeholder='Email ID'] | //div[text()='Email ID']/../input | //label[contains(text(),'Email Id')]/../input")
	private WebElement emailIdGlobal;
	
	@FindBy(xpath="//label[text()='Mobile Number (Optional)']/../input | //input[@placeholder='Mobilenumber'] | //div[contains(text(),'Mobile number')]/../input | //input[@placeholder='Mobile Number'] | //label[contains(text(),'Mobile Number')]/../input ")
	private WebElement mobileNumberGlobal;
	
	
	@FindBy(xpath="//span[contains(text(),'Add room')]")
	private WebElement paxConfig;
	
	public WebElement getPaxConfigOnGCM() {
		return paxConfig;
	}
	
	
	public WebElement getLeadPassengerNameGlobal() {
		return leadPassengerNameGlobal;
	}
	
	public WebElement getNationalityGlobal() {
		return nationalityGlobal;
	}
	
	public WebElement getArrivalOnGlobal() {
		return arrivalOnGlobal;
	}
	
	public WebElement getEmailIdGlobal() {
		return emailIdGlobal;
	}
	
	public WebElement getMobileNumberGlobal() {
		return mobileNumberGlobal;
	}

	public WebElement getSignUpCta() {
        return signUpCta;
    }
	
	public WebElement getCostingAnimation() {
		return costingAnimation;
	}

	public WebElement goToDepartureSelection()
	{
		return depbox;
	}
	
	public WebElement getdepartureCity()
	{
		return depFrom;
	}
	
	public WebElement doGetCost()
	{
		return getCost;
	}
	
	public WebElement doGetLatestCost()
	{
		return getLatestCost;
	}
	
	public WebElement getDepartureDate()
	{
		return datebox;
	}
	
	public WebElement goToNextMonth()
	{
		return chooseNextMonth;
	}
	
	public WebElement goToNextMonth1() {
		return chooseNextMonth1;
	}
	
	public WebElement chooseDepartureDate()
	{
		return chooseDate;
	}
	
	public WebElement goToLogin()
	{
		return gcmPageLogin;
	}
	
	public WebElement closeGcmModal()
	{
		return closeGCMModal;
	}
	
	public WebElement getIntlFlights()
	{
		return intlFlights;
	}

	public WebElement getEditTrip()
	{
		return editTrip;
	}
	
	public WebElement getUpdateCost()
	{
		return updateCost;
	}
}
