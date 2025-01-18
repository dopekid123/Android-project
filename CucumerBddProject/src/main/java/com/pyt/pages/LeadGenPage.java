package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadGenPage {
	
	
	@FindBy(xpath="//textarea[@name='q']")
	WebElement googlesearchbar;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement platoUserName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement platoPassword;
	
	@FindBy(xpath="//div[text()='Sign in']")
	WebElement platoSignInBtn;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement platoSearchField;
	
	@FindBy(xpath="//table[contains(@class,'table search_list_view')]")
	WebElement platoTrailResultTable;
	
	@FindBy(xpath="//a[@class='update_table_settings']")
	WebElement platoSettings;
	
//	@FindBy(xpath="//div[@data-title='Add call notes'] | //*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[10]")
	@FindBy(xpath="//*[@id='DataTables_Table_0']/tbody/tr[1]/td[10]")
	WebElement platoMobileNoOnTable;
	
	@FindBy(xpath="//label[text()='Activation Source']")
	WebElement platoActivationChannel;
	
	@FindBy(xpath="//label[text()='Flow and Methods']")
	WebElement platoFlows;
	
	@FindBy(xpath="//h2[text()='Update Columns']")
	WebElement platoUpdateColumnModal;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement platoUpdateColumnSaveBtn;
	
	@FindBy(xpath="//div[contains(@class,'show-advanced-search')]")
	WebElement platoAdvancedSearch;
	
	@FindBy(xpath="//span[contains(@id,'select2-search_type')]")
	WebElement platoSearchType;
	
	@FindBy(xpath="//li[text()='Mobile']")
	WebElement platoPhoneNumberDp;
	
	@FindBy(xpath="(//label[text()='Search Values']/../input[@name='field_values'])[1]")
	WebElement platoSearchValueField; 
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	WebElement platoSearchSubmit; 
	
	@FindBy(xpath="//th[@aria-sort='descending']")
	WebElement sortTrailIdByDescending;
	
	@FindBy(xpath="//th[text()='Trail Id']")
	WebElement trailId;
	
	@FindBy(xpath="//li[text()='Itinerary Id']")
	WebElement itineraryId;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement newPlatoUserName;

	@FindBy(xpath="//input[@id='password']")
	WebElement newPlatoPassword;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement newPlatoLogin;
	
	@FindBy(xpath="//span[text()='Sales']")
	WebElement platoSalesDashboard;
	
	@FindBy(xpath="//span[text()='Sales Metrics']")
	WebElement platoLeadsDashboard;
	
	@FindBy(xpath="(//*[name()='svg'])[5]")
	WebElement platoLeadsSearchButton;
	
	@FindBy(xpath="//input[contains(@placeholder,'Type and enter')]")
	WebElement platoLeadsSearchInput;
	
	@FindBy(xpath="//*[local-name()='svg']//*[local-name()='path' and @id='perm_phone_msg']")
	WebElement platoLeadCallNotesButton;
	
	@FindBy(xpath="(//*[local-name()='svg']//*[local-name()='path' and @id='perm_phone_msg'])[1]")
	WebElement firstCallNotesButton;
	
	@FindBy(xpath="//span[text()='Call History']")
	WebElement callHistoryButton;
	
	@FindBy(xpath="//span[text()='Customer Profile']")
	WebElement customerProfileButton;
	
	@FindBy(xpath="//span[contains(text(),'Lead source')]/../span[2]")
	WebElement leadSource;
	
	@FindBy(xpath="//div[@id='result-stats']")
	WebElement googleSearchResults;

	public WebElement getItineraryId() {
		return itineraryId;
	}

	public WebElement getTrailId() {
		return trailId;
	}
	
	public WebElement getSortTrailIdByDescending() {
		return sortTrailIdByDescending;
	}

	public WebElement getplatoPhoneNumberDp() {
		return platoPhoneNumberDp;
	}
	
	public WebElement getPlatoSearchSubmit() {
		return platoSearchSubmit;
	}

	public WebElement getPlatoSearchValueField() {
		return platoSearchValueField;
	}

	public WebElement getPlatoSearchType() {
		return platoSearchType;
	}

	public WebElement getPlatoAdvancedSearch() {
		return platoAdvancedSearch;
	}

	public WebElement getPlatoUpdateColumnSaveBtn() {
		return platoUpdateColumnSaveBtn;
	}

	public WebElement getPlatoUpdateColumnModal() {
		return platoUpdateColumnModal;
	}

	public WebElement getPlatoFlows() {
		return platoFlows;
	}

	public WebElement getPlatoActivationChannel() {
		return platoActivationChannel;
	}

	public WebElement getPlatoMobileNoOnTable() {
		return platoMobileNoOnTable;
	}
	
	public WebElement getPlatoSettings() {
		return platoSettings;
	}
	
	
	public WebElement getPlatoTrailResultTable() {
		return platoTrailResultTable;
	}
	
	public WebElement getPlatoSearchField() {
		return platoSearchField;
	}

	public WebElement getPlatoSignInBtn() {
		return platoSignInBtn;
	}
	
	public WebElement getPlatoPassword() {
		return platoPassword;
	}
	
	public WebElement getPlatoUserName() {
		return platoUserName;
	}
	
	public WebElement getGoogleSearchBar() {
		return googlesearchbar;
	}
	
	public WebElement getNewPlatoUserName() {
		return newPlatoUserName;
	}

	public WebElement getNewPlatoPassword() {
		return newPlatoPassword;
	}

	public WebElement getNewPlatoLogin() {
		return newPlatoLogin;
	}

	public WebElement getPlatoSalesDashboard() {
		return platoSalesDashboard;
	}
	
	public WebElement getPlatoLeadsDashboard() {
		return platoLeadsDashboard;
	}
	
	public WebElement getPlatoLeadsSearchButton() {
		return platoLeadsSearchButton;
	}

	public WebElement getPlatoLeadsSearchInput() {
		return platoLeadsSearchInput;
	}
	
	public WebElement getPlatoLeadCallNotesButton() {
		return platoLeadCallNotesButton;
	}
	
	public WebElement getFirstCallNotesButton() {
		return firstCallNotesButton;
	}
	
	public WebElement getCallHistoryButton() {
		return callHistoryButton;
	}

	public WebElement getCustomerProfileButton() {
		return customerProfileButton;
	}
	
	public WebElement getLeadSource() {
		return leadSource;
	}
	
	public WebElement getGoogleSearchResults() {
		return googleSearchResults;
	}
	
}
