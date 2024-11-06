package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.DMSHomePage;
import dmsClasses.ResultControlAttributesDetailPage;
import dmsClasses.SearchControlAttributesDetailPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchControlAttributesDetail extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchControlAttribDet", excel);
	}

	@Test(dataProvider = "getData")
	public void search_ControlAttributes(String Testcase, String RunMode, String SBU, String ControlAttribDesc,
			String ControlAttribDetCode, String CtrlAttrDetDesc, String Status, String SortBy, String Direction)
			throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchControlAttributesDetailPage searchcad = new SearchControlAttributesDetailPage(driver, test);
		ResultControlAttributesDetailPage result = new ResultControlAttributesDetailPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoTools();
					home.movetocontrolattribdetails();
					Wait.waitfor(3);
					searchcad.search_ctrlattribdetails(ControlAttribDesc, ControlAttribDetCode, CtrlAttrDetDesc, Status,
							SortBy, Direction);
					searchcad.search();
					Wait.waitfor(5);
					result.validate_searchresult();
					result.returntosearchpage();
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
