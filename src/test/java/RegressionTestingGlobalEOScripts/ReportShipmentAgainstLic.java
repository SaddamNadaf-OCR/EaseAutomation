package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;

import globalExportClasses.ReportShipmentAgainstLicPage;
import globalExportClasses.ResultShipmentReportAgainstLicPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportShipmentAgainstLic extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportShipmentAgainstLic", excel);
	}

	@Test(dataProvider = "getData")
	public void reportShipmentAgainstLic(String Testcase,String RunMode, String Country, String Sbu, 
			String AuthorizationNo, String LicenseType, String DateOfExportFrom, String DateOfExportTo, String UltimateConsignee, String UltDestination)throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportShipmentAgainstLicPage search = new ReportShipmentAgainstLicPage (driver, test);
		ResultShipmentReportAgainstLicPage result = new ResultShipmentReportAgainstLicPage (driver, test);
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
					HGExport.ReportShipmentAgainstLic();
					Wait.waitfor(2);
					search.parameter(Country, Sbu, AuthorizationNo, LicenseType, DateOfExportFrom, DateOfExportTo, UltimateConsignee, UltDestination);
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


