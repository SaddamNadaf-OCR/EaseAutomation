package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportMisShipt_Processing_Statistics_BySBUSiteRegionPage;
import globalExportClasses.ResultMisShipt_Processing_Statistics_BySBUSiteRegionPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportMisShipt_Processing_Statistics_BySBUSiteRegion extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportMisShipProStaBySBUSiteReg", excel);
	}

	@Test(dataProvider = "getData")
	public void reportMisShipt_Processing_Statistics_BySBUSiteRegion(String Testcase, String RunMode, String SBU,
			String SbuCode, String WorkStatus, String Country, String Region, String Site, String CreatedFrom,
			String CreatedTo, String ExportFrom, String ExportTo, String ShipReviewFrom, String ShipReviewTo,
			String ExportReviewFrom, String ExportReviewTo, String TransReviewFrom, String TransReviewTo)
			throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportMisShipt_Processing_Statistics_BySBUSiteRegionPage search = new ReportMisShipt_Processing_Statistics_BySBUSiteRegionPage(
				driver, test);
		ResultMisShipt_Processing_Statistics_BySBUSiteRegionPage result = new ResultMisShipt_Processing_Statistics_BySBUSiteRegionPage(
				driver, test);

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
					HGExport.StatisticsSBUSiteRegion();
					Wait.waitfor(2);
					search.searchByParameters(SbuCode, WorkStatus, Country, Region, Site, CreatedFrom, CreatedTo,
							ExportFrom, ExportTo, ShipReviewFrom, ShipReviewTo, ExportReviewFrom, ExportReviewTo,
							TransReviewFrom, TransReviewTo);
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
