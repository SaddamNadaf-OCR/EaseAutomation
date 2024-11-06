package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dmsClasses.CreateNewDMSFormsConfigPage;
import dmsClasses.DMSHomePage;
import dmsClasses.SearchDMSFormsConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewDMSFormConfig extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDMSForm", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateDMSForm(String Testcase, String RunMode, String ConfigType, String SBU, String Module,
			String Attrib1, String URLPattern) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchDMSFormsConfigurationPage searchdms = new SearchDMSFormsConfigurationPage(driver, test);
		CreateNewDMSFormsConfigPage createdms = new CreateNewDMSFormsConfigPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.movetoTools();
					home.movetodmsconfig();
					Wait.waitfor(3);
					searchdms.click_adddmsformconfig();
					createdms.createnewdmsform(ConfigType, SBU, Module, Attrib1, URLPattern);
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
