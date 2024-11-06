package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.AESStatusChangeReportPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.OrderWLSAuditReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchOrderWLSAuditReportUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("OrderWLSReport", excel);
	}

	@Test(dataProvider = "getData")
	public void OrderWls(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo, String InvoiceNo,
			String DeliveryNo, String ExportCode, String CountryUltDest, String FromDate, String EndDate, String ExpoDatefrom,
			String ExpoDateTo, String CountryShippedFrom) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		OrderWLSAuditReportPage OrderWls = new OrderWLSAuditReportPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.auditReports();
					HGExport.OrderWLSSAuditReport();
					OrderWls .searchbyparameter (SBUcode,ShipmentNo,InvoiceNo,DeliveryNo,ExportCode,CountryUltDest,
							FromDate,EndDate,ExpoDatefrom,ExpoDateTo,CountryShippedFrom);
					OrderWls.searchbtn();
					OrderWls.validateHeading();
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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	



}
