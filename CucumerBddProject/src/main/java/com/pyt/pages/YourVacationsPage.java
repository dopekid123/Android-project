package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourVacationsPage {

	//View all saved itinerary button

	
	@FindBy(xpath="//a[@href='/saved-itineraries']")
	private WebElement savedItinerary;

	// Rename itinerary 1st edit button in saved itinerary page

	@FindBy(xpath="(//div[@id='saved']//i[contains(@class,'pyt-edit')])[1]")
	private WebElement renameItineraryEditIcon;

	//Delete button for 1st itinerary in saved itinerary page 

	@FindBy(xpath="(//div[@id='saved']//i[contains(@class,'pyt-delete')])[1]")
	private WebElement deleteItinerary;

	//Text box of rename itinerary in saved itinerary page

	@FindBy(xpath="//input[@name='currentTitle']")
	private WebElement textBoxRenameItinerary;

	// Rename submit tickmark button

	@FindBy(xpath="(//div[@id='saved']//button)[1]")
	private WebElement submitButtonRenameItinerary ;

	
			
	// saved itinerary heading 

	//@FindBy(xpath="//section[@class='clearfix saved-card ']//*[contains(@class,'small-heading')]")
	@FindBy(xpath="(//div[@id='saved']//h6)[1]")
	private WebElement beforeRename;

	//Booked itinerary card in the your vacations page 

	//@FindBy(xpath="//section[@class='clearfix trip-details cursor-pointer mbottom-large']")
	@FindBy(xpath="//figure[@class='pull-left']")
	private WebElement bookedItinerary;

	//View itinerary in Booked itinerary

	@FindBy(xpath="//a[contains(text(),'View itinerary')]")
	private WebElement viewBookedItinerary;

	//saved itinerary 1st card in saved itinerary page under your vacations page

	@FindBy(xpath="(//div[@id='saved']//section)[1]")
	private WebElement savedItineraryCard;

	//Update cost button on itinerary page 

	//@FindBy(xpath="//button[@id='update-cost-btn']")
	@FindBy(xpath="(//button[contains(text(),'Update Cost')])[1]")
	private WebElement updateCostButton ;

	
	@FindBy(xpath="//div[@class='dropdown open btn-group']//ul[@class='dropdown-menu']")
	private WebElement deleteItineraryDropDown;
	
	//payment tab in booked itinerary
	
    @FindBy(xpath="//div[@id='tab-1']")
    private WebElement paymentTab;
    
    //partial payment radio button
    
   
	@FindBy(xpath="//span[contains(text(),'Partial payment')]")
    private WebElement partialPayment;
    
    //full payment radio button
    
    @FindBy(xpath="//span[contains(text(),'Full payment')]")
    private WebElement fullPayment;
    
    //Total cost of the itinerary booked 
    
    @FindBy(xpath="(//div[@class='row text-center']//span)[1]")
    private WebElement totalCostInBookedItinerary;
    
    //user paid amount field in booked itinerary 
    
    @FindBy(xpath="(//div[@class='row text-center']//span)[2]")
    private WebElement userPaidCostBookedIitnerary;
    
    @FindBy(xpath="//strong[@class='medium-heading']")
    private WebElement totalCostInItineraryPage;
    
    @FindBy(xpath="//a[contains(text(),'Make payment')]")
    private WebElement makePaymentFromYourvacations;
    
    @FindBy(xpath="(//*[@class='row saved-card'])[1]")
    private WebElement savedItinerary1stCard;
    
    @FindBy(xpath=" //div[@id='saved']//section")
    private WebElement savedItinerarySection;
    
 
	//input[@name='payment_option']/following::span[2]

	//input[@name='payment_option']/following::span[1]
	
	//Getters for the above web Elements
    
    public WebElement getMakePaymentFromYourvacations() {
		return makePaymentFromYourvacations;
	}

	public WebElement getTotalCostInItineraryPage() {
		return totalCostInItineraryPage;
	}

	public WebElement getPaymentTab() {
		return paymentTab;
	}

	public WebElement getPartialPayment() {
		return partialPayment;
	}

	public WebElement getFullPayment() {
		return fullPayment;
	}

	public WebElement getTotalCostInBookedItinerary() {
		return totalCostInBookedItinerary;
	}


	public WebElement getUserPaidCostBookedIitnerary() {
		return userPaidCostBookedIitnerary;
	}

	public WebElement getDeleteItineraryDropDown() {
		return deleteItineraryDropDown;
	}

	public WebElement getUpdateCostButton() {
		return updateCostButton;
	}

	public WebElement getSavedItineraryCard() {
		return savedItineraryCard;
	}

	public WebElement getViewBookedItinerary() {
		return viewBookedItinerary;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getBeforeRename() {
		return beforeRename;
	}

	public WebElement getSavedItinerary() {
		return savedItinerary;
	}

	public WebElement getRenameItineraryEditIcon() {
		return renameItineraryEditIcon;
	}

	public WebElement getDeleteItinerary() {
		return deleteItinerary;
	}

	public WebElement getTextBoxRenameItinerary() {
		return textBoxRenameItinerary;
	}

	public WebElement getSubmitButtonRenameItinerary() {
		return submitButtonRenameItinerary;
	}

	public WebElement getsavedItinerary1stCard() {
		return savedItinerary1stCard;
	}

	public WebElement getSavedItinerarySection() {
		return savedItinerarySection;
	}





}
