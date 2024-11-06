/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Aug 2019
 * Descriptions : Agreement Request Search Result
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */

package smokeTestingComplianceRequestScripts;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ResultAgreementRequestPage;
import crsClasses.SearchAgreementRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgreementReqSearchResult extends SeleniumTestBase{ 
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AgrSearchResult", excel);
	}

	@Test(dataProvider = "getData")
	public void AgrReq(String Testcase, String RunMode, String SbuID, String AuthorizationID, String LicenseNo, 
			String LicenseType, String Status)
			throws Exception {

		HomePageCRs						home     = new HomePageCRs(driver, test);
		SearchExportRequestPage         searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage      searchAR = new SearchAgreementRequestPage(driver, test);		
		ResultAgreementRequestPage	    resultAR = new ResultAgreementRequestPage(driver, test);

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
					Wait.waitfor(3);
					searchER.click_Requests();
					Wait.waitfor(3);
					searchER.click_AgreementReq();
					Wait.waitfor(3);
					searchAR.searchParameters(SbuID, AuthorizationID, LicenseNo, LicenseType, Status);
					Wait.waitfor(3);
					searchAR.click_SearchBtn();
					resultAR.titleIsDisplayed();
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


