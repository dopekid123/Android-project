package gluecode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Set;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Kernel;
import utils.SeWrappers;

public class Hooks extends SeWrappers {
	SeWrappers se = new SeWrappers();
	Kernel kn= new Kernel();

	public static String configuration = "";
	public static String featureName = "";
	public static String scenarioName="";
	public static long threadId=0;

	@Before
	public void beforeScenario(Scenario scenario) throws InterruptedException {

		threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);

		configuration = System.getProperty("configEnv");
		featureName = scenario.getId().split(";")[0];
		scenarioName= scenario.getName();
		System.out.println("Feature Name --> "+featureName);
		System.out.println("Scenario Name --> "+scenario.getName());
		System.out.println("Config:"+configuration);

		se.startApp(browserName, "https://pickyourtrail.com/");
//				se.startApp(browserName, configuration);

		//To initiate browser sessions using Selenium Grid using Zalenium and Kubernetes
		//		se.startApp(browserName, true, configuration);
		//		kn.closeStaycationModal();


	}

	//	@Before
	//	public void before() {
	//		threadId = Thread.currentThread().getId();
	//		String processName = ManagementFactory.getRuntimeMXBean().getName();
	//		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
	//	}

	@After()
	public void embedScreenshot(Scenario scenario) throws Exception {
		try {

			System.out.println("Scenario Status :" + scenario.getStatus());

			if(! (scenario.isFailed()) )
			{
				kn.writeToFile(featureName, scenarioName, "pass");
			}
			else if (scenario.isFailed())
			{
				String sc = getScreenshot(driver, scenario.getName());
				//ReporteraddScreenCaptureFromPath(sc);

				kn.writeToFile(featureName, scenarioName, "fail");

			}

		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			//scenario.write(somePlatformsDontSupportScreenshots.getMessage());
			
		} 
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			System.out.println("Closing all the browsers !!!!");
			se.closeAllBrowsers();
			
		}
	}
	
@Before
public void initialise_the_output_file( Scenario scenarios) {
	try
    {
		System.out.println("deleting");
		kn.deleteOutputFile(System.getProperty("user.dir")+File.separator+"seochecks"+File.separator+"urlswithfailedseochecks.csv");
		
		//Creating and initialising the csv file
		FileWriter writer = new FileWriter(System.getProperty("user.dir")+ File.separator+"seochecks"+File.separator+"urlswithfailedseochecks.csv", true);
		SEOChecksGlue.csvWriter = new BufferedWriter(writer);

		//Heading for the output csv file
		SEOChecksGlue.csvWriter.write("urls,FailureReason");
		SEOChecksGlue.csvWriter.newLine();

    }
    catch(Exception ex)
    {
    	System.out.println("Problem while initialising the output file");
    	ex.printStackTrace();
    }
}
}
