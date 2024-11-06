package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.SearchShipperPage;
import filesClasses.createNewShipperPage;
import initializer.SeleniumTestBase;


import utilities.Utility;

public class createNewShipper extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("createShipper", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void createShipper(String Testcase, String RunMode, String SBU, String Code, String Name) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchShipperPage searchpage=new SearchShipperPage(driver,test);
		createNewShipperPage CreatePage=new createNewShipperPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionWLS(SBU);
					homepage.movetoShippers();
					searchpage.addShipper();
					CreatePage.enterCode(Code,Name);
					CreatePage.saveandReturn();
					
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
			homepage.returnToWLSHomePage();
			Assert.assertTrue(false);
		}
	}


}
