package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class TestimonialsPage {


	@FindBys(@FindBy(xpath="//a[@class='pull-left fw tracker-pkg-fbreview']"))

	private List<WebElement> testimonialsPackagesList;


//	@FindAll({
//			@FindBy(xpath = "//div[contains(@class,'tracker-visaonarrival-testimonialcard')]/a"),
//			@FindBy(xpath = "//div[contains(@class,'tracker-familyholidays-testimonialcard')]/a"),
//			@FindBy(xpath = "//div[contains(@class,'tracker-romanticholidays-testimonialcard')]/a"),
//			@FindBy(xpath = "//div[contains(@class,'tracker-adventuretrip-testimonialcard')]/a"),
//			@FindBy(xpath = "//div[contains(@class,'tracker-beachvacations-testimonialcard')]/a")
//
//	})
	@FindBy(xpath="//div[contains(@style,'testimonials')]/div")
	private List<WebElement> testimonialsLandingList;


	@FindBys(@FindBy(xpath="//a[@class='pull-left fw']"))

	private List<WebElement> testimonialsVacationsList;


	@FindBy(xpath="//button[@class='pull-right btn btn-link']")

	private WebElement  getCostBtn;

	@FindBy(xpath="//*[contains(@class,'header-testimonial')]")
	WebElement testimonial;

	@FindBy(xpath=("//h3[@class='color-base dim']"))
	WebElement travelledRegion;

	@FindBy(xpath=("//div[@class='filter-toggle-link bold']"))
	WebElement testimonialThemeDropdown;

	@FindBy(xpath=("//i[@class='pyt-global-16 small']"))
	WebElement testimonialRegionDropdown;


	@FindBy(xpath=("//i[@class=' pyt-close-16']"))
	WebElement testimonialResetFilter;

	//i[@class=' vehoicon-swap_vert']
	@FindBy(xpath=("//i[@class='pyt-sort-ascending-16']"))
	WebElement testimonialRatingRecentFilter;
	
	@FindBy(xpath=("(//*[contains(@class,'HeaderSubmenu')])[2]"))
	WebElement subMenuHomepage;
	
	@FindBy(xpath=("(//input[@name='sort']/../span)[2]"))
	WebElement testimonialMostRecentOption;
	


	public WebElement getTestimonialRatingRecentFilter() {
		return testimonialRatingRecentFilter;
	}

	public WebElement getTestimonialResetFilter() {
		return testimonialResetFilter;
	}

	public WebElement getTestimonialRegionDropdown() {
		return testimonialRegionDropdown;
	}

	public WebElement getTestimonialDropdown() {
		return testimonialThemeDropdown;
	}

	public WebElement getTravelledRegion() {
		return travelledRegion;
	}

	public WebElement getTestimonial() {
		return testimonial;
	}

	public List<WebElement> gettestimonialsOfPackages() {

		return testimonialsPackagesList;
	}

	public List<WebElement> gettestimonialsOfLanding() {

		return testimonialsLandingList;
	}

	public List<WebElement> gettestimonialsOfVacations() {

		return testimonialsVacationsList;
	}

	public WebElement getCostCloseBtn() {
		return getCostBtn;

	}
	
	public WebElement getSubMenuHomePage() {
		return subMenuHomepage;

	}
	
	public WebElement getTestimonialMostRecentOption() {
		return testimonialMostRecentOption;
	}


}
