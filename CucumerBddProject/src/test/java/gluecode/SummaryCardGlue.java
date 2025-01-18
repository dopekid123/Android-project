package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class SummaryCardGlue extends Kernel {

	
	List<WebElement> summaryCard;
	List<WebElement> InclusionLineItemCard;
	
	@And("^get the inclusions of the itinerary in summary card$")
	public void get_the_inclusions_of_the_itinerary_in_summary_card() {
		
		 scrolltoElement(inclusion.getSummaryCardEntireSection());
		 summaryCard = driver.findElements(By.xpath("//h5[text()='Inclusions']/../ul/li"));
		 InclusionLineItemCard =driver.findElements(By.xpath("//div[contains(@class,'item-header')]//h4"));
		 
	}
	@Then("^compare the inclusions list aganist the inclusions page line item$")
	public void compare_the_inclusions_list_aganist_the_inclusions_page_line_item() {
		//section[contains(@class,'section-tab')]//a[contains(text(),'Flight')]/span
		  
	}
	
	@Then("^validate the android app link in the summary tab$")
	public void validate_the_android_app_link_in_the_summary_tab() throws Throwable {
		elementExist(inclusion.getSummaryCardEntireSection());
		scrolltoElement(inclusion.getAndroidAppLinkInclusion());
		clickAction(inclusion.getAndroidAppLinkInclusion(),"User clicks on the android app link from the summary card");
		switchWindows();
		validate_String_Contains(getCurrentUrl(),"https://play.google.com");
	}
	
	@Then("^validate the ios app link in the summary tab$")
	public void validate_the_ios_app_link_in_the_summary_tab() throws Throwable {
		elementExist(inclusion.getSummaryCardEntireSection());
		scrolltoElement(inclusion.getAndroidAppLinkInclusion());
		clickAction(inclusion.getIosAppLinkInclusions(),"User clicks on the ios app link from the summary card");
		switchWindows();
		validate_String_Contains(getCurrentUrl(),"apps.apple.com");	
	}
	
	}
	

