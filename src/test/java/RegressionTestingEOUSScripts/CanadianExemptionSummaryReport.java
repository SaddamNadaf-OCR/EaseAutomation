package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportInvoiceSummaryPage;
import globalExportClasses.ResultInvoiceReportSummaryPage;
import globalExportClasses.SearchCanadianExemptionSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CanadianExemptionSummaryReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchCanadaExemptionReport", excel);
	}

	@Test(dataProvider = "getData")
	public void canadianExemptionreport(String Testcase, String RunMode, String SBU, String sbu, String WorkStatus,
			String CanadianExemp) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportInvoiceSummaryPage rpinvsm = new ReportInvoiceSummaryPage(driver, test);
		ResultInvoiceReportSummaryPage rsltRpSummary = new ResultInvoiceReportSummaryPage(driver, test);
		SearchCanadianExemptionSummaryPage candaEXm = new SearchCanadianExemptionSummaryPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_ITARExemptionReport();
					HGExport.click_CanadianExemptionSummaryReports();
					Wait.waitfor(2);
					candaEXm.selectSBU(sbu);
					Wait.waitfor(2);
					candaEXm.selectWorkStatus(WorkStatus);
					Wait.waitfor(2);
					candaEXm.selectCanadianExempNo(CanadianExemp);
					Wait.waitfor(2);
					candaEXm.searchBtn();
					Wait.waitfor(2);
					candaEXm.validateHeading();

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
