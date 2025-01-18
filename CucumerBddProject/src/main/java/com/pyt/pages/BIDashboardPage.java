package com.pyt.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class BIDashboardPage {

    
	@FindBy(xpath = "//i[@title='Next Page']")
	WebElement nextPage;
	
	@FindBy(xpath = "//i[@title='Previous Page']")
	WebElement previousPage;

	public WebElement getNextPage() {
		return nextPage;
	}
	
	//nothing needed giot purpose
	public WebElement getPreviousPage() {
		return previousPage;
	}
	
	public WebElement getPreviousPage() {
		return previousPage;
	}
	

	}
