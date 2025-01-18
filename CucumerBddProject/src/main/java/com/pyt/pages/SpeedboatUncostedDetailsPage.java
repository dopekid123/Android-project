package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpeedboatUncostedDetailsPage {
	
	@FindBy(xpath = "//button[contains(text(),'Check availability')]")
	WebElement sbCheckAvailability;
	
	public WebElement getCheckAvailability() {
		return sbCheckAvailability;
	}

}
