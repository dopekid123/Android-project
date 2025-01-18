package gluecode;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pyt.pages.PricingPage;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class AdminDiscountGlue extends Kernel{

	public int OldDealSizeOnDiscountPageInt = 0;
	public int DisOrBufferAmt = 10000; 
	public String newDealSizeAmtapplied = null;
	public int newDealSizeAmt = 0;
	public int newDealSizeAmtCalc = 0;
	public String tripCost = null;
	public int tripCostInt = 0;
	public String tcsPrice = null;
	public int tcsPriceInt = 0;
	public String gstPrice = null;
	public int gstPriceInt = 0;
	public int DealSize = 0;
	public int TotalCostOfTheItinerary =0;
	public int discAppliedTripCost = 0;
	public int discAppliedTotalCost = 0;
	public String totalCostPrice = null;
	public int totalCostPriceInt =0;
	public int NewTripCostAfterDisc = 0;
	
	
	@Then("^validate that the edit icon is showing for applying overall discount price$")
	public void validate_that_the_edit_icon_is_showing_for_applying_overall_discount_price() throws Throwable {

		try {

		Thread.sleep(1000);
		if (elementDisplayed(adminPrice.getOverallEditPriceIcon())) {
			clickAction(adminPrice.getOverallEditPriceIcon());
		}
		Thread.sleep(1000);
		validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));

	} catch (NoSuchElementException ex) {
		System.out.println("Discount icon is not available");
	}
		
		
	
	}
	

	@Then("^Fill the buffer form to add the buffer amount by entering new deal size$")
	public void fill_the_buffer_form_to_add_the_buffer_amount_by_entering_new_deal_size() throws Throwable {
	  
		
		clickAction(adminPrice.getAddBuffer());
		
        int newDealSizeAmtCalc = calculateNewDealSizeToBeApplied("Buffer");
		
		newDealSizeAmtapplied = Integer.toString(newDealSizeAmtCalc);
		String reason = "Adding buffer";
		String manager = "Dwaraka";
		
		addBufferOrDiscount(newDealSizeAmtapplied,reason,manager);	
		
		clickAction(adminPrice.getAddBufferCTA());
		NewTripCostAfterDisc = calculateNewTripCostAfterApplyingDiscount("Buffer");
		
	}


	
	
	public void addBufferOrDiscount(String newDealSizeAmtapplied, String reason, String manager) throws InterruptedException {
		
		
		clickAction(adminPrice.getNewDealSizeField());
		typeText(adminPrice.getNewDealSizeField(),newDealSizeAmtapplied);
		try {
			clickAction(adminPrice.getReasonField());
			WebElement reasonTxt = driver.findElement(By.xpath("(//div[text()='"+reason+"'])"));
			clickAction(reasonTxt);
			
			
			clickAction(adminPrice.getManagerField());
			WebElement managerTxt = driver.findElement(By.xpath("(//div[text()='"+manager+"'])"));
			clickAction(managerTxt);
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
	
	
	@Then("^Fill the discount form to apply discount by entering new deal size$")
	public void fill_the_discount_form_to_apply_discount_by_entering_new_deal_size() throws Throwable {
		
		clickAction(adminPrice.getAddDiscount());
		
		int newDealSizeAmtCalc = calculateNewDealSizeToBeApplied("Discount");
		
		newDealSizeAmtapplied = Integer.toString(newDealSizeAmtCalc);
		String reason = "Removing buffer"; //i.e.,Applying discount by removing previous buffer applied on the itinerary
		String manager = "Dwaraka";
		
		addBufferOrDiscount(newDealSizeAmtapplied,reason,manager);	
		
	      clickAction(adminPrice.getAddDiscountCTA());
	      NewTripCostAfterDisc = calculateNewTripCostAfterApplyingDiscount("Discount");
	}
	
	

	@Then("^validate the new deal size have been reflected after applying the discount or buffer$")
	public void validate_the_new_deal_size_have_been_reflected_after_applying_the_discount_or_buffer() throws Throwable {

		clickAction(adminPrice.getConfirmChangesCTA());
        Thread.sleep(2000);;
        
		String DealSize = driver
				.findElement(By.xpath("//div[contains(text(),'Deal size')]")).getText().replaceAll("[^0-9]", "");	
		
		validateAssertion(newDealSizeAmtapplied.equals(DealSize));
	
	
	}


	public int calculateNewDealSizeToBeApplied(String category) {
		
		String OldDealSizeOnDiscountPage = driver
				.findElement(By.xpath("//div[contains(text(),'Deal size')]")).getText().replaceAll("[^0-9]", "");
		
		OldDealSizeOnDiscountPageInt = Integer.parseInt(OldDealSizeOnDiscountPage);
		
		
		if(category.equals("Discount")) {
			
			newDealSizeAmt = OldDealSizeOnDiscountPageInt - DisOrBufferAmt;
			
			
		}
		else if(category.equals("Buffer")) {
			
			newDealSizeAmt = OldDealSizeOnDiscountPageInt + DisOrBufferAmt;
			
		}
		return newDealSizeAmt;
		 
		
	}
	
	
	public int calculateNewTripCostAfterApplyingDiscount(String category) {
	
	
      if(category.equals("Discount")) {
			
			discAppliedTripCost = tripCostInt - DisOrBufferAmt; //Manually calculating tripcost
			
		}
		else if(category.equals("Buffer")) {
			
			
			discAppliedTripCost = tripCostInt + DisOrBufferAmt; //Manually calculating tripcost
			
		}
		return discAppliedTripCost;
	
	
	}
	
	
	@Then("^Hover over the tooltip and fetch the Tripcost, TCS and GST price of the itinerary$")
	public void hover_over_the_tooltip_and_fetch_the_Tripcost_TCS_and_GST_price_of_the_itinerary() throws Throwable {

		
		Thread.sleep(3000);
		scrollUp();
		hoverWebelement(price.getPriceToolTip());
		
		//TripCost - Before Applying Discount
		
		tripCost = price.getTripCost().getText().replaceAll("[^0-9]", "");
		tripCostInt = Integer.parseInt(tripCost);
		
		
	
	    //TCS -  Before Applying Discount
		
		 tcsPrice = price.getTcsPrice().getText().replaceAll("[^0-9]", "");
		tcsPriceInt = Integer.parseInt(tcsPrice);
		
	
		//GST -  Before Applying Discount
		
		 if(driver.findElements(By.xpath("//span[contains(text(),'gst')]//following::span[1]")).size() > 0) {
    	 gstPrice = price.getGstPrice().getText().replaceAll("[^0-9]", "");
   	     gstPriceInt = Integer.parseInt(gstPrice);
       }
       else {
    	   gstPriceInt = 0;
       }
       
       //Deal Size formulae dealsize = tripcost + GST (Excluding TCS) - Before Applying Discount
       
       DealSize = tripCostInt + gstPriceInt;
      
        //Total Cost - Before Applying Discount
      
      TotalCostOfTheItinerary = DealSize + tcsPriceInt;
	}
	

	
	@Then("^Navigate back to inclusion page$")
	public void navigate_back_to_inclusion_page() throws Throwable {
	   driver.navigate().back();
	}

	@Then("^Validate that the applied discount or buffer has been applied on top of trip cost$")
	public void validate_that_the_applied_discount_or_buffer_has_been_applied_on_top_of_trip_cost() throws Throwable {
		
		
		
		Thread.sleep(2000);
		scrollUp();
		hoverWebelement(price.getPriceToolTip());
		
		
		tripCost = price.getTripCost().getText().replaceAll("[^0-9]", "");
	    tripCostInt = Integer.parseInt(tripCost);
	    
		
		validateAssertion(NewTripCostAfterDisc == tripCostInt);
		
		
		 tcsPrice = price.getTcsPrice().getText().replaceAll("[^0-9]", "");
			tcsPriceInt = Integer.parseInt(tcsPrice);
			
		
			 if(driver.findElements(By.xpath("//span[contains(text(),'gst')]//following::span[1]")).size() > 0) {
		    	 gstPrice = price.getGstPrice().getText().replaceAll("[^0-9]", "");
		   	     gstPriceInt = Integer.parseInt(gstPrice);
		       }
		       else {
		    	   gstPriceInt = 0;
		       }
			 
			
		
		
		
	}

	@Then("^After applying discount or buffer validate the total cost of the itinerary$")
	public void after_applying_discount_or_buffer_validate_the_total_cost_of_the_itinerary() throws Throwable {
	    
		
		 discAppliedTotalCost = discAppliedTripCost + tcsPriceInt + gstPriceInt;

		 waitForMe(price.getTotalCost());
		 Thread.sleep(1000);
		 totalCostPrice = price.getTotalCost().getText().replaceAll("[^0-9]", "");
		 Thread.sleep(1000);
		 totalCostPriceInt = Integer.parseInt(totalCostPrice);
		
			
		 validateAssertion(discAppliedTotalCost == totalCostPriceInt);
	
	}



}
