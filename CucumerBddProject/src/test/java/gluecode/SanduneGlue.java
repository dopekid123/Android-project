package gluecode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class SanduneGlue extends Kernel {

	@Given("^User selects the region \"([^\"]*)\" from destination options$")
	public void user_selects_the_region_from_destination_options(String region) throws Throwable {
//		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
//		Thread.sleep(2000);
		driver.get(localEnvUrl+"customize");
		Thread.sleep(2000);
		typeText(cp.getlandingSearchBox(), region);
		validateAssertion(elementDisplayed(cp.getregionSelection()));
		clickAction(cp.getregionSelection(), "Region selection");
		Thread.sleep(4000);
	}

	@Given("^User chooses the month \"([^\"]*)\" for the trip$")
	public void user_chooses_the_month_for_the_trip(String dubai_month) throws Throwable {
		
		WebElement d_month = driver.findElement(By.xpath("(//div[contains(@class,'MonthCard')])[3]"));
		waitForMe(d_month);
		clickAction(d_month, "Month selected");
	}
	
	@Given("^User chooses the month \"([^\"]*)\" for the flight trip$")
	public void user_chooses_the_month_for_the_flight_trip(String dubai_month) throws Throwable {
		
		WebElement d_month = driver
				.findElement(By.xpath("//div[@class='season-details']/h6[text()='"+dubai_month+"']"));
		waitForMe(d_month);
		clickAction(d_month, "Month selected");
	}


	@Given("^User selects the departing city \"([^\"]*)\" from the dropdown$")
	public void user_selects_the_departing_city_from_the_dropdown(String dep_city) throws Throwable {

//		clickAction(dubaiPage.getSearchCity());
//		Thread.sleep(1000);
		typeText(dubaiPage.getSearchCity(),dep_city);
		clickAction(dubaiPage.getFirstSearchedCity(), "Departing city selected");

		}

	@Given("^User selects the departure date \"([^\"]*)\"$")
	public void user_selects_the_departure_date(String dep_date) throws Throwable {
		clickAction(dubaiPage.getnextMonthArrow());
		clickAction(dubaiPage.getnextMonthArrow());
		Thread.sleep(1000);
		clickAction(dubaiPage.getDateOneButton());
	}

	@Given("^User selects the no\\.of\\.nights \"([^\"]*)\" stay options$")
	public void user_selects_the_no_of_nights_stay_options(String no_of_nights) throws Throwable {
		
		WebElement d_stay = driver.findElement(
				By.xpath("//div[contains(@class,'dubai-trip-duration')]//button[text()='" + no_of_nights + "']"));
		waitForMe(d_stay);
		clickAction(d_stay, "Nights selected");
	}

	@Given("^User selects the passenger details \"([^\"]*)\" for the trip$")
	public void user_selects_the_passenger_details_for_the_trip(String pax_details) throws Throwable {
		WebElement d_paxtype = driver.findElement(
				By.xpath("//div[contains(@class,'dubai-pax-type')]//button[contains(text(),'" + pax_details + "')]"));
		waitForMe(d_paxtype);
		clickAction(d_paxtype, "Passenger type selected");
	}

	@Given("^User selects the activities from the activities list$")
	public void user_selects_the_from_the_activities_list() throws Throwable {

		List<WebElement> activitieslist = driver.findElements(By.xpath("//div[@class='row row-eq-hgt']/div"));
		if (activitieslist.size() > 0) {

			// selecting the first 4 activities from the activity list
			for (int i = 0; i <= 4; i++) {
				Thread.sleep(2000);
				activitieslist.get(i).click();
			}
			clickAction(dubaiPage.getBuildItinerary());
		}

	}

	@Then("^User validates the itinerary is created successfully$")
	public void user_validates_the_itinerary_is_created_successfully() throws Throwable {
		pollingWait(dubaiPage.getReviewInclusions(),120);
		String currentUrl = getCurrentUrl();
		validateAssertion(currentUrl.contains("view"));
	}
	
	
	@Then("^User Validate that the hotel section is displayed$")
	public void user_Validate_that_the_hotel_section_is_displayed() throws Throwable {
		try {
			while(elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
			}
		}catch(Exception e) {
			
		}
		validateAssertion(elementDisplayed(dubaiPage.getInclusionHeader()));
		clickAction(dubaiPage.getInclusionHeader());
		elementExist(inclusionNew.getHotelSection());
	}
	
	
	@Then("^user adds the split stay hotel$")
	public void user_adds_the_split_stay_hotel() throws Throwable {
		String itineraryTitle = driver.findElement(By.xpath("//h1[@id='title_editable']")).getText();
		String[] titleSplit = itineraryTitle.split(" ");
		String dayString = titleSplit[0]; 
		System.out.println(dayString);
		int dayInt = Integer.parseInt(dayString);
		clickAction(dubaiPage.getAddSplitStay(), "user verifies the split stay option is available");
		if(elementDisplayed(dubaiPage.getSplitStayModalText())) {
			clickAction(dubaiPage.getOrderOfStay());
			clickAction(dubaiPage.getEndStay());
		    clickAction(dubaiPage.getDurationOfStay());	
		    int duration = driver.findElements(By.xpath("//*[@class='border-less-select days-select']/option")).size();
			System.out.println(duration);
			validateAssertion(dayInt==duration);
		    clickAction(dubaiPage.getDurationOfDay());
		    verifyEnabled(dubaiPage.getFindHotels());
		    clickAction(dubaiPage.getFindHotels());
		    try {
		    waitForMe(dubaiPage.getHotelCard(),60);
		    System.out.println(hotelPage.gethotel_replaceHotelCardAlternate().isDisplayed());
		    }catch(NoSuchElementException e) {
		    	System.out.println("There is no alternate hotel available");
		    	assumeTrue(false);
		    }
		    clickAction(dubaiPage.getHotelCard());
		    clickAction(dubaiPage.getAddToItineraryCta());
		    Thread.sleep(4000);
		    }
		try {
			assertFalse(dubaiPage.getAddSplitStay().isDisplayed());
		}catch(NoSuchElementException e) {
			waitForMe(dubaiPage.getHotelCount());
			String hotelCount = dubaiPage.getHotelCount().getText();
            validate_String_Contains(hotelCount, "2");
			System.out.println("Split stay hotel is added successfully ");
			e.printStackTrace();
		}
		
	}
	
	
	@Then("^user delete the split stay hotel selected$")
	public void user_delete_the_split_stay_hotel_selected() throws Throwable {
	    clickAction(dubaiPage.getDeleteHotel());
	    Thread.sleep(1000);
	    validateAssertion(elementDisplayed(dubaiPage.getDeleteHotelAlert()));
	    clickAction(dubaiPage.getDeleteHotelConfirm());
	    Thread.sleep(1000);
	    validateAssertion(elementDisplayed(dubaiPage.getAddSplitStay()));
	}

	
	
		@Then("^user selects the \"([^\"]*)\"$")
		public void user_selects_the(String orderofstay) throws Throwable {
		clickAction(dubaiPage.getAddSplitStay(), "user verifies the split stay option is available");
		if(elementDisplayed(dubaiPage.getPytClose())) {
			clickAction(dubaiPage.getOrderOfStay());
			if(orderofstay.equals("at the beginning")) {
			clickAction(dubaiPage.getBeginningStay());
			}
			else {
				clickAction(dubaiPage.getEndStay());	
			}
		    clickAction(dubaiPage.getDurationOfStay());	
		    clickAction(dubaiPage.getDurationOfDay());
		    }
	}

		
		@Then("^user Validate that the split stay hotel is added according to the \"([^\"]*)\"$")
		public void user_Validate_that_the_split_stay_hotel_is_added_according_to_the(String orderofstay) throws Throwable {
			String beginningStayHotel="";
			String endStayHotel="";
			verifyEnabled(dubaiPage.getFindHotels());
		    clickAction(dubaiPage.getFindHotels());
		    waitForMe(dubaiPage.getHotelCard());
		    String hotelCardText = driver.findElement(By.xpath("(//section[@class='hotel_card']//*/span[@class='small-heading bold'])[1]")).getText();
		    System.out.println(hotelCardText);
		    clickAction(dubaiPage.getHotelCard());
		    clickAction(dubaiPage.getAddToItineraryCta());
		    Thread.sleep(1000);
		    waitForMe(booingReview.getbookNowButton());
		    if(orderofstay.equals("at the beginning")) {
		     beginningStayHotel = driver.findElement(By.xpath("(//div[@name='stay']//h4)[1]")).getText();
		     validate_String_Contains(beginningStayHotel,hotelCardText);
		    }
		    else {
		     endStayHotel = driver.findElement(By.xpath("(//div[@name='stay']//h4)[2]")).getText();
		     validate_String_Contains(endStayHotel,hotelCardText);	
		    }
		   
		}
	
		

		@Then("^user Validate that the duration option is less than the total duration of stay for split stay hotel$")
		public void user_Validate_that_the_duration_option_is_less_than_the_total_duration_of_stay_for_split_stay_hotel() throws Throwable {
		   String itineraryTitle = driver.findElement(By.xpath("//h1[@id='title_editable']")).getText();
			String[] titleSplit = itineraryTitle.split(" ");
			String dayString = titleSplit[0]; 
			System.out.println(dayString);
			int dayInt = Integer.parseInt(dayString);
			clickAction(dubaiPage.getAddSplitStay(), "user verifies the split stay option is available");
			if(elementDisplayed(dubaiPage.getPytClose())) {
			clickAction(dubaiPage.getDurationOfDay());
			int duration = driver.findElements(By.xpath("//*[@class='border-less-select days-select']/option")).size();
			System.out.println(duration);
			validateAssertion(dayInt==duration);
			
			
	}
		
			
		
		}


		@Then("^Check hotel options available in the alternate and validate the hotel name$")
		public void check_hotel_options_available_in_the_alternate_and_validate_the_hotel_name() throws Throwable {
			try {
				
				clickAction(dubaiPage.getNavigatetostaysinclusion());
								
				clickAction(dubaiPage.getChangeHotelInclusion());
				waitForMe(dubaiPage.getHotel_firsthotelname(), 15);
				String hotelname = dubaiPage.getHotel_firsthotelname().getText().trim();
				
				clickJavaScriptElement(dubaiPage.getHotel_firsthotelname());
				clickJavaScriptElement(dubaiPage.getDetailsPageAddToItinneraryButton());
				
				String afterhotelname = dubaiPage.getFirsthotelname().getText().trim();
				String[] afterhotelnamesplit = afterhotelname.split("@ ");
				String afterhotelnamesplitpart1 = afterhotelnamesplit[1];
				String[] afterhotelnamesplit0 = afterhotelnamesplitpart1.split("\\+");
				String afterhotelnameinclusion = afterhotelnamesplit0[0].trim();
				
				boolean finalhotelname =compareTwoStrings(hotelname, afterhotelnameinclusion);
				validateAssertion(finalhotelname);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
			
			
			}
		   
		
		
		
		
	}
