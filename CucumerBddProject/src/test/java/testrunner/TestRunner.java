package testrunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.Kernel;

@RunWith(Cucumber.class)

@CucumberOptions(features = "features/", glue = 
"gluecode", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/rerun.txt"}, tags = "@nice", monochrome = true, dryRun = false)


public class TestRunner {
	public static String timeStamp = "";


	@AfterClass
	public static void writeExtentReport() throws Exception {
		try
		{
			timeStamp=Kernel.getTime();
			System.out.println("Time Stamp: "+timeStamp);
			//commenting this code on Mar 21st not send the mail
			//Kernel.sendRegMail();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}



}
