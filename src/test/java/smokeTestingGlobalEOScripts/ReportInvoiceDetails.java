package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportInvoiceDetailsPage;
import globalExportClasses.ResultHouseairwaybillPage;
import globalExportClasses.ResultInvoiceReportDetailsPage;
import globalExportClasses.SearchHouseairwaybillPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportInvoiceDetails extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportInvoiceDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void reportInvoiceDetails(String Testcase, String RunMode, String Sbu, String InvoiceNo, 
			String Status, String ShipmentNo,String PartNo,String partytype)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportInvoiceDetailsPage search = new ReportInvoiceDetailsPage(driver, test);
		ResultInvoiceReportDetailsPage result = new ResultInvoiceReportDetailsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					Wait.waitfor(2);
					HGExport.moduleselection();
					Wait.waitfor(2);
					HGExport.ReportInvoice();
					Wait.waitfor(2);
//					search.parameter(Sbu,InvoiceNo, Status,ShipmentNo,PartNo,partytype);
					Wait.waitfor(2);
					search.search();
					Wait.waitfor(2);
					result.titleIsDisplayed();
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