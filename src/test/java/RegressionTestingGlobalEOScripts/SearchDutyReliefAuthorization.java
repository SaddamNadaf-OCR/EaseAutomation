package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListDutyReliefAuthorizationDetailsPage;
import globalExportClasses.SearchDutyReliefAuthorizationDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchDutyReliefAuthorization extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDutyReliefAuth", excel);
	}

	@Test(dataProvider = "getData")
	public void searchDRAuthorization(String Testcase, String RunMode, String SBU, String DutyRFAuthSBU, String Status,
			String AuthorizationNo, String ReliefType, String ReliefCategory) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);

		SearchDutyReliefAuthorizationDetailsPage SearchDutyRAD = new SearchDutyReliefAuthorizationDetailsPage(driver,
				test);
		ListDutyReliefAuthorizationDetailsPage LDRA = new ListDutyReliefAuthorizationDetailsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.clickDutyRAuth();
					SearchDutyRAD.searchDFAuth(DutyRFAuthSBU, Status, AuthorizationNo, ReliefType, ReliefCategory);
					SearchDutyRAD.clickSearch();
					LDRA.lDRAuthTitle();
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
