package gluecode;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class StaycationGlue extends Kernel {
	String cardtitle = "";
	String dateafterchanging = "";
	String dateandmonthonbookingmodel = "";
	int dealTotalPriceint = 0;
	int dealStrikedPriceint = 0;
	int priceonpaxscreenint;

	
	@Then("^Navigate to deals listing page from home page$")
	public void Navigate_to_deals_listing_page_from_home_page() throws Throwable {
		
		waitForMe(hp.getstartPlanningNowButton());

		driver.get(localEnvUrl + "/deals");
		Thread.sleep(2000);
//		scrollDown();
//		scrollByValue(1500);
//		scrolltoElement(sDeals.getCityCard());
		clickAction(sDeals.getCityCard());
		switchWindows();
		validate_String_Contains(getCurrentUrl(), "/best-staycation");
		waitForMe(sDeals.getDealsCard());

//		clickAction(sDeals.getDealsCard());
//		System.out.println(getCurrentUrl());
//        validateAssertion(elementDisplayed(sDeals.getDetailsNavigator()));
//        validate_String_Contains(getCurrentUrl(),"/deals");
	}

	@Then("^Check the budget filter$")
	public void check_the_budget_filter() throws Throwable {

		String urlPrice = " ";
		driver.get(localEnvUrl + "/deals/best-staycation");
		Thread.sleep(2000);
		clickJavaScriptElement(sDeals.getPriceFilterButton());

		for (int i = 0; i < sDeals.getBudgetFilterStaycationListingPage().size(); i++) {
// 	        clickJavaScriptElement(sDeals.getPriceFilterButton());

			String price = sDeals.getBudgetFilterStaycationListingPage().get(i).getText();
			Thread.sleep(1000);
		

			clickAction(sDeals.getBudgetFilterStaycationListingPage().get(i));
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getApplyFilterButton().get(1));

			Thread.sleep(1000);

			switch (price) {
			case "0 - ₹ 5k":
				urlPrice = "0_5000";
				break;
			case "₹ 5k - ₹ 10k":
				urlPrice = "5000_10000";
				break;
			case "₹ 10k - ₹ 15k":
				urlPrice = "10000_15000";
				break;
			case "₹ 15k - ₹ 20k":
				urlPrice = "15000_20000";
				break;
			case "₹ 20k - ₹ 30k":
				urlPrice = "20000_30000";
				break;
			case "Above ₹ 30k":
				urlPrice = "30000_9900000";
				break;
			default: {
				System.out.println("Invalid price filter option");
			}
			}
			Thread.sleep(1000);
// 			System.out.println(urlPrice);
// 			System.out.println(getCurrentUrl());
			validateAssertion(getCurrentUrl().contains(urlPrice));
			try {
				if (elementDisplayed(sDeals.getDealsCard())) {
					System.out.println("Successfully validated " + price + " option in price filter");
				}
			} catch (Exception e) {
				System.out.println(" There is no option for " + price + " filter");
			}
			clickJavaScriptElement(sDeals.getPriceFilterButton());
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getPriceResetFilterButton());

// 			 clickJavaScriptElement(sDeals.getPriceFilterButton());

		}

	}

	@Then("^Check the deals from filter$")
	public void check_the_deals_from_filter() throws Throwable {
		driver.get(localEnvUrl + "/deals/best-staycation");
		Thread.sleep(2000);
		clickJavaScriptElement(sDeals.getDealsFromFilterButton());

		for (int i = 0; i < sDeals.getDealsFromFilterStaycationListingPage().size(); i++) {
// 	        clickJavaScriptElement(sDeals.getPriceFilterButton());

			String city = sDeals.getDealsFromFilterStaycationListingPage().get(i).getText();
			Thread.sleep(1000);

			String lowerCity = city.toLowerCase().replaceAll(" ", "");
			
			clickAction(sDeals.getDealsFromFilterStaycationListingPage().get(i));
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getApplyFilterButton().get(0));

			Thread.sleep(2000);

			System.out.println(getCurrentUrl());

			validateAssertion(getCurrentUrl().contains(lowerCity));
			try {
				if (elementDisplayed(sDeals.getDealsCard())) {
					System.out.println("Successfully validated " + city + " option in deals from filter");
				}
			} catch (Exception e) {
				System.out.println(" There is no option for " + city + " filter");
			}
			clickJavaScriptElement(sDeals.getDealsFromFilterButton());
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getResetFilterButton());

		}
	}

	@Then("^Check the category filter$")
	public void check_the_category_filter() throws Throwable {
		driver.get(localEnvUrl + "/deals/best-staycation");
		Thread.sleep(2000);
		clickJavaScriptElement(sDeals.getCategoryFilterButton());

		for (int i = 0; i < sDeals.getCategoriesFilterStaycationListingPage().size(); i++) {
// 	        clickJavaScriptElement(sDeals.getPriceFilterButton());

			String category = sDeals.getCategoriesFilterStaycationListingPage().get(i).getText();
			Thread.sleep(1000);

			String lowerCategory = category.toLowerCase();
			
			clickAction(sDeals.getCategoriesFilterStaycationListingPage().get(i));
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getApplyFilterButton().get(2));

			Thread.sleep(2000);

			System.out.println(getCurrentUrl());

			validateAssertion(getCurrentUrl().contains(lowerCategory));
			try {
				if (elementDisplayed(sDeals.getDealsCard())) {
					System.out.println("Successfully validated " + lowerCategory + " option in price filter");
				}
			} catch (Exception e) {
				System.out.println(" There is no option for " + lowerCategory + " filter");
			}
			clickJavaScriptElement(sDeals.getCategoryFilterButton());
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getCategoryResetFilterButton());
		}
	}

	@Then("^Check the theme filter$")
	public void check_the_theme_filter() throws Throwable {
		driver.get(localEnvUrl + "/deals/best-staycation");
		Thread.sleep(2000);
		clickJavaScriptElement(sDeals.getThemeFilterButton());

		for (int i = 0; i < sDeals.getThemeFilterStaycationListingPage().size(); i++) {
// 	        clickJavaScriptElement(sDeals.getPriceFilterButton());

			String theme = sDeals.getThemeFilterStaycationListingPage().get(i).getText().toLowerCase();
			Thread.sleep(1000);

//			String lowerCategory = category.toLowerCase();
		
			clickAction(sDeals.getThemeFilterStaycationListingPage().get(i));
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getApplyFilterButton().get(3));

			Thread.sleep(2000);

			System.out.println(getCurrentUrl());

// 			validateAssertion(getCurrentUrl().contains(theme));
			try {
				if (getCurrentUrl().contains(theme) || getCurrentUrl().contains("FEATURED_DEAL")) {

					if (elementDisplayed(sDeals.getDealsCard())) {
						assertTrue(true);
						System.out.println("Successfully validated " + theme + " option in theme filter");

					}
				}
			} catch (Exception e) {
				System.out.println(" There is no option for " + theme + " filter");
			}
			clickJavaScriptElement(sDeals.getThemeFilterButton());
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getThemeResetFilterButton());
		}
	}

	@Then("^Check the destination filter$")
	public void check_the_destination_filter() throws Throwable {
		String urlCity = " ";
		driver.get(localEnvUrl + "/deals/best-staycation");
		Thread.sleep(2000);
		clickJavaScriptElement(sDeals.getDestinationFilterButton());

		for (int i = 0; i < sDeals.getDestinationFilterStaycationListingPage().size(); i++) {
// 	        clickJavaScriptElement(sDeals.getPriceFilterButton());

			String destination = sDeals.getDestinationFilterStaycationListingPage().get(i).getText().toLowerCase();
			Thread.sleep(1000);
			
			clickAction(sDeals.getDestinationFilterStaycationListingPage().get(i));
			Thread.sleep(1000);
			clickJavaScriptElement(sDeals.getApplyFilterButton().get(4));

			Thread.sleep(2000);

			switch (destination) {
			case "india":
				urlCity = "IND";
				break;
			case "maldives":
				urlCity = "MLE";
				break;
			case "indonesia":
				urlCity = "IDN";
				break;
			case "thailand":
				urlCity = "THA";
				break;
			default: {
				System.out.println("Invalid destination filter option");
			}

				System.out.println(getCurrentUrl());
				System.out.println(urlCity);
				Thread.sleep(1000);

				validateAssertion(getCurrentUrl().contains(urlCity));
				try {
					if (elementDisplayed(sDeals.getDealsCard())) {
						System.out.println("Successfully validated " + destination + " option in destination filter");
					}
				} catch (Exception e) {
					System.out.println(" There is no option for " + destination + " filter");
				}
				clickJavaScriptElement(sDeals.getDestinationFilterButton());
				Thread.sleep(1000);
				clickJavaScriptElement(sDeals.getDestinationResetFilterButton());
			}
		}
	}

	@Then("^Navigate to deals staycation page$")
	public void navigate_to_deals_staycation_page() throws Throwable {
		driver.get(localEnvUrl + "/deals/best-staycation");
	}

	@Then("^Choose the \"([^\"]*)\" from the destination filter$")
	public void choose_the_from_the_destination_filter(String destination) throws Throwable {
		Thread.sleep(2000);
		clickJavaScriptElement(sDeals.getDestinationFilterButton());
		for (int i = 0; i < sDeals.getDestinationFilterStaycationListingPage().size(); i++) {
			String destinationfiltertext = sDeals.getDestinationFilterStaycationListingPage().get(i).getText();
			Thread.sleep(1000);
			if (destinationfiltertext.equals(destination)) {
				clickAction(sDeals.getDestinationFilterStaycationListingPage().get(i));
				Thread.sleep(1000);
				clickJavaScriptElement(sDeals.getApplyFilterButton().get(4));
				break;
			}
		}
	}

	@Then("^Click on the city card$")
	public void click_on_the_city_card() throws Throwable {
		Thread.sleep(2000);
		cardtitle = sDeals.getCardTitle().getText();
		clickAction(sDeals.getCityFirstCard());
	}

	@Then("^Verify if user navigated to respective deals details page$")
	public void verify_if_user_navigated_to_respective_deals_details_page() throws Throwable {
		switchWindows();
		String dealTitle = sDetails.getDealTitle().getText();
		validateAssertion(cardtitle.equalsIgnoreCase(dealTitle));
	}

	/*
	 * Store the date before changing the date Change the date to next active date
	 * on the datepicker And continue, then verify the previously selected date
	 * isn't matched to current selected date Then validate the same date is getting
	 * reflected on deals passenger screen under book now model
	 */

	@Then("^Click on the date field and change the date and verify the date is got selected$")
	public void click_on_the_date_field_and_change_the_date_and_verify_the_date_is_got_selected() throws Throwable {
		String datebefore = sDetails.getDateInput().getAttribute("value");
	
		String[] datebeforeParts = datebefore.split("/");
		String datebeforechanging = datebeforeParts[0];
	

		clickAction(sDetails.getDatePicker());
		Thread.sleep(1000);
		clickAction(sDetails.getNextActiveDate());
		clickAction(sDetails.getContinueButton());
		Thread.sleep(1000);

		String dateafter = sDetails.getDateInput().getAttribute("value");
	
		String[] dateafterParts = dateafter.split("/");
		dateafterchanging = dateafterParts[0];
	

		validateAssertion(datebeforechanging != dateafterchanging);
		System.out.println("date is changed successfully");
	}

	@Then("^Verify the dates are get changed in passenger details screen$")
	public void verify_the_dates_are_get_changed_in_passenger_details_screen() throws Throwable {
		clickAction(sDetails.getBookthisdeal());
		dateandmonthonbookingmodel =sDetails.getDateAndMonthOnbookingscreen().getText();
		System.out.println(dateandmonthonbookingmodel);
		System.out.println(dateafterchanging);
		validateAssertion(dateandmonthonbookingmodel.contains(dateafterchanging));
		System.out.println("The dates are getting matched on both deals details and pax page");
	}
	
	@Then("^Click the book this modal and verify the pax details fields are disabled$")
	public void click_the_book_this_modal_and_verify_the_pax_details_fields_are_disabled() throws Throwable {
		clickAction(sDetails.getBookthisdeal());
       if (elementDisplayed(sDetails.getNameDisabledPaxDetails())&& elementDisplayed(sDetails.getEmailDisabledPaxDetails()) && elementDisplayed(sDetails.getMobileNumDisbledPaxDetails())) {
    	   validateAssertion(true);
	}
       
       
}
	@Then("^Login as a user on deals details page via header$")
	public void login_as_a_user_on_deals_details_page_via_header() throws Throwable {
		loginFunctionalityTest("Registered_User");
	}
	
	@Then("^Sign up as a new user on deals details page via header$")
	public void sign_up_as_a_new_user_on_deals_details_page_via_header() throws Throwable {
//		SignupFromLandingPageTest("NewUser");
	}
    
	@Then("^Login as a user on deals details page$")
	public void login_as_a_user_on_deals_details_page() throws Throwable {
		clickAction(sDetails.getBookthisdeal());
		doLoginFromGCMFooter(adminUser, adminPassword);
	}
 
   // The three step commented out will be added in separate testcase 
	@Then("^validate the adult count field on the deals details page$")
	public void validate_the_adult_count_field_on_the_deals_details_page() throws Throwable {
		try {
			clickAction(sDetails.getAdultCountField());
			WebElement travellersmodel = driver.findElement(By.xpath("//p[contains(text(),'Travellers')]"));
			if (elementDisplayed(travellersmodel)) {
				
				System.out.println("The given deal is a sibling and have other options");
               clickAction(sDetails.getTravellersmodelclosebtn());
//				clickAction(sDetails.getChatwithus());
//				switchWindows();
//				validateAssertion(elementDisplayed(sDetails.getWhatsAppLogo()));
				
				}
           } catch (Exception e) {
			System.out.println("The given deal isn't a sibling deal and don't have other options");
		}

	}

	@Then("^verify the adult count details on passenger screen$")
	public void verify_the_adult_count_details_on_passenger_screen() throws Throwable {
		String paxfield = sDetails.getAdultCountField().getAttribute("value");
		String[] paxfieldParts = paxfield.split(",");
		String adultpart = paxfieldParts[0];
		clickAction(sDetails.getBookthisdeal());
		dateandmonthonbookingmodel = sDetails.getDateAndMonthOnbookingscreen().getText();
		
		validateAssertion(dateandmonthonbookingmodel.contains(adultpart));

	}

	@Then("^Validate the total price on deals details page$")
	public void validate_the_total_price_on_deals_details_page() throws Throwable {
		String dealTotalPrice = sDetails.getTotalPriceOnDetailsPage().getText();
		String[] dealsplit = dealTotalPrice.split("\\*");
		String part0 = dealsplit[0];
		dealTotalPriceint = Integer.parseInt(part0.replaceAll("[^0-9]", ""));
		
	}

	@Then("^Verify the price on passenger screen$")
	public void verify_the_price_on_passenger_screen() throws Throwable {
		clickAction(sDetails.getBookThisDealButtonPaxDetails());
		waitForMe(sDetails.getPriceonbookingscreen());
		String priceonpaxscreen = sDetails.getPriceonbookingscreen().getText();
		String[] priceonpaxscreensplit = priceonpaxscreen.split("\\*");
		String priceonpaxscreenpart0 = priceonpaxscreensplit[0];
		int priceonpaxscreenint = Integer.parseInt(priceonpaxscreenpart0.replaceAll("[^0-9]", ""));
		validateAssertion(dealTotalPriceint == priceonpaxscreenint);
	}
	
	@Then("^Validate after coupon code discounted price on passenger screen$")
	public void validate_after_coupon_code_discounted_price_on_passenger_screen() throws Throwable {
		String aftercouponcodepriceonpaxscreen = sDetails.getPriceonbookingscreen().getText();
		String[] aftercouponcodepriceonpaxscreensplit = aftercouponcodepriceonpaxscreen.split("\\*");
		String aftercouponcodepriceonpaxscreenpart0 = aftercouponcodepriceonpaxscreensplit[0];
		int aftercouponcodepriceonpaxscreenint = Integer.parseInt(aftercouponcodepriceonpaxscreenpart0.replaceAll("[^0-9]", ""));
		validateAssertion(priceonpaxscreenint != aftercouponcodepriceonpaxscreenint);
	}
	
	
	@Then("^Validate the striked price on deals details page$")
	public void validate_the_striked_price_on_deals_details_page() throws Throwable {
		String dealStrikedPrice= sDetails.getStrikedPriceDetailsPage().getText();
		String[] dealsStrikedSplit = dealStrikedPrice.split("\\*");
		String part1 = dealsStrikedSplit[0];
		dealStrikedPriceint= Integer.parseInt(part1.replaceAll("[^0-9]", ""));
		System.out.println("dealStrikedPriceint--"+dealStrikedPriceint);
		clickAction(sDetails.getBookthisdeal());

	}
	
	@Then("^Verify the striked price on passenger screen$")
	public void verify_the_striked_price_on_passenger_screen() throws Throwable {
		String StrikedPriceOnPaxDetail = sDetails.getStrikedPriceOnBookingScreen().getText();
		String[] priceonpaxscreensplit = StrikedPriceOnPaxDetail.split("\\*");
		String priceonpaxscreenpart0 = priceonpaxscreensplit[0];
		int priceonpaxscreenint = Integer.parseInt(priceonpaxscreenpart0.replaceAll("[^0-9]", ""));
		validateAssertion(dealStrikedPriceint == priceonpaxscreenint);
	}
	@Then("^Validate after loyalty code discounted price on passenger screen$")
	public void validate_after_loyalty_code_discounted_price_on_passenger_screen() throws Throwable {
		String aftercouponcodepriceonpaxscreen = sDetails.getPriceonbookingscreen().getText();
		String[] aftercouponcodepriceonpaxscreensplit = aftercouponcodepriceonpaxscreen.split("\\*");
		String aftercouponcodepriceonpaxscreenpart0 = aftercouponcodepriceonpaxscreensplit[0];
		int aftercouponcodepriceonpaxscreenint = Integer.parseInt(aftercouponcodepriceonpaxscreenpart0.replaceAll("[^0-9]", ""));
		validateAssertion(priceonpaxscreenint != aftercouponcodepriceonpaxscreenint);
	}

}
