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

public class LpBelgiumDeleteRequest extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LpBelgiumDeletingRequest", excel);
	}

	@Test(dataProvider = "getData")
	public void LpBelgiumStatus(String Testcase,String RunMode,String SBU,String Status) throws Exception {
		
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
					searchAuth.status(Status);
					searchAuth.click_SearchBtn();
					searchAuthResults.delectIconAction(Status);
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
