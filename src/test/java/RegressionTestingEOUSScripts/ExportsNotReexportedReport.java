package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.ExportUnderITARExemptionReport;
import globalExportClasses.ExportsNotReexportedReportpage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportsNotReexportedReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchExportNotReExport", excel);
	}

	@Test(dataProvider = "getData")
	public void ExportsNotRexported(String Testcase, String RunMode, String SBU, String ImportShipNO,
			String ImportDateFrom, String ImportDateTo, String ShipperCountryode, String ImportLicenses,
			String ImportExemptionNo) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ExportsNotReexportedReportpage ExpNtReExp = new ExportsNotReexportedReportpage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_ITARExemptionReport();
					HGExport.click_ExportsnotReexportedReports();
					Wait.waitfor(2);
					ExpNtReExp.ImpoemptionNotReexported(ImportShipNO, ImportDateFrom, ImportDateTo,
							ShipperCountryode, ImportLicenses, ImportExemptionNo);
					Wait.waitfor(2);
					ExpNtReExp.clickonSearch();
					Wait.waitfor(2);
					ExpNtReExp.validateHeading();
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
