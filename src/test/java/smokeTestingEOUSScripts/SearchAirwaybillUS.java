package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultAirwaybillPage;
import globalExportClasses.SearchAirwayBillPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchAirwaybillUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("searchairwaybill", excel);
	}

	@Test(dataProvider = "getData")
	public void airwaybill(String Testcase, String RunMode, String Sbu, String AWB_NO, String Shipment_no)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAirwayBillPage search = new SearchAirwayBillPage(driver, test);
		ResultAirwaybillPage result = new ResultAirwaybillPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);

					HGExport.moduleselection();
					HGExport.airwaybill();
					Wait.waitfor(3);
					search.searchByParameter(Sbu, AWB_NO, Shipment_no);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					result.titleIsDisplayed();
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
