package regressionTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;
import incident_Management.SearchIncident;
import incident_Management.SearchInvestigation;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyFormHeading extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("VerifyFormHeading", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void VerifyFormHeadingDetails(String TestCases,String RunMode,String SBU,String referanceno,String data,String CorrectiveAction,String Heading,String Incident,String Investigations) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchInvestigation sca=new SearchInvestigation(driver,test);
		SearchIncident inc=new SearchIncident(driver,test);
		
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
					homePage.formHeading(CorrectiveAction,Heading,Incident,Investigations);
					Wait.waitfor(2);
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
