package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pyt.pages.BookingReviewPage;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class PackagesShortHandFlowGlue extends Kernel {

	public static String packagesUrl = "";

	@Then("^Select an itinerary title and verify the uncosted page is displaying$")
	public void select_an_itinerary_title_and_verify_the_uncosted_page_is_displaying() throws Throwable {
		clickAction(packagesPage.getPackageTitle());
		switchWindows();
		validateAssertion(elementDisplayed(packagesPage.getDayByDayPlan()));
		validateAssertion(elementDisplayed(booingReview.getUnlockPrice()));
	}

	@Then("^unlock and cost the itineary and validate the itinerary page$")
	public void unlock_and_cost_the_itineary_and_validate_the_itinerary_page() throws Throwable {
		clickAction(booingReview.getUnlockPrice());
		fillMandatoryInfoInGCM();
		pollingWaitForCostingFlow("view", 50);
		Thread.sleep(2000);
		validateAssertion(elementDisplayed(packagesPage.getDayByDayPlan()));
		validateAssertion(elementDisplayed(booingReview.getbookNowButton()));
	}
	
	@Then("^Click on a resort card for the category in andaman \"([^\"]*)\"$")
	public void click_on_a_resort_card_for_the_category_in_andaman(String category) throws Throwable {
		scroll();
     	switch(category)
		{
		case "Recommended for you":
			scrolltoElement(amDomestic.getAmRecommendedForYou());
			clickAction(amDomestic.getAmRecommendedForYou());
			break;
		case "For a romantic holiday":
			scrolltoElement(amDomestic.getAmForRomanticHoliday());
			clickAction(amDomestic.getAmForRomanticHoliday());
			break;
		case "Family vacations":
			scrolltoElement(amDomestic.getAmFamilyVacation());
			clickAction(amDomestic.getAmFamilyVacation());
			break;
		case "Nature & adventure ":
			scrolltoElement(amDomestic.getAmNatureAdventure());
			clickAction(amDomestic.getAmNatureAdventure());
			break;
		}
	}
	
	@Then("^Check the inclusion page of andaman itinerary from listing page$")
	public void check_the_inclusion_page_of_andaman_itinerary_from_listing_page() throws Throwable {
		try {
	    	WebElement costingAnimation = driver.findElement(By.xpath("//div[@class='delay-video']"));
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.invisibilityOf(costingAnimation));
	    	List<WebElement> resorts = driver.findElements(By.xpath("//section[contains(@class,'CardComponentWrapper')]"));
	    	int listingpagesize = resorts.size();
	    	System.out.println("listingpagesize---"+listingpagesize);
	    	if(listingpagesize>0) {
	    	clickAction(amDomestic.getAmItineraryCardInListingPage());
      		Thread.sleep(10000);
	    		switchWindows();
	    		String url = driver.getCurrentUrl();
	    		System.out.println("url---"+url);
	    		validateAssertion(url.contains("an/view"));
	}
	    	else {
	    		validateAssertion(elementDisplayed(driver.findElement(By.xpath("//section[@class='no-resorts']"))));
	    	}
	    	
	    }
	
	    catch (Exception ex) {
	    	ex.printStackTrace();
		}
	}
	
	@Then("^Verify that domestic landing page is loaded as expected$")
	public void verify_that_domestic_landing_page_is_loaded_as_expected() throws Throwable {
		validateAssertion(getCurrentUrl().contains("andaman-tour-packages"));
		System.out.println(" Domestic andaman landing page loaded successfully");
	}
	
	@Then("^navigate to short hand flow packages page for \"([^\"]*)\"$")
	public void navigate_to_short_hand_flow_packages_page_for(String region) throws Throwable {
	    
		String currentUrl = driver.getCurrentUrl();
		packagesUrl = currentUrl+"packages/"+region;
		driver.navigate().to(packagesUrl);
	}

}
