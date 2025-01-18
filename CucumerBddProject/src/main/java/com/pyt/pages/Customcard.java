package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Customcard {
	
	@FindBy(xpath="//button[text()='Add Custom Item']")
	WebElement addCustomItem;
	
	@FindBy(xpath="//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iiekHLJ-css']")
	WebElement totalCost;
	
	@FindBy(xpath="//span[text()='View split pricing']")
	WebElement viewFullPricing;
	
	@FindBy(xpath="//span[contains(text(),'Other')]")
	WebElement otherRight;
	
	@FindBy(xpath="//span[contains(text(),'Other')]/following::span[1]")
	WebElement otherCostRight;
	
	@FindBy(xpath="(//div[@name='more']//span[text()='Remove'])[last()]")
	WebElement removeCustomItem;
	
	@FindBy(xpath="(//div[@name='more']//span[text()='Edit Card'])[last()]")
	WebElement editCustomItem;
	
	@FindBy(xpath="(//div[@class='veho-c-jYcofd veho-c-dQPjFX veho-c-jYcofd-igLSOi-css']//*[name() = 'svg'])[1] | //i[@class='pyt-close-16 close-icon']")
	WebElement closeCustomItem;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement cardTitle;
	
	@FindBy(xpath="//input[@id='source']")
	WebElement source;
	
	@FindBy(xpath="//span[@title='EXPEDIA']")
	WebElement viatorSource;

	@FindBy(xpath="//input[@id='customCardEntity']")
	WebElement entity;
	
	@FindBy(xpath="//input[@id='ourCost']")
	WebElement ourCost;
	
	@FindBy(xpath="//input[@id='publishedCost']")
	WebElement publishedCost;
	
	@FindBy(xpath="//input[@id='reasonForBlockCard']")
	WebElement reason;
	
	@FindBy(xpath="//input[@id='happensOn']")
	WebElement inclusionDate;
	
	@FindBy(xpath="(//div[contains(@class,'react-datepicker__day--keyboard-selected') and contains(@aria-label,'day')])[1]")
	WebElement inclusionDatePicker;
	
	@FindBy(xpath="//input[@id='cancellationTimelineList.0.fee'] | //input[@placeholder='Fee']")
	WebElement fee;
	
	@FindBy(xpath="//div[@data-placeholder='Description']")
	WebElement description;
	
	@FindBy(xpath="//button[text()='Save & Create'] | //span[text()='Save & create']")
	WebElement saveAndCreate;
	
	@FindBy(xpath="//span[text()='Activity']")
	WebElement entityOption;
	
	@FindBy(xpath="//span[text()='Transit Visa']")
	WebElement reasonOption;
	
	@FindBy(xpath="//div[text()='Name of the hotel']")
	WebElement nameOfHotel;
	
	@FindBy(xpath="(//div[contains(@class,' css-1hwfws3')])[1]")
	WebElement internetSource;
	
	@FindBy(xpath="//div[text()='EXPEDIA']")
	WebElement internetSourceOption;
	
	@FindBy(xpath="//div[text()='Reason for block card']")
	WebElement reasonForBlockCard;
	
	@FindBy(xpath="//div[text()='Specific hotel NA on product']")
	WebElement reasonForBlockCardOption;
	
	@FindBy(xpath="//input[@id='checkInTime']")
	WebElement checkInTime;
	
	@FindBy(xpath="//input[@id='checkOutTime']")
	WebElement checkOutTime;
	
	@FindBy(xpath="(//div[contains(text(),'Room')])[1]")
	WebElement room;
	
	@FindBy(xpath="//input[@placeholder='Room Category']")
	WebElement roomCategory;
	
	@FindBy(xpath="//input[@placeholder='Net Cost']")
	WebElement netCost;
	
	@FindBy(xpath="//div[@name='stay']//div[@class='veho-c-lesPJm veho-c-lesPJm-icjIolg-css']")
	WebElement cardmle;
	
	@FindBy(xpath="//div[@name='stay']//button[text()='On Request']")
	WebElement customcardmle;
	
	
	
	public WebElement getCustomcardmle() {
		return customcardmle;
	}

	public WebElement getNameOfHotel() {
		return nameOfHotel;
	}

	public WebElement getInternetSource() {
		return internetSource;
	}

	public WebElement getInternetSourceOption() {
		return internetSourceOption;
	}

	public WebElement getReasonForBlockCard() {
		return reasonForBlockCard;
	}

	public WebElement getReasonForBlockCardOption() {
		return reasonForBlockCardOption;
	}

	public WebElement getCheckInTime() {
		return checkInTime;
	}

	public WebElement getCheckOutTime() {
		return checkOutTime;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRoomCategory() {
		return roomCategory;
	}

	public WebElement getNetCost() {
		return netCost;
	}

	public WebElement getCardmle() {
		return cardmle;
	}

	public WebElement getEntityOption() {
		return entityOption;
	}

	public WebElement getReasonOption() {
		return reasonOption;
	}

	public WebElement getViatorSource() {
		return viatorSource;
	}

	public WebElement getInclusionDate() {
		return inclusionDate;
	}

	public WebElement getInclusionDatePicker() {
		return inclusionDatePicker;
	}

	public WebElement getFee() {
		return fee;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSaveAndCreate() {
		return saveAndCreate;
	}

	public WebElement getAddCustomItem() {
		return addCustomItem;
	}

	public WebElement getTotalCost() {
		return totalCost;
	}

	public WebElement getViewFullPricing() {
		return viewFullPricing;
	}

	public WebElement getOtherRight() {
		return otherRight;
	}

	public WebElement getOtherCostRight() {
		return otherCostRight;
	}

	public WebElement getRemoveCustomItem() {
		return removeCustomItem;
	}

	public WebElement getEditCustomItem() {
		return editCustomItem;
	}

	public WebElement getCloseCustomItem() {
		return closeCustomItem;
	}

	public WebElement getCardTitle() {
		return cardTitle;
	}

	public WebElement getSource() {
		return source;
	}

	public WebElement getEntity() {
		return entity;
	}

	public WebElement getOurCost() {
		return ourCost;
	}

	public WebElement getPublishedCost() {
		return publishedCost;
	}

	public WebElement getReason() {
		return reason;
	}

	
	

}
