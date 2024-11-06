package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.ENCExceptionPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ENCExceptionReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ENCExceptionReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ENCException_Report(String Testcase, String RunMode, String SBU, String sbu, String workstatus, 
			String UltDestination,String Region, String Site) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ENCExceptionPage encexcep = new ENCExceptionPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_ENCExceptionReports();
					Wait.waitfor(2);
					encexcep.selectSBU(sbu);
					Wait.waitfor(2);
					encexcep.selectWorkstatus(workstatus);
					Wait.waitfor(2);
					encexcep.selectUltDestination(UltDestination);
					Wait.waitfor(2);
					encexcep.selectregion(Region);
					Wait.waitfor(2);
					encexcep.selectSite(Site);
					Wait.waitfor(2);
					encexcep.searchBtn();
					Wait.waitfor(2);
					encexcep.validateHeading();
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
