package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingPage {

	@FindBy(xpath = "//span[contains(@class,'pyt-faq')]")
	WebElement priceToolTip;

	@FindBy(xpath = "//span[contains(text(),'Trip cost')]//following::span[1]")
	WebElement tripCost;

	@FindBy(xpath = "//span[contains(text(),'gst')]//following::span[1]")
	WebElement gstPrice;

	@FindBy(xpath = "//span[contains(text(),'tcs')]//following::span[1]")
	WebElement tcsPrice;
	
	@FindBy(xpath = "//div[contains(text(),'Total cost')]/../../div[2]/div")
	WebElement priceToolTipOnDiscountModal;
	
	@FindBy(xpath = "//span[contains(text(),'Total Cost')]//following::span[1]")
	WebElement totalCost;
	
	
	public WebElement getTotalCost() {
		return totalCost;
	}

	public WebElement getPriceToolTipOnDiscountModal() {
		return priceToolTipOnDiscountModal;
	}

	public WebElement getPriceToolTip() {
		return priceToolTip;
	}
	public WebElement getTripCost() {
		return tripCost;
	}

	public WebElement getGstPrice() {
		return gstPrice;
	}

	public WebElement getTcsPrice() {
		return tcsPrice;
	}

}
