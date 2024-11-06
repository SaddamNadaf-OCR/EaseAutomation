package lpAppBelgiumScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import lpAppBelgiumClasses.HomeLpPage;
import lpAppBelgiumClasses.SearchAuthorizationsPage;
import lpAppBelgiumClasses.SearchAuthorizationsResultsPage;
import utilities.Utility;
import utilities.Wait;

public class LpbelgiumCommonSearchAuthorizationResults extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LpbelgiumCommonSearchResults", excel);
	}

	@Test(dataProvider = "getData")
	public void LpBelgiumStatus(String Testcase,String RunMode,String SBU, String AuthGrantedByCountry,
			String AuthorizationType, String CSCountry, String CSSbuCode, String RefereneceID, String Status,
			String WlsStatus, String  AuthPurpose, String Program, String Segment, String CaseNo, 
			String AuthorizationNo,	String RequestorName, String ReviewerName, String ReviewDateFrom, 
			String ReviewDateTo, String ReviewCompletedDateFrom, String ReviewCompletedDateTo,
			String ApplctionSubmtDateFrom, String ApplctionSubmtDateTo, String IssueDateFrom, 
			String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo,	String CreatedDateFrom,
			String CreatedDateTo, String ModifiedDateFrom, String ModifiedDateTo,String CreatedBy,
			String ModifiedBy, String Country, String PartNo, String Consignee, String PartDescription, 
			String ApplicantName  ) throws Exception {

		HomeLpPage                      homelp 			  = new HomeLpPage(driver, test);
		SearchAuthorizationsPage        searchAuth 		  = new SearchAuthorizationsPage(driver, test);
		SearchAuthorizationsResultsPage searchAuthResults = new SearchAuthorizationsResultsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homelp.moveTo_SBUSelection(SBU);
					searchAuth.commonSearch(AuthGrantedByCountry, AuthorizationType, CSCountry, CSSbuCode, RefereneceID,
							Status, WlsStatus, AuthPurpose, Program, Segment, CaseNo, AuthorizationNo, RequestorName, 
							ReviewerName, ReviewDateFrom,ReviewDateTo,ReviewCompletedDateFrom, ReviewCompletedDateTo,
							ApplctionSubmtDateFrom, ApplctionSubmtDateTo, IssueDateFrom, IssueDateTo, ExpiryDateFrom, 
							ExpiryDateTo, CreatedDateFrom, CreatedDateTo, ModifiedDateFrom, ModifiedDateTo,CreatedBy,
							ModifiedBy);
					searchAuth.authorizationDetailSearch(Country, PartNo, Consignee, PartDescription, ApplicantName);
					searchAuth.click_SearchBtn();
					searchAuthResults.searchAuthPageDisplay();
					Wait.waitfor(4);			
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
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
