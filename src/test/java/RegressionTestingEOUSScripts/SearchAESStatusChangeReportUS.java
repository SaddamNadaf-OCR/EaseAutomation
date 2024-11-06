package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.AESStatusChangeReportPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchAESStatusChangeReportUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AESStatusChangeReport", excel);
	}

	@Test(dataProvider = "getData")
	public void AESReport(String Testcase, String RunMode, String SBU, String SBUCode, String ShipmentNo, 
			String AESStatus, String ITNNO, String FromDate, String EndDate, String UserName, String SortBy, String Direction) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		AESStatusChangeReportPage AESReport = new AESStatusChangeReportPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.auditReports();
					HGExport.AESStatusChangeReports();
					AESReport.searchbyparameter(SBUCode, ShipmentNo, AESStatus, ITNNO, FromDate, EndDate, UserName, SortBy, Direction);
					AESReport.SearchBtn();
					AESReport.validateHeading();
					
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
