package gluecode;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.Kernel;

public class HolidayPackagesGlue extends Kernel{
	
	String packageUrl="";
	
	/*
	 * Method to navigate to different Packages Page based on URL
	 */
	
	@And("^user navigates to the \"([^\"]*)\" page$")
	@Given("^User navigates to the \"([^\"]*)\" page$")
	public void user_navigates_to_the_page(String arg1) {
		try
		{
		navigateToUrl(localEnvUrl+arg1);
		packageUrl=getCurrentUrl();
		validate_String_Contains(getCurrentUrl(),arg1);
		//pollingWait(gdropdown.getGlobalIcon(), 30);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
			
		}
	}
	
	@And("^click on the first package itinerary through \"([^\"]*)\" and costs with \"([^\"]*)\"$")
	public void click_on_the_first_package_itinerary_through_and_costs_with(String clickOn, String departFrom) throws Throwable {
		try
		{
			if(clickOn.equalsIgnoreCase("customise"))
			{
				waitForMe(packagesPage.getfirstPackageCustomize());
				scrolltoElement(packagesPage.getfirstPackageCustomize());
				Thread.sleep(3000);
				clickJavaScriptElement(packagesPage.getfirstPackageCustomize());
				
//				if (elementDisplayed(icm.getDepatureCityPackagesGcm())) 
				if (elementDisplayed(icm.getDeparturecalendarpicker())) 
				{
						fillMandatoryInfoInPackageGCMWithDepartFrom(departFrom);
					}

				}
				
			else if(clickOn.equalsIgnoreCase("Send Enquiry")) {
				
				waitForMe(packagesPage.getfirstPackageSendEnquiry());
				scrolltoElement(packagesPage.getfirstPackageSendEnquiry());
//				Thread.sleep(3000);
				clickJavaScriptElement(packagesPage.getfirstPackageSendEnquiry());
//				if (elementDisplayed(icm.getDepatureCityPackagesGcm())) 
				if (elementDisplayed(icm.getDeparturecalendarpicker())) 
				{
					fillMandatoryInfoInPackageGCMWithDepartFrom(departFrom);
					}

				}
			else if(clickOn.equalsIgnoreCase("slug"))
			{
				waitForMe(packagesPage.getfirstPackageSlug());
				scrolltoElement(packagesPage.getfirstPackageSlug());
//				Thread.sleep(3000);
				clickJavaScriptElement(packagesPage.getfirstPackageSlug());
				switchWindows();
				pollingWait(icm.getcalculateTripCostButton(), 30);
				if(packageUrl.contains("maldives"))
				{
					navigateGcmFlowWithDepartFromForMaldives(departFrom);
				}
				else
				{
					navigateGcmFlowWithDepartFrom(departFrom);
				}
			}
			else if(clickOn.equalsIgnoreCase("slugNewTab"))
			{
				waitForMe(packagesPage.getfirstPackageSlug());
				scrolltoElement(packagesPage.getfirstPackageSlug());
//				Thread.sleep(3000);
				openInNewTab(packagesPage.getfirstPackageSlug());
//				switchWindows();
				pollingWait(icm.getcalculateTripCostButton(), 30);
				if(packageUrl.contains("maldives"))
				{
					navigateGcmFlowWithDepartFromForMaldives(departFrom);
				}
				else
				{
					navigateGcmFlowWithDepartFrom(departFrom);
				}
			}
			else if (clickOn.equalsIgnoreCase("slugCBR"))
			{
				waitForMe(packagesPage.getfirstPackageSlug());
				scrolltoElement(packagesPage.getfirstPackageSlug());
//				Thread.sleep(3000);
				clickJavaScriptElement(packagesPage.getfirstPackageSlug());
				switchWindows();
				pollingWait(icm.getcalculateTripCostButton(), 30);
				popupClosure();
				clickAction(cbr.getItineraryTravelCons(),"User clicks on inclusions page CBR");
				pollingWait(sp.getEmail(), 15);
			}
			else if (clickOn.equalsIgnoreCase("slugCBRNewTab"))
			{
				waitForMe(packagesPage.getfirstPackageSlug());
				scrolltoElement(packagesPage.getfirstPackageSlug());
				openInNewTab(packagesPage.getfirstPackageSlug());
				Thread.sleep(2000);
				pollingWait(icm.getcalculateTripCostButton(), 30);
				popupClosure();
				clickAction(cbr.getItineraryTravelCons(),"User clicks on inclusions page CBR");
				pollingWait(sp.getEmail(), 15);
			}
			else if (clickOn.equalsIgnoreCase("customizeUncosted"))
			{
				waitForMe(packagesPage.getfirstPackageCustomize());
				scrolltoElement(packagesPage.getfirstPackageCustomize());
				clickJavaScriptElement(packagesPage.getfirstPackageCustomize());
				switchWindows();
				pollingWait(icm.getcalculateTripCostButton(), 30);
				if(packageUrl.contains("maldives"))
				{
					navigateGcmFlowWithDepartFromForMaldives(departFrom);
				}
				else
				{
					navigateGcmFlowWithDepartFrom(departFrom);
				}
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
		
	}

}
