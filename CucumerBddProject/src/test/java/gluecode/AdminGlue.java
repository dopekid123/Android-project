package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class AdminGlue extends Kernel {
	
	 String region;
	 String adminSharedItinerary;
	
	@Then("^Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin$")
	public void user_clicks_continue_to_book() throws Throwable {
		scrollUp();
		clickAction(adminPage.getadminOptionsDropdown(), "Clicking Admin Dropdown Admin features");
		elementExist(adminPage.getAdminSendToPlatoOption());
		elementExist(adminPage.getAdminShareItinerary());
		elementExist(adminPage.getAdminGetBetterCost());
		elementExist(adminPage.getUpdateLocaleOption());
		elementExist(adminPage.getAdminSharePDF());
		scrolltoElement(adminPage.getAdminSplitPricingForCustomers());
		elementExist(adminPage.getAdminSplitPricingForCustomers());
	}

	@Then("^Validate the share itinerary workflow$")
	public void validate_the_share_itinerary_workflow() throws Throwable {
		clickAction(adminPage.getAdminShareItinerary(), "User clicks the admin share itinerary");
		typeText(adminPage.getShareMobNo(), "+919344700243");
		clickAction(adminPage.getSharefetchAcc(), "User clicks the fetch acc no");
		region = "India";
		selectOptionsOnShareItineraryModal(region);

	}
	
	@And("^Navigate to the admin shared itinerary as an user$")
	public void navigate_to_the_admin_shared_itinerary_as_an_user() throws Throwable {
	  
		navigateToUrl(adminSharedItinerary);
		validateAssertion(elementExist(adminPage.getHotelSplitPrice()));
		//Commenting this out - Maldives destination don't have transfer so we can't able to ckeck transfer split price.
		
		//validateAssertion(elementExist(adminPage.getTransferSplitPrice()));

	}



	@Then("^Validate the split pricing workflow$")
	public void validate_the_share_pricing_workflow() throws Throwable {
		// clickAction(adminPage.getAdminShareItinerary(), "User clicks the admin share
		// itinerary");
		clickAction(adminPage.getadminOptionsDropdown(), "Clicking Admin Dropdown Admin features");
		elementExist(adminPage.getAdminSplitPricingForCustomers());
		clickAction(adminPage.getAdminSplitPricingForCustomers());
		adminSharedItinerary = getCurrentUrl();
		scrollUp();
		
	}

	@Then("^Validate the update locale feature$")
	public void validate_the_update_locale_feature() throws Throwable {
		scrolltoElement(adminPage.getadminOptionsDropdown());
		clickAction(adminPage.getadminOptionsDropdown(), "Clicking Admin Dropdown Admin features");
		clickAction(adminPage.getUpdateLocaleOption());
		validateAssertion(elementDisplayed(adminPage.getUpdateLocaleModel()));
		List<WebElement> localecode = driver
				.findElements(By.xpath("//table[contains(@class,'ChangeLocaleModal')]//tr//td[2]"));
		System.out.println(localecode.size());

		for (int i = 2; i <= localecode.size(); i++) {

			WebElement updatelocale = driver
					.findElement(By.xpath("(//table[contains(@class,'ChangeLocaleModal')]//tr//td[2])[" + i + "]"));
//		System.out.println(localecode.get(i));
			String localecodetext = updatelocale.getText();

			System.out.println("localecodetext--" + localecodetext);
			String currency = currencymapusingcode.get(localecodetext).trim();
			clickAction(updatelocale);
			clickAction(adminPage.getChangeOptionOnUpdateLocale());
			Thread.sleep(2000);
			String currencycodeintotalprice = adminPrice.getTotalItineraryCost().getText().replaceAll("[0-9]", "")
					.replace(",", "").trim();
			validateAssertion(currency.equals(currencycodeintotalprice));
			clickAction(adminPage.getadminOptionsDropdown(), "Clicking Admin Dropdown Admin features");
			pollingWait(adminPage.getUpdateLocaleOption(), 25);
			clickAction(adminPage.getUpdateLocaleOption());
			Thread.sleep(2000);

		}

	}
	
	@Then("^Validate the global share itinerary workflow$")
	public void validate_the_global_share_itinerary_workflow() throws Throwable {
		Thread.sleep(2000);
		clickAction(adminPage.getAdminShareItinerary(), "User clicks the admin share itinerary");
		typeText(adminPage.getShareMobNo(), globalUserUS);
		clickAction(adminPage.getSharefetchAcc(), "User clicks the fetch acc no");
		region = "global";
		selectOptionsOnShareItineraryModal(region);
	
	}
	
	//The commented line is deprecated
	public void selectOptionsOnShareItineraryModal(String region) {
		
		try {
        validateAssertion(elementDisplayed(adminPage.getShareItineraryModal()));
		String fetchuser = adminPage.getFetchAccountDetails().getText();
		System.out.println("fetchuser--"+fetchuser);
		if(region.equals("global")) {
		validate_String_Contains(fetchuser, globalUserName);
		}
		else {
			validate_String_Contains(fetchuser,regname);
		}
		//		clickAction(adminPage.getShareExistemailId(), "click existing email acc");
		clickAction(adminPage.getShareleadStatusDropDown(), "selcts the drop down to select for lead status");
		clickAction(adminPage.getShareleadStatusinTalks(), "Click inTalks ID");
		typeText(adminPage.getshareItineraryCallNotes(), "test");
		clickAction(adminPage.getShareContinueButton(), "User Clicks continue button after sharing the itinerary");
		validateAssertion(elementDisplayed(adminPage.getShareAlertMessage()));
		clickAction(adminPage.getShareItineraryAckMsgModalClose());
		
		

	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}