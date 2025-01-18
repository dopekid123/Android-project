package gluecode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;
import utils.SeWrappers;
import utils.SimpleEmailService;


public class SunSiyamResortAvailabilityGlue extends Kernel{


	SeWrappers salesWrapper= new SeWrappers();
	SimpleEmailService ses = new SimpleEmailService();
	Kernel kernel = new Kernel();
	public static String body,browser,sesHub,sesPort,sesUsername,sesPassword,srMailSubject,srFromEmail,srFromEmailName,srToEmail,srCcEmail,srBodyPart="";
	List<String> srAttachments= new ArrayList<>(); 
	public static String IruFsuhi, SiyamWorld,IruVeli,ViluReef,Olhuveli  =null;
	public static ArrayList<String> downloadedFiles = new ArrayList<String>();
	public static StringBuilder html = new StringBuilder();


	@Given("^launch the Sun Siyam website \"([^\"]*)\" and close the popup$")
	public void launch_the_Sun_Siyam_website_and_close_the_popup(String url) throws Throwable {
		try
		{
			System.out.println("Inside driver");
			driver.get(url);
			Thread.sleep(1000);
			typeText(sunSiyam.getSrUsername(), "mazin@islandlife.travel");
			typeText(sunSiyam.getSrPassword(), "Sunsiy@mresorts2021");
			clickAction(sunSiyam.getSrLogin());

			Thread.sleep(1000);


		}
		catch(Exception ex)
		{
			System.out.println("Problem while launching the url "+ex.getMessage());
		}
	}

	@Given("^capture the full page screenshot and change another resort$")
	public void capture_the_full_page_screenshot_and_change_another_resort() throws Throwable {
		try
		{
			//close the sun siyam - special offers popup
			closeSunSiyamPopup();
			//			createDirectory("SunSiyam");

			//Commenting on Nov 29th because Iru fushi is not in the dropdown
//			IruFsuhi= downloadPdf("/Users/mac/Downloads","SunSiyamIruFushi");


			//Commenting on Nov 29th because Iru fushi is not in the dropdown
//			selectDropDownUsingVisibleText(sunSiyam.getSrPropertyDropdown(), "Sun Siyam Olhuveli");
//			closeSunSiyamPopup();
			Olhuveli= downloadPdf("/Users/mac/Downloads","SunSiyamOlhuveli");

			//
			selectDropDownUsingVisibleText(sunSiyam.getSrPropertyDropdown(), "Sun Siyam Iru Veli");
			closeSunSiyamPopup();
			IruVeli= downloadPdf("/Users/mac/Downloads","SunSiyamIruVeli");

			//
			selectDropDownUsingVisibleText(sunSiyam.getSrPropertyDropdown(), "Sun Siyam Vilu Reef");
			closeSunSiyamPopup();
			ViluReef= downloadPdf("/Users/mac/Downloads","SunSiyamViluReef");

			//
			selectDropDownUsingVisibleText(sunSiyam.getSrPropertyDropdown(), "Siyam World");
			//closeSunSiyamPopup();
			SiyamWorld= downloadPdf("/Users/mac/Downloads","SiyamWorld");

			//Commenting on Nov 29th because Iru fushi is not in the dropdown
//			downloadedFiles.add(IruFsuhi);
			downloadedFiles.add(Olhuveli);
			downloadedFiles.add(IruVeli);
			downloadedFiles.add(ViluReef);
			downloadedFiles.add(SiyamWorld);



		}
		catch(Exception ex)
		{
			System.out.println("Problem while downloading the pdf or while changing the resort "+ex.getMessage());
		}
	}


	@Then("^mail the captured screenshot with subject \"([^\"]*)\" and body to the required stakeholders \"([^\"]*)\" and \"([^\"]*)\"$")
	public void mail_the_captured_screenshot_with_subject_and_body_to_the_required_stakeholders_and(String sub, String to, String cc) throws Throwable {

		sendSunSiyamResortAvailabilityMail(sub, to, cc);
		System.out.println();


	}

	private void closeSunSiyamPopup() throws InterruptedException
	{
		try
		{
			scrolltoElement(sunSiyam.getsrOffersPopup());
			clickAction(sunSiyam.getsrOffersPopup());
			Thread.sleep(2000);
		}
		catch(Exception ex)
		{
			System.out.println("Problem while closing the popup "+ex.getMessage());
		}
	}

	private String downloadPdf(String path, String newFileName)
	{
		File oldName,newName = null;
		try
		{
			timeStamp=getTime();
			clickAction(sunSiyam.getSrDownloadPdf());
			Thread.sleep(2000);
			oldName = new File(path+File.separator+"data.pdf");

			// Create an object of the File class
			// Replace the file path with path of the directory
			newName = new File(path+File.separator+newFileName+timeStamp+".pdf");

			// store the return value of renameTo() method in
			// flag
			boolean flag = oldName.renameTo(newName);

			// if renameTo() return true then if block is
			// executed
			if (flag == true) {
				System.out.println(oldName+" File Successfully Renamed to "+newName);
			}
			// if renameTo() return false then else block is
			// executed
			else {
				System.out.println("Renamed failed from "+oldName+" to "+newName);
			}


		}
		catch(Exception ex)
		{
			System.out.println("Problem while downloading the file "+ex.getMessage());
		}
		return newName.toString();
	}

	private void sendSunSiyamResortAvailabilityMail(String subject, String toMail, String ccMail) {
		try
		{
			Properties prop = new Properties();
			sesHub= prop.getProperty("SESHOST");
			sesPort=prop.getProperty("SESPORT");
			sesUsername=prop.getProperty("SESUSERNAME");
			sesPassword=prop.getProperty("SESPASSWORD");
			srMailSubject=subject;
			srFromEmail="qa@pickyourtrail.com";
			srFromEmailName="QATeam";
			//			srToEmail="nirmal@pickyourtrail.com,sharmila@pickyourtrail.com";
			//			srCcEmail="meenatchi@pickyourtrail.com";
			srToEmail=toMail;
			srCcEmail=ccMail;
			srAttachments=downloadedFiles;
			srBodyPart=generateSrUrl();

			//Sending mail
			ses.sendEmailWithMultipleAttachments(srMailSubject,srFromEmail,srFromEmailName,srToEmail,srCcEmail,srBodyPart,srAttachments);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public static String generateSrUrl() {
		try {
			//To empty the string builder because it may used in Url validation and Core Web vitals metrice automations
			html.setLength(0);
			String automationReportName = "Sun Siyam Availability Mail-" + timeStamp;
			html.append("<html>");
			html.append("<body>");
			html.append("<br>");
			html.append("Hi All,");
			html.append("<br>");
			html.append("Please find attached the Sun Siyam Resort Availability Mail for " + timeStamp + " ,");
			html.append("<br>");
			html.append("<br>");
			html.append("Regards,");
			html.append("<br>");
			html.append("QA Team");
			System.out.println("Sun Siyam Resort Availibity Automation Report Name: " + automationReportName);
			html.append("</body>");
			html.append("</html>");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return html.toString();
	}




}
