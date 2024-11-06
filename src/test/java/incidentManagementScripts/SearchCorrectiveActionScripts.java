package incidentManagementScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;
import incident_Management.SearchCorrectiveAction;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchCorrectiveActionScripts extends SeleniumTestBase{
	
	//.............................Data-Provider....................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("CorrectiveAction", excel);
	}
	
	//..................................Test Method................................//
	@Test(dataProvider="getdata")
	public void searchIncidentPage(String RunMode,String TestCases,String SBU,String referanceno,String data) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchCorrectiveAction sca=new SearchCorrectiveAction(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
					homePage.sbuSelection(SBU);
					Wait.waitfor(2);
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForCorrectiveAction();
					Wait.waitfor(2);
					sca.searchIncidentNo(referanceno, data);
					Wait.waitfor(2);
					homePage.logOut();
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
