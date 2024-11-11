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
import tablesClasses.TransmitterPage;
import utilities.Utility;
import utilities.Wait;

public class AddTransmitter extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddTransmitter", excel);

	}

	@Test(dataProvider = "getData")
	public void searchHazmat(String Testcase, String RunMode, String SBU, String Password)	
	{
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		TransmitterPage hz= new TransmitterPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoTransmitter();
					Wait.waitfor(2);
					hz.addbutton();
					hz.addbyParameters(Password);
					hz.savebtn();
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
