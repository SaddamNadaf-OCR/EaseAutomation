package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.DMSHomePage;
import dmsClasses.DocumentServerAccessConfigurationPage;
import dmsClasses.DocumentServerAccessConfigurationSearchResultPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class InactiveDocumentServerAcessConfiguration extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDocSerAcessConfig", excel);
	}

	@Test(dataProvider = "getData")
	public void delDocseracessconfig(String Testcase, String RunMode, String SBU, String FTPName, String AccessType,
			String Attribute, String Status, String SortBy) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		DocumentServerAccessConfigurationSearchResultPage resultdoc = new DocumentServerAccessConfigurationSearchResultPage(
				driver, test);
		DocumentServerAccessConfigurationPage doc = new DocumentServerAccessConfigurationPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoTools();
					home.movetodocserveraccconfig();
					Wait.waitfor(7);
					doc.search_docserveracessconfig(FTPName, AccessType, Attribute, Status, SortBy);
					doc.search();
					Wait.waitfor(5);
					resultdoc.inactivedocserveracessconfg();
					Wait.waitfor(5);
					resultdoc.returntosearchpage();
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
