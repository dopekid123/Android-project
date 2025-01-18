package gluecode;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class swissPassGlue extends Kernel {
	List<String> activitiesname = new ArrayList<String>();
	public static int k = 1;
	String filepasspath = null;

	File threedaypassfile = new File(System.getProperty("user.dir") + "/configuration/3dayswisspass.txt");
	String Threedaypasspath = threedaypassfile.getPath();

	File fourdaypassfile = new File(System.getProperty("user.dir") + "/configuration/4dayswisspass.txt");
	String fourdaydaypasspath = fourdaypassfile.getPath();

	File eightdaypassfile = new File(System.getProperty("user.dir") + "/configuration/8dayswisspass.txt");
	String eightdaypasspath = eightdaypassfile.getPath();

	File fifteendaypassfile = new File(System.getProperty("user.dir") + "/configuration/15dayswisspass.txt");
	String fifteendaypasspath = fifteendaypassfile.getPath();

	String pass = null;
	String[] daystartsarr;

	@Then("^Remove the extra cities in the itinerary$")
	public void remove_the_extra_cities_in_the_itinerary() throws Throwable {
		clickAction(intpag.getItineraryPage());
		Thread.sleep(2000);
		if (elementDisplayed(intpag.getgotit())) {
			clickAction(intpag.getgotit());
		}
		removeCities();
	}

	// This method will remove the nights from 2nd city in the itinerary

	public void removeCities() {
		List<WebElement> deleteiconcs = ed.getDeleteIcon();
		int len = deleteiconcs.size();
		for (int i = len; i > 1; i--) {
			try {
//				Thread.sleep(2000);
				WebElement deleteicon = driver.findElement(
						By.xpath("//div[contains(@class,'route-modal')]//following::i[contains(@class,'pyt-delete')]["
								+ i + "]"));
				hoverWebelement(deleteicon);
				clickAction(deleteicon);
				Thread.sleep(5000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Then("^Validate the swisspass for following \"([^\"]*)\"$")
	public void validate_the_swisspass_for_following(String days) throws Throwable {

		String[] eachday = days.split(",");

		for (String day : eachday) {

			int daycount = Integer.parseInt(day);
			Thread.sleep(2000);
			hoverWebelement(ed.getEditRouteFirstCity());

			waitForMe(ed.getEditRouteCityNight(), 40);
			hoverWebelement(ed.getEditRouteCityNight());

			String night = ed.getEditRouteCityNight().getText().replaceAll("[^0-9]", "");
			int nightcount = Integer.parseInt(night);

			while (nightcount > 2) {

				Thread.sleep(2000);
				hoverWebelement(ed.getEditRouteFirstCity());

				hoverWebelement(ed.getEditRouteCityMinus());
				clickAction(ed.getEditRouteCityMinus());

				nightcount--;
			}

			Thread.sleep(2000);
			hoverWebelement(ed.getEditRouteFirstCity());

			waitForMe(ed.getEditRouteCityNight(), 40);
			hoverWebelement(ed.getEditRouteCityNight());

			String nightafteredit = ed.getEditRouteCityNight().getText().replaceAll("[^0-9]", "");
			int nightaftereditcount = Integer.parseInt(nightafteredit);

			switch (day) {
			case "3":

				if (nightaftereditcount == 2) {
					scrollUp();
					pass = "3";
					filepasspath = Threedaypasspath;
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "4":

				if (nightaftereditcount == 2) {
					int countofclick = 1;
					pass = "3";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "5":

				if (nightaftereditcount == 2) {
					int countofclick = 2;
					pass = "4";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}
			case "6":

				if (nightaftereditcount == 2) {
					int countofclick = 3;
					pass = "4";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "7":
				if (nightaftereditcount == 2) {
					int countofclick = 4;
					pass = "8";
					filepasspath = eightdaypasspath;
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "8":
				if (nightaftereditcount == 2) {
					int countofclick = 5;
					pass = "8";
					filepasspath = eightdaypasspath;
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "9":
				if (nightaftereditcount == 2) {
					int countofclick = 6;
					pass = "8";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass, day, filepasspath);
					break;
				}

			case "10":
				if (nightaftereditcount == 2) {
					int countofclick = 7;
					pass = "8";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "11":
				if (nightaftereditcount == 2) {
					int countofclick = 8;
					pass = "15";
					filepasspath = fifteendaypasspath;
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "15":
				if (nightaftereditcount == 2) {
					int countofclick = 12;
					pass = "15";
					filepasspath = fifteendaypasspath;
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}
			case "16":
				if (nightaftereditcount == 2) {
					int countofclick = 13;
					pass = "15";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			case "17":
				if (nightaftereditcount == 2) {
					int countofclick = 14;
					pass = "15";
					addingNights(countofclick);
					scrollUp();
					swissPassValidation(pass,day,filepasspath);
					break;
				}

			}
		}

	}

	public void addingNights(int countofclick) {
		try {
			Thread.sleep(2000);
			hoverWebelement(ed.getEditRouteFirstCity());
			for (int i = 1; i <= countofclick; i++) {
				clickAction(ed.getEditRouteCityPlus());
				hoverWebelement(ed.getEditRouteFirstCity());
				hoverWebelement(ed.getEditRouteCityPlus());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void swissPassValidation(String pass, String day, String filepasspath) {
		try {
			clickAction(ed.getUpdateTripCost());
			pollingWaitForCostingFlow("inclusions", 250);
			clickAction(intpag.getItineraryPage());

			if (day.equals("3") || day.equals("7") || day.equals("8") || day.equals("11") || day.equals("15")) {
				String daystarts = ed.getItineraryStartDate().getText();
				daystartsarr = daystarts.split(" ");
				swissPassCardValidation(daystartsarr, day, pass);
				swissPassActivityCardValidation(filepasspath);

			}
			if (day.equals("4") || day.equals("5") || day.equals("9") || day.equals("16") || day.equals("6")
					|| day.equals("10") || day.equals("17")) {
				String daysecond = ed.getItinerarySecondDate().getText();
				daystartsarr = daysecond.split(" ");
				swissPassCardValidation(daystartsarr, day, pass);
			}

			System.out.println("completed first flow for " + day);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void swissPassCardValidation(String[] daystartsarr, String day, String pass) throws InterruptedException {

		
		clickAction(intpag.getMorePill());
		String daystrt = daystartsarr[0];
		String month = daystartsarr[1];

		String swisspassno = inclusion.getSwissPassCard().getText().replaceAll("[^0-9]", "");
		System.out.println("swisspassoncard--" + swisspassno);
		System.out.println("pass--" + pass);
		validateAssertion(swisspassno.equals(pass));

		try {
			clickAction(inclusion.getSwissPassCustomizeBtn());
			String[] dayoncard = inclusion.getSwissPassComboDate().getAttribute("value").split("/");
			String daystrtoncard = dayoncard[0];
			String monthoncard = dayoncard[1];

			validateAssertion(daystrtoncard.equals(daystrt));
			validateAssertion(monthoncard.equals(month));

			clickAction(inclusion.getSwissPassCloseBtn());

			clickAction(intpag.getItineraryPage());
			if (elementDisplayed(intpag.getgotit())) {
				clickAction(intpag.getgotit());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void swissPassActivityCardValidation(String filepasspath) {

		try {
			addSwissPassActivityAtLeisureSlot();
			ValidateSwissPassTagOnActivities(filepasspath);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void ValidateSwissPassTagOnActivities(String filepasspath) {
		try {
			
			clickAction(activityPage.getActivityPillCount());
			if (elementDisplayed(activityPage.getActivity_ExpandActivityInclusions())) {
				clickAction(activityPage.getActivity_ExpandActivityInclusions());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String activitycount = activityPage.getActivityPillCount().getText().replaceAll("[^0-9]", "");
		int activtycount = Integer.parseInt(activitycount);
		int swisspasstagcount = activityPage.getSwissPassTagCountOnCard().size();
		if (activtycount == swisspasstagcount) {
			Assert.assertTrue(true);
		} else {
			int diff = activtycount - swisspasstagcount;
			activitiesname.clear();
			for (WebElement activityname : activityPage.getActivityNames()) {
				String names = activityname.getText().trim();
				activitiesname.add(names);
			}
			List<String> cmsactivities = readFileIntoList(filepasspath);
			List<String> cmsActivityList = new ArrayList<String>();
			for (String cmsActivityeach : cmsactivities) {
				String cmsactivitynames = cmsActivityeach.trim();
				cmsActivityList.add(cmsactivitynames);
			}

			activitiesname.removeAll(cmsActivityList);
			int notAnSwissPassActivity = activitiesname.size();

			if (notAnSwissPassActivity == diff) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}

		}
		try {
			clickAction(intpag.getItineraryPage());
			if (elementDisplayed(intpag.getgotit())) {
				clickAction(intpag.getgotit());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<String> readFileIntoList(String filepasspath) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(filepasspath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public void addSwissPassActivityAtLeisureSlot() throws InterruptedException {
		int count = activityPage.getLeisureSlots().size();
		for (int i = 1; i <= count; i++) {
			WebElement leisure = driver.findElement(By.xpath("(//span[contains(text(),'Add activity')])[" + k + "]"));
			try {
				clickAction(leisure);
				while (elementDisplayed(intpag.getgotit())) {
					clickAction(intpag.getgotit());
				}
				pollingWait(activityPage.getActivityAlternate_Cards(), 120);
				clickAction(activityPage.getSearchBox());
				typeText(activityPage.getSearchBox(), "swiss");
				Thread.sleep(2000);
				try {
					if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0) {
						hoverWebelement(activityPage.getActivityAlternate_Cards());
						clickAction(activityPage.getActivityAlternate_Choose(),
								"User click choose the first activity in the alternate page");
						validate_String_Contains(getCurrentUrl(), "view");
						count--;
					} else {
						clickAction(activityPage.getBackToItineraryButtonInAlternate(),
								"User clicks the back to itinerary button due to no result found for the smart filter");
						k = k + 1;
						validate_String_Contains(getCurrentUrl(), "view");
						count--;
					}
				} catch (NoSuchElementException e) {
					e.printStackTrace();

				}

			} catch (NoSuchElementException e) {
				System.out.println("Leisure slot isn't available");
			}
		}
	}

}
