package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShareItineraryPage {
	
	@FindBy(xpath="//span[contains(text(),'Share Itinerary')]")
	WebElement shareItinerary;
	
	@FindBy(xpath="//div[@class='veho-c-lesPJm']//button[@role='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//div[@class='veho-c-lesPJm']//button[@role='checkbox']")
	List<WebElement> alertCheckBox;
	
	@FindBy(xpath="//button[text()='Acknowledged']")
	WebElement acknowledged;
	
	@FindBy(xpath="//input[@class='PhoneInputInput']")
	WebElement enterPhoneNumber;
	
	@FindBy(xpath="//button[text()='Fetch accounts']")
	WebElement fetchAccounts;
	
	@FindBy(xpath="//p[contains(text(),'Fetched User:')] ")
	WebElement fetchedUser;
	
	@FindBy(xpath="//textarea[@placeholder='Type here...']")
	WebElement callNotes;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="(//label[text()='Trail source']/following::div/div//button[@aria-label='toggle menu'])[1]")
	WebElement trailSource;
	
	@FindBy(xpath="(//label[text()='Flow & method']/following::div/div//button[@aria-label='toggle menu'])[1]")
	WebElement flowAndMethod;
	
	@FindBy(xpath="//span[text()='Blog']")
	WebElement trailSourceOption;
	
	@FindBy(xpath="//span[text()='Called In']")
	WebElement flowAndMethodOption;
	
	@FindBy(xpath="//label[text()='Enter mobile number or email to fetch accounts']/following::span[text()='Change']")
	WebElement changeNumber;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//p[text()='No accounts found for the given contact. Please create new one']")
	WebElement noAccountFound;
	
	@FindBy(xpath="(//label[text()='Occassion']/following::div/div//button[@aria-label='toggle menu'])[1]")
	WebElement occassion;
	
	@FindBy(xpath="//button[@id='ANNIVERSARY']")
	WebElement occassionOption;
	
	@FindBy(xpath="//h1[contains(text(),'Your itinerary is on its way to your inbox.')]")
	WebElement shareConfirmation;
	
	@FindBy(xpath="//label[text()='Occassion']/following::div/button[@class='veho-c-jBhkpN veho-c-jBhkpN-iLRduI-css']")
	WebElement errorInOccassion;

	public WebElement getErrorInOccassion() {
		return errorInOccassion;
	}

	public List<WebElement> getAlertCheckBox() {
		return alertCheckBox;
	}

	public WebElement getShareConfirmation() {
		return shareConfirmation;
	}

	public WebElement getShareItinerary() {
		return shareItinerary;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getAcknowledged() {
		return acknowledged;
	}

	public WebElement getEnterPhoneNumber() {
		return enterPhoneNumber;
	}

	public WebElement getFetchAccounts() {
		return fetchAccounts;
	}

	public WebElement getFetchedUser() {
		return fetchedUser;
	}

	public WebElement getCallNotes() {
		return callNotes;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getTrailSource() {
		return trailSource;
	}

	public WebElement getFlowAndMethod() {
		return flowAndMethod;
	}

	public WebElement getTrailSourceOption() {
		return trailSourceOption;
	}

	public WebElement getFlowAndMethodOption() {
		return flowAndMethodOption;
	}

	public WebElement getChangeNumber() {
		return changeNumber;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getNoAccountFound() {
		return noAccountFound;
	}

	public WebElement getOccassion() {
		return occassion;
	}

	public WebElement getOccassionOption() {
		return occassionOption;
	}

}
