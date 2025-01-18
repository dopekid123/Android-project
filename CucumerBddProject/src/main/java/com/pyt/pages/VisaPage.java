package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaPage {
	
	@FindBy(xpath = "//section[@class='visa']")
	WebElement visa_ViewDetails;
	
	@FindBy(xpath = "//section[contains(@class,'visa')]//button")
	WebElement visa_AddButton;
	
	@FindBy(xpath = "//section[@class='visa']//*/i[contains(@class,'delete')]")
	WebElement visa_RemoveButton;

	
	public WebElement getVisa_viewDetails() {
		return visa_ViewDetails;
	}

	public WebElement getVisa_AddVisa() {
		return visa_AddButton;
	}

	public WebElement getVisa_RemoveVisa() {
		return visa_RemoveButton;
	}

	
	

}
