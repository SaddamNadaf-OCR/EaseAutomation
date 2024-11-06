package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.IncotermReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class IncotermReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("IncotermReport", excel);
	}

	@Test(dataProvider = "getData")
	public void IncotermsReport(String Testcase, String RunMode, String SBU, String SbuCode, String ShipToOrgLink,
			String ShipToOrg, String SoldToOrgLink, String SoldToOrg, String IncotermsLink, String Incoterms) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		IncotermReportPage IncoReport = new IncotermReportPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.Incoterm();
					IncoReport.selectSBU(SbuCode);
					IncoReport.ShipToOrg(ShipToOrgLink, ShipToOrg);
					IncoReport.SoldToOrg(SoldToOrgLink, SoldToOrg);
					IncoReport.Incoterm(IncotermsLink, Incoterms);
					IncoReport.SearchBtn();
					IncoReport.validateHeading();

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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
