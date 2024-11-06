package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dmsClasses.CreateNewControlAttributesPage;
import dmsClasses.DMSHomePage;
import dmsClasses.SearchControlAttributesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewControlAttributes extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCA", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateControlAttribute(String Testcase, String RunMode, String SBU, String ControlAttribCode,
			String ControlAttribDesc) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchControlAttributesPage searchca = new SearchControlAttributesPage(driver, test);
		CreateNewControlAttributesPage newca = new CreateNewControlAttributesPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoTools();
					home.movetocontrolattrib();
					Wait.waitfor(3);
					searchca.add_controlattrib();
					newca.add_controlattributes(ControlAttribCode, ControlAttribDesc);
					Wait.waitfor(5);
					newca.cancel();
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
