package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchPackingListReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchPackingListReportUS extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("PackingListReport", excel);
	}

	@Test(dataProvider = "getData")
	public void PLReport(String Testcase, String RunMode, String SBU, String SbuCode, String PL, String ShpNo, String Status) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchPackingListReportPage PLReport = new SearchPackingListReportPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.PackingList();
					PLReport.selectSBU(SbuCode);
					PLReport.packingList(PL);
					PLReport.shipmentNo(ShpNo);
					PLReport.status(Status);
					PLReport.SearchBtn();
					PLReport.validateHeading();

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
