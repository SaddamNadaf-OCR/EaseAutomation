package regressionTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AuthorizationMgmtHomepagePage;
import filesClasses.ResultAuthOwnerPage;
import filesClasses.SearchAuthorizationOwnersPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthOwnerSearchResult extends SeleniumTestBase {

	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthOwnerSearchResult", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPage( String testcases,String RunMode, String SBU, String SBUCode, String OwnerID, String OwnerEmpID) {

		AuthorizationMgmtHomepagePage hpAuthOwner = new AuthorizationMgmtHomepagePage(driver, test);
		SearchAuthorizationOwnersPage srchAuthOwnr = new SearchAuthorizationOwnersPage(driver, test) ;
		ResultAuthOwnerPage rsltauthOwnr= new ResultAuthOwnerPage(driver, test);
	
	
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					// hpConsignee.alertHandle();
					hpAuthOwner.moveTo_SBUSelection(SBU);
					Wait.waitfor(2);
					hpAuthOwner.movetoFiles();
					Wait.waitfor(2);
					srchAuthOwnr.SearchAuthowner(SBUCode, OwnerID, OwnerEmpID);
					Wait.waitfor(2);
					srchAuthOwnr.Click_search();
					Wait.waitfor(2);
					rsltauthOwnr.displayOfTitle();
				
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		
		} catch (SkipException s) {
			test.log(LogStatus.INFO, testcases);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			hpAuthOwner.logout();

		}
	}
}
