package smokeTestingIncedentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddIncedent extends SeleniumTestBase {

	//.............................Data-Provider....................................//
	@DataProvider
	public Object[][] getData() { 
		return Utility.getData("AddIncedent", excel);
	}




//..................................Test Method................................//
	@Test(dataProvider="getdata")
	public void moduleSelection(String TestCases,String RunMode) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(12);
					
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
