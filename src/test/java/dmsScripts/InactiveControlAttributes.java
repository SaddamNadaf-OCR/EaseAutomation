package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.DMSHomePage;
import dmsClasses.ResultControlAttributesPage;
import dmsClasses.SearchControlAttributesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class InactiveControlAttributes extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchControlAttrib", excel);
	}

	@Test(dataProvider = "getData")
	public void delControlAttributes(String Testcase, String RunMode, String SBU, String ControlAttribCode,
			String ContAttribDes, String Status, String SortBy, String Direction) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchControlAttributesPage searchca = new SearchControlAttributesPage(driver, test);
		ResultControlAttributesPage result = new ResultControlAttributesPage(driver, test);

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
					searchca.search_controlattributes(ControlAttribCode, ContAttribDes, Status, SortBy, Direction);
					searchca.search();
					Wait.waitfor(10);
					result.inactivecontrolattrib();
					Wait.waitfor(5);
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
