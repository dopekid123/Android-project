package gluecode;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pyt.pages.DiscountPricingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class DiscountPricingGlue extends Kernel {

	public static int adminPriceApply;
	public static int lineItemCost;
	public static String internalFlightPrice = "";
	public static String trainPrice = "";
	public static String AHPrice = "";
	public static String rentalCarPrice = "";
	public static String activityPrice = "";
	public static String adminPriceAmount = "";
	public static String overallPrice = "";
	public static String totalPrice = null;
	int tripCost;
	int tripCostAfterDisCount;

	/*
	 * Parameters used all over the class
	 * 
	 * lineitem,category,field,value lineitem means Hotel,flight transfer category
	 * means division part of line item [ eg; Flight -> International , Internal ]
	 * Rate match modal [discount modal] contains fields and value
	 */

	/*
	 * This function get the total price of a line item and calculate the admin
	 * discount price needs to be applied
	 */

	public int adminPriceCalculation(String discountamt, String lineitem, String category) {
		switch (category) {

		case "common": {
			WebElement price = driver.findElement(By.xpath("(//div[@name='" + lineitem + "']//b)[1]"));
			totalPrice = price.getText();
			System.out.println("totalPrice for hotel -------" + totalPrice);
			break;
		}
		case "activity": {
			totalPrice = activityPrice;
			break;
		}
		case "internal": {
			totalPrice = internalFlightPrice;
			break;
		}
		case "train": {
			totalPrice = trainPrice;
			break;
		}
		case "AHtransfer": {
			totalPrice = AHPrice;
			break;
		}
		case "rentalcar": {
			totalPrice = rentalCarPrice;
			break;
		}
		case "price": {
			break;
		}
		}
		int discountamtint = Integer.parseInt(discountamt);
		System.out.println("discountamtint--" + discountamtint);
		if (category.equals("price")) {
			adminPriceApply = discountamtint;
		} else {
			int lineItemCost = Integer.parseInt(totalPrice.replaceAll("[^0-9]", ""));
			adminPriceApply = (lineItemCost - discountamtint);
		}
		return adminPriceApply;

	}

	// This function is to verify and validate edit icon for hotel line item

	@Then("^Validate that the edit icon is showing for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_for_applying_admin_price() throws Throwable {
		try {
			clickAction(adminPrice.getHotelPanel());
			Thread.sleep(1000);
			clickAction(adminPrice.getDiscountIcon());
		} catch (Exception e) {
			String hotellen = adminPrice.getHotelCount().getText();
			System.out.println("flightopt--->" + hotellen);
			int hotelCount = Integer.parseInt(hotellen.replaceAll("[^0-9]", ""));
			for (int i = 2; i <= hotelCount; i++) {
				WebElement hotelPanel = driver.findElement(
						By.xpath("(//div[@name='stay']//section[contains(@class,'inclusion-box')])[" + i + "]"));
				try {
					if (elementDisplayed(hotelPanel)) {
						clickAction(hotelPanel);
					}
				} catch (Exception ex) {
					continue;
				}
			}
			Thread.sleep(1000);
			clickAction(adminPrice.getDiscountIcon());

		}
		Thread.sleep(1000);
		validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));

	}

	public void rateMatchFields(String field, String value) {
		WebElement rateMatchFields = driver.findElement(By.xpath("//span[text()='" + field + "']/../select"));
		selectDropDownUsingValue(rateMatchFields, value);

	}

	@Then("^verify the admin price label is showing$")
	public void verify_the_admin_price_label_is_showing() throws Throwable {
		pollingWait(booingReview.getbookNowButton(),20);
		validateAssertion(elementDisplayed(inclusion.getBookNow()));
		scrollToView(adminPrice.getAdminPricelabel());
		Thread.sleep(2000);
		validateAssertion(elementDisplayed(adminPrice.getAdminPricelabel()));

	}

	/*
	 * This function is used to verify the update cost scenario's here we change the
	 * departure city and update cost the itinerary and wait for costed itinerary
	 */

	@Then("^change the departure city and update cost$")
	public void change_the_departure_city_and_update_cost() throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(1000);
		scrollToView(hp.getPytLogo());
		validateAssertion(elementDisplayed(adminPrice.getChangePassengerInfo()));
		clickAction(adminPrice.getChangePassengerInfo());
		Thread.sleep(1000);
		clickAction(icm.getDepartingCity());
		clickAction(icm.getdepartingFromBengaluru());
		clickAction(icm.getGcmUpdateCost());
		WebElement costingAnimation = driver.findElement(By.xpath("//div[contains(@class,'animation-holder')]"));
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOf(costingAnimation));
		pollingWait(inclusion.getBookNow(), 300);

	}

	/*
	 * Function to validate discount is applied or not for activity Expanding the
	 * activity line item is required to validate the admin price label for activity
	 * so added the separate method to validate admin price label
	 */

	@Then("^validate that the applied discount got retained for an activity$")
	public void validate_that_the_applied_discount_got_retained_for_an_activity() throws Throwable {
		System.out.println("admindiscount");
		waitForMe(booingReview.getbookNowButton());
		validateAssertion(elementDisplayed(inclusion.getBookNow()));
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		waitForMe(activityPage.getActivity_ExpandActivityInclusions());
		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		validateAssertion(elementDisplayed(adminPrice.getAdminPricelabel()));
	}

	/*
	 * This function is used to verify the update cost scenario's here we change the
	 * arrival city and update cost the itinerary and wait for costed itinerary
	 */

	@Then("^change the arrival city and update cost$")
	public void change_the_arrival_city_and_update_cost() throws Throwable {
		driver.navigate().refresh();
//		//scrollToView(adminPrice.getChangePassengerInfo());
		Thread.sleep(3000);
		validateAssertion(elementDisplayed(adminPrice.getChangePassengerInfo()));
		clickJavaScriptElement(adminPrice.getChangePassengerInfo());
		Thread.sleep(1000);
		clickAction(icm.getArrivalCityCheckBox());
		clickAction(icm.getArrivalCity());
		waitForMe(icm.getdepartingFromChennai());
		clickAction(icm.getdepartingFromChennai());
		Thread.sleep(1000);
		clickAction(icm.getGcmUpdateCost());
		pollingWait(inclusion.getBookNow(), 300);

	}

	// Flight related functionalities

	// This method finds the edit icon for internal and international flight
	// separately

	@Then("^Validate that the edit icon is showing on \"([^\"]*)\" for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_for_applying_admin_price(String flight) throws Throwable {

		String flightlen = adminPrice.getFlightCount().getText();
		System.out.println("flightopt--->" + flightlen);
		// String removeBraces = flightlen.replaceAll("\\p{P}", "");
		// int flightCount = Integer.parseInt(removeBraces.trim());
		int flightCount = Integer.parseInt(flightlen.replaceAll("[^0-9]", ""));
		System.out.println("flightcount---" + flightCount);
		int internalFlightCount = flightCount - 1;
		System.out.println("Internal flight count----" + internalFlightCount);
		if (flight.equals("international")) {
			try {
				if (elementDisplayed(adminPrice.getFlightDiscountIcon())) {
					clickAction(adminPrice.getFlightDiscountIcon());
				}
			} catch (NoSuchElementException e) {
				System.out.println("Discount icon is not available for International flight");
			}
		} else if (flight.equals("internal")) {
			for (int i = 2; i <= (++internalFlightCount); i++) {
				WebElement internalflightediticon = driver
						.findElement(By.xpath("(//div[@name='flight']//i[contains(@class,'pyt-edit')])[" + i + "]"));

				internalFlightPrice = driver
						.findElement(By.xpath("(//div[@name='flight']//b[@class='color-grey-secondary'])[" + i + "]"))
						.getText();

				System.out.println(internalFlightPrice);

				if (elementDisplayed(internalflightediticon)) {
					clickAction(internalflightediticon);
					break;
				} else {
					System.out.println("Discount icon is not available for Internal flight for "
							+ (internalFlightCount++) + " flight");
				}
			}
		}
		Thread.sleep(1000);
		validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
	}

	// This function fills the parameters required to apply discount on rate match
	// modal

	@Then("^Apply \"([^\"]*)\" on the \"([^\"]*)\" for the \"([^\"]*)\" price$")
	public void apply_on_the_for_the_price(String discountamt, String lineitem, String category) throws Throwable {

		int adminPriceInteger = adminPriceCalculation(discountamt, lineitem, category);
		adminPriceAmount = Integer.toString(adminPriceInteger);
//		Thread.sleep(1000);
		typeText(adminPrice.getAdminPriceField(), adminPriceAmount);
//		Thread.sleep(1000);

		switch (lineitem) {
		case "flight": {
			rateMatchFields("Source", "TBO");
			rateMatchFields("Reason", "Flights already booked by customers");
			break;
		}
		case "stay": {
			rateMatchFields("Source", "TBO");
			rateMatchFields("Reason", "PYT Contract Hotels");
			break;
		}
		case "activities": {
			rateMatchFields("Source", "Viator");
			rateMatchFields("Reason", "Not available on Viator");
			break;
		}
		case "transfer": {

			if (category.equals("train")) {
				rateMatchFields("Source", "SNCF");
				rateMatchFields("Reason", "Expensive On Product");
				break;
			} else if (category.equals("AHtransfer")) {

				rateMatchFields("Source", "Others");
				Thread.sleep(1000);
				typeText(adminPrice.getairportHotelSourceText(), "test");
				rateMatchFields("Reason", "Expensive On Product");
				break;
			}

			else if (category.equals("rentalcar")) {

				rateMatchFields("Source", "THRIFTY");
				rateMatchFields("Reason", "Expensive On Product");
			}

		}

		case "more": {
			rateMatchFields("Reason", "Adding buffer");
		}

		}
		rateMatchFields("Approved By", "DWARAKA");
		rateMatchFields("Retain Cancellation Policy", "YES");
		clickAction(adminPrice.getRateMatchUpdate());
	}

	// This method finds the edit icon for activity

	@Then("^Validate that the edit icon is showing on activity for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_activity_for_applying_admin_price() throws Throwable {

		try {
			clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
			clickAction(activityPage.getActivity_ExpandActivityInclusions());

			WebElement activitiesEditIcon = driver
					.findElement(By.xpath("(//div[@name='activities']//i[contains(@class,'pyt-edit')])[1]"));

			activityPrice = driver
					.findElement(By.xpath("//div[@name='activities']//i[contains(@class,'pyt-edit')]/../span//b"))
					.getText();

			System.out.println("activityPrice---" + activityPrice);
			if (elementDisplayed(activitiesEditIcon)) {
				clickAction(activitiesEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for train");
		}

	}

//This method finds the edit icon for train

	@Then("^validate that the edit icon is showing on train for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_train_for_applying_admin_price() throws Throwable {

		try {
			WebElement trainEditIcon = driver.findElement(
					By.xpath("(//button[contains(@class,'change-train')]/../div//i[contains(@class,'pyt-edit')])[1]"));
			trainPrice = driver.findElement(By.xpath(
					"//button[contains(@class,'change-train')]/../div//i[contains(@class,'pyt-edit')]/../span/b"))
					.getText();
			System.out.println("trainPrice---" + trainPrice);
			if (elementDisplayed(trainEditIcon)) {
				clickAction(trainEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for train");
		}
	}

//This method finds the edit icon for airport-hotel transfer without transfer type

	@Then("^validate that the edit icon is showing on airport-hotel transfer for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_airport_hotel_transfer_for_applying_admin_price()
			throws Throwable {

		try {
			// Commented by sharmila - 29-07-2021 - The xpath is not unique to transfer so
			// changed that.
//			WebElement AHtransferEditIcon = driver.findElement(By.xpath(
//					"//button[contains(text(),'Change to shared')]/../../div/following::i[contains(@class,'pyt-edit')]"));

			WebElement AHtransferEditIcon = driver
					.findElement(By.xpath("//div[@name='transfer']//i[contains(@class,'pyt-edit')]"));
			AHPrice = driver
					.findElement(By.xpath(
							"(//div[@name='transfer']//i[contains(@class,'pyt-edit')]/../../div//i/../span/b)[1]"))
					.getText();
			System.out.println("AHPrice---" + AHPrice);
			scrolltoElement(AHtransferEditIcon);
			Thread.sleep(1000);
			if (elementDisplayed(AHtransferEditIcon)) {
				clickAction(AHtransferEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}

	/*
	 * Added the separate glue code for airport-hotel transfer with transfer type
	 * Since we have two kinds of airport-hotel transfer - with transfer type and
	 * without transfer type This testcase will validate only the transfer which
	 * contains "change to shared" or "change to private" Verify the discount is not
	 * getting retained after changing the transfer type
	 */
	@Then("^validate that the edit icon is showing on airport-hotel transfer with transfer type for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_airport_hotel_transfer_with_transfer_type_for_applying_admin_price()
			throws Throwable {
		try {
			WebElement AHtransferEditIcon = driver
					.findElement(By.xpath("(//button[contains(text(),'Change to')]/../../div//i)[1]"));
			AHPrice = driver.findElement(By.xpath("//button[contains(text(),'Change to')]/../../div//i/../span/b"))
					.getText();
			System.out.println("AHPrice---" + AHPrice);
			scrolltoElement(AHtransferEditIcon);
			Thread.sleep(1000);
			if (elementDisplayed(AHtransferEditIcon)) {
				clickAction(AHtransferEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}

//This method finds the edit icon for Rental car transfer

	@Then("^validate that the edit icon is showing on rental car transfer for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_rental_car_transfer_for_applying_admin_price()
			throws Throwable {

		try {

			WebElement rentalCarEditIcon = driver
					.findElement(By.xpath("(//div[@name='transfer']//i[contains(@class,'pyt-edit')])[1]"));

			rentalCarPrice = driver
					.findElement(By.xpath("//div[@name='transfer']//i[contains(@class,'pyt-edit')]/../span//b"))
					.getText();
			System.out.println("rentalCarPrice---" + rentalCarPrice);
			scrolltoElement(rentalCarEditIcon);
			Thread.sleep(1000);
			if (elementDisplayed(rentalCarEditIcon)) {
				clickAction(rentalCarEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}

	/*
	 * Apart from other line item flight as specific retain logic if any of the
	 * parameters change while doing update cost flight won't retain
	 */

	@Then("^validate that the applied discount got retained for a \"([^\"]*)\"$")
	public void validate_that_the_applied_discount_got_retained_for_a(String category) throws Throwable {
		Boolean flag = false;
		try {
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			System.out.println(adminPrice.getAdminPricelabel().isDisplayed());
			flag = adminPrice.getAdminPricelabel().isDisplayed();
			System.out.println("flag--" + flag);
		} catch (NoSuchElementException e) {
			System.out
					.println("Passed : discount price is not retained after changing departure city for---" + category);
		}
		assertFalse(flag);
	}

	/*@Then("^validate that the edit icon is showing for applying overall discount price$")
	public void validate_that_the_edit_icon_is_showing_for_applying_overall_discount_price() throws Throwable {

		try {

		taxCalculationGlue tax = new taxCalculationGlue();
			tripCost = tax.tripCostCalculation();

			WebElement overallPriceEditIcon = driver
					.findElement(By.xpath("//aside[@class='price-card']//p//i[contains(@class,'cursor-pointer')]"));

			Thread.sleep(1000);
			if (elementDisplayed(overallPriceEditIcon)) {
				clickAction(overallPriceEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));

		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}*/

	/*
	 * After applying discount need to verify discount is deducted from total price
	 * and validate the total price and discount price in tooltip
	 */
	@Then("^verify if the discount is applied for entire itinerary$")
	public void verify_if_the_discount_is_applied_for_entire_itinerary() throws Throwable {
		taxCalculationGlue tax = new taxCalculationGlue();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'SplitPrice__ShowMore')]")).click();
		String discount = driver
				.findElement(By.xpath(
						"//div[contains(@class,'RightSidePanel')]//span[contains(@class,'SplitPrice__BoldData')]"))
				.getText();
		String discountstr = discount.replaceAll("[^\\d]", "");
		int discountapplied = Integer.parseInt(discountstr);
		validateAssertion(discountapplied == adminPriceApply);

		tripCostAfterDisCount = tripCost - discountapplied;
		int tripCostOnToolTip = tax.tripCostCalculation();
		System.out.println("tripCostOnToolTip--" + tripCostOnToolTip);
		System.out.println("tripCostAfterDisCount--" + tripCostAfterDisCount);
		validateAssertion(tripCostAfterDisCount == tripCostOnToolTip);

	}

	@Then("^change the transfer type of AH transfer$")
	public void change_the_transfer_type_of_AH_transfer() throws Throwable {
		clickAction(adminPrice.getTransferType());

	}
}
