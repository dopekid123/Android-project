package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {

	// button[contains(@class,'paynow-100')]

	@FindBy(xpath = "//button[contains(@class,'paynow-100')]")
	WebElement payHundredPercentButton;

	@FindBy(xpath = "//button[contains(@class,'paynow-70')]")
	WebElement paySeventyPercentButton;

	@FindBy(xpath = "//button[contains(@class,'paynow-50')]")
	WebElement payFiftyPercentButton;

	//Payment success page link to your vacations 
	
	@FindBy(xpath="//a[contains(text(),'Your Vacations')]")
	WebElement paymentSuccessYourVacation;
	
	
	public WebElement getPaymentSuccessYourVacation() {
		return paymentSuccessYourVacation;
	}

	public WebElement getPayHundredPercentButton() {
		return payHundredPercentButton;
	}

	public WebElement getPaySeventyPercentButton() {
		return paySeventyPercentButton;
	}

	public WebElement getPayFiftyPercentButton() {
		return payFiftyPercentButton;
	}

}
