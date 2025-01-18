package gluecode;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class RentalCarGlue extends Kernel {

	@And("^user click on transfer tab$")
	public void user_click_on_transfer_tab() throws Throwable {
		scrolltoElement(rentalCarPage.getTranferButton());
		clickJavaScriptElement(rentalCarPage.getTranferButton());
		pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(),75);
		validate_String_Contains(getCurrentUrl(), "alternate-rental-cars/");

	}

	@And("^change the rental car$")
	public void change_the_rental_car() throws Throwable {

		try {
//		waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 60);
			if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {

				hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
			} else if (elementExist(rentalCarPage.getAlertCardIfNetworkFailedRentalCar())) {
				clickAction(rentalCarPage.getOkButtonInAlertCard(),
						"Issue with loading Rental cars, so user clicks the Ok button in the alert");
				Assert.fail();
			}

		} catch (Exception e) {
			// ReporteraddStepLog("There is no alternate rental car in the itinerary");
			System.out.println("There is no alternate rental car in the itinerary");
		}
	}

	@Then("^validate the rental car changed succesfully$")
	public void validate_the_rental_car_changed_succesfully() throws Throwable {

		pollingWait(rentalCarPage.getTranferButton(), 60);
		Assert.assertFalse(getCurrentUrl().contains("alternate-rental-cars/"));
	}

	@Then("^user change the insurance and validate the insurance applied successfully$")
	public void user_change_the_insurance_and_validate_the_insurance_applied_successfully() throws Throwable {

		scrolltoElement(inclusion.getInsuranceChangeLinkInRentalCar());
		clickJavaScriptElement(inclusion.getInsuranceChangeLinkInRentalCar());
		if (elementExist(rentalCarPage.getBasicInsuranceRentalCar())) {
			clickAction(rentalCarPage.getTotalProtectionPackageRentalCar(),
					"User selecting the Accident Damage Excess insurance type");
			clickAction(rentalCarPage.getApplyButtonInChangeInsuranceModal(),
					"User clicks the selected insurance type to apply in the itinerary");
		} else {
			Assert.fail();
		}
		validateAssertion(elementDisplayed(inclusion.getBookNow()));
	}

	@Then("^apply economy filter and validate the filter applied successfully$")
	public void apply_economy_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getEconomyFilterRentalCar())) {
				clickAction(rentalCarPage.getEconomyFilterRentalCar(), "User clicks on the Economy filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("Economy");
						clickAction(rentalCarPage.getEconomyFilterRentalCar(), "User clicks on the Economy filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply compact filter and validate the filter applied successfully$")
	public void apply_compact_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getCompactFilterRentalCar())) {
				System.out.println();
				clickAction(rentalCarPage.getCompactFilterRentalCar(), "User clicks on the Compact filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("Compact");
						clickAction(rentalCarPage.getCompactFilterRentalCar(), "User clicks on the Compact filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply value standard filter and validate the filter applied successfully$")
	public void apply_value_standard_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			user_click_on_transfer_tab();
			clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getValueStandardFilterRentalCar())) {
				clickAction(rentalCarPage.getValueStandardFilterRentalCar(),
						"User clicks on the value standard filter");
				waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
					rentalCarFilterValidation("Value standard");
					hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
					clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				} else {
					// ReporteraddStepLog("There is no result for the selected filter");
					clickAction(rentalCarPage.getBackToItineraryRentalCar(),
							"User Clicks the Back to itinerary in the rental car alternate page ");
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				}
			}
		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),
					"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(), "inclusions/");
			Thread.sleep(2000);
		}
	}

	@Then("^apply standard filter and validate the filter applied successfully$")
	public void apply_standard_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			user_click_on_transfer_tab();
			clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getStandardFilterRentalCar())) {
				clickAction(rentalCarPage.getStandardFilterRentalCar(), "User clicks on the standard filter");
				waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
					rentalCarFilterValidation("Standard");
					hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
					clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				} else {
					// ReporteraddStepLog("There is no result for the selected filter");
					clickAction(rentalCarPage.getBackToItineraryRentalCar(),
							"User Clicks the Back to itinerary in the rental car alternate page ");
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				}
			}
		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),
					"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(), "inclusions/");
			Thread.sleep(2000);
		}
	}

	@Then("^apply value suv \\(awd\\) filter and validate the filter applied successfully$")
	public void apply_value_suv_awd_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			user_click_on_transfer_tab();
			clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getValueSuvAwdFilterRentalCar())) {
				clickAction(rentalCarPage.getValueSuvAwdFilterRentalCar(), "User clicks on the value suv awd filter");
				waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
					rentalCarFilterValidation("Value");
					hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
					clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				} else {
					// ReporteraddStepLog("There is no result for the selected filter");
					clickAction(rentalCarPage.getBackToItineraryRentalCar(),
							"User Clicks the Back to itinerary in the rental car alternate page ");
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				}
			}
		}

		catch (NoSuchElementException e) {
			// ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),
					"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(), "inclusions/");
			Thread.sleep(2000);
		}
	}

	@Then("^apply executive filter and validate the filter applied successfully$")
	public void apply_executive_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getExecutiveFilterRentalCar())) {
				clickAction(rentalCarPage.getExecutiveFilterRentalCar(), "User clicks on the executive filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("Executive");
						clickAction(rentalCarPage.getExecutiveFilterRentalCar(), "User clicks on the executive filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply suv filter and validate the filter applied successfully$")
	public void apply_suv_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getSuvFilterRentalCar())) {
				clickAction(rentalCarPage.getSuvFilterRentalCar(), "User clicks on the SUV filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("SUV");
						clickAction(rentalCarPage.getSuvFilterRentalCar(), "User clicks on the SUV filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply intermediate filter and validate the filter applied successfully$")
	public void apply_intermediate_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getIntermediateFilterRentalCar())) {
				clickAction(rentalCarPage.getIntermediateFilterRentalCar(),
						"User clicks on the intermediate 4x4 filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("intermediate 4×4");
						clickAction(rentalCarPage.getIntermediateFilterRentalCar(),
								"User clicks on the intermediate 4x4 filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply large filter and validate the filter applied successfully$")
	public void apply_large_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getLargeFilterRentalCar())) {
				clickAction(rentalCarPage.getLargeFilterRentalCar(), "User clicks on the large 4x4 filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("Large 4x4");
						clickAction(rentalCarPage.getLargeFilterRentalCar(), "User clicks on the large 4x4 filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply premium filter and validate the filter applied successfully$")
	public void apply_premium_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			Thread.sleep(1000);
			if (elementExist(rentalCarPage.getPremiumFilterRentalCar())) {
				clickJavaScriptElement(rentalCarPage.getPremiumFilterRentalCar());
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("premium 4x4");
						clickJavaScriptElement(rentalCarPage.getPremiumFilterRentalCar());

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	/*
	 * The last filter - seater van under type category will validate the replace
	 * usecase also
	 */

	@Then("^apply seater van filter and validate the filter applied successfully$")
	public void apply_seater_van_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getSeaterVanFilterRentalCar())) {
				clickAction(rentalCarPage.getSeaterVanFilterRentalCar(), "User clicks on the 11 seater van filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("11 seater van");
						hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
						clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
						pollingWait(inclusion.getBookNow(), 40);
						verifyStringNotEquals(getCurrentUrl(), "alternate-rental-cars");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
						clickAction(rentalCarPage.getBackToItineraryRentalCar(),
								"User Clicks the Back to itinerary in the rental car alternate page ");

					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply suited for five filter and validate the filter applied successfully$")
	public void apply_suited_for_five_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			user_click_on_transfer_tab();
			clickAction(rentalCarPage.getSuitedForCategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getSuitedForFiveFilterRentalCar())) {
				clickAction(rentalCarPage.getSuitedForFiveFilterRentalCar(), "User clicks on the suited for 5  filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("5 people");
						clickAction(rentalCarPage.getSuitedForFiveFilterRentalCar(),
								"User clicks on the suited for 5  filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply suited for seven filter and validate the filter applied successfully$")
	public void apply_suited_for_seven_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getSuitedForSevenFilterRentalCar())) {
				clickAction(rentalCarPage.getSuitedForSevenFilterRentalCar(), "User clicks on the suited for 7 filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("7 people");
						clickAction(rentalCarPage.getSuitedForSevenFilterRentalCar(),
								"User clicks on the suited for 7 filter");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	/*
	 * The last filter - suited for 11 under suited for category will validate the
	 * replace usecase also
	 */

	@Then("^apply suited for eleven filter and validate the filter applied successfully$")
	public void apply_suited_for_eleven_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			if (elementExist(rentalCarPage.getSuitedForElevenFilterRentalCar())) {
				clickAction(rentalCarPage.getSuitedForElevenFilterRentalCar(),
						"User clicks on the suited for 11 filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						rentalCarFilterValidation("11 people");
						hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
						clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
						pollingWait(inclusion.getBookNow(), 40);
						verifyStringNotEquals(getCurrentUrl(), "alternate-rental-cars");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
						clickAction(rentalCarPage.getBackToItineraryRentalCar(),
								"User Clicks the Back to itinerary in the rental car alternate page ");

					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	/*
	 * The last filter - auto under transmission category will validate the replace
	 * usecase also.
	 */

	@Then("^apply automatic filter and validate the filter applied successfully$")
	public void apply_automatic_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			user_click_on_transfer_tab();
			clickAction(rentalCarPage.getTransmissionCategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getAutomaticFilterRentalCar())) {
				clickAction(rentalCarPage.getAutomaticFilterRentalCar(), "User clicks on the automatic filter");
				pollingWait(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				try {
					if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
						hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
						clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
						pollingWait(inclusion.getBookNow(), 40);
						verifyStringNotEquals(getCurrentUrl(), "alternate-rental-cars");

					} else if (verifyPartialText(rentalCarPage.getNoOptionFound(),
							"no alternate rental car options available")) {
						System.out.println("Alternate rental car are not available ");
					}
				} catch (Exception e) {
					Assert.fail();
				}
			} else {
				System.out.println("The selected filter isn't available");
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Alternate page isn't populating");
			e.printStackTrace();
		}
	}

	@Then("^apply air conditioning filter and validate the filter applied successfully$")
	public void apply_air_conditioning_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
			user_click_on_transfer_tab();
			clickAction(rentalCarPage.getTransmissionCategoryFilterRentalCar());
			if (elementExist(rentalCarPage.getAirconditioningFilterRentalCar())) {
				clickAction(rentalCarPage.getAirconditioningFilterRentalCar(),
						"User clicks on the air conditioning filter");
				waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(), 40);
				if (elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
					hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
					clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				} else {
					// ReporteraddStepLog("There is no result for the selected filter");
					clickAction(rentalCarPage.getBackToItineraryRentalCar(),
							"User Clicks the Back to itinerary in the rental car alternate page ");
					validate_String_Contains(getCurrentUrl(), "inclusions/");
					Thread.sleep(2000);
				}
			}
		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),
					"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(), "inclusions/");
			Thread.sleep(2000);
		}
	}

}
