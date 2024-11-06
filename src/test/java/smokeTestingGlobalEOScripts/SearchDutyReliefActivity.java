package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListDutyReliefActivityDetailsPage;
import globalExportClasses.SearchDutyReliefActivityLogPage;
import globalExportClasses.SearchDutyReliefAuthorizationDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchDutyReliefActivity extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDutyReliefActivity", excel);
	}

	@Test(dataProvider = "getData")
	public void searchDRActivity(String Testcase, String RunMode, String SBU, String ReliefAuthorizationNo,
			String ReliefType, String ActivityStatus, String PartNumber, String ShipmentType) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDutyReliefAuthorizationDetailsPage SearchDutyRAD = new SearchDutyReliefAuthorizationDetailsPage(driver,
				test);
		SearchDutyReliefActivityLogPage SearchDRALog = new SearchDutyReliefActivityLogPage(driver, test);
		ListDutyReliefActivityDetailsPage LDRActivity = new ListDutyReliefActivityDetailsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.clickDutyRAuth();
					SearchDutyRAD.clickSearchDRActivity();
					SearchDRALog.searchDFAlog(ReliefAuthorizationNo, ReliefType, ActivityStatus, PartNumber,
							ShipmentType);
					SearchDRALog.clickSearch();
					LDRActivity.lDRActivityTitle();
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
