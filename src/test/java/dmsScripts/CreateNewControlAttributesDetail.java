package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.CreateNewControlAttributesDetailPage;
import dmsClasses.DMSHomePage;
import dmsClasses.SearchControlAttributesDetailPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewControlAttributesDetail extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCtrlAttribDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateControlAttributeDet(String Testcase, String RunMode, String SBU, String ControlAttribDesc,
			String ControlAttribDetailCode, String ControlAttribDetDesc) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchControlAttributesDetailPage searchcad = new SearchControlAttributesDetailPage(driver, test);
		CreateNewControlAttributesDetailPage newcad = new CreateNewControlAttributesDetailPage(driver, test);

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
					searchcad.add_controlattribdet();
					newcad.add_controlattributesdet(ControlAttribDesc, ControlAttribDetailCode, ControlAttribDetDesc);
					Wait.waitfor(5);
					newcad.cancel();
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
