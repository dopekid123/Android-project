package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FerryPage {
	
	
	@FindBy(xpath ="(//span[contains(text(),'Transfer by flight')])[1]")
	WebElement flightInYourRoute;
	
	@FindBy(xpath ="(//span[contains(text(),'Replace Transfer')])[1]")
	WebElement replaceTransfer;
	
	@FindBy(xpath ="//div[contains(@class,'alternate-option')]//span[contains(@class,'pyt-ship')]")
	WebElement alternate_Ferry;
	
	@FindBy(xpath ="//section[contains(@class,'route-details')]//i[contains(@class,'pyt-ship')]")
	WebElement Ferry_section;
	
	
			
	public WebElement getFlightInYourRoute() {
		return flightInYourRoute;
	}
		
	public WebElement getReplaceTransfer() {
		return replaceTransfer;
	}
			
	public WebElement getAlternateFerry() {
		return  alternate_Ferry;
	}
				
	public WebElement getFerrySection() {
		return Ferry_section;
	}
	
	
	
	
	
	
}
