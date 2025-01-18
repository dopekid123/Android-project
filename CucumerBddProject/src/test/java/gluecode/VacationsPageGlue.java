package gluecode;

import com.pyt.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class VacationsPageGlue extends Kernel {
	
	
	@Given("^Scroll down and click Explore Australia button in the landing page$")
	public void scroll_down_and_click_Explore_Australia_button_in_the_landing_page() throws Throwable {
	    scrolltoElement(hp.goToAusPaidCampaignPage());
	    clickAction(hp.goToAusPaidCampaignPage());
	    switchWindows();

		
	}

	@When("^verify the user land on vacations page$")
	public void the_vacations_page_should_be_launched_for_Australia() throws Throwable {
		Thread.sleep(3000);
//		 elementDisplayed(packagesPage.getFirstPackage());
	  validate_String_Contains(getCurrentUrl(),"vacations");
	  
	  
	}

	 @Then("^click the pyt logo and validate the logo shouldn't be clickable$")
	 public void click_the_pyt_logo_and_validate_the_logo_should_not_be_clickable() throws Throwable{
	 clickAction(packagesPage.getVacationPagePytLogo(),"User clicks the Pyt logo from vacations page");
	 validate_String_Contains(getCurrentUrl(),"vacations");
	
  }

	@Then("^validate the PDG flow link from vacations page$")
	public void Validate_the_PDG_flow_link_from_vacations_page() throws Throwable {
	
		if(elementExist(packagesPage.getPdgFlowLinkFromPackage())){
			clickAction(packagesPage.getPdgFlowLinkFromPackage()," User clicks the Create your personalised itinerary button");
			validate_String_Contains(getCurrentUrl(),"customize/aus");
			
		}
		else
		{
			System.out.println("Create your personalised itinerary button is not present in the page ");
		}
		
	}
	@Then("^Validate the itinerary got costed successfully$")
	public void validate_the_itinerary_got_costed_successfully() throws Throwable {
	   String inclusion =  getCurrentUrl();
	   validateAssertion( inclusion.contains("inclusions"));
	   
	}
	
	@Then("verify the vacations page contains faq Section")
	public void verify_the_vacations_page_contains_faq_Section() {
		elementExist(packagesPage.getFaqSectionVacations());
	}
	

	@When("^redirect to vacations page$")
	public void redirect_to_vactions_page() throws Throwable {
		String url = driver.getCurrentUrl();
		navigateToUrl(url+"vacations/australia");
		validate_String_Contains(getCurrentUrl(),"vacations"); 
	}




	
	

}
