package gluecode;

import utils.Kernel;

import io.cucumber.java.en.Given;

public class HomePageGlue extends Kernel {

	@Given("^click guides link and verify its working$")
	public void click_guides_link_and_verify_its_working() throws Throwable {
		clickAction(hp.getGuides());
		switchWindows();
		validateAssertion(elementDisplayed(hp.getGuidesBreadCrumbInGuidesPage()));

	}

	@Given("^click blog link and verify its working$")
	public void click_blog_link_and_verify_its_working() throws Throwable {
		clickAction(hp.getBlog());
		switchWindows();
		Thread.sleep(3000);
//		validateAssertion(elementDisplayed(hp.getBlogIconInBlogPage()));
		validate_String_Contains(getCurrentUrl(),"/blog/");

	}

	@Given("^click aboutUs link and verify its working$")
	public void click_aboutUs_link_and_verify_its_working() throws Throwable {
		clickAction(hp.getAboutUs());
		switchWindows();
		validateAssertion(elementDisplayed(hp.getAboutTabInAboutUsPage()));

	}

	@Given("^click testimonial link and verify its working$")
	public void click_testimonial_link_and_verify_its_working() throws Throwable {
		hoverWebelement(hp.getHeaderSubmenu());
		clickAction(hp.getTestimonials());
		/*
		 * Commented by sharmila - 26-07-2021 Switchwindow is not necessary here since
		 * the link is opening on same tab switchWindows();
		 */
		validate_String_Contains(getCurrentUrl(), "/testimonials");
		/*
		 * Commented by sharmila - 26-07-2021 PYT logo xpath is not active on
		 * testimonial page clickAction(hp.getPytLogo());
		 */
	}

	@Given("^click careers link and verify its working$")
	public void click_careers_link_and_verify_its_working() throws Throwable {
		
		/*
		 * Commented by Meenatchi - 16-09-2021, hoverWebelement(hp.getHeaderSubmenu()); is not necessary here since
		 * the link is removed from the dropdown
		 */
		clickAction(hp.getCareers());
		switchWindows();
		validate_String_Contains(getCurrentUrl(), "/careers");
		/*
		 * Commented by sharmila - 26-07-2021 PYT logo xpath is not active on
		 * testimonial page clickAction(hp.getPytLogo());
		 */
	}

	@Given("^click visa link and verify its working$")
	public void click_visa_link_and_verify_its_working() throws Throwable {
		hoverWebelement(hp.getHeaderSubmenu());
		clickAction(hp.getVisa());
		/*
		 * Commented by sharmila - 26-07-2021 Switchwindow is not necessary here since
		 * the link is opening on same tab switchWindows();
		 */
		validate_String_Contains(getCurrentUrl(), "visa.");

	}

	@Given("^click faq link and verify its working$")
	public void click_faq_link_and_verify_its_working() throws Throwable {
		hoverWebelement(hp.getHeaderSubmenu());
		clickAction(hp.getFaq());
		/*
		 * Commented by sharmila - 26-07-2021 Switchwindow is not necessary here since
		 * the link is opening on same tab switchWindows();
		 */
		validate_String_Contains(getCurrentUrl(), "/faq");
		/*
		 * Commented by sharmila - 26-07-2021 PYT logo xpath is not active on
		 * testimonial page clickAction(hp.getPytLogo());
		 */
	}

	@Given("^click contactUs link and verify its working$")
	public void click_contactUs_link_and_verify_its_working() throws Throwable {
		hoverWebelement(hp.getHeaderSubmenu());
		clickAction(hp.getContactUs());
		/*
		 * Commented by sharmila - 26-07-2021 Switchwindow is not necessary here since
		 * the link is opening on same tab switchWindows();
		 */
		validate_String_Contains(getCurrentUrl(), "/contact-us");
		/*
		 * Commented by sharmila - 26-07-2021 PYT logo xpath is not active on
		 * testimonial page clickAction(hp.getPytLogo());
		 */
	}

}
