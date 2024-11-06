package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportMisDisapprovalMetricsPage;
import globalExportClasses.ResultMisDisapprovalMetricsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportMisDisapprovalMetrics extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportMisDisapprovalMetrics", excel);
	}

	@Test(dataProvider = "getData")
	public void reportMisDisapprovalMetrics(String Testcase, String RunMode, String SBU, String Sbu, String Workstatus,
			String country, String Region, String Site, String CreatedFrom, String CreatedTo, String ExportFromDate, 
			String ExportToDate) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportMisDisapprovalMetricsPage search = new ReportMisDisapprovalMetricsPage(driver, test);
		ResultMisDisapprovalMetricsPage result = new ResultMisDisapprovalMetricsPage(driver, test);

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
					HGExport.DisapprovalMetrics();
					Wait.waitfor(2);
					search.searchbyParameters(Sbu, Workstatus, country, Region, Site, CreatedFrom, CreatedTo,
							ExportFromDate, ExportToDate);
					Wait.waitfor(2);
					search.search();
					Wait.waitfor(2);
					result.titleIsDisplayed();
					result.IconsDisplay();
			
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
