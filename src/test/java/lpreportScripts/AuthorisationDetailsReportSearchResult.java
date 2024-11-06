package lpreportScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import lpreports.AuthorisationDetailsReportPage;
import lpreports.HomePageReport;
import utilities.Utility;
import utilities.Wait;

public class AuthorisationDetailsReportSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthorisationDetailsSearch", excel);
	}

	@Test(dataProvider = "getData")



	public void authorisationsearchpage(String Testcase, String RunMode, String SBU, String SBUCode, String ReferenceID, String Status, String FolderID, String AuthorizationCode, 
			String AuthorizationNo, String AuthorizationCountry, String Code, String AgencyCode, String ProgramCode, String SegmentCode,
			String RequestorName, String ReviewerName, String SubmitReviewDateFrom, String SubmitReviewDateTo, String ReviewCompletedDateFrom, String ReviewCompletedDateTo, 
			String ApplicationSubmitDateFrom, String ApplicationSubmitDateTo, String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo,
			String Country, String PartNo, String ConsigneeId, String PartDescription, String ManufactureCode) throws Exception {

		// ******************************** Objects Creation*******************************************

		AuthorisationDetailsReportPage authdetailsReport = new AuthorisationDetailsReportPage(driver, test);
		HomePageReport home = new HomePageReport(driver, test);

		// ******************************************** Test steps execution***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoAuthorisationDetailsReports();
					authdetailsReport.searchAuthorisationDetailsReport(SBUCode, ReferenceID, Status, FolderID, AuthorizationCode, AuthorizationNo,
							AuthorizationCountry, Code, AgencyCode, ProgramCode, SegmentCode, RequestorName, ReviewerName, SubmitReviewDateFrom,
							SubmitReviewDateTo, ReviewCompletedDateFrom, ReviewCompletedDateTo, ApplicationSubmitDateFrom, ApplicationSubmitDateTo, 
							IssueDateFrom, IssueDateTo, ExpiryDateFrom, ExpiryDateTo, Country, PartNo, ConsigneeId, PartDescription, ManufactureCode);
					authdetailsReport.click_ReportSearch();
					authdetailsReport.displayOfTitle();
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
