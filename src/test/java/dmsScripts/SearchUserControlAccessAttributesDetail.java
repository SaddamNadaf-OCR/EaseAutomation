package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.DMSHomePage;
import dmsClasses.ResultUserControlAccessAttributesDetailPage;
import dmsClasses.SearchUserControlAccessAttributesDetailPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchUserControlAccessAttributesDetail extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchUserCtrlAccAttrib", excel);
	}

	@Test(dataProvider = "getData")
	public void search_DoctypeControlAttributes(String Testcase, String RunMode, String SBU, String UserId,
			String ContrAttrib, String ContrAttribDet, String SortBy, String Direction) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchUserControlAccessAttributesDetailPage searchuctrl = new SearchUserControlAccessAttributesDetailPage(
				driver, test);
		ResultUserControlAccessAttributesDetailPage resultuctrl = new ResultUserControlAccessAttributesDetailPage(
				driver, test);

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
					searchuctrl.search_userctrlacessattribdetails(UserId, ContrAttrib, ContrAttribDet, SortBy,
							Direction);
					searchuctrl.search();
					Wait.waitfor(5);
					resultuctrl.validate_searchresult();
					Wait.waitfor(5);
					resultuctrl.returntosearchpage();
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
