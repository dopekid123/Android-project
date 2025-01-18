package gluecode;


import io.cucumber.java.en.Then;
import utils.Kernel;

public class GlobalPricingInclusionGlue extends Kernel {

	public static String currencycode;

	/*
	 * This method compares the currency code on inclusion page total cost with the
	 * actual destination currency strored on hashmap
	 * 
	 */

	@Then("^Validate the currency showing on inclusion is corresponding to the \"([^\"]*)\" selected$")
	public void validate_the_currency_showing_on_inclusion_is_corresponding_to_the_selected(String Destination) throws Throwable {
	    
		String currencyintotalprice = adminPrice.getTotalItineraryCost().getText().replaceAll("[0-9]", "").replace(",", "").trim();
		currencycode = currencymapping.get(Destination);
		validateAssertion(currencyintotalprice.equals(currencycode));
	}
	
	@Then("^Global user clicks the book now button$")
	public void global_user_clicks_the_book_now_button() throws Throwable {
		pollingWait(pdgtreco.waitForCosting(), 60);
		clickAction(pdgtreco.waitForCosting());
	}



}
