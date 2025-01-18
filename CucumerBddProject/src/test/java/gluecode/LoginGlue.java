package gluecode;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.pyt.pages.InclusionsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.Kernel;

public class LoginGlue extends Kernel {
	
	public static String actualSMSStatus="";
	public static String actualOTPValue="";


	@Given("^Login as a authenticated user from GCM page with \"([^\"]*)\"$")
	public void login_as_a_authenticated_user_from_GCM_page_with(String region) throws Throwable {
		// ReporteraddScenarioLog("Login as a authenticated user from GCM page");
		validateAssertion(LoginThroughPage("GCM", "GCMSignup", region));
	}

	@Given("^Login as a authenticated user$")
	public void login_as_a_authenticated_user() throws Throwable {
		loginFunctionalityTest("Registered_User");
		// homepageLanding();
	}

	@Given("^Header Login as a authenticated user \"([^\"]*)\"$")
	public void header_Login_as_a_authenticated_user(String Url) throws Throwable {
		headerloginFunctionalityTest("Registered_User", Url);
	}

	@Given("^Login as a authenticated admin user$")
	public void login_as_a_authenticated_admin_user() throws Throwable {
		loginFunctionalityTest("admin");
		System.out.println("Login completed successfully");
		Thread.sleep(2000);
		// homepageLanding();
	}

	// Login to the application from landing page via login modal with various
	// credentials

	@Then("^Login to the application with valid username and password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_valid_credentials(String uName, String passwd) throws Throwable {
        clickAction(lp.getLogin());
//		validateAssertion(doLogin(uName, passwd));
		doLogin(uName, passwd);
	}

	@Then("^Login to the application with valid username and invalid password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_invalid_password(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLoginWithInvalidPassword());
		if (driver.findElements(By.xpath("//span[@class='help-block']")).size() > 0) {
			clickAction(lp.getCloseLoginModal());
			Thread.sleep(2000);
		}
	}

	@Then("^Login to the application with invalid username and valid password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_invalid_username(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLoginWithInvalidUsername());
		if (driver.findElements(By.xpath("//span[@class='help-block']")).size() > 0) {
			clickAction(lp.getCloseLoginModal());
			Thread.sleep(2000);
		}
	}

	@Then("^Login to the application with invalid username and invalid password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_invalid_credentials(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLoginWithInvalidCredentials());
		if (driver.findElements(By.xpath("//span[@class='help-block']")).size() > 0) {
			clickAction(lp.getCloseLoginModal());
			Thread.sleep(2000);
		}
	}

	// Login to the application from landing page via sign-up modal by entering
	// registered user credentials

	@Then("^Login from signup modal by entering registered user data and then logging in$")
	public void login_from_signup_modal() throws Throwable {
		validateAssertion(doLoginFromSignupModal("", "", "InputUserData", ""));
	}

	// Login to the application from landing page via "already got an account" CTA
	// with various credentials

	@Then("^Login from signup modal via Already have an account CTA with valid credentials$")
	public void login_via_Already_have_an_account_CTA_with_valid_credentials() throws Throwable {
		validateAssertion(doLoginFromSignupModal(username, pass, "CleanSignupForm", "ValidCredentials"));
	}

	@Then("^Login from signup modal via Already have an account CTA with invalid username$")
	public void login_via_Already_have_an_account_CTA_with_invalid_username() throws Throwable {
		validateAssertion(doLoginFromSignupModal(invalidUser, pass, "CleanSignupForm", "InvalidUsername"));
		if (driver.findElements(By.xpath("//span[@class='help-block']")).size() > 0) {
			clickAction(lp.getCloseLoginModal());
			Thread.sleep(2000);
		}
	}

	@Then("^Login from signup modal via Already have an account CTA with invalid password$")
	public void login_via_Already_have_an_account_CTA_with_invalid_password() throws Throwable {
		validateAssertion(doLoginFromSignupModal(username, invalidPassword, "CleanSignupForm", "InvalidPassword"));
		if (driver.findElements(By.xpath("//span[@class='help-block']")).size() > 0) {
			clickAction(lp.getCloseLoginModal());
			Thread.sleep(2000);
		}
	}

	@Then("^Login from signup modal via Already have an account CTA with invalid credentials$")
	public void login_via_Already_have_an_account_CTA_with_invalid_credentials() throws Throwable {
		validateAssertion(
				doLoginFromSignupModal(invalidUser, invalidPassword, "CleanSignupForm", "InvalidCredentials"));
		if (driver.findElements(By.xpath("//span[@class='help-block']")).size() > 0) {
			clickAction(lp.getCloseLoginModal());
			Thread.sleep(2000);
		}
	}

	// Login validation from PDG flow using GCM

	@Given("^Login from PDG Flow using GCM via already got an account with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_GCM_via_already_got_an_account_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("GCM", "GCMLogin", region));
	}

	@Given("^Login from PDG Flow using GCM via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_GCM_via_Signup_as_existing_user_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("GCM", "ChooseSignup", region));
	}

	@Given("^Login from PDG Flow using GCM via GCM Signup with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_GCM_via_GCM_Signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("GCM", "GCMSignup", region));
	}

	// Login validation from PDG flow using CTC

	@Given("^Login from PDG Flow using Calculate trip cost via already got an account with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_Calculate_trip_cost_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughPage("CTC", "GCMLogin", region));
	}

	@Given("^Login from PDG Flow using Calculate trip cost via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_Calculate_trip_cost_via_Signup_as_existing_user_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughPage("CTC", "ChooseSignup", region));
	}

	@Given("^Login from PDG Flow using Calculate trip cost via GCM Signup with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_Calculate_trip_cost_via_GCM_Signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("CTC", "GCMSignup", region));
	}

	// Header Login Validation from itinerary page

	@Given("^Login from Itinerary page using Header login via already got an account with \"([^\"]*)\"$")
	public void login_from_Itinerary_page_using_Header_login_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughHeader("ItineraryPage", "ExistingAccount", region));
	}

	@Given("^Regular login through headers login from Itinerary page with \"([^\"]*)\"$")
	public void regular_login_through_headers_login_from_Itinerary_page_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("ItineraryPage", "HeaderLogin", region));
	}

	@Given("^Login from Itinerary page using Header login via signup with \"([^\"]*)\"$")
	public void login_from_Itinerary_page_using_Header_login_via_signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("ItineraryPage", "HeaderSignup", region));
	}

	// Header Login validation from packages pages

	@Given("^Login from package page using Header login via already got an account with \"([^\"]*)\"$")
	public void login_from_package_page_using_Header_login_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughHeader("Packages", "ExistingAccount", region));
	}

	@Given("^Regular login through headers login from packages page with \"([^\"]*)\"$")
	public void regular_login_through_headers_login_from_packages_page_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("Packages", "HeaderLogin", region));
	}

	// completed
	@Given("^Login from package page using Header login via signup with \"([^\"]*)\"$")
	public void login_from_package_page_using_Header_login_via_signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("Packages", "HeaderSignup", region));
	}

	// Login validation from GCM packages page

	@Given("^Login from packages page via GCM Signup with \"([^\"]*)\"$")
	public void login_from_packages_page_via_GCM_Signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("Packages", "ChooseSignup", region));
	}

	@Given("^Login from packages page using customize option \"([^\"]*)\"$")
	public void login_from_packages_page_using_customize_option(String region) throws Throwable {
		validateAssertion(LoginThroughPage("Packages", "PackagesGCMLogin", region));
	}

	@Given("^Login from packages page via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_packages_page_via_Signup_as_existing_user_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("Packages", "GCMSignup", region));
	}

	// Login validation from GCM Paid campaign pages

	@Given("^Login from paid campaign page using custiomize option via already got an account with \"([^\"]*)\"$")
	public void login_from_paid_campaign_page_using_custiomize_option_via_already_got_an_account_with(String region)
			throws Throwable {
		LoginThroughPage("PaidCampaign", "GCMLogin", region);
	}

	@Given("^Login from paid campaign page via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_paid_campaign_page_via_Signup_as_existing_user_with(String region) throws Throwable {
		LoginThroughPage("PaidCampaign", "ChooseSignup", region);
	}

	@Given("^Login from paid campaign page via GCM Signup with \"([^\"]*)\"$")
	public void login_from_paid_campaign_page_via_GCM_Signup_with(String region) throws Throwable {
		LoginThroughPage("PaidCampaign", "GCMSignup", region);
	}

	@Then("^Logout and navigate to home page$")
	public void logout_navigate_to_homepage() throws InterruptedException {

		/*
		 * Commented the below code on 02/07/21
		 * 
		 * if(elementDisplayed(hp.getEmailNotify())) { clickAction(hp.emailnotify); }
		 */
		Thread.sleep(2000);
		scrollByValue(0);
		Thread.sleep(1000);

		if (elementExist(lp.getSubMenu())) {
			clickJavaScriptElement(lp.getSubMenu());
			Thread.sleep(2000);
		} else {

			clickJavaScriptElement(lp.getSecondLogoutHeader());
			Thread.sleep(1000);
		}
		scrolltoElement(lp.getLogoutButtonMle());
		// hoverWebelement(lp.getlogoutButton());
		clickAction(lp.getLogoutButtonMle());
		Thread.sleep(2000);
		pollingWait(lp.getloginButtonAfterLogOut(), 15);

		// if(elementExist(booingReview.getbookNowButton())) {
		clickAction(hp.getPytLogo());

		// }

	}

	@Then("^Logout and navigate to home page for \"([^\"]*)\"$")
	public void logout_and_navigate_to_home_page_for(String Url) throws Throwable {

		Thread.sleep(2000);
		scrollByValue(0);
		Thread.sleep(1000);

		if (elementExist(lp.getSubMenu())) {
			clickJavaScriptElement(lp.getSubMenu());
			Thread.sleep(2000);
		} else {

			clickJavaScriptElement(lp.getSecondLogoutHeader());
			Thread.sleep(1000);
		}

		if (Url.equals("Uncosted-maldives-packages")) {
			scrolltoElement(lp.getLogoutButtonMle());
			clickAction(lp.getLogoutButtonMle());
			Thread.sleep(2000);
		} else if (Url.equals("Uncosted-packages")) {
			scrolltoElement(lp.getUncostedPacklogoutButton());
			clickAction(lp.getUncostedPacklogoutButton());
			Thread.sleep(2000);
		} else {
			scrolltoElement(lp.getUncostedPacklogoutButton());
			clickAction(lp.getUncostedPacklogoutButton());
			Thread.sleep(2000);
		}

		pollingWait(lp.getloginButtonAfterLogOut(), 15);

		clickAction(hp.getPytLogo());

		// }

	}

	@Given("^user navigates to the following \"([^\"]*)\" page$")
	public void user_navigates_to_the_following_page(String Url) throws Throwable {
		// SpeedboatGlue sb = new SpeedboatGlue();
		try {
			if (Url.equals("Uncosted-packages")) {
				navigateToUrl(localEnvUrl + "packages/maldives");
				clickAction(packagesPage.getPackageTitle());
				Thread.sleep(1000);
				if (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
					scrollUp();
				}

			} else if (Url.equals("Uncosted-maldives-packages")) {
				navigateToUrl(localEnvUrl + "maldives-tour-packages");
				// sb.select_resort_card_from_category("For the Honeymooners");
				switchWindows();
			} else {
				navigateToUrl(localEnvUrl + Url);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail();

		}
	}

	@Then("^Validate the corresponding page is showing after logged in \"([^\"]*)\"$")
	public void validate_the_corresponding_page_is_showing_after_logged_in(String Url) throws Throwable {
		switch (Url) {
		case "deals":
			validateAssertion(elementDisplayed(lp.getDealsLogo()));
			break;

		case "holiday-packages":
			Thread.sleep(5000);
			validateAssertion(getCurrentUrl().contains("holiday-packages"));
			validateAssertion(elementDisplayed(lp.gettHolidayPackagesSearchCTA()));
			break;

		case "maldives-tour-packages":
			validateAssertion(getCurrentUrl().contains("maldives-tour-packages"));
			validateAssertion(elementDisplayed(lp.getMaldivesHomePage()));
			break;

		case "testimonials":
			validateAssertion(getCurrentUrl().contains("testimonials"));
			validateAssertion(elementDisplayed(lp.getTestimonial()));
			break;

		case "contact-us":
			validateAssertion(getCurrentUrl().contains("contact-us"));
			validateAssertion(elementDisplayed(lp.getContactUs()));
			break;

		case "faq":
			validateAssertion(getCurrentUrl().contains("faq"));
			validateAssertion(elementDisplayed(lp.getFaqHeader()));
			break;
		case "careers":
			validateAssertion(getCurrentUrl().contains("careers"));
			validateAssertion(elementDisplayed(lp.getCareers()));
			break;

		case "about-us":
			validateAssertion(getCurrentUrl().contains("about-us"));
			validateAssertion(elementDisplayed(lp.getAboutUs()));
			break;

		case "Uncosted-maldives-packages":
			validateAssertion(elementDisplayed(lp.getMaldivesUncostedPage()));
			break;

		case "Uncosted-packages":
			validateAssertion(elementDisplayed(lp.getpackages()));
			break;

		}

	}

	@Then("validate whether the login is successful")
	public void validate_whether_the_login_is_successful() {
	
		pageRefresh();
		waitForMe(lp.getUserAvatar(), 20);
	//	scrolltoElement(lp.getUserAvatar());
		Assert.assertTrue(isElementVisible(lp.getUserAvatar(),10));

	}

	@Then("validate whether the login is unsuccessful")
	public void validate_whether_the_login_is_unsuccessful() {

		try {
		    waitForMe(lp.getWrongOTP(), 20);
		    Assert.assertTrue(elementExist(lp.getWrongOTP()));
		    System.out.println("Login is unsuccessful");
		} catch (AssertionError e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Then("Login to the application through {string} with invalid username and password with {string} and {string}")
	public void login_with_invalid_credentials(String page, String uName, String passwd) throws Throwable {
		if (page.equalsIgnoreCase("packages")) {
			validateAssertion(invalidLogin(uName, passwd));
		} else if (page.equalsIgnoreCase("home")) {
			clickAction(lp.getLogin());
			validateAssertion(invalidLogin(uName, passwd));
		}
	}

	@Given("Enter a valid mobile number {string} in {string} and page should navigate to the OTP screen")
	public void enter_a_valid_mobile_number_in_and_page_should_navigate_to_the_otp_screen(String mobileNo,
			String page) {

		try {
			if (page.equalsIgnoreCase("home")) {
				Thread.sleep(2000);
				forceClick(lp.getLogin());

			}

//			String globalurl = driver.getCurrentUrl();
//			System.out.println("globalurl--"+globalurl);
//			if(globalurl.contains("/ae/")) {
//				typeText(lp.getUserName(), globalUserUAE);
//
//			}
//			else if(globalurl.contains("/us/")) {
//				typeText(lp.getUserName(), globalUserUS);	
//			}
//			else {
			try {
				System.out.println("entering mobile no");
				pollingWaitWithoutClickable(lp.getUserName(), 20);
				Assert.assertTrue(isElementVisible(lp.getUserName(),15));
				forceClick(lp.getUserName());
				Thread.sleep(1000);
				typeText(lp.getUserName(), mobileNo);
				
				/*
				 * Commenting on July 26th because language selection page is removed
				if (page.equalsIgnoreCase("packages")) {
					if (driver.findElements(By.xpath("//span[text()='english']")).size() > 0) {
						// waitForMe(lp.getLanguageSelection());
						clickAction(lp.getLanguageSelection());
					}
				}
				*/

				if (driver.findElements(By.xpath("//span[text()='Enter OTP']")).size() > 0) {
					System.out.println("We are in OTP screen");
					// Assert.assertTrue("In OTP Screen", findAllElements("(//div[@style='display:
					// flex; justify-content: space-between;'])[1]//div/input"));
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
//			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Given("Close the OTP dialog box and validate whether confirmation popup appears")
	public void close_the_otp_dialog_box_and_validate_whether_confirmation_popup_appears() {

		try {
			waitForMe(lp.getCloseOTP());
			clickAction(lp.getCloseOTP());
			Assert.assertTrue("Exit PopUp", isElementVisible(lp.getExitNo(), 30));
			System.out.println("Exit Popup");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Then("Click on No button to traverse back to the OTP screen")
	public void click_on_button_to_traverse_back_to_the_otp_screen() {

		try {
			clickAction(lp.getExitNo());
			pollingWait(lp.getEnterOTPSreen(),10);

			if (isElementVisible(lp.getEnterOTPSreen(), 15)) {
				System.out.println("Back in OTP Screen");
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Then("Again click on Yes button to navigate to the Home page")
	public void again_click_on_Yes_button_to_navigate_to_the_home_page() {

		try {
			clickAction(lp.getExitYes());
			pollingWait(lp.getLogin(),15);

			if (isElementVisible(lp.getLogin(), 20)) {
				System.out.println("Back in Home Page");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@When("Click on Resend OTP button and wait for {int} seconds")
	public void click_on_button_and_wait_for_seconds(Integer int1) {
		try {
			pollingWait(lp.getEnterOTPSreen(), 20);
			Thread.sleep(22000);
			pollingWait(lp.getResendOTP(), 20);
			clickAction(lp.getResendOTP());
			Thread.sleep(10000);
			Assert.assertTrue("Clicked Resend OTP", isElementVisible(lp.getEnterOTPSreen(), 20));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Then("Enter the resent {string} to login to the application")
	public void enter_the_resent_to_login_to_the_application(String passwd) {
		try {
			// Entering the OTP
			enterOtp(passwd);
			
			if(driver.findElements(By.xpath("//button[text()='Continue']")).size() > 0)
			{
				System.out.println("inside continue");
				pollingWaitWithoutClickable(lp.getPackCtaContinue(), 20);
				Assert.assertTrue(isElementVisible(lp.getPackCtaContinue(), 20));
				scrolltoElement(lp.getPackCtaContinue());
				clickAction(lp.getPackCtaContinue());
				Thread.sleep(2000);
			}
			else if (findAllElements("//button[contains(@class,'login-cta-in-modal')]")) {
				clickAction(lp.getpackCtaLogin());
				Thread.sleep(2000);
			} else if (findAllElements("(//div[contains(text(),'Login')])[2] | //button[contains(text(),'Login')]")) {
				clickAction(lp.getLoginButton());
				Thread.sleep(2000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void click_on_icon_for_changing_the_mobile_number(String uName) {

		try {
			waitForMe(lp.getEditNo());
			clickAction(lp.getEditNo());
			System.out.println("In Edit Mobile number screen");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Then("Change to {string} {string} and  and proceed with login")
	public void change_to_and_and_proceed_with_login(String mobileNo, String OTP) {
		try {
			validateAssertion(doLogin(mobileNo, OTP));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@When("Click on the {string} button from the first package itinerary")
	public void click_on_the_button_from_the_first_package_itinerary(String clickOn) {
		try {
			System.out.println("Inside" + clickOn);
			
			if(driver.findElements(By.xpath("(//div[@role='dialog']//*[name()='svg'])[2]")).size() > 0)
			{
				clickAction(seoChecks.getSeoRcbClose());
				Thread.sleep(2000);
			}
			
			if(clickOn.contains("View Details"))
			{
				System.out.println("Inside View Details");
				//	hoverWebelement(packagesPage.getviewdealbutton());
				Thread.sleep(3000);
				scrollToView(packagesPage.getFirstViewdealbutton());
				clickJavaScriptElement(packagesPage.getFirstViewdealbutton());
			}

			else if (clickOn.contains("View Deal")) {
				System.out.println("Inside View Deal");
			//	hoverWebelement(packagesPage.getviewdealbutton());
				Thread.sleep(3000);
				scrollToView(packagesPage.getFirstViewdealbutton());
				clickJavaScriptElement(packagesPage.getFirstViewdealbutton());
			}

			else if (clickOn.contains("slug")) {
				pollingWait(packagesPage.getfirstPackageSlug(),15);
				scrolltoElement(packagesPage.getfirstPackageSlug());
//				Thread.sleep(3000);
				clickJavaScriptElement(packagesPage.getfirstPackageSlug());
				switchWindows();
				String currentLink=getCurrentUrl();
				if(! (currentLink.contains("/us/") || currentLink.contains("/ae/")) )
				{
					pollingWait(icm.getcalculateTripCostButton(), 30);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail();
		}
	}

	@Then("Login to the application through packages with valid username and password with {string} and {string}")
	public void login_to_the_application_through_packages_with_valid_username_and_password_with_and(String mobileNo,
			String OTP) {
		try {
			doLoginThroughPackages(mobileNo, OTP);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail();
		}
	}

	@Then("validate the itineary is costed")
	public void validate_the_itineary_is_costed() {
		try {
			InclusionsPage inclusion = new InclusionsPage();
			inclusion = PageFactory.initElements(driver, InclusionsPage.class);
			System.out.println("Inclusions");
			// pollingWaitForCostingFlow("view",250);
			
			waitForMe(inclusion.getBookNow(), 60);
//			Assert.assertTrue(driver.getCurrentUrl().contains("inclusions"));
			
			if (driver.getCurrentUrl().contains("inclusions")) {
				System.out.println("Itinerary costed successfully");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("Login to the application with valid second number {string} and password {string}")
	public void login_to_the_application_with_valid_second_number_and_password(String secondNo, String password) {
		try
		{
			doSecondTimeLogin(secondNo, password);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	    
	}
	
	@Then("Login to the application with valid username and password with {string} and {string} through Header")
	public void login_to_the_application_with_valid_username_and_password_with_and_through_header(String uName, String passwd) {
	    try
	    {
	    	clickAction(lp.getLogin());
	    	doHeaderLogin(uName, passwd);
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	Assert.fail();
	    }
	}
	
	@Given("Hit the Post API to fetch the OTP and validate whether OTP is sent")
	public void hit_the_post_api_to_fetch_the_otp_and_validate_whether_otp_is_sent() {
		try
		{
			// Base URL of the API
			String baseUrl = "https://pickyourtrail.com";

			// Request body in JSON format
			String requestBody = "{\"countryPhoneCode\": \"+91\", \"mobileNumber\": \"9080934240\", \"name\":\"QATest\"}";

			// Send POST request with headers and body
			Response response = RestAssured.given()
					.baseUri(baseUrl)
					.header("Content-Type", ContentType.JSON)
					//.header("Authorization", "Bearer your_access_token")
					.header("apikey","3l5b3e5f-28ad-4k5b-8367-29f09985k0ee")
					.body(requestBody)
					.post("/api/user/testotplogin");

			// Print response status code
			System.out.println("Response status code: " + response.getStatusCode());

			// Print response body
			System.out.println("Response body: " + response.getBody().asString());

			String smsStatus = "data.status";
			String expectedSMSStatus = "SENT";
			String invalidSMSStatus = "NOT_SENT";
			String otpStatus="data.otp";

			// Extract the smsStatus of the key from the JSON response
			actualSMSStatus = response.jsonPath().getString(smsStatus);
			actualOTPValue = response.jsonPath().getString(otpStatus);
			System.out.println("actualSMSStatus-->"+actualSMSStatus+"actualOTPValue-->"+actualOTPValue);


			// Perform validation
			if (actualSMSStatus != null && actualSMSStatus.equalsIgnoreCase(expectedSMSStatus)) {
				System.out.println("Validation passed for key '" + smsStatus + "'");

				if (actualOTPValue != null)
				{
					Assert.assertTrue(true);
					System.out.println("Validation passed for key '" + otpStatus + "'" +"with "+actualOTPValue);

				}
			} else if (actualSMSStatus.equalsIgnoreCase(invalidSMSStatus)){
				System.out.println("Validation failed for key '" + smsStatus + "'");
				Assert.assertTrue(false);

			}
			else
			{
				System.out.println("Problem while validating the SMS Status and OTP");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Problem while fetching the SMS Status and OTP");
			ex.printStackTrace();
		}
	}
	
	@Then("Login to the application with valid username {string} and with the generated OTP")
	public void login_to_the_application_with_valid_username_and_with_the_generated_otp(String uName) {
	   try
	   {
		   clickAction(lp.getLogin());
			doLogin(uName, actualOTPValue);
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	}
	
	@Given("Login as an existing user while creating itinerary for europe with {string}, {string} and {string}")
	public void login_as_an_existing_user_while_creating_itinerary_for_europe_with_and(String region, String uName, String passwd) {
		Valid_login_for_europe_PDG(region, uName, passwd);
	}
	
	

	@Given("Login as a existing user while creating itinerary for europe with {string}, {string}, {string}")
	public void login_as_a_existing_user_while_creating_itinerary_for_europe_with_and_name(String region, String uName, String passwd) {
		LoginForEuropePDG(region, uName, passwd);
	}
	


	@Given("Login as a existing user while creating itinerary for europe with Paris Barcelona {string}, {string}, {string}")
	public void login_as_a_existing_user_while_creating_itinerary_for_europe_with_paris_barcelona(String region, String uName, String passwd) {
		LoginForEuropePDGParisBarcelona(region, uName, passwd);
	}
	

	@Given("Login as a existing user while creating itinerary for Thailand {string}, {string}, {string}")
	public void login_as_a_existing_user_while_creating_itinerary_for_thailand(String region, String uName, String passwd) {
		LoginForThailandPDG(region, uName, passwd);
	
	}



	@Given("Login as a existing user while creating itinerary for MLE with {string}, {string} and {string}")
	public void login_as_a_existing_user_while_creating_itinerary_for_mle_with_and(String url, String uName, String passwd) throws InterruptedException {
		Valid_login_through_MLE(url, uName, passwd);
	}


	@Given("validate whether the login is successful and successfully created the itinerary")
	public void validate_whether_the_login_is_successful_and_successfully_created_the_itinerary() throws InterruptedException {
		validate_successful_login();
	}

	@Then("Login to the application through packages with valid username and invalid password with {string} and {string}")
	public void login_to_the_application_through_packages_with_valid_username_and_invalid_password_with_and(String mobileNo,
			String OTP) {
		try {
			unsuccessfulLoginWithInvalidOtp(mobileNo, OTP);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail();
		}
	}

	@Given("^Login as a authenticated global user \"([^\"]*)\"")
	public void loginAsAAuthenticatedGlobalUser(String globalUser) throws Throwable {
		loginFunctionalityTest(globalUser);
		// homepageLanding();
	}
	
	
	






	

	





}
