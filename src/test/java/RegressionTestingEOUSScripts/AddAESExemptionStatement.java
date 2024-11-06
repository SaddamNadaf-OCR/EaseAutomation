package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.AddAesExemptionStatementpage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddAESExemptionStatement extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddaesExemptionStatement", excel);
	}

	@Test(dataProvider = "getData")
	public void addDutyRActivity(String Testcase, String RunMode, String SBU, String Country, String Exemptioncode,
			String ExemptionDesc) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		AddAesExemptionStatementpage aesexm = new AddAesExemptionStatementpage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					aesexm.movetoFiles();
					Wait.waitfor(2);
					aesexm.addexemption();
					aesexm.exemptiondetails(Country, Exemptioncode, ExemptionDesc);
					Wait.waitfor(2);
					aesexm.savebtn();
					Wait.waitfor(2);
					aesexm.validateHeading();
					Wait.waitfor(3);
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
