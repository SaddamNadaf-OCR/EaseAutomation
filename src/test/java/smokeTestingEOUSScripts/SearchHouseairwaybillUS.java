package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultHouseairwaybillPage;
import globalExportClasses.SearchHouseairwaybillPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchHouseairwaybillUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchHouseAirwaybill", excel);
	}

	@Test(dataProvider = "getData")
	public void Houseairwaybill(String Testcase, String RunMode, String sbu, String HAWB_NO, String Shipment_No)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchHouseairwaybillPage search = new SearchHouseairwaybillPage(driver, test);
		ResultHouseairwaybillPage result = new ResultHouseairwaybillPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);

					HGExport.moduleselection();
					HGExport.HouseAirwayBill();
					Wait.waitfor(3);
					search.parameter(sbu, HAWB_NO, Shipment_No);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					result.titleIsDisplayed();
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
