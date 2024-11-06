package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HazmatPage;
import tablesClasses.HomePageTables;
import tablesClasses.PortsPage;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class SearchPort extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchPort", excel);

	}

	@Test(dataProvider = "getData")
	public void searchPorts(String Testcase, String RunMode, String SBU, String PortId, String CustomCountry, String Description, String PortCode, String PortCountry, String Status, String sortby, String direction)	
	{
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		PortsPage hz= new PortsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoports();
					Wait.waitfor(2);
					hz.searchbyParameters(PortId, CustomCountry, Description, PortCode, PortCountry, Status, sortby, direction);
					Wait.waitfor(2);
					hz.searchbutton();
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

		
		
	