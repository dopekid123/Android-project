package gluecode;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class YourVacationsGlue extends Kernel {
	
	public static String beforeRename;
	public static String afterRename;
	public static String totalCostOfBookedIti;
	public static String itiPageTotalCost;
	List<WebElement> totalCountSavedIti;
	
	public static String url;

	public static String itineraryID="";

	
	
	@When("^validate the user land on your vacations page$")
	public void validate_the_user_land_on_your_vacations_page() {
		validate_String_Contains(getCurrentUrl(),"your-vacations");
	}

	@And("^user opens saved itinerary$")
	public void user_opens_saved_itinerary() throws Throwable {
		try {
	     //assertTrue(yourVacation.getSavedItinerary().isDisplayed());
		scrolltoElement(yourVacation.getSavedItinerary());
		clickAction(yourVacation.getSavedItinerary());
		validate_String_Contains(getCurrentUrl(),"saved-itineraries");
		}catch(NoSuchElementException e) {
			//ReporteraddStepLog("Saved Itineraries not found");
		}
	}
	@And("^user rename the itinerary$")
	public void  user_rename_the_itinerary() throws Throwable {
		pollingWait(yourVacation.getSavedItineraryCard(), 180);
		if(elementExist(yourVacation.getSavedItineraryCard())) {
		beforeRename = getText(yourVacation.getBeforeRename());
		clickAction(yourVacation.getRenameItineraryEditIcon(),"User clicks on edit icon in the saved itinerary 1st first");
		typeText(yourVacation.getTextBoxRenameItinerary(),"itinerary renaming");
		clickAction(yourVacation.getSubmitButtonRenameItinerary());
		}
	}
	@Then("^validate the itinerary got renamed successfully$")
	public void validate_the_itinerary_got_renamed_successfully() {
		afterRename = getText(yourVacation.getBeforeRename());
		 Assert.assertTrue(!beforeRename.equalsIgnoreCase(afterRename));
	}
	@And("^user delete the itinerary$")
	public void user_delete_the_itinerary() throws Throwable {
		pollingWait(yourVacation.getSavedItineraryCard(), 180);
		if(elementExist(yourVacation.getSavedItineraryCard())) {
			
			clickAction(yourVacation.getDeleteItinerary());
			clickAction(yourVacation.getDeleteItineraryDropDown());
		}
		}
		
	 @And("^user opens the booked itinerary in your vacations page$")
	 public void  user_opens_the_booked_itinerary_in_your_vacations_page() throws Throwable {
		 try {
			 if(yourVacation.getBookedItinerary().isDisplayed()) {
			 clickAction(yourVacation.getBookedItinerary());
			 switchWindows();
			 String url = getCurrentUrl();
			 validate_String_Contains(url,"yourtrips");
		     elementDisplayed(yourVacation.getViewBookedItinerary());
		     totalCostOfBookedIti = getText(yourVacation.getTotalCostInBookedItinerary());
		     clickAction(yourVacation.getViewBookedItinerary(),"User view the booked itinerary");
		     itiPageTotalCost = getText(yourVacation.getTotalCostInItineraryPage());
		     //ReporteraddStepLog("Itinerary total cost"+itiPageTotalCost);
		     //ReporteraddStepLog("Itinerary total cost in your vacations page"+totalCostOfBookedIti);
		 }else {
			 assumeTrue(false);
		 }
		 }catch(Exception e) {
			 System.out.println("There is no booked itinerary");
			 assumeTrue(false);
			 //ReporteraddStepLog("There is no booked itinerary");
		 }
			
	}
	 @Then("^validate the itinerary shouldn't customizable$")
	 public void validate_the_itinerary_should_not_customizable() throws Throwable{
		 compareTwoStringsPartially(totalCostOfBookedIti,itiPageTotalCost);
		 if(elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
			}
		 scrollUp();
		 Thread.sleep(1000);
		 Boolean disabled = (Boolean) driver.executeScript("return arguments[0].hasAttribute(\"disabled\");", inclusion.getBookandReviewButton());
         System.out.println("disabled--"+disabled);
		 Assert.assertTrue(disabled);
 }
	 
	 @And("^select the itinerary from saved itinerary page$")
	 public void select_the_itinerary_from_saved_itinerary_page() throws Throwable{
		 waitForMe(yourVacation.getSavedItinerarySection());
		 totalCountSavedIti = driver.findElements(By.xpath("//div[@id='saved']//section"));
		 int count = totalCountSavedIti.size();
		 WebElement savedItineraryCard = driver.findElement(By.xpath("(//div[@id='saved']//section)["+ (count-1) +"]"));
		 scrolltoElement(savedItineraryCard);
		 clickAction(savedItineraryCard);
		 switchWindows();
//		 popupClosure();
	 }
	 @And("^do update cost if the itinerary is stale costed$")
	 public void do_update_cost_if_the_itinerary_is_stale_costed() throws Throwable{
		 popupClosure();
		 try {
		 if (elementExist(inclusion.getUpdateCostButton())) {
			 
				clickAction(yourVacation.getUpdateCostButton());
				waitForMe(inclusion.getBookandReviewButton());
				verifyEnabled(inclusion.getBookandReviewButton());
		 }
		 }
		 catch (NoSuchElementException e)
		 
				{
			        System.out.println("The itinerary is not stale costing");
			        //ReporteraddStepLog("The itinerary is not stale costing");
					validate_String_Contains(getCurrentUrl(),"view");
					
				}
		 
	 
			
	 }
		 @And("^get the itinerary id$")
		 public void get_the_itinerary_id() throws Throwable {
			 
			  url = getCurrentUrl();
              itineraryID=url.substring(url.length()-24);
             System.out.println("Itinerary Id" + itineraryID);
		 }
		 
	@And("^user makes the first payment$")
	public void user_makes_the_first_payment() throws Throwable {
		clickAction(razorpaypage.gettermsConditionsCheckBox(),
				"User clicks the terms and conditions checks and accepts the  terms declared");
		
		clickAction(paymentPage.getPayFiftyPercentButton(), "User makes the 50% payment");
		clickAction(paymentPage.getPayFiftyPercentButton(), "User makes the 50% payment");
	
		}
	
	@Then("^user makes the third payment directly without paying first and second payment$")
	public void user_makes_the_third_payment_directly_without_paying_first_and_second_payment() throws Throwable {
		clickAction(razorpaypage.gettermsConditionsCheckBox(),
				"User clicks the terms and conditions checks and accepts the  terms declared");
		
		clickAction(paymentPage.getPayHundredPercentButton(), "User makes the 100% payment");
	
	
	}

	
	@And("^user makes first payment for customised percentage of pay$")
	public void user_makes_customized_payment() throws Throwable {
		clickAction(razorpaypage.gettermsConditionsCheckBox(),
				"User clicks the terms and conditions checks and accepts the  terms declared");
		
		if (!paymentPage.getPayFiftyPercentButton().getAttribute("class").toString().contains("disabled")) {
			
			clickAction(paymentPage.getPayFiftyPercentButton());
			clickAction(paymentPage.getPayFiftyPercentButton(), "User makes the 50% payment");
			//clickAction(paymentPage.getPayFiftyPercentButton(), "User makes the 50% payment");
		}
		else if (!paymentPage.getPaySeventyPercentButton().getAttribute("class").toString().contains("disabled")) {
			clickAction(paymentPage.getPaySeventyPercentButton());
			clickAction(paymentPage.getPaySeventyPercentButton());
			//clickAction(paymentPage.getPaySeventyPercentButton());
		}
		else {
			clickAction(paymentPage.getPayHundredPercentButton());
			clickAction(paymentPage.getPayHundredPercentButton());
			
		}
	}
	
	
	
	
	@Then("^user should redirect to your vacations page from payment success page$")
	public void user_should_redirect_to_your_vacations_page_from_payment_success_page() throws Throwable {
		clickAction(paymentPage.getPaymentSuccessYourVacation(),"User clicks Your vacations link in payment success page");
		switchWindows();
		validate_String_Contains(getCurrentUrl(),"your-vacations");
	}
	
	@And("^user navigates the booked itinerary in your vacations page$")
	public void navigation_to_booked_itinerary() throws InterruptedException {
		elementExist(yourVacation.getBookedItinerary());
		clickAction(yourVacation.getBookedItinerary());
		switchWindows();	
	}
	
	
	@And("^user navigates to payment tab$")
	public void user_navigates_to_payment_tab() throws Throwable {
		waitForMe(yourVacation.getPaymentTab());
		clickAction(yourVacation.getPaymentTab());
	}
	@And("^user makes second payment from your vacations$")
	public void user_makes_second_payment_your_vacations() throws Throwable {
		if(elementExist(yourVacation.getPartialPayment())) {
		clickAction(yourVacation.getPartialPayment(),"User clicks on partial payment in the your vacations page booked itinerary");
		clickAction(yourVacation.getMakePaymentFromYourvacations(),"User clicking in make payment button in booked iti from your vacations ");
		}else {
			assumeTrue(false);
		}
		
	}
	@And("^user makes third payment from your vacations page$")
	public void user_makes_third_payment_from_your_vacations_page() throws Throwable {
		clickAction(yourVacation.getFullPayment(),"User clicks on partial payment in the your vacations page booked itinerary");
		clickAction(yourVacation.getMakePaymentFromYourvacations(),"User clicking in make payment button in booked iti from your vacations ");
	}
	
	@Then("^validate the itinerary got deleted successfully$")
	public void validate_the_itinerary_got_deleted_successfully() throws Throwable {
		Thread.sleep(2000);
		afterRename = getText(yourVacation.getBeforeRename());
		System.out.println("Itinerary name before delete - "+beforeRename+" and After delete - "+afterRename);
		 Assert.assertTrue(!beforeRename.equalsIgnoreCase(afterRename));
	}
	@Given("^Login as a authenticated user without redirect to homepage$")
	public void login_as_a_authenticated_user_without_redirect_to_homepage() throws Throwable {
		loginFunctionalityTest("Registered_User"); 
		hoverWebelement(hp.getUserLoggedInitial());
		clickAction(hp.getYourVactionsFromHomePage());	
		pollingWait(yourVacation.getsavedItinerary1stCard(), 240);
	}




}
