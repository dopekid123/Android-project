package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class GlobalSignupAndLoginGlue extends Kernel {

	public void globalSignupAndLogin(String fields) {
		try {
			clickAction(gcm.getLeadPassengerNameGlobal());
			Thread.sleep(500);
			typeText(gcm.getLeadPassengerNameGlobal(), regname);
			Thread.sleep(500);

			clickAction(icm.getArrivalOn());
			Thread.sleep(1000);
			clickAction(driver.findElement(By.xpath("//*[contains(@class,'navigation--next')]")));
			Thread.sleep(500);
			// clickAction(driver.findElement(By.xpath("//div[@aria-label='day-14']")));
			clickAction(sbLand.sbChooseTravelDate());

			switch (fields) {
			case "NewEmail":
				clickAction(gcm.getEmailIdGlobal());
				Thread.sleep(500);
				typeText(gcm.getEmailIdGlobal(), newemail);
				clickAction(icm.getGetCostContinue());
				break;

			case "NewMailandMobile":
				clickAction(gcm.getEmailIdGlobal());
				Thread.sleep(500);
				typeText(gcm.getEmailIdGlobal(),newemailaddress);
				Thread.sleep(500);
				clickAction(gcm.getMobileNumberGlobal());
				Thread.sleep(500);
				typeText(gcm.getMobileNumberGlobal(), newmobile);
				clickAction(icm.getGetCostContinue());
				break;
			case "ExistingMail":
				clickAction(gcm.getEmailIdGlobal());
				Thread.sleep(500);
				typeText(gcm.getEmailIdGlobal(), regemail);
				Thread.sleep(500);
				clickAction(icm.getGetCostContinue());
				Thread.sleep(500);
				clickAction(lp.getPassword());
				Thread.sleep(500);
				typeText(lp.getPassword(), pass);
				Thread.sleep(500);
				clickAction(lp.getpackCtaLogin());
				break;
				
			case "ExistingMailandMobile":
				clickAction(gcm.getEmailIdGlobal());
				Thread.sleep(500);
				typeText(gcm.getEmailIdGlobal(), regemail);
				Thread.sleep(500);
				clickAction(gcm.getMobileNumberGlobal());
				Thread.sleep(500);
				typeText(gcm.getMobileNumberGlobal(), username);
				Thread.sleep(500);
				clickAction(icm.getGetCostContinue());
				Thread.sleep(500);
				clickAction(lp.getPassword());
				Thread.sleep(500);
				typeText(lp.getPassword(), pass);
				Thread.sleep(5000);
				clickAction(lp.getpackCtaLogin());
				break;
				
			case "ExistingMailAE":
				clickAction(gcm.getEmailIdGlobal());
				Thread.sleep(500);
				typeText(gcm.getEmailIdGlobal(), regemail);
				Thread.sleep(500);
				validateAssertion(verifyIsDisabled(icm.getGetCostContinue()));
				break;

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^Global user signup and login flow for \"([^\"]*)\"$")
	public void global_user_signup_and_login_flow_for(String fields) throws Throwable {
		Thread.sleep(500);
		clickAction(icm.getcalculateTripCostButton());
		Thread.sleep(500);
		globalSignupAndLogin(fields);

	}

	@Then("^Global user fills the gcm form \"([^\"]*)\"$")
	public void global_user_fills_the_gcm_form(String nationality) throws Throwable {
		Thread.sleep(500);
		clickAction(icm.getcalculateTripCostButton());
		Thread.sleep(500);
		fillMandatoryInfoGlobal(nationality);

	}

	@Then("^User navigate to packages page \"([^\"]*)\"$")
	public void user_navigate_to_packages_page(String region) throws Throwable {
		chooseAnyPackage(region);
	}

	@Then("^Global user fills the gcm form for packages page \"([^\"]*)\"$")
	public void global_user_fills_the_gcm_form_for_packages_page(String fields) throws Throwable {
		Thread.sleep(500);
		clickAction(packagesPage.getfirstPackageCustomize());
		Thread.sleep(500);
		clickAction(icm.getcalculateTripCostButton());

		try {

			pollingWait(ip.getgotItPopup(), 30);
			Thread.sleep(2000);
			if (elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
}
		} catch (Exception e) {
			System.out.println("No Got it popup");

		}
		Thread.sleep(1000);
		if (elementDisplayed(pdgflowp.getCookiesOkGlobal())) {
			try {
				clickAction(pdgflowp.getCookiesOkGlobal());
			} catch (NoSuchElementException e) {
				System.out.println("Accept cookies button is not available");
			}
		}

		globalSignupAndLogin(fields);

	}

}
