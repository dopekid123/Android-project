package gluecode;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import utils.Kernel;

public class WhatsappCheckBoxGlue extends Kernel {

	/*
	 * Scenario for dubai flow - GCM whatsapp checkbox 
	 * By default whatsapp checkbox is enabled 
	 * The value is true if the checkbox is enabled validate if the value is true for enabled checkbox
	 */

	@Given("^User verifies if the checkbox is enabled by default$")
	public void validateCheckboxCheckedDefault() throws Throwable {
		validateAssertion(getCurrentUrl().contains("signup"));
		Thread.sleep(1000);
		String checkboxBeforeClick = driver.findElement(By.xpath("//input[@name='canSendWhatsAppMessages']"))
				.getAttribute("checked");
		System.out.println("checkboxBeforeClick----" + checkboxBeforeClick);
		validateAssertion(checkboxBeforeClick.contains("true"));

	}

	/*
	 * Scenario for dubai flow - GCM whatsapp checkbox 
	 * By default whatsapp checkbox is enabled 
	 * If user unchecked the checkbox it got disabled The value is null
	 * if the checkbox is disabled validate if the value is null for disabled
	 * checkbox
	 * 
	 */

	@Given("^User validates that checkbox got unchecked after clicking on checkbox$")
	public void validateCheckboxUnchecked() throws Throwable {
		driver.findElement(By.xpath("//div[@class='clearfix']//i")).click();
		Thread.sleep(1000);
		String checkboxAfterClick = driver.findElement(By.xpath("//input[@name='canSendWhatsAppMessages']"))
				.getAttribute("checked");
		System.out.println("checkboxAfterClick----" + checkboxAfterClick);
		Thread.sleep(2000);
		validateAssertion(checkboxAfterClick == null);

	}

	// Scenario for landing page login flow - whatsapp checkbox for default case

	@Given("^User validates by default that the checkbox got enabled for landing page GCM$")
	public void user_validates_by_default_that_the_checkbox_got_enabled_for_landing_page_GCM() throws Throwable {
		if (elementDisplayed(lp.getLogin())) {
			clickAction(lp.getLogin());
			clickAction(sp.getInitSignup());
			validateCheckboxCheckedDefault();
		}
	}

	// Scenario for landing page login flow - whatsapp checkbox

	@Given("^User validates that checkbox got unchecked after clicking on checkbox for landing page GCM$")
	public void user_validates_that_checkbox_got_unchecked_after_clicking_on_checkbox_for_landing_page_GCM()
			throws Throwable {
		if (elementDisplayed(lp.getLogin())) {
			clickAction(lp.getLogin());
			clickAction(sp.getInitSignup());
			validateCheckboxUnchecked();
		}
	}

	// Scenario for itinerary page flow - GCM whatsapp checkbox default flow

	@Given("^User validates by default that the checkbox got enabled for itinerary page GCM \"([^\"]*)\"$")
	public void user_validates_by_default_that_the_checkbox_got_enabled_for_itinerary_page_GCM(String region)
			throws Throwable {

		if (elementDisplayed(hp.getstartPlanningNowButton()))
			iternaryFlow(region);
		if (elementDisplayed(icm.getcalculateTripCostButton())) {
			clickAction(icm.getcalculateTripCostButton());
		}
		fillMandatoryInfoInGCM();
		validateCheckboxCheckedDefault();

	}

	// Scenario for itinerary page flow - GCM whatsapp checkbox

	@Given("^User validates that checkbox got unchecked after clicking on checkbox for itinerary page GCM \"([^\"]*)\"$")
	public void user_validates_that_checkbox_got_unchecked_after_clicking_on_checkbox_for_itinerary_page_GCM(
			String region) throws Throwable {
		if (elementDisplayed(hp.getstartPlanningNowButton())) {
			iternaryFlow(region);
		}
		if (elementDisplayed(icm.getcalculateTripCostButton())) {
			clickAction(icm.getcalculateTripCostButton());
		}
		fillMandatoryInfoInGCM();
		validateCheckboxUnchecked();
	}

}
