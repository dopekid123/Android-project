package gluecode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class PackagesPageValidation extends Kernel {
	
	public static String destinationName,themeName,currentUrl,packagesUrl="";
	public static String destUrl="";
	
	@Then("^user validates the packages page$")
	public void user_validates_the_packages_page() throws Throwable {
		
		
		String currentUrl=driver.getCurrentUrl();
		packagesUrl = currentUrl+"packages";
		driver.navigate().to(packagesUrl);

		waitForLoad(driver,30);
		List<WebElement> li = driver.findElements(By.xpath("//*[text()='Destinations']/div/ul/li"));
		System.out.println("Destination :" + li.size());

		for(int i =2;i<=li.size();i++)
		{
         System.out.println("i---"+i);
			packagesPageValidation();
//			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("//*[text()='Destinations']/div/ul/li["+i+"]/label/span"));
			System.out.println("element ---"+ele);
//			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
//					.pollingEvery(Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(2000);
		destinationName=ele.getText();
//			destinationName= getText(ele);
			System.out.println("destinationName : "+destinationName);
			if(!(destinationName.contains("Singapore") || destinationName.contains("Dubai") || destinationName.contains("Bali"))) {
			moveTo(driver, ele);
			clickAction(ele);
			waitForLoad(driver,30);
			destUrl=driver.getCurrentUrl();
			Thread.sleep(3000);
//			themeSelection(destinationName);
			}
			
//			if(i==3)
//			{
//				break;
//			}
		}
	}
	




//themes selection 

public boolean themeSelection(String dest) throws Exception
{
	boolean retVal=false;

	List<WebElement> li = driver.findElements(By.xpath("//*[text()='Interests']/div/ul/li"));
	System.out.println("Themes :" + li.size());
	for(int i =1;i<=li.size();i++)
	{
		Thread.sleep(1000);
		themesPageValidation();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[text()='Interests']/div/ul/li["+i+"]/label/span"));
		themeName=getText(ele);
		System.out.println("Theme Name :"+themeName);
		waitForMe(ele);
		scrolltoElement(ele);
		clickAction(ele);
		waitForLoad(driver,30);
		Thread.sleep(1000);
//		minSeoItineraryCheck(dest,themeName);
		//kn.isImageBroken();
		List<String> seoitinerList = individualitineraryValidation(dest,themeName,"customize");
		if(seoitinerList.size()!=0)
		{
			if(seoItineraryIndvalidation(seoitinerList,dest,themeName))
			{
				retVal=true;
			}
		}
		
	}

	return retVal;
}
}

/*

//To Validate the Packages validation through Slug Url

@Test
public void packagesPageValidationThroughSlug() throws Exception
{

	try {

		setTCNameDesc("Packages Page - Costed and Validated Slug Itineraries in Packages Page", "Costed and Validated Slug Itineraries in Packages Page for different destinations with different themes");

		String currentUrl=driver.getCurrentUrl();
		packagesUrl=currentUrl+"packages";
		driver.navigate().to(packagesUrl);

		List<WebElement> li = driver.findElements(By.xpath("//a[@class='dropdown-toggle tracker-pkg-cities']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-destination']"));
		System.out.println("Destination :" + li.size());

		for(int i =2;i<=li.size();i++)
		{

			kn.packagesPageValidation();
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("(//a[@class='dropdown-toggle tracker-pkg-cities']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-destination'])["+i+"]//span"));
			destinationName= getText(ele);
			clickAction(ele);
			destUrl=driver.getCurrentUrl();
			Thread.sleep(3000);
			
			//This method is to select and validate Themes for that particular destination

			if(themeSelectionSlug(destinationName))
			{
				Reports.reportStep("Successfully Costed and Validated Packages page Slug Itineraries for "+destinationName, "PASS");
			}
			
			if(i==1)
			{
				break;
			}
		}
	}
	catch(Exception ex)
	{
		Reports.reportStep("Problem while Costing and Validating Packages page Slug Itineraries for "+destinationName, "FAIL");
	}
}	

//Themes selection for Slug

	public boolean themeSelectionSlug(String dest) throws Exception
	{
		boolean retVal=false;

		List<WebElement> li = driver.findElements(By.xpath("//a[@class='dropdown-toggle tracker-pkg-themes']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-themes']"));
		System.out.println("Themes :" + li.size());
		for(int i =1;i<=li.size();i++)
		{
			kn.themesPageValidation();
			Thread.sleep(1000);
			WebElement ele = driver.findElement(By.xpath("(//a[@class='dropdown-toggle tracker-pkg-themes']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-themes'])["+i+"]//span"));
			themeName=getText(ele);
			waitForMe(ele);
			clickAction(ele);
			Thread.sleep(1000);
			kn.minSeoItineraryCheck(dest,themeName);
			//kn.isImageBroken();
			//This method is to
			
			List<String> seoitinerList = kn.individualitineraryValidation(dest,themeName,"slug");
			if(seoitinerList.size()!=0)
			{
				if(kn.seoItineraryIndvalidation(seoitinerList,dest,themeName))
				{
					retVal=true;
				}
			}
			else
			{
				Reports.reportStep("There are No Itineraries for "+dest+" with "+themeName, "PASS");
				//			System.out.println("No Itineraries");
			}
			
			/*

			kn.themesPageValidation();
			kn.scroll();
			Thread.sleep(1000);
			WebElement ele = driver.findElement(By.xpath("(//a[@class='dropdown-toggle tracker-pkg-themes']//following::ul[@class='dropdown-menu']//li[@class='tracker-pkg-themes'])["+i+"]//span"));
			themeName=getText(ele);
			waitForMe(ele);
			clickAction(ele);
			Thread.sleep(1000);
			kn.scroll();
			kn.minSeoItineraryCheck(dest,themeName);
			
			if(kn.validateSlugItinerary(dest,themeName))
			{
				retVal=true;
			}
			
			*/
			
//		}

//		return retVal;
//	}
//	
	




	    
	


