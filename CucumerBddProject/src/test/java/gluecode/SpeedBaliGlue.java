package gluecode;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;


public class SpeedBaliGlue extends Kernel {

	/**
	 * Verifying the Bali landing page is loaded as expected by the URL of that page
	 * bali-tour-packages
	 */
	

	@Then("^Verify that landing page is loaded as expected for Bali$")
	public void verify_that_landing_page_Bali_is_loaded_as_expected() throws Throwable {
		String regionUrlPattern = "bali-tour-packages";
		validateAssertion(getCurrentUrl().contains(regionUrlPattern));
	}
	
    /* Method name :enterDepartureCity()
     * Functionality : Gets the input for departure city and Clicks the city or other options accordingly with compliance with the Param
     * @Params : departFrom
     *  */

	@Then("^Enter the departure location as for bali \"([^\"]*)\"$")
	public void enterDepartureCity(String departFrom) throws InterruptedException {
		String depCode = "";

		if (departFrom.contentEquals("Outside India")) {
			depCode = "I’m departing from Outside India";
		} else if (departFrom.contentEquals("Flights Booked")) {
			depCode = "I have booked my flights already";
		} else {
			depCode = departureCities.get(departFrom);
		}
		if (elementDisplayed(sbaliLanding.getSbDepartureCity())) {
			clickJavaScriptElement(sbaliLanding.getSbDepartureCity());
		} else {
			clickAction(sbList.getListingGCMDepartureCity());
		}
		try {
			choose_city(depCode);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	/**
	 * This method is used to select the departure date for the bali There is no
	 * need to mention the date in feature file this method always selects the next
	 * month departure date. Need to handle dynamic Datepicker
	 */

	@Then("^Enter the departure date for bali$")
	public void enter_speedboat_departure_date() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, 200);");
		clickJavaScriptElement(sbLand.getSbDepartureDate());
		clickJavaScriptElement(sbLand.sbGoToNextMonth());
		clickJavaScriptElement(sbLand.sbChooseTravelDate());

	}

	/**
	 * Click action for search the packages for bali related packages in the landing
	 * page by using "search for packages CTA
	 */

	@Then("^Search for all available packages for bali$")
	public void search_available_packages_bali() throws Throwable {
		clickJavaScriptElement(sbaliLanding.getsBaliCheckDeals());

	}

	/**
	 * Verifying the listing page is loaded successfully by validating the "bali"
	 * breadcrumb is showing on the listing page.
	 */
	
	@Then("^Verify that valid results are displayed in listing page for Bali$")
	public void verify_results_in_listing_page_bali() throws Throwable {
		String parentWindow = switchWindows();
		if (getCurrentUrl().contains("/listing")) {
			waitForMe(sbList.getUnlockDeal());
			System.out.println("Successfully routed to listing page and finished costing");
			validate_String_Contains("Bali", sbaliListing.getsBaliText().getText());
		}
	}

	/** 
	 * Navigate to Bali landing page by searching the Bali region in the search box
	 */

	@Given("^Navigate to landing page for bali \"([^\"]*)\"$")
	public void navigate_to_landing_page_for_bali(String region) throws Throwable {
		Thread.sleep(2000);
//		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
//		Thread.sleep(2000);
		driver.get(localEnvUrl+"/customize");
		Thread.sleep(2000);
		typeText(cp.getlandingSearchBox(), region);
		Thread.sleep(2000);
		clickAction(cp.getregionSelection(), "Region selection");
		Thread.sleep(2000);

	}

	  /* Method name : enter_speedbali_group_type()
     * Functionality : With the parameter of Group type selects and proceeds the corresponding group in the landing page
     * @Params : region
     *  */

    @Then("^Enter the group type for bali as \"([^\"]*)\"$")
	public void enter_speedbali_group_type(String groupType) throws Throwable {
		System.out.println("Choosing group type " + groupType);
		clickJavaScriptElement(sbaliLanding.getSbPax());
		switch (groupType) {
		case "Couple":
			clickJavaScriptElement(sbLand.sbChooseCoupleGcm());
			save_gcm_config_Bali();
			break;
		case "Family":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			save_gcm_config_Bali();
			break;
		case "Friends":
			clickJavaScriptElement(sbLand.sbChooseFriendsGcm());
			save_gcm_config_Bali();
			break;
		case "Solo":
			clickAction(sbLand.sbChooseSoloGcm());
			save_gcm_config_Bali();
			break;
		default:
			System.out.println("Please make sure your case value");
		}

	}

	public void save_gcm_config_Bali() throws Throwable {
		if (elementDisplayed(sbLand.sbSaveRoomConfig())) {
			clickJavaScriptElement(sbLand.sbSaveRoomConfig());
		} else {
			System.out.println("Save config not visible. Moving with further steps");
		}
	}

	public void choose_city(String depCode) throws Throwable {
		try {

			clickJavaScriptElement(driver.findElement(By.xpath("//*[contains(text(),'" + depCode + "')]")));
		}

		catch (Exception ex) {
			clickAction(sbLand.sbSearchForCity());
			typeText(sbLand.sbSearchForCity(), depCode);
			clickAction(driver.findElement(By.xpath("//*[contains(text(),'" + depCode + "')]")));
		}

	}
	
	  /* Method name : choose_price_range_option()
     * Functionality : With the parameter of priceRange  selects and proceeds the corresponding budget range in the filter
     * @Params : region
     *  */

	@Then("^Choose price range per person as for Bali \"([^\"]*)\"$")
	public void choose_price_range_option(String priceRange) throws Throwable {
		switch (priceRange) {
		case "1to1.2lacs":
			clickJavaScriptElement(sbaliListing.getonetoOnedot2lakh());

			break;
		case "1.2to1.6lacs":
			clickJavaScriptElement(sbaliListing.getonedot2toOnedot6lakh());

			break;
		case "1.6to2.0lacs":
			clickJavaScriptElement(sbaliListing.getonedot6to2lakh());

			break;
		case "Above2lacs":
			clickJavaScriptElement(sbaliListing.getabove2Lakh());

			// List<String> priceList = Arrays.asList(priceRange.split("+"));
			// int i = 0;
			// for (i=0;i<priceList.size();i++) {
			// if(priceList.get(i) == "50to70k")
			// {clickAction(sbList.get50to70kPriceFilter());}
			// else if(priceList.get(i) == "70to80k")
			// {clickAction(sbList.get70to80kPriceFilter());}
			// else if(priceList.get(i) ==
			// "Above80k"){clickAction(sbList.getAbove80kPriceFilter());}
			// }
			break;
		default:
			System.out.println("Please make sure your case value");
		}
		clickJavaScriptElement(sbaliListing.getsbApplyFilter());

	}

	@Then("^Verify that results are shown for price range for bali \"([^\"]*)\"$")
	public void verify_price_filter_results(String priceRange) throws Throwable {
		String urlPrice = "";
		switch (priceRange) {
		case "1to2lacs":
			urlPrice = "100000to120000";
			break;
		case "1.2to1.6lacs":
			urlPrice = "120000to160000";
			break;
		case "1.6to2.0lacs":
			urlPrice = "160000to200000";
			break;
		case "Above2lacs":
			urlPrice = "200000to20000000";
			break;
		default:
			System.out.println("Please make sure your case value");
		}
		if (getCurrentUrl().contains("&price=" + urlPrice)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}

	@Then("^Click on the price filter for bali$")
	public void choose_price_range_filter() throws Throwable {
		clickAction(sbaliListing.getpriceFilter());
	}

	@Then("^Click on the star category filter for Bali$")
	public void choose_star_category_filter() throws Throwable {
		clickAction(sbaliListing.getStarFilter());
	}

	@And("^Choose star category for bali as \"([^\"]*)\"$")
	public void choose_star_category_option(String starCategory) throws Throwable {
		switch (starCategory) {
		case "4 Star":
			waitForMe(sbaliListing.getfourStarFilter());
			clickAction(sbaliListing.getfourStarFilter());
			break;
		case "5 Star":
			waitForMe(sbaliListing.getfiveStarFilter());
			clickAction(sbaliListing.getfiveStarFilter());
			break;
		case "4 Star+5 Star":
			List<String> starList = Arrays.asList(starCategory.split(","));
			int i = 0;
			for (i = 0; i < starList.size(); i++) {
				if (starList.get(i) == "3 Star") {
		//			clickAction(sbList.get3StarFilter());
				} else if (starList.get(i) == "4 Star") {
		//			clickAction(sbList.get4StarFilter());
				} else if (starList.get(i) == "5 Star") {
		//			clickAction(sbList.get5StarFilter());
				}
			}
			break;
		default:
			System.out.println("Please make sure your case value");
		}
		clickAction(sbaliListing.getstarApply());
	}

	@Then("^Click on the villa type filter for bali$")
	public void choose_villa_type_filter() throws Throwable {
		clickAction(sbaliListing.getVillaFilter());
	}

	@And("^Choose villa type for bali as \"([^\"]*)\"$")
	public void choose_villa_type_option(String villaType) throws Throwable {
		switch (villaType) {
		case "Private Pool Villa":
			waitForMe(sbaliListing.getPrivateVilla());
			clickAction(sbaliListing.getPrivateVilla());
			break;
		case "Garden View":
			waitForMe(sbaliListing.getGardenView());
			clickAction(sbaliListing.getGardenView());
			break;
		case "Deluxe Room":
			waitForMe(sbaliListing.getDeluxeRoom());
			clickAction(sbaliListing.getDeluxeRoom());
			break;
		default:
			System.out.println("Please make sure your case value");

		}
		waitForMe(sbaliListing.getVillaTypeApply());
		clickAction(sbaliListing.getVillaTypeApply());
	}

	@Then("^Verify that results are shown for villa type for Bali \"([^\"]*)\"$")
	public void verify_villa_type_results(String villaType) throws Throwable {
		String urlVilla = "";
		switch (villaType) {
		case "Private Pool Villa":
			urlVilla = "Private";
			break;
		case "Garden View":
			urlVilla = "Garden";
			break;
		case "Deluxe Room":
			urlVilla = "Deluxe";
			break;
		default:
			System.out.println("Please make sure your case value");

		}
		if (getCurrentUrl().contains("&villa=" + urlVilla)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}

	@Then("^Verify that results are shown for villa type for Bali on refresh \"([^\"]*)\"$")
	public void verify_villa_type_results_on_refresh(String villaType) throws Throwable {
		String urlVilla = "";
		switch (villaType) {
		case "Private Pool Villa":
			urlVilla = "Private";
			break;
		case "Garden View":
			urlVilla = "Garden";
			break;
		case "Deluxe Room":
			urlVilla = "Deluxe";
			break;
		default:
			System.out.println("Please make sure your case value");

		}
		pageRefresh();
		if (getCurrentUrl().contains("&villa=" + urlVilla)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}

	@Then("^Click the Bali Crums$")
	public void click_bali_crums() throws Throwable {
		clickAction(sbaliListing.getsBaliText());
		Thread.sleep(3000);
	}

	@Then("^Click the Unlock Deal button$")
	public void click_unlock_deal() throws Throwable {
		waitForMe(sbList.getUnlockDeal());
		clickAction(sbList.getUnlockDeal());
		System.out.println("Unlock Deal button is present and successfully clicked");
		waitForMe(sbaliListing.getsBaliText());
		validate_String_Contains("Bali", sbaliListing.getsBaliText().getText());

	}

	@Then("^Verify the appearance of inclusions page$")
	public void verify_results_in_listing_page() throws Throwable {
		String parentWindow = switchWindows();
		waitForMe(sbaliListing.getBooknowButton());
		if (getCurrentUrl().contains("/inclusions")) {
			System.out.println("Successfully routed to listing page and finished costing");
		}
	}

	@Then("^Click on Hotel card$")
	public void click_hotel_cards() throws Throwable {
		waitForMe(sbList.getUnlockDeal());
		clickAction(sbaliListing.getHotelCard());

	}

	@Then("^Login from signup modal for Speedbali inclusions Page$")
	public void login_from_signup() throws Throwable {
		waitForMe(sbaliListing.getAlreadyRegistered());
		clickAction(sbaliListing.getAlreadyRegistered());
		loginFunctionalityGCM("Registered_User");

	}
	
	
	
	

	/**
	 * This method is to select the duration of stay The default stay option for
	 * bali is 5 nights The minimum stay option is 4 nights and the maximum stay
	 * option is 8 nights In this method if the user chooses the duration of stay
	 * less than 6 nights we're selecting the respecting nights directly with the
	 * help of switch opern. If duration of stay greater than 6 nights [i.e.,7 & 8 ]
	 * the user should choose that nights by using add symbol so for that we're
	 * using for loop and selecting the day option
	 */

	@Then("^Enter the duration of stay for bali as \"([^\"]*)\"$")
	public void enter_the_duration_of_stay_for_bali_as(String duration) throws Throwable {
		int nights = Integer.parseInt(duration);
		clickJavaScriptElement(sbLand.getSbDuration());
		if (nights > 6) {
			for (int i = 1; i <= 5; i++) {
				clickJavaScriptElement(sbLand.sbAddCustomDuration());
				String durationText = sbLand.getSbDuration().getAttribute("value");
				if (durationText.contains(duration)) {
					break;
				} else {
					continue;
				}
			}
		} else {
			switch (duration) {
			case "4":
				clickJavaScriptElement(sbaliLanding.sbChoose4Night());
				break;
			case "5":
				clickJavaScriptElement(sbaliLanding.sbChoose5Nights());
				break;
			case "6":
				clickJavaScriptElement(sbaliLanding.sbChoose6Nights());
				break;
			default:
				System.out.println("Please make sure your case value");
			}
		}

	}

	/**
	 * This method is to select Passenger details User able to directly selects the
	 * couple and solo directly If user chooses family or
	 */
	
	@Then("^Enter the room config with adult and child count for bali as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_the_room_config_with_adult_and_child_count_for_bali_as(String adultCount, String childCount,
			String childAge) throws Throwable {
		int children = Integer.parseInt(childCount);
		int childrenAge = Integer.parseInt(childAge);
		clickJavaScriptElement(sbaliLanding.getSbPax());
		switch (adultCount) {
		case "1":
			clickJavaScriptElement(sbLand.sbChooseSoloGcm());
			break;
		case "2":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			choose_child(childCount, childAge);
			break;
		case "3":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			for (int i = 1; i <= 1; i++) {
				clickJavaScriptElement(sbLand.sbAddAdultToPax());
			}
			choose_child(childCount, childAge);
			break;
		case "4":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			for (int i = 1; i <= 2; i++) {
				clickJavaScriptElement(sbLand.sbAddAdultToPax());
			}
			choose_child(childCount, childAge);
			break;
		case "5":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			for (int i = 1; i <= 3; i++) {
				clickJavaScriptElement(sbLand.sbAddAdultToPax());
			}
			choose_child(childCount, childAge);
			break;
		default:
			System.out.println("Please make sure your case value");
		}

	}

	public void choose_child(String childCount, String childAge) throws Throwable {
		int children = Integer.parseInt(childCount);
		int childrenAge = Integer.parseInt(childAge);
		if (children == 0 && childrenAge == 0) {
			clickJavaScriptElement(sbLand.sbChooseCoupleGcm());
		}
		if (children >= 1) {
			for (int i = 0; i < children; i++) {
				clickJavaScriptElement(sbLand.sbAddChildToPax());
			}
			selectDropDownUsingValue(sbaliLanding.sbChildAge(), childAge);
			clickJavaScriptElement(sbaliLanding.sbRoomDoneOptn());

		}

	}

	@Then("^Verify by clicking on view all deals GCM should popup$")
	public void verify_by_clicking_on_view_all_deals_GCM_should_popup() throws Throwable {
		waitForMe(sbaliLanding.getViewAllDeals());
		clickJavaScriptElement(sbaliLanding.getViewAllDeals());
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[text()='What is your travel plan like?']/../..//following::*[@placeholder='Departing from']"))
				.sendKeys("");
		fillMandatoryInfoInGCM();
		pollingWait(sbaliListing.getUnlockDeal(), 100);
		validateAssertion(elementDisplayed(sbaliListing.getUnlockDeal()));

	}

	@Then("^verify if the user able to view the itinerary$")
	public void verify_if_the_user_able_to_view_the_itinerary() throws Throwable {

		clickJavaScriptElement(sbaliListing.getUnlockDeal());
		if (elementDisplayed(sbaliListing.getAlreadyRegistered())) {
			login_from_signup();
		}
		switchWindows();
		waitForMe(inclusion.getBookNow());
		validateAssertion(elementDisplayed(inclusion.getBookNow()));
	}

	@Then("^click the packages on home page and verify the itinerary page is loading \"([^\"]*)\"$")
	public void click_the_packages_on_home_page_and_verify_the_itinerary_page_is_loading(String packages)
			throws Throwable {
		switch (packages) {
		case "honeymoon":
			scrolltoElement(sbaliLanding.getHoneymoonScroll());
			clickJavaScriptElement(sbaliLanding.getHoneymoonPackage());
			validation_on_itinerary();
			break;
		case "privatepoolvilla":
			scrolltoElement(sbaliLanding.getPrivatePoolVillaScroll());
			clickJavaScriptElement(sbaliLanding.getPrivatePoolVilla());
			validation_on_itinerary();
			break;
		case "family":
			scrolltoElement(sbaliLanding.getFamilyScroll());
			clickJavaScriptElement(sbaliLanding.getFamilyPackage());
			validation_on_itinerary();
			break;
		case "adventure":
			scrolltoElement(sbaliLanding.getAdventureScroll());
			Thread.sleep(1000);
			System.out.println(sbaliLanding.getAdventurePackage().isDisplayed());
			clickJavaScriptElement(sbaliLanding.getAdventurePackage());
			validation_on_itinerary();
			break;
		default:
			System.out.println("Please make sure your case value");
		}

	}

	/* Method name :validation_on_itinerary()
	 * Functionality : Verifies the presence of pop up displayed and proceed clicking it to Price CTA page
	 * @Params : null
	 *  */

	public void validation_on_itinerary() throws Exception {
		waitForMe(ip.getgotItPopup());

		if (elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());

		}
		validateAssertion(elementDisplayed(sbaliLanding.getPriceCTA()));
	}

	/* Method name :verify_if_user_able_to_view_the_GCM_while_clicking_on_elements_in_the_itinerary_page()
	 * Functionality : Verifies the GCM page is undisturbed while clicking on other elements of Webpage
	 * @Params : null
	 *  */

	@Then("^Verify if user able to view the GCM while clicking on elements in the itinerary page \"([^\"]*)\"$")
	public void verify_if_user_able_to_view_the_GCM_while_clicking_on_elements_in_the_itinerary_page(String elements)
			throws Throwable {
		driver.findElement(By.xpath("//*[contains(text(),'" + elements + "')]")).click();
		assertTrue(elementDisplayed(sbaliLanding.getGCMModal()));
	}
	
	/* Method name :validate_user_able_to_cost_the_itinerary()
	 * Functionality :Enables the costing and verifies the Presence of Costing page and related content                    
	 * @Params : null
	 *  */

	@Then("^validate user able to cost the itinerary$")
	public void validate_user_able_to_cost_the_itinerary() throws Throwable {

		// clickJavaScriptElement(sbLanding.getGCMModal());

		sbaliLanding.getDeparingFrom().sendKeys("");
		fillMandatoryInfoInGCM();
		if (elementDisplayed(sbaliListing.getAlreadyRegistered())) {
			login_from_signup();
		}
		switchWindows();
		waitForMe(inclusion.getBookNow());
		validateAssertion(elementDisplayed(inclusion.getBookNow()));
	}

	/* Method name :verify_that_valid_results_are_displayed_in_listing_page_for_speedbali()
	 * Functionality :Validates the Adult and child count are displayed in compliance with the passed params                      
	 * @Params : adultCount,childCount
	 *  */

	@Then("^Verify that valid results are displayed in listing page for speedbali \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_that_valid_results_are_displayed_in_listing_page_for_speedbali(String adultCount,
			String childCount) throws Throwable {
		String adult = adultCount + " adults";
		String child = childCount + " child";
		clickAction(sbaliListing.getGCMFilter());
		String text = getAttribute(sbaliListing.getGCMPax(), "value");
		validateAssertion(text.contains(adult) && text.contains(child));
	}

	/* Method name :add_rooms_to_the_bali_itinerary_with_group_type_and_additional_room_count_as()
	 * Functionality : Enters room, group details, room count in the landing page of bali                         
	 * @Params : groupType,roomCount
	 *  */

	@Then("^Add rooms to the bali itinerary with group type and additional room count as \"([^\"]*)\",\"([^\"]*)\"$")
	public void add_rooms_to_the_bali_itinerary_with_group_type_and_additional_room_count_as(String groupType,
			String roomCount) throws Throwable {
		int rooms = Integer.parseInt(roomCount);
		clickJavaScriptElement(sbLand.getSbPax());
		switch (groupType) {
		case "Couple":
			clickJavaScriptElement(sbLand.sbChooseCoupleGcm());
			break;
		case "Family":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			break;
		case "Friends":
			clickJavaScriptElement(sbLand.sbChooseFriendsGcm());
			break;
		case "Solo":
			clickJavaScriptElement(sbLand.sbChooseSoloGcm());
			break;
		default:
			System.out.println("Please make sure your case value");
		}
		if (rooms > 1) {
			for (int i = 1; i <= 6; i++) {
				clickJavaScriptElement(sbLand.sbAddNewRoom());
				List<WebElement> roomsAdded = new ArrayList<WebElement>();
				roomsAdded = driver.findElements(
						By.xpath("//div[contains(@class,'gcm-room-config')]//*/span[contains(text(),'Room')]"));
				if (roomsAdded.size() == rooms) {
					break;
				} else {
					continue;
				}

			}
			clickJavaScriptElement(sbaliLanding.sbRoomDoneOptn());
			String room = roomCount + " rooms";
			String text = getAttribute(sbaliLanding.getSbPax(), "value");
			validateAssertion(text.contains(room));
		}

	}

	/* Method name :click_on_the_cities_category_filter_for_Bali()
	 * Functionality : Verifies the presence of City filter and clicks it                             
	 * @Params : city
	 *  */	

	@Then("^Click on the cities category filter for Bali$")
	public void click_on_the_cities_category_filter_for_Bali() throws Throwable {
		clickAction(sbaliListing.getCityFilter());
	}

	/* Method name :choose_cities_category_for_bali_as()
	 * Functionality : Clicks the respective city filter option in compliance with the Parameter
	 *                              
	 * @Params : city
	 *  */	

	@Then("^Choose cities category for bali as \"([^\"]*)\"$")
	public void choose_cities_category_for_bali_as(String citiesCategory) throws Throwable {

		switch (citiesCategory) {
		case "Kuta + Ubud":
			clickJavaScriptElement(sbaliListing.getKutaAndUbud());
			break;
		case "Seminyak + Ubud":
			clickJavaScriptElement(sbaliListing.getNusaduaAndUbud());
			break;
		case "Nusa Dua + Ubud":
			clickJavaScriptElement(sbaliListing.getSeminyakAndUbud());
			break;
		default:
			System.out.println("Please make sure your case value");
		}

		waitForMe(sbaliListing.getcityApplyFilter());
		clickAction(sbaliListing.getcityApplyFilter());

	}

	/* Method name :verify_no_results_message()
	 * Functionality : Validates the presence of error text when there are no results for the specific filter
	 *                              
	 * @Params : null
	 *  */	

	@Then("^Verify the no results message$")
	public void verify_no_results_message() throws Throwable {
		validate_String_Contains(sbaliListing.getNoResultsMessage().getText(), "We’re sorry");

	}
	
	/* Method name :reset_villa_filter()
	 * Functionality : Verifies the presence of reset button inside Villa filter panel and clicks it
	 *                 Verifies the presence of apply button inside Villa filter panel and clicks it                 
	 * @Params : null
	 *  */

	@Then("^Reset villaType filter$")
	public void reset_villa_filter() throws Throwable {

		waitForMe(sbaliListing.getVillaReset());
		clickAction(sbaliListing.getVillaReset());
		waitForMe(sbaliListing.getVillaTypeApply());
		clickAction(sbaliListing.getVillaTypeApply());
	}

	/* Method name :reset_star_filter()
	 * Functionality : Verifies the presence of star ratings in the filter and clicks the star value in compliance with the parameter                 
	 * @Params : starCategory
	 *  */

	@Then("^Reset starCateory filter \"([^\"]*)\"$")
	public void reset_star_filter(String starCategory) throws Throwable {

		switch (starCategory) {
		case "4 Star":
			waitForMe(sbaliListing.getFourstarOnReset());
			clickAction(sbaliListing.getFourstarOnReset());
			waitForMe(sbaliListing.getStarReset());
			clickAction(sbaliListing.getStarReset());
			break;
		case "5 Star":
			waitForMe(sbaliListing.getFivestarOnReset());
			clickAction(sbaliListing.getFivestarOnReset());
		default:
			System.out.println("Please make sure your case value");

		}
		clickAction(sbaliListing.getstarApply());

	}

	/* Method name :reset_pricerange_filter()
	 * Functionality : Verifies the presence of Reset button inside Price filter panel and clicks it
	 *                 Verifies the presence of Apply button inside the price filter panel and clicks it
	 *                 
	 * @Params : null
	 *  */

	@Then("^Reset priceRange filter$")
	public void reset_pricerange_filter() throws Throwable {

		waitForMe(sbaliListing.getPriceReset());
		clickAction(sbaliListing.getPriceReset());
		waitForMe(sbaliListing.getsbApplyFilter());
		clickJavaScriptElement(sbaliListing.getsbApplyFilter());

	}

	/* Method name :click_hotels_filter()
	 * Functionality : Verifies the presence of hotels filter and clicks it enabling the user tho select an option from the filter
	 *                 
	 * @Params : null
	 *  */

	@And("^Click the Hotels Filter$")
	public void click_hotels_filter() throws Throwable {
		waitForMe(sbaliListing.getHotelsFilter());
		clickAction(sbaliListing.getHotelsFilter());

	}

	/* Method name :select_hotel()
	 * Functionality : Selects the desired hotel in the list
	 *                 
	 * @Params : Hotel
	 *  */

	@And("^Select the Hotel \"([^\"]*)\"$")
	public void select_hotel(String hotel) throws Throwable {
		String hotelList = "//span[contains(text(),'" + hotel + "')]";
		System.out.println(hotelList);
		WebElement test = driver.findElement(By.xpath(hotelList));

//	clickJavaScriptElement(test);

		waitForMe(driver.findElement(By.xpath("//span[contains(text(),'" + hotel + "')]")));
		clickAction(driver.findElement(By.xpath("//span[contains(text(),'" + hotel + "')]")));
	}

	/* Method name :complete_booking()
	 * Functionality : verifies the Presence of Book now button and clicks it
	 *                 verifies the presence of Continue to book button and clicks it
	 * @Params : null
	 *  */

@And("^Complete the booking as User$")
public void complete_booking() throws Throwable {
	
	waitForMe(booingReview.getbookNowButton());
	clickAction(booingReview.getbookNowButton());
	waitForMe(booingReview.getContinueToBooking());
	clickAction(booingReview.getContinueToBooking());
	
	
}

/* Method name :payment_completion() 
 * Functionality : verifies the Presence of Make,Next Payment button and clicks it
 * @Params : null
 *  */

@Then("^Complete the payments$")
public void payment_completion() throws Throwable {
	waitForMe(booingReview.getNextMakePayment());
	clickAction(booingReview.getNextMakePayment());

}

	
	@Then("^Validate that valid results are displaying for cities selected \"([^\"]*)\"$")
	public void validate_that_valid_results_are_displaying_for_cities_selected(String citiesCategory) throws Throwable {
		String cities = citiesCategory;
		String[] citiesSplit = cities.split(" + ");
		String firstCity = citiesSplit[0];
		String secondCity = citiesSplit[1];
		System.out.println("firstCity" + firstCity);
		System.out.println("secondCity" + secondCity);

		String inclusionFirstCity = sbaliListing.getFirstHotelHeader().getText();
		String inclusionSecondCity = sbaliListing.getSecondHotelHeader().getText();
		validateAssertion(inclusionFirstCity.contains(firstCity) && inclusionSecondCity.contains(secondCity));

	}

}
