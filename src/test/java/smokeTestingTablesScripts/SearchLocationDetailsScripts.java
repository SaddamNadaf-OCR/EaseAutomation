package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;
import tablesClasses.ResultLocationDetailsPage;

import tablesClasses.SearchLocationDetailsPage;

import utilities.Utility;
import utilities.Wait;

public class SearchLocationDetailsScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchLocationDetails", excel);
		
	}
	@Test(dataProvider = "getData")
	public void SearchLocationDetails(String Testcase, String RunMode, String SBU, String CountryGroupCodes, String Description, String status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchLocationDetailsPage searchpage=new SearchLocationDetailsPage(driver,test);
		ResultLocationDetailsPage ResultPage=new ResultLocationDetailsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoLocationDetails();
					Wait.waitfor(2);
					searchpage.searchbyParameters(CountryGroupCodes ,Description, status);
					searchpage.searchbutton();
					ResultPage.LocationDetailsIsDisplayed();
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
