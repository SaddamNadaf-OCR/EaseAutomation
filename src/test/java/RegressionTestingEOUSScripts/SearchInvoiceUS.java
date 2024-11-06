package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchInvoiceUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchInvoice", excel);
	}

	@Test(dataProvider = "getData")
	public void searchInvoiceResult(String Testcase, String RunMode, String SBU, String InvoiceNo, String workStatus,
			String ShipmentNo, String LSStatus, String PartNo, String Description) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage invoice = new InvoicePage(driver, test);
		ResultInvoiceOrderPage resultI = new ResultInvoiceOrderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Invoice_Order();
					invoice.searchWithParameters(InvoiceNo, workStatus, ShipmentNo, LSStatus, PartNo, Description);
					invoice.click_SearchButton();
					resultI.titleDisplayed();
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
