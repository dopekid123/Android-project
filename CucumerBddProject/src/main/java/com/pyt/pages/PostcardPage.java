package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostcardPage {
	
	@FindBy(xpath="//input[@name='name']")
	WebElement enterName;


	@FindBy(xpath="//input[@name='email']")
	WebElement enterEmail;
	
	@FindBy(xpath="//button[contains(text(),'Get Notified')]")
	WebElement notified;
	
	@FindBy(xpath="//p[@class='mbottom-large color-grey-secondary medium-heading text-center']")
	WebElement thankYou;
	
	@FindBy(xpath="//div[@class='clearfix content-wrap']//li[1]//a[1]")
	WebElement noPostcard;
	
	@FindBy(xpath="//*[text()=\"Yes! I'm game\"]")
	WebElement unwrappedDest;
	
	@FindBy(xpath="//select[@name='adults']")
	WebElement adults;

	@FindBy(xpath="//select[@name='departureCity']")
	WebElement departureCity;
	

	@FindBy(xpath="//select[@name='date']")
	WebElement date;

	@FindBy(xpath="//select[@name='budget']")
	WebElement budget;
	
	@FindBy(xpath="//input[@name='request-callback-mobile-number']")
	WebElement mobile;
	
	@FindBy(xpath="//button[@id='send_post_desktop']")
	WebElement planThisTripButton;
	
	@FindBy(xpath="//span[@class='postcard_cheers vmargin-large']")
	WebElement cheers;
	
	
	@FindBy(xpath="//span[contains(text(),'Name must be at least 3 characters in length')]")
	WebElement incorrectName;

	
	@FindBy(xpath="//span[contains(text(),'Enter a valid email address')]")
	WebElement incorrectMail;
	
	@FindBy(xpath="//select[@name='destination']")
	WebElement destinationDropdown;
	

	
	public WebElement getDestinationDropdown() {
		return destinationDropdown;
	}
	
	public WebElement getIncorrectName() {
		return incorrectName;
	}

	public WebElement getIncorrectMail() {
		return incorrectMail;
	}

	public WebElement getCheers() {
		return cheers;
	}

	public WebElement getPlanThisTripButton() {
		return planThisTripButton;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getDepartureCity() {
		return departureCity;
	}
	
	public WebElement getDate() {
		return date;
	}


	public WebElement getBudget() {
		return budget;
	}

	public WebElement getAdults() {
		return adults;
	}


	public WebElement getUnwrappedDest() {
		return unwrappedDest;
	}


	public WebElement getNoPostcard() {
		return noPostcard;
	}


	public WebElement getThankYou() {
		return thankYou;
	}


	public WebElement getEmail() {
		return enterEmail;
	}


	public WebElement getName() {
		return enterName;
	}
	
	
	public WebElement getNotified() {
		return notified;
	}

	
	
}
