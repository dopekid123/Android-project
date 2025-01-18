package testrunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.Kernel;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt", glue = {
"gluecode" }, plugin = {
"rerun:target/rerun.txt", "tech.grasshopper.extentreports.ExtentCucumberAdapter:" },monochrome = true, dryRun = false)
//com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/FailedScenariosReReunReport.html

public class TestrunnerFailedTestcases {
	
	public static String timeStamp = "";

        	
	@AfterClass
	public static void writeExtentReport() throws Exception {
		timeStamp=Kernel.getTime();
		
		System.out.println("Time Stamp: "+timeStamp);
		Kernel.sendRegMail();
//		kn.mergeAllTextFileContents();
	}
        
 }
        