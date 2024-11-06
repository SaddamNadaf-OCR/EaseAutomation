package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchAuthorizationExpiringReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchAuthorizationExpiringReportUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthExpiringReport", excel);
	}

	@Test(dataProvider = "getData")
	public void AuthExpiringReport(String Testcase, String RunMode, String SBU, String sbu, String AuthType, String AuthTypeLink, String AuthNoLink, String AuthNumber  ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAuthorizationExpiringReportPage AuthExpReport = new SearchAuthorizationExpiringReportPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.AuthorizationReport();
					HGExport.AuthExpiry();
					AuthExpReport.selectSBU(sbu);
					AuthExpReport.enterAuthType(AuthType, AuthTypeLink);
					AuthExpReport.authNo(AuthNoLink, AuthNumber);
					AuthExpReport.searchBtn();
					AuthExpReport.validateHeading();
				
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
