package gluecode;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pyt.pages.HotelsPage;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class HotelsGlue extends Kernel {

	public static String beforeRoomChange;
	public static String afterRoomChange;

	@Then("^user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary$")
	public void user_validates_the_hotels_count() throws Throwable {

		// ReporteraddScenarioLog("user validates the costing flow for : " + region);
		// driver.navigate().to("https://staging.pickyourtrail.com");
		System.out.println("Header hotels : " + getText(inclusion.getHotelTabInclusions()));

		// No of hotel cards in the itinerary
		List<WebElement> eles = driver
				.findElements(By.xpath("//div[@name='stay']//section[contains(@class,'inclusion-box')]"));
		Integer result = eles.size();
		System.out.println("Hotel Cards :" + result.toString());
		validate_String_Contains(getText(inclusion.getHotelTabInclusions()), result.toString());

		// ReporteraddScenarioLog("No of hotels added in this itinerary is : " +
		// result);

	}

	@Then("^user views the details of the hotel$")
	public void user_views_existing_hotel() throws Throwable {

		clickDisbledJavaScriptElement(hotelPage.getHotel_viewDetails());
		if (hotelPage.gethotel_ChangeHotelButton().isDisplayed()) {
			System.out.println("View Details working fine for the hotels card");
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}

	}

	@Then("^user removes the hotel and confirms$")
	public void user_removes_the_existing_hotel_and_validates_the_alert_message_for_removal() throws Throwable {

		clickAction(hotelPage.getHotel_removeHotelButton(), "User removes the hotel");

	}

	@Then("^Validate user will not be allowed to remove an hotel$")
	public void validatee_will_not_be_allowed_to_remove_an_hotel() throws Throwable {
		elementNotExist(hotelPage.getHotel_hotelRemovedMessage());
	}

	@Then("^user Adds an hotel$")
	public void user_adds_hotel() throws Throwable {
		clickAction(hotelPage.getHotel_addHotelButton(), "User adds the hotel");
		waitForMe(hotelPage.gethotel_replaceHotelCardAlternate());
		clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
		clickAction(hotelPage.gethotel_detailsPageAddToItinneraryButton(), "Adding the hotel in Details page ");
	}

	@Then("^user changes the hotel and select an alternative$")
	public void user_changes_hotel_Select_Alternative() throws Throwable {
		clickAction(hotelPage.gethotel_ChangeHotelButton(), "User changes the hotel");
		try {
			waitForMe(hotelPage.gethotel_replaceHotelCardAlternate());
			System.out.println(hotelPage.gethotel_replaceHotelCardAlternate().isDisplayed());
		//	clickAction(hotelPage.getOurPickFilterHotel(), "User clicks the our pick filter");
		//	validateAssertion(elementDisplayed(hotelPage.getTopRecommendedTagFilterHotel()));
			clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
			Thread.sleep(500);
			clickAction(hotelPage.getViewmorehotels(), "Selecting view more hotels");
			Thread.sleep(500);
			clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
			clickAction(hotelPage.gethotel_detailsPageAddToItinneraryButton(), "Adding the hotel in Details page ");
			System.out.println("Hotel replaced succesfully");
		} catch (Exception e) {
			System.out.println("No hotel option available! ");
			assumeTrue(false);
		}
	}

	@Then("^user changes the hotel$")
	public void user_changes_hotel() throws Throwable {
		clickAction(hotelPage.gethotel_ChangeHotelButton(), "User changes the hotel");

	}

	@Then("^user applies the pyt smart filters$")
	public void user_artFilter() throws Throwable {

		driver.navigate().refresh();
		Thread.sleep(5000);
		clickAction(hotelPage.getOurPickFilterHotel(), "User clicks the our pick filter");
		// elementDisplayed(hotelPage.getTopRecommendedTagFilterHotel());
		validateAssertion(elementDisplayed(hotelPage.getTopRecommendedTagFilterHotel()));
	}

	@Then("^validates hotel added succesfully$")
	public void validates_hotel_added_succesfully() throws Throwable {
		validateAssertion(elementDisplayed(hotelPage.getRoomDetails()));
	}

	/**
	 * Looping through the i value to get the dynamic web element of star filters
	 * and clicking the star filter based on that , validating using
	 * "validate_the_filter_applied_successfully" method ---> comparing the hotel
	 * pill text and applied filter text if both string equal scenario passed and
	 * getting the hotel option count for each filter application and printing it
	 */
	@Then("^apply the star filters and validate the filter applied succesfully$")
	public void apply_the_star_filters_and_validate_the_filter_applied_succesfully() throws Throwable {
		clickAction(hotelPage.getHeaderFilterHotelButton(),
				" User clicks the filter button in the hotel alternate header sticky bar");
		Thread.sleep(3000);
		for (int i = 3; i <= 5; i++) {
			WebElement starFilter = driver.findElement(By.xpath("//*[contains(@title,'" + i + " star')]"));
			Thread.sleep(1000);
			// Clicking the star filter
			pollingWaitWithoutClickable(starFilter, 30);
			clickAction(starFilter);
			// Waiting for loading the filter search results
			try {
				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			} catch (Exception e) {
				System.out.println("No filter option available");
			}

			// validating whether the appropriate start filter is selected
			validate_the_filter_applied_successfully("" + i + " star");
			Thread.sleep(1000);

			// Checking the filter count results
			int HotelOptions = hotelPage.getHotelCardInAlternate().size();
			if (HotelOptions > 0) {
				System.out.println("There are " + HotelOptions + " hotel options available for  " + i + " Star filter");
				List<WebElement> starRate = driver.findElements(By.xpath("//span[@class='star-rating']"));
				for (int j = 1; j <= starRate.size(); j++) {
					String Starrating = "(//span[@class='star-rating'])[" + j + "]";
					WebElement starelement = driver.findElement(By.xpath(Starrating));
					hoverWebelement(starelement);
					String star1 = Starrating + "//i[@class='pyt-star-16'][1]";
					String star2 = Starrating + "//i[@class='pyt-star-16'][2]";
					String star3 = Starrating + "//i[@class='pyt-star-16'][3]";
					String star4 = Starrating + "//i[@class='pyt-star-16'][4]";
					String star5 = Starrating + "//i[@class='pyt-star-16'][5]";
					WebElement starone = driver.findElement(By.xpath(star1));
					WebElement startwo = driver.findElement(By.xpath(star2));
					WebElement starthree = driver.findElement(By.xpath(star3));
					if (i == 3) {
						try {
							if (starone.isDisplayed() && startwo.isDisplayed() && starthree.isDisplayed()) {
								Assert.assertTrue(true);
							} else {
								Assert.fail("3 Star filter is not working in hotels alternate");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					else if (i == 4) {
						WebElement starfour = driver.findElement(By.xpath(star4));
						try {
							if (starone.isDisplayed() && startwo.isDisplayed() && starthree.isDisplayed()
									&& starfour.isDisplayed()) {
								Assert.assertTrue(true);
							} else {
								Assert.fail("4 Star filter is not working in hotels alternate");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					else if (i == 5) {
						WebElement starfour = driver.findElement(By.xpath(star4));
						WebElement starfive = driver.findElement(By.xpath(star5));
						try {
							if (starone.isDisplayed() && startwo.isDisplayed() && starthree.isDisplayed()
									&& starfour.isDisplayed() && starfive.isDisplayed()) {
								Assert.assertTrue(true);
							} else {
								Assert.fail("5 Star filter is not working in hotels alternate");

							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			} else {
				System.out.println("There is no hotel option available for " + i + " Star filter");
			}

			// Clicking the previously selected star filter again to reset the filter values
			WebElement disableActiveStarFilter = driver.findElement(
					By.xpath("//label[contains(@title,'" + i + " star')]//i[contains(@class,'pyt-check_box_active')]"));
			clickAction(disableActiveStarFilter);

			// Waiting for loading the filter search results
			try {
				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			} catch (Exception e) {
				System.out.println("No filter option available for Refundable option ");
			}
		}
	}

	@Then("^apply the inclusions filters in hotel alternate and validate the filter applied successfully$")
	public void apply_the_inclusions_filter_and_validate_the_filter_applied_succesfully() throws Throwable {
		clickAction(hotelPage.getHeaderFilterHotelButton(),
				" User clicks the filter button in the hotel alternate header sticky bar");
		Thread.sleep(3000);

		// Validating Free Breakfast filter option
		clickAction(hotelPage.getFreeBreakfastFilter());
		try {
			int hotelsCardSizeBF = hotelPage.getHotelCardInAlternate().size()/4;
			System.out.println(hotelsCardSizeBF);
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			try {
				for (int i = 0; i < hotelPage.getHotelCardInAlternate().size()/4; i++) {
					hoverWebelement(hotelPage.getHotelCardInAlternate().get(i));
					scrolltoElementAndClick(hotelPage.getHotelCardInAlternate().get(i));
					Assert.assertTrue(hotelPage.getFreeBreakfast().isDisplayed());
					hoverWebelement(hotelPage.getFreeBreakfast());
					Thread.sleep(500);
					clickAction(hotelPage.getBackToList());
					Thread.sleep(500);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Free breakfast filter is not working in the hotels alternate page");
			}

		} catch (Exception e) {
			System.out.println("No filter option available for Free Breakfast Filter option ");
		}
	//	clickAction(hotelPage.getFreeBreakfastFilter());
		
		pageRefresh();
		Thread.sleep(3000);
		clickAction(hotelPage.getHeaderFilterHotelButton());
		

		// Validating Free Wifi Filter option
		pollingWaitWithoutClickable(hotelPage.getFreeWifiFilter(), 20);
		clickAction(hotelPage.getFreeWifiFilter());
		try {
			int hotelsCardSizeWIFI = hotelPage.getHotelCardInAlternate().size()/4;
			System.out.println(hotelsCardSizeWIFI);
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			try {
				for (int i = 0; i < hotelPage.getHotelCardInAlternate().size()/4; i++) {
					hoverWebelement(hotelPage.getHotelCardInAlternate().get(i));
					scrolltoElementAndClick(hotelPage.getHotelCardInAlternate().get(i));
					Assert.assertTrue(hotelPage.getFreeWifi().isDisplayed());
					hoverWebelement(hotelPage.getFreeWifi());
					Thread.sleep(500);
					clickAction(hotelPage.getBackToList());
					Thread.sleep(500);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Free Wifi filter is not working in the hotels alternate page");
			}

		} catch (Exception e) {
			System.out.println("No filter option available for Free Wifi Filter option ");
		}
	//	clickAction(hotelPage.getFreeWifiFilter());
		
		pageRefresh();
		Thread.sleep(3000);
		clickAction(hotelPage.getHeaderFilterHotelButton());
		

		// Validating Air conditioning filter option
		pollingWaitWithoutClickable(hotelPage.getAirconditioningFilter(), 20);
		clickAction(hotelPage.getAirconditioningFilter());
		try {
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			int hotelsCardSizeAC = hotelPage.getHotelCardInAlternate().size()/4;
			System.out.println(hotelsCardSizeAC);
			
			try {
				for (int i = 0; i < hotelPage.getHotelCardInAlternate().size()/4; i++) {
					hoverWebelement(hotelPage.getHotelCardInAlternate().get(i));
					scrolltoElementAndClick(hotelPage.getHotelCardInAlternate().get(i));
					Assert.assertTrue(hotelPage.getAirconditioning().isDisplayed());
					hoverWebelement(hotelPage.getAirconditioning());
					Thread.sleep(500);
					clickAction(hotelPage.getBackToList());
					Thread.sleep(500);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Airconditioning filter is not working in the hotels alternate page");
			}

		} catch (Exception e) {
			System.out.println("No filter option available for Air condtioning Filter option ");
		}
		clickAction(hotelPage.getAirconditioningFilter());

	}

	/**
	 * Applying refundable filter and validating using refundable icon on the card
	 * and applying non refundable filter and validating using non refundable icon
	 * in the hotel card
	 */
	@Then("^apply the refundable filter in map view and validate the filter applied succesfully$")
	public void apply_the_refundable_filter_in_map_view_and_validate_the_filter_applied_succesfully() throws Throwable {
		clickAction(hotelPage.getHeaderFilterHotelButton(),
				" User clicks the filter button in the hotel alternate header sticky bar");
		// Clicking the refundable filter option
		clickAction(hotelPage.getRefundableFilterMapHotel(),
				"User clicks the refundable filter in map view of hotel alternate page ");
		// Waiting to load the filter search results
		try {
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			List<WebElement> refundable = driver.findElements(By.xpath("//span[text()='Refundable']"));
			for (int i = 0; i < refundable.size(); i++) {
				hoverWebelement(refundable.get(i));
				String refundablePills = getText(refundable.get(i));
				Assert.assertEquals(refundablePills, "Refundable");
			}
		} catch (Exception e) {
			System.out.println("No filter option available for Refundable option ");
		}
		// Validating the appropriate filter is applied
	//	validate_the_filter_applied_successfully("Refundable");

		// Clicking the previously selected refundable filter again to reset the filter
		// values
		clickAction(hotelPage.getUnselectRefundableFilterMapHotel(),
				"User deselects the refundable filter in map view of hotel alternate page ");
		// Waiting to load the filter search results
		try {
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
		} catch (Exception e) {
			System.out.println("No filter option available for Refundable option ");
		}

	//	validateAssertion(elementExist(hotelPage.getRefundableHotelCardIcon()));

		// Clicking the non-refundable filter option
		clickAction(hotelPage.getNonRefundableFilterMapHotel(),
				"User clicks the non refundable filter in map view of hotel alternate page ");
		// Waiting to load the filter search results
		try {
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
			List<WebElement> nonRefundable = driver.findElements(By.xpath("//span[text()='Non-Refundable']"));
			for (int i = 0; i < nonRefundable.size(); i++) {
				hoverWebelement(nonRefundable.get(i));
				String nonrefundablePills = getText(nonRefundable.get(i));
				Assert.assertEquals(nonrefundablePills, "Non-Refundable");
			}
		} catch (Exception e) {
			System.out.println("No filter option available for Non Refundable option ");
		}

		// Validating the appropriate filter is applied
	//	validate_the_filter_applied_successfully("Non Refundable");
		// Clicking the previously selected non-refundable filter again to reset the
		// filter values
		clickAction(hotelPage.getUnselectNonRefundableFilterMapHotel(),
				"User deselects the non refundable filter in map view of hotel alternate page ");
		// Waiting to load the filter search results
//		try {
//			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
//		} catch (Exception e) {
//			System.out.println("No filter option available for Non-Refundable option ");
//		}
	}

	/**
	 * Looping through the i value to get the dynamic web element of type filters
	 * and clicking the star filter based on that , validating using
	 * "validate_the_filter_applied_successfully" method ---> comparing the hotel
	 * pill text and applied filter text if both string equal scenario passed and
	 * getting the hotel option count for each filter application and printing it
	 */
	@Then("^apply the hotel filter in map view and validate the filter applied succesfully$")
	public void apply_the_hotel_filter_in_map_view_and_validate_the_filter_applied_succesfully() throws Throwable {
		try {
			Thread.sleep(3000);
			for (int i = 1; i <= 6; i++) {
				if (i == 5) {
					i++;
				}
				WebElement hotelTypeFilters = driver
						.findElement(By.xpath("//label[@value='" + i + "' and @name='hotel-type']"));
				System.out.println(hotelTypeFilters);
				String filtersName = getText(hotelTypeFilters);
				System.out.println(filtersName);
				// Clicking the appropriate hotel type
				clickAction(hotelTypeFilters, "user clicks the type of hotels ");
				Thread.sleep(500);
				if (elementDisplayed(hotelPage.getnoresultfound())) {
					clickAction(hotelTypeFilters);
				} else {

				}

				// Waiting to load the results
				try {
					pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
				} catch (Exception e) {
					System.out.println("No filter option available for " + filtersName + " option ");
				}

				// Validating whether the appropriate filter is selected
				validate_the_filter_applied_successfully(filtersName);
				Thread.sleep(1500);

				// Fetching the search results count
				int HotelOptions = hotelPage.getHotelCardInAlternate().size();
				if (HotelOptions > 0) {
					System.out.println(
							"There are " + HotelOptions + " hotel options available for " + filtersName + " filter");
				} else {
					System.out.println("There is no hotel option available for " + filtersName + " filter");
				}
				// Clicking the previously selected hotel type filter again to reset the filter
				// values
				WebElement deSelectActiveHotelType = driver.findElement(By.xpath("//label[@value='" + i
						+ "' and @name='hotel-type']//i[contains(@class,'pyt-check_box_active')]"));

				clickAction(deSelectActiveHotelType, "user deselects the active hotel type");

				// Waiting to load the filter
				try {
					pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
				} catch (Exception e) {
					System.out.println("No filter option available for " + filtersName + " option ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^user change the room$")
	public void user_change_the_room() throws Throwable {
		clickAction(hotelPage.getRetainRoomOptionHotelDetails(),
				"User clicks the retain the room option in the hotel details page");
		beforeRoomChange = getText(hotelPage.getFirstRoomNameNoExpandViewHotel());
		clickAction(hotelPage.getChooseMoreOptionHotelDetails(),
				"User clicks the choose more room option in the hotel details page");
		clickAction(hotelPage.getSelectRoomButtonHotelDetails(), "User change the room ");
		afterRoomChange = getText(hotelPage.getFirstRoomNameNoExpandViewHotel());

	}

	@Then("^validate the room changed successfully$")
	public void validate_the_room_changed_successfully() throws Throwable {
		Assert.assertTrue(!beforeRoomChange.equalsIgnoreCase(afterRoomChange));
		compareTwoWebElements(hotelPage.getFirstRoomNameNoExpandViewHotel(),
				hotelPage.getFirstRoomNameSideCardHotelDetails());
	}

	@Then("^apply the exclusive filter and validate the filter applied succesfully$")
	public void apply_the_exclusive_filter_and_validate_the_filter_applied_succesfully() throws Throwable {

		clickAction(hotelPage.getPytExclusiveToggle());

		try {
//			validateAssertion(elementDisplayed(hotelPage.getPytExclusiveTagHotelCard()));
			pollingWait(hotelPage.getPytExclusiveTagHotelCard(), 10);
		} catch (Exception e) {
			System.out.println("No hotel options available for exclusive filter");
		}

	}

	@Then("^apply sorting and validate the sort applied successfully$")
	public void apply_sorting_and_validate_the_sort_applied_successfully() throws Throwable {
//		pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
//		Thread.sleep(1000);
//		clickAction(hotelPage.getHeaderSortHotelButton());
//		Thread.sleep(1000);
//
//		// Clicking the rating sort filter
//		clickAction(hotelPage.getRatingSortingHotel());
//		try {
//			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
//		} catch (Exception e) {
//			System.out.println("No filter option available option ");
//		}
//		validateAssertion(elementExist(hotelPage.getHotel_replaceHotelCardAlternate()));
//
//		// Clicking the previously selected rating sort filter again to reset the filter
//		// values
//		clickAction(hotelPage.getdeselectRateSortHotel());
//		try {
//			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
//		} catch (Exception e) {
//			System.out.println("No filter option available for Refundable option ");
//		}
//
//		// Clicking the Price sort filter
//		clickAction(hotelPage.getPriceSortingHotel());
//		try {
//			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 5);
//		} catch (Exception e) {
//			System.out.println("No filter option available option ");
//		}
//		validateAssertion(elementExist(hotelPage.getHotel_replaceHotelCardAlternate()));
//		clickAction(hotelPage.getHeaderSortHotelButton());

		clickAction(hotelPage.getHeaderSortHotelButton());
		Thread.sleep(3000);
		clickAction(hotelPage.getPriceSortingHotel());
		List<Integer> actualList = new ArrayList<>();
		try {
			pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 5);
			List<WebElement> hotelPrice = driver.findElements(By.xpath("//span[@class='price-txt medium-heading']"));
			for (int i = 0; i < hotelPrice.size(); i++) {
				hoverWebelement(hotelPrice.get(i));
				String price = hotelPrice.get(i).getText();
				String hotelprice = price.replaceAll("[^0-9]", "");
				int actualprice = Integer.parseInt(hotelprice);
				actualList.add(actualprice);

			}
//			List<String> actualList = new ArrayList<>();
//	        for (WebElement element : hotelPrice) {
//	            actualList.add(element.getText());
//	        }
			System.out.println("Actual Order = " + actualList);

			// Create a copy of the list and sort it
			List<Integer> sortedList = new ArrayList<>(actualList);
			Collections.sort(sortedList);

			System.out.println("Sorted List for Price = " + sortedList);

			// Validate if the actual list is in ascending order
			boolean isAscending = actualList.equals(sortedList);

			// Print the result
			if (isAscending) {
				System.out.println("Cheapest First Filter is in the ascending order.");
				Assert.assertTrue(true);
			} else {
				System.out.println("Cheapest First Filter is not in the ascending order.");
				Assert.fail();
			}

		} catch (Exception e) {
			System.out.println("No filter option available for Cheapest first ");
		}

	}

	@Then("^check hotel options available in the alternate$")
	public void check_hotel_options_available_in_the_alternate() throws Throwable {
		clickAction(hotelPage.getChangeHotelInclusion());
//					"User click the change button in the hotel card in inclusions page ");
//			try {
//				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 20);
//				System.out.println(hotelPage.gethotel_replaceHotelCardAlternate().isDisplayed());
//				clickAction(hotelPage.getOurPickFilterHotel(), "User clicks the our pick filter");
//				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 20);
//				validateAssertion(elementDisplayed(hotelPage.getTopRecommendedTagFilterHotel()));
//				Thread.sleep(3000);
//				clickAction(hotelPage.getOurPickFilterHotel(), "User clicks the our pick filter");
//				Thread.sleep(2000);
//
//			} catch (Exception e) {
//
//				System.out.println("No hotel option available! ");
//				assumeTrue(false);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	@Then("^apply source provider filter and validate the appropriate source provider selected$")
	public void apply_source_provider_filter_and_validate_the_appropriate_source_provider_selected() throws Throwable {
		try {

			validate_the_filter_applied_successfully("AGODA");
			Thread.sleep(5000);
			clickJavaScriptElement(hotelPage.getHeaderSourceProviderHotelButton());
			clickAction(hotelPage.getExpediaHotelFilter());
			try {
				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 5);
				hoverWebelement(hotelPage.getHotel_replaceHotelCardAlternate());
				validateAssertion(elementDisplayed(hotelPage.getOnTripAdvisorHotelIcon()));

			} catch (Exception e) {

				System.out.println("No Expedia hotel option available! ");

			}

			Thread.sleep(5000);
			clickAction(hotelPage.getAgodaHotelFilter());
			try {
				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 5);
				hoverWebelement(hotelPage.getHotel_replaceHotelCardAlternate());
				validateAssertion(elementDisplayed(hotelPage.getOnAgodaHotelIcon()));

			} catch (Exception e) {

				System.out.println("No Agoda hotel option available! ");

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Check hotel options available in the alternate and fetch the hotel name$")
	public void check_hotel_options_available_in_the_alternate_and_fetch_the_hotel_name() throws Throwable {

		try {

			clickAction(hotelPage.getNavigatetostaysinclusion());
			clickAction(hotelPage.getChangeHotelInclusion());
			waitForMe(hotelPage.getHotel_firsthotelname(), 15);
			String hotelname = hotelPage.getHotel_firsthotelname().getText().trim();

			clickJavaScriptElement(hotelPage.getHotel_firsthotelname());
			clickJavaScriptElement(hotelPage.getDetailsPageAddToItinneraryButton());

			String afterhotelname = hotelPage.getFirsthotelname().getText().trim();
			String[] afterhotelnamesplit = afterhotelname.split("@");
			String afterhotelnameinclusion = afterhotelnamesplit[1].trim();

			boolean finalhotelname = compareTwoStrings(hotelname, afterhotelnameinclusion);
			validateAssertion(finalhotelname);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("add the split stay night in the itinerary")
	public void add_the_split_stay_night_in_the_itinerary() throws InterruptedException {
		scrolltoElement(hotelPage.getSplitStay());
		clickAction(hotelPage.getSplitStay());
		System.out.println("Split Stay button working fine");
		Assert.assertTrue(true);
		selectDropDownUsingVisibleText(hotelPage.getChooseDuration(), "1 night");
		Thread.sleep(2000);
		if(hotelPage.getFindHotels().isEnabled())
		{
			clickAction(hotelPage.getFindHotels());
			Thread.sleep(2000);
		}
		else
		{
			selectDropDownUsingVisibleText(hotelPage.getChooseDuration(), "2 nights");
			Thread.sleep(2000);
			clickAction(hotelPage.getFindHotels());
			Thread.sleep(2000);
		}
		
		clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
		clickAction(hotelPage.gethotel_detailsPageAddToItinneraryButton(), "Adding the hotel in Details page ");
		System.out.println("After split Hotels splitted succesfully");

	}

	@Then("validate the split stay added successfully in the itinerary")
	public void validate_the_split_stay_added_successfully_in_the_itinerary() {
		if (driver.findElements(By.xpath("//div[@name='stay']//section[@class='veho-c-lesPJm']")).size() > 1) {
			System.out.println("Split stay option working fine");
			Assert.assertTrue(true);
		} else {
			System.out.println("Split stay option not working");
			Assert.fail();
		}

	}

	@Then("validate that after closing the split stay it redirecting to the new itinerary")
	public void validate_that_after_closing_the_split_stay_it_redirecting_to_the_new_itinerary()
			throws InterruptedException {
		clickAction(hotelPage.getSplitStay());
		System.out.println("Split Stay button working fine");
		Assert.assertTrue(true);
		clickAction(hotelPage.getSplitStayClose());
		pollingWaitForCostingFlow("view", 150);
		if (getCurrentUrl().contains("view")) {
			validate_String_Contains(getCurrentUrl(), "view");
			System.out.println("After closing the split stay it redirects to new itinerary page");
			Assert.assertTrue(true);
			Thread.sleep(2000);
		} else {
			System.out.println("After closing the split stay it redirects to the old itinerary page");
			Assert.fail();
		}

	}

	@Then("Add the early checkin and checkout date and validate it")
	public void add_the_early_checkin_and_checkout_date_and_validate_it() throws InterruptedException {
		clickDisbledJavaScriptElement(hotelPage.getStays());
		hoverWebelement(hotelPage.getDatesOfStays());
		String datesofStay = hotelPage.getDatesOfStays().getText();
		String date = datesofStay.replaceAll("[^0-9]", "");
		String earlyChceckinDate = date.length() >= 2 ? date.substring(0, 2) : date;
		System.out.println("Actual Checkin date = " + earlyChceckinDate);
		String earlyChceckoutDate = date.length() >= 4 ? date.substring(2, 4) : date;
		System.out.println("Actual Checkout date = " + earlyChceckoutDate);
		int CheckinDate = Integer.parseInt(earlyChceckinDate);
		int CheckoutDate = Integer.parseInt(earlyChceckoutDate);

		int expectedEarlyCheckinDate = CheckinDate - 1;
		int expectedEarlyCheckoutDate = CheckoutDate + 1;

		pageRefresh();
		clickDisbledJavaScriptElement(hotelPage.getStays());

		Thread.sleep(3000);
		// Adding early checkin Date
		isElementVisible(hotelPage.getChangedates(), 20);
		scrolltoElementAndClick(hotelPage.getChangedates());
		// clickDisbledJavaScriptElement(hotelPage.getChangedates());
		Thread.sleep(2000);

		List<WebElement> early = driver.findElements(By.xpath("//span[text()='Add early check in']"));
		try {
		if (early.size() > 0) {

		} else {
			scrolltoElementAndClick(hotelPage.getChangedates());
		}
		}
		catch (Exception e) {
			
		}
		isElementVisible(hotelPage.getEarlycheckin(), 10);
		clickDisbledJavaScriptElement(hotelPage.getEarlycheckin());
		Thread.sleep(4000);
		isElementVisible(hotelPage.getConfirmChanges(), 10);
		scrolltoElement(hotelPage.getConfirmChanges());
		Thread.sleep(2000);
		actionsClick(hotelPage.getConfirmChanges());
		Thread.sleep(5000);

		try {
			clickDisbledJavaScriptElement(hotelPage.getStays());
			hoverWebelement(hotelPage.getDatesOfStays());
			String changeddatesofStay = hotelPage.getDatesOfStays().getText();
			String changeddate = changeddatesofStay.replaceAll("[^0-9]", "");
			String changedearlyChceckinDate = changeddate.length() >= 2 ? changeddate.substring(0, 2) : changeddate;
			int actualCheckinDate = Integer.parseInt(changedearlyChceckinDate);
			System.out.println("After add the checkin date = " + changedearlyChceckinDate);
			System.out.println("expectedEarlyCheckinDate"+expectedEarlyCheckinDate+"-->"+"actualCheckinDate"+actualCheckinDate);
			assertEquals(expectedEarlyCheckinDate, actualCheckinDate);
			System.out.println("Adding Early checkin Date is working for stays");
		} catch (Exception e) {
			System.out.println("Adding Early checkin Date is not working for stays");
			e.printStackTrace();
		}

		pageRefresh();

		// Removing early checkin Date
		isElementVisible(hotelPage.getChangedatesEarly(), 10);
		scrolltoElementAndClick(hotelPage.getChangedatesEarly());
		// clickJavaScriptElement(hotelPage.getChangedates());
		Thread.sleep(2000);
		try {
		if (hotelPage.getRemoveEarlycheckin().isDisplayed()) {

		} else {
			scrolltoElementAndClick(hotelPage.getChangedates());
		}
		}
		catch (Exception e) {
			
		}
		isElementVisible(hotelPage.getRemoveEarlycheckin(), 10);
		clickDisbledJavaScriptElement(hotelPage.getRemoveEarlycheckin());
		Thread.sleep(2000);
		isElementVisible(hotelPage.getConfirmChanges(), 10);
		Thread.sleep(2000);
		scrolltoElement(hotelPage.getConfirmChanges());
		Thread.sleep(2000);
		actionsClick(hotelPage.getConfirmChanges());
		Thread.sleep(5000);

		try {
			pollingWaitWithoutClickable(hotelPage.getDatesOfStays(), 20);
			String changeddatesofStay = hotelPage.getDatesOfStays().getText();
			String changeddate = changeddatesofStay.replaceAll("[^0-9]", "");
			String changedearlyChceckinDate = changeddate.length() >= 2 ? changeddate.substring(0, 2) : changeddate;
			int actualCheckinDate = Integer.parseInt(changedearlyChceckinDate);
			System.out.println("After removed the checkin date = " + changedearlyChceckinDate);
			assertEquals(CheckinDate, actualCheckinDate);
			System.out.println("Removing Early checkin Date is working for stays");
		} catch (Exception e) {
			System.out.println("Removing Early checkin Date is not working for stays");
			e.printStackTrace();
		}

		pageRefresh();

		// Adding Late checkout date
		isElementVisible(hotelPage.getChangedates(), 10);
		scrolltoElementAndClick(hotelPage.getChangedates());
		// clickJavaScriptElement(hotelPage.getChangedates());
		Thread.sleep(2000);
		try {
		if (hotelPage.getEarlycheckout().isDisplayed()) {

		} else {
			scrolltoElementAndClick(hotelPage.getChangedates());
		}
		}
		catch (Exception e) {
			
		}
		isElementVisible(hotelPage.getEarlycheckout(), 10);
		clickDisbledJavaScriptElement(hotelPage.getEarlycheckout());
		Thread.sleep(4000);
		isElementVisible(hotelPage.getConfirmChanges(), 10);
		Thread.sleep(1000);
		scrolltoElement(hotelPage.getConfirmChanges());
		Thread.sleep(2000);
		actionsClick(hotelPage.getConfirmChanges());
		Thread.sleep(5000);
		try {
			hoverWebelement(hotelPage.getDatesOfStays());
			String changeddatesofStay = hotelPage.getDatesOfStays().getText();
			String changeddate = changeddatesofStay.replaceAll("[^0-9]", "");
			String changedearlyChceckoutDate = changeddate.length() >= 4 ? changeddate.substring(2, 4) : changeddate;
			int actualCheckoutDate = Integer.parseInt(changedearlyChceckoutDate);
			System.out.println("After add the Late checkout date = " + changedearlyChceckoutDate);
			assertEquals(expectedEarlyCheckoutDate, actualCheckoutDate);
			System.out.println("Adding Late checkout Date is working for stays");
		} catch (Exception e) {
			System.out.println("Adding Late checkout Date is not working for stays");
			e.printStackTrace();
		}

		pageRefresh();

		// Removing late checkout Date
		isElementVisible(hotelPage.getChangedatesLate(), 10);
		scrolltoElementAndClick(hotelPage.getChangedatesLate());
		// clickJavaScriptElement(hotelPage.getChangedates());
		Thread.sleep(2000);
		try {
		if (hotelPage.getRemoveLatecheckout().isDisplayed()) {

		} else {
			scrolltoElementAndClick(hotelPage.getChangedates());
		}
		}
		catch (Exception e) {
			
		}
		isElementVisible(hotelPage.getRemoveLatecheckout(), 10);
		clickDisbledJavaScriptElement(hotelPage.getRemoveLatecheckout());
		Thread.sleep(2000);
		isElementVisible(hotelPage.getConfirmChanges(), 10);
		Thread.sleep(1000);
		scrolltoElement(hotelPage.getConfirmChanges());
		Thread.sleep(2000);
		actionsClick(hotelPage.getConfirmChanges());
		Thread.sleep(5000);
		try {
			hoverWebelement(hotelPage.getDatesOfStays());
			String changeddatesofStay = hotelPage.getDatesOfStays().getText();
			String changeddate = changeddatesofStay.replaceAll("[^0-9]", "");
			String changedearlyChceckoutDate = changeddate.length() >= 4 ? changeddate.substring(2, 4) : changeddate;
			int actualCheckoutDate = Integer.parseInt(changedearlyChceckoutDate);
			System.out.println("After remove the Late checkout date = " + changedearlyChceckoutDate);
			assertEquals(CheckoutDate, actualCheckoutDate);
			System.out.println("Removing Late checkout Date is working for stays");
		} catch (Exception e) {
			System.out.println("Removing Late checkout Date is not working for stays");
			e.printStackTrace();
		}
	}
}
