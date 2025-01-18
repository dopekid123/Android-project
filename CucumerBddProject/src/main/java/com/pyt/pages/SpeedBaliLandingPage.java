package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SpeedBaliLandingPage {

	
	@FindBy(xpath = "//input[@placeholder='Departure city']")
	WebElement sBaliDepartureCity;
	
	@FindBy(xpath = "//input[@id='departure-date-get-cost']")
	WebElement sBaliTravelDate;
	
	@FindBy(xpath = "//input[@placeholder='Duration of stay']")
	WebElement sBaliDuration;
	
	@FindBy(xpath = "//input[@placeholder='Traveller details']")
	WebElement sBaliPax;
	
	
	@FindBy(xpath = "//button[contains(text(),'Search for packages')]")
	WebElement sBaliCheckDeals;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'4')]")
	WebElement sbDuration4n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'5')]")
	WebElement sbDuration5n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'6')]")
	WebElement sbDuration6n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(@class,'pyt-plus')]")
	WebElement sbAddCustomDuration;
	
	@FindBy(xpath = "//div[contains(@class,'duration')]//*[contains(@class,'pyt-minus')]")
	WebElement sbReduceCustomDuration;
	
	@FindBy(xpath = "//select[contains(@class,'ChildAge__Select')]")
	WebElement sbChildAge;
	
	@FindBy(xpath = "//a[text()='Done']")
	WebElement sbRoomDoneOptn;
	
	@FindBy(xpath = "(//span[contains(text(),'VIEW ALL DEALS')])[1]")
	WebElement viewAllDeals;
	
   @FindBys(@FindBy(xpath="//div[@type='Hotel']"))
	private List<WebElement> packagesHotel;
   
   @FindBy(xpath = "//button[text()='Next']")
	WebElement packagesNextArrow;
   
   
   @FindBy(xpath = "(//div[contains(@class,'SPEEDBALI-honeymoon-special')])[1]/a/p")
   WebElement honeymoonPackage;
   
   @FindBy(xpath = "//div[contains(@class,'SPEEDBALI-private-pool-villa')][1]/a/p")
	WebElement privatePoolVillaPackage;
   
   @FindBy(xpath = "//div[contains(@class,'SPEEDBALI-family-time')][1]/a/p")
	WebElement familyPackage;
   
   @FindBy(xpath = "//div[contains(@class,'SPEEDBALI-water-adventure')][1]/a/p")
	WebElement adventurePackage;
   
    @FindBy(xpath = "//button[text()='Get latest cost']")
   WebElement priceCTA;
   
   @FindBy(xpath = "//button[contains(@class,'get-cost-modal')]")
   WebElement getCostModal;
   
   @FindBy(xpath = "(//section[contains(@class,'CategoryPanel__Category')])[1]")
   WebElement scrollForHoneymoon;
   
   @FindBy(xpath = "(//section[contains(@class,'CategoryPanel__Category')])[2]")
   WebElement scrollForPrivatePoolVilla;
   
   @FindBy(xpath = "(//section[contains(@class,'CategoryPanel__Category')])[3]")
   WebElement scrollForFamily;
   
   @FindBy(xpath = "(//section[contains(@class,'CategoryPanel__Category')])[4]")
   WebElement scrollForAdventure;
   
   
   @FindBy(xpath = "//*[text()='What is your travel plan like?']/../..//following::*[@placeholder='Departing from']")
   WebElement departingFrom;
   
   public WebElement  getDeparingFrom()
 	{
 		return departingFrom;
 	   
 	}
   
   
   public WebElement  getHoneymoonScroll()
  	{
  		return scrollForHoneymoon;
  	   
  	}
   
   public WebElement  getPrivatePoolVillaScroll()
 	{
 		return scrollForPrivatePoolVilla;
 	   
 	}
   
   public WebElement  getFamilyScroll()
 	{
 		return scrollForFamily;
 	   
 	}
   public WebElement  getAdventureScroll()
 	{
 		return scrollForAdventure;
 	   
 	}
   
   public WebElement  getGCMModal()
	{
		return getCostModal;
	}
  		
  public WebElement  getPriceCTA()
 	{
 		return priceCTA;
 	}
   		
   
   public WebElement  getHoneymoonPackage()
  	{
  		return honeymoonPackage;
  	}
   
   public WebElement getPrivatePoolVilla()
  	{
  		return privatePoolVillaPackage;
  	}
   
   public WebElement getFamilyPackage()
  	{
  		return familyPackage;
  	}
   
   public WebElement  getAdventurePackage()
  	{
  		return adventurePackage;
  	}
	
   public List<WebElement> getPackagesHotel()
	{
		return packagesHotel;
	}
	
   public WebElement getPackagesNextArrow()
	{
		return packagesNextArrow;
	}
	

	public WebElement getViewAllDeals()
	{
		return viewAllDeals;
	}
	
	public WebElement sbRoomDoneOptn()
	{
		return sbRoomDoneOptn;
	}
	
	
	public WebElement sbChildAge()
	{
		return sbChildAge;
	}
	
	public WebElement sbChoose4Night()
	{
		return sbDuration4n;
	}
	
	public WebElement sbChoose5Nights()
	{
		return sbDuration5n;
	}
	
	public WebElement sbChoose6Nights()
	{
		return sbDuration6n;
	}
	
	public WebElement sbAddCustomDuration()
	{
		return sbAddCustomDuration;
	}
	
	public WebElement sbReduceCustomDuration()
	{
		return sbReduceCustomDuration;
	}
	
	public WebElement getSbDepartureCity()
	{
		return sBaliDepartureCity;
	}
	
	public WebElement getSbDepartureDate()
	{
		return sBaliTravelDate;
	}
	
	public WebElement getSbDuration()
	{
		return sBaliDuration;
	}
	
	public WebElement getSbPax()
	{
		return sBaliPax;
	}
	
	public WebElement getsBaliCheckDeals()
	{
		return sBaliCheckDeals;
	}
	
	
}
