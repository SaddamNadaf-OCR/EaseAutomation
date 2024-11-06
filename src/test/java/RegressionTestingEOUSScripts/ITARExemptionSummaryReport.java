package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.ExportsNotReexportedReportpage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ITARExemptionSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ITARExemptionSummaryReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ITARExemptionSummaryReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ITAReXemptionSummary(String Testcase, String RunMode, String SBU, String sbu, String WorkStatus,
			String ContryOfUltDestination, String Description, String ShipmentNo, String SalesOrderNo)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ITARExemptionSummaryPage ITARSum = new ITARExemptionSummaryPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_ITARExemptionReport();
					HGExport.click_SummaryReports();
					Wait.waitfor(2);
					ITARSum.selectSBU(sbu);
					Wait.waitfor(2);
					ITARSum.selectWorkStatus(WorkStatus);
					Wait.waitfor(2);
					ITARSum.selectContryOfUltDestination(ContryOfUltDestination);
					Wait.waitfor(2);
					ITARSum.otherfields(Description, ShipmentNo, SalesOrderNo);
					Wait.waitfor(2);
					ITARSum.searchBtn();
					Wait.waitfor(2);
					ITARSum.validateHeading();
					Wait.waitfor(3);
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
