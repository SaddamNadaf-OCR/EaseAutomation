package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportMisShipSumBySBUFinalShipPage;
import globalExportClasses.ResultMisShipSumBySBUFinalShipPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportMisShipSumBySBUFinalShip extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportMisShipSumBySBUFinalShip", excel);
	}

	@Test(dataProvider = "getData")
	public void reportMisShipSumBySBUFinalShip(String Testcase, String RunMode, String SBU, String SbuCode,
			String country, String UltConsName, String IntConsName, String FwdAgentName, String Region, String Site,
			String CountryofUltDest, String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo)
			throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportMisShipSumBySBUFinalShipPage search = new ReportMisShipSumBySBUFinalShipPage(driver, test);
		ResultMisShipSumBySBUFinalShipPage result = new ResultMisShipSumBySBUFinalShipPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					Wait.waitfor(2);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moduleselection();
					Wait.waitfor(2);
					HGExport.ShipSumBySBUFinalShip();
					Wait.waitfor(2);
					search.searchByParameters(SbuCode, country, UltConsName, IntConsName, FwdAgentName, Region, Site,
							CountryofUltDest, CreatedFrom, CreatedTo, ExportFrom, ExportTo);
					Wait.waitfor(2);
					search.search();
					Wait.waitfor(2);
					result.titleIsDisplayed();
					//result.IconsDisplay();
					Wait.waitfor(2);
					HGExport.return_ExportHome();

				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
