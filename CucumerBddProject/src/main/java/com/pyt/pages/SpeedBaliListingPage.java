package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpeedBaliListingPage {

	
	@FindBy(xpath = "//ol[@class='cards-breadcrumb']//li//a")
	WebElement sBaliText;
	
	@FindBy(xpath = "(//*[@class='logo-icon']/following::ul/li[6])[1]")
	WebElement priceFilter;
	
	@FindBy(xpath = "//span[contains(text(),'hotels')]")
	WebElement hotelsFilter;
	
	@FindBy(xpath = "(//input[@name='price'])[1]")
	WebElement onetoOnedot2lakh;
	

	@FindBy(xpath = "(//input[@name='price'])[2]")
	WebElement onedot2toOnedot6lakh;
	
	@FindBy(xpath = "(//input[@name='price'])[3]")
	WebElement onedot6to2lakh;
	
	@FindBy(xpath = "(//input[@name='price'])[4]")
	WebElement above2Lakh;
	
	
	@FindBy(xpath = "(//button[contains(text(),'Apply')])[5]")
	WebElement sbApplyFilter;
	
	
	@FindBy(xpath = "//span[contains(text(),'Star Category')]")
	WebElement StarFilter;

	@FindBy(xpath = "(//input[@name='star'])[1]")
	WebElement fourStarFilter;
	
	@FindBy(xpath = "(//input[@name='star'])[2]")
	WebElement fiveStarFilter;
	
	@FindBy(xpath = "(//button[contains(text(),'Apply')])[3]")
	WebElement starApply;
	
	@FindBy(xpath = "(//div[starts-with(@class,'TopStickyFilterStyles')])[8]")
	WebElement villaFilter;
	
	@FindBy(xpath = "(//input[@name='villa'])[1]")
	WebElement privateVilla;
	
	@FindBy(xpath = "(//input[@name='villa'])[2]")
	WebElement gardenView;
	
	@FindBy(xpath = "(//input[@name='villa'])[3]")
	WebElement deluxeRoom;
	
	@FindBy(xpath = "(//button[contains(text(),'Apply')])[4]")
	WebElement villaTypeApply;
	
	@FindBy(xpath = "(//button[contains(text(),'Reset')])[4]")
	WebElement villaReset;
	
	@FindBy(xpath = "(//button[contains(text(),'Reset')])[3]")
	WebElement starReset;
	
	@FindBy(xpath= "(//button[contains(text(),'Reset')])[5]")
	WebElement priceReset;
	

	@FindBy(xpath = "//button[contains(text(),'Book now')]")
	WebElement bookNowButton;
	
	@FindBy(xpath= "(//ul[starts-with(@class,'resort-list')])[1]" )
	WebElement hotelCard;
	
	
	@FindBy(xpath = "//button[contains(text(),'Already registered? Login Now')]")
	WebElement alreadyRegistered;
	
	@FindBy(xpath = "(//*/div/*[contains(text(),'Login')])[2]")
	WebElement loginGCM;
	
	@FindBy(xpath = "//button[text()='Unlock deal']")
	WebElement unlockDeal;
	

	@FindBy(xpath = "(//li[contains(@class,'FilterDropdown')])[1]")
	WebElement filterforGCM;
	
	@FindBy(xpath = "//input[@id='costing-input']")
	WebElement costingConfig;
	
	@FindBy(xpath = "//span[contains(text(),'Cities')]")
	WebElement cityFilter;
	
	@FindBy(xpath = "(//input[@name='cities'])[1]")
	WebElement kutaAndUbudFilter;
			
	@FindBy(xpath = "(//input[@name='cities'])[2]")
    WebElement seminyakAndUbud;
					
	@FindBy(xpath = "(//input[@name='cities'])[3]")
	WebElement nusaduaAndUbud;
	
	@FindBy(xpath = "(//button[contains(text(),'Apply')])[2]")
	WebElement cityApplyFilter;
	
	@FindBy(xpath = "//strong[contains(text(),'We’re sorry')]")
	WebElement noResultsMessage;
	
	@FindBy(xpath = "(//span[contains(text(),'4 star')])[1]")
	WebElement fourstarOnReset;
	
	@FindBy(xpath = "(//span[contains(text(),'5 star')])[1]")
	WebElement fivestarOnReset;
	
	@FindBy(xpath = "(//div[@name='stay']//h4)[1]")
	WebElement firstHotelHeader;
	
	@FindBy(xpath = "(//div[@name='stay']//h4)[2]")
	WebElement secondHotelHeader;
	
	
	public WebElement getFirstHotelHeader()
	{
		return firstHotelHeader;
	}
	
	
	public WebElement getSecondHotelHeader()
	{
		return secondHotelHeader;
	}
	
	
	public WebElement getcityApplyFilter() 
	{
		return cityApplyFilter;
	}
	
	public WebElement getNusaduaAndUbud() 
	{
		return nusaduaAndUbud;
	}
	
	public WebElement getSeminyakAndUbud() 
	{
		return seminyakAndUbud;
	}
	
	public WebElement getKutaAndUbud() 
	{
		return kutaAndUbudFilter;
	}
	
	public WebElement getCityFilter() 
	{
		return cityFilter;
	}
	
	public WebElement getGCMPax()
	{
		return costingConfig;
	}
	
	public WebElement getGCMFilter()
	{
		return filterforGCM;
	}

	
	public WebElement getUnlockDeal()
	{
		return unlockDeal;
	}
	
	public WebElement getsBaliText()
	{
		return sBaliText;
	}
	
	public WebElement getpriceFilter() 
	{
		return priceFilter;
	}
	
	public WebElement getonetoOnedot2lakh()
	{
		return onetoOnedot2lakh;
	}
	
	public WebElement getonedot2toOnedot6lakh()
	{
		return onedot2toOnedot6lakh;
	}
	
	public WebElement getonedot6to2lakh()
	{
		return onedot6to2lakh;
	}
	
	public WebElement getabove2Lakh()
	{
		return above2Lakh;
	}
	
	public WebElement getsbApplyFilter()
	{
		return sbApplyFilter;
	}
	
	public WebElement getStarFilter()
	{
		return StarFilter;
	}
	
	public WebElement getfourStarFilter()
	{
		return fourStarFilter;
	}
	
	public WebElement getfiveStarFilter()
	{
		return fiveStarFilter;
	}
	
	public WebElement getstarApply()
	{
		return starApply;
	}
	
	public WebElement getVillaFilter()
	{
		return villaFilter;
	}
	
	public WebElement getPrivateVilla()
	{
		return privateVilla;
	}
	
	public WebElement getGardenView()
	{
		return gardenView;
	}
	
	public WebElement getDeluxeRoom()
	{
		return deluxeRoom;
	}
	
	public WebElement getVillaTypeApply()
	{
		return villaTypeApply;
	}
	
	public WebElement getBooknowButton()
	{
		return bookNowButton;
	}
	
	public WebElement getHotelCard()
	{
		return hotelCard;
	}
	
	public WebElement getAlreadyRegistered()
	{
		return alreadyRegistered;
	}
	
	public WebElement getLoginGCM()
	{
		return loginGCM;
	}
	
	public WebElement getNoResultsMessage()
	{
		return noResultsMessage;
	}
	
	public WebElement getVillaReset()
	{
		return villaReset;
	}
	
	public WebElement getStarReset()
	{
		return starReset;
	}
	
	public WebElement getPriceReset()
	{
		return priceReset;
	}
	
	public WebElement getFourstarOnReset()
	{
		return fourstarOnReset;
	}
	
	public WebElement getFivestarOnReset()
	{
		return fivestarOnReset;
	}
	
	public WebElement getHotelsFilter()
	{
		return hotelsFilter;
	}
	
	
	
	
}
