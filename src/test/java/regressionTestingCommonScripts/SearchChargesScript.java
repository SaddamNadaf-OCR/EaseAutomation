package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.ListChargesPage;
import filesClasses.HomePage;
import filesClasses.SearchChargesPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchChargesScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCharge", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchCharge(String Testcase, String RunMode, String SBU, String sbu, String ChargeCode, String Status, String ChargeType, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchChargesPage searchpage=new SearchChargesPage(driver,test);
		ListChargesPage ChargesTitle=new ListChargesPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoCharges();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,ChargeCode,Status,ChargeType,direction);
					searchpage.searchbutton();
					ChargesTitle.ChargesIsDisplayed();
					Wait.waitfor(2);
					homepage.returnToIOHomePage();
				
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homepage.returnToIOHomePage();
			Assert.assertTrue(false);
		}
		
	}


}
