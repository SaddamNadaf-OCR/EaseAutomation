package smokeTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AddOwnerPage;
import filesClasses.AuthorizationMgmtHomepagePage;
import filesClasses.ResultAuthOwnerPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddOwnerResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddOwnerResult", excel);
	}

	@Test(dataProvider = "getData")
	public void AddAuthOwnerpage( String testcases,String RunMode, String SBU, String EMPLName, String EMPFName)

	{
// create objects
		AuthorizationMgmtHomepagePage hpAuthMngmt = new AuthorizationMgmtHomepagePage(driver, test);
		AddOwnerPage adOwner = new AddOwnerPage(driver, test);
		ResultAuthOwnerPage rsltAuthOwner = new ResultAuthOwnerPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					Wait.waitfor(3);
					hpAuthMngmt.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpAuthMngmt.movetoFiles();
					Wait.waitfor(3);
				adOwner.SearchAuthowner(EMPLName, EMPFName);
					Wait.waitfor(3);
					adOwner.clickonSave();
					rsltAuthOwner.displayOfTitle();
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
			hpAuthMngmt.logout();

		}
	}
}
