package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.ENCExceptionPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.LVSExceptionPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LVSExceptionReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LVSExceptionReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ENCException_Report(String Testcase, String RunMode, String SBU, String sbu, String workstatus,
			String UltDestination, String ExportDateFrom, String ExportDateTo) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		LVSExceptionPage lvsexception = new LVSExceptionPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_LVSExceptionReports();
					Wait.waitfor(2);
					lvsexception.selectSBU(sbu);
					Wait.waitfor(2);
					lvsexception.selectWorkstatus(workstatus);
					Wait.waitfor(2);
					lvsexception.selectultdestination(UltDestination, ExportDateFrom, ExportDateTo);
					Wait.waitfor(2);
					lvsexception.searchBtn();
					Wait.waitfor(2);
					lvsexception.validateHeading();
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
