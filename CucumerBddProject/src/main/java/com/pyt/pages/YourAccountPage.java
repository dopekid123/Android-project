package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class YourAccountPage {
	
	//YourAccount Edit Details XPATH
	
	@FindBy(xpath=("//span[@class='user-initials']"))
	WebElement userinitials;


	@FindBy(xpath=("//a[@class='n-tracker-youraccount']"))
	WebElement youraccount;


	@FindBy(xpath=("//button[@id='editGeneral']"))
	WebElement editdetails;


	@FindBy(xpath=("//label[contains(text(),'Name')]/following::input[1]"))
	WebElement name;


	@FindBy(xpath=("//label[contains(text(),'Address Line 1')]/following::input[1]"))
	WebElement addressline1;



	@FindBy(xpath=("//label[contains(text(),'Address Line 2')]/following::input[1]"))
	WebElement addressline2;



	@FindBy(xpath=("//label[contains(text(),'Address Line 3')]/following::input[1]"))
	WebElement addressline3;


	@FindBy(xpath=("//label[contains(text(),'State')]/following::input[1]"))
	WebElement state;


	@FindBy(xpath=("//label[contains(text(),'Pincode')]/following::input[1]"))
	WebElement pincode;



	@FindBy(xpath=("//button[@id='updateGeneral']"))
	WebElement update;


	@FindBy(xpath=("//button[@class='confirm']"))
	WebElement submit;

//Preferences XPATH

	@FindBy(xpath=("//a[text()='Preferences' and @href='#' ]"))
	WebElement preferences;


	@FindBys(@FindBy(xpath="//input[@type='checkbox']/../i"))
	private List<WebElement> checkboxlist;

	@FindBy(xpath="//input[@checked]/../i")
	WebElement checked;


	@FindBy(xpath=("//button[@type='button']"))
	WebElement save;


	@FindBy(xpath=("//span[text()='Opt me out of all communications']"))
	WebElement reset;
	
//ChangePassword XPATH
	
	@FindBy(xpath=("//button[@id='editPassword']"))
	WebElement changepassword;

//	change tab to loyalty credit
	
	@FindBy(xpath=("//ul[contains(@class,'clearfix list-unstyled tab-links')]/li/a[contains(text(),'Loyalty Credits')]"))
	WebElement loyaltyCreditTab;
	
	//international credits and domestic coins
	
	@FindBy(xpath=("(//p[contains(@class,'YourAccountLoyaltyCredits__CostText')])[1]"))
	WebElement internationalCreditCoins;
	
	@FindBy(xpath=("(//p[contains(@class,'YourAccountLoyaltyCredits__CostText')])[2]"))
	WebElement domesticCoins;

	public WebElement getDomesticCoins() {
		return domesticCoins;
	}


	public WebElement getInternationalCreditCoins() {
		return internationalCreditCoins;
	}


	public WebElement getLoyaltyCreditTab() {
		return loyaltyCreditTab;
	}


	public WebElement getYourAccount() {
		return youraccount;
	}


	public WebElement getUserInitials() {
		return userinitials ;
	}

	public WebElement getEditDetails() {
		return editdetails ;
	}

	public WebElement getNameDetails() {

		return name;
	}

	public WebElement getAddressLine1() {

		return addressline1;
	}

	public WebElement getAddressLine2() {

		return addressline2;

	}	

	public WebElement getAddressLine3() {

		return addressline3;

	}		

	public WebElement getState() {

		return state;

	}		

	public WebElement getPincode() {

		return pincode;

	}		

	public WebElement getUpdate() {

		return update;

	}
   
	public WebElement getSubmit() {

		return submit;

	}

	public WebElement getPreferences() {

		return preferences;
	}

	public List<WebElement> getCheckboxList() {

		return checkboxlist ;
	}


	public WebElement getSaveButton() {

		return save;
	}

	public WebElement getResetOptions() {

		return reset;
	}


	public WebElement getChecked() {

		return checked;
	}
	
	public WebElement getChangePassword() {

		return changepassword;
	}


}