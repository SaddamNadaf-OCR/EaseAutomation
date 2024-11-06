package lpreportScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import lpreports.AdhocApplicationReportPage;
import lpreports.HomePageReport;
import utilities.Utility;
import utilities.Wait;

public class AdhocApplicationReportSearchResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AdhocReportSearch", excel);
	}

	@Test(dataProvider = "getData")
	public void adhocsearchpage(String Testcase, String RunMode, String SBU, String SBUCode, String ReferenceID,
			String AuthorizationType, String Status, String AuthorizationNo, String AuthorizationCountry,
			String AgencyCode, String ProgramCode, String ExporterCode, String RelatedAuthorisation, String SegmentCode,
			String Role, String UserEmailId, String DateInitiatedFrom, String DateInitiatedTo, String IssueDateFrom,
			String IssueDateTo, String DateSubmitFrom, String DateSubmitTo, String ExpiryDateFrom, String ExpiryDateTo)
			throws Exception {

		// ******************************** Objects
		// Creation*******************************************

		AdhocApplicationReportPage adhocReport = new AdhocApplicationReportPage(driver, test);
		HomePageReport home = new HomePageReport(driver, test);

		// *************** Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoAdhocReports();
					adhocReport.searchAdhocApplicationReport(SBUCode, ReferenceID, AuthorizationType, Status,
							AuthorizationNo, AuthorizationCountry, AgencyCode, ProgramCode, ExporterCode,
							RelatedAuthorisation, SegmentCode, Role, UserEmailId, DateInitiatedFrom, DateInitiatedTo,
							IssueDateFrom, IssueDateTo, DateSubmitFrom, DateSubmitTo, ExpiryDateFrom, ExpiryDateTo);
					adhocReport.click_ReportSearch();
					adhocReport.displayOfTitle();
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
