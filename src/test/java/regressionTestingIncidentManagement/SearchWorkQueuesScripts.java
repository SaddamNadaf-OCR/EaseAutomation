package regressionTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;
import incident_Management.SearchInvestigation;
import incident_Management.WorkQueueIM;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchWorkQueuesScripts extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("WorkQueues", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void searchMyworkQueues(String TestCases,String RunMode,String SBU,String myQueuedata,String investigationsQueue,String correctiveActionQueue) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchInvestigation sin=new SearchInvestigation(driver,test);
		WorkQueueIM wq=new WorkQueueIM(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
				//	homePage.sbuSelection(SBU);
					Wait.waitfor(2);

					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForWorkQueue();
					
					wq.myQueue(myQueuedata,investigationsQueue,correctiveActionQueue);
					Wait.waitfor(3);
					wq.titleIsDisplayed();
			//		homePage.logOut();
			}
		}
		}
			catch (Exception e) {
			e.printStackTrace();
			testFail();
			homePage.logOut();
			Assert.assertTrue(false);
		}
	}

}
