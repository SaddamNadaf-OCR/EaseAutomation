package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultAirportsPage;

import tablesClasses.SearchAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class SearchAirportsScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchAirports", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchAirports(String Testcase, String RunMode, String SBU, String AirportCode, String AirportName, String CountryCode,String status,String SortBy,String direction) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAirportsPage searchpage=new SearchAirportsPage(driver,test);
		ResultAirportsPage SearchAirports=new ResultAirportsPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAirports();
					Wait.waitfor(4);
					searchpage.searchbyParameters(AirportCode , AirportName, CountryCode, status, SortBy, direction);
					searchpage.searchbutton();
					SearchAirports.AirportsIsDisplayed();
					Wait.waitfor(2);
					SearchAirports.searchresultIsDisplayed();
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
