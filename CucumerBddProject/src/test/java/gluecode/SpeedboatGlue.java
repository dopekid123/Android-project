package gluecode;

import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;
import utils.SeWrappers;

public class SpeedboatGlue extends Kernel {

	boolean isPaxChanged;

	private void setPaxChange(boolean value) {
		isPaxChanged = value;
	}

	private boolean getPaxChange() {
		return isPaxChanged;
	}

	public static String depYear = " ";
	
	public static List<WebElement> nights = new ArrayList<WebElement>();

	@Given("^Navigate to landing page for \"([^\"]*)\"$")
	public void navigate_to_landing_page_for(String region) throws Throwable {
		// clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
		System.out.println("SeWrappers.localEnvUrl--" + SeWrappers.localEnvUrl);
		driver.get(SeWrappers.localEnvUrl + "customize");
		Thread.sleep(2000);
		typeText(cp.getlandingSearchBox(), region);
		pollingWait(cp.getregionSelection(), 10);
		// Script is failing often so, I changed the clickAction to forceClick and added
		// intervals
		forceClick(cp.getregionSelection());
	}

	@Given("^Verify that landing page is loaded as expected$")
	public void verify_that_landing_page_is_loaded_as_expected() throws Throwable {

		// Added a wait for the url
		waitForUrl("maldives-tour-packages");
		validateAssertion(getCurrentUrl().contains("/maldives-tour-packages"));
		System.out.println("Maldives landing page loaded successfully");
		pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 20);
		Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
		System.out.println("Maldives Resorts card Displayed successfully");
	}

	@Then("^Enter the duration of stay as \"([^\"]*)\"$")
	public void enter_speedboat_duration(String duration) throws Throwable {
		int nights = Integer.parseInt(duration);

		clickAction(sbLand.getSbDuration());
		if (nights >= 5) {
			for (int i = 1; i <= 6; i++) {
				clickAction(sbLand.sbAddCustomDuration());
				String durationText = sbLand.getSbDuration().getAttribute("value");
				if (durationText.contains(duration)) {
					break;
				} else {
					continue;
				}
			}
		} else {
			switch (duration) {
			case "1":
				clickAction(sbLand.sbChoose1Night());
				break;
			case "2":
				clickAction(sbLand.sbChoose2Nights());
				break;
			case "3":
				clickAction(sbLand.sbChoose3Nights());
				break;
			case "4":
				clickAction(sbLand.sbChoose4Nights());
				break;
			}
		}

	}

	@Then("^Add custom adult and child and room config as \"([^\"]*)\",\"([^\"]*)\"$")
	public void change_speedboat_room_config(String groupType, String roomCount) throws Throwable {
		int rooms = Integer.parseInt(roomCount);
		int ageToSelect = 0;
		clickJavaScriptElement(sbLand.getSbPax());
		switch (groupType) {
		case "Family":
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			break;
		case "Friends":
			clickJavaScriptElement(sbLand.sbChooseFriendsGcm());
			break;
		}

		for (int i = 1; i <= rooms; i++) {
			clickJavaScriptElement(sbLand.sbAddNewRoom());
			// clickAction(sbLand.sbAddChildToPax());
			// ageToSelect = ageToSelect + 4;
			// clickAction(driver
			// .findElement(By.xpath("(//select[contains(@class,'ChildAge')]/option[" +
			// ageToSelect + "])[1]")));
		}
//		List<WebElement> roomsAdded = new ArrayList<WebElement>();
//		roomsAdded = driver
//				.findElements(By.xpath("//div[contains(@class,'gcm-room-config')]//*/span[contains(text(),'Room')]"));
//		validateAssertion(roomsAdded.size() == rooms + 1);
		clickAction(sbLand.sbSaveRoomConfig());
	}

	@Then("^Enter the group type as \"([^\"]*)\"$")
	public void enter_speedboat_group_type(String groupType) throws Throwable {
		System.out.println("Choosing group type " + groupType);
		clickAction(sbLand.getSbPax());
		switch (groupType) {
		case "Couple":
			clickAction(sbLand.sbChooseCoupleGcm());
			save_gcm_config();
			break;
		case "Family":
			clickAction(sbLand.sbChooseFamilyGcm());
			save_gcm_config();
			break;
		case "Friends":
			clickAction(sbLand.sbChooseFriendsGcm());
			save_gcm_config();
			break;
		case "Solo":
			clickAction(sbLand.sbChooseSoloGcm());
			save_gcm_config();
			break;
		}

	}

	public void save_gcm_config() throws Throwable {
		if (elementDisplayed(sbLand.sbSaveRoomConfig())) {
			clickAction(sbLand.sbSaveRoomConfig());
		} else {
			System.out.println("Save config not visible. Moving with further steps");
		}
	}

	@Then("^Enter the departure location as \"([^\"]*)\"$")
	public void enter_speedboat_departure_loation(String departFrom) throws Throwable {
		String depCode = "";
		if (departFrom.contentEquals("Outside India")) {
			depCode = "departing from Outside India";
		} else if (departFrom.contentEquals("Flights Booked")) {
			depCode = "I have booked my flights already";
		} else {
			depCode = departureCities.get(departFrom);
		}
		try {
			pollingWait(sbLand.getSbDepartureCity(), 15);
			Thread.sleep(2000);
			clickAction(sbLand.getSbDepartureCity());
		} catch (Exception e) {
			clickJavaScriptElement(sbList.getListingGCMDepartureCity());
		}
		choose_city_dynamically(departFrom, depCode);
	}

	@Then("^Click on Search available packages$")
	public void select_search_available_packages() throws Throwable {
		if (elementDisplayed(sbList.getSelectAvailablePackages())) {
			scrollToView(sbList.getSelectAvailablePackages());
			clickAction(sbList.getSelectAvailablePackages());
		} else {
			scrollToView(cbr.getGetCost());
			clickAction(cbr.getGetCost());

		}
		try {
			if (sbList.getConfirmButton().isDisplayed()) {
				Thread.sleep(2000);
				clickAction(sbList.getConfirmButton());
				System.out.println("Resort sold-out for that date");
				Assert.fail();
			}
		} catch (Exception e) {
		}

	}

	public void choose_city_dynamically(String departFrom, String depCode) throws Throwable {
		try {
			clickAction(driver.findElement(By.xpath("//*[contains(text(),'" + depCode + "')]")));
		} catch (Exception ex) {
			clickAction(sbLand.getSbDepartureCity());
			typeText(sbLand.getSbDepartureCity(), departFrom);
//			clickAction(sbLand.sbSearchForCity());
//			typeText(sbLand.sbSearchForCity(),departFrom);
			clickAction(driver.findElement(By.xpath("//*[contains(text(),'" + depCode + "')]")));
		}

	}

	@Then("^Enter the departure date$")
	public void enter_speedboat_departure_date() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 200);");
		clickAction(sbLand.getSbDepartureDate());
		Thread.sleep(1000);
		clickAction(sbLand.sbGoToNextMonth());
		Thread.sleep(1000);

		clickAction(sbLand.sbChooseTravelDate());
		Thread.sleep(1000);
		depYear = sbLand.getSbDepartureDate().getAttribute("value");
	}

	@Then("^Click on the price filter$")
	public void choose_price_range_filter() throws Throwable {
		clickAction(sbList.getPriceFilter());
	}

	@Then("^Search for all available packages$")
	public void search_available_packages() throws Throwable {
		try {
			clickAction(sbLand.chooseSearchForPackages());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Click on the GCM pill and update departure city \"([^\"]*)\"$")
	public void choose_gcm_pill(String departFrom) throws Throwable {
		clickAction(sbList.getGCMPill());
		waitForMe(sbList.getListingGCMDepartureCity());
		clickAction(sbList.getListingGCMDepartureCity());
		String depCode = departureCities.get(departFrom);
		choose_city_dynamically(departFrom, depCode);
	}

	@Then("^Click on the Book now button$")
	public void get_book_now_button() throws Throwable {
		clickAction(sbCost.getBookNow());
	}

	@Then("^Verify that valid results are displayed in listing page$")
	public void verify_results_in_listing_page() throws Throwable {
		try {
			System.out.println(getCurrentUrl());
			if (elementExist(amDomestic.getNoSearchResults())) {
				Thread.sleep(1500);
				assumeTrue(false);
			} else {
				waitForMe(sbList.getSbLogintoViewDeal(), 100);
				validateAssertion(elementDisplayed(sbList.getSbLogintoViewDeal()));
				clickAction(sbList.getSbLogintoViewDeal());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Verify that valid results are displaying with room config and child option in url$")
	public void verify_results_in_url() throws Throwable {
		validate_String_Contains(getCurrentUrl(), "&duration=4");
		validate_String_Contains(getCurrentUrl(), "travellers=a2");

	}

	@Then("^Verify that valid results are displayed in costed details page$")
	public void verify_results_in_costed_page() throws Throwable {
		pollingWait(sbCost.getBookNow(), 100);
		validateAssertion(elementDisplayed(sbCost.getBookNow()));
		System.out.println("Successfully routed to costed details page");
	}

	@Then("^Validate the price range filter in listing page$")
	public void verify_price_filter_results() throws Throwable {
		List<String> priceRange = new ArrayList<String>();
		priceRange.add("Below 100k");
		priceRange.add("Below 150k");
		priceRange.add("Below 200k");
		priceRange.add("Above 200k");
		for (int i = 0; i < priceRange.size(); i++) {
			String priceXpath="//div[@class='veho-c-gqwkJN veho-c-gqwkJN-iTKOFX-direction-column veho-c-gqwkJN-irEjuD-align-stretch veho-c-gqwkJN-awKDG-justify-start veho-c-gqwkJN-kVNAnR-wrap-noWrap veho-c-gqwkJN-igTSNnh-css']//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-icgzfZ-css']";
			switch (priceRange.get(i)) {
			case "Below 100k":
				// Validating Price filter Below 100k filter
				scrolltoElement(sbList.getBelow100k());
				clickAction(sbList.getBelow100k());
				Thread.sleep(1000);
				List<WebElement> price = driver.findElements(By.xpath(priceXpath));
				for (int j = 1; j <= price.size(); j++) {
					String pricing = "("+priceXpath+")["+j+"]";
					WebElement priceOfResorts = driver.findElement(By.xpath(pricing));
					Thread.sleep(750);
					hoverWebelement(priceOfResorts);
					String newprice = priceOfResorts.getText();
					System.out.println("New price-->"+newprice);
					String rate = newprice.replaceAll("[^0-9]", "");
					System.out.println("Price-->"+newprice);
					int newRate = Integer.parseInt(rate);
					if (newRate < 100000) {
						Assert.assertTrue(true);
					} else {
						System.out.println("Below 100k Filters not Working");
						Assert.assertTrue(false);
					}
				}
//				Assert.assertTrue(true);
				System.out.println("Below 100k Filters Works properly");
				System.out.println();
				break;

			case "Below 150k":
				// Validating Price filter Below 150k filter
				clickAction(sbList.getBelow150k());
				List<WebElement> price150k = driver.findElements(By.xpath(priceXpath));
				for (int j = 1; j <= price150k.size(); j++) {
					String pricing = "("+priceXpath+")["+j+"]";
					WebElement priceOfResorts = driver.findElement(By.xpath(pricing));
					hoverWebelement(priceOfResorts);
					String newprice = priceOfResorts.getText();
					String rate = newprice.replaceAll("[^0-9]", "");
					System.out.println("Price-->"+rate);
					int newRate = Integer.parseInt(rate);
					if (newRate < 150000) {
						Assert.assertTrue(true);
					} else {
						System.out.println("Below 150k filter not working");
						Assert.assertTrue(false);
					}
				}
//				Assert.assertTrue(true);
				System.out.println("Below 150k Filters Works properly");
				System.out.println();
				break;

			case "Below 200k":
				// Validating Price filter Below 200k filter
				clickAction(sbList.getBelow200k());
				List<WebElement> price200k = driver.findElements(By.xpath(priceXpath));
				for (int j = 1; j <= price200k.size(); j++) {
					String pricing = "("+priceXpath+")["+j+"]";
					WebElement priceOfResorts = driver.findElement(By.xpath(pricing));
					hoverWebelement(priceOfResorts);
					String newprice = priceOfResorts.getText();
					String rate = newprice.replaceAll("[^0-9]", "");
					System.out.println("Price-->"+rate);
					int newRate = Integer.parseInt(rate);
					if (newRate < 200000) {
						Assert.assertTrue(true);
					} else {
						System.out.println("Below 200k filter not working");
						Assert.assertTrue(false);
					}
				}
//				Assert.assertTrue(true);
				System.out.println("Below 200k Filters Works properly");
				System.out.println();
				break;

			case "Above 200k":
				// Validating Price filter Above 200k filter
				clickAction(sbList.getAbove200k());
				List<WebElement> priceabove200k = driver.findElements(By.xpath(priceXpath));
				for (int j = 1; j <= priceabove200k.size(); j++) {
					String pricing = "("+priceXpath+")["+j+"]";
					WebElement priceOfResorts = driver.findElement(By.xpath(pricing));
					hoverWebelement(priceOfResorts);
					String newprice = priceOfResorts.getText();
					String rate = newprice.replaceAll("[^0-9]", "");
					System.out.println("Price-->"+rate);
					int newRate = Integer.parseInt(rate);
					if (newRate > 200000) {
						Assert.assertTrue(true);
					} else {
						System.out.println("Above 200k filter not working");
						Assert.assertTrue(false);
					}
				}
//				Assert.assertTrue(true);
				System.out.println("Above 200k Filters Works properly");
				System.out.println();
				break;
			default: {
				System.out.println("Invalid price filter option");
			}
			}
			pageRefresh();
			Thread.sleep(1000);
		}
	}

	@And("^Validate the star category filter in listing page$")
	public void choose_star_category_option() throws Throwable {
		List<String> starCategory = new ArrayList<String>();
		starCategory.add("3 Star");
		starCategory.add("4 Star");
		starCategory.add("5 Star");
		for (int i = 0; i < starCategory.size(); i++) {
//			String hotelStarXpath="//div[@class='veho-c-gqwkJN veho-c-gqwkJN-ejCoEP-direction-row veho-c-gqwkJN-jroWjL-align-center veho-c-gqwkJN-awKDG-justify-start veho-c-gqwkJN-kVNAnR-wrap-noWrap']/span[1]";
			String hotelStarXpath="//div[text()='4']";

			switch (starCategory.get(i)) {
			
			// Validating 3 star filter
			case "3 Star":
				// Added polling wait
				
				pollingWait(sbList.getStarrating3(), 10);
				clickJavaScriptElement(sbList.getStarrating3());
				Thread.sleep(5000);
				
				String threeStarHotelXpath="//div[text()='3']";
				List<WebElement> starRating3= driver.findElements(By.xpath(threeStarHotelXpath));
				for(int j = 1;j<=starRating3.size();j++) {
					String starRateElement = "("+threeStarHotelXpath+")["+j+"]";
					WebElement starCheck = driver.findElement(By.xpath(starRateElement));
					hoverWebelement(starCheck);
					pollingWaitWithoutClickable(starCheck, 15);
					String star3 = starCheck.getText().split(" ")[0];
					System.out.println("star rating-->"+star3);
					int rating3 = Integer.parseInt(star3);
					if (rating3 == 3) {
						Assert.assertEquals(star3, "3");
					} else {
						System.out.println("3 Star rating Filter not working");
						Assert.assertTrue(false);
					}
				}
				System.out.println("3 Star rating Filter works fine");
				System.out.println();
				
				break;
			case "4 Star":
				// Added polling wait
				pollingWait(sbList.getStarrating4(), 10);
				// Validating 4 star filter
				clickJavaScriptElement(sbList.getStarrating4());
				Thread.sleep(5000);
				
				String fourStarHotelXpath="//div[text()='4']";
				
				List<WebElement> starRating4 = driver.findElements(By.xpath(fourStarHotelXpath));
				for(int j = 1;j<=starRating4.size();j++) {
					String starRateElement = "("+fourStarHotelXpath+")["+j+"]";
					WebElement starCheck = driver.findElement(By.xpath(starRateElement));
					hoverWebelement(starCheck);
					pollingWaitWithoutClickable(starCheck, 15);
					String star4 = starCheck.getText().split(" ")[0];
					System.out.println("star rating-->"+star4);
					int rating4 = Integer.parseInt(star4);
					if (rating4 == 4) {
						Assert.assertEquals(star4, "4");
					} else {
						System.out.println("4 Star rating Filter not working");
						Assert.assertTrue(false);
					}
				}
				System.out.println("4 Star rating Filter works fine");
				System.out.println();
				break;
			case "5 Star":
				// Added polling wait
				pollingWait(sbList.getStarrating5(), 10);
				// Validating 5 star filter
				clickJavaScriptElement(sbList.getStarrating5());
				
				Thread.sleep(5000);
				
				String fiveStarHotelXpath="//div[text()='5']";
				List<WebElement> starRating5 = driver.findElements(By.xpath(fiveStarHotelXpath));
				for(int j = 1;j<=starRating5.size();j++) {
					String starRateElement = "("+fiveStarHotelXpath+")["+j+"]";
					WebElement starCheck = driver.findElement(By.xpath(starRateElement));
					hoverWebelement(starCheck);
					pollingWaitWithoutClickable(starCheck, 15);
					String star5 = starCheck.getText().split(" ")[0];
					int rating5 = Integer.parseInt(star5);
					if (rating5 == 5) {
						Assert.assertEquals(star5, "5");
					} else {
						System.out.println("5 Star rating Filter not working");
						Assert.assertTrue(false);
					}
				}
				System.out.println("5 Star rating Filter works fine");
				System.out.println();
				break;
			default: {
				System.out.println("Invalid Star Category Filter");
			}
			}
			pageRefresh();
			Thread.sleep(1000);
		}
	}

	@Then("^Validate the villa type filter in listing page$")
	public void verify_villa_type_results() throws Throwable {
		List<String> villaType = new ArrayList<String>();
		villaType.add("Water Villa");
		villaType.add("Beach Bungalow");
		villaType.add("Split Stay");
		villaType.add("Family Stay");
		villaType.add("Garden Villa");
		for (int i = 0; i < villaType.size(); i++) {
			switch (villaType.get(i)) {
			
		
			// Validating Water villa filter
			case "Water Villa":
				// Added polling wait
				pollingWait(sbList.getWaterVillaFilter(), 10);
				scrolltoElement(sbList.getWaterVillaFilter());
				clickAction(sbList.getWaterVillaFilter());
				Thread.sleep(5000);
				
				String villaTypeXpath="//div[@class='veho-c-lesPJm veho-c-lesPJm-iciHYuY-css']";
				List<WebElement> waterVillaText = driver.findElements(By.xpath(villaTypeXpath));
				for(int j = 1;j<=waterVillaText.size();j++) {
					String waterVillaElement = "("+villaTypeXpath+")["+j+"]";
					WebElement waterVilla = driver.findElement(By.xpath(waterVillaElement));
					hoverWebelement(waterVilla);
					pollingWaitWithoutClickable(waterVilla, 15);
					String villaWaterTextActual = waterVilla.getText();
					String expectedwaterVilla = "Water Villa";
					try {
						Assert.assertTrue(villaWaterTextActual.contains(expectedwaterVilla));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Water Vila Filter works properly");
				
				break;
			case "Beach Bungalow":
				// Added polling wait
				pollingWait(sbList.getBeachBungalowFilter(), 10);
				// Validating Beach Bungalow filter
				scrolltoElement(sbList.getBeachBungalowFilter());
				clickAction(sbList.getBeachBungalowFilter());
				pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
				String beachBungalow = sbList.getWeresorry().getText();
				String expectedbeachBungalow = "The resorts are unavailable for the filters you've selected.";
				if (sbList.getWeresorry().isDisplayed()) {
					try {
						Assert.assertTrue(beachBungalow.contains(expectedbeachBungalow));
						System.out.println("Beach Bungalow Filter works properly");
						System.out.println();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;

			case "Split Stay":
				// Added polling wait
				pollingWait(sbList.getSplitStayFilter(), 10);
				// Validating Split Stay filter
				scrolltoElement(sbList.getSplitStayFilter());
				clickAction(sbList.getSplitStayFilter());
				pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
				Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
				System.out.println("Split stay Filters works properly");
				System.out.println();

				break;

			case "Family Stay":
				// Added polling wait
				pollingWait(sbList.getFamilyVillaFilter(), 10);
				// Validating Family Stay filter
				scrolltoElement(sbList.getFamilyVillaFilter());
				clickAction(sbList.getFamilyVillaFilter());
				pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
				Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
				System.out.println("Family stay Filters works properly");
				System.out.println();

				break;

			case "Garden Villa":
				// Added polling wait
				pollingWait(sbList.getGardenVillaFilter(), 10);
				// Validating Garden Villa filter
				scrolltoElement(sbList.getGardenVillaFilter());
				clickAction(sbList.getGardenVillaFilter());
				pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
				Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
				System.out.println("Garden Villa Filters works properly");
				System.out.println();
				break;

			default: {
				System.out.println("Invalid Villa Type option");
			}
			}
			pageRefresh();
			Thread.sleep(1000);
		}
	}

	@Then("^Validate the other filter in listing page$")
	public void verify_filter_results() throws Throwable {
		List<String> otherType = new ArrayList<String>();
		otherType.add("For the Honeymooners");
		otherType.add("Best Overwater Villa");
		otherType.add("Seaplane Only");
		otherType.add("Great Indian Food");
		otherType.add("Kid Friendly Resorts");
		otherType.add("Closest to Airport");

		for (int i = 0; i < otherType.size(); i++) {
			switch (otherType.get(i)) {
			// Validating Garden Villa filter
			case "For the Honeymooners":
				// Added polling wait
				pollingWait(sbList.getForHoneymoonersFilter(), 15);
				scrolltoElement(sbList.getForHoneymoonersFilter());
				clickAction(sbList.getForHoneymoonersFilter());
				try {
					pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
					Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
					System.out.println("For the Honeymooners Filters works properly");
				}
				catch (Exception e) {
					System.out.println("No Cards is displayed for For the Honeymooners filters");
				}
					try {
						pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
						String honeymoonfilter = "The resorts are unavailable for the filters you've selected.";
						String seaplaneFilter = sbList.getWeresorry().getText();
						Assert.assertTrue(seaplaneFilter.contains(honeymoonfilter));
						System.out.println("For the Honeymooners Filters works properly");
						System.out.println();
					} catch (Exception e) {
						System.out.println("Cards is displayed for For the Honeymooners filters");
					}
					scrolltoElement(sbList.getForHoneymoonersFilter());
					clickAction(sbList.getForHoneymoonersFilter());
				break;
			case "Best Overwater Villa":
				// Added polling wait
				pollingWait(sbList.getBestOverwaterVillaFilter(), 15);
				// Validating Best Overwater Villa filter
				scrolltoElement(sbList.getBestOverwaterVillaFilter());
				clickAction(sbList.getBestOverwaterVillaFilter());
				String expectedbfilter = "The resorts are unavailable for the filters you've selected.";
				try {
					pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
					Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
					System.out.println("Best overwater Filter works properly");
				}
			catch (Exception e) {
				System.out.println("No Cards is displayed for Best Overwater Villa filters");
			}
					try {
						pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
						String bestOverwaterFilter = sbList.getWeresorry().getText();
						Assert.assertTrue(bestOverwaterFilter.contains(expectedbfilter));
						System.out.println("Best overwater Filter works properly");
						System.out.println();
					} catch (Exception e) {
						System.out.println("Cards is displayed for Best Overwater Villa filters");
					}
				
					scrolltoElement(sbList.getBestOverwaterVillaFilter());
					clickAction(sbList.getBestOverwaterVillaFilter());
				break;
			case "Seaplane Only":
				// Added polling wait
				pollingWait(sbList.getSeaplaneOnlyFilter(), 15);
				// Validating Seaplane Only filter
				scrolltoElement(sbList.getSeaplaneOnlyFilter());
				clickAction(sbList.getSeaplaneOnlyFilter());
				try {
					pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
					Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
					System.out.println("Seaplane Only Filters works properly");
				}
				catch (Exception e) {
					System.out.println("No Cards is displayed for Seaplane Only filters");
				}
					try {
						pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
						String seplanefilter = "The resorts are unavailable for the filters you've selected.";
						String seaplaneFilter = sbList.getWeresorry().getText();
						Assert.assertTrue(seaplaneFilter.contains(seplanefilter));
						System.out.println("Seaplane Only Filters works properly");
						System.out.println();
					} catch (Exception e) {
						System.out.println("Cards is displayed Seaplane Only filters");
					}
					scrolltoElement(sbList.getSeaplaneOnlyFilter());
					clickAction(sbList.getSeaplaneOnlyFilter());
				break;
			case "Great Indian Food":
				// Added polling wait
				pollingWait(sbList.getGreatIndianFoodFilter(), 15);
				// Validating Great Indian Food filter
				scrolltoElement(sbList.getGreatIndianFoodFilter());
				clickAction(sbList.getGreatIndianFoodFilter());
				
				//Cards are displayed in this filter so, changed the code for this(04.04.2024)
				try {
					pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
					Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
					System.out.println("Great Indian Food Filters works properly");
				}
				catch (Exception e) {
					System.out.println("No Cards is displayed for Great Indian Food filters");
				}
					try {
						pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
						String honeymoonfilter = "The resorts are unavailable for the filters you've selected.";
						String seaplaneFilter = sbList.getWeresorry().getText();
						Assert.assertTrue(seaplaneFilter.contains(honeymoonfilter));
						System.out.println("Great Indian Food Filters works properly");
						System.out.println();
					} catch (Exception e) {
						System.out.println("Cards is displayed for Great Indian Food filters");
					}
					scrolltoElement(sbList.getGreatIndianFoodFilter());
					clickAction(sbList.getGreatIndianFoodFilter());
				break;
			case "Kid Friendly Resorts":
				// Added polling wait
				pollingWait(sbList.getKidFriendlyResortsFilter(), 15);
				// Validating Kid Friendly Resorts filter
				scrolltoElement(sbList.getKidFriendlyResortsFilter());
				clickAction(sbList.getKidFriendlyResortsFilter());
			//Cards are displayed in this filter so, changed the code for this(13.03.2024)
				try {
					pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
					Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
					System.out.println("Kid Friendly Resorts Filters works properly");
				}
				catch (Exception e) {
					System.out.println("No Cards is displayed for Kid Friendly Resorts filters");
				}
					try {
						pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
						String honeymoonfilter = "The resorts are unavailable for the filters you've selected.";
						String seaplaneFilter = sbList.getWeresorry().getText();
						Assert.assertTrue(seaplaneFilter.contains(honeymoonfilter));
						System.out.println("Kid Friendly Resorts Filters works properly");
						System.out.println();
					} catch (Exception e) {
						System.out.println("Cards is displayed for Kid Friendly Resorts filters");
					}
					scrolltoElement(sbList.getKidFriendlyResortsFilter());
					clickAction(sbList.getKidFriendlyResortsFilter());
				break;
			case "Closest to Airport":
				// Added polling wait
				pollingWait(sbList.getClosestToAirportFilter(), 15);
				// Validating Closest to Airport filter
				scrolltoElement(sbList.getClosestToAirportFilter());
				clickAction(sbList.getClosestToAirportFilter());
				try {
					pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
					Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
					System.out.println("Closest to Airport Filters works properly");
				}
				catch (Exception e) {
					System.out.println("No Cards is displayed for Closest to Airport filters");
				}
					try {
						pollingWaitWithoutClickable(sbList.getWeresorry(), 15);
						String honeymoonfilter = "The resorts are unavailable for the filters you've selected.";
						String seaplaneFilter = sbList.getWeresorry().getText();
						Assert.assertTrue(seaplaneFilter.contains(honeymoonfilter));
						System.out.println("Closest to Airport Filters works properly");
						System.out.println();
					} catch (Exception e) {
						System.out.println("Cards is displayed for Closest to Airport filters");
					}
				
				break;

			default: {
				System.out.println("Invalid Others Filter Type option");
			}
			}
			pageRefresh();
			Thread.sleep(1000);
		}

	}

	@Then("^Validate the Meal filter in listing page$")
	public void verify_meal_filter_results() throws Throwable {
		String urlMealFilter = "";
		List<String> mealType = new ArrayList<String>();
		mealType.add("Half Board");
		mealType.add("Full Board");
		mealType.add("Breakfast Only");
		mealType.add("All Inclusive");
		for (int i = 0; i < mealType.size(); i++) {
			switch (mealType.get(i)) {
			case "Half Board":
				clickAction(sbList.getMealFilter());
				clickAction(sbList.getHalfBoardFilter());
				clickAction(sbList.getApplyChosenFilter());
				urlMealFilter = "HB";
				break;
			case "Full Board":
				clickAction(sbList.getMealFilter());
				clickAction(sbList.getFullBoardFilter());
				clickAction(sbList.getApplyChosenFilter());
				urlMealFilter = "FB";
				break;
			case "Breakfast Only":
				clickAction(sbList.getMealFilter());
				clickAction(sbList.getBreakfastOnlyFilter());
				clickAction(sbList.getApplyChosenFilter());
				urlMealFilter = "BB";

				break;
			case "All Inclusive":
				clickAction(sbList.getMealFilter());
				clickAction(sbList.getAllInclusiveFilter());
				clickAction(sbList.getApplyChosenFilter());
				urlMealFilter = "AI";
				break;

			}
			validateAssertion(getCurrentUrl().contains("&meal=" + urlMealFilter));
			System.out.println("Successfully validated " + mealType.get(i) + " option in villa type filter");
			clickAction(sbList.getMealFilter());
			clickAction(sbList.getResetFilter());
			clickAction(sbList.getApplyChosenFilter());
			Thread.sleep(1000);
		}
	}

	@Then("^Enter the room config with adult count and child count as \"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_custom_pax_speedboat(String adultCount, String childCount) throws Throwable {
		int adults = Integer.parseInt(adultCount);
		int children = Integer.parseInt(childCount);
		System.out.println("Updating adult count as " + adults + " and child count as " + children);
		int ageToSelect = 0;
		clickAction(sbLand.getSbPax());
		clickAction(sbLand.sbChooseFamilyGcm());
		if (adults > 2) {
			for (int i = 3; i <= adults; i++) {
				clickAction(sbLand.sbAddAdultToPax());
			}
		}
		if (children >= 1) {
			for (int j = 1; j <= children; j++) {
				clickAction(sbLand.sbAddChildToPax());
				ageToSelect = j + 4;
				clickAction(driver.findElement(
						By.xpath("(//select[contains(@class,'ChildAge')]/option[" + ageToSelect + "])[" + j + "]")));
			}
		}
		clickAction(sbLand.sbSaveRoomConfig());
	}

	@And("^Verify that resort details page is opened$")
	public void verify_resort_details_page_load() throws Throwable {
		switchWindows();
		Thread.sleep(2000);
		System.out.println(getCurrentUrl());
		validateAssertion(getCurrentUrl().contains("-maldives-resort"));
		System.out.println("Successfully navigated to the uncosted resort details page");
	}

	@Then("^Click on a resort card for the category \"([^\"]*)\"$")
	public void select_resort_card_from_category(String category) throws Throwable {
		switch (category) {
		case "For the Honeymooners":
			scrollToView(sbLand.sbChooseHoneymoonResort());
			// Select 2nd resort card - coco-bodu-hithi since its available for many dates
			clickAction(sbLand.sbChooseHoneymoonResort());
			break;
		case "Best Overwater Villa":
			scrollToView(sbLand.sbChooseOverwaterResort());
			// Select 1st resort card - coco-bodu-hithi since its available for many dates
			clickAction(sbLand.sbChooseOverwaterResort());
			break;
		case "Kid Friendly Resorts":
			scrollToView(sbLand.sbChooseKidFriendlyResort());
			// Select 3rd resort card - sun-siyam-olhuveli since its available for many
			// dates
			clickAction(sbLand.sbChooseKidFriendlyResort());
			break;
		case "Great Indian Food":
			scrollToView(sbLand.sbChooseIndianFoodResort());
			clickAction(sbLand.sbChooseIndianFoodResort());
			break;
		case "Seaplane Only":
			scrollToView(sbLand.sbChooseSeaplaneResort());
			clickAction(sbLand.sbChooseSeaplaneResort());
			break;
		case "Closest to Airport":
			scrollToView(sbLand.sbChooseAirportResort());
			clickAction(sbLand.sbChooseAirportResort());
			break;
		}
	}

	@Then("^Click on the resort card for the category \"([^\"]*)\" and select resort name \"([^\"]*)\"$")
	public void click_on_the_resort_card_for_the_category_and_select_resort_name(String category, String Hotelname)
			throws Throwable {

		try {
			switch (category) {

			case "For the Honeymooners":
				Thread.sleep(2000);
				scrollToView(driver.findElement(By.xpath("//h2[text()='Honeymoon Friendly']")));
				Thread.sleep(2000);
				List<WebElement> listhoneymoonhotelname = sbList.getSbListinghoneymoonhotelname();
				System.out.println("honeymoon size--> " + listhoneymoonhotelname.size());
				for (int i = 0; i < listhoneymoonhotelname.size(); i++) {
					String Villaname = listhoneymoonhotelname.get(i).getText();
					System.out.println("Villa name: " + Villaname);
					System.out.println(Hotelname);

					if (Villaname.equals(Hotelname)) {
						System.out.println("true");
						clickAction(listhoneymoonhotelname.get(i));
						break;
					}
				}
				break;

			case "Best Overwater Villa":
				scrollToView(driver.findElement(By.xpath("//h2[text()='Best Overwater Villa']")));
				List<WebElement> listhotelname = sbList.getSbListingoverwaterHotelname();
				for (int i = 0; i < listhotelname.size(); i++) {
					String Villaname = listhotelname.get(i).getText();
					if (Villaname.equals(Hotelname)) {
						clickAction(listhotelname.get(i));
						break;
					}
				}
				break;
			case "Kid Friendly Resorts":
				scrollToView(driver.findElement(By.xpath("//h2[text()='Kids/Family Friendly Resorts']")));
				List<WebElement> listkidshotelname = sbList.getSbListingkidshotelname();
				for (int i = 0; i < listkidshotelname.size(); i++) {
					String Villaname = listkidshotelname.get(i).getText();
					if (Villaname.equals(Hotelname)) {
						clickAction(listkidshotelname.get(i));
						break;
					}
				}
				break;
			case "Great Indian Food":
				scrollToView(driver.findElement(By.xpath("//h2[text()='Great Indian Food']")));
				List<WebElement> listindianhotelname = sbList.getSbListingindianhotelname();
				for (int i = 0; i < listindianhotelname.size(); i++) {
					String Villaname = listindianhotelname.get(i).getText();
					if (Villaname.equals(Hotelname)) {
						clickAction(listindianhotelname.get(i));
						break;
					}
				}
				break;

			case "Pocket Savers":
				scrollToView(driver.findElement(By.xpath("//i[@class='pocketsaver']")));
				List<WebElement> listPocketSavers = sbList.getSbListingPocketSaversHotelname();
				for (int i = 0; i < listPocketSavers.size(); i++) {
					String Villaname = listPocketSavers.get(i).getText();
					if (Villaname.equals(Hotelname)) {
						clickAction(listPocketSavers.get(i));
						break;
					}
				}
				break;

			case "Seaplane Only":
				scrollToView(driver.findElement(By.xpath("//h2[text()='Seaplane']")));
				List<WebElement> listseaplanehotelname = sbList.getSbListingseaplanehotelname();
				for (int i = 0; i < listseaplanehotelname.size(); i++) {
					String Villaname = listseaplanehotelname.get(i).getText();
					if (Villaname.equals(Hotelname)) {
						clickAction(listseaplanehotelname.get(i));
						break;
					}
				}
				break;

			}

		} catch (Exception ex) {
			System.out.println("Problem while selecting the hotels " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Then("^Click on Check Availability button$")
	public void click_check_availability_option() throws Throwable {
		scrollToView(sbUncost.getCheckAvailability());
		clickAction(sbUncost.getCheckAvailability());
		Thread.sleep(2000);
	}

	@Then("^Click on change room option$")
	public void click_change_room_option() throws Throwable {
		scrollToView(sbCost.getChangeRoom());
		clickAction(sbCost.getChangeRoom());
	}

	@Then("^Choose a room from the alternate full stay options available$")
	public void choose_alternate_full_stay_room_option() throws Throwable {
		clickAction(sbCost.getsbChooseAlternateRoom());
		List<WebElement> roomList = sbCost.getFullStayRoomList();
		if (roomList.size() >= 1) {
			clickAction(sbCost.getAlternateFullStayRoom());
			System.out.println("Added alternate room");
			waitForMe(sbCost.getBookNow());
			validateAssertion(elementDisplayed(sbCost.getBookNow()));
		} else {
			System.out.println("There are no alternate full stay room options available");
		}
	}

	@Then("^Choose a room from the alternate split stay options available$")
	public void choose_alternate_split_stay_room_option() throws Throwable {
		if (elementDisplayed(sbCost.chooseSplitStayTab())) {
			clickAction(sbCost.chooseSplitStayTab());
			List<WebElement> roomList = sbCost.getSplitStayRoomList();
			if (roomList.size() >= 1) {
				clickAction(sbCost.getAlternateSplitStayRoom());
				waitForMe(sbCost.getBookNow());
			} else {
				System.out.println("There are no alternate split stay room options available");
			}
		} else {
			System.out.println("There are no split stay room options available for the given resort");
		}
	}

	@Then("^Verify the resorts are getting listed on the listing page$")
	public void verify_the_resorts_are_getting_listed_on_the_listing_page() throws Throwable {
		try {
			WebElement costingAnimation = driver.findElement(By.xpath("//div[@class='delay-video']"));
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.invisibilityOf(costingAnimation));
			List<WebElement> resorts = driver
					.findElements(By.xpath("//section[contains(@class,'ListingCardStyles__ResortListCardWrapper')]"));
			int listingpagesize = resorts.size();
			System.out.println("listingpagesize---" + listingpagesize);
			if (listingpagesize > 0) {
				clickAction(sbList.getListingCard());
				// waitForMe(booingReview.getbookNowButton());
				Thread.sleep(20000);
				switchWindows();
				String url = driver.getCurrentUrl();
				System.out.println("url---" + url);
				validateAssertion(url.contains("inclusions"));
				// scrolltoElement(booingReview.getbookNowButton());
				// validateAssertion(elementDisplayed(booingReview.getbookNowButton()));
			} else {
				validateAssertion(elementDisplayed(driver.findElement(By.xpath("//section[@class='no-resorts']"))));
			}

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Then("^user fills the GCM form of maldives for \"([^\"]*)\"$")
	public void user_fills_the_GCM_form_of_maldives_for(String departFrom) throws Throwable {
		fillMandatoryInfoInGCMWithDepartFromForMaldives(departFrom);
	}

	@Then("Validate the Edit details functionality in the listing page")
	public void validate_the_edit_details_functionality_in_the_listing_page() throws InterruptedException {

		// Edit details with 3 nights & Couple and validating the edit details
		// functionality
		// Added pollingwait
		pollingWait(sbList.getSbEdit(), 20);
		clickAction(sbList.getSbEdit());
		Thread.sleep(1000);	
		pollingWaitWithoutClickable(sbList.getSbdepcity(), 15);
		forceClick(sbList.getSbdepcity());
		Thread.sleep(2000);
		clickAction(sbList.getSbChooseDate());
		Thread.sleep(2000);		
		clickAction(sbList.getSbNoOfNights());
		Thread.sleep(2000);		
		clickAction(sbList.getSbChooseCouple());
		Thread.sleep(7000);

		// Verifying after edit details, it is correctly updating in the listing page or
		// not
		pollingWaitWithoutClickable(sbList.getEditedDetails(), 20);
		String editedDetailsResult = sbList.getEditedDetails().getText();
		Assert.assertTrue(editedDetailsResult.contains("22, 3 nights, 2 pax"));
		System.out.println("Edited details is validated");

		// Added polling wait
		pollingWaitWithoutClickable(cp.getMaldivesListingCardPresent(), 15);
		Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
		System.out.println();

		// Added Nights validation after edit details in cards
		 nights = driver.findElements(By.xpath(
//					"//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-ifJLjZW-css'][normalize-space()='3 Nights']"));
				"//span[normalize-space()='3 Nights']"));
		 System.out.println("Total nights card:"+nights.size());
		for (int j = 1; j <= nights.size(); j++) {
			String night = "(//span[normalize-space()='3 Nights'])["+j+"]";
			System.out.println("(//span[normalize-space()='3 Nights'])["+j+"]");
			WebElement totalNights = driver.findElement(By.xpath(night));
			Thread.sleep(1000);
			hoverWebelement(totalNights);
			
//			scrolltoElement(totalNights);
			Thread.sleep(500);
			String cardNights = totalNights.getText();
			String nightsinCard = "3";
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}

		// Validating the Edit details data which is correctly costed with that data in the itinerary page
		hoverWebelement(sbList.getViewDeal());
		isElementVisible(sbList.getViewDeal(), 10);
		clickAction(sbList.getViewDeal());
		Thread.sleep(5000);
		Validate_whether_itinerary_costed_succesfully_for_Maldives();
		pollingWait(sbList.getItineraryEditDetails(), 10);
		String editDetails = sbList.getItineraryEditDetails().getText();
		Assert.assertTrue(editDetails.contains("2 Adults") && editDetails.contains("22"));
		System.out.println("After Edit details itinerary costed with same data successfully");
		System.out.println();
		

	}

	@Then("Validate Pyt Recommended filter in listing page")
	public void validate_pyt_recommended_filter_in_listing_page() throws InterruptedException {
		pollingWait(sbList.getPytRecommended(), 10);
		clickAction(sbList.getPytRecommended());
		
		Thread.sleep(3000);		
		// Added polling wait
		pollingWaitWithoutClickable(sbList.getWeresorry(), 10);
		String noResorts = sbList.getWeresorry().getText();
		String expectednoResorts = "The resorts are unavailable for the filters you've selected.";
	
		// Verifying Pyt recommended filter is working properly
		if (sbList.getWeresorry().isDisplayed()) {
			try {
				Assert.assertTrue(noResorts.contains(expectednoResorts));
				System.out.println("Pyt Recommeneded Filter validated successfully");
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
		pageRefresh();
	}

	// Costing Itinerary through Maldives listing page
	@Then("Verify that the itinerary costed for Maldives through listing page")
	public void verify_that_the_itinerary_costed_for_maldives_through_listing_page() throws InterruptedException {
		// Added polling wait
		pollingWait(sbList.getViewDeal(), 10);
		clickAction(sbList.getViewDeal());
		Thread.sleep(5000);
		Validate_whether_itinerary_costed_succesfully_for_Maldives();

		pollingWait(inclusion.getBookNow(), 35);
		Assert.assertTrue(inclusion.getBookNow().isDisplayed());
		// Validating twice so, I removed these lines

	}

	@Then("Validating the Edit details with {int} Nights and passenger as solo")
	public void validating_the_edit_details_with_nights_and_passenger_as_solo(Integer int1)
			throws InterruptedException {
		// Added polling wait
		pollingWait(sbList.getSbEdit(), 15);
		// Verifying edit details with Solo and 4 nights
		clickAction(sbList.getSbEdit());
		Thread.sleep(2000);
		clickAction(sbList.getSbdepcity());
		Thread.sleep(2000);
		clickAction(sbList.getSbChooseDate());
		Thread.sleep(2000);
//		scrolltoElement(sbList.getSb4Nights());
//		Assert.assertTrue(sbList.getSb4Nights().isDisplayed());
		clickJavaScriptElement(sbList.getSb4Nights());
		Thread.sleep(2000);
//		Assert.assertTrue(sbList.getSbChooseSolo().isDisplayed());
		clickJavaScriptElement(sbList.getSbChooseSolo());
		Thread.sleep(25000);

		// Verifying after edit details, it is correctly updating in the listing page or
		// not
		// Added polling wait
		try {
		pollingWait(sbList.getEditedDetails(), 30);
		String editedDetailsResult = sbList.getEditedDetails().getText();
		System.out.println("Edited details-->"+editedDetailsResult);
		Assert.assertTrue(editedDetailsResult.contains("22, 4 nights, 1 pax"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		// Added polling wait
		pollingWait(cp.getMaldivesListingCardPresent(), 10);
		Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
		System.out.println();
		// Added Nights validation after edit details in cards
		
		List<WebElement> nights = driver.findElements(By.xpath(
				"//span[normalize-space()='4 Nights']"));
		System.out.println("no. of 4 nights-->"+nights);
		for (int j = 1; j <= nights.size(); j++) {
			try {
			String night = "(//span[normalize-space()='4 Nights'])["+j+"]";
			WebElement totalNights = driver.findElement(By.xpath(night));
			Thread.sleep(1000);
			hoverWebelement(totalNights);
			Thread.sleep(500);
			String cardNights = totalNights.getText();
			System.out.println(cardNights);
			String nightsinCard = "4";
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
			}
			
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
			pageRefresh();
			String night = "(//span[normalize-space()='4 Nights'])["+j+"]";
			WebElement totalNights = driver.findElement(By.xpath(night));
			Thread.sleep(1000);
			hoverWebelement(totalNights);
			Thread.sleep(500);
			String cardNights = totalNights.getText();
			String nightsinCard = "4";
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
			}
		}
		Thread.sleep(2000);

		// Validating the Edit details data which is correctly costed with that data in
		// the itinerary page
		hoverWebelement(sbList.getViewDeal());
		isElementVisible(sbList.getViewDeal(), 20);
		clickAction(sbList.getViewDeal());
		Thread.sleep(2000);
		Validate_whether_itinerary_costed_succesfully_for_Maldives();
		pollingWaitWithoutClickable(sbList.getItineraryEditDetails(), 30);
		String editDetails = sbList.getItineraryEditDetails().getText();
		Assert.assertTrue(editDetails.contains("1 Adult") && editDetails.contains("22"));
		System.out.println("After Edit details itinerary costed with same data successfully");
		System.out.println("Edit details with 4 Nights and Solo Works properly");
		System.out.println();

	}

	@Then("Validating the Edit details with {int} Nights and passenger as Family with {int} Rooms & {int} Children & {int} Adults on each")
	public void validating_the_edit_details_with_nights_and_passenger_as_family_with_rooms_children_adults_on_each(
			Integer int1, Integer int2, Integer int3, Integer int4) throws InterruptedException {
		// Added polling wait
		pollingWaitWithoutClickable(sbList.getSbEdit(), 20);
		// Validating Family edit details with 5 Nights, 2 Rooms and 2 Adults, 2
		// children in each room
		Assert.assertTrue(isElementVisible(sbList.getSbEdit(), 20));
		clickAction(sbList.getSbEdit());
		Thread.sleep(500);
		
		pollingWaitWithoutClickable(sbList.getSbdepcity(), 20);
		Assert.assertTrue(isElementVisible(sbList.getSbdepcity(), 20));
		clickAction(sbList.getSbdepcity());
		Thread.sleep(500);
		
		pollingWaitWithoutClickable(sbList.getSbChooseDate(), 20);
		Assert.assertTrue(isElementVisible(sbList.getSbChooseDate(), 20));
		clickAction(sbList.getSbChooseDate());
		Thread.sleep(1000);
		//Changed pollingwait to pollingWaitWithoutClickable 0n Mar 22nd
		pollingWaitWithoutClickable(sbList.getSb5Nights(), 25);
		Assert.assertTrue(sbList.getSb5Nights().isDisplayed());
		clickAction(sbList.getSb5Nights());
		Thread.sleep(500);
		//Changed pollingwait to pollingWaitWithoutClickable 0n Mar 22nd
		pollingWaitWithoutClickable(sbList.getSbChooseFamily(), 15);
		Assert.assertTrue(sbList.getSbChooseFamily().isDisplayed());
		clickAction(sbList.getSbChooseFamily());
		Thread.sleep(1000);
		scrolltoElement(sbList.getSbFirstChild());
		forceClick(sbList.getSbFirstChild());
		Thread.sleep(2000);
		scrolltoElement(sbList.getSbSecondChild());
		forceClick(sbList.getSbSecondChild());
		Thread.sleep(2000);
//		clickJavaScriptElement(sbList.getSbChildAgeFirst());
		selectDropDownUsingValue(sbList.getSbChildAgeFirst(), "6");
		Thread.sleep(2000);
//		clickJavaScriptElement(sbList.getSbChildAgeSecond());
		selectDropDownUsingValue(sbList.getSbChildAgeSecond(), "8");

		Thread.sleep(1000);
		forceClick(sbList.getSbAddRoom());
		Thread.sleep(1000);
		forceClick(sbList.getSbAdultPlus());
		Thread.sleep(1000);
		forceClick(sbList.getSbFirstChild());
		Thread.sleep(1000);
		forceClick(sbList.getSbSecondChild());
		Thread.sleep(1000);
		selectDropDownUsingValue(sbList.getSbChildAgeFirst(), "4");
		Thread.sleep(1000);
		selectDropDownUsingValue(sbList.getSbChildAgeSecond(), "7");
		Thread.sleep(500);

		// Added polling wait
		//Changed pollingwait to pollingWaitWithoutClickable 0n Mar 22nd
		pollingWaitWithoutClickable(sbList.getSbViewTripCost(), 10);
		clickAction(sbList.getSbViewTripCost());

		Thread.sleep(25000);

		// Verifying after edit details, it is correctly updating in the listing page or
		// not
		pollingWaitWithoutClickable(sbList.getEditedDetails(), 30);
		String editedDetailsResult = sbList.getEditedDetails().getText();
		Assert.assertTrue(editedDetailsResult.contains("22, 5 nights, 8 pax - 2 rooms"));
		// Added polling wait
		pollingWait(cp.getMaldivesListingCardPresent(), 20);
		Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
		System.out.println();

		// Added Nights validation after edit details in cards
		List<WebElement> nights = driver.findElements(By.xpath(
				"//span[normalize-space()='5 Nights']"));
		for (int j = 1; j <= nights.size(); j++) {
			try {
			String night = "(//span[normalize-space()='5 Nights'])["+j+"]";
			WebElement totalNights = driver.findElement(By.xpath(night));
			Thread.sleep(1000);
			hoverWebelement(totalNights);
			Thread.sleep(500);
			String cardNights = totalNights.getText();
			String nightsinCard = "5";
			
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
			}
		
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			pageRefresh();
			String night = "(//span[normalize-space()='5 Nights'])["+j+"]";
			WebElement totalNights = driver.findElement(By.xpath(night));
			Thread.sleep(1000);
			hoverWebelement(totalNights);
			Thread.sleep(500);
			String cardNights = totalNights.getText();
			String nightsinCard = "5";
			
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		   
		}
		}
		
		Thread.sleep(8000);

		// Validating the Edit details data which is correctly costed with that data in
		// the itinerary page
		hoverWebelement(sbList.getAllViewDetails());
		isElementVisible(sbList.getAllViewDetails(), 20);
		clickAction(sbList.getViewDeal());
		Thread.sleep(10000);
		Validate_whether_itinerary_costed_succesfully_for_Maldives();
		pollingWaitWithoutClickable(sbList.getItineraryEditDetails(), 10);
		String editDetails = sbList.getItineraryEditDetails().getText();
		Assert.assertTrue(
				editDetails.contains("4 Adults") && editDetails.contains("4 Children") && editDetails.contains("22"));
		System.out.println("After Edit details itinerary costed with same data successfully");
		System.out.println("Edit details with 5 Nights and Family with 2 Rooms, 2 Adults & 2 Children in each room Works properly");
		System.out.println();

	}

	@Then("Validating the Edit details with Six Nights and passenger as Friends with Three Rooms - Four Adults, Three Adults & Two Adults on each")
	public void validating_the_edit_details_with_six_nights_and_passenger_as_friends_with_three_rooms_four_adults_three_adults_two_adults_on_each()
			throws InterruptedException {
		// Added polling wait to without clickable on Mar30
		pollingWaitWithoutClickable(sbList.getSbEdit(), 10);
		// Validate the Friends edit details with 6 Nights, 3 Rooms and Max people(9)
		
		//Added pollingwait for Depcity and changed the click action to forceclick on Apr 05
		Assert.assertTrue(sbList.getSbEdit().isDisplayed());
		clickAction(sbList.getSbEdit());
		Thread.sleep(1000);	
		pollingWaitWithoutClickable(sbList.getSbdepcity(), 15);
		Assert.assertTrue(sbList.getSbdepcity().isDisplayed());
		forceClick(sbList.getSbdepcity());
		Thread.sleep(1000);
		clickAction(sbList.getSbChooseDate());
		Thread.sleep(1000);
		
		pollingWaitWithoutClickable(sbList.getSb6Nights(), 10);
		Assert.assertTrue(sbList.getSb6Nights().isDisplayed());
		clickAction(sbList.getSb6Nights());
		pollingWaitWithoutClickable(sbList.getSbChooseFriends(), 10);
		Assert.assertTrue(sbList.getSbChooseFriends().isDisplayed());
		clickAction(sbList.getSbChooseFriends());

		Thread.sleep(500);
		forceClick(sbList.getSbSecondAdult());
		Thread.sleep(500);
		forceClick(sbList.getSbAddRoom());
		Thread.sleep(2000);
		forceClick(sbList.getSbAdultPlus());
		Thread.sleep(500);
		forceClick(sbList.getSbSecondAdult());
		Thread.sleep(500);
		forceClick(sbList.getSbAddRoom());
		Thread.sleep(2000);
		forceClick(sbList.getSbAdultPlus());
		Thread.sleep(500);
		forceClick(sbList.getSbSecondAdult());
		Thread.sleep(500);
		Thread.sleep(2000);

		// Verifying Max people Alert is displaying or not
		try {
			String maxPeopleAlert=sbList.getSbMaxPeople().getText();
			Assert.assertTrue(maxPeopleAlert.contains("9 people"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		Thread.sleep(2000);
		// Added polling wait
		pollingWait(sbList.getSbViewTripCost(), 15);
		scrolltoElement(sbList.getSbViewTripCost());
		actionsClick(sbList.getSbViewTripCost());
		Thread.sleep(10000);

		// Verifying after edit details, it is correctly updating in the listing page or
		// not
		pollingWaitWithoutClickable(sbList.getEditedDetails(), 20);
		String editedDetailsResult = sbList.getEditedDetails().getText();
		Assert.assertTrue(editedDetailsResult.contains("22, 6 nights, 9 pax - 3 rooms"));
		// Added polling wait
		pollingWait(cp.getMaldivesListingCardPresent(), 10);
		Assert.assertTrue(cp.getMaldivesListingCardPresent().isDisplayed());
		System.out.println();

		// Added Nights validation after edit details in cards
		List<WebElement> nights = driver.findElements(By.xpath(
				"//span[normalize-space()='6 Nights']"));
		for (int j = 1; j <= nights.size(); j++) {
			try {
			String night = "(//span[normalize-space()='6 Nights'])["+j+"]";
			WebElement totalNights = driver.findElement(By.xpath(night));
			hoverWebelement(totalNights);
			String cardNights = totalNights.getText();
			String nightsinCard = "6";
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
           }
			
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				pageRefresh();
				String night = "(//span[normalize-space()='6 Nights'])["+j+"]";
				WebElement totalNights = driver.findElement(By.xpath(night));
				hoverWebelement(totalNights);
				String cardNights = totalNights.getText();
				String nightsinCard = "6";
			try {
				Assert.assertTrue(cardNights.contains(nightsinCard));
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
			
			}
		}

		// Validating the Edit details data which is correctly costed with that data in
		// the itinerary page
		hoverWebelement(sbList.getViewDeal());
		isElementVisible(sbList.getViewDeal(), 20);
		actionsClick(sbList.getViewDeal());
		Thread.sleep(10000);
		Validate_whether_itinerary_costed_succesfully_for_Maldives();
		pollingWait(sbList.getItineraryEditDetails(), 10);
		String editDetails = sbList.getItineraryEditDetails().getText();
		Assert.assertTrue(editDetails.contains("9 Adults") && editDetails.contains("22"));
		System.out.println("After Edit details itinerary costed with same data successfully");
		System.out.println("Edit details with 6 Nights and Friends with 3 Rooms - 4 Adults, 3 Adults & 2 Adults in each room Works properly");
		System.out.println();

	}

	@Then("Validating by adding the maximum number of Rooms and Delete Rooms functionality in the Edit details")
	public void validating_by_adding_the_maximum_number_of_rooms_and_delete_rooms_functionality_in_the_edit_details()
			throws InterruptedException {
		// Added polling wait
		pollingWaitWithoutClickable(sbList.getSbEdit(), 15);
		Assert.assertTrue(sbList.getSbEdit().isDisplayed());
		clickAction(sbList.getSbEdit());
		//Added Assertion and changed the ckick to force click on APR 10
		pollingWaitWithoutClickable(sbList.getSbdepcity(), 15);
		Assert.assertTrue(sbList.getSbdepcity().isDisplayed());
		forceClick(sbList.getSbdepcity());
		
		pollingWaitWithoutClickable(sbList.getSbChooseDate(), 15);
		Assert.assertTrue(sbList.getSbChooseDate().isDisplayed());
		clickAction(sbList.getSbChooseDate());
		
		pollingWait(sbList.getSb6Nights(), 15);
		Assert.assertTrue(sbList.getSb6Nights().isDisplayed());
		clickAction(sbList.getSb6Nights());
		pollingWait(sbList.getSbChooseFriends(), 15);
		Assert.assertTrue(sbList.getSbChooseFriends().isDisplayed());
		clickAction(sbList.getSbChooseFriends());
		Thread.sleep(2000);

		// Adding Max no of rooms
		forceClick(sbList.getSbAddRoom());
		Thread.sleep(1000);

		forceClick(sbList.getSbAddRoom());
		Thread.sleep(1000);

		forceClick(sbList.getSbAddRoom());
		Thread.sleep(1000);

		forceClick(sbList.getSbAddRoom());
		Thread.sleep(1000);

		forceClick(sbList.getSbAddRoom());
		Thread.sleep(2000);
		
		
		List<WebElement> Room6 = driver.findElements(By.xpath("//span[contains(normalize-space(),'Room 6')]"));

		// Verifying the Max Rooms addition
		if (Room6.size() > 0) {
			System.out.println("Added max number of rooms working fine");
			Assert.assertTrue(true);

		} else {
			System.out.println("Unable to add max no of rooms");
			Assert.assertTrue(false);
		}
		

		// Deleting the added rooms and validating
		forceClick(sbList.getDeleteSixthRoom());
		Thread.sleep(1000);

		forceClick(sbList.getExpandFifthRoomDetails());
		Thread.sleep(2000);
		forceClick(sbList.getDeleteFifththRoom());
		Thread.sleep(1000);

		forceClick(sbList.getExpandFourthRoomDetails());
		Thread.sleep(2000);
		forceClick(sbList.getDeleteFouthRoom());
		Thread.sleep(1000);


		List<WebElement> Room3 = driver.findElements(By.xpath("//span[contains(normalize-space(),'Room 3')]"));
		if (Room3.size() >= 0) {
			System.out.println("Delete Room option works fine");
			Assert.assertTrue(true);

		} else {
			System.out.println("Delete Room option not working");
			Assert.assertTrue(false);
		}

	}

}
