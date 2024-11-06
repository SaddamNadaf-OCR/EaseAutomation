package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultPackingListPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchPLUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchPackingList", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPLResult(String Testcase, String RunMode, String SBU, String SbuCode, String plNum, String exporter, 
			String DateOfExport, String consigneeName, String DateOfArrival, String shipmentNum, String Status, String createdBy) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		PackingListPage PLPage = new PackingListPage(driver, test);
		ResultPackingListPage Result_PLPage = new ResultPackingListPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PLPage.searchByParameter(SbuCode, plNum, exporter, DateOfExport, consigneeName, DateOfArrival,
							shipmentNum, Status, createdBy);
					PLPage.search();
					Wait.waitfor(3);
					Result_PLPage.packingListResult();
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
