package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StaycationDealsPage {
	
	//a[contains(@class,'Desktop__Card')]
	

	@FindBy(xpath = "//a[contains(@display,'inline-block')]")
    WebElement cityCard;
	
	@FindBy(xpath="//ul[contains(@class,'DetailsNavigator')]")
	WebElement detailsNavigator;
	
	@FindBy (xpath="//div[contains(@class,'DealCardComponent__DealsCard')][1]")
	WebElement dealsCard;
	
	
	@FindBy (xpath="//li[contains(@class,'DropdownMenuItem')]//input[@name='budgets']/../span")
	List<WebElement> budgetFilterStaycationListingPage;
	
	@FindBy(xpath="//li[contains(@class,'DropdownMenuItem')]//input[@name='dealDepartureCities']/../span")
	List<WebElement> dealsFromFilterStaycationListingPage;
	
	@FindBy(xpath="//li[contains(@class,'DropdownMenuItem')]//input[@name='categories']/../span")
	List<WebElement> categoriesFilterStaycationListingPage;
	
	@FindBy(xpath="//li[contains(@class,'DropdownMenuItem')]//input[@name='dealTypes']/../span")
	List<WebElement> themeFilterStaycationListingPage;
	
	@FindBy(xpath="//li[contains(@class,'DropdownMenuItem')]//input[@name='countries']/../span")
	List<WebElement> destinationFilterStaycationListingPage;

    @FindBy(xpath="//div[contains(@class,'DropdownMenuFooter')]//button[text()='Apply']")
    List<WebElement> applyFilterButton;
	
	@FindBy(xpath="(//div[contains(text(),'Price')])[1]")
	WebElement priceFilterButton;
	
	//Reset filter button for deals from filter alone 
	@FindBy(xpath="(//div[contains(@class,'DropdownMenuFooter')]//button[text()='Reset'])[1]")
	WebElement resetFilterButton;
	
	@FindBy(xpath="(//div[contains(@class,'DropdownMenuFooter')]//button[text()='Reset'])[2]")
	WebElement priceResetFilterButton;
	
	@FindBy(xpath="(//div[contains(@class,'DropdownMenuFooter')]//button[text()='Reset'])[3]")
	WebElement categoryResetFilterButton;
	
	@FindBy(xpath="(//div[contains(@class,'DropdownMenuFooter')]//button[text()='Reset'])[4]")
	WebElement themeResetFilterButton;
	
	@FindBy(xpath="(//div[contains(@class,'DropdownMenuFooter')]//button[text()='Reset'])[5]")
	WebElement destinationResetFilterButton;
	
	@FindBy(xpath="(//div[contains(text(),'Deals from')])[1]")
	WebElement dealsFromFilterButton;
	
	@FindBy(xpath="(//div[contains(text(),'Category')])[1]")
	WebElement categoryFilterButton;
	
	@FindBy(xpath="(//div[contains(text(),'Destinations')])[1]")
	WebElement destinationFilterButton;
	
	@FindBy(xpath="(//div[contains(text(),'Theme')])[1]")
	WebElement themeFilterButton;
	
	@FindBy(xpath="(//button[contains(text(),'Book this deal')])")
	WebElement bookdealbutton;
	
	@FindBy(xpath="(//div[contains(@class,'DealsListing__ListingCardContainer')]//div[contains(@class,'DealCardComponent__DealsCard')])")
	WebElement cityFirstCard;
	
	@FindBy(xpath="(//div[contains(@class,'DealsListing__ListingCardContainer')]//div[contains(@class,'DealCardComponent__DealsCard')]//span[contains(@class,'AboutDealCard__DealTitle')])")
	WebElement cardtitle;
	
	public WebElement getCardTitle() {
		return cardtitle;
	}
	 
	public WebElement getCityFirstCard() {
		return cityFirstCard;
	}
	
	public WebElement getPriceResetFilterButton() {
		return priceResetFilterButton;
	}
	
	public WebElement getCategoryResetFilterButton() {
		return categoryResetFilterButton;
	}

	
	public WebElement getThemeResetFilterButton() {
		return themeResetFilterButton;
	}
	
	public WebElement getDestinationResetFilterButton() {
		return destinationResetFilterButton;
	}
	
	public WebElement getDealsFromFilterButton() {
		return dealsFromFilterButton;
	}


	public WebElement getCategoryFilterButton() {
		return categoryFilterButton;
	}


	public WebElement getDestinationFilterButton() {
		return destinationFilterButton;
	}


	public WebElement getThemeFilterButton() {
		return themeFilterButton;
	}


	public List<WebElement> getCategoriesFilterStaycationListingPage() {
		return categoriesFilterStaycationListingPage;
	}


	public List<WebElement> getThemeFilterStaycationListingPage() {
		return themeFilterStaycationListingPage;
	}


	public List<WebElement> getDestinationFilterStaycationListingPage() {
		return destinationFilterStaycationListingPage;
	}


	public List<WebElement> getDealsFromFilterStaycationListingPage() {
		return dealsFromFilterStaycationListingPage;
	}


	public WebElement getResetFilterButton() {
		return resetFilterButton;
	}

	public WebElement getPriceFilterButton() {
		return priceFilterButton;
	}

	public List<WebElement> getApplyFilterButton() {
		return applyFilterButton;
	}

	public List<WebElement> getBudgetFilterStaycationListingPage() {
		return budgetFilterStaycationListingPage;
		
	}

	public WebElement getDetailsNavigator() {
		return detailsNavigator;
	}

	public WebElement getCityCard() {
		return cityCard;
	}
	
	
	public WebElement getDealsCard() {
		return dealsCard;
	}
	
	public WebElement getBookDealButton() {
		return bookdealbutton;
	}
}
