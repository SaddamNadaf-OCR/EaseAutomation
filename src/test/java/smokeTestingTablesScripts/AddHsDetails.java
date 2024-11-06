package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HazmatPage;
import tablesClasses.HomePageTables;
import tablesClasses.HsDetailsPage;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class AddHsDetails extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateHsDetails", excel);

	}

	@Test(dataProvider = "getData")
	public void CreateHsDetail(String Testcase, String RunMode, String SBU, String Country, String ExportImport, String Effectvedate, String Description, String EffectiveStatus) {
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		HsDetailsPage hz= new HsDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
//					homepage.movetoHsDetails();
					Wait.waitfor(2);
					hz.addbutton();
					hz.addbyParameters(Country, ExportImport, Effectvedate, Description, EffectiveStatus);
					Wait.waitfor(2);
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
