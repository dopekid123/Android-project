package gluecode;

import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class ItninerayCostComparisonGlue extends Kernel {
	/*
	 * In this method, getting costed or booked itineraries price, Itinerary ID from
	 * URL and region. Writting all the above mentioned values to corresponding csv
	 * file
	 * 
	 */
	@Then("^get created itinerary details \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void get_created_itinerary_details(String region, String clear, String itineraryStatus) throws Throwable {
		String price = "";
		PrintWriter writer = null;
		FileWriter fileWriter = null;
		try {
			if (clear.equalsIgnoreCase("true")) {
				if (itineraryStatus.equalsIgnoreCase("costed")) {
					writer = new PrintWriter(System.getProperty("user.dir") + costedItineraryPrice);
				} else {
					writer = new PrintWriter(System.getProperty("user.dir") + bookedItineraryPrice);
				}
				writer.print("");
				writer.close();
			}
		} catch (Exception e) {
			System.out.println("File Not Found");
		}
		System.out.println("URL :" + getCurrentUrl());
		String itineraryLen = getCurrentUrl();
		String itineraryID = getCurrentUrl().substring(itineraryLen.length() - 24);
		System.out.println(itineraryID);
		if (itineraryStatus.equalsIgnoreCase("costed")) {
			price = intpag.getItineraryCost().getText().replaceAll("[-+.^:,₹]", "");
		} else {
			price = psp.getTotalCost().getText().replaceAll("[-+.^:,₹]", "");
		}
		System.out.println(price);
		String content = region + "," + itineraryID + "," + price + ", comparePrice";
		if (itineraryStatus.equalsIgnoreCase("costed")) {
			fileWriter = new FileWriter(System.getProperty("user.dir") + costedItineraryPrice, true);

		} else {
			fileWriter = new FileWriter(System.getProperty("user.dir") + bookedItineraryPrice, true);
		}
		fileWriter.write(content);
		fileWriter.write("\n");
		fileWriter.close();
	}

	/*
	 * In this method, Reading above created csv file and using that data to get itinerary price,
	 * Navigating to particular itinerary. Then fetching itinerary price for the
	 * same and appending new price value in csv file.
	 * 
	 */
	@Then("^get \"([^\"]*)\" itinerary details to compare$")
	public void getItineraryPriceToCompare(String itineraryStatus) throws IOException, InterruptedException {
		PrintWriter writer = null;
		try {
			if (itineraryStatus.equalsIgnoreCase("costed")) {
				writer = new PrintWriter(System.getProperty("user.dir") + costedItineraryPriceCompare);

			} else {
				writer = new PrintWriter(System.getProperty("user.dir") + bookedItineraryPriceCompare);
			}
			writer.print("");
			writer.close();
		} catch (Exception e) {
			System.out.println("File Not Found");
		}
		String row = "";
		BufferedReader csvReader = null;
		if (itineraryStatus.equalsIgnoreCase("costed")) {
			csvReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + costedItineraryPrice));
		} else {
			csvReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + bookedItineraryPrice));
		}
		while ((row = csvReader.readLine()) != null) {
			String region = row.split(",")[0];
			String itineraryId = row.split(",")[1];
			String oldPrice = row.split(",")[2];
			driver.navigate().to(localEnvUrl + "/view/" + itineraryId);
			if (elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
			}
			String price = intpag.getItineraryCost().getText().replaceAll("[-+.^:,₹]", "");
			String newPrice = row.split(",")[3].replace(" comparePrice", price);
			System.out.println("new price" + newPrice);
			String newContent = region + "," + itineraryId + "," + oldPrice + "," + newPrice;

			System.out.println("New Content--->" + newContent);
			FileWriter fileWriter = null;
			if (itineraryStatus.equalsIgnoreCase("costed")) {
				fileWriter = new FileWriter(System.getProperty("user.dir") + costedItineraryPriceCompare, true);
			} else {
				fileWriter = new FileWriter(System.getProperty("user.dir") + bookedItineraryPriceCompare, true);
			}
			fileWriter.write(newContent);
			fileWriter.write("\n");
			fileWriter.close();
		}
	}

	/*
	 * In this method, Reading compare csv file and Comparing Old Price with New Price.
	 * Validating price are equal or not, if not, assert will take action.
	 */
	@Then("^compare both the \"([^\"]*)\" itinerary prices$")
	public void compare(String itineraryStatus) throws IOException {
		String row;
		BufferedReader csvReader = null;
		if (itineraryStatus.equalsIgnoreCase("costed")) {
			csvReader = new BufferedReader(
					new FileReader(System.getProperty("user.dir") + costedItineraryPriceCompare));
		} else {
			csvReader = new BufferedReader(
					new FileReader(System.getProperty("user.dir") + bookedItineraryPriceCompare));
		}
		while ((row = csvReader.readLine()) != null) {
			String oldprice = row.split(",")[2];
			String newPrice = row.split(",")[3];
			System.out.println("Old Price -  " + oldprice + " - New Price - " + newPrice);
			assertTrue(oldprice.equalsIgnoreCase(newPrice));
		}
	}
}