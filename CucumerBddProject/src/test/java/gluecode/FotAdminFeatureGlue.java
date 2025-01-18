package gluecode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import freemarker.core.ReturnInstruction.Return;
import groovyjarjarantlr4.v4.parse.ANTLRParser.elementOptions_return;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class FotAdminFeatureGlue extends Kernel {

	String updatedEmail = "";

	@Given("Login to the product with admin credential using {string} and {string}")
	public void login_to_the_product_with_admin_credential_using_and(String adminNo, String iPin) {

		validateAssertion(loginAsAdmin(adminNo, iPin));

	}

	@Then("Share the itinerary with customer mobile number using {string}")
	public boolean share_the_itinerary_with_customer_mobile_number_using(String mobileNo) {

		boolean retvalue = false;

		try {
			// Wait and interact with buttons

			pollingWait(pbp.getShareItineraryButton(), 25);
			assertTrue(pbp.getShareItineraryButton().isDisplayed());
			clickAction(pbp.getShareItineraryButton());

			List<WebElement> alerts = driver.findElements(By.xpath("//button[@type='button' and @value]"));
			String alert = "//button[@type='button' and @value]";
			int size = alerts.size();
			System.out.println(size);

			for (int i = 1; i <= size; i++) {

				WebElement clickalert = driver.findElement(By.xpath("(" + alert + ")[" + i + "]"));
				pollingWait(clickalert, 10);
				Thread.sleep(500);
				clickAction(clickalert);

			}

			pollingWait(pbp.getAcknowledgeButton(), 25);
			assertTrue(pbp.getAcknowledgeButton().isDisplayed());
			clickAction(pbp.getAcknowledgeButton());

			pollingWait(pbp.getMobileNumberShareItinerary(), 25);
			assertTrue(pbp.getMobileNumberShareItinerary().isDisplayed());
			typeText(pbp.getMobileNumberShareItinerary(), mobileNo);

			pollingWait(pbp.getFetchAccountButton(), 25);
			assertTrue(pbp.getFetchAccountButton().isDisplayed());
			clickAction(pbp.getFetchAccountButton());

			// Check if the fetched user details are displayed
			boolean fetchUserDisplayed = false;
			try {
				fetchUserDisplayed = pbp.getfetchUserDetails().isDisplayed();
			} catch (NoSuchElementException e) {
				System.out.println("Fetched user details are not displayed.");
			}

			// If user details are not displayed, enter name and email if available
			if (!fetchUserDisplayed) {
				System.out.println("Entering name and email since fetched user details are not displayed.");

				try {
					if (pbp.getNameShareItinerary().isDisplayed()) {
						typeText(pbp.getNameShareItinerary(), "Test AB Card");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Name field is not displayed.");
				}

				try {
					if (pbp.getEmailShareItinerary().isDisplayed()) {
						typeText(pbp.getEmailShareItinerary(), mobileNo + "@gmail.com");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Email field is not displayed.");
				}
			}

			// Continue with the next set of actions regardless of whether fetched user
			// details were displayed or not
			System.out.println("Proceeding to the trail source dropdown...");
			pollingWait(pbp.getTrailSourceDropDown(), 25);
			assertTrue(pbp.getTrailSourceDropDown().isDisplayed());
			clickAction(pbp.getTrailSourceDropDown());

			pollingWait(pbp.getdirectTrailSource(), 25);
			assertTrue(pbp.getdirectTrailSource().isDisplayed());
			clickAction(pbp.getdirectTrailSource());

			pollingWait(pbp.getFlowAndMethodDropDown(), 25);
			assertTrue(pbp.getFlowAndMethodDropDown().isDisplayed());
			clickAction(pbp.getFlowAndMethodDropDown());

			pollingWait(pbp.getpdgFlowAndMethod(), 25);
			assertTrue(pbp.getpdgFlowAndMethod().isDisplayed());
			clickAction(pbp.getpdgFlowAndMethod());

			pollingWait(pbp.getCallNotesFieldShareItinerary(), 25);
			assertTrue(pbp.getCallNotesFieldShareItinerary().isDisplayed());
			typeText(pbp.getCallNotesFieldShareItinerary(), "Test Trail");

			pollingWait(pbp.getContinueButton(), 25);
			assertTrue(pbp.getContinueButton().isDisplayed());
			clickAction(pbp.getContinueButton());

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			retvalue = false;
		}

		return retvalue;
	}

	@Then("Create an itinerary with {string}")
	public boolean create_an_itinerary_with(String region) {

		boolean retvalue = false;
		String currentUrl = getCurrentUrl();

		try {
			if (currentUrl.contains("pickyourtrail")) {

				pollingWait(pdgflowp.getsearchcountries(), 25);
				Assert.assertTrue(pdgflowp.getsearchcountries().isDisplayed());
				clickAction(pdgflowp.getsearchcountries());
				typeText(pdgflowp.getpickYourDestinationField(), region);
				pollingWait(pdgflowp.getdestinationeurope(), 20);
				Assert.assertTrue(pdgflowp.getdestinationeurope().isDisplayed());
				clickAction(pdgflowp.getdestinationeurope());
				Thread.sleep(500);

				/*
				 * Commenting on Feb 6th 2024 because of PDG flow change in Europe
				 * 
				 * Assert.assertTrue(dubaiPage.getDepmonth().isDisplayed());
				 * clickAction(dubaiPage.getDepmonth()); Thread.sleep(500);
				 * 
				 */

				/*
				 * Commenting on Jan 10th 2024
				 * 
				 * clickAction(dubaiPage.getDateOneButton()); Thread.sleep(500);
				 * clickAction(dubaiPage.getchnDepcity()); Thread.sleep(500);
				 */

				pollingWait(dubaiPage.getdepdays(), 20);
				Assert.assertTrue(dubaiPage.getdepdays().isDisplayed());
				clickAction(dubaiPage.getdepdays());
				Thread.sleep(500);

				pollingWait(dubaiPage.getsolostaytype(), 20);
				Assert.assertTrue(dubaiPage.getsolostaytype().isDisplayed());
				clickAction(dubaiPage.getsolostaytype());
				Thread.sleep(500);

				pollingWait(pdgflowp.getFindACity(), 20);
				Assert.assertTrue(pdgflowp.getFindACity().isDisplayed());
				clickAction(pdgflowp.getFindACity());
				typeText(pdgflowp.getFindACity(), "Barcelona");

				pollingWait(pdgflowp.getBarcelonaCity(), 20);
				Assert.assertTrue(pdgflowp.getBarcelonaCity().isDisplayed());
				clickAction(pdgflowp.getBarcelonaCity());
				Thread.sleep(500);

				pollingWait(dubaiPage.getBuildItinerary(), 20);
				Assert.assertTrue(dubaiPage.getBuildItinerary().isDisplayed());
				clickAction(dubaiPage.getBuildItinerary());
				Thread.sleep(500);
				retvalue = true;
				System.out.println(retvalue);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			retvalue = false;
			assertFalse(retvalue);
			System.out.println(retvalue);

		}

		return retvalue;
	}

	@Then("Validate whether the itinerary shared successfully")
	public boolean validate_whether_the_itinerary_shared_successfully() {

		boolean retvalue = false;

		try {

			WebElement itinerarySharedSuccessMessage = driver
					.findElement(By.xpath("//div//h1[contains(text(),'Your itinerary is on its way to your inbox.')]"));
			String text = itinerarySharedSuccessMessage.getText();
			System.out.println(text);
			validate_String_Contains(text, "Your itinerary is on its way to your inbox");

			pollingWait(pbp.getcloseIcon(), 20);
			assertTrue(pbp.getcloseIcon().isDisplayed());
			clickAction(pbp.getcloseIcon());

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while sharing the itinerary");
		}

		return retvalue;

	}

	@Then("Click on send to plato button")
	public boolean click_on_send_to_plato_button() {

		boolean retvalue = false;

		try {

			pollingWait(pbp.getsendtoplatoButton(), 20);
			assertTrue(pbp.getsendtoplatoButton().isDisplayed());
			clickAction(pbp.getsendtoplatoButton());

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on send to plato button");
		}

		return retvalue;

	}

	@Then("validate whether the data send to Plato")
	public boolean validate_whether_the_data_send_to_plato() {

		boolean retvalue = false;

		try {

			WebElement SendToPlatoSuccessMessage = driver.findElement(
					By.xpath("//div[@role='dialog']//h4[text()='Success!' or text()='The data sent to PLATO']"));
			String text = SendToPlatoSuccessMessage.getText();
			System.out.println(text);

			validate_String_Contains(text, "Success!");

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on send to plato button");
		}

		return retvalue;

	}

	@Then("Click on Override exposure payment button")
	public boolean click_on_override_exposure_payment_button() {
		boolean retvalue = false;

		try {

			scrolltoElement(pbp.getoverridePaymentExposureButton());
			pollingWait(pbp.getoverridePaymentExposureButton(), 25);
			assertTrue(pbp.getoverridePaymentExposureButton().isDisplayed());
			clickAction(pbp.getoverridePaymentExposureButton());

			pollingWait(pbp.getreasonOverrideDropDown(), 25);
			assertTrue(pbp.getreasonOverrideDropDown().isDisplayed());
			typeText(pbp.getreasonOverrideDropDown(), "Others");
			clickAction(pbp.getothersOption());
			typeText(pbp.getremarkField(), "Test Trail");
			pollingWait(pbp.getoverridebutton(), 25);
			assertTrue(pbp.getoverridebutton().isDisplayed());
			clickAction(pbp.getoverridebutton());

			assertTrue(pbp.getoverrideSuccessMessage().isDisplayed());
			WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
			clickAction(okButton);
			System.out.println("Exposure amount successfully overrided");

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while performing override payment");
		}

		return retvalue;

	}

	@Then("Validate exposure payment was overrided")
	public void validate_exposure_payment_was_overrided() {
		try {
			assertTrue(pbp.getoverrideSuccessMessage().isDisplayed());
			WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
			clickAction(okButton);

		} catch (Exception e) {
			fail("Problem while performing override payment");
			e.printStackTrace();
		}

	}

	@Then("Click on the Reset Override exposure payment button")
	public boolean click_on_the_reset_override_exposure_payment_button() {

		boolean retvalue = false;

		try {

			scrolltoElement(pbp.getoverRideResetButton());
			pollingWait(pbp.getoverRideResetButton(), 25);
			assertTrue(pbp.getoverRideResetButton().isDisplayed());
			clickAction(pbp.getoverRideResetButton());

			pollingWait(pbp.getreasonOverrideDropDown(), 25);
			assertTrue(pbp.getreasonOverrideDropDown().isDisplayed());
			typeText(pbp.getreasonOverrideDropDown(), "Others");
			clickAction(pbp.getothersOption());
			typeText(pbp.getremarkField(), "Test Trail");
			clickAction(pbp.getoverRideResetButton());

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while performing resetting override payment");
		}

		return retvalue;

	}

	@Then("Validate Override payment was reseted")
	public void validate_override_payment_was_reseted() {

		try {
			assertTrue(pbp.getoverRideResetSuccessMessage().isDisplayed());
			WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
			clickAction(okButton);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while performing resetting override payment");
		}

	}

	@Then("Click on cancellation policy button")
	public void click_on_cancellation_policy_button() {

		try {
			pollingWait(pbp.getCancellationPolicyButton(), 25);
			assertTrue(pbp.getCancellationPolicyButton().isDisplayed());
			clickAction(pbp.getCancellationPolicyButton());

		} catch (InterruptedException e) {
			e.printStackTrace();
			fail("Problem while performing resetting override payment");
		}

	}

	@Then("Validate whether cancellation policy displayed")
	public void validate_whether_cancellation_policy_displayed() {

		try {
			WebElement cancellation = driver
					.findElement(By.xpath("//div//h5[contains(text(),'Cancellation & Refunds')]"));
			assertTrue(cancellation.isDisplayed());

			String cancellandrefundtext = cancellation.getText();
			System.out.println(cancellandrefundtext);

			validate_String_Contains(cancellandrefundtext, "Cancellation & Refunds");

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while performing resetting override payment");
		}

	}

	@Then("Click on change email button")
	public void click_on_change_email_button() {

		try {

			pollingWait(pbp.getchangeEmailButton(), 25);
			assertTrue(pbp.getchangeEmailButton().isDisplayed());
			clickAction(pbp.getchangeEmailButton());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on change email");
		}

	}

	@Then("Enter a valid email address")
	public String enter_a_valid_email_address() {

		try {

			WebElement crtemail = driver.findElement(By.xpath("//span[contains(text(),'Current Email')]"));

			String emailtext = crtemail.getText();

			String[] split = emailtext.split(":");

			if (split.length > 1) {

				String currentEmail = split[1].trim();

				String[] emailPart = currentEmail.split("@");

				String oldemailpart = emailPart[0];

				String domainYahoo = "yahoo.com";

				String domainGmail = "gmail.com";

				if (currentEmail.contains("@gmail.com")) {

					updatedEmail = oldemailpart + "@" + domainYahoo;

				} else {

					updatedEmail = oldemailpart + "@" + domainGmail;

				}

				pollingWait(pbp.getenterEmailField(), 25);

				assertTrue(pbp.getenterEmailField().isDisplayed());

				typeText(pbp.getenterEmailField(), updatedEmail);

				System.out.println("Email Updated successfully with new email : " + updatedEmail);

				pollingWait(pbp.getemailUpdateButton(), 25);

				assertTrue(pbp.getemailUpdateButton().isDisplayed());

				clickAction(pbp.getemailUpdateButton());

				pollingWait(pbp.getemailSuccessfulMessage(), 25);

				assertTrue(pbp.getemailSuccessfulMessage().isDisplayed());

				pollingWait(pbp.getcloseIcon(), 25);

				assertTrue(pbp.getcloseIcon().isDisplayed());

				clickAction(pbp.getcloseIcon());

			}

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on change email");
		}

		return updatedEmail;

	}

	@Then("Validate whether new email id was updated")
	public void validate_whether_new_email_id_was_updated() {

		try {

			pollingWait(pbp.getchangeEmailButton(), 25);

			assertTrue(pbp.getchangeEmailButton().isDisplayed());

			clickAction(pbp.getchangeEmailButton());

			WebElement crtemail = driver.findElement(By.xpath("//span[contains(text(),'Current Email')]"));

			String emailtext = crtemail.getText();

			String[] split = emailtext.split(":");

			String currentEmail = split[1].trim();

			if (currentEmail.equals(updatedEmail)) {

				System.out.println("Validation successful: Email was updated to " + currentEmail);
			} else {

				fail("Validation failed: Expected email " + updatedEmail + " but found " + currentEmail);
			}

		} catch (Exception e) {

			e.printStackTrace();
			fail("Problem while validating change email");
		}

	}

	@Then("Click on share pdf in Whatsapp button")
	public void click_on_share_pdf_in_whatsapp_button() {

		try {

			pollingWait(pbp.getsharePdfWhatsappButton(), 25);

			assertTrue(pbp.getsharePdfWhatsappButton().isDisplayed());

			clickAction(pbp.getsharePdfWhatsappButton());

			List<WebElement> alerts = driver.findElements(By.xpath("//button[@type='button' and @value]"));
			String alert = "//button[@type='button' and @value]";
			int size = alerts.size();
			System.out.println(size);

			for (int i = 1; i <= size; i++) {

				WebElement clickalert = driver.findElement(By.xpath("(" + alert + ")[" + i + "]"));
				System.out.println(alert);
				pollingWait(clickalert, 10);
				clickAction(clickalert);

			}

			pollingWait(pbp.getAcknowledgeButton(), 5);
			assertTrue(pbp.getAcknowledgeButton().isDisplayed());
			clickAction(pbp.getAcknowledgeButton());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on share pdf in whats app button");
		}

	}

	@Then("Validate whether user redirected to WA url")
	public void validate_whether_user_redirected_to_wa_url() {

		try {

			String currentUrl = getCurrentUrl();
			waitForUrl(currentUrl);
			validate_String_Contains(currentUrl, "whatsapp");

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while redirecting to whats app");
		}

	}

	@Then("Click on add hod button")
	public void click_on_add_hod_button() {

		try {

			pollingWait(pbp.getAddHodButton(), 5);
			assertTrue(pbp.getAddHodButton().isDisplayed());
			clickAction(pbp.getAddHodButton());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on add HOD button");
		}

	}

	@Then("Validate whether user an add comments in HOD")
	public Boolean validate_whether_user_an_add_comments_in_hod() {

		boolean retvalue = false;

		try {

			pollingWait(pbp.getccEmailField(), 10);
			assertTrue(pbp.getccEmailField().isDisplayed());
			typeText(pbp.getccEmailField(), "qa@pickyourtrail.com");

			pollingWait(pbp.getsubjectField(), 10);
			assertTrue(pbp.getsubjectField().isDisplayed());
			typeText(pbp.getsubjectField(), "HOD debrief sanity automation");

			pollingWait(pbp.getwelcomeTextFied(), 10);
			assertTrue(pbp.getwelcomeTextFied().isDisplayed());
			typeText(pbp.getwelcomeTextFied(), "HOD debrief sanity automation");

			boolean alertsbuttondisplayed = false;

			try {

				alertsbuttondisplayed = pbp.getalertsButtonHodDebrief().isDisplayed();

			} catch (NoSuchElementException e) {

				e.printStackTrace();
				fail("Problem while click on alerts");
			}

			pollingWait(pbp.getalertsButtonHodDebrief(), 10);
			assertTrue(pbp.getalertsButtonHodDebrief().isDisplayed());

			if (alertsbuttondisplayed) {

				try {

					pollingWait(pbp.getalertsButtonHodDebrief(), 10);
					scrolltoElement(pbp.getalertsButtonHodDebrief());
					clickAction(pbp.getalertsButtonHodDebrief());

					List<WebElement> internalCommentsField = driver
							.findElements(By.xpath("//textarea[@placeholder='Add internal comments']"));

					int Commentsize = internalCommentsField.size();

					System.out.println(Commentsize);

					for (int i = 0; i < Commentsize; i++) {

						WebElement internalcomment = internalCommentsField.get(i);

						typeText(internalcomment, "Test Comment");

					}

					List<WebElement> internalNotesField = driver
							.findElements(By.xpath("//textarea[@placeholder='Add Note']"));

					int Notesize = internalNotesField.size();

					System.out.println(Notesize);

					for (int i = 0; i < Notesize; i++) {

						WebElement internalnotes = internalNotesField.get(i);

						typeText(internalnotes, "Test Notes");

					}

					pollingWait(pbp.getAddBookingMessageButton(), 10);
					scrolltoElement(pbp.getAddBookingMessageButton());
					clickAction(pbp.getAddBookingMessageButton());

				} catch (NoSuchElementException e) {

					e.printStackTrace();
					fail("Problem while click on adding comments");
				}

			}

			retvalue = true;

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while adding HOD button");
		}

		return retvalue;
	}

	@Then("Validate whether the added comments where reflecting in itinerary page")
	public void validate_whether_the_added_comments_where_reflecting_in_itinerary_page() {

		
	}

	@Then("Click on Add booking message button")
	public void click_on_add_booking_message_button() {

		try {

			pollingWait(pbp.getAddBookingMessageButton(), 5);
			assertTrue(pbp.getAddBookingMessageButton().isDisplayed());
			clickAction(pbp.getAddBookingMessageButton());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem while click on add booking message button");
		}

	}

	@Then("Validate whether user can able to Add booking message")
	public void validate_whether_user_can_able_to_add_booking_message() {

		try {

			pollingWait(pbp.getdepartureCityDropDown(), 25);
			assertTrue(pbp.getdepartureCityDropDown().isDisplayed()); //
			clickAction(pbp.getdepartureCityDropDown());
			typeText(pbp.getdepartureCityDropDown(), "Chennai");
			pressEnter(pbp.getdepartureCityDropDown());

			pollingWait(pbp.getamountPaidByCustomerField(), 25);
			assertTrue(pbp.getamountPaidByCustomerField().isDisplayed());
			typeText(pbp.getamountPaidByCustomerField(), "10"); //
			pressEnter(pbp.getamountPaidByCustomerField());

			pollingWait(pbp.getflightBookedDropDown(), 25);
			assertTrue(pbp.getflightBookedDropDown().isDisplayed());
			typeText(pbp.getflightBookedDropDown(), "No"); //
			pressEnter(pbp.getflightBookedDropDown());

			pollingWait(pbp.getwhatsNeedsToBeDoneDropwDown(), 25);
			assertTrue(pbp.getwhatsNeedsToBeDoneDropwDown().isDisplayed()); //
			clickAction(pbp.getwhatsNeedsToBeDoneDropwDown());
			typeText(pbp.getwhatsNeedsToBeDoneDropwDown(), "No need");
			pressEnter(pbp.getwhatsNeedsToBeDoneDropwDown());

			pollingWait(pbp.getasendDebriefAndCompleteBookingButton(), 25);
			assertTrue(pbp.getasendDebriefAndCompleteBookingButton().isDisplayed());
			clickAction(pbp.getasendDebriefAndCompleteBookingButton());

			Thread.sleep(2000);
			pollingWait(pbp.getbookingMessageSavedSuccessfullyText(), 25);
			assertTrue(pbp.getbookingMessageSavedSuccessfullyText().isDisplayed());

			pollingWait(pbp.getcompleteBookingButton(), 5);
			assertTrue(pbp.getcompleteBookingButton().isDisplayed());
			clickAction(pbp.getcompleteBookingButton());

		} catch (Exception e) {

			e.printStackTrace();
			fail("Problem while click on adding booking message");
		}

	}

	@Then("Click on Enable Bank tranfer button")
	public void click_on_enable_bank_tranfer_button() {

		try {

			pollingWait(pbp.getenableBankTransferButton(), 20);
			assertTrue(pbp.getenableBankTransferButton().isDisplayed());
			clickAction(pbp.getenableBankTransferButton());

		} catch (Exception e) {

			e.printStackTrace();
			fail("Problem while click on bank transfer button");
		}

	}

	@Then("Validate whether Bank transfer option enabled")
	public void validate_whether_bank_transfer_option_enabled() {

		try {

			pollingWait(pbp.getenableBankTransferText(), 20);
			assertTrue(pbp.getenableBankTransferButton().isDisplayed());
			WebElement getenableBankTransferText = pbp.getenableBankTransferText();
			String text = getenableBankTransferText.getText();
			System.out.println(text);
			text.contains("make-payment");

			pollingWait(pbp.getcloseIcon(), 20);
			assertTrue(pbp.getcloseIcon().isDisplayed());
			clickAction(pbp.getcloseIcon());

		} catch (Exception e) {

			e.printStackTrace();
			fail("Problem while click on enable bank transfer button");
		}

	}

	@Then("Click on Disable Bank tranfer button")
	public void click_on_disable_bank_tranfer_button() {

		try {

			pollingWait(pbp.getdisableBankTransferButton(), 20);
			assertTrue(pbp.getdisableBankTransferButton().isDisplayed());
			clickAction(pbp.getdisableBankTransferButton());

			pollingWait(pbp.getdisableBankTransferText(), 20);
			assertTrue(pbp.getdisableBankTransferText().isDisplayed());
			WebElement getdisableBankTransferText = pbp.getdisableBankTransferText();
			String text = getdisableBankTransferText.getText();
			text.contains("Disable");

			pollingWait(pbp.getdisableAccessButton(), 20);
			assertTrue(pbp.getdisableAccessButton().isDisplayed());
			clickAction(pbp.getdisableAccessButton());

		} catch (Exception e) {

			e.printStackTrace();
			fail("Problem while click on bank transfer button");
		}

	}

	@Then("Validate whether Bank transfer option disabled")
	public void validate_whether_bank_transfer_option_disabled() {

		try {

			pollingWait(pbp.getenableBankTransferButton(), 20);
			assertTrue(pbp.getenableBankTransferButton().isDisplayed());

		} catch (Exception e) {

			e.printStackTrace();
			fail("Problem while click on bank transfer button");
		}

	}

}
