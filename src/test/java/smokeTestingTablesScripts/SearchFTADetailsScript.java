package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultFTADetailsPage;

import tablesClasses.SearchFTADetailsPage;
import utilities.Utility;
import utilities.Wait;

public class SearchFTADetailsScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchFTA", excel);
		
	}
	@Test(dataProvider = "getData")
	public void SearchFTA(String Testcase, String RunMode, String SBU, String Country, String FTACode, String status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchFTADetailsPage searchpage=new SearchFTADetailsPage(driver,test);
		ResultFTADetailsPage ResultPage=new ResultFTADetailsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoFTADetails();
					Wait.waitfor(2);
					searchpage.searchbyParameters(Country ,FTACode, status);
					searchpage.searchbutton();
					ResultPage.FTADetailsIsDisplayed();
					Wait.waitfor(2);
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
