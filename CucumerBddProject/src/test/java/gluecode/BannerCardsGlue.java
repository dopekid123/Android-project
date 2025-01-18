package gluecode;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;

public class BannerCardsGlue extends Kernel {

	@Then("Click on Maldives banner card")
	public void click_on_maldives_banner_card() {

		try {

			pollingWait(hp.getbannerMaldives(), 25);
			assertTrue(hp.getbannerMaldives().isDisplayed());
			clickAction(hp.getbannerMaldives());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
			fail("Problem while click on Home page banner card");
		}
	}

	@Then("Click on Dubai banner card")
	public void click_on_dubai_banner_card() {
		try {
			pollingWait(hp.getbannerDubai(), 25);
			assertTrue(hp.getbannerDubai().isDisplayed());
			clickAction(hp.getbannerDubai());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Europe banner card")
	public void click_on_europe_banner_card() {
		try {
			pollingWait(hp.getbannerEurope(), 25);
			assertTrue(hp.getbannerEurope().isDisplayed());
			clickAction(hp.getbannerEurope());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Thailand banner card")
	public void click_on_thailand_banner_card() {
		try {
			pollingWait(hp.getbannerThailand(), 25);
			assertTrue(hp.getbannerThailand().isDisplayed());
			clickAction(hp.getbannerThailand());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Bali banner card")
	public void click_on_bali_banner_card() {
		try {
			pollingWait(hp.getbannerBali(), 25);
			assertTrue(hp.getbannerBali().isDisplayed());
			clickAction(hp.getbannerBali());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Austria banner card")
	public void click_on_austria_banner_card() {
		try {
			pollingWait(hp.getbannerAustria(), 25);
			assertTrue(hp.getbannerAustria().isDisplayed());
			clickAction(hp.getbannerAustria());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Finland banner card")
	public void click_on_finland_banner_card() {
		try {
			pollingWait(hp.getbannerFinland(), 25);
			assertTrue(hp.getbannerFinland().isDisplayed());
			clickAction(hp.getbannerFinland());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Norway banner card")
	public void click_on_norway_banner_card() {
		try {
			pollingWait(hp.getbannerNorway(), 25);
			assertTrue(hp.getbannerNorway().isDisplayed());
			clickAction(hp.getbannerNorway());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Italy banner card")
	public void click_on_italy_banner_card() {
		try {
			pollingWait(hp.getbannerItaly(), 25);
			assertTrue(hp.getbannerItaly().isDisplayed());
			clickAction(hp.getbannerItaly());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Switzerland banner card")
	public void click_on_switzerland_banner_card() {
		try {
			pollingWait(hp.getbannerSwitzerland(), 25);
			assertTrue(hp.getbannerSwitzerland().isDisplayed());
			clickAction(hp.getbannerSwitzerland());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on France banner card")
	public void click_on_france_banner_card() {
		try {
			pollingWait(hp.getbannerFrance(), 25);
			assertTrue(hp.getbannerFrance().isDisplayed());
			clickAction(hp.getbannerFrance());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on United Kingdom banner card")
	public void click_on_united_kingdom_banner_card() {
		try {
			pollingWait(hp.getbannerUk(), 25);
			assertTrue(hp.getbannerUk().isDisplayed());
			clickAction(hp.getbannerUk());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Turkey banner card")
	public void click_on_turkey_banner_card() {
		try {
			pollingWait(hp.getbannerTurkey(), 25);
			assertTrue(hp.getbannerTurkey().isDisplayed());
			clickAction(hp.getbannerTurkey());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Spain card")
	public void click_on_spain_card() {
		try {
			pollingWait(hp.getbannerTurkey(), 25); // Change if "Spain" needs a unique method
			assertTrue(hp.getbannerTurkey().isDisplayed());
			clickAction(hp.getbannerTurkey());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Azerbijan card")
	public void click_on_azerbijan_card() {
		try {
			pollingWait(hp.getbannerAzerbaijan(), 25);
			assertTrue(hp.getbannerAzerbaijan().isDisplayed());
			clickAction(hp.getbannerAzerbaijan());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Australia card")
	public void click_on_australia_card() {
		try {
			pollingWait(hp.getbannerAustralia(), 25);
			assertTrue(hp.getbannerAustralia().isDisplayed());
			clickAction(hp.getbannerAustralia());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on New zealand card")
	public void click_on_new_zealand_card() {
		try {
			pollingWait(hp.getbannerNewzealand(), 25);
			assertTrue(hp.getbannerNewzealand().isDisplayed());
			clickAction(hp.getbannerNewzealand());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Singapore card")
	public void click_on_singapore_card() {
		try {
			pollingWait(hp.getbannerSingapore(), 25);
			assertTrue(hp.getbannerSingapore().isDisplayed());
			clickAction(hp.getbannerSingapore());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Vietnam card")
	public void click_on_vietnam_card() {
		try {
			pollingWait(hp.getbannerVietnam(), 25);
			assertTrue(hp.getbannerVietnam().isDisplayed());
			clickAction(hp.getbannerVietnam());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Srilanka card")
	public void click_on_srilanka_card() {
		try {
			pollingWait(hp.getbannerSrilanka(), 25);
			assertTrue(hp.getbannerSrilanka().isDisplayed());
			clickAction(hp.getbannerSrilanka());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Philippines card")
	public void click_on_philippines_card() {
		try {
			pollingWait(hp.getbannerPhilippines(), 25);
			assertTrue(hp.getbannerPhilippines().isDisplayed());
			clickAction(hp.getbannerPhilippines());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Malaysia card")
	public void click_on_malaysia_card() {
		try {
			pollingWait(hp.getbannerMalaysia(), 25);
			assertTrue(hp.getbannerMalaysia().isDisplayed());
			clickAction(hp.getbannerMalaysia());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Japan card")
	public void click_on_japan_card() {
		try {
			pollingWait(hp.getbannerJapan(), 25);
			assertTrue(hp.getbannerJapan().isDisplayed());
			clickAction(hp.getbannerJapan());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Denmark card")
	public void click_on_denmark_card() {
		try {
			pollingWait(hp.getbannerDenmark(), 25);
			assertTrue(hp.getbannerDenmark().isDisplayed());
			clickAction(hp.getbannerDenmark());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Iceland card")
	public void click_on_iceland_card() {
		try {
			pollingWait(hp.getbannerIceland(), 25);
			assertTrue(hp.getbannerIceland().isDisplayed());
			clickAction(hp.getbannerIceland());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("Click on Sweden card")
	public void click_on_sweden_card() {
		try {
			pollingWait(hp.getbannerSweden(), 25);
			assertTrue(hp.getbannerSweden().isDisplayed());
			clickAction(hp.getbannerSweden());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			fail("Problem while clicking on Home page banner card");
		}
	}

	@Then("validate whether user logged in successfully")
	public void validate_whether_user_logged_in_successfully() {

		assertTrue(validateSuccessfulLogin());
	}

	@When("Create an Itinerary")
	public void create_an_itinerary() {

		assertTrue(pdgItineraryCreation());

	}

}
