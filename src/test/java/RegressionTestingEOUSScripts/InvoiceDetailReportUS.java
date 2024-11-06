package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportInvoiceDetailsPage;
import globalExportClasses.ResultInvoiceReportDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class InvoiceDetailReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchInvoiceReport", excel);
	}

	@Test(dataProvider = "getData")
	public void invoiceDetails(String Testcase, String RunMode, String SBU, String Sbu, String InvoiceNo, String Status,
			String ShipmentNo, String PartNo,String partytype, String ShipTO, String BillTO, String EEIValue, String UnitPrice) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportInvoiceDetailsPage RepInvcdet = new ReportInvoiceDetailsPage(driver, test);
		ResultInvoiceReportDetailsPage rsltinvdet = new ResultInvoiceReportDetailsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.ReportInvoice();
					Wait.waitfor(2);
					RepInvcdet.parameter(Sbu, InvoiceNo, Status, ShipmentNo, PartNo, partytype,ShipTO,BillTO,EEIValue,UnitPrice);
					Wait.waitfor(2);
					RepInvcdet.search();
					Wait.waitfor(5);
					rsltinvdet.titleIsDisplayed();
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
