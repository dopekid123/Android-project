
package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import utils.Kernel;

public class packagesPageGlue extends Kernel {
	public static String destinationName, themeName, currentUrl, packagesUrl = "";
	public static String destUrl = "";

	@And("validate the packages page from customize flow")
	
	public void packagesPageValidationThroughCustomize() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
		packagesUrl = currentUrl + "packages";
		driver.navigate().to(packagesUrl);

		List<WebElement> li = driver.findElements(By.xpath(
				"//a[@class='dropdown-toggle tracker-pkg-cities']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-destination']"));
		System.out.println("Destination :" + li.size());

		for (int i = 2; i <= li.size(); i++) {

			packagesPageValidation();
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath(
					"(//a[@class='dropdown-toggle tracker-pkg-cities']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-destination'])["
							+ i + "]//span"));
			destinationName = getText(ele);
			clickAction(ele);
			destUrl = driver.getCurrentUrl();
			Thread.sleep(3000);
			themeSelection(destinationName);
			
			if (i == 3) {
				break;
			}
		}


	}

	public void themeSelection(String dest) throws Exception {
		boolean retVal = false;

		List<WebElement> li = driver.findElements(By.xpath(
				"//a[@class='dropdown-toggle tracker-pkg-themes']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-themes']"));
		System.out.println("Themes :" + li.size());
		for (int i = 1; i <= li.size(); i++) {

			themesPageValidation();
			Thread.sleep(1000);
			WebElement ele = driver.findElement(By.xpath(
					"(//a[@class='dropdown-toggle tracker-pkg-themes']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-themes'])["
							+ i + "]//span"));
			themeName = getText(ele);
			waitForMe(ele);
			clickAction(ele);
			Thread.sleep(1000);
			minSeoItineraryCheck(dest, themeName);
			// kn.isImageBroken();
			List<String> seoitinerList = individualitineraryValidation(dest, themeName, "customize");
			if (seoitinerList.size() != 0) {
				seoItineraryIndvalidation(seoitinerList, dest, themeName);
					retVal = true;

			}

		}

	}

}
