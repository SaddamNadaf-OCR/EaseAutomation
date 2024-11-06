package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultCountryPage;

import tablesClasses.SearchCountryPage;
import utilities.Utility;
import utilities.Wait;

public class SearchCountryScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCountry", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchCountry(String Testcase, String RunMode, String SBU, String CountryCode, String CountryName, String ISOCode,String DosCode, String status,String SortBy,String direction) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCountryPage searchpage=new SearchCountryPage(driver,test);
		ResultCountryPage SearchCountry=new ResultCountryPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoCountry();
					Wait.waitfor(4);
					searchpage.searchbyParameters(CountryCode ,CountryName, ISOCode, DosCode, status, SortBy, direction);
					searchpage.searchbutton();
					SearchCountry.CountryIsDisplayed();
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
