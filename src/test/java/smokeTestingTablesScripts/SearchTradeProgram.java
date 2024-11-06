package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HazmatPage;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import tablesClasses.TradeProgramPage;
import utilities.Utility;
import utilities.Wait;

public class SearchTradeProgram extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchTradeProgram", excel);

	}

	@Test(dataProvider = "getData")
	public void searchtradProgram(String Testcase, String RunMode, String SBU, String TradeProgramCountry, String SpecialProgramIndicator, String SpecialProgram, String Country, String Status, String sortby, String direction)	
	{
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		TradeProgramPage hz= new TradeProgramPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetotradeprogram();
					Wait.waitfor(2);
					hz.searchbyParameters(TradeProgramCountry, SpecialProgramIndicator, SpecialProgram, Country, Status, sortby, direction);
					hz.searchbutton();
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

		
		
	