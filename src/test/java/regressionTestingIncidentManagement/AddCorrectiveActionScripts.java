package regressionTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.AddCorrectiveAction;
import incident_Management.HomePageIM;
import incident_Management.SearchCorrectiveAction;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddCorrectiveActionScripts extends SeleniumTestBase{
	
	//.............................Data-Provider....................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("AddCorrectiveAction", excel);
	}
	
	//..................................Test Method................................//
	@Test(dataProvider="getdata")
	public void addCorrectiveActiondetails(String TestCases,String RunMode,String SBU,String incidentno,String data,String department,String site,String title, String description,String remark,String correctiveactionno,String rootcause) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchCorrectiveAction sca=new SearchCorrectiveAction(driver,test);
		AddCorrectiveAction eca=new AddCorrectiveAction(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
		//			homePage.sbuSelection(SBU);
					Wait.waitfor(2);
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForCorrectiveAction();
					Wait.waitfor(2);
					eca.addCorrectiveAction();
					Wait.waitfor(2);
					eca.addincidentno(incidentno);
					eca.AddCorrectiveAction(department,site,title,description, remark,correctiveactionno,rootcause);
				//	homePage.logOut();
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