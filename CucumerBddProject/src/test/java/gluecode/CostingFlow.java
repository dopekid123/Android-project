package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class CostingFlow extends Kernel {

	// Validate the costing time period for 100 seconds

	@Then("^user validates the costing time period for \"([^\"]*)\"$")
	public void user_validates_the_costing_time_period_for(String region) throws Throwable {
		
		try
		{
		/*
		 * Commented on 05/07/21 by Nirmal
		 * 
		WebElement costingAnimation = driver.findElement(By.xpath("//div[contains(@class,'animation-holder')]"));
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOf(costingAnimation));
		
		*/
		
//		pollingWait(lp.getSubMenu(), 120);
			
		if( region.equals("Singapore") || region.equals("Switzerland") ) {
			
			/*
			 * Sharmila - July 11 - In product flow has been changed
			 * Short haul flow - without selecting cities - SINGAPORE,SWITZERLAND
			 * short haul flow - select cities list are given below
			 * Bali
               Thailand
               Bali + Thailand
               Malaysia
               Thailand + Malaysia
               Thailand + Singapore + Malaysia
               Bali + Malaysia
               UAE
			 */
			pollingWaitForCostingFlow("view",250);
			pollingWait(intpag.getMorePill(), 20);
//			Thread.sleep(2000);
			clickAction(intpag.getMorePill());
			validate_String_Contains(getCurrentUrl(), "inclusions");
		}
		else {
			pollingWaitForCostingFlow("inclusions",120);
        validate_String_Contains(getCurrentUrl(), "inclusions");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//User able to login from single destination GCM page with existing user account

	@Then("^user login with \"([^\"]*)\" and \"([^\"]*)\" for single destination$")
	public void user_login_with_and_for_single_destination(String uName, String passwd) throws Throwable {
	   if(elementDisplayed(lp.getToggleButton())) {
		clickAction(lp.getToggleButton());
	   }
	   validateAssertion(singleDestinationLogin(uName, passwd));
	}
	
	
	
	
}
