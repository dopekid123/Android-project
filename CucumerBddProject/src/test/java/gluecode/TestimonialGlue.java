package gluecode;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class TestimonialGlue extends Kernel {


	@Then("^User validates the testimonial from landing page$")
	public void user_performs_testimonial_validation_Landing_Page() throws Throwable {

		Assert.assertTrue(TestimonialsOnLandingPage());

	}

	// Testimonials Validation from Vacations page
	@Then("^User validates the testimonial from vacations page$")
	public void user_performs_testimonial_validation_vacations_Page() throws Throwable {

		Assert.assertTrue(TestimonialsOnVacationsPage());

	}
	// Testimonials Validation from Packages page

	@Then("^User validates the testimonial from packages page$")
	public void user_performs_testimonial_validation_packages_Page() throws Throwable {

		Assert.assertTrue(TestimonialsOnPackagesPage());

	}

	//Testimonial filter Validation for trips for different regions

	@Then("^User Validating Testimonial Filter for \"([^\"]*)\" theme for different regions$")
	public void testimonial_Filter_Validation_for_theme_for_different_regions(String trip) throws Throwable {

		Assert.assertTrue(testimonialFilterValidation(trip));
	}

   //Testimonial reset filter validation

	@Then("^User Validating Testimonial Reset Filter for \"([^\"]*)\" theme$")
	public void testimonial_Reset_Filter_Validation(String trip) throws Throwable {
		Assert.assertTrue(testimonialResetFilterValidation(trip));
	}

	//Testimonial rating/recent filter validation

	@Then("^User Validating Testimonial Rating/Recent Filter for \"([^\"]*)\" theme$")
	public void testimonial_Rating_Recent_Filter_Validation(String trip) throws Throwable {
		Assert.assertTrue(testimonialRatingRecentFilterValidation(trip));
	}



}
