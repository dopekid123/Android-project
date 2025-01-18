package gluecode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class StaycationsdetailsGlue extends Kernel {
	
	
	public static int defaultnightCount;
	public static int defaultnightunderbookdealcount;
	public static String defaultnightafter;

	
	@Then("^Navigate to respective \"([^\"]*)\" via URL$")
	public void navigate_to_respective_via_URL(String deals) throws Throwable {
	   
		Thread.sleep(1000);
		System.out.println(deals);
		driver.get(localEnvUrl+"deals/"+deals);
		
	}


	
	
	
	
	
	@Then("^Select the \"([^\"]*)\" from best-staycation deals listing page$")
	public void select_the_from_best_staycation_deals_listing_page(String deals) throws Throwable {
		Thread.sleep(1000);
		driver.get(localEnvUrl + "deals");
//		Thread.sleep(2000);
//		WebElement dealslink = driver.findElement(By.xpath("//span[contains(text(),'" + deals + "')]"));
//		clickAction(dealslink);
		switchWindows();
	}

	@Then("^validate whether the deal is customizable deal or not$")
	public void validate_whether_the_deal_is_customizable_deal_or_not() throws Throwable {
//		driver.navigate().refresh();
//		Thread.sleep(1000);
//		scrollToView(sDetails.getwhatsIncluded());     
//		validateAssertion(elementDisplayed(sDetails.getNightsDropdown()));
		if (elementDisplayed(sDetails.getNightsDropdown())) {
			validateAssertion(elementDisplayed(sDetails.getNightsDropdown()));
			System.out.println("The selected deal is a customizable - contains night option");
		} else {

//			elementNotExist(sDetails.getNightsDropdown());
			System.out.println("The selected deal is not an customizable deal");
			Assert.assertFalse(elementDisplayed(sDetails.getNightsDropdown()));
//			validateAssertion() != true);

		}

	}

	@Then("^Change the default night option on the current room option$")
	public void change_the_default_night_option_on_the_current_room_option() throws Throwable {
	   
		try {
		if(verifyIsDisabled(sDetails.getDefaultRoomNightInput())== false) {
			
			String defaultnightbefore = driver.findElement(By.xpath("(//section[@name='deals-inclusions']//div[@label='Number of nights']//p)[1]")).getText();
			System.out.println("defaultnightbefore---"+defaultnightbefore);
			int defaultnightbeforeselection = Integer.parseInt(defaultnightbefore.replaceAll("[^0-9]", ""));
			System.out.println("defaultnightbeforeselection--- " + defaultnightbeforeselection);
			
//			clickAction(sDetails.getDefaultRoomNightInput());
			WebElement nightsDropdown = driver.findElement(By.xpath("//section[@name='deals-inclusions']//div[@label='Number of nights']"));
			   clickAction(nightsDropdown);
//			   Thread.sleep(2000);
		
			List<WebElement> nights = driver
					.findElements(By.xpath("//div[@id='modal-root']//div[1]//div[contains(@name,'nights')]"));
			System.out.println(nights.size());
			for (int i = 0; i < nights.size(); i++) {
				String nightList = nights.get(i).getText();
				System.out.println("nightList---" +nightList);
				int nightCountListValue = Integer.parseInt(nightList.replaceAll("[^0-9]", ""));
				System.out.println("nightCountListValue--"+nightCountListValue);
				System.out.println("defaultnightbeforeselection--"+defaultnightbeforeselection);
				if(nightCountListValue!=defaultnightbeforeselection) {
					nights.get(i).click();
					break;
				}
			}
			
			defaultnightafter = driver.findElement(By.xpath("(//section[@name='deals-inclusions']//div[@label='Number of nights']//p)[1]")).getText();
		      System.out.println("defaultnightafter=="+defaultnightafter);
		      System.out.println("defaultnightbefore==="+defaultnightbefore);
				validateAssertion(!defaultnightbefore.equals(defaultnightafter));
		}
		else {
			System.out.println("There is no night option for default room selected");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	}

		
	@Then("^validate the nights under bookdeal card and hotel card are similar$")
	public void validate_the_nights_under_bookdeal_card_and_hotel_card_are_similar(String selection) throws Throwable {
		
		
		if(selection.equals("room-upgrade")) {
			
		String nightonhotelcard =	driver.findElement(By.xpath("//section[@name='"+selection+"']//p[@class='sc-kAzzGY dEgine']")).getText();
		String[] nightonhotelcardparts = nightonhotelcard.split("-");
		String nightonhotelcardcount = nightonhotelcardparts[1];
		System.out.println("nightonhotelcardcount---"+nightonhotelcardcount);
		validateAssertion(defaultnightafter.equals(nightonhotelcardcount));
		clickAction(sDetails.getSelectRoomButton());
		Thread.sleep(6000);
		
		}
		
		
		String defaultnight = driver.findElement(By.xpath("((//div[@label='Number of nights'])[1]//p)[1]")).getText();
		defaultnightCount = Integer.parseInt(defaultnight.replaceAll("[^0-9]", ""));
		
		System.out.println("defaultnight--- " + defaultnightCount);
		
		Thread.sleep(2000);

		String defaultnightunderbookdeal = driver.findElement(By.xpath("//strong[@itemprop='highPrice']//span"))
				.getText();
        int defaultnightunderbookdealcount = Integer.parseInt(defaultnightunderbookdeal.replaceAll("[^0-9]", ""));
		System.out.println("defaultnightunderbookdealcount--- " + defaultnightunderbookdealcount);

		validateAssertion(defaultnightCount == defaultnightunderbookdealcount);
	}

	
	@Then("^change the default room type with alternate room type$")
	public void change_the_default_room_type_with_alternate_room_type() throws Throwable {
		try {
			
		
		String alternateRoomTitle = sDetails.getAlternateRoomTitle().getText();
		System.out.println("alternateRoomTitle---"+alternateRoomTitle);
		
		String alternateRoomPrice = sDetails.getAlternateRoomPrice().getText();
		int alternateRoomPriceint = Integer.parseInt(alternateRoomPrice.replaceAll("[^0-9]", ""));
		System.out.println("alternateRoomPriceint--"+alternateRoomPriceint);
		
		
	    validateAssertion(elementDisplayed(sDetails.getRoomUpgradeDropdown()));
		clickAction(sDetails.getRoomUpgradeDropdown());
		Thread.sleep(1000);
		clickAction(sDetails.getSelectRoomButton());
		Thread.sleep(6000);
		
		String dealTotalPrice =	driver.findElement(By.xpath("//strong[@itemprop='highPrice']")).getText();
		System.out.println("dealTotalPrice---"+dealTotalPrice);
		String[] dealsplit= dealTotalPrice.split("\\*");
		String part0 = dealsplit[0];
		int dealTotalPriceint = Integer.parseInt(part0.replaceAll("[^0-9]", ""));
        System.out.println("dealTotalPriceint---"+dealTotalPriceint);
		
		String currentroomtitleafter = sDetails.getCurrentRoomTitle().getText();
		System.out.println("currentroomtitleafter---"+currentroomtitleafter);
		System.out.println("alternateRoomTitle---"+alternateRoomTitle);
		
        validateAssertion(alternateRoomTitle.equals(currentroomtitleafter));
        validateAssertion(dealTotalPriceint==alternateRoomPriceint);
		
		}
		catch (Exception e) {
			
			System.out.println("There are no room alternates for this room type");
		
		}
}

	
	@Then("^change the no\\.of\\.nights and validate the price got changed or not$")
	public void change_the_no_of_nights_and_validate_the_price_got_changed_or_not() throws Throwable {
	   
		String sidepanelpricetextbefore = sDetails.getsidePanelPrice().getText();
		int sidepanelpricebefore = Integer.parseInt(sidepanelpricetextbefore.replaceAll("[^0-9]", ""));		
		change_the_default_night_option_on_the_current_room_option();
		String sidepanelpricetextafter = sDetails.getsidePanelPrice().getText();
		int sidepanelpriceafter = Integer.parseInt(sidepanelpricetextafter.replaceAll("[^0-9]", ""));		
	validateAssertion(sidepanelpricebefore != sidepanelpriceafter);
	
	}

	
	
	





}
