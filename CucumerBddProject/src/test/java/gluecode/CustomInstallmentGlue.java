package gluecode;

import static org.junit.Assume.assumeTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import utils.Kernel;

public class CustomInstallmentGlue extends Kernel {
	HotelsGlue hg = new HotelsGlue();
	UserFloGlue ug = new UserFloGlue();

	int defaultFirstCustomInstalment = 10000;
	int secondCustomInstalmentCalc;
	int totaldealcost;

	int firstInstalmentOnModalPrice;
	int secondInstalmentOnModalPrice;
	
	@Then("^Verify custom Installment option are showing$")
	public void verify_custom_Installment_option_are_showing() throws Throwable {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			WebElement chatdismiss = (WebElement) jse.executeScript(
					"return document.querySelector(\"df-messenger\").shadowRoot.querySelector(\"df-messenger-chat\").shadowRoot.querySelector(\"df-message-list\").shadowRoot.querySelector(\"#dismissIcon\")");
			System.out.println(chatdismiss.getSize());
			Thread.sleep(3000);
			jse.executeScript("arguments[0].click()", chatdismiss);
			Thread.sleep(3000);
			System.out.println("chat clicked");
		} catch (Exception e) {
			System.out.println("chat not avaialable");
			e.printStackTrace();
		}

		validateAssertion(elementDisplayed(custom.getCreateCustom()));

	}

	@Then("^Calculate the first and second Instalment amount from total cost$")
	public void calculate_the_first_and_second_Instalment_amount_from_total_cost() throws Throwable {

		try {
			String totalDealPrice = adminPrice.getTotalItineraryCost().getText().replaceAll("[^0-9]", "")
					.replace(",", "").trim();
			System.out.println("totalDealPrice--" + totalDealPrice);

			totaldealcost = Integer.parseInt(totalDealPrice);
			System.out.println("totaldealcost--" + totaldealcost);

			System.out.println("totaldealcost--" + totaldealcost);
			if (totaldealcost == 0) {
				clickAction(hotelPage.gethotel_ChangeHotelButton(), "User changes the hotel");
				try {
				waitForMe(hotelPage.gethotel_replaceHotelCardAlternate());
				System.out.println(hotelPage.gethotel_replaceHotelCardAlternate().isDisplayed());
				clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
				clickAction(hotelPage.gethotel_detailsPageAddToItinneraryButton(), "Adding the hotel in Details page ");
				}catch(Exception e) {
					System.out.println("No hotel option available! ");
					assumeTrue(false);
				}	
			}
			secondCustomInstalmentCalc = totaldealcost - defaultFirstCustomInstalment;
			System.out.println("secondCustomInstalmentCalc--" + secondCustomInstalmentCalc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Validate the first and second instalement on custom Instalment modal$")
	public void validate_the_first_and_second_instalement_on_custom_Instalment_modal() throws Throwable {

		try {
			String firstInstalmentOnModal = custom.getFirstInstalmentAmount().getAttribute("placeholder");
			System.out.println("firstInstalmentOnModal--" + firstInstalmentOnModal);
			firstInstalmentOnModalPrice = Integer.parseInt(firstInstalmentOnModal);
			System.out.println("firstInstalmentOnModalPrice--" + firstInstalmentOnModalPrice);

			String secondInstalmentOnModal = custom.getSecondInstalmentAmount().getAttribute("placeholder")
					.replaceAll("[^0-9]", "").replace(",", "").trim();
			secondInstalmentOnModalPrice = Integer.parseInt(secondInstalmentOnModal);
			System.out.println("secondInstalmentOnModalPrice--" + secondInstalmentOnModalPrice);

			validateAssertion(firstInstalmentOnModalPrice == defaultFirstCustomInstalment);

			if (secondInstalmentOnModalPrice == secondCustomInstalmentCalc
					|| secondInstalmentOnModalPrice == (secondCustomInstalmentCalc - 1)) {
				validateAssertion(true);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Add the reason for instalment and create instalment$")
	public void add_the_reason_for_instalment_and_create_instalment() throws Throwable {
   try {
	    waitForMe(custom.getReasonCustomInstalment());
		typeText(custom.getReasonCustomInstalment(), "test custom instalment");
		clickAction(custom.getCreateInstalmentCT());
		validateAssertion(elementDisplayed(custom.getInstalmentAdded()));
    }
   catch (Exception e) {
	e.printStackTrace();
    }

	}

	@Then("^click on the create custom instalment link$")
	public void click_on_the_create_custom_instalment_link() throws Throwable {
		try {
		Thread.sleep(2000);
		clickAction(custom.getCreateCustom());
		Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^Validate the first default amount is showing for user on above book now header$")
	public void validate_the_first_default_amount_is_showing_for_user_on_above_book_now_header() throws Throwable {

		try {
		String customTag = custom.getUserFirstInstalmentAmt().getText().replaceAll("[^0-9]", "").replace(",", "")
				.trim();

		System.out.println("customTag---" + customTag);

		int customTagint = Integer.parseInt(customTag);
		System.out.println("customTagint--" + customTagint);
		System.out.println("defaultFirstCustomInstalment--" + defaultFirstCustomInstalment);

		validateAssertion(customTagint == defaultFirstCustomInstalment);

	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Then("^Validate the first and second instalement amount on payment screen$")
	public void validate_the_first_and_second_instalement_amount_on_payment_screen() throws Throwable {
		clickAction(sbCost.getBookNow());
		clickAction(pdgflowp.getcontinue_to_book_button(), "User clicks continue to book");
		validatePassengerDetails();
		ug.user_initializes_Payment();
		
		
		String paymentscreenFirstInstalment = custom.getPaymentScreenFirstInstalment().getText().replaceAll("[^0-9]", "").replace(",", "").trim();
		
		int firstInstalmentOnPaymentScreen = Integer.parseInt(paymentscreenFirstInstalment);
		
		String paymentscreenSecondInstalment = custom.getPaymentScreenSecondInstalment().getText().replaceAll("[^0-9]", "").replace(",", "").trim();
		
		int secondInstalmentOnPaymentScreen = Integer.parseInt(paymentscreenSecondInstalment);
		
		
		validateAssertion(firstInstalmentOnModalPrice == firstInstalmentOnPaymentScreen);
		
		validateAssertion(secondInstalmentOnModalPrice == secondInstalmentOnPaymentScreen);
		
		}
	

}
