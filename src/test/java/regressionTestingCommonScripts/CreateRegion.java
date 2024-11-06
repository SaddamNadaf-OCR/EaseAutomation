package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.CreateNewRegionPage;
import filesClasses.HomePage;


import filesClasses.SearchRegionPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateRegion extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddRegion", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddRegion(String Testcase, String RunMode, String SBU,String RegionID, String RegionName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchRegionPage searchpage=new SearchRegionPage(driver,test);
		CreateNewRegionPage CreatePage=new CreateNewRegionPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoRegion();
					searchpage.addRegion();
					CreatePage.enterRegionID(RegionID,RegionName);
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
