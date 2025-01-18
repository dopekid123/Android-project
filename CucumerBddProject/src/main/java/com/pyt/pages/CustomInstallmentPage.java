package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomInstallmentPage {
	
	
	
	@FindBy(xpath="//div[contains(text(),'Create')]")
	WebElement createCustom;
	
	@FindBy(xpath="(//div[contains(text(),'Instalment')])[1]//parent::div//following-sibling::div[1]//input")
	WebElement firstInstalmentAmount;
	
	@FindBy(xpath="(//div[contains(text(),'Instalment')])[2]//parent::div//following-sibling::div[1]//input")
	WebElement secondInstalmentAmount;
	
	@FindBy(xpath="//div[contains(text(),'Reason for custom')]//following::textarea")
	WebElement reasonCustomInstalment;
	
	@FindBy(xpath="(//div[contains(text(),'Create')])[2]")
	WebElement createInstalmentCTA;
	
	@FindBy(xpath="//div[contains(text(),'Edit')]")
	WebElement instalmentAdded;
	
	@FindBy(xpath="//div[contains(text(),'Pay just')]")
	WebElement userFirstInstalmentAmt;
	
	@FindBy(xpath="(//div[contains(text(),'Instalment ')])[1]//following::div[5]")
	WebElement paymentScreenFirstInstalment;
	
	@FindBy(xpath="(//div[contains(text(),'Instalment ')])[2]//following::div[6]")
	WebElement paymentScreenSecondInstalment;
	
	
	public WebElement getPaymentScreenSecondInstalment() {
		return paymentScreenSecondInstalment;
	}
	
	public WebElement getPaymentScreenFirstInstalment() {
		return paymentScreenFirstInstalment;
	}
	
	
	public WebElement getUserFirstInstalmentAmt() {
		return userFirstInstalmentAmt;
	}
	
	public WebElement getInstalmentAdded() {
		return instalmentAdded;
	}
	
	public WebElement getCreateInstalmentCT() {
		return createInstalmentCTA;
	}
	
	
	public WebElement getReasonCustomInstalment() {
		return reasonCustomInstalment;
	}
	
	public WebElement getSecondInstalmentAmount() {
		return secondInstalmentAmount;
	}

	public WebElement getFirstInstalmentAmount() {
		return firstInstalmentAmount;
	}

	
	public WebElement getCreateCustom() {
		return createCustom;
	}

	
	
	
	
	
	
	
	
	

}
