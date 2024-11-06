package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportAuthorizationBal_PendPage;
import globalExportClasses.ReportShipmentSummaryPage;
import globalExportClasses.ResultAuthorizationBalPendPage;
import globalExportClasses.ResultShipmentReportSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportAuthorization_Bal_Pend  extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportAuthorization_Bal_Pend", excel);
	}

	@Test(dataProvider = "getData")
	public void reportAuthorization_Bal_Pend(String Testcase,String RunMode, String Sbu, String AuthType, String AuthNO, 
			String AuthStatus, String PartNo) throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportAuthorizationBal_PendPage search = new ReportAuthorizationBal_PendPage (driver, test);
		ResultAuthorizationBalPendPage result = new ResultAuthorizationBalPendPage (driver, test);
		
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
					HGExport.ReportAuthorizationBal_Pend();
					Wait.waitfor(2);
					search.parameter(Sbu,AuthType,AuthNO,AuthStatus,PartNo);
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


