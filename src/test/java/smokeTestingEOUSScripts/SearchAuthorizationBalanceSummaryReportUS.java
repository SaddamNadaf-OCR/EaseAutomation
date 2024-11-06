package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchAuthorizationBalanceSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchAuthorizationBalanceSummaryReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthBalSumReport", excel);
	}

	@Test(dataProvider = "getData")
	public void AuthbalSumReport(String Testcase, String RunMode, String SBU, String sbu, String ActivityStatus, String AuthStatus, String AuthTypeLink  ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAuthorizationBalanceSummaryPage AuthBalSumReport = new SearchAuthorizationBalanceSummaryPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.AuthorizationReport();
					HGExport.AuthbalanceSumm();
					AuthBalSumReport.selectSBU(sbu);
					AuthBalSumReport.selectActivity(ActivityStatus);
					AuthBalSumReport.selectAuthStatus(AuthStatus);
					AuthBalSumReport.enterAuthType(AuthTypeLink);
					AuthBalSumReport.clickSearchBtn();
					AuthBalSumReport.validateHeading();
					
					
				
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
