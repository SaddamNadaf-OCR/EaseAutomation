package regressionTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AddConsigneePage;
import filesClasses.HomepageConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ConsigneeAddResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddConsignee", excel);
	}

	@Test(dataProvider = "getData")
	public void AddConsigneepage(String testcases, String RunMode, String SBU, String InputId, String ConsigneeName,
			String ID)

	{
// create objects
		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		AddConsigneePage addConsignee = new AddConsigneePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					
					hpConsignee.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpConsignee.movetoFiles();
					Wait.waitfor(3);
					hpConsignee.ClickOnAddConsingee();
					Wait.waitfor(3);
					addConsignee.AddConsigneeDetails(InputId, ConsigneeName, ID);
					Wait.waitfor(3);
					addConsignee.Click_ConsigneeSave();
					hpConsignee.logout();
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

		}
	}
}
