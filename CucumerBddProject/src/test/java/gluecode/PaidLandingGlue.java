package gluecode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;
import utils.SimpleEmailService;

public class PaidLandingGlue extends Kernel {
	public static String landingPageUrl, propertyStars, cellValue, propertyName,  propertyNameWithoutComma = "";
	public static ArrayList<String> paidLandingUrls = new ArrayList<String>();
	public static List<WebElement> starRating = new ArrayList<WebElement>();
	public static List<WebElement> propertyNames = new ArrayList<WebElement>();
	BufferedWriter csvWriter;
	public static double stars;
	public static int starsRoundedNumber;
	public static String hotelMailSubject, hotelFromEmail, hotelFromEmailName, hotelToEmail, hotelCcEmail,
			hotelAttachment, hotelBodyPart;
	public static String timeStamp = "";
	SimpleEmailService ses = new SimpleEmailService();

	@Given("User reads the urls from the input csv file {string}")
	public void user_reads_the_urls_from_the_input_csv_file(String paidLandingPath) {
		try {
			try (CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir") + paidLandingPath))) {
				String[] nextLine;

				while ((nextLine = reader.readNext()) != null) {
					landingPageUrl = nextLine[0];
					paidLandingUrls.add(landingPageUrl);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Then("User navigates to the url and sign up to the itinerary with valid username, name and password {string}, {string} and {string} and fetches the {string} below three stars")
	public void user_navigates_to_the_url_and_sign_up_to_the_itinerary_with_valid_username_name_and_password_and_and_fetches_the_below_three_stars(
			String uName, String name, String passwd, String outputFile) throws IOException, InterruptedException {
		try {
			// Header login
			clickAction(lp.getLogin());
			doHeaderLogin(uName, passwd);

			System.out.println("Path-->" + System.getProperty("user.dir") + "/hotels/" + outputFile);
			// Deleting the Previously generated files
			deleteOutputFile(System.getProperty("user.dir") + "/hotels/" + outputFile);

			// Creating and initialising the csv file
			FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/hotels/" + outputFile, true);
			csvWriter = new BufferedWriter(writer);

			// Heading for the output csv file
			csvWriter.write("paidlandingurl,propertyname,starrating");
			csvWriter.newLine();
			csvWriter.flush();

			System.out.println("Url List" + paidLandingUrls);

			for (String eachUrl : paidLandingUrls) {

				System.out.println("each url-->" + eachUrl);
				navigateToUrl(eachUrl);
	//			validate_String_Contains(getCurrentUrl(), eachUrl);

//				if(driver.findElements(By.xpath("//span[contains(text(),'find itineraries matching your interest')]")).size() < 1)
//				{
				if (driver.findElements(By.xpath("//div[@id='packages-cards']")).size() > 0) {
					// Refreshing the page to show login state
					pageRefresh();

					// Writing the output to file
					writeToCSV(System.getProperty("user.dir") + "/hotels/" + outputFile);

					// Clicking on the View deal button from the first itinerary in the package
					click_on_View_Deal_button_Before_Login();
					// Itinerary creation
					itineraryCreationthroughPackages();

					// validate the itinerary is costed
					validateSuccessfulCostingWithGotItPopup();

					// Close the new window opened while costing and switch the parent window
					closeSwittchParentWindow(parentWindow);
				} else if (driver.findElements(By.xpath("(//button[contains(text(),'Check availability')])[1]")).size() > 0) {
					// Clicking on the View deal button from the first itinerary in the package
					clickOnCheckAvailabilityCTA();

					// Itinerary creation
					itineraryCreationForResortLP();

					// validate the itinerary is costed
					validateSuccessfulCostingWithGotItPopup();

					// Close the new window opened while costing and switch the parent window
					// closeSwittchParentWindow(parentWindow);
				}

				else if (driver.findElements(By.xpath("//span[contains(text(),'find itineraries matching your interest')]")).size() > 0){
					csvWriter.write(getCurrentUrl()+","+"No Properties for this landing page");
					csvWriter.newLine();
					csvWriter.flush();
					System.out.println("There is no packages listed for this URL - " + eachUrl);
				}

			}

		}

		catch (Exception e) {
			System.out.println("Problem while creating itinerary with this URL---> " + getCurrentUrl());
			e.printStackTrace();
		}

		finally {
			csvWriter.close();
			// Clearing all the urls before the start of the execution
			paidLandingUrls.clear();

		}
	}

	public void writeToCSV(String file) throws InterruptedException {
		try {
			starRating = driver.findElements(By.xpath("//span[text()='Hotels']/parent::div/div/span")); 
			propertyNames = driver.findElements(By.xpath("//div[@class='veho-c-lesPJm']//div[@class='veho-c-gqwkJN veho-c-gqwkJN-iTKOFX-direction-column veho-c-gqwkJN-irEjuD-align-stretch veho-c-gqwkJN-awKDG-justify-start veho-c-gqwkJN-kVNAnR-wrap-noWrap veho-c-gqwkJN-iibBUcl-css']//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iiWLjtc-css'] | //div[@itemprop='name']//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iiWLjtc-css']"));
			
			for (int i = 1; i <= starRating.size(); i++) {
				String star = "(//span[text()='Hotels']/parent::div/div/span)[" + i + "]";
				WebElement starProperty = driver.findElement(By.xpath(star));
				pollingWaitWithoutClickable(starProperty, 30);
				propertyStars = getText(starProperty);
				
				propertyName = getText(propertyNames.get(i-1));
				pollingWaitWithoutClickable(propertyNames.get(i-1), 30);
				
			    propertyNameWithoutComma = propertyName.replace(",", "");
				stars = Double.parseDouble(propertyStars);
				if (stars <= 3) {
					cellValue = getCurrentUrl() + "," + propertyNameWithoutComma + "," + stars;
					csvWriter.write(cellValue);
					csvWriter.newLine();
					csvWriter.flush();
					System.out.println("Final String: " + cellValue);

				}
			}
		} catch (Exception ex) {
			System.out.println("Problem while fetching the star ratings from the paid landing urls");
			ex.printStackTrace();
		}
	}

	@Then("mail the urls to the required stakeholders {string} and {string}")
	public void mail_the_urls_to_the_required_stakeholders_and(String toMail, String ccMail) {
		try {

			sendHotelStarMail(toMail, ccMail);

		} catch (Exception ex) {
			System.out.println("Problem while sharing to the required stakeholders");
			ex.printStackTrace();
		}
	}

	private void sendHotelStarMail(String toMail, String ccMail) {
		try {
			timeStamp = getTime();
			Properties prop = new Properties();
			sesHub = prop.getProperty("SESHOST");
			sesPort = prop.getProperty("SESPORT");
			sesUsername = prop.getProperty("SESUSERNAME");
			sesPassword = prop.getProperty("SESPASSWORD");
			hotelMailSubject = "Paid Campaign pages with properties below 3 stars ";
			hotelFromEmail = "qa@pickyourtrail.com";
			hotelFromEmailName = "QATeam";
			// biToEmail="nirmal@pickyourtrail.com,sharmila@pickyourtrail.com";
			// biCcEmail="meenatchi@pickyourtrail.com";
			hotelToEmail = toMail;
			hotelCcEmail = ccMail;
			hotelAttachment = System.getProperty("user.dir") + "/hotels/propertiesbelow3stars.csv";
			hotelBodyPart = generateEmailBody();

			// Sending mail
			ses.sendSESMail(hotelMailSubject, hotelFromEmail, hotelFromEmailName, hotelToEmail, hotelCcEmail,
					hotelBodyPart, hotelAttachment);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String generateEmailBody() {
		try {
			// To empty the string builder because it may used in Url validation and Core
			// Web vitals metrice automations
			html.setLength(0);
			String automationReportName = "Paid Campaign pages with properties below 3 stars -" + timeStamp;
			html.append("<html>");
			html.append("<body>");
			html.append("<br>");
			html.append("Hi All,");
			html.append("<br>");
			html.append(
					"Please find attached the Paid Campaign pages with properties below 3 stars for the report generated at"
							+ timeStamp + " ,");
			html.append("<br>");
			html.append("<br>");
			html.append("Regards,");
			html.append("<br>");
			html.append("QA Team");
			System.out.println("Paid Campign: " + automationReportName);
			html.append("</body>");
			html.append("</html>");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return html.toString();
	}

}
