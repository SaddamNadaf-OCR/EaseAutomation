package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import filesClasses.AddconsigneeTypePage;
import filesClasses.AddconsigneetypeResultPage;
import filesClasses.HomepageConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ConsigneetypeAddResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ConsigneetypeAddResult", excel);
	}

	@Test(dataProvider = "getData")
	public void AddconsigneeTypePage(String testcases, String RunMode, String SBU, String ConsigneeID, String ConsigneeName) {

		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		AddconsigneetypeResultPage adCnsityperslt = new AddconsigneetypeResultPage(driver, test);
		AddconsigneeTypePage addconsgnetype=new AddconsigneeTypePage(driver, test);
		
		

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
					addconsgnetype.AddConsigneetypeDetails(ConsigneeID, ConsigneeName);
					Wait.waitfor(3);
					addconsgnetype.Click_ConsigneetypeSave();
					Wait.waitfor(3);
					adCnsityperslt.displayOfTitle();
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
			adCnsityperslt.logout();
			Assert.assertTrue(false);
		}

	}
}
