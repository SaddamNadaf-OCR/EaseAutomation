package nrcLicensingScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.NrcWebServiceAuditReportPage;
import utilities.Utility;
import utilities.Wait;

public class NrcWebServiceAuditReportResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("NrcWebServiceAuditReport", excel);
	}

	@Test(dataProvider = "getData")
	public void webserviceauditsearchpage(String Testcase, String RunMode, String SBU, String SBUCode, String UserID,
			String RequestType, String RequestDateFrom, String MessageType, String RequestDateTo, String RequestStatus,
			String ReferenceNo, String AuditID) throws Exception {

		// *********** Objects Creation ********************************

		NrcWebServiceAuditReportPage auditReport = new NrcWebServiceAuditReportPage(driver, test);
		HomePageNrcLicense home = new HomePageNrcLicense(driver, test);

		// ****************** Test steps execution***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoWebserviceAuditApplicationReport();
					auditReport.searchAuthorizationSummaryReport(SBUCode, UserID, RequestType, RequestDateFrom,
							MessageType, RequestDateTo, RequestStatus, ReferenceNo, AuditID);
					auditReport.click_ReportSearch();
					auditReport.webserviceAuditReportDisplayOfTitle();
					Wait.waitfor(3);
					home.NrcreturnPage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.NrcreturnPage();
			Assert.assertTrue(false);
		}
	}

}
