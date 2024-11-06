package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.LVSExceptionPage;
import globalExportClasses.licenseExceptionSummarypage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LicenceExceptionsummaryReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LicenseExceptionsummryReport", excel);
	}
	
	@Test(dataProvider = "getData")
	public void ENCException_Report(String Testcase, String RunMode, String SBU, String sbu, String workstatus,
			 String ExportDateFrom, String ExportDateTo ,String UltDestination) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		licenseExceptionSummarypage licnexception = new licenseExceptionSummarypage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_AESummaryReports();
					Wait.waitfor(2);
					licnexception.selectSBU(sbu);
					Wait.waitfor(2);
					licnexception.selectWorkstatus(workstatus, ExportDateFrom, ExportDateTo);
					Wait.waitfor(2);
					licnexception.selectUltDestination(UltDestination);
					Wait.waitfor(2);
					licnexception.searchBtn();
					Wait.waitfor(2);
					licnexception.validateHeading();
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

