package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PDGEurTrendingCombos {
	
	@FindBy(xpath = "//span[@class='pull-right btn btn-primary btn-huge']")
	private WebElement createitinerary;
	
	@FindBy(xpath = "//a[@href='/customize/idn']")
	private WebElement bali;
	
	@FindBy(xpath = "//div[@class='n-tracker-plantotravel-september pdg-card']")
	private WebElement month;
	
	@FindBy(xpath = "//div[contains(@class,'hm-days-2')]")
	private WebElement duration;
	
	@FindBy(xpath = "//div[contains(@class,'seeanddo-5')]")
	private WebElement preference;
	
	@FindBy(xpath ="//span[contains(text(),'Get a Pickyourtrail itinerary')]")
	private WebElement PytItn;
	
	@FindBy(xpath = "//a[@href='/customize/eur/month/duration/interests/']")
	private WebElement finalizeChoices;
	
	@FindBy(xpath = "//li[contains(@class,'n-tracker-topcombos')]")
	private WebElement combos;
	
	@FindBy(xpath = "//*/h5[text()='Prague, Budapest & Ljubljana']")
	private WebElement chosenPkg;
	
	@FindBy(xpath = ("(//div[@id='itinerary_page']//*/button[contains(text(),'Get trip cost')])[1]"))
	private WebElement doTripCost;
	
	@FindBy(xpath = "//button[contains(text(),'Book now')]")
	private WebElement costingDelay;
	
//	@class='n-tracker-boookyourtrip btn btn-primary'
	
	@FindBy(xpath = "//*/button[contains(text(), 'Sign up to get free quotes')]")
	private WebElement signupFromOldUser;
	
	@FindBy(xpath="//div/*/a[contains(text(),'Got It')]")
	WebElement gotitPDG;
	
	public WebElement getPYTItn()
	{
		return PytItn;
	}

	public WebElement getPDGGotIt()
	{
		return gotitPDG;
	}

	
	public WebElement getPDGLocation()
	{
		return bali;
	}
	
	public WebElement getMonth()
	{
		return month;
	}
	
	public WebElement getDuration()
	{
		return duration;
	}
	
	public WebElement getPreference()
	{
		return preference;
	}
	
	public WebElement confirmFinalChoices()
	{
		return finalizeChoices;
	}
	
	public WebElement goToCombos()
	{
		return combos;
	}
	
	public WebElement getComboPackage()
	{
		return chosenPkg;
	}
	
	public WebElement getTripCost()
	{
		return doTripCost;
	}
	
	public WebElement getCreateItinerary()
	{
		return createitinerary;
	}
	
	public WebElement waitForCosting()
	{
		return costingDelay;
	}
	
	public WebElement doSignupFromOldUserModal()
	{
		return signupFromOldUser;
	}

}
