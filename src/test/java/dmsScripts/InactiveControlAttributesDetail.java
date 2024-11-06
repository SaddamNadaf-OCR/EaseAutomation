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

public class InactiveControlAttributesDetail extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchControlAttribDet", excel);
	}

	@Test(dataProvider = "getData")
	public void delControlAttributes(String Testcase, String RunMode, String SBU, String ControlAttribDesc,
			String ControlAttribDetCode, String CtrlAttrDetDesc, String Status, String SortBy, String Direction)
			throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchControlAttributesDetailPage searchdet = new SearchControlAttributesDetailPage(driver, test);
		ResultControlAttributesDetailPage resultdet = new ResultControlAttributesDetailPage(driver, test);

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
					searchdet.search_ctrlattribdetails(ControlAttribDesc, ControlAttribDetCode, CtrlAttrDetDesc, Status,
							SortBy, Direction);
					searchdet.search();
					Wait.waitfor(10);
					resultdet.inactivecontrolattrib();
					Wait.waitfor(5);
					resultdet.returntosearchpage();
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
