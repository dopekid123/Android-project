package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RazorPayPaymentPage {

	@FindBy(xpath = "//input[contains(@name,'card[number]')]")
	WebElement cardnumber;

	@FindBy(xpath = "//input[contains(@name,'card[expiry]')]")
	WebElement cardExpiryDate;

	@FindBy(xpath = "//input[contains(@name,'card[cvv]')]")
	WebElement cardcvv;

	@FindBy(xpath = "//input[contains(@name,'card[name]')]")
	WebElement cardHolderName;

	@FindBy(xpath = "//button[@id='pay-now']")
	WebElement paynowButton;

	@FindBy(xpath = "//button[@class='success']")
	WebElement paymentSuccessButton;

	@FindBy(xpath = "//button[@class='danger']")
	WebElement paymentFailiureButton;

	@FindBy(xpath = "//div[contains(@class,'checkbox')]//i")
	WebElement termsConditionsCheckBox;

	@FindBy(xpath = "//*[contains(@class,'cancel-btn')]/a")
	WebElement cancelTransactionButton;

	// *[contains(@class,'cancel-btn')]/a

	// *[contains(@class,'checkbox')]//input

	// button[@class='success']

	// button[@id='pay-now']

	public WebElement getcancelTransactionButton() {
		return cancelTransactionButton;
	}

	public WebElement gettermsConditionsCheckBox() {
		return termsConditionsCheckBox;
	}

	public WebElement getPaynowButton() {
		return paynowButton;
	}

	public WebElement getPaymentSuccessButton() {
		return paymentSuccessButton;
	}

	public WebElement getPaymentFailiureButton() {
		return paymentFailiureButton;
	}

	public WebElement getCardnumber() {
		return cardnumber;
	}

	public WebElement getCardExpiryDate() {
		return cardExpiryDate;
	}

	public WebElement getCardcvv() {
		return cardcvv;
	}

	public WebElement getCardHolderName() {
		return cardHolderName;
	}

}
