package regressionTestingVMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.ResultReportPage;
import vmsClasses.SearchReportsPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorSummaryReportByExportAuthorityPage;


public class SearchMetrixByExportAuthority extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchMetrixByExportAuthority", excel);

	}

	@Test(dataProvider = "getData")

	public void searchMetrixByExportAuthority(String TestCases, String RunMode, String SBU, String SBUCode,
			String RequestID, String VisitorName, String VisitRequestFrom, String VisitRequestTo,
			String VisitorCategory, String site, String FromDate, String ToDate, String SFromDate, String SToDate,
			String AFromDate, String AToDate)

	{
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage saarchReport = new SearchReportsPage(driver, test);
		VisitorSummaryReportByExportAuthorityPage metrixByExportAuthority = new VisitorSummaryReportByExportAuthorityPage(
				driver, test);
		ResultReportPage result = new ResultReportPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");

			} else {

				if (RunMode.equalsIgnoreCase("y")) {

					test.log(LogStatus.INFO, TestCases);

					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Reports();
					saarchReport.click_MetricsReport();
					Wait.waitfor(3);
					saarchReport.click_ByExportAuthority();
					Wait.waitfor(3);
					metrixByExportAuthority.searchParameters(SBUCode, RequestID, VisitorName, VisitRequestFrom,
							VisitRequestTo, VisitorCategory, site, FromDate, ToDate, SToDate, SFromDate, AFromDate,
							AToDate);
					Wait.waitfor(3);
					metrixByExportAuthority.clicksearchbutton();
					Wait.waitfor(10);
					result.titleIsDisplayedMatrixbyExportAuthority();
					Wait.waitfor(3);
					homePage.returnPage();
				} else {
					testFail();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			homePage.returnPage();
			testFail();
		}
	}

}
