package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.ConsigneeTypesearchPage;
import filesClasses.HomepageConsigneePage;
import filesClasses.ResultConsigneeSerchTypePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ConsigneeTypeSearch extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ConsigneeTypeSearch", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPage(String testcases, String RunMode, String SBU, String SBUCode, String ConsigneeID) {

		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		ConsigneeTypesearchPage srchconsitype=new ConsigneeTypesearchPage(driver, test);
		ResultConsigneeSerchTypePage rsltconsgnetype= new ResultConsigneeSerchTypePage(driver, test);
		

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					//hpConsignee.alertHandle();
					hpConsignee.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpConsignee.movetoFilesConsigneetype();
					Wait.waitfor(3);
					srchconsitype.SearchConsigneeType(SBUCode, ConsigneeID);
					Wait.waitfor(3);
					rsltconsgnetype.displayOfTitle();
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
			rsltconsgnetype.logout();
			Assert.assertTrue(false);
		}

	}
}
