package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchDutyReliefAuthorizationActivityAndBalanceReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchDutyReliefAuthorizationActivityAndBalanceReportUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DutyReliefReport", excel);
	}

	@Test(dataProvider = "getData")
	public void DRAReport(String Testcase, String RunMode, String SBU, String Sbu, String Status, String RANLink, String RAN, String RelType, String RelCat ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDutyReliefAuthorizationActivityAndBalanceReportPage DRAReport = new SearchDutyReliefAuthorizationActivityAndBalanceReportPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.DRAReports();
					DRAReport.selectSBU(Sbu);
					DRAReport.selectStatus(Status);
					DRAReport.ReliefAuthNo(RANLink, RAN);
					DRAReport.ReliefType(RelType);
					DRAReport.ReliefCategory(RelCat);
					DRAReport.SearchBtn();
					DRAReport.validateHeading();
					
				
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
