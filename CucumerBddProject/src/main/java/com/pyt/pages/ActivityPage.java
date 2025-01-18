package com.pyt.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ActivityPage {

    
	@FindBy(xpath = "(//div[@name='activities']//button[@data-state='closed'])[1]")
	WebElement activity_ViewDetails;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement activity_RemoveButton;

	@FindBy(xpath = "//button[contains(text(),'Change Activity')]")
	WebElement activity_ChangeButton;
	
	@FindBy(xpath="(//div[contains(@name,'activities')]//section[1]//*[contains(text(),'Change')])[1]")
	WebElement firstActivityChangeButton;
	
	@FindBy(xpath = "//div[text()='PYT Recommended']//span")
	WebElement pytRecommended;
	
	@FindBy(xpath = "//b[text()='PYT Recommended']")
	WebElement pytRecommendedPill;
	
	
	



	@FindBy(xpath="//a[text()='Morning']")
	WebElement activity_MorningTimeSlotFilter;
	
	@FindBy(xpath="//a[text()='Afternoon']")
	WebElement activity_AfternoonTimeSlotFilter;
	
	@FindBy(xpath="//a[text()='Evening']")
	WebElement activity_EveningTimeSlotFilter;
	
	@FindBy(xpath="//a[text()='Quarter Day']")
	WebElement activity_QuarterDayDurationFilter;
	
	@FindBy(xpath="//a[text()='Half Day']")
	WebElement activity_HalfDayDurationFilter;
	
	@FindBy(xpath="//a[text()='Full Day']")
	WebElement activity_FullDayDurationFilter;
	
	@FindBy(xpath="//a[@value='transferIncluded']")
	WebElement activity_TranferIncludedFilter;
	
	@FindBy(xpath="//a[@value='transferNotIncluded']")
	WebElement activity_TranferNotIncludedFilter;
	
	//Group type filter shared/private filter
	@FindBy(xpath="//a[@value='shared']")
	WebElement activity_SharedFilter;
	
	@FindBy(xpath="//a[@value='private']")
	WebElement activity_PrivateFilter;
	
	//Interest filter from activity alternate page
	@FindBy(xpath="//a[text()='Art & Culture']")
	WebElement activity_ArtAndCulture;
	
	@FindBy(xpath="//a[text()='Adventure & Outdoor']")
	WebElement activity_AdventureAndOutdoor;
	
	@FindBy(xpath="//a[text()='Food & Nightlife']")
	WebElement activity_FoodAndNightlife;
	
	@FindBy(xpath="//a[text()='Shopping & Leisure']")
	WebElement activity_ShoppingAndLeisure;
	
	//Other filter section in activity alternate page 
	@FindBy(xpath="//a[text()='Top Highlight']")
	WebElement activity_TopHighlightsFilter;
	
	@FindBy(xpath="//a[text()='Kid Friendly']")
	WebElement activity_KidFriendlyFilter;
	
	@FindBy(xpath="//a[text()='Fast Selling']")
	WebElement activity_FastSellingFilter;
	
	@FindBy(xpath="//a[text()='Less explored gems']")
	WebElement activity_LessExploredGemsFilter;
	
	@FindBy(xpath="//a[text()='Self Exploration']")
	WebElement activity_SelfExplorationFilter;
	
	@FindBy(xpath="(//div[@class='slick-list'])[1]")
	WebElement firstActivity;
	
	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement activity_AddToItineraryButton;
	
	@FindBy(xpath = "(//span[contains(text(),'Add Activity')])[1]")
	WebElement addActivity;
	
	@FindBy(xpath="//div[@class='detail-box']//p//span")
	WebElement firstActivityName;
	
	@FindBy(xpath="//button[text()='Proceed with current selection']")
	WebElement proceedWithCurrentSelection;
	
	@FindBy(xpath="//div[@name='activities']")
	WebElement activitiesSection;
	
	@FindBy(xpath="(//div[@name='activities']//section[@class='veho-c-lesPJm veho-c-lesPJm-ihfRENr-css']//span)[1]")
	WebElement FirstActivitiesSectionName;
	
	@FindBy(xpath="(//div[@class='slick-list'])[1]")
	WebElement alternateActivityCard;
	
	@FindBy(xpath="//span[text()='Transfer  Included']")
	WebElement transfersIncluded;
	
	@FindBy(xpath="//span[text()='Transfer Not Included']")
	WebElement transfersNotIncluded;
	
	@FindBy(xpath="//p[contains(text(),'We couldn’t find activities')]")
	WebElement noActivities;

	@FindBy(xpath="//button[text()='Back to list']")
	WebElement backToList;
	
	@FindBy(xpath="//div[@class='slick-list']")
	WebElement alternateActivityCardAll;
	
	@FindBy(xpath="//span[text()='Shared activity']")
	WebElement sharedActivity;
	
	@FindBy(xpath="//span[text()='Private activity']")
	WebElement privateActivity;
	
	@FindBy(xpath="//button[contains(text(),'View')]")
	WebElement viewMoreActivities;
	
	
	








	

	


	@FindBy(xpath = "(//div[contains(@class,'activity-alter-card')])[1]")
	WebElement activity_ChangeAlternateActivity;

	
	
	//Activity slots in the itinerary page 
	@FindBy(xpath="(//*[text()='Full Day']/following-sibling::*[not(@data-full-text='At leisure' or contains(text(),'Arrive'))])[1]")
	WebElement activity_FirstFullDaySlot;
	
	@FindBy(xpath="(//*[text()='Morning to Noon' or text()='Noon to Evening']/following-sibling::*[not(@data-full-text='At leisure' or contains(text(),'Checkout')or contains(text(),'Arrive'))])[1]")
	WebElement activity_FirstHalfDaySlot;
	
	@FindBy(xpath="(//*[text()='Evening' or text()='Noon' or text()='Morning']/following-sibling::*[not(@data-full-text='At leisure' or contains(text(),'Checkout') or contains(text(),'Arrive'))])[1]")
	WebElement activity_FirstQuarterDaySlot;
	
	//View similar button in activity slider to access the activity alternate page
	@FindBy(xpath="//button[contains(text(),'Find More Activities')]")
	WebElement activitySlider_ViewSimilar;
	
	//View details button in the activity slider to access the activity details page 
	@FindBy(xpath="//button[contains(text(),'View details')]")
	WebElement activitySlider_ViewDetails;
	
	//Remove button in the activity slider 
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement activitySlider_Remove;
	
	//Add activity button in the activity slider,The button is only accessible if the user removed the activity
	@FindBy(xpath="//button[contains(text(),'Add Activity')]")
	WebElement activitySlider_AddActivity;
	
	//After user reomved the activity from activity slider the text will display in the slider "Activity removed" 
	@FindBy(xpath="//p[contains(text(),'Activity Removed')]")
	WebElement activitySlider_AfterRemove;
	
	//Right arrow in the activity slider 
	@FindBy(xpath="//i[contains(@class,'pyt-chevron-right')]")
	WebElement activitySlider_RightArrow;
	
	//Left arrow in the activity slider
	@FindBy(xpath="//i[contains(@class,'pyt-chevron-left')]")
	WebElement activitySlider_LeftArrow;
	
	//Search box in the activity alternate page 
	@FindBy(xpath="//div[contains(@class,'search')]/descendant::input")
	WebElement activityAlternate_SearchBox;
	
	//Activity Cards in the alternate page 
	@FindBy(xpath="//div[@class='activity-alter-card']")
	WebElement activityAlternate_Cards;
	
	//Activity Choose button in alternate page hover on Activity card
	@FindBy(xpath="//button[contains(text(),'Choose')]")
	WebElement activityAlternate_Choose;
	
	//Activity updated/added/removed/ success message notification
	@FindBy(xpath="//div[@class='msg-notification bottom-left']/p[@class='with-close']")
	WebElement activity_CrudSuccessMsgNoti;
	
	//Time slot filters in Activity alternate page 
	
	
	//Activity Duration filter in Alternate page
	
	
	//Activity transfer included/not included filter in alternate page 
	
	
	//Activity Smart filter
	
	@FindBy(xpath="//span[contains(@class,'slider')]")
	WebElement activity_SmartFilter;
	
	//Activtiy tab in the inclusions header with count of the activity
	@FindBy(xpath="//li/a[contains(text(),'Activity ')]")
	WebElement activity_InclusionsHeader;
	
	//View all activities button in Inclusion page
	@FindBy(xpath="//button[contains(text(),'View all')]")
	WebElement activity_ExpandActivityInclusions;
	
	//Show less activity button in inclusions page
	@FindBy(xpath="//button[contains(text(),'Show less activities')]")
	WebElement activity_ShowLessInclusions;
	
	//Activity 1st Card in inclusions page 
	@FindBy(xpath="//div[contains(@name,'activities')]//section[1]//i[contains(@class,'info')]")
	WebElement activity_InclusionsfirstCard;
	
	//Activity slider close 
	@FindBy(xpath="(//i[contains(@class,'pyt-close-16')])[3]")
	WebElement activity_SliderClose;
	
	//Filter pills in the alternate page 
	@FindBy(xpath="//span[@class='tag-sm round']")
	WebElement activity_FilterPill;
	
	//Self exploration tag in the alternate activity card
	@FindBy(xpath=" //b[contains(text(),'Self Exploration')]")
	WebElement selfExplorationTag;
	
	@FindBy(xpath="(//div[contains(@class,'activity-alter-card')]//span)[1]")
	WebElement nameOfActivityFirstCardAlternate;
	
	@FindBy(xpath="//div[contains(@class,'ContainerWrapper')]//span/span")
	List<WebElement> activityCountInInclusions;
	
	@FindBy(xpath="//button[contains(text(),'Back to itinerary')]")
	WebElement backToItineraryInAlternate;
	
	@FindBy(xpath="//*[contains(text(),'Retry')]")
	List<WebElement> retryCountInInclusions;
	
	@FindBy(xpath="(//*[contains(text(),'Full Day')]/..//*[contains(text(),'At leisure')])[1]")
	WebElement activity_FirstFullDayAtLeisureSlot;
	
	@FindBy(xpath="//*[contains(text(),'Morning to Noon')]/..//*[contains(text(),'At leisure')] | //*[contains(text(),'Noon to Evening')]/..//*[contains(text(),'At leisure')]")
	WebElement activity_FirstHalfDayAtLeisureSlot;
	
	@FindBy(xpath="//*[text()='Evening']/following-sibling::*[@data-full-text='At leisure'] | //*[text()='Morning']/following-sibling::*[@data-full-text='At leisure'] | //*[text()='Noon']/following-sibling::*[@data-full-text='At leisure']")
	WebElement activity_FirstQuarterDayAtLeisureSlot;

	@FindBy(xpath="//div[contains(@name,'activities')]//section[1]//*[contains(text(),'Change')]")
	WebElement changeActivityButtonInInclusions;
	
	@FindBy(xpath="//div[contains(@name,'activities')]//section[1]//*[contains(@class,'delete-btn')]")
	WebElement deleteActivityButtonInInclusions;
	
	@FindBy(xpath="//div[contains(@name,'activities')]//section[1]/div[1]")
	WebElement fisrtActivityTextInInclusions;
	
	
	
	
	@FindBys(@FindBy(xpath ="//span[contains(text(),'Add activity')]"))
	List<WebElement> leisureSlots;
	
	@FindBy(xpath="//input[@placeholder='Find an activity']")
	WebElement searchBox;
	
	@FindBy(xpath="//i[@class='pyt-activities_fill']/following::span[1]")
	WebElement activityPillCount;
	
	@FindBys(@FindBy(xpath ="//div[@name='activities']//span[contains(text(),'Included in Swiss Pass')]"))
	List<WebElement> swissPassTagCountOnCard;
	
	@FindBys(@FindBy(xpath ="//div[@name='activities']//h4"))
	List<WebElement> activityNames;
	
	@FindBys(@FindBy(xpath ="//span[contains(@class,'ItineraryNavigation__Tab')]//span[contains(text(),'Activity')]"))
	List<WebElement> activityNavigator;
	
	@FindBy(xpath="//p[text()='Remove Activities']")
	WebElement removeActivities;
	
	@FindBy(xpath="//span[contains(text(),'Proceed')]")
	WebElement removeActivitiesProceed;
	
	@FindBy(xpath="//span[text()='Activity Start Time']/following::b")
	WebElement activityStartTime;
	
	@FindBy(xpath="//div[@class='title']")
	WebElement viewDetailsTitle;
	
	@FindBy(xpath="//span[text()='Remove Activities']")
	WebElement removeAllActivities;
	
	@FindBy(xpath="//span[text()='Inclusions']")
	WebElement inclusions;
	
	@FindBy(xpath="(//button[text()='Choose'])[1]")
	WebElement choose;
	
	@FindBy(xpath="//button[text()='Ok, Continue']")
	WebElement swissContinue;
	
	
	public WebElement getSwissContinue() {
		return swissContinue;
	}

	public WebElement getChoose() {
		return choose;
	}

	public WebElement getInclusions() {
		return inclusions;
	}

	public WebElement getRemoveAllActivities() {
		return removeAllActivities;
	}

	public WebElement getViewDetailsTitle() {
		return viewDetailsTitle;
	}

	public void setViewDetailsTitle(WebElement viewDetailsTitle) {
		this.viewDetailsTitle = viewDetailsTitle;
	}

	public WebElement getViewMoreActivities() {
		return viewMoreActivities;
	}

	public WebElement getActivityStartTime() {
		return activityStartTime;
	}


	public WebElement getPytRecommended() {
		return pytRecommended;
	}

	
	public WebElement getPytRecommendedPill() {
		return pytRecommendedPill;
	}
	
	
	public WebElement getSharedActivity() {
		return sharedActivity;
	}


	public WebElement getPrivateActivity() {
		return privateActivity;
	}

	
	public WebElement getAlternateActivityCardAll() {
		return alternateActivityCardAll;
	}
	

	public WebElement getTransfersIncluded() {
		return transfersIncluded;
	}



	public WebElement getTransfersNotIncluded() {
		return transfersNotIncluded;
	}



	public WebElement getNoActivities() {
		return noActivities;
	}


	public WebElement getBackToList() {
		return backToList;
	}

	
	public WebElement getAlternateActivityCard() {
		return alternateActivityCard;
	}

	
	public WebElement getFirstActivity() {
		return firstActivity;
	}

	public WebElement getAddActivity() {
		return addActivity;
	}

	public WebElement getFirstActivityName() {
		return firstActivityName;
	}

	public WebElement getProceedWithCurrentSelection() {
		return proceedWithCurrentSelection;
	}

	public WebElement getActivitiesSection() {
		return activitiesSection;
	}
	
	public WebElement getRemoveActivitiesProceed() {
		return removeActivitiesProceed;
	}

	public WebElement getRemoveActivity() {
		return removeActivities;
	}

	
	public List<WebElement> getActivityNavigator(){
		return activityNavigator;
	}
	
	
	public List<WebElement> getActivityNames() {
		return activityNames;
	}
	
	public List<WebElement> getSwissPassTagCountOnCard() {
		return swissPassTagCountOnCard;
	}
	
	public WebElement getActivityPillCount() {
		return activityPillCount;
	}

	
	public WebElement getSearchBox() {
		return searchBox;
	}

	public List<WebElement> getLeisureSlots() {
		return leisureSlots;
	}

	public WebElement getBackToItineraryButtonInAlternate() {
		return backToItineraryInAlternate;
	}

	
	public WebElement getNameOfActivityFirstCardAlternate() {
		return nameOfActivityFirstCardAlternate;
	}

	public WebElement getSelfExplorationTag() {
		return selfExplorationTag;
	}

	public WebElement getActivity_FilterPill() {
		return activity_FilterPill;
	}

	public WebElement getActivity_SliderClose() {
		return activity_SliderClose;
	}

	public WebElement getActivity_InclusionsfirstCard() {
		return activity_InclusionsfirstCard;
	}

	public WebElement getActivity_InclusionsHeader() {
		return activity_InclusionsHeader;
	}

	public WebElement getActivity_ExpandActivityInclusions() {
		return activity_ExpandActivityInclusions;
	}

	public WebElement getActivity_ShowLessInclusions() {
		return activity_ShowLessInclusions;
	}

	public WebElement getActivity_MorningTimeSlotFilter() {
		return activity_MorningTimeSlotFilter;
	}

	public WebElement getActivity_AfternoonTimeSlotFilter() {
		return activity_AfternoonTimeSlotFilter;
	}

	public WebElement getActivity_EveningTimeSlotFilter() {
		return activity_EveningTimeSlotFilter;
	}

	public WebElement getActivity_QuarterDayDurationFilter() {
		return activity_QuarterDayDurationFilter;
	}

	public WebElement getActivity_HalfDayDurationFilter() {
		return activity_HalfDayDurationFilter;
	}

	public WebElement getActivity_FullDayDurationFilter() {
		return activity_FullDayDurationFilter;
	}

	public WebElement getActivity_TranferIncludedFilter() {
		return activity_TranferIncludedFilter;
	}

	public WebElement getActivity_TranferNotIncludedFilter() {
		return activity_TranferNotIncludedFilter;
	}

	public WebElement getActivity_SharedFilter() {
		return activity_SharedFilter;
	}

	public WebElement getActivity_PrivateFilter() {
		return activity_PrivateFilter;
	}

	public WebElement getActivity_ArtAndCulture() {
		return activity_ArtAndCulture;
	}

	public WebElement getActivity_AdventureAndOutdoor() {
		return activity_AdventureAndOutdoor;
	}

	public WebElement getActivity_FoodAndNightlife() {
		return activity_FoodAndNightlife;
	}

	public WebElement getActivity_ShoppingAndLeisure() {
		return activity_ShoppingAndLeisure;
	}

	public WebElement getActivity_TopHighlightsFilter() {
		return activity_TopHighlightsFilter;
	}

	public WebElement getActivity_KidFriendlyFilter() {
		return activity_KidFriendlyFilter;
	}

	public WebElement getActivity_FastSellingFilter() {
		return activity_FastSellingFilter;
	}

	public WebElement getActivity_LessExploredGemsFilter() {
		return activity_LessExploredGemsFilter;
	}

	public WebElement getActivity_SelfExplorationFilter() {
		return activity_SelfExplorationFilter;
	}

	public WebElement getActivity_SmartFilter() {
		return activity_SmartFilter;
	}

	public void setActivity_RemoveButton(WebElement activity_RemoveButton) {
		this.activity_RemoveButton = activity_RemoveButton;
	}

	public WebElement getActivity_CrudSuccessMsgNoti() {
		return activity_CrudSuccessMsgNoti;
	}

	public WebElement getActivity_ViewDetails() {
		return activity_ViewDetails;
	}

	public WebElement getActivity_FirstFullDaySlot() {
		return activity_FirstFullDaySlot;
	}

	public WebElement getActivity_FirstHalfDaySlot() {
		return activity_FirstHalfDaySlot;
	}

	public WebElement getActivity_FirstQuarterDaySlot() {
		return activity_FirstQuarterDaySlot;
	}

	public WebElement getActivitySlider_ViewSimilar() {
		return activitySlider_ViewSimilar;
	}

	public WebElement getActivitySlider_ViewDetails() {
		return activitySlider_ViewDetails;
	}

	public WebElement getActivitySlider_Remove() {
		return activitySlider_Remove;
	}

	public WebElement getActivitySlider_AddActivity() {
		return activitySlider_AddActivity;
	}

	public WebElement getActivitySlider_AfterRemove() {
		return activitySlider_AfterRemove;
	}

	public WebElement getActivitySlider_RightArrow() {
		return activitySlider_RightArrow;
	}

	public WebElement getActivitySlider_LeftArrow() {
		return activitySlider_LeftArrow;
	}

	public WebElement getActivityAlternate_SearchBox() {
		return activityAlternate_SearchBox;
	}

	public WebElement getActivityAlternate_Cards() {
		return activityAlternate_Cards;
	}

	public WebElement getActivityAlternate_Choose() {
		return activityAlternate_Choose;
	}
	
	public WebElement getActivity_viewDetails() {
		return activity_ViewDetails;
	}

	public WebElement getActivity_RemoveButton() {
		return activity_RemoveButton;
	}

	public WebElement getActivity_ChangeButton() {
		return activity_ChangeButton;
	}

	public WebElement getActivity_ChangeAlternateActivity() {
		return activity_ChangeAlternateActivity;
	}

	public WebElement getActivity_AddToItineraryButton() {
		return activity_AddToItineraryButton;
	}

	public List<WebElement> getActivityCountInInclusions() {
		return activityCountInInclusions;
	}

	public List<WebElement> getRetryCountInInclusions() {
		return retryCountInInclusions;
	}
	
	public WebElement getActivity_FirstFullDayAtLeisureSlot() {
		return activity_FirstFullDayAtLeisureSlot;
	}

	public WebElement getActivity_FirstHalfDayAtLeisureSlot() {
		return activity_FirstHalfDayAtLeisureSlot;
	}

	public WebElement getActivity_FirstQuarterDayAtLeisureSlot() {
		return activity_FirstQuarterDayAtLeisureSlot;
	}
	
	public WebElement getChangeActivityButtonInInclusions() {
		return changeActivityButtonInInclusions;
	}
	
	public WebElement getDeleteActivityButtonInInclusions() {
		return deleteActivityButtonInInclusions;
	}
	
	public WebElement getFirstActivityChangeButton() {
		return firstActivityChangeButton;
	}
	
	public WebElement getFirstActivitiesSectionName() {
		return FirstActivitiesSectionName;
	}
}
