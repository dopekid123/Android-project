package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PdgFlowPage {

	@FindBy(xpath = "//a[contains(text(),'Continue to booking')]")
	WebElement continue_to_book_button;

	@FindBy(xpath = "//button[contains(@class,'VerifyBlock__SubmitBtn')]")
	WebElement cookiesOkButtonGlobal;
	
	@FindBy(xpath = "(//span[text()='Search countries, cities'])[1] | //input[@placeholder='Pick your destination']")
	WebElement searchcountries;
	
	
	@FindBy (xpath="//a[text()='Dubai']")
	WebElement destinationdubai;
	
	@FindBy (xpath="//input[@placeholder='Enter your mobile number'] | //input[@type='number'] | //input[@placeholder='Mobile Number'] ")
	WebElement pdgenterno;
	
	@FindBy (xpath="//input[contains(@placeholder,'Name')] | //input[@id='name'] | //input[@placeholder='Your name'] ")
	WebElement pdgentername;
	
	@FindBy (xpath="//a[text()='Europe']")
	WebElement destinationeurope;
	
	@FindBy (xpath="//a[text()='Thailand']")
	WebElement destinationThailand;
	
	@FindBy (xpath="//span[contains(text(),'Barcelona, Spain')] | //span[contains(text(),'Tenerife, Spain')] | //span[contains(text(),'Athens, Greece')]")
	WebElement europecities;
	
	@FindBy (xpath="//a[contains(text(),'Got It')]")
	WebElement gotitpopup;
	
	@FindBy (xpath="//input[@placeholder='Departing from']")
	WebElement departfrom;
	
	@FindBy (xpath="//li[contains(text(),'Chennai, IN')]")
	WebElement departcity;
	
	@FindBy (xpath="(//div[@class='LanguageSelection__StyledWrapper-lhYBuz ipXKMa'] )[3]")
	WebElement langTamil;
	
	@FindBy (xpath="//input[@placeholder='Find a city']")
	WebElement findACity;
	
	@FindBy (xpath="//span[contains(text(),'Barcelona, Spain')]")
	WebElement barcelonaCity;
	
	@FindBy (xpath="//span[contains(text(),'Athens, Greece')]")
	WebElement athensCity;
	
	@FindBy (xpath="//span[contains(text(),'Paris, France')]")
	WebElement parisCity;
	
	@FindBy (xpath="//span[contains(text(),'London, England')]")
	WebElement londonCity;
	
	@FindBy (xpath="//span[contains(text(),'Barcelona, Spain')]")
	WebElement BarcelonaCity;
	
	@FindBy (xpath="//span[contains(text(),'Phuket, Thailand')]")
	WebElement phuketCity;
	
	@FindBy (xpath="//span[contains(text(),'Krabi, Thailand')]")
	WebElement krabiCity;
	
	@FindBy(xpath = "//input[@placeholder='Pick your destination']")
	WebElement pickYourDestinationField;
	
	
	public WebElement getpickYourDestinationField() {
		return pickYourDestinationField;
	}
	
	public WebElement getDestinationThailand() {
		return destinationThailand;
	}

	public WebElement getPhuketCity() {
		return phuketCity;
	}

	public WebElement getKrabiCity() {
		return krabiCity;
	}

	public WebElement getParisCity() {
		return parisCity;
	}

	public WebElement getLondonCity() {
		return londonCity;
	}

	public WebElement getlangTamil() {
		return langTamil;
	}
	
	public WebElement getdepartcity() {
		return departcity;
	}
	
	public WebElement getdepartfrom() {
		return departfrom;
	}
	
	public WebElement getgotitpopup() {
		return gotitpopup;
	}
	
	public WebElement geteuropecities() {
		return europecities;
	}
	
	public WebElement getdestinationeurope() {
		return destinationeurope;
	}
	
	
	public WebElement getpdgentername() {
		return pdgentername;
	}
	
	
	public WebElement getpdgenterno() {
		return pdgenterno;
	}
	
	public WebElement getdestinationdubai() {
		return destinationdubai;
	}

	public WebElement getsearchcountries() {
		return searchcountries;
	}
	
	public WebElement getcontinue_to_book_button() {
		return continue_to_book_button;
	}

	public WebElement getCookiesOkGlobal() {
		return cookiesOkButtonGlobal;
	}
	
	public WebElement getFindACity() {
		return findACity;
	}
	
	public WebElement getBarcelonaCity() {
		return barcelonaCity;
	}

	public WebElement getAthensCity() {
		return athensCity;
	}

}
