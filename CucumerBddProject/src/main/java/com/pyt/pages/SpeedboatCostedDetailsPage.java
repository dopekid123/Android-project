package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpeedboatCostedDetailsPage {
	
	@FindBy(xpath = "//button[contains(text(),'Book now')]")
	WebElement sbBookNow;
	
	@FindBy(xpath = "//button[contains(@class,'change-cta')]")
	WebElement sbChangeRoom;
	
	@FindBy(xpath = "//button[contains(text(),'Choose')]")
	WebElement sbChooseRoom;
	
	@FindBy(xpath = "//div[@id='fullStay-tab']/div[@class='room-card']")
	List <WebElement> sbFullStayRoomList;
	
	@FindBy(xpath = "//div[@id='fullStay-tab']//div[@id='pricetxt']/button[contains(text(),'Choose')]")
	WebElement sbChooseFullStayRoom;
	
	@FindBy(xpath = "//li/a[contains(text(),'Split Stay')]")
	WebElement sbSplitStayTab;
	
	@FindBy(xpath = "//div[@id='splitStay-tab']/div[@class='room-card']")
	List <WebElement> sbSplitStayRoomList;
	
	@FindBy(xpath = "//div[@id='splitStay-tab']//div[@id='pricetxt']/button[contains(text(),'Choose')]")
	WebElement sbChooseSplitStayRoom;
	
	@FindBy(xpath = "//button[contains(text(),'Choose another room')]")
	WebElement sbChooseAlternateRoom;
	
	public WebElement getsbChooseAlternateRoom() {
		return sbChooseAlternateRoom;
	}
	public WebElement getBookNow() {
		return sbBookNow;
	}
	
	public WebElement getChangeRoom() {
		return sbChangeRoom;
	}
	
	public WebElement getChooseRoom() {
		return sbChooseRoom;
	}
	
	public List<WebElement> getFullStayRoomList() {
		return sbFullStayRoomList;
	}
	
	public WebElement getAlternateFullStayRoom() {
		return sbChooseFullStayRoom;
	}
	
	public WebElement chooseSplitStayTab() {
		return sbSplitStayTab;
	}
	
	public List<WebElement> getSplitStayRoomList() {
		return sbSplitStayRoomList;
	}
	
	public WebElement getAlternateSplitStayRoom() {
		return sbChooseSplitStayRoom;
	}

}
