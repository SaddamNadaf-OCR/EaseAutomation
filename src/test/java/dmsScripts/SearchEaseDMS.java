package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.DMSHomePage;
import dmsClasses.ResultEaseDMSPage;
import dmsClasses.SearchEASEDMSPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchEaseDMS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchEaseDMS", excel);
	}

	@Test(dataProvider = "getData")
	public void searcheasedms(String Testcase, String RunMode, String SBU, String FileStoreType, String SBUCode,
			String ModuleName, String RefNo, String DocName, String URLLink, String LocationPath, String FTPServerName,
			String SetId, String DocType, String KeyWords, String SourceSysDocNo, String Status, String SortBy,
			String Direction) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchEASEDMSPage searchedms = new SearchEASEDMSPage(driver, test);
		ResultEaseDMSPage resultdms = new ResultEaseDMSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.movetoTools();
					home.moveto_EaseDMS();
					searchedms.searcheasedms(FileStoreType, SBUCode, ModuleName, RefNo, DocName, URLLink, LocationPath,
							FTPServerName, SetId, DocType, KeyWords, SourceSysDocNo, Status, SortBy, Direction);
					searchedms.search();
					Wait.waitfor(3);
					resultdms.validate_searchresult();
					resultdms.returntosearchpage();
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
