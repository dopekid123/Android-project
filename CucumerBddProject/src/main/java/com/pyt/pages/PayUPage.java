package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayUPage {
	
	@FindBy(xpath="//input[@id='cardNumber']")
	private WebElement cardNumberField;
	
	@FindBy(xpath="//input[@id='cardOwnerName']")
	private WebElement cardNameField;
	
	@FindBy(xpath="//input[@id='cardCvv']")
	private WebElement ccvvNumber;
	
	@FindBy(xpath="//input[@id='cardExpiry']")
	private WebElement expiryMonthDropDown;
	
	@FindBy(xpath="//select[@id='cexpiry_date_year']")
	private WebElement expiryYearhDropDown;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement payNowButton;
	
	@FindBy(xpath="(//a[contains(text(),'Click here to go back')])[1]")
    private WebElement cancelPaymentLink;
	
	//Xpath for alert message in the payment page for its non production env 
	@FindBy(xpath="//p[@id='isProductionError']")
	private WebElement NonProdConfirmation;
	
	// if payment failed the xpath is loacates the payment failure page representation image
	@FindBy(xpath="//*[@class='paymentfailure-img']")
	private WebElement paymentFailurePageImg;
	
	@FindBy(xpath="//a[contains(text(),'Go back and retry payment')]")
	private WebElement linkToBackItineraryPage;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement paymentOTP;
	
	@FindBy(xpath="//input[@id='submitBtn']")
	private WebElement paymentSubmit;
	
	@FindBy(xpath="//*[contains(text(),'AXIS SIMULATOR')]")
	private WebElement axisSimulator;
	
	@FindBy(xpath="//*[@id='cancelButton']")
	private WebElement paymentCancel;
	
	public WebElement getLinkToBackItineraryPage() {
		return linkToBackItineraryPage;
	}

	public WebElement getPaymentFailurePageImg() {
		return paymentFailurePageImg;
	}

	public WebElement getNonProdConfirmation() {
		return NonProdConfirmation;
		
	}

	public WebElement getCardNumberField() {
		return cardNumberField;
	}

	public WebElement getCardNameField() {
		return cardNameField;
	}

	public WebElement getCcvvNumber() {
		return ccvvNumber;
	}

	public WebElement getExpiryMonthDropDown() {
		return expiryMonthDropDown;
	}

	public WebElement getExpiryYearhDropDown() {
		return expiryYearhDropDown;
	}

	public WebElement getPayNowButton() {
		return payNowButton;
	}

	public WebElement getCancelPaymentLink() {
		return cancelPaymentLink;
	}
	
	public WebElement getAxisSimulator() {
		return axisSimulator;
	}
	public WebElement getPaymentOTPTxtBox() {
		return paymentOTP;
	}
	public WebElement getPaymentSubmit() {
		return paymentSubmit;
	}
	public WebElement getPaymentCancel() {
		return paymentCancel;
	}
	
}
