package utils;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import gluecode.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;




public class SeWrappers {

	//	public static WebDriver driver;
	protected String browser = null;
	//Base class configuration file
	//	protected static Properties prop = new Properties();
	//packages page configuration file 
	protected static Properties packagesProperties = new Properties();

	File baseConfigFile = new File("configuration/config.properties");
	File packageConfig = new File("configuration/packages.properties");
	public WebDriverWait wait;
	WebElement highlightElement;
	// protected ITestContext suites;
	public static String environment= null;

	// public static ExtentReports extentReport;

	// public static ExtentTest extentTest;
	FluentWait<WebDriver> waiter;

	// Reports ;
	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;
	public static String reportlocation = "/reports/";

	//Packages page input
	protected static String packagesPageEnv = null;
	protected static int packageItineraries,vacationItineraries=0;
	//	public static RemoteWebDriver driver1;
	public static RemoteWebDriver driver;
	public static String sUrl,pUrl,sHubUrl,sHubPort,regname,username,pass,browserName,globalStag,globalUat,
	regemail,newuser,newemail,newemailaddress,newmobile,invalidUser,invalidPassword, globalUserUS,globalUserName,
	addluser, addlemail, addlmobile, cbrName, cbrMobile, cbrMail, vacationsNo, changeName, address1, address2,
	address3, state, pincode, adminUser, adminPassword, fromMail, toMail1, toMail2, toMail3, toMail4,toMail5, ccMail1,
	ccMail2, sendGridKey,localEnvUrl,costedItineraryPrice,costedItineraryPriceCompare,bookedItineraryPrice,bookedItineraryPriceCompare,deltaUrl,googleSearchConsoleUrl
	,sesHub, sesPort, sesUsername,sesPassword, toMail, ccMail, remoteHub, remotePort, platoUserName,platoPassword, globalUserUAE,globalUserUAEName, newPlatoUrl, Admin_Ipin, globalUserUSName, globalUserUAEPwd, globalUserUSPwd ;


	protected Properties prop;
	public static boolean browserVal=false;

	public SeWrappers() {
		prop = new Properties();
		try {

			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/configuration/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("stageUrl");
			pUrl= prop.getProperty("prodUrl");
			browserName=prop.getProperty("browser");
			adminUser = prop.getProperty("Admin_User");
			adminPassword = prop.getProperty("Admin_Password");
			username=prop.getProperty("Registered_User");
			pass=prop.getProperty("Registered_Password");
			regname=prop.getProperty("Registered_Name");
			regemail=prop.getProperty("Registered_Email");
			newuser = prop.getProperty("New_Username");
			newemail = prop.getProperty("New_Email");
			newemailaddress = prop.getProperty("New_Email_Address");
			newmobile = prop.getProperty("New_Mobile");
			addluser = prop.getProperty("New_Addl_User");
			addlemail = prop.getProperty("New_Addl_Email");
			addlmobile = prop.getProperty("New_Addl_Mobile");
			invalidUser = prop.getProperty("Invalid_User");
			invalidPassword = prop.getProperty("Invalid_Password");
			cbrName=prop.getProperty("cbrName");
			cbrMobile=prop.getProperty("cbrMobileNumber");
			cbrMail=prop.getProperty("cbrEmail");
			vacationItineraries=Integer.parseInt(prop.getProperty("vacationsItinerariesNumber"));
			packageItineraries=Integer.parseInt(prop.getProperty("packageItinerariesNumber"));
			changeName=prop.getProperty("newName");
			address1=prop.getProperty("address1");
			address2=prop.getProperty("address2");
			address3=prop.getProperty("address3");
			state=prop.getProperty("state");
			pincode=prop.getProperty("pincode");
			toMail1 = prop.getProperty("toMail1");
			toMail2 = prop.getProperty("toMail2");
			toMail3 = prop.getProperty("toMail3");
			toMail4 = prop.getProperty("toMail4");
			toMail5 = prop.getProperty("toMail5");
			ccMail1 = prop.getProperty("ccMail1");
			ccMail2 = prop.getProperty("ccMail2");
			sendGridKey = prop.getProperty("sendGridKey");
			costedItineraryPrice=prop.getProperty("costedItineraryPrice");
			costedItineraryPriceCompare=prop.getProperty("costedItineraryPriceCompare");
			bookedItineraryPrice=prop.getProperty("bookedItineraryPrice");
			bookedItineraryPriceCompare=prop.getProperty("bookedItineraryPriceCompare");
			googleSearchConsoleUrl=prop.getProperty("googleSearchConsoleUrl");
			globalUserUS=prop.getProperty("globalUser");
			globalUserName=prop.getProperty("Global_User_Name");
			platoUserName=prop.getProperty("Plato_UserName");
			platoPassword=prop.getProperty("Plato_Password");
			globalUserUAE=prop.getProperty("globalUser");
			globalUserUAEName=prop.getProperty("globalUAEUserName");
			globalUserUSName=prop.getProperty("globalUSUserName");
			globalUserUAEPwd=prop.getProperty("globalUserPwd");
			globalUserUSPwd=prop.getProperty("globalUserPwd");
			newPlatoUrl=prop.getProperty("newPlatoUrl");
			Admin_Ipin=prop.getProperty("Admin_Ipin");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void startApp(String browser, boolean bRemote, String env) {
		try {

			// this is for grid run
			if(bRemote)
			{

				try {

					/*
					 * Parallel run for Zalenium. Commenting the below code because we have migrated to Kubernetes
					 *
					if (browser.equalsIgnoreCase("chrome"))
					{
						System.out.println("Hub: "+sHubUrl);
						System.out.println("Port: "+sHubPort);
						driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), cap);

					}

					else
					{
					 */
					/*
					 * hubService is the mvn command line argument
					 * mvn -f pom-parallel.xml clean install -DconfigEnv=$URL -DforkCount=$SERVERS -DhubService=$SERVICE_URL -DreportUrl=$REPORT_URL -Dcucumber.options="--tags @$SCOPE"
					 */
					
					//Define desired capabilities
					DesiredCapabilities cap=new DesiredCapabilities();
					cap.setCapability("browserName", "Chrome");
					
					ChromeOptions chromeOptions = new ChromeOptions();
					//chromeOptions.setCapability("browserVersion", 115);
					chromeOptions.addArguments("--no-sandbox"); 
					chromeOptions.addArguments("--disable-dev-shm-usage"); 
					chromeOptions.addArguments("--disable-extensions"); // disabling extensions
					chromeOptions.addArguments("--disable-dev-shm-usage"); 
					
					cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
					

					sHubUrl=System.getProperty("hubService");
					sHubPort="4444";
					System.out.println("Hub Url: "+sHubUrl+":"+sHubPort+"/wd/hub");
					//driver = new RemoteWebDriver(new URL(sHubUrl+":"+sHubPort+"/wd/hub"), chromeOptions);
					driver = new RemoteWebDriver(new URL(sHubUrl+":"+sHubPort+"/wd/hub"), cap);

					//					}
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{ // this is for local run

				try
				{

					if(browser.equalsIgnoreCase("chrome")){
						try
						{
							//							System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
							//							ChromeOptions chromeOptions = new ChromeOptions();
							//							chromeOptions.addArguments("--disable-notifications");
							//							System.setProperty("webdriver.chrome.silentOutput", "true");
							//							driver= new ChromeDriver(chromeOptions);
							//							System.out.println("Launched chrome");
							//							browserVal=true;


							WebDriverManager.chromedriver().clearDriverCache().setup();
							ChromeOptions chromeOptions = new ChromeOptions();
							chromeOptions.addArguments("--disable-notifications");
							chromeOptions.addArguments("--remote-allow-origins=*");

							System.setProperty("webdriver.chrome.silentOutput", "true");
							driver= new ChromeDriver(chromeOptions);
							driver.manage().deleteAllCookies();
							driver.get("chrome://settings/clearBrowserData");
							driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
							System.out.println("Launched chrome");
							driver.manage().window().maximize();
							browserVal=true;
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}

					}
					else if(browser.equalsIgnoreCase("chromeLocal")){
						System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.addArguments("headless");
						chromeOptions.addArguments("window-size=1200x600");
						chromeOptions.addArguments("--disable-notifications");
						System.setProperty("webdriver.chrome.silentOutput", "true");
						driver= new ChromeDriver(chromeOptions);
						driver.manage().window().maximize();
					}
					//				
					else if (browser.equalsIgnoreCase("mobchrome")) {// This for mobile web
						
						WebDriverManager.chromedriver().clearDriverCache().setup();

						// Create ChromeOptions object
				        ChromeOptions options = new ChromeOptions();

				        // Add mobile emulation option to ChromeOptions
				        options.addArguments("--window-size=412,915"); // Set mobile resolution here

				        // Initialize ChromeDriver with ChromeOptions
				        driver = new ChromeDriver(options);
				        
				        // Example: Print current window size
				        Dimension size = driver.manage().window().getSize();
				        System.out.println("Current window size: " + size);
		
					}else if (browser.equalsIgnoreCase("firefox")) {

						System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
						driver = new FirefoxDriver();
						browserVal=true;

					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			localEnvUrl=env;
			driver.get("https://pickyourtrail.com/api/misc/usercleanup");
			driver.get(env);

		} catch (WebDriverException e) {
			System.out.println("The browser: "+browser+" could not be launched");
			browserVal=false;
			e.printStackTrace();
		}
	}


	public void startApp(String browser, String env) {
		//				System.out.println(browser);
		startApp(browser, false, env);
	}

	public void setTCNameDesc(String tcName,String tcDescription)
	{
		if(browserVal)
		{
			// Reports.startTestCase(tcName,tcDescription);
			// Reports.reportStep("The browser: "+browserName+" launched successfully",
			// "PASS");
		}
		else
		{
			// Reports.reportStep("The browser: "+browserName+" could not be launched",
			// "FAIL");

		}
	}




	/*
	 * Before suite method will run first in the suite were it will initializes
	 * WebDriver Extent Reports Synchronization waits Properties File
	 *
	 */

	/*

//	@BeforeSuite(alwaysRun = true)
	public void startUp(ITestContext suites) throws Exception {
		// Properties File Configuration
		FileInputStream baseConfig = new FileInputStream(baseConfigFile);
		prop.load(baseConfig);

		FileInputStream packagesPageConfig = new FileInputStream(packageConfig);
		packagesProperties.load(packagesPageConfig);

		//Packages page inputs

		packagesPageEnv = packagesProperties.getProperty("environment");
		noOfitineariesToTest= Integer.parseInt(packagesProperties.getProperty("noOfItineraries"));


		browser = prop.getProperty("browser");
		System.out.println("Browser : " + browser);
		String url = prop.getProperty("url");
		System.out.println("Browser :" + browser);
		String region = "";
		environment = prop.getProperty("environment");;
		String suiteName = "";
		util = new Utility();
		this.suites = suites;



		if (!(suites.getCurrentXmlTest().getParameter("sRegion") == null))

			region = suites.getCurrentXmlTest().getParameter("sRegion");

		if (!(suites.getCurrentXmlTest().getParameter("sBrowser") == null))

			browser = suites.getCurrentXmlTest().getParameter("sBrowser");

		if (!(suites.getSuite().getXmlSuite().getName() == null))

			suiteName = suites.getSuite().getXmlSuite().getName() + "_" + region;



		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Driver : " + driver);
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "driver/chromedriver");
			driver = new InternetExplorerDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile mypprofile =profile.getProfile("default");
			DesiredCapabilities dc = new DesiredCapabilities().firefox();
			dc.setCapability(FirefoxDriver.PROFILE, mypprofile);
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver();
			break;

		default :
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Driver from default : " + driver);
			break;
		}

		// Synchronization statements

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

	}

	 */

	public WebDriver getDriver() {
		return driver;
	}

	public void typeText(WebElement element, String msg) {
		try
		{
			pollingWait(element,20);
			if(element.isEnabled())
			{
				System.out.println("Element is enabled for interaction");
				Thread.sleep(1000);
				try
				{
					System.out.println("JS clear");
					JavascriptExecutor js= (JavascriptExecutor)driver;
					js.executeScript("arguments[0].value='';", element);
					Thread.sleep(2000);
				}
				catch(ElementNotInteractableException ex)
				{
					System.out.println("Selenium clear");
					element.clear();
					Thread.sleep(2000);
				}
				Thread.sleep(2000);
				for (int i = 0; i < msg.length(); i++) {
					try
					{
//						System.out.println("Inside send keys");
						element.sendKeys(Character.toString(msg.charAt(i)));
						Thread.sleep(270);			
					}

					catch(ElementNotInteractableException ex)
					{
//						System.out.println("Inside js");
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].value='"+msg+"';", element);
						Thread.sleep(1000);
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Failed to type the Webelement "+element);
			ex.printStackTrace();
		}

	}

	public void forceClick(WebElement ele) {
		//		WebElement element = driver.findElement(By.id("navigationPageButton"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).click().build().perform();
	}

	public WebElement waitForMe(WebElement element)
	{
		try
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element))); 
			// wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the Webelement: "+element, "FAIL");

		}
		return element;

	}


	public void waitForMe(WebElement first, WebElement second)
	{
		try
		{
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(first));
			wait.until(ExpectedConditions.visibilityOf(first));

			wait.until(ExpectedConditions.elementToBeClickable(second));
			wait.until(ExpectedConditions.visibilityOf(second));
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the
			// Webelements("+first.getText()+","+second.getText()+")", "FAIL");

		}

	}

	public void clickAction(WebElement element) throws InterruptedException {
		
		try {
			pollingWait(element,30);
			element.click();
		}
		catch(ElementNotInteractableException ex)
		{
			Thread.sleep(3000);
			clickJavaScriptElement(element);
		}
		catch (Exception ex) {
			// Reports.reportStep("Failed to click the Webelement "+element, "FAIL");
			System.out.println("Failed to click the Webelement "+element);
			ex.printStackTrace();
			Assert.fail();
		}
		
		
		
	}

	public void clickActionFailure(WebElement element) throws InterruptedException {

		try {
			Thread.sleep(3000);
			element.click();
			// Reports.reportStep("Successfully clicked the WebElement: "+element, "PASS");

		}
		catch(ElementNotInteractableException ex)
		{
			Thread.sleep(3000);
			// Reports.reportStep("Unable to click the "+element, "INFO");
			element.click();
		}
		catch (Exception ex) {
			// Reports.reportStep("Failed to click the Webelement "+element, "FAIL");
			ex.printStackTrace();
		}
	}




	public void clickAction(WebElement element, String msg) throws InterruptedException {

		try {
			//			waitForMe(element);
			pollingWait(element, 30);
			element.click();

		}
		catch(ElementNotInteractableException ex)
		{
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);
			js.executeScript("arguments[0].click()", element);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public boolean verifyClickAction(WebElement element) throws InterruptedException {
		boolean res= true;
		try {
			//			waitForMe(element);
			pollingWait(element, 30);
			element.click();

		}
		catch(ElementNotInteractableException ex)
		{
			res = false;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}











	public String getText(WebElement element) {

		String eleText="";
		try
		{
			//			waitForMe(element);
			pollingWait(element, 20);
			//			Thread.sleep(2000);
			eleText=element.getText();
			// Reports.reportStep("Successfully read text for the given Webelement
			// "+eleText, "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to read text for the given webelement "+eleText,
			// "FAIL");
		}
		return eleText;
	}


	public boolean compareTwoStrings(String actual, String expected) throws Exception
	{
		boolean retVal=false;
		//ReporteraddStepLog("Comparing " + actual + "Vs" + expected);

		//		Assert.assertEquals(expected, actual);

		if (expected.toLowerCase().contentEquals(actual.toLowerCase())) {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are matching ", "PASS");
			retVal = true;
		} else {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are not matching ", "FAIL");
			retVal = false;

		}
		return retVal;

	}

	public boolean compareTwoStringsPartially(String actual, String expected) throws Exception
	{
		boolean retVal=false;

		if (expected.toLowerCase().contains(actual.toLowerCase())) {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are partially matching ", "PASS");
			retVal=true;
		} else {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are not partially matching ", "FAIL");
			retVal=false;

		}
		return retVal;

	}



	public boolean compareTwoWebElements(WebElement e1, WebElement e2)
	{
		boolean retVal = false;
		try
		{
			String firstElement=e1.getText().toLowerCase();
			String secondElement=e2.getText().toLowerCase();
			if(firstElement.contentEquals(secondElement))
			{
				// Reports.reportStep("Text of both the Webelements are matching ", "PASS");
				retVal=true;
			}
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Text of both the Webelements are not matching ", "FAIL");
			retVal=false;
		}
		return retVal;
	}


	public boolean compareOneWebElementWithString(WebElement ele, String message, boolean showMessage)
	{
		boolean retVal=false;
		waitForMe(ele);
		if (ele != null && ele.isDisplayed()) {
			retVal = true;
			if (ele.getText() != null &&	ele.getText().length() > 0 && !ele.getText().equals(message)) {// use message if value = *
				//				pass("Verification Pass:  Element Found On UI : " + ele.getText());
				// Reports.reportStep("Value between the Webelement("+ele.getText()+") and the
				// given String("+message+") matches", "PASS");
			}
			else
			{
				retVal=false;
				//				pass("Verification Pass:  Element Found On UI : " + message);
				// Reports.reportStep("Value between the Webelement("+ele.getText()+") and the
				// given String("+message+") doesn't match", "FAIL");
			}

		}
		return retVal;

	}













	public String switchWindows() {
		String currentWindowHandle="";
		try {
			// Store the current window handle
			currentWindowHandle = driver.getWindowHandle();
			// Switch to new window opened

			Set<String> allWindows= driver.getWindowHandles();
			for (String winHandle : allWindows) {
				if (!winHandle.equals(currentWindowHandle) ) {
					driver.switchTo().window(winHandle);
					System.out.println("Successfully traversed to the required window");
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Problem while traversing to the required window");

		}

		return currentWindowHandle;
	}



	public String switchWindowspackages(String pwindow) {
		// Store the current window handle
		String winHandleBefore="";
		try {
			winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				if (!winHandle.contentEquals(winHandleBefore) && !winHandle.contentEquals(pwindow)) {
					driver.switchTo().window(winHandle);
					// Reports.reportStep("Successfully traversed through other windows", "PASS");

				}
			}
			return winHandleBefore;

		}

		catch(Exception ex)
		{
			// Reports.reportStep("Problem in navigating to different windows", "FAIL");

		}

		return winHandleBefore;
	}

	public void closeSwittchParentWindow(String window) {

		try
		{
			// Perform the actions on new window
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(window);
			
			System.out.println("Switched to parent window successfully");

		}
		catch(Exception ex)
		{
			ex.printStackTrace();

		}
	}

	// Creating a method getScreenshot and passing two parameters
	// driver and screenshotName
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String destination="";
		File finalDestination =null;
		try {
			// below line is just to append the date format with the screenshot name to
			// avoid duplicate names
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots" under src
			// folder

			screenshotName=screenshotName.replaceAll("\\s+", "");
			//			destination = System.getProperty("user.dir")+"/reports/images/" + screenshotName + dateName+ ".jpg";
			destination = "./reports/images/" + screenshotName + dateName
					+ ".jpg";
			finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			//			 Reports.reportStep("Captured the Failed TC screenshot successfully", "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in capturing Failed TC Screenshot", "FAIL");
		}
		// Returns the captured file path
		return destination;

	}

	public String getCurrentUrl() {

		String currentURL="";
		try
		{
			//ReporteraddStepLog("Capturing current URL");
			currentURL= driver.getCurrentUrl();
			// Reports.reportStep("Successfully captured the Current URL", "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in fetching the current URL", "FAIL");

		}
		return currentURL;

	}



	/*    *//**
	 * Waits for given WebElement to be present and visible (height and length >
	 * 1px) in DOM.
	 *
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitUntil(WebElement element, long timeOutInSeconds) {
		try
		{
			new WebDriverWait(driver, timeOutInSeconds).ignoring(NoSuchElementException.class)
			.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the Webelement: "+element, "FAIL");

		}


	}


	public boolean elementExist(WebElement ele) {
		try {
			pollingWait(ele,35);
			ele.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void elementNotExist(WebElement ele) {

		try {
			if (ele.getTagName() != null) {

			} else
				Assert.fail();
		} catch (Exception e) {
			System.out.println("User Not able to remove the hotel as expexted");
		}



	}


	public Boolean elementDisplayed(WebElement ele) {
		try {
			//			waitUntil(ele, 2);
			pollingWait(ele,30);
			// waitForMe(ele);
			if(ele.isDisplayed()) {
				// //Reports.reportStep("The element "+ele.getText()+" is displayed","INFO");
				return true;

			}
		} catch (Exception e) {
			//// Reports.reportStep("The element "+ele.getText()+" is not
			//// displayed","INFO");
			e.printStackTrace();
			return false;
		}
		return true;
	}



	//reports

	// @BeforeMethod

	//Navigate to different URl

	public void navigateToDiffUrlPackages(String environment)
	{
		try {

			if(packagesPageEnv.contentEquals("prod")) {
				driver.navigate().to("https://pickyourtrail.com/packages");
				// Reports.reportStep("Successfully navigated to
				// https://pickyourtrail.com/packages","PASS");

			}
			else if(packagesPageEnv.contentEquals("staging")) {
				driver.navigate().to("https://staging.pickyourtrail.com/packages");
				// Reports.reportStep("Successfully navigated to
				// https://staging.pickyourtrail.com/packages","PASS");

			}
			else if(packagesPageEnv.contentEquals("uat")) {
				driver.navigate().to("https://uat.pickyourtrail.com/packages");
				// Reports.reportStep("Successfully navigated to
				// https://uat.pickyourtrail.com/packages","PASS");

			}
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in navigating to Packages URL of
			// "+environment,"FAIL");

		}
	}


	public void navigateToEnvUrl(String url)
	{

		if(!(environment.contentEquals("prod")))
		{
			url = url.replace("env", environment);
		}

		driver.navigate().to(url);
	}

	public void navigateToUrl(String url)
	{
		try
		{
			System.out.println(url);
			driver.navigate().to(url);
			Thread.sleep(5000);

			// Reports.reportStep("Navigated to "+url, "PASS");

		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem while navigating to "+url, "FAIL");
		}
	}



	public static void hoverWebelement(WebElement HovertoWebElement)
	{
		try
		{
			Actions builder = new Actions(driver);
			builder.moveToElement(HovertoWebElement).build().perform();

		}
		catch(StaleElementReferenceException ex)
		{
			Actions builder = new Actions(driver);
			builder.moveToElement(HovertoWebElement).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("Unable to locate the elements in the page");
			ex.printStackTrace();
		}

	}
	public  void scrolltoElement(WebElement ScrolltoThisElement) {
		try {

			pollingWaitWithoutClickable(ScrolltoThisElement,40);
			Actions act = new Actions(driver);

			act.moveToElement(ScrolltoThisElement).build().perform();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}
	}
	public void scroll()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 300);");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public void scrollToReserveSlot()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 1000);");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public void scrollToEnd()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 4100);");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public void scrollToView(WebElement ScrolltoThisView)
	{
		try
		{
			Thread.sleep(1500);
			pollingWaitWithoutClickable(ScrolltoThisView, 30);
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);",ScrolltoThisView );
		
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public boolean verifyExistence(WebElement webElement, String message, boolean showMessage) throws Exception {

		boolean returnValue = false;

		try {

			highlightElement = null;

			if (webElement != null && webElement.isDisplayed()) {

				returnValue = true;

				if (webElement.getText() != null &&

						webElement.getText().length() > 0 &&

						!webElement.getText().equals("*")) {// use message if value = *



				} else {


				}

			} else {

				if (showMessage) {

					// fail("Verification Failed: Element Not Found On UI :" + message);

					// ScreenShot_Helper.capturefullPageScreenShot(driver, "i-" + message);

				} else {

					// reportLog("Verification Failed: Element Not Found On UI :"+message);

				}
			}
		} finally {

		}
		return returnValue;
	}




	public String getAttribute(WebElement ele, String attribute) {
		String bReturn = "";
		try {
			pollingWaitWithoutClickable(ele,15);
			bReturn=  ele.getAttribute(attribute);
			// Reports.reportStep("The element: "+ele+" was found.", "PASS");

		} catch (WebDriverException e) {
			// Reports.reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	// method to select values in drop down based on index
	public void selectDropDownUsingIndex(WebElement element, int indexer) {
		try
		{
			waitForMe(element);
			Select sel = new Select(element);
			sel.selectByIndex(indexer);
			// Reports.reportStep("The dropdown is selected with index: "+indexer,"PASS");
		}
		catch (WebDriverException e) {
			// Reports.reportStep("The element: "+element+" could not be found.", "FAIL");
		}

	}

	// method to select values in drop down based on Visible Text
	public void selectDropDownUsingVisibleText(WebElement element, String visibleText) {
		try
		{
			pollingWait(element,20);
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
			// Reports.reportStep("The dropdown is selected with visible text:
			// "+visibleText,"PASS");
		}
		catch (WebDriverException e) {
			// Reports.reportStep("The element: "+element+" could not be found.", "FAIL");
		}

	}


	// method to select values in drop down based on Value
	public void selectDropDownUsingValue(WebElement element, String value) {
		try
		{
			waitForMe(element);
			Select sel = new Select(element);
			sel.selectByValue(value);
			// Reports.reportStep("The dropdown is selected with value: "+value,"PASS");
		}
		catch (WebDriverException e) {
			// Reports.reportStep("The element: "+element+" could not be found.", "FAIL");
		}

	}


	public String getTitle() {
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		}
		return bReturn;
	}


	public boolean verifyTitle(String title) throws InterruptedException {
		boolean bReturn =false;
		try {
			Thread.sleep(3000);
			if(getTitle().equals(title)) {
				// Reports.reportStep("The title of the page matches with the value
				// :"+title,"PASS");
				bReturn= true;
			}else {
				// Reports.reportStep("The title of the page:"+driver.getTitle()+" did not match
				// with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the title",
			// "FAIL");
		}
		return bReturn;
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		boolean bReturn =false;
		try {
			//			waitForMe(ele);
			pollingWait(ele, 20);
			if(getText(ele).equals(expectedText)) {
				// Reports.reportStep("The text: "+getText(ele)+" matches with the value
				// :"+expectedText,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The text "+getText(ele)+" doesn't matches the actual
				// "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Text",
			// "FAIL");
		}
		return bReturn;

	}


	public boolean verifyPartialText(WebElement ele, String expectedText) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(getText(ele).contains(expectedText)) {
				// Reports.reportStep("The expected text contains the actual
				// "+expectedText,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The expected text doesn't contain the actual
				// "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Text",
			// "FAIL");
		}
		return bReturn;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(getAttribute(ele, attribute).equals(value)) {
				// Reports.reportStep("The expected attribute :"+attribute+" value matches the
				// actual "+value,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The expected attribute :"+attribute+" value does not
				// matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Attribute
			// Text", "FAIL");
		}

		return bReturn;

	}

	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(getAttribute(ele, attribute).contains(value)) {
				// Reports.reportStep("The expected attribute :"+attribute+" value contains the
				// actual "+value,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The expected attribute :"+attribute+" value does not
				// contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Attribute
			// Text", "FAIL");
		}
		return bReturn;
	}


	public boolean verifySelected(WebElement ele) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(ele.isSelected()) {
				// Reports.reportStep("The element "+ele+" is selected","PASS");
				bReturn=true;
			} else {
				// Reports.reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In verifySelected",
			// "FAIL");
		}
		return bReturn;
	}

	public boolean verifyEnabled(WebElement ele) {
		boolean retVal=false;
		try {
			//			waitForMe(ele);
			if(ele.isEnabled()) {
				retVal=true;

			} else {
				retVal=false;
			}
		} catch (WebDriverException e) {
			retVal=false;


		}
		return retVal;
	}

	public void switchWindowByIndex(int index)
	{
		try
		{
			Set<String> allWindowHandles=driver.getWindowHandles();
			List<String> allWindows=new ArrayList<String>();
			allWindows.addAll(allWindowHandles);
			driver.switchTo().window(allWindows.get(index));
			// Reports.reportStep("Switched to the given window index: "+index,"PASS");
		}
		catch (NoSuchWindowException e) {
			// Reports.reportStep("The driver could not move to the given window by index
			// "+index,"FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In switchToWindow",
			// "FAIL");
		}
	}

	public void switchToFrameByWebElement(WebElement ele)
	{
		try
		{
			driver.switchTo().frame(ele);
			// Reports.reportStep("Switched to Frame by Webelement "+ele,"PASS");
		}
		catch (NoSuchFrameException e) {
			// Reports.reportStep("NoSuchFrameException occured ","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In
			// switchToFrameByWebelement", "FAIL");
		}
	}

	public void switchToFrameByName(String frameName_ID)
	{
		try
		{
			driver.switchTo().frame(frameName_ID);
			// Reports.reportStep("Switched to Frame by Name/ID "+frameName_ID,"PASS");
		}
		catch (NoSuchFrameException e) {
			// Reports.reportStep("NoSuchFrameException occured ","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In
			// switchToFrameByName/ID", "FAIL");
		}
	}

	public void switchToFrameByIndex(int index)
	{
		try
		{
			driver.switchTo().frame(index);
			// Reports.reportStep("Switched to Frame by Index "+index,"PASS");
		}
		catch (NoSuchFrameException e) {
			// Reports.reportStep("NoSuchFrameException occured ","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In switchToFrameByIndex",
			// "FAIL");
		}
	}

	public void acceptAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			// Reports.reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException ex) {
			// Reports.reportStep("There is no alert present","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In dismissAlert", "FAIL");
		}
	}

	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			// Reports.reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			// Reports.reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In dismissAlert", "FAIL");
		}

	}

	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			// Reports.reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In getAlertText", "FAIL");
		}
		return text;
	}

	public void closeBrowser() {
		try {
			driver.close();
			// Reports.reportStep("The current browser session is closed","PASS");
		} catch (Exception e) {
			// Reports.reportStep("The current browser session could not be closed","FAIL");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			driver.manage().deleteAllCookies();
			// //Reports.reportStep("All the opened browsers are closed","INFO");
		} catch (Exception e) {
			// //Reports.reportStep("Unexpected error occurred while closing all the opened
			// browsers","FAIL");
		}
	}

	public void doubleClick(WebDriver driver, WebElement ele)
	{
		try
		{
			waitForMe(ele);
			Actions doubleClk = new Actions(driver);
			doubleClk.moveToElement(ele).doubleClick().build().perform();
			// Reports.reportStep("Double clicked the given
			// Webelement("+ele.getText()+")","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to double click the given
			// Webelement("+ele.getText()+")","FAIL");
		}
	}

	public void rightClick(WebDriver driver, WebElement ele)
	{
		try
		{
			waitForMe(ele);
			Actions rightClk = new Actions(driver);
			rightClk.moveToElement(ele).contextClick().build().perform();
			// Reports.reportStep("Right clicked the given
			// Webelement("+ele.getText()+")","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to right click the given
			// Webelement("+ele.getText()+")","FAIL");
		}
	}

	public void dragDropUsingClickAndHold(WebDriver driver, WebElement dragElement,WebElement dropElement)
	{
		try
		{
			waitForMe(dragElement, dropElement);
			Actions dragDrop = new Actions(driver);
			dragDrop.clickAndHold(dragElement).moveToElement(dropElement).build().perform();
			// Reports.reportStep("Drag and dropped using Click and Hold","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to drag and drop using Click and Hold","FAIL");
		}
	}

	public void moveToSubMenu(WebDriver driver, WebElement menu, WebElement subMenu)
	{
		try
		{
			waitForMe(menu, subMenu);
			Actions navigateSubMenu = new Actions(driver);
			navigateSubMenu.moveToElement(menu).moveToElement(subMenu).build().perform();
			// Reports.reportStep("Moved to the Sub Menu","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to move to the Sub menu","FAIL");
		}
	}

	public void dragDrop(WebDriver driver, WebElement dragElement,WebElement dropElement)
	{
		try
		{
			waitForMe(dragElement, dropElement);
			Actions dragDrop = new Actions(driver);
			dragDrop.dragAndDrop(dragElement,dropElement).build().perform();
			// Reports.reportStep("Drag and dropped the given Webelement to the target
			// element","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to drag and drop the given Webelement to the
			// target element","FAIL");
		}
	}

	public void moveTo(WebDriver driver, WebElement moveElement)
	{
		try
		{
			waitForMe(moveElement);
			Actions moveTo = new Actions(driver);
			moveTo.moveToElement(moveElement).build().perform();
			// Reports.reportStep("Moved to the given Webelement ","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to move to the given Webelement","FAIL");
		}
	}


	public void moveToUrl(WebDriver driver)
	{
		try
		{
			Thread.sleep(2000);
			Dimension initial_size = driver.manage().window().getSize();
			int ab =initial_size.getHeight();
			System.out.println("Window size"+initial_size);
			System.out.println(initial_size.getHeight());
			//			moveToUrl.keyDown(Keys.CONTROL)
			//			   .click(ele)
			//			   .moveByOffset( 0, 20 )
			//			   .keyUp(Keys.CONTROL).build().perform();
			Actions moveToUrl = new Actions(driver);
			moveToUrl.moveByOffset(0, -750).click().build().perform();
			// Reports.reportStep("Dragged the Mouse pointer to the Url","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to drag the Mouse pointer to the Url","FAIL");
		}
	}




	public boolean uploadFileUsingSendKeys(WebElement ele, String path)
	{
		boolean retVal=false;
		try
		{
			waitForMe(ele);



		}
		catch(Exception ex)
		{
			retVal=false;
		}
		return retVal;
	}

	/*
	 * Author : karthick Description : Following method will get the webelement and
	 * return total count as String Category : Validation
	 */
	//
	//	public void String (WebElement ele) {
	//		driver.findElements(by)
	//		Assert.assertTrue(actual.contains(expected));
	//	}

	/*
	 * Author : karthick Description : Following method will check if expected sting
	 * in available in actual String Similar to contains method of String class
	 * Category : Validation
	 */

	public void validate_String_Contains(String actual, String expected) {
		//		Reporter.addStepLog("Validating " + actual + " contains " + expected + "");
		System.out.println("Validating " + actual + " contains " + expected + "");
		Assert.assertTrue(actual.contains(expected));
	}

	//Assertions or validations

	public boolean validateAssertion(boolean value) {
		if(value == true)
		{
			Assert.assertTrue(value);
			return true;
			//ReporteraddStepLog("Assertion Passed");
		}
		else
		{
			Assert.assertTrue(value);
			return true;
			//ReporteraddStepLog("Assertion Failed");
		}
	}

	public void clickJavaScriptElement(WebElement element) throws InterruptedException {
		try {
			pollingWait(element, 15);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView()", element);
			executor.executeScript("arguments[0].click()", element);
		} catch (ElementNotInteractableException ex) {
			Thread.sleep(3000);
			System.out.println("Unable to click for the first time and trying one more time");
			element.click();
		} catch (Exception ex) {
			System.out.println("Failed to click the Javascript Webelement");
			scrolltoElement(element);
			actionsClick(element);
		}
	}

	public void clickDisbledJavaScriptElement(WebElement element) throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].removeAttribute('disabled');", element);
	        executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', { bubbles: true }))", element);			
	        System.out.println("Successfully clicked the disabled element");
		} catch (ElementNotInteractableException ex) {
			Thread.sleep(3000);
			System.out.println("Unable to click for the first time and trying one more time");
			element.click();
		} catch (Exception ex) {
			System.out.println("Failed to click the Javascript Webelement");
			ex.printStackTrace();
		}
	}

	public void pollingWait(WebElement element,int timeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean pollingWaitForCostingFlow(String element,int timeout) {
		boolean retVal=false;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.urlContains(element));
			retVal=true;
		} catch (NoSuchElementException e) {
			//ReporteraddStepLog("Unable to locate Element : " + element);
		}
		return retVal;
	}	
	public boolean verifyStringNotEquals(String actual, String expected) {
		boolean retVal=false;

		try {
			//ReporteraddStepLog(actual + " string should not contain " + expected);
			Assert.assertFalse(actual.contains(expected));
			retVal=true;
		}
		catch(Exception ex)
		{
			//ReporteraddStepLog("Problem in comparing the strings "+actual+"--->"+expected);

		}
		return retVal;
	}

	public void actionsClick(WebElement ele)
	{
		try
		{
//			pollingWait(ele,20);
			scrollToView(ele);
			Actions singleClick = new Actions(driver);
			singleClick.moveToElement(ele).click().build().perform();
			// Reports.reportStep("Double clicked the given
			// Webelement("+ele.getText()+")","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to double click the given
			// Webelement("+ele.getText()+")","FAIL");
			//ReporteraddStepLog("Problem while clicking the Webelement "+ele);
		}
	}


	public void scrollUp()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-750)"); 
			//ReporteraddStepLog("Successfully scrolled up the page");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");
			//ReporteraddStepLog("Problem while scrolling up the page");
		}
	}


	public void scrollByValue(int value)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,"+value+")"); 
			//ReporteraddStepLog("Successfully scrolled up the page");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");
			//ReporteraddStepLog("Problem while scrolling up the page");
		}
	}

	public void scrollDown()
	{
		try
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,3000)");
			//ReporteraddStepLog("Successfully scroller down to the page");
			// Reports.reportStep(“Successfully scrolled down to the page”,“INFO”);
		}
		catch(Exception ex)
		{
			// Reports.reportStep(“Problem in scrolling down to the page”,“FAIL”);
			//ReporteraddStepLog("Problem in scrolling down to the page");
		}
	}

	public void actionTypeText( WebElement ele,String text) {
		try {
			waitForMe(ele);
			Actions typeText = new Actions(driver);
			typeText.sendKeys(ele,text).build().perform();


		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to double click the given
			// Webelement("+ele.getText()+")","FAIL");
			//			Reporter.addStepLog("Problem while clicking the Webelement "+ele);
			ex.printStackTrace();
		}
	}


	public boolean scrollTo(int val) {
		boolean flag = false;
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, " + val + ");");
			flag = true;
		} catch (Exception ex) {
			System.out.println("Failed to scroll");
		}
		return flag;
	}

	public WebElement waitForMe(WebElement element,int timeOut)
	{
		try
		{
			wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			//wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception ex)
		{
			System.out.println("Unable to locate the Webelement: "+element);

		}
		return element;
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public Boolean verifyIsDisabled(WebElement element) {
		Boolean disabled = false;

		try
		{
			disabled = (Boolean) driver.executeScript("return arguments[0].hasAttribute(\"disabled\");", element);
			System.out.println(element+" is disabled with value "+disabled);
			return disabled;
		}
		catch(Exception ex)
		{
			System.out.println("Unable to locate the disabled attribute in the webelement: "+element);

		}
		return disabled;


	}

	public void openInNewWindow(WebElement element)
	{
		try
		{
			System.out.println(element);
			String keyString =   Keys.CONTROL+Keys.SHIFT.toString()+Keys.ENTER.toString();
			element.sendKeys(keyString);


		}
		catch(Exception ex)
		{
			System.out.println("Error opening in New tab" +ex.getMessage());
		}
	}

	public void openInNewTab(WebElement element)
	{
		try
		{
			System.out.println(element);
			String packageLink=element.getAttribute("href");
			System.out.println(packageLink);
			((JavascriptExecutor)driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(packageLink);


		}
		catch(Exception ex)
		{
			System.out.println("Error opening in New tab" +ex.getMessage());
		}
	}

	public void typeCharacter(WebElement element, char msg) {
		try
		{
			pollingWait(element,20);
			//element.clear();
			Thread.sleep(200);
			System.out.println("ch-->"+msg);
			//typeTextUsingJS(element,msg);
			element.sendKeys(Character.toString(msg));
			
		}
		catch(Exception ex)
		{
			System.out.println("Failed to type the Webelement "+element);
			ex.printStackTrace();
		}

	}
	
	public void typeTextUsingJS(WebElement ele, char text)
	{
		ele.isEnabled();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));

		//ele.clear();
		pollingWait(ele,20);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+text+"'", ele);  

	}
	
	public boolean findAllElements(String xpathLocator)
	{
		boolean retVal=false;
		
		List<WebElement> allElements= driver.findElements(By.xpath(xpathLocator));
		if(allElements.size() > 0)
		{
			retVal= true;
		}
		
		return retVal;

	}
	
	public boolean isElementVisible(WebElement element,int timeOut)
	{
		
		boolean retVal=false;
		try
		{
			wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			retVal=true;
		}
		catch(Exception ex)
		{
			System.out.println("Unable to locate the Webelement: "+element);
			Assert.fail();

		}
		return retVal;
	}
	
	
	public void selectavailabledate () {
		 try {
	            // Find all available elements with a common selector
	            List<WebElement> availableElements = driver.findElements(By.cssSelector("div[aria-disabled='false']"));

	            // Check if there are any available elements
	            if (!availableElements.isEmpty()) {
	                // Click the first available element
	                availableElements.get(0).click();
	            } else {
	                System.out.println("No available elements found.");
	            }
	        } catch (Throwable e) {
	            e.printStackTrace();
	        } 
	}
	
	public void pressEnter(WebElement ele)
	{
		pollingWait(ele,15);
		ele.sendKeys(Keys.ENTER);

	}
	
	public boolean waitForUrl(String url)
	{
		boolean retVal=false;
		try
		{
			//Added extra 5 seconds on Mar25 to load the itinerary page
			wait = new WebDriverWait(driver, 80);
			wait.until(ExpectedConditions.urlContains(url)); 
			retVal=true;
		}
		catch(Exception ex)
		{
			System.out.println("Continue CTA is taking more time to load the itinerary");
			ex.printStackTrace();
		}
		return retVal;

	}
	
	public void pollingWaitWithoutClickable(WebElement element,int timeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void traverseBackInHistory()
	{
		driver.navigate().back();
	}


	public  void scrolltoElementAndClick(WebElement ScrolltoThisElement) {
		try {

			pollingWaitWithoutClickable(ScrolltoThisElement,30);
			Actions act = new Actions(driver);

			act.moveToElement(ScrolltoThisElement).click().build().perform();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}/**
     * Uploads a file by sending the file path to the file input element.
    *
    * @param ele      The file input WebElement where the file path is to be set.
    * @param filePath The absolute or relative path to the file to be uploaded.
    */
	public void fileUpload(WebElement ele, String filePath)
	{
		try
		{
			pollingWait(ele, 20);

	        // Upload the file
	        ele.sendKeys(filePath);
	        
	        System.out.println("Upload successful");
		}
		catch(Exception ex)
		{
			System.out.println("Problem while uploading the file");
			ex.printStackTrace();		
		}
	}
	
	/**
    * Uploads a file by setting the file path to the file input element using JavaScript.
    *
    * @param ele      The file input WebElement where the file path is to be set.
    * @param filePath The absolute or relative path to the file to be uploaded.
    */
   public void fileUploadUsingJS(WebElement ele, String filePath) {
       try {
           // Use JavaScript to set the file path
           JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
           jsExecutor.executeScript("arguments[0].style.display='block';", ele); // Make the element visible if it is hidden
           jsExecutor.executeScript("arguments[0].value=arguments[1];", ele, filePath);
       } catch (Exception ex) {
           System.out.println("Problem while uploading the file");
           ex.printStackTrace();
       }
   }
   
   /**
    * Uses the Robot class to simulate file upload by copying the file path to the clipboard and pasting it.
    *
    * @param filePath The absolute path to the file to be uploaded.
    * @throws AWTException If the platform configuration does not allow low-level input control.
    */
   public void uploadFileWithRobotInWindows(String filePath) throws AWTException {
       // Copy the file path to the clipboard
       StringSelection stringSelection = new StringSelection(filePath);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

       // Create an instance of Robot class
       Robot robot = new Robot();

       // Paste the clipboard content
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);

       // Press Enter to upload the file
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
   }
   
   
   /**
    * Uses the Robot class to simulate file upload by copying the file path to the clipboard and pasting it.
    *
    * @param filePath The absolute path to the file to be uploaded.
    * @throws AWTException If the platform configuration does not allow low-level input control.
    */
   public void uploadFileWithRobotInMac(String filePath) throws AWTException, InterruptedException {
   	
   	try
   	{
   		// Copy the file path to the clipboard
   		StringSelection stringSelection = new StringSelection(filePath);
   		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

   		// Create an instance of Robot class
   		Robot robot = new Robot();

   		// Press Command (⌘) + Shift + G to open the "Go to Folder" dialog
   		robot.keyPress(KeyEvent.VK_META); // Command key
   		robot.keyPress(KeyEvent.VK_SHIFT);
   		robot.keyPress(KeyEvent.VK_G);
   		robot.keyRelease(KeyEvent.VK_G);
   		robot.keyRelease(KeyEvent.VK_SHIFT);
   		robot.keyRelease(KeyEvent.VK_META);

   		// Small delay to allow the dialog to open
   		Thread.sleep(1000);

   		// Paste the clipboard content (file path)
   		robot.keyPress(KeyEvent.VK_META);
   		robot.keyPress(KeyEvent.VK_V);
   		robot.keyRelease(KeyEvent.VK_V);
   		robot.keyRelease(KeyEvent.VK_META);

   		// Press Enter to confirm the path
   		robot.keyPress(KeyEvent.VK_ENTER);
   		robot.keyRelease(KeyEvent.VK_ENTER);

   		// Small delay to allow the folder to open
   		Thread.sleep(1000);

   		// Press Enter again to select the file and close the dialog
   		robot.keyPress(KeyEvent.VK_ENTER);
   		robot.keyRelease(KeyEvent.VK_ENTER);
   	}
   	catch(Exception ex)
   	{
   		ex.printStackTrace();
   	}
   }
   
   
   public int removeStringConvertInt(String data) {
	   String removedString = data.replaceAll("[^0-9]", "");
	   int convertedInt = Integer.parseInt(removedString);
	   
	   return convertedInt;
   }
   
   public  void scrolltoElementAndClickWithoutException(WebElement ScrolltoThisElement) {
			Actions act = new Actions(driver);

			act.moveToElement(ScrolltoThisElement).click().build().perform();

	}
   
   public void waitAndSwitchItinerary(WebElement element) {
	   try {
		// Get the original number of tabs
	        int originalTabCount = driver.getWindowHandles().size();
	        Thread.sleep(2000);
	        
	        clickAction(element);
	        
	        Thread.sleep(6000);

	        // Wait until a new tab is opened
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until((WebDriver d) -> d.getWindowHandles().size() > originalTabCount);
	        Thread.sleep(1500);

	        
	        // Get the list of all window handles (tabs)
	        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	        Thread.sleep(1500);
	        
	        // Switch to the new tab (the last one in the list)
	        driver.switchTo().window(tabs.get(tabs.size() - 1));
	        Thread.sleep(3000);
	   }
	   catch (Exception e) {
		   e.printStackTrace();
		System.out.println("Takes more time to open new tab");
	}
   }

}
