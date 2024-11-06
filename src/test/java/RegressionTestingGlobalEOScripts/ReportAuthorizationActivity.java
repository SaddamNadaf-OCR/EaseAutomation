package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportAuthorizationActivityPage;
import globalExportClasses.ResultAuthorizationActivityReportPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportAuthorizationActivity extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportAuthorizationActivity", excel);
	}

	@Test(dataProvider = "getData")
	public void reportAuthorizationActivity(String Testcase,String RunMode, String Sbu, String AuthType, 
			String AuthNO, String AuthStatus, String ActivityType, String salesOrderNo, String UltConsingnee, String RefNo, String FromDate, String EndDate, String Segment, String Expiredays, String ExpireDateFrom, String ExpireDateTo, String SalesOrderNo, String AuthTypeLink, String Sbucode2, String ItemNO, String PartNo, String activityTypeItem, String Description, String Quantity, String AuthQty, String AuthValue, String SOItemNO, String Country2, String ECCN )throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportAuthorizationActivityPage search = new ReportAuthorizationActivityPage (driver, test);
		ResultAuthorizationActivityReportPage result = new ResultAuthorizationActivityReportPage (driver, test);
		
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
					HGExport.ReportAuthorizationActivity();
					Wait.waitfor(2);
//					search.Searchbyparameter(Sbu,AuthType,AuthNO,AuthStatus,ActivityType,UltConsingnee,RefNo,
//							FromDate,EndDate,Segment,Expiredays,ExpireDateFrom,ExpireDateTo,SalesOrderNo,AuthTypeLink);
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
	@Test(dataProvider = "getData")
	public void reportAuthorizationActivity2(String Testcase,String RunMode, String Sbu, String AuthType, 
			String AuthNO, String AuthStatus, String ActivityType, String salesOrderNo, String UltConsingnee, String RefNo, String FromDate, String EndDate, String Segment, String Expiredays, String ExpireDateFrom, String ExpireDateTo, String SalesOrderNo, String AuthTypeLink, String Sbucode2, String ItemNO, String PartNo, String activityTypeItem, String Description, String Quantity, String AuthQty, String AuthValue, String SOItemNO, String Country2, String ECCN )throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportAuthorizationActivityPage search = new ReportAuthorizationActivityPage (driver, test);
		ResultAuthorizationActivityReportPage result = new ResultAuthorizationActivityReportPage (driver, test);
		
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
					HGExport.ReportAuthorizationActivity();
					Wait.waitfor(2);
					search.Searchbyparameter2(Sbucode2,ItemNO,PartNo,activityTypeItem,Description,
							Quantity,AuthQty,AuthValue,SOItemNO,Country2,ECCN);
					Wait.waitfor(2);
					search.search2();
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
