package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.CreateNewUserControlAccessAttributesDetailPage;
import dmsClasses.DMSHomePage;
import dmsClasses.SearchUserControlAccessAttributesDetailPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewUserControlAccessAttributesDetail extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddUserCtrlAccAttrib", excel);
	}

	@Test(dataProvider = "getData")
	public void adduserctrlacessattribdet(String Testcase, String RunMode, String SBU, String UserId,
			String ContrAttrib) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		CreateNewUserControlAccessAttributesDetailPage createuserctr = new CreateNewUserControlAccessAttributesDetailPage(
				driver, test);
		SearchUserControlAccessAttributesDetailPage searchuser = new SearchUserControlAccessAttributesDetailPage(driver,
				test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoTools();
					home.movetouserctrlaccattrib();
					Wait.waitfor(7);
					searchuser.add_doctypcontrolattrib();
					createuserctr.add_usertcontrlattribdetmapping(UserId, ContrAttrib);
					createuserctr.save();
					Wait.waitfor(5);
					home.return_ExportHome();
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
			home.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}