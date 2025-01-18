package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SpeedboatListingPage {

	@FindBy(xpath = "//button[contains(text(),'Unlock deal')]")
	WebElement sbUnlockDeal;

	@FindBy(xpath = "//div[contains(text(),'View Deal')]")
	WebElement sbLogintoViewDeal;

	@FindBy(xpath = "(//div[@class='atom-web-c-lesPJm atom-web-c-lesPJm-idOqKNs-css']//button[(text()='View Deal')])[1]")
	WebElement sbfirstviewdeal;

	@FindBy(xpath = "(//span[@class='dropdown-toggle'])[1]| //div[contains(@class,'FilterDropdown__DestinationBox')]")
	WebElement sbGcmPill;

	@FindBy(xpath = "//button[contains(text(),'Search for packages')]")
	WebElement sbSearchAvailablePackages;

	@FindBy(xpath = "//input[@placeholder='Departing from']")
	WebElement sbListingDepCity;

	@FindBys(@FindBy(xpath = "(//div[@class='swiper-wrapper'])[2]//div[contains(@class,'swiper-slide')]//p"))
	List<WebElement> sbListingoverwaterHotelname;

	@FindBys(@FindBy(xpath = "(//div[@class='swiper-wrapper'])[1]//div[contains(@class,'swiper-slide')]//p"))
	List<WebElement> sbListinghoneymoonhotelname;

	@FindBys(@FindBy(xpath = "(//div[@class='swiper-wrapper'])[3]//div[contains(@class,'swiper-slide')]//p"))
	List<WebElement> sbListingkidshotelname;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'maldives-indian-food-resorts')]//b[@itemprop='name']"))
	List<WebElement> sbListingindianhotelname;

	@FindBys(@FindBy(xpath = "(//section[@class='row'])[4]//div[contains(@class,'resort-card')]//b[@itemprop='name']"))
	List<WebElement> sbListingPocketSavers;

	@FindBys(@FindBy(xpath = "(//div[@class='swiper-wrapper'])[4]//div[contains(@class,'swiper-slide')]//p"))
	List<WebElement> sbListingseaplanehotelname;

	@FindBy(xpath = "//div[@class='sort-items']//li[2]")
	WebElement sbPriceFilter;

	@FindBy(xpath = "//div[@class='sort-items']//li[3]")
	WebElement sbStarFilter;

	@FindBy(xpath = "//div[@class='sort-items']//li[4]")
	WebElement sbVillaFilter;

	@FindBy(xpath = "//div[@class='sort-items']//li[5]")
	WebElement sbMealFilter;

	@FindBy(xpath = "//div[@class='sort-items']//li[6]")
	WebElement sbOthersFilter;

	@FindBy(xpath = "//span[contains(text(),'Below ₹ 100k')]")
	WebElement below100k;

	@FindBy(xpath = "//span[contains(text(),'Below ₹ 150k')]")
	WebElement below150k;

	@FindBy(xpath = "//span[@class='atom-web-c-kZvpKt atom-web-c-kZvpKt-iMVRpC-size-3 atom-web-c-kZvpKt-ieOYwXt-css']")
	WebElement resortscard1;

	@FindBy(xpath = "//div[@class='atom-web-c-lesPJm atom-web-c-bqYwTd atom-web-c-kPTeuJ']")
	WebElement resortscard2;

	@FindBy(xpath = "//button[@role='switch']")
	WebElement pytRecommended;

	@FindBy(xpath = "//span[contains(text(),'re sorry')]")
	WebElement weresorry;

	@FindBy(xpath = "//span[@class='atom-web-c-kZvpKt atom-web-c-kZvpKt-iMVRpC-size-3 atom-web-c-kZvpKt-icvulKB-css'] | //span[text()='Edit']/../span[1]")
	WebElement editedDetails;

	@FindBy(xpath = "//span[text()='Edit']")
	WebElement sbEdit;

	@FindBy(xpath = "//div[contains(text(),'departing from Outside India')] | //a[text()='Skip this step']")
	WebElement sbdepcity;
	
	@FindBy(xpath = "//div//li[contains(text(),'Chennai')]")
	WebElement sbdepcityChennai;
	
	@FindBy(xpath = "//div//li[contains(text(),'Mumbai')]")
	WebElement sbdepcityMumbai;
	
	@FindBy(xpath = "//span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-iefIUiL-css']")
	WebElement itineraryEditDetails;

	@FindBy(xpath = "(//span[text()='22'])[3]")
	WebElement sbChooseDate;

	@FindBy(xpath = "//section[text()='3 Nights'] | //span[normalize-space()='3 Nights']")
	WebElement sbNoOfNights;
	
	@FindBy(xpath = "//section[text()='4 Nights'] | //span[@class='veho-c-kZvpKt veho-c-kZvpKt-hEhdYc-size-3 veho-c-kZvpKt-isloPO-css'][normalize-space()='4 Nights']")
	WebElement sb4Nights;
	
	@FindBy(xpath = "//section[text()='5 Nights'] | //span[normalize-space()='5 Nights']")
	WebElement sb5Nights;
	
	@FindBy(xpath = "//section[text()='6 Nights'] | //span[normalize-space()='6 Nights']")
	WebElement sb6Nights;

	@FindBy(xpath = "//section[contains(text(),'Couple')] | //span[text()='Couple']")
	WebElement sbChooseCouple;
	
	@FindBy(xpath = "//section[contains(text(),'Solo')] | //span[text()='Solo']")
	WebElement sbChooseSolo;
	
	@FindBy(xpath = "//section[contains(text(),'Family')] | //span[text()='Family']")
	WebElement sbChooseFamily;
	
	@FindBy(xpath = "//section[contains(text(),'Friends')] | //span[text()='Friends']")
	WebElement sbChooseFriends;
	
	@FindBy(xpath = "(//div//i[@class='sc-eGJbfJ cVtEOd pyt-plus-16'])[1] |  //span[normalize-space()='1']/../button[2]")
	WebElement sbAdultPlus;
	
	@FindBy(xpath = "//span[normalize-space()='2']/../button[2]")
	WebElement sbSecondAdult;
	
//	@FindBy(xpath = "(//div[@class='sc-bhNKFk bpMlTI']//i[@class='sc-eGJbfJ cVtEOd pyt-plus-16'])[2]")
	@FindBy(xpath = "(//i[contains(@class,'pyt-plus-16')])[2] | //span[normalize-space()='0']/../button[2]")
	WebElement sbFirstChild;
	
	@FindBy(xpath = "(//i[contains(@class,'pyt-plus-16')])[2] | //span[normalize-space()='1']/../button[2]")
	WebElement sbSecondChild;
	
	@FindBy(xpath = "(//select[@class='veho-c-bSkwCu'])[1]")
	WebElement sbChildAgeFirst;
	
	@FindBy(xpath = "(//select[@class='veho-c-bSkwCu'])[2]")
	WebElement sbChildAgeSecond;
	
	@FindBy(xpath = "//div//button[text()='View Trip Cost'] | //button[text()='Confirm changes']")
	WebElement sbViewTripCost;
	
	@FindBy(xpath = "(//button[normalize-space()='View Deal'])[2] | (//button[contains(text(),'View')])[1]")
	WebElement viewDeal;
	
	@FindBy(xpath = "//button[text()='View Details']")
	WebElement allViewDetails;

	@FindBy(xpath = "//div//span[text()='Add room'] | //button[contains(text(),'Add new room')]")
	WebElement sbAddRoom;
	
	@FindBy(xpath = "//div//span[contains(text(),'9 people')]")
	WebElement sbMaxPeople;
	
	@FindBy(xpath = "//div//span[text()='Delete room']")
	WebElement sbDeleteRoom;
	
	@FindBy(xpath = "//div//span[text()='Room 2']")
	WebElement sbNewRoom2;
	
	@FindBy(xpath = "//span[contains(text(),'Below ₹ 200k')]")
	WebElement below200k;

	@FindBy(xpath = "//span[contains(text(),'Above ₹ 200k')]")
	WebElement above200k;

	@FindBy(xpath = "//div[text()='3 Star'] | //span[normalize-space()='3 Star']")
	WebElement starrating3;

	@FindBy(xpath = "//div[text()='3 Star'] | //span[normalize-space()='4 Star']")
	WebElement starrating4;

	@FindBy(xpath = "//div[text()='3 Star'] | //span[normalize-space()='5 Star']")
	WebElement starrating5;

	@FindBy(xpath = "//span[text()='3']")
	WebElement starFiltercheck;

	@FindBy(xpath = "//span[text()='4']")
	WebElement starFiltercheck4;

	@FindBy(xpath = "//span[text()='5']")
	WebElement starFiltercheck5;

	@FindBy(xpath = "//div[text()='Water Villa'] | (//span[text()='Water Villa'])[1]")
	WebElement sbWaterVillaFilter;

	@FindBy(xpath = "//div[text()='Beach Bungalow'] | (//span[text()='Beach Bungalow'])[1]")
	WebElement sbBeachBungalowFilter;

	@FindBy(xpath = "//div[text()='Split Stay'] | (//span[text()='Split Stay'])[1]")
	WebElement sbSplitStayFilter;

	@FindBy(xpath = "//div[text()='Family Villa'] | (//span[text()='Family Villa'])[1]")
	WebElement sbFamilyVillaFilter;

	@FindBy(xpath = "//div[text()='Garden Villa'] | (//span[text()='Garden Villa'])[1]")
	WebElement sbGardenVillaFilter;

	@FindBy(xpath = "//div[text()='For the Honeymooners'] | //span[text()='For the Honeymooners']")
	WebElement sbHoneymooners;

	@FindBy(xpath = "//div[text()='Best Overwater Villa'] | //span[text()='Best Overwater Villa']")
	WebElement sbOverwater;

	@FindBy(xpath = "//div[text()='Seaplane only'] | //span[text()='Seaplane only']")
	WebElement sbSeaplaneOnly;

	@FindBy(xpath = "//div[text()='Kid Friendly Resorts'] | //span[text()='Kid Friendly Resorts']")
	WebElement sbKidFriendly;

	@FindBy(xpath = "//div[text()='Great Indian Food'] | //span[text()='Great Indian Food']")
	WebElement sbGreatIndianFood;

	@FindBy(xpath = "//div[text()='Closest to Airport'] | //span[text()='Closest to Airport']")
	WebElement sbClosestToAirport;

	@FindBy(xpath = "//span[contains(text(),'Half Board')]")
	WebElement sbHalfBoard;

	@FindBy(xpath = "//span[contains(text(),'Full Board')]")
	WebElement sbFullBoard;

	@FindBy(xpath = "//span[contains(text(),'Breakfast Only')]")
	WebElement sbBreakfastOnly;

	@FindBy(xpath = "//span[contains(text(),'All Inclusive')]")
	WebElement sbAllInclusive;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement sbApplyFilter;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElement sbResetFilter;

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement confirmButton;

	@FindBy(xpath = "//section[contains(@class,'ListingCardStyles__ResortListCardWrapper')]")
	WebElement listingcard;
	
	@FindBy(xpath = "//span[text()='Water Villa']")
	WebElement waterVillaText;
	
	@FindBy(xpath = "(//button[text()='Remove'])[5]")
	WebElement deleteSixthRoom;

	@FindBy(xpath = "(//button[text()='Remove'])[4]")
	WebElement deleteFifthRoom;
	
	@FindBy(xpath = "(//button[text()='Remove'])[3]")
	WebElement deleteFourthRoom;

	@FindBy(xpath = "//span[contains(normalize-space(),'Room 5')]")
	WebElement expandFifthRoomDetails;
	
	@FindBy(xpath = "//span[contains(normalize-space(),'Room 4')]")
	WebElement expandFourthRoomDetails;
	
	public WebElement getListingCard() {
		return listingcard;
	}

	public WebElement getUnlockDeal() {
		return sbUnlockDeal;
	}

	public WebElement getGCMPill() {
		return sbGcmPill;
	}

	public WebElement getSelectAvailablePackages() {
		return sbSearchAvailablePackages;
	}

	public WebElement getListingGCMDepartureCity() {
		return sbListingDepCity;
	}

	public WebElement getPriceFilter() {
		return sbPriceFilter;
	}

	public WebElement getStarFilter() {
		return sbStarFilter;
	}

	public WebElement getVillaFilter() {
		return sbVillaFilter;
	}

	public WebElement getMealFilter() {
		return sbMealFilter;
	}

	public WebElement getOthersFilter() {
		return sbOthersFilter;
	}

	public WebElement getWaterVillaFilter() {
		return sbWaterVillaFilter;
	}

	public WebElement getBeachBungalowFilter() {
		return sbBeachBungalowFilter;
	}

	public WebElement getSplitStayFilter() {
		return sbSplitStayFilter;
	}

	public WebElement getFamilyVillaFilter() {
		return sbFamilyVillaFilter;
	}

	public WebElement getGardenVillaFilter() {
		return sbGardenVillaFilter;
	}

	public WebElement getForHoneymoonersFilter() {
		return sbHoneymooners;
	}

	public WebElement getBestOverwaterVillaFilter() {
		return sbOverwater;
	}

	public WebElement getKidFriendlyResortsFilter() {
		return sbKidFriendly;
	}

	public WebElement getGreatIndianFoodFilter() {
		return sbGreatIndianFood;
	}

	public WebElement getSeaplaneOnlyFilter() {
		return sbSeaplaneOnly;
	}

	public WebElement getClosestToAirportFilter() {
		return sbClosestToAirport;
	}

	public WebElement getHalfBoardFilter() {
		return sbHalfBoard;
	}

	public WebElement getFullBoardFilter() {
		return sbFullBoard;
	}

	public WebElement getBreakfastOnlyFilter() {
		return sbBreakfastOnly;
	}

	public WebElement getAllInclusiveFilter() {
		return sbAllInclusive;
	}

	public WebElement getApplyChosenFilter() {
		return sbApplyFilter;
	}

	public WebElement getResetFilter() {
		return sbResetFilter;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}
	
	public WebElement getItineraryEditDetails() {
		return itineraryEditDetails;
	}

	public WebElement getSbdepcityChennai() {
		return sbdepcityChennai;
	}

	public WebElement getSbdepcityMumbai() {
		return sbdepcityMumbai;
	}
	
	public WebElement getStarFiltercheck4() {
		return starFiltercheck4;
	}

	public WebElement getStarFiltercheck5() {
		return starFiltercheck5;
	}

	public WebElement getStarFiltercheck() {
		return starFiltercheck;
	}
	
	public WebElement getStarrating3() {
		return starrating3;
	}

	public WebElement getStarrating4() {
		return starrating4;
	}

	public WebElement getStarrating5() {
		return starrating5;
	}
	
	public WebElement getsbfirstviewdeal() {
		return sbfirstviewdeal;
	}

	public WebElement getSbLogintoViewDeal() {
		return sbLogintoViewDeal;
	}

	public List<WebElement> getSbListingseaplanehotelname() {
		return sbListingseaplanehotelname;
	}

	public List<WebElement> getSbListingindianhotelname() {
		return sbListingindianhotelname;
	}

	public List<WebElement> getSbListingkidshotelname() {
		return sbListingkidshotelname;
	}

	public List<WebElement> getSbListinghoneymoonhotelname() {
		return sbListinghoneymoonhotelname;
	}

	public List<WebElement> getSbListingoverwaterHotelname() {
		return sbListingoverwaterHotelname;
	}

	public List<WebElement> getSbListingPocketSaversHotelname() {
		return sbListingPocketSavers;
	}
	
	public WebElement getSbViewTripCost() {
		return sbViewTripCost;
	}

	public WebElement getSbAdultPlus() {
		return sbAdultPlus;
	}
	
	public WebElement getSbSecondAdult() {
		return sbSecondAdult;
	}

	public WebElement getSbFirstChild() {
		return sbFirstChild;
	}
	
	public WebElement getSbSecondChild() {
		return sbSecondChild;
	}

	public WebElement getSbChildAgeFirst() {
		return sbChildAgeFirst;
	}

	public WebElement getSbChildAgeSecond() {
		return sbChildAgeSecond;
	}
	

	public WebElement getSbDeleteRoom() {
		return sbDeleteRoom;
	}

	public WebElement getSbNewRoom2() {
		return sbNewRoom2;
	}

	public WebElement getSbMaxPeople() {
		return sbMaxPeople;
	}

	public WebElement getSb4Nights() {
		return sb4Nights;
	}

	public WebElement getSb5Nights() {
		return sb5Nights;
	}

	public WebElement getSb6Nights() {
		return sb6Nights;
	}

	public WebElement getSbChooseSolo() {
		return sbChooseSolo;
	}

	public WebElement getSbChooseFamily() {
		return sbChooseFamily;
	}

	public WebElement getSbChooseFriends() {
		return sbChooseFriends;
	}

	public WebElement getSbAddRoom() {
		return sbAddRoom;
	}

	public WebElement getViewDeal() {
		return viewDeal;
	}

	public WebElement getSbEdit() {
		return sbEdit;
	}

	public WebElement getSbdepcity() {
		return sbdepcity;
	}

	public WebElement getSbChooseDate() {
		return sbChooseDate;
	}

	public WebElement getSbNoOfNights() {
		return sbNoOfNights;
	}

	public WebElement getSbChooseCouple() {
		return sbChooseCouple;
	}

	public WebElement getEditedDetails() {
		return editedDetails;
	}

	public WebElement getWeresorry() {
		return weresorry;
	}

	public WebElement getResortscard1() {
		return resortscard1;
	}

	public WebElement getPytRecommended() {
		return pytRecommended;
	}

	public WebElement getResortscard2() {
		return resortscard2;
	}

	public WebElement getBelow100k() {
		return below100k;
	}

	public WebElement getBelow150k() {
		return below150k;
	}

	public WebElement getBelow200k() {
		return below200k;
	}

	public WebElement getAbove200k() {
		return above200k;
	}
	
	public WebElement getWaterVillaText() {
		return waterVillaText;
	}
	
	public WebElement getDeleteSixthRoom() {
		return deleteSixthRoom;
	}

	public WebElement getDeleteFifththRoom() {
		return deleteFifthRoom;
	}

	public WebElement getDeleteFouthRoom() {
		return deleteFourthRoom;
	}

	public WebElement getExpandFifthRoomDetails() {
		return expandFifthRoomDetails;
	}

	public WebElement getExpandFourthRoomDetails() {
		return expandFourthRoomDetails;
	}
	
	public WebElement getAllViewDetails() {
		return allViewDetails;
	}


}
