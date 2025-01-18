package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SunSiyamResortAvailabilityPage {
	
	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement srUsername;
	
	@FindBy(id = "user_pass")
	private WebElement srPassword;
	
	@FindBy(id = "wp-submit")
	private WebElement srLogin;
	
	@FindBy(xpath = "(//i[contains(@class,'la-times')])[2]")
	private WebElement srOffersPopup;
	
	@FindBy(id = "download-pdf")
	private WebElement srDownloadPdf;
	
	@FindBy(xpath="//select[@id='filter-field']")
	private WebElement srPropertyDropdown;
	
	
	public WebElement getSrUsername() {
		return srUsername;
	}

	public WebElement getSrPassword() {
		return srPassword;
	}

	public WebElement getSrLogin() {
		return srLogin;
	}
	
	public WebElement getsrOffersPopup()
	{
		return srOffersPopup;
	}
	
	public WebElement getSrDownloadPdf()
	{
		return srDownloadPdf;
	}
	
	public WebElement getSrPropertyDropdown()
	{
		return srPropertyDropdown;
	}

}
