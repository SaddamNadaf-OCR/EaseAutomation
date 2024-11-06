package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;
import filesClasses.ResultSitePage;
import filesClasses.SearchSitePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchSiteScript extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchSite", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchSite(String Testcase, String RunMode, String SBU, String sbu, String SiteId, String SiteName, String Status, String CreatedBy, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchSitePage searchpage=new SearchSitePage(driver,test);
		ResultSitePage ResultListSiteTitle=new ResultSitePage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoSite();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,SiteId,SiteName,Status,CreatedBy,SortBy,direction);
					searchpage.searchbutton();
					ResultListSiteTitle.ResultListSiteIsDisplayed();
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
