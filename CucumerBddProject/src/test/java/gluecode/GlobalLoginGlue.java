package gluecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;
import utils.SeWrappers;

public class GlobalLoginGlue extends Kernel{
	public String countrytxt;
	public String descode;
	public String descity;
	protected static Map<String, String> destinationcountries = new HashMap<String, String>();
	WebElement country;
	public static String destcodevalue;
	public static String destinationValue="";
	
	GlobalSignupAndLoginGlue gsl = new GlobalSignupAndLoginGlue();

	@When("^User selects the \"([^\"]*)\" from the global dropdown$")
	public void user_selects_the_from_the_global_dropdown(String Destination) throws Throwable {

		Thread.sleep(2000);
		hoverWebelement(globalPage.getGlobalIcon());
		pollingWait(globalPage.getGlobalDropdownList().get(0), 10);
		if(Destination.equalsIgnoreCase("UAE"))
		{
			destinationValue="United Arab Emirates";
			destcodevalue="ae";
		}
		else if(Destination.equalsIgnoreCase("US"))
		{
			destinationValue="United States";
			destcodevalue="us";
		}
		WebElement globalDestination= driver.findElement(By.xpath("(//a[contains(text(),'"+destinationValue+"')])[2]"));
		hoverWebelement(globalDestination);
		clickAction(globalDestination);
		Thread.sleep(3000);
	}


	@Then("^Validate the respective \"([^\"]*)\" homepage is displaying or not$")
	public void validate_the_respective_homepage_is_displaying_or_not(String Destination) throws Throwable {
		String currenturl = driver.getCurrentUrl();
		if(Destination.equals("India")) {
			validate_String_Contains(currenturl,localEnvUrl);
		}
		else {
		System.out.println("Destcode: "+destcodevalue);
		validate_String_Contains(currenturl,destcodevalue);
		}

	}
	
	@Then("^Global user fills the GCM with mandatory for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void global_user_fills_the_GCM_with_mandatory_for(String Destination, String region, String fields) throws Throwable {
	   
	Thread.sleep(1000);
		clickAction(icm.getcalculateTripCostButton());
		Thread.sleep(1000);
		if(Destination.equals("India")) {
			fillMandatoryInfoInGCM();
			doLoginFromGCM(username, pass, "Valid");
		}
		else {
			gsl.globalSignupAndLogin(fields);
		}
	}

	@Given("^Login with valid \\\"([^\\\"]*)\\\" and incorrect \\\"([^\\\"]*)\\\" for global \"([^\"]*)\"$")
	public void loginWithValidUserNameAndIncorrectPasswordForGlobal(String userName, String password, String user) {
	   try
	   {
		   Thread.sleep(8000);
		   if(driver.findElements(By.xpath("(//div[@role='dialog']//*[name()='svg'])[2]")).size() > 0)
			{
				clickAction(seoChecks.getSeoRcbClose());
				Thread.sleep(2000);
			}
		   
			Thread.sleep(2000);
			pollingWait(lp.getLogin(), 15);
			clickAction(lp.getLogin());
		   
		   if (user.toLowerCase().contentEquals("uae")) {
			pollingWait(globalPage.getGlobalUserName(), 25);
			forceClick(globalPage.getGlobalUserName());
			typeText(globalPage.getGlobalUserName(), userName);
			
			pollingWait(globalPage.getGlobalCountryCode(), 25);
			forceClick(globalPage.getGlobalCountryCode());
			typeText(globalPage.getGlobalCountryCode(), "91");
			
			pollingWait(globalPage.getGlobalPassword(), 15);
			forceClick(globalPage.getGlobalPassword());
			typeText(globalPage.getGlobalPassword(), password);
		}
		else if (user.toLowerCase().contentEquals("us")) {
			pollingWait(globalPage.getGlobalUserName(), 15);
			forceClick(globalPage.getGlobalUserName());
			typeText(globalPage.getGlobalUserName(), userName);
			
			pollingWait(globalPage.getGlobalCountryCode(), 15);
			forceClick(globalPage.getGlobalCountryCode());
			typeText(globalPage.getGlobalCountryCode(), "91");
			
			pollingWait(globalPage.getGlobalPassword(), 15);
			forceClick(globalPage.getGlobalPassword());
			typeText(globalPage.getGlobalPassword(), password);
		}
		   
		   Thread.sleep(500);
		   pollingWait(globalPage.getGlobalLoginButton(), 15);
		   clickAction(globalPage.getGlobalLoginButton());
		
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
		   Assert.fail();
	   }

	}
	
	@Then("^Login should be unsuccessful for global for incorrect password$")
	public void loginShouldBeUnsuccessfulForGlobalForIncorrectPassword() {
		try
		{
			pollingWaitWithoutClickable(globalPage.getGlobalPasswordError(), 15);
			Assert.assertTrue(globalPage.getGlobalPasswordError().isDisplayed());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^Login should be unsuccessful for global for incorrect username and incorrect password$")
	public void loginShouldBeUnsuccessfulForGlobalForIncorrectUserNameAndIncorrectPassword() {
		try
		{
			pollingWaitWithoutClickable(globalPage.getGlobalIncorrectUsername(), 15);
			pollingWaitWithoutClickable(globalPage.getGlobalInvalidUsername(), 15);
			Assert.assertTrue(globalPage.getGlobalInvalidUsername().isDisplayed());
			Assert.assertTrue(globalPage.getGlobalIncorrectUsername().isDisplayed());

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
	@Then("^Validate whether closing the login screen traverses back to the global home page$")
	public void validateWhetherClosingTheLoginScreenTraversesBackToTheGlobalHomePage() {
		try
		{
			 Thread.sleep(8000);
			   if(driver.findElements(By.xpath("(//div[@role='dialog']//*[name()='svg'])[2]")).size() > 0)
				{
					clickAction(seoChecks.getSeoRcbClose());
					Thread.sleep(2000);
				}
			   
				Thread.sleep(2000);
				pollingWait(lp.getLogin(), 15);
				clickAction(lp.getLogin());
			
				pollingWait(globalPage.getGlobalCloseLoginScreen(), 15);
				clickAction(globalPage.getGlobalCloseLoginScreen());
				
				pollingWait(lp.getLogin(), 15);
				Assert.assertTrue(lp.getLogin().isDisplayed() );
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
	@Then("^Validate whether entering incorrect mobile number throws error in Forgot password screen for global$")
	public void validateEnteringIncorrecrMobileNoThrowsErrorInForgotPassword() {
		try
		{
			 Thread.sleep(8000);
			   if(driver.findElements(By.xpath("(//div[@role='dialog']//*[name()='svg'])[2]")).size() > 0)
				{
					clickAction(seoChecks.getSeoRcbClose());
					Thread.sleep(2000);
				}
			   
				Thread.sleep(2000);
				pollingWait(lp.getLogin(), 15);
				clickAction(lp.getLogin());
				
				pollingWait(globalPage.getGlobalForgotPwd(), 15);
				clickAction(globalPage.getGlobalForgotPwd());
				
				pollingWait(globalPage.getGlobalUserName(), 15);
				forceClick(globalPage.getGlobalUserName());
				typeText(globalPage.getGlobalUserName(), globalUserUAE);
				
				pollingWait(globalPage.getGlobalGetOtp(), 15);
				clickAction(globalPage.getGlobalGetOtp());
				
				pollingWait(globalPage.getInvalidMobileNoInOtpScreen(), 15);
				Assert.assertTrue(globalPage.getInvalidMobileNoInOtpScreen().isDisplayed());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}
	@Then("Click on View Price")
	public void click_on_view_price() {
	    try
	    {
	    	pollingWait(globalPage.getViewPrice(), 30);
	    	scrolltoElement(globalPage.getViewPrice());
	    	actionsClick(globalPage.getViewPrice());
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	@Then("Enter the valid passenger details {string}, {string} and credentials {string} {string}")
	public void enter_the_valid_passenger_details_and_credentials(String passengerName, String mailId, String mobileNo, String password) {
		try
	    {
			pollingWait(globalPage.getLeadPassengerName(), 20);
			forceClick(globalPage.getLeadPassengerName());
			typeText(globalPage.getLeadPassengerName(), passengerName);
			
			pollingWait(globalPage.getLeadPassengerEmailId(), 20);
			forceClick(globalPage.getLeadPassengerEmailId());
			typeText(globalPage.getLeadPassengerEmailId(), mailId);
			
			pollingWait(globalPage.getLeadPassengerMobileNo(), 20);
			forceClick(globalPage.getLeadPassengerMobileNo());
			typeText(globalPage.getLeadPassengerMobileNo(), mobileNo);
			
			pollingWait(globalPage.getLeadPassengerCountryCode(), 15);
			forceClick(globalPage.getLeadPassengerCountryCode());
			typeText(globalPage.getLeadPassengerCountryCode(), "+91");
			
			pollingWait(globalPage.getLeadPassengerGetCost(), 20);
	    	scrolltoElement(globalPage.getLeadPassengerGetCost());
	    	actionsClick(globalPage.getLeadPassengerGetCost());
	    	
	    	pollingWait(globalPage.getLeadPassengerMobileNoInLogin(), 15);
	    	actionsClick(globalPage.getLeadPassengerMobileNoInLogin());
			typeText(globalPage.getLeadPassengerMobileNoInLogin(), mobileNo);
			Thread.sleep(1500);
			
			pollingWait(globalPage.getLeadPassengerPasswordInLogin(), 15);
			actionsClick(globalPage.getLeadPassengerPasswordInLogin());
			typeText(globalPage.getLeadPassengerPasswordInLogin(), password);
			
			pollingWait(globalPage.getLeadPassengerLogin(), 20);
	    	scrolltoElement(globalPage.getLeadPassengerLogin());
	    	actionsClick(globalPage.getLeadPassengerLogin());
	    	
	    	Thread.sleep(7000);
	    	
	    	switchWindows();
	    	
			
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	@Then("Validate whether the costing has happened successfully for global")
	public void validate_whether_the_costing_has_happened_successfully_for_global() {
		try
	    {
			Thread.sleep(4000);
			Validate_whether_itinerary_costed_succesfully();
			elementExist(inclusion.getBookNow());
			Assert.assertTrue(isElementVisible(inclusion.getBookNow(), 10));
			
			pollingWaitWithoutClickable(globalPage.getGlobalInclusionsCost(), 30);
			String globalCost=getText(globalPage.getGlobalInclusionsCost());
			Thread.sleep(1500);
			if(globalCost.contains("AED") || globalCost.contains("$"))
			{
				System.out.println("Costing is successful and Currency is proper in inclusions page");
				Assert.assertTrue(true);
			}
			else
			{
				System.out.println("Costing is successful but Currency is improper in inclusions page");
				Assert.assertTrue(false);
			}
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}

	@Given("^User navigates to the global \"([^\"]*)\" page$")
	public void user_navigates_to_the_page(String arg1) {
		try
		{
		navigateToUrl(getCurrentUrl()+"/"+arg1);
		validate_String_Contains(getCurrentUrl(),arg1);
		//pollingWait(gdropdown.getGlobalIcon(), 30);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
			
		}
	}
	@Then("Enter the valid passenger details {string}, {string} and incorrect credentials {string} {string} {string}")
	public void enter_the_valid_passenger_details_and_incorrect_credentials(String passengerName, String mailId, String mobileNo, String incorrectPassword, String countryCode) {
	    try
	    {
	    	pollingWait(globalPage.getLeadPassengerName(), 20);
			forceClick(globalPage.getLeadPassengerName());
			typeText(globalPage.getLeadPassengerName(), passengerName);
			
			pollingWait(globalPage.getLeadPassengerEmailId(), 20);
			forceClick(globalPage.getLeadPassengerEmailId());
			typeText(globalPage.getLeadPassengerEmailId(), mailId);
			
			pollingWait(globalPage.getLeadPassengerMobileNo(), 20);
			forceClick(globalPage.getLeadPassengerMobileNo());
			typeText(globalPage.getLeadPassengerMobileNo(), mobileNo);
			
			if(countryCode.contentEquals("+91"))
			{
				pollingWait(globalPage.getLeadPassengerCountryCode(), 15);
				forceClick(globalPage.getLeadPassengerCountryCode());
				typeText(globalPage.getLeadPassengerCountryCode(), countryCode);
			}
			
			pollingWait(globalPage.getLeadPassengerGetCost(), 20);
	    	scrolltoElement(globalPage.getLeadPassengerGetCost());
	    	actionsClick(globalPage.getLeadPassengerGetCost());
	    	Thread.sleep(3000);
	    	
	    	if(countryCode.contentEquals("+91"))
	    	{
		    	pollingWait(globalPage.getLeadPassengerMobileNoInLogin(), 15);
				forceClick(globalPage.getLeadPassengerMobileNoInLogin());
				typeText(globalPage.getLeadPassengerMobileNoInLogin(), mobileNo);
				Thread.sleep(1500);
			
				pollingWait(globalPage.getLeadPassengerPasswordInLogin(), 15);
				forceClick(globalPage.getLeadPassengerPasswordInLogin());
				typeText(globalPage.getLeadPassengerPasswordInLogin(), incorrectPassword);
	    	}
	    	else if (countryCode.contentEquals("+971"))
	    	{
	    		pollingWait(globalPage.getLeadPassengerPasswordInLogin(), 15);
	    		scrolltoElement(globalPage.getLeadPassengerPasswordInLogin());
				actionsClick(globalPage.getLeadPassengerPasswordInLogin());
				typeText(globalPage.getLeadPassengerPasswordInLogin(), incorrectPassword);
	    	}
			
			pollingWait(globalPage.getLeadPassengerLogin(), 20);
	    	scrolltoElement(globalPage.getLeadPassengerLogin());
	    	actionsClick(globalPage.getLeadPassengerLogin());
	    	
	    	Thread.sleep(3000);
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	@Then("Login should be unsuccessful for global for incorrect password for {string}")
	public void login_should_be_unsuccessful_for_global_for_incorrect_password_for(String countryCode) {
		try
		{
			if(countryCode.contentEquals("+971"))
			{
				pollingWaitWithoutClickable(globalPage.getGlobalIncorrectCredentials(), 15);
				Assert.assertTrue(globalPage.getGlobalIncorrectCredentials().isDisplayed());
			}
			else if(countryCode.contentEquals("+91"))
			{
				pollingWaitWithoutClickable(globalPage.getGlobalPasswordError(), 15);
				Assert.assertTrue(globalPage.getGlobalPasswordError().isDisplayed());
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}
	

@Then("Enter the valid passenger details {string}, {string} and incorrect mobileNo {string} {string} {string} {string}")
public void enter_the_valid_passenger_details_and_incorrect_mobile_no(String passengerName, String mailId, String mobileNo, String password, String countryCode, String incorrectMobileNo) {
	try{
		pollingWait(globalPage.getLeadPassengerName(), 20);
		forceClick(globalPage.getLeadPassengerName());
		typeText(globalPage.getLeadPassengerName(), passengerName);
		
		pollingWait(globalPage.getLeadPassengerEmailId(), 20);
		forceClick(globalPage.getLeadPassengerEmailId());
		typeText(globalPage.getLeadPassengerEmailId(), mailId);
		
		pollingWait(globalPage.getLeadPassengerMobileNo(), 20);
		forceClick(globalPage.getLeadPassengerMobileNo());
		typeText(globalPage.getLeadPassengerMobileNo(), mobileNo);
		
		if(countryCode.contentEquals("+91"))
		{
			pollingWait(globalPage.getLeadPassengerCountryCode(), 15);
			forceClick(globalPage.getLeadPassengerCountryCode());
			typeText(globalPage.getLeadPassengerCountryCode(), countryCode);
		}
		
		pollingWait(globalPage.getLeadPassengerGetCost(), 20);
    	scrolltoElement(globalPage.getLeadPassengerGetCost());
    	actionsClick(globalPage.getLeadPassengerGetCost());
    	Thread.sleep(3000);
    	
    	if(countryCode.contentEquals("+91"))
    	{
	    	pollingWait(globalPage.getLeadPassengerMobileNoInLogin(), 15);
			forceClick(globalPage.getLeadPassengerMobileNoInLogin());
			typeText(globalPage.getLeadPassengerMobileNoInLogin(), incorrectMobileNo);
			Thread.sleep(1500);
		
			pollingWait(globalPage.getLeadPassengerPasswordInLogin(), 15);
			forceClick(globalPage.getLeadPassengerPasswordInLogin());
			typeText(globalPage.getLeadPassengerPasswordInLogin(), password);
    	}
    	else if (countryCode.contentEquals("+971"))
    	{
    		pollingWait(globalPage.getLeadPassengerPasswordInLogin(), 15);
    		scrolltoElement(globalPage.getLeadPassengerPasswordInLogin());
			actionsClick(globalPage.getLeadPassengerPasswordInLogin());
			typeText(globalPage.getLeadPassengerPasswordInLogin(), password);
    	}
    	
    }
    catch(Exception ex)
    {
    	ex.printStackTrace();
    	Assert.fail();
    }
}
	@Then("Login should be unsuccessful for global for incorrect mobileNo for {string}")
	public void login_should_be_unsuccessful_for_global_for_incorrect_mobile_no_for(String string) {
		try{
	    	Thread.sleep(3000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	Boolean isDisabled = (Boolean) js.executeScript("return arguments[0].hasAttribute('disabled');", globalPage.getLeadPassengerLogin());

	    	if (isDisabled) {
	    	    System.out.println("Login element is not enabled because of invalid mobile no");
	    	}
		}
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	@Then("Navigate to global landing page for {string}")
	public void navigate_to_global_landing_page_for(String region) {
	    try
	    {
			driver.get(driver.getCurrentUrl() + "/customize");
			Thread.sleep(2000);
			typeText(cp.getlandingSearchBox(), region);
			pollingWait(cp.getregionSelection(), 10);
			// Script is failing often so, I changed the clickAction to forceClick and added
			// intervals
			forceClick(cp.getregionSelection());
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	@Then("Enter the details for Global PDG flow for Thailand")
	public void enter_the_details_for_global_pdg_flow() {
	    try
	    {

			pollingWait(dubaiPage.getdepdays(), 10);
			Assert.assertTrue(dubaiPage.getdepdays().isDisplayed());
			clickAction(dubaiPage.getdepdays());
			Thread.sleep(500);

			pollingWait(dubaiPage.getsolostaytype(), 10);
			Assert.assertTrue(dubaiPage.getsolostaytype().isDisplayed());
			clickAction(dubaiPage.getsolostaytype());
			Thread.sleep(500);

			pollingWait(pdgflowp.getFindACity(), 10);
			Assert.assertTrue(pdgflowp.getFindACity().isDisplayed());
			clickAction(pdgflowp.getFindACity());
			typeText(pdgflowp.getFindACity(), "Phuket");
			pollingWait(pdgflowp.getPhuketCity(), 10);
			Assert.assertTrue(pdgflowp.getPhuketCity().isDisplayed());
			clickAction(pdgflowp.getPhuketCity());
			Thread.sleep(1000);

			clickAction(pdgflowp.getFindACity());
			typeText(pdgflowp.getFindACity(), "Krabi");

			pollingWait(pdgflowp.getKrabiCity(), 10);
			Assert.assertTrue(pdgflowp.getKrabiCity().isDisplayed());
			clickAction(pdgflowp.getKrabiCity());
			Thread.sleep(2000);

			pollingWait(dubaiPage.getBuildItinerary(), 10);
			Assert.assertTrue(dubaiPage.getBuildItinerary().isDisplayed());
			clickAction(dubaiPage.getBuildItinerary());
			Thread.sleep(3000);
			
	    }catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
}
