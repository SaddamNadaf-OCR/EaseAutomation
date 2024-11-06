package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.ExportUnderITARExemptionReport;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportInvoiceSummaryPage;
import globalExportClasses.ResultInvoiceReportSummaryPage;
import globalExportClasses.SearchCanadianExemptionSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ITARExemptionDetailReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchITARExemptionReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ITARExemptionreport(String Testcase, String RunMode, String SBU, String sbu, String WorkStatus,
			String DestinationCountry) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ExportUnderITARExemptionReport ITAREXm = new ExportUnderITARExemptionReport(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_ITARExemptionReport();
					HGExport.click_DetailsReports();
					Wait.waitfor(2);
					ITAREXm.selectSBU(sbu);
					Wait.waitfor(2);
					ITAREXm.selectWorkStatus(WorkStatus);
					Wait.waitfor(2);
					ITAREXm.selectDestinationCountry(DestinationCountry);
					Wait.waitfor(2);
					ITAREXm.searchBtn();
					Wait.waitfor(2);
					ITAREXm.validateHeading();

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
