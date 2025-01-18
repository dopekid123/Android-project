package gluecode;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Kernel;
import utils.SeWrappers;

public class BannerCardsGlobalGlue extends Kernel{
	
	@Then("Click on Singapore banner card under Trending Destinations in global home page")
	public void click_on_singapore_banner_card_under_trending_destinations_in_global_home_page() {
		try
		{
			pollingWait(globalPage.getSingaporePackagesUnderTrendingDestinations(), 25);
			scrolltoElement(globalPage.getSingaporePackagesUnderTrendingDestinations());
			clickAction(globalPage.getSingaporePackagesUnderTrendingDestinations());
			String currentUrl = getCurrentUrl();
			System.out.println(currentUrl);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
}
