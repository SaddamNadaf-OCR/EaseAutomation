package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomepageConsigneePage;
import filesClasses.ResultFFpage;
import filesClasses.SearchFreightForwardersPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FFSearchScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FFSearchScript", excel);
	}

	@Test(dataProvider = "getData")

	public void searchFF(String testcases, String RunMode, String SBU, String FFSBUCode, String Code, String name,
			String country) {
		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		SearchFreightForwardersPage SFF = new SearchFreightForwardersPage(driver, test);
		ResultFFpage RFF = new ResultFFpage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					hpConsignee.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpConsignee.movetoFilesfreightforwarders();
					Wait.waitfor(3);

					SFF.searchfreitforwrders(FFSBUCode, Code, name, country);
					Wait.waitfor(3);
					SFF.ClickonFFsearch();
					Wait.waitfor(3);
					RFF.displayOfTitle();
					Wait.waitfor(3);
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
			hpConsignee.logout();
			Assert.assertTrue(false);
		}

	}

}
