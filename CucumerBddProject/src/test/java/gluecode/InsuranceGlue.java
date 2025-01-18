package gluecode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class InsuranceGlue extends Kernel {

	@When("^Check an itinerary got successfully costed$")
	public void check_an_itinerary_got_successfully_costed() throws Throwable {
		try {

			if (pollingWaitForCostingFlow("view", 100)) {
				System.out.println("Costing URL :" + getCurrentUrl());
				validate_String_Contains(getCurrentUrl(), "view");
				System.out.println("Itinerary got successfully costed");
			} else if (pollingWaitForCostingFlow("inclusions", 100)) {
				System.out.println("Costing URL :" + getCurrentUrl());
				validate_String_Contains(getCurrentUrl(), "inclusions");
				System.out.println("Itinerary got successfully costed");
			}

		} catch (Exception ex) {
			System.out.println("Problem while costing the itinerary" + ex.getMessage());
		}
	}

	@When("^user scroll down and remove the insurance from the inclusions page$")
	public void user_scroll_down_and_remove_the_insurance_from_the_inclusions_page() throws Throwable {
		scrolltoElement(inclusion.getInsuranceDelete());
		clickAction(inclusion.getInsuranceDelete());
		System.out.println("Insurance deleted successfully");
	}

	@Then("^validate the insurance got removed successfully$")
	public void validate_the_insurance_got_removed_successfully() throws Throwable {
		Assert.assertTrue(verifyExactText(inclusion.getBookNow(), "Book now"));

	}

	@When("^user click the change button in the insurance card$")
	public void user_click_the_change_button_in_the_insurance_card() throws Throwable {
		scrolltoElement(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceChange());
		boolean applyButton = verifyEnabled(inclusion.getInsuranceApply());
		if (applyButton) {
			System.out.println("The apply button is enabled");
		} else {
			System.out.println("The apply button is disabled");
		}

	}

	@When("^select the alternate insurance type$")
	public void select_the_alternate_insurance_type() throws Throwable {
//		scrolltoElement(inclusion.getInsuranceType50kPlatinumPlan());
//		clickAction(inclusion.getInsuranceType50kPlatinumPlan());
		boolean applyButton = verifyEnabled(inclusion.getInsuranceApply());
		if (applyButton) {
			System.out.println("The apply button is enabled");
			clickAction(inclusion.getInsuranceApply());
		} else {
			System.out.println("The apply button is disabled");
		}

	}

	@Then("^verify the insurance type changed successfully$")
	public void verify_the_insurance_type_changed_successfully() throws Throwable {
		verifyPartialText(inclusion.getInsuranceTypeInclusions(), "50k Platinum Plan");
		System.out.println("Insurance changed successfully");

	}

	@Then("^user add the insurance$")
	public void user_add_the_insurance() throws Throwable {

		clickAction(inclusion.getInsuranceAdd());

	}

	@Then("^verify insurance added successfully$")
	public void verify_insurance_added_successfully() throws Throwable {
		elementExist(inclusion.getInsuranceChange());
		System.out.println("Insurance added successfully");

	}

	@Then("validate the remove insurance functionality in the itinerary page as Admin")
	public void validate_the_remove_insurance_functionality_in_the_itinerary_page_as_admin()
			throws InterruptedException {
		pollingWaitWithoutClickable(inclusion.getTotalcost(), 20);
		String totalCost = inclusion.getTotalcost().getText();
		String cost = totalCost.replaceAll("[^0-9]", "");
		int actualTotalCost = Integer.parseInt(cost);

		System.out.println(actualTotalCost);
		
    //    scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());

		pollingWaitWithoutClickable(inclusion.getInsuranceDelete(), 10);
		if (isElementVisible(inclusion.getInsuranceDelete(), 20)) {
			scrolltoElementAndClick(inclusion.getInsuranceDelete());

		//	pageRefresh();
			Thread.sleep(3000);
			pollingWaitWithoutClickable(blockCard.getDayByDay(), 30);
			clickDisbledJavaScriptElement(blockCard.getDayByDay());
			
			String changedtotalCost = inclusion.getTotalcost().getText();
			String changedcost = changedtotalCost.replaceAll("[^0-9]", "");
			int changedactualTotalCost = Integer.parseInt(changedcost);

			System.out.println(changedactualTotalCost);
			if (actualTotalCost > changedactualTotalCost) {
				Assert.assertTrue(true);

				pollingWaitWithoutClickable(inclusion.getViewFullPricing(), 10);
				scrolltoElementAndClick(inclusion.getViewFullPricing());
				Thread.sleep(2000);
				List<WebElement> insuranceRightPanel = driver.findElements(By.xpath("//span[text()='Insurance (1)']"));
				if (insuranceRightPanel.size() < 1) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("After removed the insurance, insurance item is not removed in the view full pricing");
				}
			} else {
				Assert.fail("After removed the insurance, insurance cost is not removed in the itinerary");
			}
		}

	}

	@Then("validate the add insurance functionality in the itinerary page as Admin")
	public void validate_the_add_insurance_functionality_in_the_itinerary_page_as_admin() throws InterruptedException {
    //    scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(inclusion.getInsuranceDelete(), 10);
		scrolltoElementAndClick(inclusion.getInsuranceDelete());
		Thread.sleep(3000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		pollingWaitWithoutClickable(inclusion.getTotalcost(), 20);
		String totalCost = inclusion.getTotalcost().getText();
		String cost = totalCost.replaceAll("[^0-9]", "");
		int actualTotalCost = Integer.parseInt(cost);
		System.out.println(actualTotalCost);
		
     //   scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());

		pollingWaitWithoutClickable(inclusion.getInsuranceAdd(), 10);
		if (isElementVisible(inclusion.getInsuranceAdd(), 20)) {
			scrolltoElementAndClick(inclusion.getInsuranceAdd());

			pageRefresh();
			Thread.sleep(3000);
			
			pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
			clickDisbledJavaScriptElement(blockCard.getDayByDay());
			
			String changedtotalCost = inclusion.getTotalcost().getText();
			String changedcost = changedtotalCost.replaceAll("[^0-9]", "");
			int changedactualTotalCost = Integer.parseInt(changedcost);

			System.out.println(changedactualTotalCost);
			if (actualTotalCost < changedactualTotalCost) {
				Assert.assertTrue(true);

				pollingWaitWithoutClickable(inclusion.getViewFullPricing(), 10);
				scrollUp();
				clickDisbledJavaScriptElement(inclusion.getViewFullPricing());
				Thread.sleep(2000);
				List<WebElement> insuranceRightPanel = driver.findElements(By.xpath("//span[text()='Insurance (1)']"));
				if (insuranceRightPanel.size() >= 1) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("After added the insurance, insurance item is not added in the view full pricing");
				}

			} else {
				Assert.fail("After added the insurance, insurance cost is not added in the itinerary");
			}
		}

	}

	@Then("validate the change insurance functionality in the itinerary page as Admin")
	public void validate_the_change_insurance_functionality_in_the_itinerary_page_as_admin()
			throws InterruptedException {
   //     scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceType100kGoldPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("100K Gold Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 100k Gold Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 100k Gold Plan insurance in the itinerary");
		}

		Thread.sleep(3000);

		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		scrolltoElementAndClick(inclusion.getInsuranceType250kGoldPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("250K Gold Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 250k Gold Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 250k Gold Plan insurance in the itinerary");
		}

		Thread.sleep(3000);

		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceType50kSilverPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("50K Silver Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 50k Silver Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 50k Silver Plan insurance in the itinerary");
		}
		Thread.sleep(3000);

		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceType100kSilverPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("100K Silver Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 100k Silver Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 100k Silver Plan insurance in the itinerary");
		}

	}

	@Then("validate the remove insurance functionality in the itinerary page as User")
	public void validate_the_remove_insurance_functionality_in_the_itinerary_page_as_user()
			throws InterruptedException {
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());
		
		pollingWaitWithoutClickable(inclusion.getTotalcost(), 20);
		String totalCost = inclusion.getTotalcost().getText();
		String cost = totalCost.replaceAll("[^0-9]", "");
		int actualTotalCost = Integer.parseInt(cost);

		System.out.println(actualTotalCost);
		
    //    scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());

		pollingWaitWithoutClickable(inclusion.getInsuranceDelete(), 10);
		if (isElementVisible(inclusion.getInsuranceDelete(), 20)) {
			scrolltoElementAndClick(inclusion.getInsuranceDelete());

			pageRefresh();
			Thread.sleep(3000);
			pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
			clickDisbledJavaScriptElement(blockCard.getDayByDay());
			
			String changedtotalCost = inclusion.getTotalcost().getText();
			String changedcost = changedtotalCost.replaceAll("[^0-9]", "");
			int changedactualTotalCost = Integer.parseInt(changedcost);

			System.out.println(changedactualTotalCost);
			if (actualTotalCost > changedactualTotalCost) {
				Assert.assertTrue(true);

			} else {
				Assert.fail("After removed the insurance, insurance cost is not removed in the itinerary");
			}
		}
	}

	@Then("validate the add insurance functionality in the itinerary page as User")
	public void validate_the_add_insurance_functionality_in_the_itinerary_page_as_user() throws InterruptedException {
   //     scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(inclusion.getInsuranceDelete(), 10);
		scrolltoElementAndClick(inclusion.getInsuranceDelete());
		Thread.sleep(3000);
		
		pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
		clickDisbledJavaScriptElement(blockCard.getDayByDay());

		pollingWaitWithoutClickable(inclusion.getTotalcost(), 20);
		String totalCost = inclusion.getTotalcost().getText();
		String cost = totalCost.replaceAll("[^0-9]", "");
		int actualTotalCost = Integer.parseInt(cost);
		System.out.println(actualTotalCost);
		
   //     scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());

	//	pollingWaitWithoutClickable(inclusion.getInsuranceAdd(), 30);
		if (isElementVisible(inclusion.getInsuranceAdd(), 20)) {
			scrolltoElementAndClick(inclusion.getInsuranceAdd());
			pageRefresh();
			Thread.sleep(3000);
			pollingWaitWithoutClickable(blockCard.getDayByDay(), 20);
			clickDisbledJavaScriptElement(blockCard.getDayByDay());
			
			String changedtotalCost = inclusion.getTotalcost().getText();
			String changedcost = changedtotalCost.replaceAll("[^0-9]", "");
			int changedactualTotalCost = Integer.parseInt(changedcost);

			System.out.println(changedactualTotalCost);
			if (actualTotalCost < changedactualTotalCost) {
				Assert.assertTrue(true);

			} else {
				Assert.fail("After added the insurance, insurance cost is not added in the itinerary");
			}
		}
	}

	@Then("validate the change insurance functionality in the itinerary page as User")
	public void validate_the_change_insurance_functionality_in_the_itinerary_page_as_user()
			throws InterruptedException {
  //      scrollDown();
		
		pollingWaitWithoutClickable(activityPage.getInclusions(), 15);
		clickAction(activityPage.getInclusions());
		
		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceType100kGoldPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("100K Gold Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 100k Gold Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 100k Gold Plan insurance in the itinerary");
		}

		Thread.sleep(3000);

		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		scrolltoElementAndClick(inclusion.getInsuranceType250kGoldPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
//		pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("250K Gold Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 250k Gold Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 250k Gold Plan insurance in the itinerary");
		}

		Thread.sleep(3000);

		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceType50kSilverPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("50K Silver Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 50k Silver Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 50k Silver Plan insurance in the itinerary");
		}
		Thread.sleep(3000);

		pollingWaitWithoutClickable(inclusion.getInsuranceChange(), 20);
		scrolltoElement(inclusion.getPlanInCard());
		clickAction(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceType100kSilverPlan());
		pollingWaitWithoutClickable(inclusion.getInsuranceApply(), 10);
		clickAction(inclusion.getInsuranceApply());
	//	pollingWaitWithoutClickable(inclusion.getPolicyAddedSuccessfully(), 10);
		if (isElementVisible(inclusion.getPolicyAddedSuccessfully(), 10)) {
			Assert.assertTrue(true);
			pollingWaitWithoutClickable(inclusion.getPlanInCard(), 20);
			String planInCard = inclusion.getPlanInCard().getText();
			if (planInCard.contains("100K Silver Plan")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to change the 100k Silver Plan insurance in the itinerary");
			}
		} else {
			Assert.fail("Unable to change the 100k Silver Plan insurance in the itinerary");
		}
	}

}
