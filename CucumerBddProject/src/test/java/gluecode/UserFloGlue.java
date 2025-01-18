package gluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class UserFloGlue extends Kernel {

	@And("^user costs the itinerary by clicking Get Trip Cost$")
	public void user_costs_the_itinerary_by_clicking_Get_Trip_Cost() throws Throwable {
		clickAction(intpag.getLatestCostBeforeScroll());
		validateCostPassengerDetails();
	}

	@And("^user fills the GCM form$")
	public void user_fills_gcm_flow() throws Throwable {
//		try {
//			pollingWait(intpag.getChatBotClose(),30);
//			Thread.sleep(2000);
//			clickAction(intpag.getChatBotClose());
//		} catch (Exception e) {
//			System.out.println("Chat Bot not available");
//		}
		navigateGcmFlow();
	}

	@And("^user checks all the alerts and clicks continue to book$")
	public void user_clicks_continue_to_book() throws Throwable {
		pollingWait(pdgtreco.waitForCosting(), 60);
		clickAction(pdgtreco.waitForCosting());
        scrollUp();
		clickAction(pdgflowp.getcontinue_to_book_button(), "User clicks continue to book");
	}

	@And("^user fills in the passenger details$")
	public void user_fills_passenger_details() throws Throwable {
		validatePassengerDetails();
	}

	@And("^user reviews the cost and clicks make payment$")
	public void user_initializes_Payment() throws Throwable {
		waitUntil(booingReview.getmakePaymentButton(), 45);
		clickAction(booingReview.getmakePaymentButton(),
				"User initializes the payment by clicking next make payment button ");
	}

	@And("^user makes the full payment$")
	public void user_makes_the_full_payment() throws Throwable {
		clickAction(razorpaypage.gettermsConditionsCheckBox(),
				"User clicks the terms and conditions checks and accepts the  terms declared");
		clickAction(paymentPage.getPayHundredPercentButton(), "User makes the 100% payment");
		Thread.sleep(1000);
		clickAction(paymentPage.getPayHundredPercentButton(), "User makes the 100% payment");
		Thread.sleep(5000);

	}

	@And("^user fills the card details and make payment$")
	public void user_fills_the_card_details() throws Throwable {
          
		waitForMe(payUPage.getPayNowButton());
		String paymentPageUrl = getCurrentUrl();
        try {
		if (paymentPageUrl.contains("payu") && paymentPageUrl.contains("test")) {
			System.out.println("Payment page"+getCurrentUrl());
			Thread.sleep(2000);
			typeText(payUPage.getCardNumberField(), "5123456789012346");
//			Thread.sleep(1000);
			typeText(payUPage.getExpiryMonthDropDown(), "0522");
			typeText(payUPage.getCcvvNumber(), "123");
			typeText(payUPage.getCardNameField(), "QA");

			clickAction(payUPage.getPayNowButton(), "User clicks the Pay now button");
			try {
				waitForMe(payUPage.getAxisSimulator());
				if (payUPage.getAxisSimulator().isDisplayed()) {
					clickAction(payUPage.getPaymentOTPTxtBox());
					typeText(payUPage.getPaymentOTPTxtBox(), "123456");
					clickAction(payUPage.getPaymentSubmit());
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println("Axis Simulator not displaying");
			}
			
		}
        }
        catch (Exception e) {
			e.printStackTrace();
		}

//		} else {
//			submitcardDetails();
//			clickAction(razorpaypage.getPaymentSuccessButton(), "user trigers a succesful Payment");
//			clickAction(razorpaypage.getcancelTransactionButton(), "user cancels the transaction  Payment");
//		}

	}

	@And("^user cancels the transaction$")
	public void user_cancels_Payment() throws Throwable {

		waitForMe(payUPage.getPayNowButton());
		String paymentPageUrl = getCurrentUrl();
		// ReporteraddStepLog(getCurrentUrl());

		if (paymentPageUrl.contains("payu") && paymentPageUrl.contains("test")
				&& elementDisplayed(payUPage.getNonProdConfirmation())) {
			clickAction(payUPage.getCancelPaymentLink());
		} else {
			clickAction(razorpaypage.getcancelTransactionButton(), "user cancels the transaction  Payment");
		}
	}

	@Then("^validate that the payment is success$")
	public void validate_that_the_payment_is_success() throws Throwable {
//		clickAction(razorpaypage.getPaymentSuccessButton(), "user trigers a succesful Payment");
		pollingWait(paymentPage.getPaymentSuccessYourVacation(), 300);
		validate_String_Contains(getCurrentUrl(), "success");

	}

	@Then("^validate that the user is navigated back to the inclusion screen after cancelation$")
	public void validate_user_navigates_inclusion_after_cancelation() throws Throwable {
//		clickAction(razorpaypage.getPaymentSuccessButton(), "user trigers a succesful Payment");
//		waitUntil(inclusion.getLogout(), 25);
//		validate_String_Contains(getCurrentUrl(), "wronginclusion");
		pollingWait(payUPage.getPaymentFailurePageImg(), 60);
		String failurePaymentPage = getCurrentUrl();
		if (elementDisplayed(payUPage.getPaymentFailurePageImg()) && failurePaymentPage.contains("failure")) {
			clickAction(payUPage.getLinkToBackItineraryPage());
			elementDisplayed(intpag.getItineraryH1Element());
			validate_String_Contains(getCurrentUrl(), "view");

		}
	}

	/*
	 * Added the assertion to check if we landed on itinerary page for multi city
	 * destination and new GCM page for single city destination page
	 */

	@Then("^validate that the itinerary is created succesfully$")
	public void validate_that_the_itinerary_Creation_Successfull_is_success() throws Throwable {
		System.out.println("URL :" + getCurrentUrl());

//		try {
//			pollingWait(intpag.getChatBotClose(),30);
//			Thread.sleep(2000);
//			clickAction(intpag.getChatBotClose());
//			} catch (Exception e) {
//			System.out.println("Chat Bot not available");
//		}
//		if(elementDisplayed(intpag.getGcmSignupButton())) {
//			scrolltoElement(intpag.getGcmSignupButton());
//			validateAssertion(elementDisplayed(intpag.getGcmSignupButton()));
//		}
//		else {
//			clickAction(intpag.getMorePill());
//			validateAssertion(elementDisplayed(sbaliLanding.getDeparingFrom()));
//            clickAction(gcm.closeGcmModal());
//		}
//		driver.navigate().refresh();
//elementDisplayed(intpag.getItineraryH1Element());
//		validate_String_Contains(getCurrentUrl(), "view");
		// ReporteraddStepLog("Itinerary got created succesfully");
		// ReporteraddStepLog(getCurrentUrl());

		Thread.sleep(15000);
		//pageRefresh();
		pollingWaitForCostingFlow("view", 150);
		validate_String_Contains(getCurrentUrl(), "view");
		System.out.println("Itinerary got successfully created");
		Thread.sleep(2000);
	}

	@Then("^validate that the itinerary is created succesfully for single destination$")
	public void validate_that_the_itinerary_is_created_succesfully_for_single_destination() throws Throwable {
		System.out.println("URL :" + getCurrentUrl());
		if (elementDisplayed(intpag.getGcmSignupButton())) {
			scrolltoElement(intpag.getGcmSignupButton());
			validateAssertion(elementDisplayed(intpag.getGcmSignupButton()));

		}

	}

	@And("^user fills the GCM form for \"([^\"]*)\"$")
	public void user_fills_gcm_flow_with_deaprtFrom(String departFrom) throws Throwable {
		navigateGcmFlowWithDepartFrom(departFrom);
	}

	@And("^user fills the card details and cancel payment in payU$")
	public void user_fills_the_card_details_and_cancel_payment() throws Throwable {

		waitForMe(payUPage.getPayNowButton());
		String paymentPageUrl = getCurrentUrl();
		// ReporteraddStepLog(getCurrentUrl());
        try {
		if (paymentPageUrl.contains("payu") && paymentPageUrl.contains("test")
				&& elementDisplayed(payUPage.getNonProdConfirmation())) {
			System.out.println(getCurrentUrl());
			typeText(payUPage.getCardNumberField(), "5123456789012346");
			typeText(payUPage.getCardNameField(), "QA");
			typeText(payUPage.getCcvvNumber(), "123");
			pollingWait(payUPage.getExpiryMonthDropDown(), 20);
			selectDropDownUsingVisibleText(payUPage.getExpiryMonthDropDown(), "May (5)");
			selectDropDownUsingVisibleText(payUPage.getExpiryYearhDropDown(), "2020");
			clickAction(payUPage.getPayNowButton(), "User clicks the Pay now button");
			try {
				waitForMe(payUPage.getAxisSimulator());
				if (payUPage.getAxisSimulator().isDisplayed()) {
					clickAction(payUPage.getPaymentOTPTxtBox());
					typeText(payUPage.getPaymentOTPTxtBox(), "123456");
					clickAction(payUPage.getPaymentCancel());
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
					Thread.sleep(5000);

				}
			} catch (Exception e) {
				System.out.println("Axis Simulator not displaying");
			}
		}
        }

		catch (Exception e) {
			e.printStackTrace();
		}
	
        }

	@Then("^validate that the payment is cancelled$")
	public void validate_that_the_payment_is_cancel() throws Throwable {
		Thread.sleep(3000);
		validate_String_Contains(getCurrentUrl(), "retry");

	}

}