package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.CreateNewSitePage;
import filesClasses.HomePage;


import filesClasses.SearchSitePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewSite extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateSite", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateProductFamily(String Testcase, String RunMode, String SBU,String SiteID, String SiteName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchSitePage searchpage=new SearchSitePage(driver,test);
		CreateNewSitePage CreatePage=new CreateNewSitePage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoSite();
					searchpage.addSite();
					CreatePage.enterSiteID(SiteID,SiteName);
					CreatePage.saveandReturn();
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
