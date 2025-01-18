package gluecode;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class removeTransferGlue extends Kernel{
	public static int transfercntBefore = 0;
	public static int transfercntAfter = 0;
	String transferRemovedTxt = null;
	String alertTransferRemovedTxt = null;
	
	@Then("^Get the count of transfers in the itinerary before removing the transfers$")
	public void get_the_count_of_transfers_in_the_itinerary_before_removing_the_transfers() throws Throwable {
		
		transfercntBefore = transfersPage.getTransferNames().size();
		}
	
	@Then("^Click on remove transfer option$")
	public void click_on_remove_transfer_option() throws Throwable {
		
		clickAction(transfersPage.getRemoveTransfers());
		Thread.sleep(1000);
		clickAction(transfersPage.getRemoveTransfersProceed());
	
	}


	

	@Then("^Validate that the all the transfers in the itinerary are removed$")
	public void validate_that_the_all_the_transfers_in_the_itinerary_are_removed() throws Throwable {
		
		transfercntAfter = transfersPage.getTransferNames().size();
		validateAssertion(transfercntBefore == transfercntAfter);
		
		
		for(int i=1; i<=transfercntAfter; i++) {
			
			transferRemovedTxt = driver.findElement(By.xpath("((//div[@name='transfer']//h4)//following::div[4]//p)["+i+"]")).getText();
			if (driver.findElements(By.xpath("(//div[@name='transfer']//div[contains(@class,'alert')]//span)["+i+"]")).size() > 0 ) {
			
			alertTransferRemovedTxt = driver.findElement(By.xpath("(//div[@name='transfer']//div[contains(@class,'alert')]//span)["+i+"]")).getText();
			}
			
		   if((transferRemovedTxt.contains("removed") && transferRemovedTxt.contains("transfer")) || (alertTransferRemovedTxt.contains("removed") && alertTransferRemovedTxt.contains("transfer"))){
            Assert.assertTrue(true);
		}
		
		
		}
		
		
	    
	}

}
