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
import tablesClasses.SPIDetails;
import utilities.Utility;
import utilities.Wait;

public class SearchSPIDetails extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchSpiDetails", excel);

	}

	@Test(dataProvider = "getData")
	public void searchSpiDetail(String Testcase, String RunMode, String SBU, String CountryCode, String Status, String LanguageCode, String FTACode, String SPICode, String sortby, String direction)	
	{
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		SPIDetails hz= new SPIDetails(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoSPIDetails();
					Wait.waitfor(2);
					hz.searchbyParameters(CountryCode, Status, LanguageCode, FTACode, SPICode, sortby, direction);;
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
