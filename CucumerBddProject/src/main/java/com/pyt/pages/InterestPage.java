package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterestPage {

	

	@FindBy(xpath="//div[@class='pdg-card n-tracker-seeanddo-2']")
	private WebElement artAndCulture;
	
	@FindBy(xpath="//div[@class='pdg-card n-tracker-seeanddo-1']")
	private WebElement adventureOutdoors;
	
	@FindBy(xpath="//div[@class='pdg-card n-tracker-seeanddo-3']")
	private WebElement foodandNighLife;
	
	@FindBy(xpath="//div[@class='pdg-card n-tracker-seeanddo-4']")
	private WebElement shoppingAndLeisure;
	
	@FindBy(xpath="//div[contains(@class,'seeanddo-5')]")
	private WebElement abitOfEverything;
	
	@FindBy(xpath="//span[contains(text(),'Get a Pickyourtrail itinerary')]")
	private WebElement getPytIternaryButton;
	
	@FindBy(xpath="//span[contains(text(),'View your Pickyourtrail personalized')]")
	private WebElement viewPytIternaryButton;
	
	@FindBy(xpath="(//div[contains(@class,'SingleCityCard')])[1]")
	private WebElement select1City;
	
	@FindBy(xpath="(//a[contains(text(),'Choose cities')])[1]")
	private WebElement viewCitiesButton;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement tellusMore;
	
	@FindBy(xpath="//span[contains(text(),'Build itinerary')]")
	private WebElement buildItineraryButton;
	
	@FindBy(xpath = "//a[contains(text(),'Got')]")
	private WebElement gotItPopup;
	
	@FindBy(xpath = "(//div[contains(@class,'PaxCard__PDGCard')])[1]")
	private WebElement travellingAsCouple;
	
	@FindBy(xpath="//input[@name='citySearchText']")
	private WebElement citySearchText;
	
	
	//island Destination
	
	//Maldives 
	
	

	@FindBy(xpath="//section[@class='pdg-maldives-card' and @tabindex='1']")
	private WebElement maldivesHotelSelection;
	
	public WebElement getMaldivesHotel() {
		return maldivesHotelSelection;
	}
	
	@FindBy(xpath="//input[@id='landing-search-input']")
	WebElement enterCity;

	public WebElement getgotItPopup() {
		return gotItPopup;
	}

		
	public WebElement getCity() {
		return enterCity;
	}

	public WebElement getselect1City() {
		return select1City;
	}
	
	public WebElement getbuildItineraryButton() {
		return buildItineraryButton;
	}
	
	public WebElement getviewCitiesButton() {
		return viewCitiesButton;
	}
	
	
	public WebElement gettellusMore() {
		return tellusMore;
	}
	public WebElement getIternaryButton() {
		return getPytIternaryButton;
	}
	
	public WebElement getviewPytIternaryButton() {
		return viewPytIternaryButton;
	}
	
	public WebElement getArtAndCulture() {
		return artAndCulture;
	}

	public WebElement getAdventureOutdoors() {
		return adventureOutdoors;
	}

	public WebElement getFoodandNighLife() {
		return foodandNighLife;
	}

	public WebElement getShoppingAndLeisure() {
		return shoppingAndLeisure;
	}

	public WebElement getAbitOfEverything() {
		return abitOfEverything;
	}
	
	public WebElement getTraveelingWith() {
		return travellingAsCouple;
	}
	
	public WebElement getCitySearchText() {
		return citySearchText;
	}
	
}
