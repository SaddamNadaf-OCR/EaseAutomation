package lpreportScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import lpreports.AuthorizationSummaryReportPage;
import lpreports.HomePageReport;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationSummaryReportSearchResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthorizationSummarySearch", excel);
	}

	@Test(dataProvider = "getData")
	public void authorisationsummarysearchpage(String Testcase, String RunMode, String SBU, String ReferenceID,
			String SBUCode, String FolderID, String Status, String AuthorizationNo, String ProgramCode,
			String AuthorizationCountry, String SegmentCode, String Code, String AuthorizationCode, String AgencyCode,
			String RequestorName, String ReviewerName, String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom,
			String ExpiryDateTo) throws Exception {

		// *************** Objects Creation *******************************************

		AuthorizationSummaryReportPage authsummaryReport = new AuthorizationSummaryReportPage(driver, test);
		HomePageReport home = new HomePageReport(driver, test);

		// ******************** Test steps execution***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoAuthorisationSummaryReports();
					authsummaryReport.searchAuthorizationSummaryReport(ReferenceID, SBUCode, FolderID, Status,
							AuthorizationNo, ProgramCode, AuthorizationCountry, SegmentCode, Code, AuthorizationCode,
							AgencyCode, RequestorName, ReviewerName, IssueDateFrom, IssueDateTo, ExpiryDateFrom,
							ExpiryDateTo);
					authsummaryReport.click_ReportSearch();
					authsummaryReport.displayOfTitle();
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
