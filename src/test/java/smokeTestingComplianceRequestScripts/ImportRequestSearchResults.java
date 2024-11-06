
package smokeTestingComplianceRequestScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ImportResultsImportRequestPage;
import crsClasses.ImportSearchImportRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ImportRequestSearchResults extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ImportSearchResults", excel);
	}

	@Test(dataProvider = "getData")
	public void ImportReq(String Testcase, String RunMode, String SbuID, String AuthorizationID, String LicenseAppNo, 
			String Status, String Determination) throws Exception {

		HomePageCRs						home     = new HomePageCRs(driver, test);
		SearchExportRequestPage     	searchER = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage 	searchIR = new ImportSearchImportRequestPage(driver, test);
		ImportResultsImportRequestPage	resultIR = new ImportResultsImportRequestPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.click_ComplianceRequest();
					searchER.moveTo_Features();
					searchER.click_Requests();
					searchER.click_ImportReq();
					searchIR.searchParameters(SbuID, AuthorizationID, LicenseAppNo, Status, Determination);
					searchIR.click_SearchBtn();
					resultIR.titleIsDisplayed();
					Wait.waitfor(3);
					home.returnToCRPage();
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
			home.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

}