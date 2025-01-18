package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlockingDatesPage {
	
	@FindBy(xpath="(//div[contains(@class,'totalplantotravel')]/div)[3]")
	private  WebElement select2ndMonthfromList;
	
	@FindBy(xpath="//span[@class='date-txt' and text()='21']")
	private  WebElement selectDatefromCalender;
	
	public WebElement getMonth() {
		return select2ndMonthfromList;
	}
	
	public WebElement getDate() {
		return selectDatefromCalender;
	}
	
	public WebElement getOctober() {
		return october;
	}
	public WebElement getSeptember() {
		return september;
	}
	public WebElement getNovember() {
		return november;
	}
	public WebElement getDecember() {
		return december;
	}
	public WebElement getJanuary() {
		return january;
	}
	public WebElement getFebruary() {
		return february;
	}
	public WebElement getMarch() {
		return march;
	}
	public WebElement getApril() {
		return april;
	}
	public WebElement getMay() {
		return may;
	}
	public WebElement getJune() {
		return june;
	}
	public WebElement getJuly() {
		return july;
	}
	public WebElement getAugust() {
		return august;
	}
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-october pdg-card']")
	private  WebElement october;
	
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-september pdg-card']")
	private  WebElement september;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-november pdg-card']")
	private  WebElement november;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-december pdg-card']")
	private  WebElement december;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-january pdg-card']")
	private  WebElement january;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-february pdg-card']")
	private  WebElement february;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-march pdg-card']")
	private  WebElement march;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-april pdg-card']")
	private  WebElement april;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-may pdg-card']")
	private  WebElement may;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-june pdg-card']")
	private  WebElement june;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-july pdg-card']")
	private  WebElement july;
	@FindBy(xpath="//div[@class='n-tracker-plantotravel-august pdg-card']")
	private  WebElement august;
}
