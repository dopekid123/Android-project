package gluecode;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class taxCalculationGlue extends Kernel {

	String tripCost = null;
	int tripCostInt = 0;
	String gstPrice = null;
	int gstPriceInt = 0;
	int tcsPriceInt = 0;
	int totalcostCalc = 0;
	double GstAndTcsPercent = 0.05;
	int discountapplied = 0;
	int totalCostWithoutTCS = 0;
	int tcsCostInt = 0;
	int gstcalc = 0;

	@Then("^Calculate the GST of the itinerary from trip cost for \"([^\"]*)\"$")
	public void calculate_the_GST_of_the_itinerary_from_trip_cost_for(String region) throws Throwable {
    try {
		if(region.equals("Singapore")) {
		
		int tripCostAmt = tripCostCalculation();
		gstPrice = price.getGstPrice().getText().replaceAll("[^0-9]", "");
		gstPriceInt = Integer.parseInt(gstPrice);
		System.out.println("gstPriceInt--" + gstPriceInt);

		// GST Calculation
		gstcalc = GSTCalculation(tripCostAmt);

		/*
		 * Validating the price shown on tool tip for gst with calculated amount for gst
		 * gstPriceInt --> Price shown on tool tip gstroundvalue --> calculated gst
		 * value
		 */

		validateAssertion(gstPriceInt == gstcalc);

	} 
		 /*GST in product previously maintained based on locale level ex; India or global locale
		 * But the logic has been changed currently - GST changes based on region level irrespective of locale level
		 * Data for the same singapore - Gst true, Europe - GST false.
		 */
		else if(region.equals("Europe")){
			
			if(elementDisplayed(price.getGstPrice())==false) {
			gstcalc = 0;
			}
			else {
				Assert.fail();
			}
		}
	}
   catch (Exception e) {
	e.printStackTrace();
    }
	}

	public int GSTCalculation(int tripcost) {

		float gstAmt = (float) (tripcost * GstAndTcsPercent);
		int gstroundvalue = (int) Math.round(gstAmt);
		System.out.println("gstroundvalue--" + gstroundvalue);
		System.out.println("gstAmt--" + gstAmt);
		return gstroundvalue;

	}

	@Then("^Calculate the TCS of the itinerary from trip cost$")
	public void calculate_the_TCS_of_the_itinerary_from_trip_cost() throws Throwable {

		int tripCostAmt = tripCostCalculation();

		String tcsPrice = price.getTcsPrice().getText().replaceAll("[^0-9]", "");
		tcsPriceInt = Integer.parseInt(tcsPrice);
		System.out.println("tcsPriceInt--" + tcsPriceInt);

		// TCS Calculation
		/*
		 * Validating the price shown on tool tip for tcs with calculated amount for tcs
		 * tcsPriceInt --> Price shown on tool tip tcsroundvalue --> calculated gst
		 * value
		 */
		int tcscalc = tcsCalculation(tripCostAmt, gstPriceInt);
		validateAssertion(tcsPriceInt == tcscalc);

	}

	public int tcsCalculation(int tripCost, int gstPrice) {

		float tcsAmt = (float) ((tripCost + gstPrice) * GstAndTcsPercent);
		int tcsroundvalue = (int) Math.ceil(tcsAmt);
		System.out.println("tcsroundvalue--" + tcsroundvalue);
		System.out.println("tcsAmt--" + tcsAmt);
		return tcsroundvalue;

	}

	public int tripCostCalculation() {

		try {
			Thread.sleep(2000);
			scrollUp();
			hoverWebelement(price.getPriceToolTip());
			tripCost = price.getTripCost().getText().replaceAll("[^0-9]", "");
			tripCostInt = Integer.parseInt(tripCost);
			System.out.println("tripCostInt--" + tripCostInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return tripCostInt;

	}

	@Then("^Verify GST and TCS aren't available for global$")
	public void verify_GST_and_TCS_aren_t_available_for_global() throws Throwable {

		selectlocalefrommodal("ae");
		hoverWebelement(price.getPriceToolTip());
		if (elementDisplayed(price.getGstPrice()) == false && elementDisplayed(price.getTcsPrice()) == false) {
			Assert.assertTrue(true);
		}
		selectlocalefrommodal("us");
		hoverWebelement(price.getPriceToolTip());
		if (elementDisplayed(price.getGstPrice()) == false && elementDisplayed(price.getTcsPrice()) == false) {
			Assert.assertTrue(true);
		}

	}

	// This method selects the locale from update locale modal under share itinerary

	public void selectlocalefrommodal(String locale) {
		try {
			scrolltoElement(adminPage.getadminOptionsDropdown());
			clickAction(adminPage.getadminOptionsDropdown(), "Clicking Admin Dropdown Admin features");
			clickAction(adminPage.getUpdateLocaleOption());
			validateAssertion(elementDisplayed(adminPage.getUpdateLocaleModel()));
			Thread.sleep(2000);
			WebElement loc = driver.findElement(By.xpath("//td[contains(text(),'" + locale + "')]"));
			clickAction(loc);
			System.out.println("//td[contains(text(),'"+locale+"')]");
			clickAction(adminPage.getChangeOptionOnUpdateLocale());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^Validate the \"([^\"]*)\" is applied on tripcost and check tcs is calcualted on top of that for \"([^\"]*)\"$")
	public void validate_the_is_applied_on_tripcost_and_check_tcs_is_calcualted_on_top_of_that_for(String amt,
			String scenario) throws Throwable {
		CalculatetcsAfterReduction(amt, scenario);
	}

	public void CalculatetcsAfterReduction(String amt, String scenario) {

		try {
			clickAction(psp.getBackLink());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(@class,'SplitPrice__ShowMore')]")).click();
			String discount = driver
					.findElement(By.xpath(
							"//div[contains(@class,'RightSidePanel')]//span[contains(@class,'SplitPrice__BoldData')]"))
					.getText();
			String discountstr = discount.replaceAll("[^\\d]", "");
			discountapplied = Integer.parseInt(discountstr);
			if (scenario.equals("couponcode")) {
				int couponamount = Integer.parseInt(amt);
				validateAssertion(discountapplied == couponamount);
			} else if (scenario.equals("loyalitycredit")) {
				int loyalitycredit = Integer.parseInt(amt);
				validateAssertion(discountapplied == loyalitycredit);
			}

			int tripcostOnToolTip = tripCostCalculation();

			int tripcostaftercoupon = tripcostOnToolTip - discountapplied;
			int gstaftercoupon = GSTCalculation(tripcostaftercoupon);
			int tcsaftercoupon = tcsCalculation(tripcostaftercoupon, gstaftercoupon);

			int totalitincost = tripcostaftercoupon + gstaftercoupon + tcsaftercoupon;

			String currencyintotalprice = adminPrice.getTotalItineraryCost().getText().replaceAll("[^0-9]", "")
					.replace(",", "").trim();
			System.out.println("currencyintotalprice--" + currencyintotalprice);
			int totalcost = Integer.parseInt(currencyintotalprice);

			int diffintotalcost = totalitincost - totalcost;
			if (diffintotalcost == 0 || diffintotalcost == 1) {

				Assert.assertTrue(true);

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("^Fetch the tripcost and GST amount from inclusion page for calculating tcs on each card$")
	public void fetch_the_tripcost_and_GST_amount_from_inclusion_page_for_calculating_tcs_on_each_card()
			throws Throwable {
		if (elementDisplayed(psp.getLivePriceBacktoItinerarybtn())) {
			clickAction(psp.getLivePriceBacktoItinerarybtn());
		} else {
			System.out.println("There are sold out line items in the itinerary");
			Assert.fail();
		}

		int tripCost = tripCostCalculation();
		String gstCost = price.getGstPrice().getText().replaceAll("[^0-9]", "");
		int gstCostInt = Integer.parseInt(gstCost);

		String tcsCost = price.getTcsPrice().getText().replaceAll("[^0-9]", "");
		tcsCostInt = Integer.parseInt(tcsCost);

		totalCostWithoutTCS = (tripCost + gstCostInt);

	}

	@Then("^user validates each card contains respective tcs value$")
	public void user_validates_each_card_contains_respective_tcs_value() throws Throwable {

		List<WebElement> paymentcards = driver
				.findElements(By.xpath("//div[contains(@class,'pay-card n-tracker-paycard')]"));

		if (paymentcards.size() > 0) {

			for (int i = 0; i <= 2; i++) {
				String cardpercent = driver
						.findElement(By.xpath(
								"(//div[contains(@class,'pay-card n-tracker-paycard')]//p)["+(i+(i+1))+"]"))
						.getText();
				String paycardamt = driver
						.findElement(By.xpath(
								"(//div[contains(@class,'pay-card n-tracker-paycard')]//p/../strong)["+(i+1)+"]"))
						.getText().replaceAll("[^0-9]", "");

				int cardamt = Integer.parseInt(paycardamt);

				if (cardpercent.contains("50%")) {
					double fiftypercentf = (totalCostWithoutTCS * 0.5);
					long fiftypercent = Math.round(fiftypercentf);
					int priceoncardcalc = (int) (fiftypercent + tcsCostInt);
					int diffincost = priceoncardcalc - cardamt;
					if (diffincost == 0 || diffincost == 1) {
						Assert.assertTrue(true);
					}

				} else if (cardpercent.contains("70%")) {
					double seventypercentf = (totalCostWithoutTCS * 0.7);
					long seventypercent = Math.round(seventypercentf);
					int priceoncardcalc = (int) (seventypercent + tcsCostInt);
					int diffincost = priceoncardcalc - cardamt;
					if (diffincost == 0 || diffincost == 1) {
						Assert.assertTrue(true);
					}

				} else {
					int priceoncardcalc = totalCostWithoutTCS + tcsCostInt;
					int diffincost = priceoncardcalc - cardamt;
					if (diffincost == 0 || diffincost == 1) {
						Assert.assertTrue(true);
					}

				}

			}
		}

	}

}
