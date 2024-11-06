package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.DMSHomePage;
import dmsClasses.SearchDMSFormsConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchDMSFormConfg extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDMSForm", excel);
	}

	@Test(dataProvider = "getData")
	public void searchdmsconfg(String Testcase, String RunMode, String ConfigType, String SBU, String Module,
			String Formset, String UrlPattern, String Attrib1, String Status) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchDMSFormsConfigurationPage searchdms = new SearchDMSFormsConfigurationPage(driver, test);

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
					if (ConfigType.length() > 0) {
						searchdms.select_configtype(ConfigType);
						if (Module.length() > 0) {
							searchdms.select_module(Module);
							if (Formset.length() > 0) {
								searchdms.select_formset(Formset);
							}
						}
					}
					if (SBU.length() > 0) {
						searchdms.select_sbu(SBU);
					}
					if (UrlPattern.length() > 0) {
						searchdms.enter_urlpattern(UrlPattern);
					}
					if (Attrib1.length() > 0) {
						searchdms.enter_attrib1(Attrib1);
					}
					if (Status.length() > 0) {
						searchdms.select_status(Status);
					}
					searchdms.search();
					// home.returnToSearchProductPage();
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
