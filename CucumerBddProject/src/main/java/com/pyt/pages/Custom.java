package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Custom {
	
	@FindBy(xpath="//button[text()='Add Custom Item']")
	WebElement addCustomItem;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement cardTitle;
	
	@FindBy(xpath="//input[@id='source']")
	WebElement source;
	
	@FindBy(xpath="//span[@title='EXPEDIA']")
	WebElement viaSourceExpedia;
	
	@FindBy(xpath="//span[@title='HOTELBEDS']")
	WebElement viaSourceHotelbeds;
	
	public WebElement getAddCustomItem() {
		return addCustomItem;
	}

	public WebElement getCardTitle() {
		return cardTitle;
	}

	public WebElement getSource() {
		return source;
	}

	public WebElement getViaSourceExpedia() {
		return viaSourceExpedia;
	}

	public WebElement getViaSourceHotelbeds() {
		return viaSourceHotelbeds;
	}

	public WebElement getViaSourceTbo() {
		return viaSourceTbo;
	}

	public WebElement getViaSourceQpx() {
		return viaSourceQpx;
	}

	public WebElement getViaSourceViator() {
		return viaSourceViator;
	}

	public WebElement getViaSourceViatorapi() {
		return viaSourceViatorapi;
	}

	public WebElement getViaSourceWeltravel() {
		return viaSourceWeltravel;
	}

	public WebElement getViaSourceSkypicker() {
		return viaSourceSkypicker;
	}

	public WebElement getViaSourceAmedous() {
		return viaSourceAmedous;
	}

	public WebElement getViaSourceItalo() {
		return viaSourceItalo;
	}

	public WebElement getViaSourceThrifty() {
		return viaSourceThrifty;
	}

	public WebElement getViaSourceGorental() {
		return viaSourceGorental;
	}

	public WebElement getViaSourceTravelbullz() {
		return viaSourceTravelbullz;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getEntity() {
		return entity;
	}

	public WebElement getEntityOption() {
		return entityOption;
	}

	public WebElement getOurCost() {
		return ourCost;
	}

	public WebElement getPublishedCost() {
		return publishedCost;
	}

	public WebElement getReason() {
		return reason;
	}

	public WebElement getReasonOption() {
		return reasonOption;
	}

	public WebElement getInclusionDate() {
		return inclusionDate;
	}

	public WebElement getFee() {
		return fee;
	}

	public WebElement getSaveAndCreate() {
		return saveAndCreate;
	}

	@FindBy(xpath="//span[@title='TBO']")
	WebElement viaSourceTbo;
	
	@FindBy(xpath="//span[@title='QPX']")
	WebElement viaSourceQpx;
	
	@FindBy(xpath="//span[@title='VIATOR']")
	WebElement viaSourceViator;
	
	@FindBy(xpath="//span[@title='VIATOR_API']")
	WebElement viaSourceViatorapi;
	
	@FindBy(xpath="//span[@title='WELTRAVEL']")
	WebElement viaSourceWeltravel;
	
	@FindBy(xpath="//span[@title='SKYPICKER']")
	WebElement viaSourceSkypicker;
	
	@FindBy(xpath="//span[@title='AMADEUS']")
	WebElement viaSourceAmedous;
	
	
	@FindBy(xpath="//span[@title='ITALO']")
	WebElement viaSourceItalo;
	
	@FindBy(xpath="//span[@title='THRIFTY']")
	WebElement viaSourceThrifty;
	
	@FindBy(xpath="//span[@title='GO_RENTAL']")
	WebElement viaSourceGorental;
	
	@FindBy(xpath="//span[@title='Travelbullz']")
	WebElement viaSourceTravelbullz;
	
	
	@FindBy(xpath="//div[@data-placeholder='Description']")
	WebElement description;

	@FindBy(xpath="//input[@id='customCardEntity']")
	WebElement entity;
	
	@FindBy(xpath="//span[text()='Activity']")
	WebElement entityOption;
	
	@FindBy(xpath="//input[@id='ourCost']")
	WebElement ourCost;
	
	@FindBy(xpath="//input[@id='publishedCost']")
	WebElement publishedCost;
	
	@FindBy(xpath="//input[@id='reasonForBlockCard']")
	WebElement reason;
	
	@FindBy(xpath="//span[text()='Transit Visa']")
	WebElement reasonOption;
	
	@FindBy(xpath="//input[@id='happensOn']")
	WebElement inclusionDate;
	
	@FindBy(xpath="//input[@id='cancellationTimelineList.0.fee'] | //input[@placeholder='Fee']")
	WebElement fee;
	
	@FindBy(xpath="//button[text()='Save & Create'] | //span[text()='Save & create']")
	WebElement saveAndCreate;
	

}
