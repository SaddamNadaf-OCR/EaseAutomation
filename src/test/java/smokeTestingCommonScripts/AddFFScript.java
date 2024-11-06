package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AddFFresultPage;
import filesClasses.AddfreightForwarderPage;
import filesClasses.HomepageConsigneePage;


import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddFFScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddFFScript", excel);
	}

	@Test(dataProvider = "getData")

	public void searchFF(String testcases, String RunMode, String SBU, String FFName,String FFcodeinput) {
		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		AddfreightForwarderPage AddFF = new AddfreightForwarderPage(driver, test);
		AddFFresultPage AdFFrslt= new AddFFresultPage(driver, test);
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
					AddFF.addFF(FFName,FFcodeinput);
					Wait.waitfor(3);
					AddFF.addFFsave();
					Wait.waitfor(3);
					AdFFrslt.displayOfTitle();
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
