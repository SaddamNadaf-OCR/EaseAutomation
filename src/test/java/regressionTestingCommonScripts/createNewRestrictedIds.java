package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.createNewRestrictedIdsPage;
import filesClasses.searchRestrictedIdsPage;
import initializer.SeleniumTestBase;


import utilities.Utility;

public class createNewRestrictedIds extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("createRestrictedIds", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void createRestrictedIds(String Testcase, String RunMode, String SBU, String AccountNumber, String RestrictedValues) {
		HomePage homepage=new HomePage(driver,test);
		searchRestrictedIdsPage searchpage=new searchRestrictedIdsPage(driver,test);
		createNewRestrictedIdsPage CreatePage=new createNewRestrictedIdsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoRestrictedValues();
					searchpage.addRestrictedIds();
					CreatePage.enterAccountNumber(AccountNumber,RestrictedValues);
					CreatePage.saveandReturn();
					homepage.returnToGExportHomePage();
					
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
			homepage.returnToGExportHomePage();
			Assert.assertTrue(false);
		}
	}

}
