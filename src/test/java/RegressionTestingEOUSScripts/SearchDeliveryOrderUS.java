package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.DeliveryOrderPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultDeliveryOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchDeliveryOrderUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDeliveryOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void searchDeliveryResult(String Testcase, String RunMode, String SBU, String InvoiceNo, String WorkStatus,
			String ShipmentNo, String LSStatus, String PartNo, String Description, String ExportClassification,
			String AuthorisationNo) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		DeliveryOrderPage DO = new DeliveryOrderPage(driver, test);
		ResultDeliveryOrderPage Result = new ResultDeliveryOrderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresOrdersDeliveries();
					HGExport.clickDeliveryOrder();
					DO.searchWithParameters(InvoiceNo, WorkStatus, LSStatus, PartNo, Description, ExportClassification, AuthorisationNo);
					DO.clickSearch();
					Result.resultDOrder();
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