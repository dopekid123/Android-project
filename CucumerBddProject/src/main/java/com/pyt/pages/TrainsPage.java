package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainsPage {
	
	
	@FindBy(xpath = "//button[contains(@class,'change-train')]")
	WebElement trainChangeButton;

	@FindBy(xpath = "(//*[@class='train-card'])[1]")
	WebElement trainReplaceButton;

	@FindBy(xpath = "(//section[@class='train-card'])[1]")
	WebElement trainReplaceFirstTrain;
	
	@FindBy(xpath ="//div/a[@title='2']")
	WebElement twoStopsTrainFilter;
	
	@FindBy(xpath ="//div/a[@title='1']")
	WebElement oneStopsTrainFilter;
	
	@FindBy(xpath ="//div/a[@title='No stops']")
	WebElement NoStopsTrainFilter;
	
	@FindBy(xpath = "//button[contains(text(),'Got it')]")
	WebElement priceAlertGotit;
	
	@FindBy(xpath = "//span[contains(text(),'Oops! No other trains found for the applied filters')]")
	WebElement noAlternateTrains;
	
	
	
	@FindBy(xpath = "(//a[@title='Early Morning'])[1]")
	WebElement depEarlyMorningTrains;

	@FindBy(xpath = "(//a[@title='Early Morning'])[2]")
	WebElement arrEarlyMorningTrains;

	@FindBy(xpath = "(//a[@title='Morning'])[1]")
	WebElement depMorningTrains;

	@FindBy(xpath = "(//a[@title='Morning'])[2]")
	WebElement arrMorningTrains;

	@FindBy(xpath = "(//a[@title='Mid-Day'])[1]")
	WebElement depMiddayTrains;

	@FindBy(xpath = "(//a[@title='Mid-Day'])[2]")
	WebElement arrMiddayTrains;

	@FindBy(xpath = "(//a[@title='Night'])[1]")
	WebElement depNightTrains;

	@FindBy(xpath = "(//a[@title='Night'])[2]")
	WebElement arrNightTrains;
	
	@FindBy(xpath = "(//a[@title='Evening'])[1]")
	WebElement depEveningTrains;
	
	@FindBy(xpath = "(//a[@title='Evening'])[2]")
	WebElement arrEveningTrains;
	

	@FindBy(xpath = "//img[contains(@src,'train')]")
	WebElement trainPanel;
	
	@FindBy(xpath = "//span[contains(text(),'No other trains')]")
	WebElement NoTrainsOption;
	
//	@FindBy(xpath = "//section[@class='subheader-modals']//button[@class='back-link']")
//	WebElement BackToInclusion;
	
	@FindBy(xpath = "//button[@class='back-link']")
	WebElement BackToInclusion;
	
	
	public WebElement getOnwardEveningTrains() {
		return depEveningTrains;
	}

	public WebElement getReturnEveningTrains() {
		return arrEveningTrains;
	}

	public WebElement getBackToInclusions() {
		return BackToInclusion;
	}

	public WebElement getNoTrainsOptions() {
		return NoTrainsOption;
	}
	
	public WebElement getTrainChangeButton() {
		return trainChangeButton;
	}

	public WebElement getTrainReplaceButton() {
		return trainReplaceButton;
	}

	public WebElement getTrainReplaceFirstTrain() {
		return trainReplaceFirstTrain;
	}
	
	public WebElement GotItPopUp() {
		
		return  priceAlertGotit;
	}
	
     public WebElement getNoStopTrains() {
		
		return NoStopsTrainFilter;
	}
     
     public WebElement getOneStopTrains() {
 		
 		return  oneStopsTrainFilter;
 	}
     
     public WebElement getTwoStopTrains() {
  		
  		return twoStopsTrainFilter;
  	}
     public WebElement getOnwardEarlyMorningTrains() {
 		return depEarlyMorningTrains;
 	}

 	public WebElement getReturnEarlyMorningTrains() {
 		return arrEarlyMorningTrains;
 	}

 	public WebElement getOnwardMorningTrains() {
 		return depMorningTrains;
 	}

 	public WebElement getReturnMorningTrains() {
 		return arrMorningTrains;
 	}

 	public WebElement getOnwardMiddayTrains() {
 		return depMiddayTrains;
 	}

 	public WebElement getReturnMiddayTrains() {
 		return arrMiddayTrains;
 	}

 	public WebElement getOnwardNightTrains() {
 		return depNightTrains;
 	}

 	public WebElement getReturnNightTrains() {
 		return arrNightTrains;
 	}


 	public WebElement getNoAlternateTrains() {
 		return noAlternateTrains;
 	}
 	
 	public WebElement getTrainPanel() {
 		return trainPanel;
 	}
     
   }
