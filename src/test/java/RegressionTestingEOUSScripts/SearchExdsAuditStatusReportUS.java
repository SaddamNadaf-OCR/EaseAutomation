package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchExdsAuditStatusReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchExdsAuditStatusReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExdsAuditStatusReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ExdsAuditReport(String Testcase, String RunMode, String SBU, String SbuCode, String RefNo, 
			String FormType, String WorkStatus, String WLStatus, String LRStatus, String FromDate, String EndDate, String StatusChangedBy) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchExdsAuditStatusReportPage ExdsReport = new SearchExdsAuditStatusReportPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.auditReports();
					HGExport.ShipStatusReport();
					ExdsReport.searchbyparameter(SbuCode, RefNo, FormType, WorkStatus, WLStatus, LRStatus, FromDate, EndDate, StatusChangedBy);
					ExdsReport.SearchBtn();
					ExdsReport.validateHeading();
					
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
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	

	

	
	
}
