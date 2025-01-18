package gluecode;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class CbrValidationGlue extends Kernel {

	@Then("^User performs CBR validation after GCM$")
	public void user_performs_CBR_validation_after_GCM() throws Throwable {
		cbrValidationAfterGCM("itinerary");
		Assert.fail();
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click on talk to us button in lading page$")
	public void user_click_on_talk_to_us_button_in_lading_page() throws Throwable {
//		waitForMe(cbr.getCustomerStory());
//		scrolltoElement(cbr.getCustomerStory());
		Thread.sleep(2000);
		scrollDown();
		waitForMe(cbr.getHomePageCbr());
		scrolltoElement(cbr.getHomePageCbr());
		Thread.sleep(1000);
		clickAction(cbr.getHomePageCbr());
	}

	@And("^verify the name email and mobile number field disabled$")
	public void verify_the_name_email_and_mobile_number_field_disabled() throws Throwable {
		boolean name = verifyEnabled(cbr.getUsername());
		boolean email = verifyEnabled(cbr.getEmail());
		boolean num = verifyEnabled(cbr.getPhonenumber());
		if (name == false && email == false && num == false) {
			System.out.println("The name number and email field successfully disabled for existing user");
		}
	}

	@And("^post cbr form$")
	public void post_cbr_form() throws Throwable {
		/*
		 * Commenting the code, since preferred region is removed
		 * */
		if(driver.getCurrentUrl().contains("packages"))
		{
			if(cbr.getPreferredRegion().isDisplayed()) {
				pollingWaitWithoutClickable(cbr.getPreferredRegion(), 10);
				clickAction(cbr.getPreferredRegion());
				Thread.sleep(1000);
				clickAction(cbr.getRegionBali());
				Thread.sleep(1000);
			}else {
				Thread.sleep(1000);
			}
		}
		
		try {
		pollingWait(cbr.getcBrSubmitButton(), 10);
		Assert.assertTrue(cbr.getcBrSubmitButton().isDisplayed());
		clickAction(cbr.getcBrSubmitButton(), "User submitting landing page CBR form ");
		}
		catch (Exception e) {
			Assert.fail("Request callback CTA is disbaled in the CBR");
		}

	}
	

	@And("post cbr form without preferred region")
	public void post_cbr_form_without_preferred_region() {
		try {
			pollingWaitWithoutClickable(cbr.getcBrSubmitButton(), 20);
			Assert.assertTrue(cbr.getcBrSubmitButton().isDisplayed());
			clickAction(cbr.getcBrSubmitButton(), "User submitting landing page CBR form ");
			}
			catch (Exception e) {
				Assert.fail("Request callback CTA is disbaled in the CBR");
			}
	}




	@Then("^Verify the cbr posted successfully$")
	public void verify_the_cbr_posted_successfully() throws Throwable {
		// compareTwoStrings(getCurrentUrl(),"https://"+Hooks.configuration+".longweekend.co.in/");
		waitForMe(hp.getstartPlanningNowButton());
		validateAssertion(elementExist(hp.getstartPlanningNowButton()));

	}

//	@And("^new user fill the CBR form $")
//	public void user_fill_the_CBR_form() throws Throwable {
//	   enterFieldsexceptTime();
//	  }

	@Then("^verify the user should logged in successfully$")
	public void verify_the_user_should_logged_in_successfully() throws Throwable {
		if (elementExist(hp.getUserInitialPostLogin())) {
			System.out.println("User logged in successfully");
		} else {
			System.out.println("User failed to log in");
		}

	}

	@Then("^Validate the alert message$")
	public void validate_the_alert_message() throws Throwable {
		waitForMe(cbr.getAlertMsgCbrExisting());
		if (elementExist(cbr.getAlertMsgCbrExisting())) {
			verifyPartialText(cbr.getAlertMsgCbrExisting(),
					"An account with the given credentials already exists please login or provide different credentials to continue.");
			clickAction(cbr.getOkButtonInAlert(), "User click on Ok button in the alert");
		}
	}

	@Then("^validate the alert message in vacations cbr$")
	public void validate_the_alert_message_in_vacations_cbr() throws Throwable {
		try {
			if (elementExist(cbr.getVactionCbrAlertMsg())) {
				assertTrue(cbr.getCbrCloseVacations().isDisplayed());
				clickAction(cbr.getCbrCloseVacations());
			}
		} catch (Exception e) {

		}
	}

	@And("^user opens the cbr from itinerary$")
	public void user_opens_the_cbr_from_itinerary() throws Throwable {
		scrollDown();
		Thread.sleep(2000);
		scrolltoElement(cbr.getItineraryTravelCons());
		clickAction(cbr.getItineraryTravelCons(), "User clicks the Talk to an expert button in itinerary page");
	}

	@Then("^Verify the cbr posted successfully from itinerary$")
	public void verify_the_cbr_posted_successfully_from_itinerary() throws Throwable {
		pollingWait(cbr.getPytLogo(), 20);
		validateAssertion(elementDisplayed(cbr.getPytLogo()));
	}

	@Then("^user navigate to itinerary page$")
	public void user_navigate_to_itinerary_page() throws Throwable {
		String url = getCurrentUrl();
		System.out.println(url);
		waitUntil(inclusion.getBookNow(), 180);
		clickAction(inclusion.getitineraryTab(), "user navigate to Itinerary tab");
	}

	@Then("^user opens the cbr from inclusions$")
	public void user_opens_the_cbr_from_inclusions() throws Throwable {
		clickAction(cbr.getCbrFromInclusions(), "User clicks on inclusions page CBR");
	}

	public static String packagesUrl = "";

	@Given("^user navigate to packages page$")
	public void user_navigate_to_packages_page() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
		packagesUrl = currentUrl + "packages";
		driver.navigate().to(packagesUrl);
		Thread.sleep(5000);
	}

	@When("^user click on packages page cbr$")
	public void user_click_on_packages_page_cbr() throws Throwable {

		scrollDown();
		pollingWait(cbr.getPackagesCbr(), 25);
		clickJavaScriptElement(cbr.getPackagesCbr());
	}

	@When("^user click on vacations page cbr$")
	public void user_click_on_vacations_page_cbr() throws Throwable {

		scrollDown();
		Thread.sleep(1000);
		scrollUp();
		pollingWait(cbr.getVacationsCbr(), 30);
		clickJavaScriptElement(cbr.getVacationsCbr());
	}

	@Then("^validate the user submitted the cbr successfully$")
	public void validate_the_user_submitted_the_cbr_successfully() throws Throwable {
		Assert.assertTrue(elementExist(cbr.getPackagesCbr()));
	}

	@And("^user moves the cursor to url tab$")
	public void user_moves_the_cursor_to_url_tab() {
		moveToUrl(driver);
		try {
			Thread.sleep(9000);
			validate_String_Contains(getCurrentUrl(), "request-callback");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@When("^user fill the cbr value in the form\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_fill_the_cbr_value_in_the_form(String name, String mobile, String email) throws Throwable {
		try {
			typeText(cbr.getUsername(), name);
			typeText(cbr.getPhonenumber(), mobile);
			typeText(cbr.getEmail(), email);
		} catch (Exception ex) {
			System.out.println("Problem while submitting CBR form " + ex.getMessage());
		}
	}

	@Given("user opens the cbr from packages page")
	public void user_opens_the_cbr_from_packages_page() throws InterruptedException {
		if(driver.findElements(By.xpath("(//div[@role='dialog']//*[name()='svg'])[2]")).size() > 0)
		{
			clickAction(seoChecks.getSeoRcbClose());
		}
		pollingWaitWithoutClickable(cbr.getRequestCallbackCTA(), 15);
		Assert.assertTrue(isElementVisible(cbr.getRequestCallbackCTA(),20));
		scrolltoElement(cbr.getRequestCallbackCTA());
		try {
		clickDisbledJavaScriptElement(cbr.getRequestCallbackCTA());
		}
		catch(StaleElementReferenceException e) {
			pageRefresh();
			pollingWaitWithoutClickable(cbr.getRequestCallbackCTA(), 15);
			clickDisbledJavaScriptElement(cbr.getRequestCallbackCTA());
		}

	}
	

	@Then("Validate the CBR successfully posted message in packages page")
	public void validate_the_cbr_successfully_posted_message_in_packages_page() throws InterruptedException {
		pollingWaitWithoutClickable(cbr.getCBRSuccessfullmsg(), 20);
		if(cbr.getCBRSuccessfullmsg().isDisplayed()) {
			pollingWaitWithoutClickable(cbr.getTravelExpertsmsg(), 10);
			Assert.assertTrue(cbr.getTravelExpertsmsg().isDisplayed());
			Thread.sleep(2000);
			clickAction(cbr.getOkaygotIt());
		}
		else {
			Assert.fail("CBR is not posted in the packages page");
		}
	}
	

	@Then("Click on the request callback CTA in the itinerary page")
	public void click_on_the_request_callback_cta_in_the_itinerary_page() throws InterruptedException {
	//	hoverWebelement(cbr.getRequestCallback());
		pageRefresh();
		
		scrolltoElement(cbr.getRequestCallback());
		Thread.sleep(2000);
		pollingWaitWithoutClickable(cbr.getRequestCallback(), 10);
		Thread.sleep(2000);
		Assert.assertTrue(cbr.getRequestCallback().isDisplayed());
		clickDisbledJavaScriptElement(cbr.getRequestCallback());
		Thread.sleep(2000);
		
		
	}
	
	
	@Then("Validate the CBR successfully popsted message in the itinerary page")
	public void validate_the_cbr_successfully_popsted_message_in_the_itinerary_page() throws InterruptedException {
		pollingWaitWithoutClickable(cbr.getCBRSuccessfullmsg(), 10);
		if(cbr.getCBRSuccessfullmsg().isDisplayed()) {
			pollingWaitWithoutClickable(cbr.getTravelExpertsmsg(), 10);
			Assert.assertTrue(cbr.getTravelExpertsmsg().isDisplayed());
			Thread.sleep(1000);
			clickAction(cbr.getOkaygotIt());
		}
		else {
			Assert.fail("CBR is not posted in the itinerary page");
		}
	}



	@Then("Click on the request callbact CTA in the listing page")
	public void click_on_the_request_callbact_cta_in_the_listing_page() throws InterruptedException {
		pollingWaitWithoutClickable(cbr.getMlerequestCallbackCTA(), 15);
		Assert.assertTrue(cbr.getMlerequestCallbackCTA().isDisplayed());
		clickAction(cbr.getMlerequestCallbackCTA());
	}



	@Given("user opens the cbr from destination page")
	public void user_opens_the_cbr_from_destination_page() throws InterruptedException {
		pollingWaitWithoutClickable(cbr.getDestinationrequestCallback(), 10);
		scrolltoElement(cbr.getDestinationrequestCallback());
		Assert.assertTrue(cbr.getDestinationrequestCallback().isDisplayed());
		clickAction(cbr.getDestinationrequestCallback());
		
	}
	
	@Then("Validate the CBR successfully posted message in destination page")
	public void validate_the_cbr_successfully_posted_message_in_destination_page() {
		scrolltoElement(cbr.getDestinationTravelExpertsmsg());
		try {
			Assert.assertTrue(cbr.getDestinationTravelExpertsmsg().isDisplayed());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("CBR is not working in the destination page");
		}
	}

	@Given("user opens the cbr from journeys page")
	public void user_opens_the_cbr_from_journeys_page() throws InterruptedException {
		pollingWaitWithoutClickable(cbr.getEnquireNow(), 10);
		scrolltoElement(cbr.getEnquireNow());
		Assert.assertTrue(cbr.getEnquireNow().isDisplayed());
		Thread.sleep(2000);
		clickAction(cbr.getEnquireNow());
	}
	


		@Then("Validate CBR posted in the Journeys page successfully")
		public void validate_cbr_posted_in_the_journeys_page_successfully() {
			try {
				pollingWaitWithoutClickable(cbr.getEnquireNow(), 10);
				scrolltoElement(cbr.getEnquireNow());
				Assert.assertTrue(cbr.getEnquireNow().isDisplayed());
				Thread.sleep(2000);
			}
			catch(Exception e) {
				Assert.fail("CBR is not posted in the journey's page");
				e.printStackTrace();
			}
			
		}



	




//	@Then("Enter the {string} and {string} and {string} and {string}")
//	public void enter_the_and_and_and(String string, String string2, String string3, String string4) throws InterruptedException {



	
	@Then("Enter the {string} {string} {string} {string}")
	public void enter_the(String uName, String passwd, String emailid, String name) throws InterruptedException {
		Thread.sleep(1000);
		isElementVisible(cbr.getCbrName(), 15);
		typeText(cbr.getCbrName(), emailid);
		Thread.sleep(1000);
		isElementVisible(cbr.getCbrMobile(), 15);
		typeText(cbr.getCbrMobile(), uName);
		Thread.sleep(1000);
		isElementVisible(cbr.getCbrEmail(), 15);
		typeText(cbr.getCbrEmail(), name);
		Thread.sleep(1000);
		try {
		if(cbr.getPreferredRegion().isDisplayed()) {
			pollingWaitWithoutClickable(cbr.getPreferredRegion(), 10);
			scrolltoElement(cbr.getPreferredRegion());
			clickDisbledJavaScriptElement(cbr.getPreferredRegion());
			Thread.sleep(1000);
			clickDisbledJavaScriptElement(cbr.getRegionBali());
			Thread.sleep(1000);
		}
		}
		catch (Exception e) {
			System.out.println("There is no preferred region");
		}
		try {
			pollingWait(cbr.getcBrSubmitButton(), 15);
			scrolltoElement(cbr.getcBrSubmitButton());
			Assert.assertTrue(cbr.getcBrSubmitButton().isDisplayed());
			System.out.println("After entering the user details, Request callback CTA is enabled");
			actionsClick(cbr.getcBrSubmitButton());
		}
		catch (Exception e) {
			Assert.fail("After entering the user details, Request callback CTA is not enabled");
		}
		
		if (driver.findElements(By.xpath("//span[text()='tamil']")).size() > 0) {
			pollingWait(lp.getLanguageSelection(),10);
			forceClick(lp.getLanguageSelection());
		}
		// Entering OTP
		enterOtp(passwd);
		Thread.sleep(2000);
		try {
			Assert.assertTrue(cbr.getPlaceRequest().isDisplayed());
			System.out.println("After entering the OTP, Place Request CTA is enabled");
			clickAction(cbr.getPlaceRequest());
		}
		catch (Exception e) {
			Assert.fail("After entering the OTP, Place Request CTA is not enabled");
		}

	}
	

	@Then("Enter the {string} {string} {string} {string} without preferred region")
	public void enter_the_without_preferred_region(String uName, String passwd, String emailid, String name) throws InterruptedException {
		Thread.sleep(1000);
		typeText(cbr.getCbrName(), emailid);
		Thread.sleep(1000);
		typeText(cbr.getCbrMobile(), uName);
		Thread.sleep(1000);
		typeText(cbr.getCbrEmail(), name);
		Thread.sleep(1000);
		
		try {
			Assert.assertTrue(cbr.getcBrSubmitButton().isDisplayed());
			System.out.println("After entering the user details, Request callback CTA is enabled");
			forceClick(cbr.getcBrSubmitButton());
		}
		catch (Exception e) {
			Assert.fail("After entering the user details, Request callback CTA is not enabled");
		}
		
		if (driver.findElements(By.xpath("//span[text()='tamil']")).size() > 0) {
			pollingWait(lp.getLanguageSelection(),10);
			forceClick(lp.getLanguageSelection());
		}
		// Entering OTP
		enterOtp(passwd);
		Thread.sleep(2000);
		try {
			Assert.assertTrue(cbr.getPlaceRequest().isDisplayed());
			System.out.println("After entering the OTP, Place Request CTA is enabled");
			clickAction(cbr.getPlaceRequest());
		}
		catch (Exception e) {
			Assert.fail("After entering the OTP, Place Request CTA is not enabled");
		}

	}
		





	

	@Then("Enter the {string} {string} {string} {string} in the Maldives page")
	public void enter_the_in_the_maldives_page(String string, String string2, String string3, String string4) throws InterruptedException {
		Thread.sleep(1000);
		typeText(cbr.getCbrNameSpeedboat(), string3);
		Thread.sleep(1000);
		typeText(cbr.getCbrMobileSpeedboat(), string);
		Thread.sleep(1000);
		typeText(cbr.getCbrEmailSpeedboat(), string4);
		Thread.sleep(1000);
		try {
			Assert.assertTrue(cbr.getcBrSubmitButton().isDisplayed());
			System.out.println("After entering the user details, Request callback CTA is enabled");
			clickAction(cbr.getcBrSubmitButton());
		}
		catch (Exception e) {
			Assert.fail("After entering the user details, Request callback CTA is not enabled");
		}
		
		if (driver.findElements(By.xpath("//span[text()='tamil']")).size() > 0) {
			pollingWait(lp.getLanguageSelection(),10);
			forceClick(lp.getLanguageSelection());
		}
		// Entering OTP
		enterOtp(string2);
		Thread.sleep(2000);
		try {
			Assert.assertTrue(cbr.getPlaceRequest().isDisplayed());
			System.out.println("After entering the OTP, Place Request CTA is enabled");
			clickAction(cbr.getPlaceRequest());
		}
		catch (Exception e) {
			Assert.fail("After entering the OTP, Place Request CTA is not enabled");
		}

	}
	





	@Then("Validate the CBR request is not posting in the packages page")
	public void validate_the_cbr_request_is_not_posting_in_the_packages_page() {
		try {
			pollingWaitWithoutClickable(cbr.getOopsError(), 10);
			Assert.assertTrue(cbr.getOopsError().isDisplayed());
			System.out.println("CBR posting with different existing user credentials is working fine");
		}
		catch (Exception e) {
			Assert.fail("CBR posting with different existing user credentials allows to post the CBR");
		}
		
	}



	@Then("user enters {string} {string} and {string} in the destination page")
	public void user_enters_and_in_the_destination_page(String name, String mobile, String mailid) throws InterruptedException {
		scrolltoElement(cbr.getDestinationrequestCallback());
		typeText(cbr.getDestinationcbrName(), name);
		Thread.sleep(1000);
		typeText(cbr.getDestinationcbrMobile(), mobile);
		Thread.sleep(1000);
		typeText(cbr.getDestinationcbrEmail(), mailid);
		Thread.sleep(1000);
		clickAction(cbr.getDestinationrequestCallback());
		
	}
	
	
	@Then("User enters {string} and submit the CBR form")
	public void user_enters_and_submit_the_cbr_form(String passwd) throws InterruptedException {
		enterOtp(passwd);
		Thread.sleep(2000);
		clickAction(cbr.getPlaceRequest());
		
		
	}

	@Then("Validate whether Oops message with already account exists")
	public void validateWhetherAccountExistsMsg() throws InterruptedException {
		try
		{
			pollingWaitWithoutClickable(cbr.getOopsError(), 20);
			Assert.assertTrue(isElementVisible(cbr.getOopsError(), 20));
			Thread.sleep(2000);
		}
		catch(Exception ex) {
			Assert.fail("CBR is not posted in the packages page");
		}
	}

}
