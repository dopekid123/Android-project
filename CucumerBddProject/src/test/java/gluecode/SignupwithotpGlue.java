package gluecode;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class SignupwithotpGlue extends Kernel {

	@Given("Signup to the application with valid username and password with {string}, {string}, and name {string}")
	public void signup_to_the_application_with_valid_username_and_password_with_and(String uName, String passwd,
			String name) {
		// Sign up with valid mobile number and OTP
		Valid_signup_with_otp(uName, passwd, name);
	}

	@Then("validate whether the Signup is successful")
	public void validate_whether_the_signup_is_successful() throws InterruptedException {
		// validate whether the Signup is successful
		validate_successful_signup();
	}

	@When("Signup to the application with valid username and invalid password with {string}, {string} and name {string}")
	public void signup_to_the_application_with_valid_username_and_invalid_password_with_and_name(String uName,
			String invalidPasswd, String name) {
		// Sign up with valid mobile number and invalid OTP
		Signup_with_wrongotp(uName, invalidPasswd, name);
	}

	@Then("validate whether the Signup is unsuccessful")
	public void validate_whether_the_signup_is_unsuccessful() throws InterruptedException {
		// validate whether the Signup is unsuccessful
		Validate_unsuccessful_signup();
	}

	@Given("Signup to the application with invalid username with {string}")
	public void signup_to_the_application_with_invalid_username_with(String invalidUName) {
		// Signup to the application with invalid username
		Signup_with_invalid_mobile_num(invalidUName);

	}

	@Given("Signup as a new user while creating itinerary for MLE with {string}, {string}, {string}, and name {string}")
	public void signupNewUser(String url, String uName, String passwd, String name) {
		// Signup as a new user while creating itinerary for MLE
		Valid_signup_through_MLE(url, uName, passwd, name);
	}



	@Then("validate the itinerary is costed")
	public void validate_the_itinerary_is_costed() {
		// validate the itinerary is costed
		Validate_whether_itinerary_costed_succesfully();

	}

	@Given("Enter a valid mobile number {string} and name {string} page should navigate to the OTP screen")
	public void enter_a_valid_mobile_number_and_name_page_should_navigate_to_the_otp_screen(String uName, String name) {
		// Enter a valid mobile number and name page should navigate to the OTP screen
		Navigate_to_OTP_screen_while_signup(uName, name);
	}

	@When("Click on the View Deal button from the first package itinerary")
	public void click_on_View_Deal_button_from_the_first_package_itinerary() {
		try {
			click_on_View_Deal_button();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

	@When("Click on the No button to traverse back to the OTP screen")
	public void click_on_the_no_button_to_traverse_back_to_the_otp_screen() {
		// traverse back to the OTP screen
		traverse_back_to_the_OTP_screen_while_signup();
	}

	@Then("Close the OTP dialog box and validate whether the confirmation popup appears")
	public void close_the_otp_dialog_box_and_validate_whether_the_confirmation_popup_appears() {
		// Close the OTP dialog box and validate whether the confirmation popup appears
		validate_whether_the_confirmation_popupappears_while_signup();
	}

	@Then("Again click on the Yes button to navigate to the Packages page")
	public void again_click_on_the_yes_button_to_navigate_to_the_packages_page() {
		// Again click on the Yes button to navigate to the Home page
		Again_click_on_Yes_button_to_navigate_to_home_page_while_signup(adminPassword);

	}

	@Then("Enter the resent {string} to Signup to the application")
	public void enter_the_resent_to_signup_to_the_application(String passwd) {
		// Enter the resent OTP to Signup to the application
		Enter_resent_otp_while_signup(passwd);
	}

	@Given("Signup to the application with valid username {string} and name {string}")
	public void signup_to_the_application_with_valid_username_and_name(String firstNo, String name) {
		// Enter the first mobile number while signup
		Enter_first_number_while_signup(firstNo, name);
	}

	@Then("Signup to the application with valid username, password and name with {string} , {string} and {string}")
	public void signup_to_the_application_with_valid_username_password_and_name_with_and(String secondNo, String passwd,
			String secName) {
		// Enter the second mobile number while signup
		Enter_second_number_while_signup(secondNo, passwd, secName);
	}

	@When("Click on the edit icon for changing the mobile number")
	public void click_on_the_edit_icon_for_changing_the_mobile_number() throws InterruptedException {
		// Click on Edit mobile number icon
		Click_on_change_mobile_number_icon();
	}

	@Then("Signup to the application with valid username, name and password {string}, {string} and {string}")
	public void signup_to_the_application_with_valid_username_name_and_password_and(String uName, String name,
			String passwd) {
		Signup_through_packages(uName, name, passwd);
	}

	@Then("Signup to the application with valid username, name and invalid password {string}, {string} and {string}")
	public void signup_to_the_application_with_valid_username_name_and_invalid_password_and(String uName,
			String invalidPasswd, String name) {
		Signup_with_invalid_otp_packages(uName, invalidPasswd, name);
	}

	@Then("Signup to the application with invalid username in packages with {string}")
	public void signup_to_the_application_with_invalid_username_in_packages_with(String invaliduName) {
		Signup_with_invalid_mobile_number_packages(invaliduName);
	}

	@Given("Enter a valid mobile number {string} and name {string} page should navigate to the OTP screen in packages")
	public void Enter_a_valid_mobile_number_and_name_page_should_navigate_to_the_OTP_screen_in_packages(String uName,
			String name) throws NoSuchElementException, InterruptedException {
		Signup_with_valid_username_for_closing_OTP(uName, name);
	}

	@Given("Close the OTP dialog box and validate whether there is no confirmation popup appears in packages")
	@And("Close the OTP dialog box and validate whether the confirmation popup appears in packages")
	public void close_the_otp_dialog_box_and_validate_whether_the_confirmation_popup_appears_in_packages() {
		Click_on_close_otp_Button_in_packages();
		

	}

	@Then("Click on No button to traverse back to the OTP screen in packages")
	public void click_on_no_button_to_traverse_back_to_the_otp_screen_in_packages() {
		Click_on_NO_Button_while_popup_appears();
	}

	@Then("Again click on Yes button to navigate to the Packages page")
	public void again_click_on_yes_button_to_navigate_to_the_packages_page() {
		Click_on_YES_Button_while_popup_appears();
	}

	@Then("Enter the resent {string} in packages to Signup to the application")
	public void enter_the_resent_in_packages_to_signup_to_the_application(String passwd) throws Throwable {
		enterOtp(passwd);
		Thread.sleep(500);
		clickAction(packagesPage.getcontinuebutton());
		Thread.sleep(6000);
		switchWindows();
	}

	@When("Click on Resend OTP button and wait for {int} seconds in packages page")
	public void click_on_resend_otp_button_and_wait_for_seconds_in_packages_page(Integer int1) {
		click_on_button_and_wait_for_seconds(25);
	}

	@When("Click on the edit icon for changing the mobile number in packages page")
	public void click_on_the_edit_icon_for_changing_the_mobile_number_in_packages_page() throws Throwable {
		// Click on Edit mobile number icon
		Click_on_change_mobile_number_icon();
	}

	@Then("Signup to the application with valid username and password with {string}, {string} and {string} in packages")
	public void signup_to_the_application_with_valid_username_and_password_with_and_in_packages(String secondNo,
			String passwd, String name) {
		Signup_through_packages(secondNo, passwd, name);
	}

	@Then("Wait for {int} seconds and enter {string}")
	public void wait_for_seconds_and_enter(Integer int1, String passwd) {
		click_on_button_and_wait_for_OTP_to_expired(32, passwd);
	}
	
	@When("Click on the title from the first package itinerary")
	public void click_on_the_title_from_the_first_package_itinerary() {
		Click_on_packages_title_and_get_trip_cost_button();
	}
	
	@Then("Signup to the application with valid username, name and password {string}, {string} and {string} through slug.")
	public void signup_to_the_application_with_valid_username_name_and_password_and_through_slug(String uName, String name, String passwd) {
		Signup_through_slug(uName, name, passwd);
	}

	@Given("Signup as a new user while creating itinerary for dubai with {string}, {string}, {string}, {string}, and name {string}")
	public void signup_as_a_new_user_while_creating_itinerary_for_dubai_with_and_name(String region, String url, String uName, String passwd, String name) {
	    Valid_signup_for_dubai_PDG(region, url, uName, passwd, name);
	}


	@Given("Signup as a new user while creating itinerary for europe with {string}, {string}, {string}, and name {string}")
	public void signup_as_a_new_user_while_creating_itinerary_for_europe_with_and_name(String region, String uName, String passwd, String name) {
	   
		Valid_signup_for_europe_PDG(region, uName, passwd, name);
	}

	@Then("validate whether the Signup is successful and successfully created the itinerary through packages")
	public void validate_whether_the_signup_is_successful_and_successfully_created_the_itinerary_through_packages() throws InterruptedException {
		validate_successful_signup_through_packages();
	}



	@Given("Signup as a new user while creating itinerary for MLE listing with {string}, {string}, and name {string}")
	public void signup_as_a_new_user_while_creating_itinerary_for_mle_listing_with_and_name(String uName, String passwd, String name) throws InterruptedException {
		Valid_signup_through_MLE_listing(uName, passwd, name);
	
	}



















}
