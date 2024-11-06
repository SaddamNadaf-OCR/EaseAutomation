package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.AddDCSpage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddDCS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDCS", excel);
	}

	@Test(dataProvider = "getData")
	public void ADDDCS(String Testcase, String RunMode, String SBU, String DcsId, String ExportingCountry,
			String ImportingCountry, String Statement) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		AddDCSpage addcs = new AddDCSpage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					addcs.movetoFiles();
					Wait.waitfor(2);
					addcs.adddcs();
					addcs.dcsdetails(DcsId, ExportingCountry, ImportingCountry, Statement);
					Wait.waitfor(2);
					addcs.savebtn();
					Wait.waitfor(2);
					addcs.validateHeading();
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
