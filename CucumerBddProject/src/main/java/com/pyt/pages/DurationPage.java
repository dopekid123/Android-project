package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DurationPage {

	
	public WebElement getDurationDur1() {
		return duration1;
	}

	public WebElement getDurationDur2() {
		return duration2;
	}

	public WebElement getDurationDur3() {
		return duration3;
	}

	public WebElement getDurationDur4() {
		return duration4;
	}

	@FindBy(xpath="//label[@for='pdg-duration-1']")
	private WebElement duration1;
	
	@FindBy(xpath="//div[@class='pdg-card n-tracker-hm-days-2']")
	private WebElement duration2;
	
	@FindBy(xpath="//div[@class='pdg-card n-tracker-hm-days-3']")
	private WebElement duration3;
	
	@FindBy(xpath="//div[@class='pdg-card n-tracker-hm-days-4']")
	private WebElement duration4;
	
}
