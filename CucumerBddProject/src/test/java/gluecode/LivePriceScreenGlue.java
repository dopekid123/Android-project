package gluecode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class LivePriceScreenGlue extends Kernel {

	public static List<WebElement> InclusionLineItemCard;
	public static List<WebElement> livePriceCard;
	UserFloGlue usePas = new UserFloGlue();
	public static int inclusionFlightCount=0;
	public static int inclusionHotelCount=0;
	public static int inclusionTransferCount=0;
	public static int liveFlightCount=0;
	public static int liveHotelCount=0;
	public static int liveTransferCount=0;
	static String cnt ="";
	
	@And("^get the count of the inclusions card count from the inclusions page$")
	public void get_the_count_of_the_inclusions_card_count_from_the_inclusions_page() throws Throwable {
		cnt = inclusion.getFlightTabInclusions().getText();
		inclusionFlightCount=Integer.parseInt(cnt.replaceAll("[^0-9]", ""));
		if(driver.findElements(By.xpath("//div[@name='flight']//section[contains(@class,'error')]")).size()>0){
			int cnt = driver.findElements(By.xpath("//div[@name='flight']//section[contains(@class,'error')]")).size();
			inclusionFlightCount = inclusionFlightCount - cnt;
		}
		cnt=inclusion.getHotelTabInclusions().getText();
		inclusionHotelCount=Integer.parseInt(cnt.replaceAll("[^0-9]", ""));
		if(driver.findElements(By.xpath("//div[@name='stay']//section[contains(@class,'error')]")).size()>0){
			int cnt = driver.findElements(By.xpath("//div[@name='stay']//section[contains(@class,'error')]")).size();
			inclusionHotelCount = inclusionHotelCount - cnt;
		}
		cnt=inclusion.getTransferTabInclusions().getText();
		inclusionTransferCount=Integer.parseInt(cnt.replaceAll("[^0-9]", ""));
		if(driver.findElements(By.xpath("//div[@name='transfer']//section[contains(@class,'error')]")).size()>0){
			int cnt = driver.findElements(By.xpath("//div[@name='transfer']//section[contains(@class,'error')]")).size();
			inclusionTransferCount = inclusionTransferCount - cnt;
		}
	}
	@And("^get the count of the inclusions card from the live price page$")
	public void get_the_count_of_the_inclusions_card_from_the_live_price_page() throws Throwable {
		waitUntil(psp.getMakePaymentLivePrice(), 50);
		validate_String_Contains(getCurrentUrl(), "booking-review/");
		Thread.sleep(1000);
		clickAction(psp.getShowMoreButtonInLivePrice());
		Thread.sleep(1000);
		liveFlightCount = driver.findElements(By.xpath("//div[@class='clearfix review-table']//a[contains(@href,'flight')]")).size();
		liveHotelCount  = driver.findElements(By.xpath("//div[@class='clearfix review-table']//a[contains(@href,'hotel')]")).size();
		liveTransferCount =driver.findElements(By.xpath("//div[@class='clearfix review-table']//a[contains(@href,'transfer')]")).size();
	}

	@Then("^validate the both count are same$")
	public void validate_the_both_count_are_same() throws Throwable {
		System.out.println(inclusionFlightCount+"-Flight-"+liveFlightCount);
		System.out.println(inclusionHotelCount+"-Hotel-"+liveHotelCount);
		System.out.println(inclusionTransferCount+"-Transfer-"+liveTransferCount);
		Thread.sleep(2000);
		validateAssertion(inclusionFlightCount==liveFlightCount);
		validateAssertion(inclusionHotelCount==liveHotelCount);
		validateAssertion(inclusionTransferCount==liveTransferCount);
	}

	@And("^apply the coupon and verify the application of discount$")
	public void validate_the_kajalpyt_coupon_application() throws Throwable {
		String totalCost = getText(psp.getTotalCost());
		String totalresult = totalCost.replaceAll("[-+.^:,₹]", "");
		System.out.println(totalresult);
		clickAction(psp.getApplyCoupon());
		typeText(psp.getEnterCoupon(), "KAJALPYT");
		clickAction(psp.getApplyCode());
		String appliedDiscount = getText(psp.getTotalCost());
		String appliedDiscountResult = appliedDiscount.replaceAll("[-+.^:,₹]", "");
		int totalresultParsed = integerParser(totalresult);
		int appliedDiscountResultParsed = integerParser(appliedDiscountResult);
		Assert.assertEquals(totalresultParsed - 5000, appliedDiscountResultParsed);

	}
	
	public void validate_the_activity_removed_successfully() throws Throwable {
		boolean isReomved = verifyExactText(activityPage.getActivitySlider_AfterRemove(), "Activity Removed!");
		Assert.assertTrue(isReomved);
		clickAction(activityPage.getActivity_SliderClose(),"User clicks on out side the silder to close");
	}
	
	//Handling the sold-out scenario for activities in the live price screen
	
	@Then("^user Verifies if there is any sold out line item in the live price screen$")
	public void user_Verifies_if_there_is_any_sold_out_line_item_in_the_live_price_screen() throws Throwable {
		
		//If Change booking CTA displayed there are sold-out line items in the live price screen.
		
		if(elementDisplayed(booingReview.getChangeBooking())){
			scrollDown();
			clickAction(booingReview.getChangeBooking());
			Thread.sleep(1000);
			clickAction(booingReview.getItineraryButton());
			List<WebElement> soldOutActivities = driver.findElements(By.xpath("//span[contains(@class,'sold-out')]"));
			for(int i=1; i<=soldOutActivities.size(); i++)
			{
				Thread.sleep(2000);
			WebElement	soldOutActivity = driver.findElement(By.xpath("(//span[contains(@class,'sold-out')])[1]"));
			soldOutActivity.click();
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();

			}
			scrollUp();
			waitForMe(booingReview.getInclusionButton());
			clickAction(booingReview.getInclusionButton());
			Thread.sleep(2000);
			clickAction(pdgtreco.waitForCosting());
			clickAction(pdgflowp.getcontinue_to_book_button(), "User clicks continue to book");
			usePas.user_fills_passenger_details();
			validateAssertion(elementDisplayed(booingReview.getmakePaymentButton()));
		}
		
		// If there is no "change booking" CTA in the booking live price screen proceed with bookings
		
		else if(elementDisplayed(booingReview.getmakePaymentButton())){
			assumeTrue(true);
		}

	}







}
