package gluecode;



import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class Custom extends Kernel{
	



    @Then("User clicks the custom block card button")
    public void user_clicks_the_custom_block_card_button() {
       
    	
		try {
			hoverWebelement(activityPage.getInclusions());
			clickAction(activityPage.getInclusions());
			scrolltoElementAndClick(custom1.getAddCustomItem());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    	
    }

    @Then("User is on the custom block card page")
    public void user_is_on_the_custom_block_card_page() {
    	//if needed will add
    	Validate_user_is_in_addingcustom_blockcard();
    	//hope this is ok
		assertTrue(custom1.getAddCustomItem().isDisplayed());

        System.out.println("User is on the custom block card page");
        
    }

    @When("User enters the title")
    public void user_enters_the_title() {
    	
		try {
			pollingWaitWithoutClickable(custom1.getCardTitle(), 20);
			clickDisbledJavaScriptElement(custom1.getCardTitle());
			typeText(customcard.getCardTitle(), "Test Activity Custom Card");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    	
    }

    @And("User selects the source as {string}")
    public void user_selects_the_source_as(String source) {
    	try {
    		pollingWaitWithoutClickable(custom1.getSource(), 10);
    		clickAction(custom1.getSource());

    		Thread.sleep(1000);

    		clickDisbledJavaScriptElement(custom1.getViaSourceExpedia());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        System.out.println("Selecting source: " + source);
        // Add logic to select the source
    }

    @And("User enters the description")
    public void user_enters_the_description() {
        System.out.println("Entering the description");
        // Add logic to enter the description
    }

    @And("User selects the entity as {string}")
    public void user_selects_the_entity_as(String entity) {
        System.out.println("Selecting entity: " + entity);
        // Add logic to select the entity
    }

    @And("User enters the our cost and published cost")
    public void user_enters_the_our_cost_and_published_cost() {
    	typeText(custom1.getOurCost(), "10000");

		typeText(custom1.getPublishedCost(), "12000");
    }

    @And("User selects the reason for the block card as {string}")
    public void user_selects_the_reason_for_the_block_card_as(String reason) {
    	try {
			clickAction(custom1.getReason());
			Thread.sleep(1000);
			clickDisbledJavaScriptElement(custom1.getReasonOption());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @And("User enters the date")
    public void user_enters_the_date() {
        System.out.println("Entering the date");
        // Add logic to enter the date
    }

    @And("User enters the fee")
    public void user_enters_the_fee() {
    	typeText(custom1.getFee(), "12000");
    }	

    @And("clicks on the save and create button")
    public void clicks_on_the_save_and_create_button() {
        System.out.println("Clicking on save and create button");
        // Add logic to click the save and create button
    }

    @Then("The card should be created successfully")
    public void the_card_should_be_created_successfully() {
        System.out.println("Card created successfully");
        // Add logic to verify the card creation
    }

}
