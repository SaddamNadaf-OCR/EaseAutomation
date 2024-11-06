package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;

import globalExportClasses.ReportShipmentSummaryPage;

import globalExportClasses.ResultShipmentReportSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportShipmentSummary extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportShipmentSummary", excel);
	}

	@Test(dataProvider = "getData")
	public void reportShipmentSummary(String Testcase,String RunMode, String Sbu, String ShipmentNo,
			String Workstatus, String AESStatus, String AESOption, String InvoiceNo) throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportShipmentSummaryPage search = new ReportShipmentSummaryPage (driver, test);
		ResultShipmentReportSummaryPage result = new ResultShipmentReportSummaryPage (driver, test);
		
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
					HGExport.ReportShipmentSummary();
					Wait.waitfor(2);
					search.parameter(Sbu,ShipmentNo,Workstatus,AESStatus,AESOption,InvoiceNo);
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


