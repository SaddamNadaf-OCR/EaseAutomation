package smokeTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;
import incident_Management.SearchInvestigation;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchInvestigationsFormScripts extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("InvestigationsForm", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void searchIncidentPage(String TestCases,String RunMode,String SBU,String referanceno,String data,String blanksearch,String invalidsearch) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchInvestigation sin=new SearchInvestigation(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
				//	homePage.sbuSelection(SBU);
					Wait.waitfor(2);
//					if(blanksearch.length()> 0) {
//						sin.searchIncidentNoinv(referanceno, data,blanksearch,invalidsearch);
//					}
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForInvestigations();
					Wait.waitfor(3);
					sin.searchIncidentNoinv(referanceno, data,blanksearch,invalidsearch);
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
