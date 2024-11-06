package smokeTestingEOUSScripts;

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

public class ReportMisShipSumBySBUFinalShip  extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportMisShipSumBySBUFinalShip", excel);
	}

	@Test(dataProvider = "getData")
	public void reportMisShipSumBySBUFinalShip(String Testcase,String RunMode, String SBU, String Sbu, String Region,String CountryofUltDest)
			throws Exception{
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportMisShipSumBySBUFinalShipPage search = new ReportMisShipSumBySBUFinalShipPage (driver, test);
		ResultMisShipSumBySBUFinalShipPage result = new ResultMisShipSumBySBUFinalShipPage (driver, test);
		
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
					search.parameter(Sbu,Region,CountryofUltDest);
					Wait.waitfor(2);
					search.search();
					Wait.waitfor(2);
					result.titleIsDisplayed();
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
