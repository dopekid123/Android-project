package gluecode;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class PostCardGlue extends Kernel {
	@When("^user typing unsupported destination$")
	public void user_typing_unsupported_destination() throws Throwable {
//		clickAction(hp.getstartPlanningNowButton());
		driver.get(localEnvUrl + "/customize");
		Thread.sleep(2000);
		clickAction(ip.getCity());
		typeText(ip.getCity(), "unsupportedDest");
		clickAction(postCard.getUnwrappedDest());

	}

	@And("^user selecting vacation details in the postcard page$")
	public void user_selecting_vacation_p_details_in_the_postcard_page() throws Throwable {
		selectDropDownUsingVisibleText(postCard.getAdults(), "4 adults");
		selectDropDownUsingValue(postCard.getDepartureCity(), "Mumbai");
		selectDropDownUsingValue(postCard.getDestinationDropdown(), "Others");
		selectDropDownUsingValue(postCard.getDate(), "May");
		selectDropDownUsingVisibleText(postCard.getBudget(), "₹60000 - 75000");

	}

	@And("^check the name and email and phone number field is disabled$")
	public void check_the_name_and_email_and_phone_number_field_is_disabled() throws Throwable {
		boolean name = verifyEnabled(postCard.getName());
		boolean email = verifyEnabled(postCard.getEmail());
		boolean num = verifyEnabled(postCard.getMobile());
		if (name == false && email == false && num == false) {
			System.out.println("The name number and email field successfully disabled for existing user");
		}
		clickAction(postCard.getPlanThisTripButton());
	}

	@Then("^validate the postcard submitted successfully$")
	public void validate_the_postcard_submitted_successfully() throws Throwable {

		elementExist(postCard.getCheers());
	}

	@When("^user typing city inside city$")
	public void user_typing_city_inside_city() throws Throwable {
//	  clickAction(hp.getstartPlanningNowButton());
		driver.get(localEnvUrl + "/customize");
		Thread.sleep(2000);
		clickAction(ip.getCity());
		typeText(ip.getCity(), "Mumbai");
	}

	@And("^submit user name and email id details$")
	public void submit_user_name_and_email_id_details() throws Throwable {
		typeText(postCard.getName(), cbrName);
		typeText(postCard.getEmail(), cbrMail);

		clickAction(postCard.getNotified());
	}

	@Then("^validate the success response$")
	public void validate_the_success_response() throws Throwable {
		verifyPartialText(postCard.getThankYou(), "Thank you");
	}

	@When("^user type the new name number and email \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_type_the_new_name_number_and_email(String name, String num, String email) throws Throwable {
		try {
			typeText(postCard.getName(), name);
			typeText(postCard.getEmail(), email);
			typeText(postCard.getMobile(), num);
			clickJavaScriptElement(postCard.getPlanThisTripButton());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
