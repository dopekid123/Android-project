package gluecode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class SEOChecksGlue extends Kernel{
	public static BufferedWriter csvWriter;
	public static String cellValue;
    public static List<WebElement> headerInterlinking = new ArrayList<>();
    public static List<WebElement> footerInterlinking = new ArrayList<>();
    Set<WebElement> duplicateFooterLinks= new HashSet<>();
    Set<WebElement> uniqueFooterLinks = new HashSet<>();
    Set<WebElement> uniqueHeaderLinks = new HashSet<>();
    Set<WebElement> duplicateHeaderLinks = new HashSet<>();
	
    @Given("Initialise the Output file {string}")
	public void initialise_the_output_file(String outputFile) {
		try
	    {
			deleteOutputFile(System.getProperty("user.dir")+File.separator+"seochecks"+File.separator+outputFile);
			
			//Creating and initialising the csv file
			FileWriter writer = new FileWriter(System.getProperty("user.dir")+ File.separator+"seochecks"+File.separator+outputFile, true);
			csvWriter = new BufferedWriter(writer);

			//Heading for the output csv file
			csvWriter.write("urls,FailureReason");
			csvWriter.newLine();

	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Problem while initialising the output file");
	    	ex.printStackTrace();
	    }
	}
    
    
	@Then("Validate whether Popup is displayed")
	public void validate_whether_popup_is_displayed() throws IOException {
		try
	    {
			
			
			
	    	//Waiting for the Popup to open
			Thread.sleep(12000);
	    	
			//Waiting for the CBR Title from CBR popup
			isElementVisible(seoChecks.getSeoCBRPopUpTitle(),20);
			
			if( ! isElementVisible(seoChecks.getSeoCBRPopUpTitle(), 15) ){
				cellValue=getCurrentUrl()+","+"CBR Popup Title is not displayed";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
			
			//Waiting for RCB button from CBR popup
			pollingWaitWithoutClickable(seoChecks.getSeoRcb(),15);
			
			if( ! isElementVisible(seoChecks.getSeoRcb(), 15) ){
				cellValue=getCurrentUrl()+","+"RCB button in CBR is not displayed";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
			
			//To close the RCB button
			pollingWaitWithoutClickable(seoChecks.getSeoRcbClose(), 10);
			clickAction(seoChecks.getSeoRcbClose());
			
			System.out.println("Displayed and closed the popup");
			Thread.sleep(3000);
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Problem in displaying the popup");
	    	cellValue=getCurrentUrl()+","+"CBR Popup did not open";
			csvWriter.write(cellValue);
			csvWriter.newLine();
	    	ex.printStackTrace();
	    }
	}
	
	@Then("Validate whether Meta tags are present")
	public void validate_whether_meta_tags_are_present() throws IOException {
	    try
	    {
	    	//Waiting for the title tag
//	    	isElementVisible(seoChecks.getSeoTitle(),15);
			
//			if( ! isElementVisible(seoChecks.getSeoTitle(), 15) ){
			if( driver.findElements(By.xpath("//title")).size() < 0 ){

				cellValue=getCurrentUrl()+","+"Title is not present";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
			
	    	//Waiting for the h1 tag
//			isElementVisible(seoChecks.getSeoH1(),15);
			
//			if( ! isElementVisible(seoChecks.getSeoH1(), 15) ){
			if( driver.findElements(By.xpath("//h1")).size() < 0 ){
				cellValue=getCurrentUrl()+","+"H1 tag is not present";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}

			
	    	//Waiting for the meta tag
//			isElementVisible(seoChecks.getSeoMeta(),15);
			
//			if( ! isElementVisible(seoChecks.getSeoMeta(), 15) ){
			if( driver.findElements(By.xpath("//head/meta[@name='description']")).size() < 0 ){
				cellValue=getCurrentUrl()+","+"Meta tag is not present";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Problem while validating title, h1 and meta tags");
	    	cellValue=getCurrentUrl()+","+"Problem while validating title, h1 and meta tags";
			csvWriter.write(cellValue);
			csvWriter.newLine();
	    	ex.printStackTrace();
	    }
	}
	
	
	@Then("Validate whether Canonical is present")
	public void validate_whether_canonical_is_present() throws IOException {
		
		try
		{
			//Waiting for the canonical tag
//			isElementVisible(seoChecks.getSeoCanonical(),15);
			
//			String urlValue=getAttribute(seoChecks.getSeoCanonical(), "href" );
			WebElement val = driver.findElement(By.xpath("//link[@rel='canonical']"));
			String urlValue=val.getAttribute("href");
			System.out.println("Canonical-->"+urlValue);
			System.out.println("get current url-->"+getCurrentUrl());

			
			if(! getCurrentUrl().equalsIgnoreCase(urlValue))
			{
				cellValue=getCurrentUrl()+","+"Canonical url ("+urlValue+") is different from "+getCurrentUrl();
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Problem while validating Canonical tag");
			cellValue=getCurrentUrl()+","+"Problem while validating Canonical tag";
			csvWriter.write(cellValue);
			csvWriter.newLine();
			ex.printStackTrace();
		}
	
	}
	
	
	@Then("Validate whether CTAs are present")
	public void validate_whether_ct_as_pdg_view_details_call_now_gcm_are_present() throws IOException {
		try
		{
			
			/*
			 * Validating the Request Call Back
			 */
			if (driver.findElements(By.xpath("(//span[text()='Request call back'])[1]")).size() > 0)
			{
				clickAction(cbr.getRequestCallbackCTA());
				
				//Waiting for the CBR Title from CBR popup
				pollingWaitWithoutClickable(seoChecks.getSeoCBRPopUpTitle(),15);
				
				if( ! isElementVisible(seoChecks.getSeoCBRPopUpTitle(), 15) ){
					cellValue=getCurrentUrl()+","+"CBR Popup Title is not displayed";
					csvWriter.write(cellValue);
					csvWriter.newLine();
				}
				
				//Waiting for RCB button from CBR popup
				pollingWaitWithoutClickable(seoChecks.getSeoRcb(),15);
				
				if( ! isElementVisible(seoChecks.getSeoRcb(), 15) ){
					cellValue=getCurrentUrl()+","+"RCB button in CBR is not displayed";
					csvWriter.write(cellValue);
					csvWriter.newLine();
				}
				
				//To close the RCB button
				pollingWaitWithoutClickable(seoChecks.getSeoRcbClose(), 10);
				clickAction(seoChecks.getSeoRcbClose());
			}
			else if(driver.findElements(By.xpath("(//span[text()='Request call back'])[2]")).size() > 0)
			{
				clickAction(cbr.getMlerequestCallbackCTA());
				
				//Waiting for the CBR Title from CBR popup
				pollingWaitWithoutClickable(seoChecks.getSeoCBRPopUpTitle(),15);
				
				if( ! isElementVisible(seoChecks.getSeoCBRPopUpTitle(), 15) ){
					cellValue=getCurrentUrl()+","+"CBR Popup Title is not displayed";
					csvWriter.write(cellValue);
					csvWriter.newLine();
				}
				
				//Waiting for RCB button from CBR popup
				pollingWaitWithoutClickable(seoChecks.getSeoRcb(),15);
				
				if( ! isElementVisible(seoChecks.getSeoRcb(), 15) ){
					cellValue=getCurrentUrl()+","+"RCB button in CBR is not displayed";
					csvWriter.write(cellValue);
					csvWriter.newLine();
				}
				
				//To close the RCB button
				pollingWaitWithoutClickable(seoChecks.getSeoRcbClose(), 10);
				clickAction(seoChecks.getSeoRcbClose());
			}
			
			/*
			 *  Validating Create Now in Packages page
			 */
			
			scrollByValue(700);
			
			pollingWaitWithoutClickable(seoChecks.getSeoCreateNow(),15);
			Thread.sleep(2000);
			scrolltoElement(seoChecks.getSeoCreateNow());
			clickDisbledJavaScriptElement(seoChecks.getSeoCreateNow());
			
			pollingWaitWithoutClickable(seoChecks.getSeoPDG(), 15);
			if (! isElementVisible(seoChecks.getSeoPDG(),15))
			{
				cellValue=getCurrentUrl()+","+"Problem in Create Now CTA";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
			
			//Traversing back in the history
			traverseBackInHistory();
			Thread.sleep(3000);
			
			/*
			 * navigate whether the slug itinerary is loaded
			 */
			
			pollingWaitWithoutClickable(seoChecks.getSeoSlugItinerary(), 20);
			forceClick(seoChecks.getSeoSlugItinerary());
			
			pollingWaitWithoutClickable(seoChecks.getSeoSlugPrice(), 20);
			
			if(! isElementVisible(seoChecks.getSeoSlugPrice(), 15))
			{
				cellValue=getCurrentUrl()+","+"Problem in loading Slug Itinerary";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
			
			//Traversing back in the history
			traverseBackInHistory();
			Thread.sleep(3000);
			
			//Waiting for the first slug itinerary to be loaded
			pollingWaitWithoutClickable(seoChecks.getSeoSlugItinerary(), 20);
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Problem while validating CTAs in the Packages page");
			cellValue=getCurrentUrl()+","+"Problem while validating CTAs in the Packages page";
			csvWriter.write(cellValue);
			csvWriter.newLine();
			ex.printStackTrace();
		}
	}
	
	@Then("Validate whether Interlinking links are displayed and not repeated")
	public void validate_whether_interlinking_links_are_displayed_and_not_repeated() throws IOException {
	    try
	    {
	    	headerInterlinking=driver.findElements(By.xpath("//div[@itemprop='TouristTrip']//span/..//div/a[contains(@href,'packages')]"));
	    	
	    	//To find duplicate links
	    	if(headerInterlinking.size()>0)
	    	{
	    		boolean headerDuplicate=false;
	    		for (WebElement headerLink : headerInterlinking) {
	                if (!uniqueHeaderLinks.add(headerLink)) {
	                	duplicateHeaderLinks.add(headerLink);
	                	headerDuplicate=true;
	                }
	            }
	    		
	    		//To print in the report, if there are any duplicate interlinking links
	    		if(headerDuplicate)
	    		{
		            System.out.println("Duplicates using Set: " + duplicateHeaderLinks);
		            cellValue=getCurrentUrl()+","+"Duplicate Interlinking links under Package cards ("+duplicateHeaderLinks+")";
					csvWriter.write(cellValue);
					csvWriter.newLine();
	    		}
	    	}
	    	else
	    	{
	    		cellValue=getCurrentUrl()+","+"No Interlinking links under Package cards";
				csvWriter.write(cellValue);
				csvWriter.newLine();
	    	}
	    	
	    	footerInterlinking=driver.findElements(By.xpath("//div[@id='footer-wrapper']//span/..//div/a[contains(@href,'packages')]"));
	    	
	    	//To find duplicate links
	    	if(footerInterlinking.size()>0)
	    	{
	    		boolean footerDuplicate=false;
	    		for (WebElement footerLink : footerInterlinking) {
	    			
	                if (!uniqueFooterLinks.add(footerLink)) {
	                	duplicateFooterLinks.add(footerLink);
	                	footerDuplicate=true;
	                }
	            }
	    		
	    		//To print in the report, if there are any duplicate interlinking links
	    		if(footerDuplicate)
	    		{
		            System.out.println("Duplicates using Set: " + duplicateFooterLinks);
		            cellValue=getCurrentUrl()+","+"Duplicate Interlinking links in Footer ("+duplicateFooterLinks+")";
					csvWriter.write(cellValue);
					csvWriter.newLine();
	    		}
	    		
	    	}
	    	else
	    	{
	    		cellValue=getCurrentUrl()+","+"No Interlinking links in Footer";
	    		csvWriter.write(cellValue);
				csvWriter.newLine();
	    	}
	    }
	    catch(Exception ex)
	    {
			System.out.println("Problem while validating interlinking Urls in the Packages page");
			cellValue=getCurrentUrl()+","+"Problem while validating the interlinking Urls";
			csvWriter.write(cellValue);
			csvWriter.newLine();
			ex.printStackTrace();
	    }
	    finally
	    {
	    	headerInterlinking.clear();
	    	footerInterlinking.clear();
	    	uniqueHeaderLinks.clear();
	    	duplicateFooterLinks.clear();
	    	uniqueFooterLinks.clear();
	    	uniqueHeaderLinks.clear();
	    }
	}
	
	
	@Then("Validate whether you are able to cost the itinerary using View Details")
	public void validate_whether_you_are_able_to_cost_the_itinerary_using_view_details() throws IOException {
		try
	    {
			Thread.sleep(3000);
			switchWindows();
			Thread.sleep(2000);
			String indurl = driver.getCurrentUrl();
			System.out.println("indurl--->" + indurl);
			//waitForUrl("view");
			if (indurl.contains("/customize/") || indurl.contains("inclusions") || indurl.contains("view")) {
				pageRefresh();
				//Adding this pollingWait for the book now to be visible
				//Added extra 5 seconds to load the itinerary
				pollingWaitWithoutClickable(inclusion.getBookNow(),30);
				//Commented on Feb 26th for handling the clickable exception in wait
				//pollingWait(inclusion.getBookNow(),25);

				itineraryId=driver.getCurrentUrl().split("/")[6];
				System.out.println("current url-->"+driver.getCurrentUrl());
				System.out.println("Itineray Id-->"+itineraryId);
				System.out.println("Itinerary costed successfully");
				

			} else {
				System.out.println("Unable to cost the itinerary");
				cellValue=getCurrentUrl()+","+"Problem while costing the itinerary";
				csvWriter.write(cellValue);
				csvWriter.newLine();
			}
	    }
	    catch(Exception ex)
	    {
			System.out.println("Problem while costing the itinerary");
			cellValue=getCurrentUrl()+","+"Problem while costing the itinerary";
			csvWriter.write(cellValue);
			csvWriter.newLine();
			ex.printStackTrace();
	    }
		finally
		{
			csvWriter.close();
		}
	}
	
	
	@When("Navigate to the SEO {string}")
	public void navigate_to_the_seo(String seoUrl) {
	   try
	   {
		  driver.navigate().to(seoUrl); 
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	}

}
