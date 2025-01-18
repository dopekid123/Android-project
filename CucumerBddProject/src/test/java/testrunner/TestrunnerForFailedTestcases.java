package testrunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.Kernel;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt", glue = {
"gluecode" }, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },monochrome = true, dryRun = false)


public class TestrunnerForFailedTestcases {
	
	public static String timeStamp = "";

        	
	@AfterClass
	public static void writeExtentReport() throws Exception {
		
		System.out.println("Failed test cases");
		timeStamp=Kernel.getTime();
		
		System.out.println("Time Stamp: "+timeStamp);
//		Kernel.sendRegMail();
//		kn.mergeAllTextFileContents();
	}
        
 }
        