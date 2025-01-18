package gluecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import com.pyt.pages.LeadGenPage;
import com.pyt.pages.SignupPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class LeadGenValidate_CustomizeGlue extends Kernel{
	WebElement packageslink;

	@Then("^search the \"([^\"]*)\" on google website$")
	public void search_the_on_google_website(String Query) throws Throwable {
		driver.navigate().to("http://google.co.in/");	
		typeText(leadgen.getGoogleSearchBar(), Query);
		leadgen.getGoogleSearchBar().sendKeys(Keys.ENTER);
		//isElementVisible(leadgen.getGoogleSearchResults(), 20);
		Thread.sleep(4000);
	}

	@Then("^click on the respective \"([^\"]*)\" showing on the results$")
	public void click_on_the_respective_showing_on_the_results(String URL) throws Throwable {
		try
		{
			List<WebElement> ad= driver.findElements(By.xpath("//a[contains(@href,'"+URL+"')]//span[text()='Ad']"));
			if(ad.size() > 0)
			{
				packageslink = driver.findElement(By.xpath("(//a[contains(@href,'"+URL+"')])[2]"));
				
			}
			else if (driver.findElements(By.xpath("(//a[contains(@href,'"+URL+"')])")).size() > 0)
			{
				packageslink = driver.findElement(By.xpath("(//a[contains(@href,'"+URL+"')])"));
			}/*
			else if (driver.findElements(By.xpath("//h3[contains(text(),'Pickyourtrail.com: Customized')]")).size() > 0)
			{
				System.out.println("Inide pyt");
				packageslink=driver.findElement(By.xpath("//h3[contains(text(),'Pickyourtrail.com: Customized')]"));
			}*/
			clickAction(packageslink);
			System.out.println("Packages link-->"+packageslink);
			//Assert.assertTrue(getCurrentUrl().contains(URL));
			System.out.println("pyt");
			Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			System.out.println("Problem while clicking the corresponding link from Search results page "+ex.getMessage());
			ex.printStackTrace();
		}

	}

	@Then("^Click on the customise button and fill the GCM form to signup using \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void click_on_the_customise_button_and_fill_the_GCM_form_to_signup_using_and_and(String name, String emailid, String mobileno) throws Throwable {

		pollingWait(packagesPage.getfirstPackageCustomize(), 20);
		scrollTo(500);
		clickAction(packagesPage.getfirstPackageCustomize());
		System.out.println("new gcm package");
		signUp(name, emailid, mobileno);
		pollingWaitForCostingFlow("inclusions", 100);
		validateAssertion(getCurrentUrl().contains("inclusions"));

	}

	@Then("^Login into the plato using valid credentials$")
	public void login_into_the_plato_using_valid_credentials()  {

		try
		{

			String platoUrl = "https://plato.pickyourtrail.com/";
			driver.navigate().to("https://plato.pickyourtrail.com/admin/default/login/?secret=true");
			driver.navigate().refresh();
			clickAction(leadgen.getPlatoUserName());
			typeText(leadgen.getPlatoUserName(), platoUserName);
			clickAction(leadgen.getPlatoPassword());
			typeText(leadgen.getPlatoPassword(), platoPassword);
			pollingWait(leadgen.getPlatoSignInBtn(),15);
			forceClick(leadgen.getPlatoSignInBtn());
			pollingWait(leadgen.getPlatoSearchField(), 20);
			validateAssertion(getCurrentUrl().equals(platoUrl));
			System.out.println("Successfully logged in to plato");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}


	}

	@Then("^Search the trail using \"([^\"]*)\" and validate the trail is showing on plato dashboard$")
	public void search_the_trail_using_and_validate_the_trail_is_showing_on_plato_dashboard(String mobileno) throws Throwable {

		waitForMe(leadgen.getPlatoAdvancedSearch(), 10);
		clickAction(leadgen.getPlatoAdvancedSearch());
		pollingWait(leadgen.getPlatoSearchType(), 10);
		clickAction(leadgen.getPlatoSearchType());
		clickAction(leadgen.getplatoPhoneNumberDp());
		clickAction(leadgen.getPlatoSearchValueField());
		typeText(leadgen.getPlatoSearchValueField(),mobileno);
		pollingWait(leadgen.getPlatoSearchSubmit(), 10);
		clickAction(leadgen.getPlatoSearchSubmit());
		pollingWait(leadgen.getPlatoTrailResultTable(), 50);
		Thread.sleep(3000);
		String usermobileno = "+91"+mobileno;
		waitForMe(leadgen.getPlatoMobileNoOnTable(),10);
		String MobilenoOnDashboard = leadgen.getPlatoMobileNoOnTable().getText();
		System.out.println("usermobileno--"+usermobileno);
		System.out.println("MobilenoOnDashboard--"+MobilenoOnDashboard);
		validateAssertion(usermobileno.equals(MobilenoOnDashboard));
		System.out.println("The trail details are correct");
	}

	@Then("^Validate the \"([^\"]*)\" and \"([^\"]*)\" for the respective trail$")
	public void validate_the_and_for_the_respective_trail(String activationchannel, String flowsandmethods) throws Throwable {

		/*
		 * Commenting this code because we can enable the activation source and flow & methods by default 
		clickAction(leadgen.getPlatoSettings());
		validateAssertion(elementDisplayed(leadgen.getPlatoUpdateColumnModal()));
		scrolltoElement(leadgen.getPlatoActivationChannel());
		clickAction(leadgen.getPlatoActivationChannel());
		Thread.sleep(1000);
		scrolltoElement(leadgen.getPlatoFlows());
		clickAction(leadgen.getPlatoFlows());
		Thread.sleep(1000);
		scrolltoElement(leadgen.getPlatoUpdateColumnSaveBtn());
		clickAction(leadgen.getPlatoUpdateColumnSaveBtn());
		pollingWait(leadgen.getPlatoTrailResultTable(), 50);
		 */
		
		pollingWait(leadgen.getTrailId(), 20);
		//change to ascending order
		clickAction(leadgen.getTrailId());
		Thread.sleep(500);

		//change to descending order
		clickAction(leadgen.getTrailId()); 

		
		if(driver.findElements(By.xpath("//th[@aria-sort='descending']")).size() > 0)
		{
			System.out.println("Trail Ids are arranged in descending order");
			Thread.sleep(500);
			String flowsOnPlato =driver.findElement(By.xpath("//td[11]")).getText();
			Thread.sleep(500);

			String activationChannelOnPlato =driver.findElement(By.xpath("//td[12]")).getText();
			System.out.println("activationchannel--"+activationchannel);
			System.out.println("flowsandmethods--"+flowsandmethods);
			System.out.println("activationChannelOnPlato--"+activationChannelOnPlato);
			System.out.println("flowsOnPlato--"+flowsOnPlato);
	
			Thread.sleep(500);
			validateAssertion(activationchannel.equals(activationChannelOnPlato));
			Thread.sleep(500);
			validateAssertion(flowsandmethods.equals(flowsOnPlato));
		}
		else
		{
			System.out.println("Trail Ids are arranged in ascending order");
			//change to descending order
			clickAction(leadgen.getTrailId());
			Thread.sleep(500);

			
			String flowsOnPlato =driver.findElement(By.xpath("//td[11]")).getText();
			Thread.sleep(500);

			String activationChannelOnPlato =driver.findElement(By.xpath("//td[12]")).getText();
			Thread.sleep(500);

			System.out.println("activationchannel--"+activationchannel);
			System.out.println("flowsandmethods--"+flowsandmethods);
			System.out.println("activationChannelOnPlato--"+activationChannelOnPlato);
			System.out.println("flowsOnPlato--"+flowsOnPlato);
			Thread.sleep(500);
			validateAssertion(activationchannel.equals(activationChannelOnPlato));
			Thread.sleep(500);
			validateAssertion(flowsandmethods.equals(flowsOnPlato));
		}


	}


	@Then("^Signup as new user from GCM page with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_as_new_user_from_GCM_page_with_and_and_and(String region, String name, String emailid, String mobileno) throws Throwable {
		validateAssertion(signupThroughGCMLeadGen("GCM",region,name,emailid,mobileno));
	}


	@Then("^Select the \"([^\"]*)\" on the homepage$")
	public void select_the_on_the_homepage(String maldiveslink) throws Throwable {
		WebElement malpackageslink = driver.findElement(By.xpath("//a[@href='"+maldiveslink+"']"));
		clickAction(malpackageslink);
		validateAssertion(getCurrentUrl().contains(maldiveslink));
	}

	@Then("^Navigate to the paid campaign link$")
	public void navigate_to_the_paid_campaign_link() throws Throwable {
		driver.navigate().to("https://pickyourtrail.com/packages/dubai?utm_keyword=jumeirah%20hotel%20dubai&utm_fee[…]etid=kwd-182359596&utm_creative=561901594511&utm_adposition=");
	}

	@Then("^signup with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void signup_with_and_and(String name, String emailId, String mobileNo) throws Throwable {
		
		validateAssertion(signUp(name, emailId, mobileNo));
		pollingWaitForCostingFlow("inclusions", 100);
		validateAssertion(getCurrentUrl().contains("inclusions"));
	}
	
	
	@Then("Search the trail using itineraryId and validate the trail is showing on plato dashboard using {string}")
	public void search_the_trail_using_itinerary_id_and_validate_the_trail_is_showing_on_plato_dashboard_using(String mobileNo) {
		 try
		    {
		    	waitForMe(leadgen.getPlatoAdvancedSearch(), 10);
				clickAction(leadgen.getPlatoAdvancedSearch());
				pollingWait(leadgen.getPlatoSearchType(), 10);
				clickAction(leadgen.getPlatoSearchType());
				clickAction(leadgen.getItineraryId());
				clickAction(leadgen.getPlatoSearchValueField());
				typeText(leadgen.getPlatoSearchValueField(),itineraryId);
				pollingWait(leadgen.getPlatoSearchSubmit(), 10);
				clickAction(leadgen.getPlatoSearchSubmit());
				pollingWait(leadgen.getPlatoTrailResultTable(), 50);
				Thread.sleep(3000);
				String userMobileNo = "+91"+mobileNo;
				waitForMe(leadgen.getPlatoMobileNoOnTable(),10);
				String MobilenoOnDashboard = leadgen.getPlatoMobileNoOnTable().getText();
				System.out.println("usermobileno--"+userMobileNo);
				System.out.println("MobilenoOnDashboard--"+MobilenoOnDashboard);
				Assert.assertTrue(userMobileNo.equals(MobilenoOnDashboard));
				System.out.println("The trail details are correct");
				
				
		    }
		    catch(Exception ex)
		    {
		    	
		    }
	}
	
	@Then("Login into the plato using valid credentials and click on Sales dashboard")
	public void login_into_the_plato_using_valid_credentials_and_click_on_sales_dashboard() {
	    try
	    {
			driver.navigate().to(newPlatoUrl);
			
			//refreshing the page
			driver.navigate().refresh();
			
			//Checking whether the plato login page is displayed
			Assert.assertTrue(leadgen.getNewPlatoUserName().isDisplayed());
			//Entering the Plato username
			clickAction(leadgen.getNewPlatoUserName());
			typeText(leadgen.getNewPlatoUserName(), platoUserName);
			
			//Entering the Plato password
			clickAction(leadgen.getNewPlatoPassword());
			typeText(leadgen.getNewPlatoPassword(), platoPassword);
			//Clicking on Login button
			pollingWait(leadgen.getNewPlatoLogin(),15);
			forceClick(leadgen.getNewPlatoLogin());
			
			pollingWait(leadgen.getPlatoSalesDashboard(), 20);
			Assert.assertTrue(leadgen.getPlatoSalesDashboard().isDisplayed());
			System.out.println("Successfully logged in to plato");
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	@Then("Search using itineraryId and validate the trail is showing on sales dashboard using {string}")
	public void search_using_itinerary_id_and_validate_the_trail_is_showing_on_sales_dashboard_using(String string) {
		try
	    {
			int trailIdSize=0;
			Thread.sleep(3000);
			pollingWaitWithoutClickable(leadgen.getPlatoSalesDashboard(),20);
	    	forceClick(leadgen.getPlatoSalesDashboard());
			Thread.sleep(2000);
	    	
	    	pollingWaitWithoutClickable(leadgen.getPlatoLeadsDashboard(),30);
	    	//Assertion to validate whether we are in Plato leads dashboard or not
	    	Assert.assertTrue(leadgen.getPlatoLeadsDashboard().isDisplayed());

	    	clickAction(leadgen.getPlatoLeadsSearchButton());
			Thread.sleep(3000);
	    	pollingWait(leadgen.getPlatoLeadsSearchInput(),15);
	    	//Assertion to validate whether we are in plato search box is displayed or not
	    	Assert.assertTrue(leadgen.getPlatoLeadsSearchInput().isDisplayed());
	    	
	    	
	    	Thread.sleep(4000);
	    	clickAction(leadgen.getPlatoLeadsSearchInput());
			Thread.sleep(1000);
	    	typeText(leadgen.getPlatoLeadsSearchInput(),itineraryId);
	    	
	    	//Press enter after entering the itinerary id
	    	pressEnter(leadgen.getPlatoLeadsSearchInput());
	    	Thread.sleep(8000);
	    	
	    	//Changed to pollingwait withoutclickable and added an extra 5 sec to load the itinerary in plato on Apr25
	    	
//	    	Assert.assertTrue(elementExist(leadgen.getPlatoLeadCallNotesButton()));
	    	scrolltoElement(leadgen.getPlatoLeadCallNotesButton());
	    	
	    	if (driver.findElements(By.xpath("//*[local-name()='svg']//*[local-name()='path' and @id='perm_phone_msg']")).size() > 0)
	    	{
	    		trailIdSize=driver.findElements(By.xpath("//*[local-name()='svg']//*[local-name()='path' and @id='perm_phone_msg']")).size();
	    		Assert.assertTrue(trailIdSize>0);
	    		System.out.println("Trail id Size-->"+trailIdSize);
	    		System.out.println("Trail id is created for the itinerary id ("+itineraryId+")");
	    	}
	    	else if (driver.findElements(By.xpath("//*[local-name()='svg']//*[local-name()='path' and @id='perm_phone_msg']")).size() < 0)
	    	{
	    		Assert.assertTrue(false);
	    		System.out.println("Trail id is not created for the itinerary id ("+itineraryId+")");
	    	}
	    	else if(driver.findElements(By.xpath("//span[text()='65']")).size() >0)
	    	{
	    		trailIdSize=driver.findElements(By.xpath("//*[local-name()='svg']//*[local-name()='path' and @id='perm_phone_msg']")).size();
	    		Assert.assertTrue(trailIdSize>1);
	    		System.out.println("Trail id Size-->"+trailIdSize);
	    		System.out.println("Trail id is created for the itinerary id ("+itineraryId+")");
	    	}
	    	
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Problem while creating Trail id");
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	
	@Given("launch the pickyourtrail website")
	public void launch_the_pickyourtrail_website() {
	    try
	    {
	    	driver.navigate().to("https://pickyourtrail.com/");	
	    	pollingWait(pdgflowp.getsearchcountries(),10);
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Problem loading the pickyourtrail website");
	    	ex.printStackTrace();
	    }
	}
	
	@Then("Click on the Call Notes option to load the Call notes page")
	public void click_on_the_call_notes_option_to_load_the_call_notes_page() {
	    try
	    {
	    	forceClick(leadgen.getFirstCallNotesButton());
	    	switchWindows();
	    	pollingWaitWithoutClickable(leadgen.getCallHistoryButton(),15);
	    	Assert.assertTrue(driver.getCurrentUrl().contains("call-notes"));
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Unable to load the Call notes page");
	    	ex.printStackTrace();
	    }
	}
	
	@Then("Click on Customer profile to validate the lead source as {string}")
	public void click_on_customer_profile_to_validate_the_lead_source_as(String expectedLeadSource) {
		try
	    {
			pollingWaitWithoutClickable(leadgen.getCustomerProfileButton(), 20);
	    	clickAction(leadgen.getCustomerProfileButton());
	    	Thread.sleep(2000);
	    	scrollByValue(300);
	    	scrolltoElement(leadgen.getLeadSource());
	    	scrollToView(leadgen.getLeadSource());
//	    	pollingWaitWithoutClickable(leadgen.getLeadSource(), 20);
	    	String leadSourceInPlato=getText(leadgen.getLeadSource());
	    	System.out.println("Expected Lead source-->"+expectedLeadSource+"and Plato lead source-->"+leadSourceInPlato);
	    	Assert.assertTrue(expectedLeadSource.equalsIgnoreCase(leadSourceInPlato));
	    	
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Unable to fetch the lead source from customer profile page");
	    	ex.printStackTrace();
	    }
	    
	}
}
