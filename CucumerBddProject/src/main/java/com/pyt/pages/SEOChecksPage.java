package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SEOChecksPage {
	
	@FindBy(xpath = "//title")
	WebElement seoTitle;
	
	@FindBy(xpath = "//h1")
	WebElement seoH1;
	
	@FindBy(xpath = "//head/meta[@name='description']")
	WebElement seoMeta;
	
	@FindBy(xpath = "//span[contains(text(),'Have a question?')]")
	WebElement seoCBRPopUpTitle;
	
	@FindBy(xpath = "//button[text()=' Request callback']")
	WebElement seoRcb;
	
	@FindBy(xpath = "//link[@rel='canonical']")
	WebElement seoCanonical;
	
	@FindBy(xpath = "//button[text()='Create Now']")
	WebElement seoCreateNow;
	
	@FindBy(xpath = "//span[contains(text(),'Now Planning your holiday')]")
	WebElement seoPDG;
	
	@FindBy(xpath = "(//div[@itemprop='name']/a)[1]")
	WebElement seoSlugItinerary;
	
	@FindBy(xpath = "//button[text()='View Price']")
	WebElement seoSlugPrice;
	
	@FindBy(xpath = "(//div[@role='dialog']//*[name()='svg'])[2]")
	WebElement seoRcbClose;
	
	
	public WebElement getSeoRcbClose() {
		return seoRcbClose;
	}

	public WebElement getSeoSlugPrice() {
		return seoSlugPrice;
	}

	public WebElement getSeoSlugItinerary() {
		return seoSlugItinerary;
	}

	public WebElement getSeoPDG() {
		return seoPDG;
	}

	public WebElement getSeoCreateNow() {
		return seoCreateNow;
	}

	public WebElement getSeoCanonical() {
		return seoCanonical;
	}

	public WebElement getSeoTitle() {
		return seoTitle;
	}
	
	public WebElement getSeoH1() {
		return seoH1;
	}

	public WebElement getSeoMeta() {
		return seoMeta;
	}

	public WebElement getSeoCBRPopUpTitle() {
		return seoCBRPopUpTitle;
	}

	public WebElement getSeoRcb() {
		return seoRcb;
	}

	public void setSeoH1(WebElement seoH1) {
		this.seoH1 = seoH1;
	}
	
	
	

}
