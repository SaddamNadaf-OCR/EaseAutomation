package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportShipmentAESPage;

import globalExportClasses.ResultShipmentReportAESPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportShipmentAES extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportShipmentAES", excel);
	}

	@Test(dataProvider = "getData")
	public void reportShipmentAES(String Testcase,String RunMode, String Sbu, String ShipmentNo, 
			String status, String Options)throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportShipmentAESPage search = new ReportShipmentAESPage (driver, test);
		ResultShipmentReportAESPage result = new ResultShipmentReportAESPage (driver, test);
	
	// **********Test steps execution ***************************
	try {
		if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
			throw new SkipException("Skipping the test");
		} else {
			if (RunMode.equalsIgnoreCase("y")) {
				test.log(LogStatus.INFO, Testcase);
				Wait.waitfor(2);
				HGExport.moduleselection();
				Wait.waitfor(2);
				HGExport.ReportShipmentAES();
				Wait.waitfor(2);
//				search.parameter(Sbu,ShipmentNo,status,Options);
				Wait.waitfor(2);
				search.search();
				Wait.waitfor(2);
				result.titleIsDisplayed();
				Wait.waitfor(2);
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
