package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultSalesOrderPage;
import globalExportClasses.SalesOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchSalesOrderUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchSalesOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void searchshipmentResult(String Testcase, String RunMode, String SBU, String SalesOrderNo,
			String WorkStatus, String ShipmentNo, String ECStatus, String WLSStatus, String PartNo, String Description,
			String ExportClassification, String AuthorisationNo, String AuthorisationType) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SalesOrderPage sales = new SalesOrderPage(driver, test);
		ResultSalesOrderPage resultOrder = new ResultSalesOrderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresOrdersDeliveries();
					HGExport.clickSalesOrder();
					sales.search_SalesorderNo(SalesOrderNo);
					sales.search_WorkStatus(WorkStatus);
					sales.search_WLStatus(WLSStatus);
					/*sales.searchSalesHeader(SalesOrderNo, WorkStatus, ShipmentNo, ECStatus, WLSStatus);
					sales.searchInvoiceItem(PartNo, Description);
					sales.searchExport(ExportClassification, AuthorisationNo, AuthorisationType);*/
					sales.click_SearchButton();
					resultOrder.salesResult();
					Wait.waitfor(2);
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
