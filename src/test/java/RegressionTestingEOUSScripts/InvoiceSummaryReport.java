package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportInvoiceSummaryPage;
import globalExportClasses.ResultInvoiceReportSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class InvoiceSummaryReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchSummaryReport", excel);
	}

	@Test(dataProvider = "getData")
	public void summaryReport(String Testcase, String RunMode, String SBU, String Sbu, String InvoiceNo, String ShipmentNo, 
			String CountryofultDest, String PartNo, String CountryOfOrigin, String partytype, String ShipTo, String BillTo, 
			String UnitPrice, String ECCN, String AuthNo)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportInvoiceSummaryPage rpinvsm=new ReportInvoiceSummaryPage(driver, test);
		ResultInvoiceReportSummaryPage rsltRpSummary= new ResultInvoiceReportSummaryPage(driver, test);
		

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.ReportInvoiceSummary();
					Wait.waitfor(2);
					rpinvsm.parameter(Sbu,InvoiceNo, 
							ShipmentNo,CountryofultDest,PartNo ,CountryOfOrigin,partytype,ShipTo,BillTo,UnitPrice,ECCN,AuthNo);
					Wait.waitfor(2);
					rpinvsm.search();
					Wait.waitfor(5);
					rsltRpSummary.titleIsDisplayed();

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
