package gluecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.IDN;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.*;

public class BIDashboardGlue extends Kernel {

	SeWrappers biWrapper= new SeWrappers();
	SimpleEmailService ses = new SimpleEmailService();
	WebDriver driver;
	String biUrl= "https://app.powerbi.com/view?";
	public static StringBuilder html = new StringBuilder();
	public static String timeStamp = "";
	public static String screenshotAtt,body,browser,sesHub,sesPort,sesUsername,sesPassword,biMailSubject,biFromEmail,biFromEmailName,biToEmail,biCcEmail,biAttachment,biBodyPart=""; 


	@Given("^launch the BI dashboard \"([^\"]*)\"$")
	public void launch_the_BI_dashboard_URL(String url) throws Throwable {
		try
		{
			Hooks hook= new Hooks();
			browser= biWrapper.browserName;
			System.out.println(biWrapper.browserName);
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.out.println("Inside chrome");
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("headless");
				chromeOptions.addArguments("window-size=1200x600");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver= new ChromeDriver(chromeOptions);
			}
			else if( browser.equalsIgnoreCase("chromeLocal" ))
			{
				System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("headless");
				chromeOptions.addArguments("window-size=1200x600");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver= new ChromeDriver(chromeOptions);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			System.out.println(biUrl+url);
			driver.get(biUrl+url);
			Thread.sleep(5000);
		}

		catch(Exception e)
		{
			System.out.println("Probem while launching the browser "+e.getMessage());
			e.printStackTrace();
		}

	}

	@And("^capture the screenshot of the entire page with name \"([^\"]*)\"$")
	public void capture_the_screenshot_of_the_entire_page(String screenshotName) throws Throwable {

		createDirectory();
		screenshotAtt=screenshotName;
		getBIDashboardScreenshot(driver, screenshotName);
		Thread.sleep(2000);
//		clickJavaScriptElement(biDashboard.getPreviousPage());
//		Thread.sleep(2000);
//		getBIDashboardScreenshot(driver,"BIDashboardSecondPage");

	}

	@Then("^mail the captured screenshot with subject \"([^\"]*)\" and body \"([^\"]*)\" to the required stakeholders \"([^\"]*)\" and \"([^\"]*)\"$")
	public void mail_the_captured_screenshot_with_subject_and_body_to_the_required_stakeholders_and(String sub, String body, String to, String cc) throws Throwable {
		
		sendBIMail(sub, body, to, cc);
		System.out.println();


	}

	private void sendBIMail(String subject, String body, String toMail, String ccMail) {
		try
		{
			Properties prop = new Properties();
			sesHub= prop.getProperty("SESHOST");
			sesPort=prop.getProperty("SESPORT");
			sesUsername=prop.getProperty("SESUSERNAME");
			sesPassword=prop.getProperty("SESPASSWORD");
			biMailSubject=subject;
			biFromEmail="qa@pickyourtrail.com";
			biFromEmailName="QATeam";
//			biToEmail="nirmal@pickyourtrail.com,sharmila@pickyourtrail.com";
//			biCcEmail="meenatchi@pickyourtrail.com";
			biToEmail=toMail;
			biCcEmail=ccMail;
			biAttachment=System.getProperty("user.dir") + "/bidashboard/"+screenshotAtt+ timeStamp + ".jpg";
			biBodyPart=generateUrl(body);

			//Sending mail
			ses.sendSESMail(biMailSubject,biFromEmail,biFromEmailName,biToEmail,biCcEmail,biBodyPart,biAttachment);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public void createDirectory()
	{
		try {
			timeStamp=getTime();
			File file = new File(System.getProperty("user.dir")+"/bidashboard");
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("Problem while creating directory ");
			e.printStackTrace();
		}
	}




	public static String generateUrl(String body) {
		try {
			//To empty the string builder because it may used in Url validation and Core Web vitals metrice automations
			html.setLength(0);
			String automationReportName = "BIDashboardReport-" + timeStamp;
			html.append("<html>");
			html.append("<body>");
			html.append("<br>");
			html.append("Hi All,");
			html.append("<br>");
			html.append("Please find attached the "+body+" Screenshot for " + timeStamp + " ,");
			html.append("<br>");
			html.append("<br>");
			html.append("Regards,");
			html.append("<br>");
			html.append("QA Team");
			System.out.println("BI Automation Report Name: " + automationReportName);
			html.append("</body>");
			html.append("</html>");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return html.toString();
	}


	public static String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH:mm");
		Date date = new Date();
		// System.out.println(formatter.format(date));
		return formatter.format(date);
	}

	// Creating a method getScreenshot and passing two parameters
	// driver and screenshotName
	public static String getBIDashboardScreenshot(WebDriver driver,String screenshotName) throws Exception {

		String destination="";
		File finalDestination =null;
		try {
			// below line is just to append the date format with the screenshot name to
			// avoid duplicate names
			//					String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			destination = "./bidashboard/"+screenshotName+ timeStamp
					+ ".jpg";
			finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			//					 Reports.reportStep("Captured the Failed TC screenshot successfully", "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in capturing Failed TC Screenshot", "FAIL");
		}
		// Returns the captured file path
		return destination;

	}


}
