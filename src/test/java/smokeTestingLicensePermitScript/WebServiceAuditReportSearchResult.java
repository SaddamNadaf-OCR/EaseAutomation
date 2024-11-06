package smokeTestingLicensePermitScript;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import lpreports.HomePageReport;
import lpreports.WebServiceAuditReportPage;
import utilities.Utility;
import utilities.Wait;

public class WebServiceAuditReportSearchResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("WebServiceAuditSearch", excel);
	}

	@Test(dataProvider = "getData")
	public void webserviceauditsearchpage(String Testcase, String RunMode, String SBU, String SBUCode, String UserID,
			String RequestType, String RequestDateFrom) throws Exception {

		// *********** Objects Creation ********************************

		WebServiceAuditReportPage auditReport = new WebServiceAuditReportPage(driver, test);
		HomePageReport home = new HomePageReport(driver, test);

		// ****************** Test steps execution***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoWebServiceAuditReports();
					auditReport.searchAuthorizationSummaryReport(SBUCode, UserID, RequestType, RequestDateFrom);
					auditReport.click_ReportSearch();
					auditReport.displayOfTitle();
					Wait.waitfor(3);
					home.returnHomepageLP();
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
			home.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}

}
