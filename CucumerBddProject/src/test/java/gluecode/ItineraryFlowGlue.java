package gluecode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class ItineraryFlowGlue extends Kernel {

	@Then("^user validates the costing flow for \"([^\"]*)\"$")
	public void user_validates_the_costing_flow_for(String region) throws Throwable {

		System.out.println("Region : " + region);
		iternaryFlow(region);


	}
	
	@Given("^user validates the costing flow for \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_validates_the_costing_flow_for(String region, String cities) throws Throwable {
		iternaryFlowPdgCities(region,cities);
	}


	
	@Then("^user validates the costing flow for ferry \"([^\"]*)\"$")
	public void user_validates_the_costing_flow_for_ferry(String region) throws Throwable {

		System.out.println("Region : " + region);
		iternaryFlowForFerry(region);


	}
	
	@Given("^user validates the short hand destinatiom costing flow for \"([^\"]*)\"$")
	public void user_validates_the_short_hand_destinatiom_costing_flow_for(String region) throws Throwable {
	   
		System.out.println("Region : " + region);
		iternaryShortHandFlow(region);

	}


}
