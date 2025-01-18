package gluecode;

import java.util.ArrayList;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class CostingTimeGlue extends Kernel {
	@Then("^calculate the costing time\"([^\"]*)\",\"([^\"]*)\"$")
	public void calculate_the_costing_time(String region, String departFrom) throws Throwable {
		ArrayList<Integer> costTimeArr = new ArrayList<Integer>();
		loginFunctionalityTest("admin");
//		homepageLanding();
		for (int i = 0; i < 5; i++) {
			System.out.println("Region : " + region + " i value " + i);
			iternaryFlow(region);
			navigateGcmFlowWithDepartFrom(departFrom);
			StopWatch pageLoad = new StopWatch();
			pageLoad.start();
			pollingWait(inclusion.getBookNow(),150);
			pageLoad.stop();
			long pageLoadTime_ms = pageLoad.getTime();
			long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
			System.out.println("Itinerary Url: "+getCurrentUrl());
			System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
			System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
			costTimeArr.add((int) pageLoadTime_Seconds);
			driver.findElement(By.xpath("(//img[@alt='pickyourtrail'])[1]")).click();
		}
		System.out.println("Arry Size : " + costTimeArr);
		int count = 0;
		int avg = 0;
		for (int j = 0; j < costTimeArr.size(); j++) {
			count = count + costTimeArr.get(j);
		}
		avg = count/5;

		System.out.println("Region :" + region + " and its Avg costing time " + avg+"sec");
		//ReporteraddStepLog("Region :" + region + " and its Avg costing time " + avg+"sec");
		
	}

}
