package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoreWebVitalsPage {
	
	@FindBy(xpath="//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	@FindBy(xpath="(//div[contains(text(),'Open report')])[1]")
	WebElement mobileOpenReport;
	
	@FindBy(xpath="(//div[contains(text(),'Open report')])[2]")
	WebElement desktopOpenReport;
	
	@FindBy(xpath="(//div[contains(text(),'poor')])[1]")
	WebElement mobilePoorURLs;
	
	@FindBy(xpath="(//div[contains(text(),'poor')])[2]")
	WebElement desktopPoorURLs;
	
	@FindBy(xpath="(//div[contains(text(),'improvement')])[1]")
	WebElement mobileImprovementURLs;
	
	@FindBy(xpath="(//div[contains(text(),'improvement')])[2]")
	WebElement desktopImprovementURLs;
	
	@FindBy(xpath="(//div[contains(text(),'good')])[1]")
	WebElement mobileGoodURLs;
	
	@FindBy(xpath="(//div[contains(text(),'good')])[2]")
	WebElement desktopGoodURLs;
	
	@FindBy(xpath="(//div[contains(text(),'Details')])[2]")
	WebElement detailTab;
	
	@FindBy(xpath="//div[@title='Affected URLs']")
	WebElement affectedURLs;
	
	@FindBy(xpath="//a[@title='Core Web Vitals']")
	WebElement coreWebVitals;
	
	@FindBy(xpath="//span[contains(text(),'Status')]")
	WebElement status;

	

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getNextButton() {
		return nextButton;
	}
	
	public WebElement getMobileOpenReport() {
		return mobileOpenReport;
	}

	public WebElement getDesktopOpenReport() {
		return desktopOpenReport;
	}

	public WebElement getMobilePoorURLs() {
		return mobilePoorURLs;
	}

	public WebElement getDesktopPoorURLs() {
		return desktopPoorURLs;
	}

	public WebElement getMobileImprovementURLs() {
		return mobileImprovementURLs;
	}

	public WebElement getDesktopImprovementURLs() {
		return desktopImprovementURLs;
	}

	public WebElement getMobileGoodURLs() {
		return mobileGoodURLs;
	}

	public WebElement getDesktopGoodURLs() {
		return desktopGoodURLs;
	}
	
	public WebElement getDetailTab() {
		return detailTab;
	}

	public WebElement getAffectedURLs() {
		return affectedURLs;
	}
	
	public WebElement getCoreWebVitals() {
		return coreWebVitals;
	}
	
	public WebElement getStatus() {
		return status;
	}
	
}
