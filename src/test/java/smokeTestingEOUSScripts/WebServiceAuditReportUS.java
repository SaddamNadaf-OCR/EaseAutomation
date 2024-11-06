package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultWebServiceAuditReportAMPage;
import authorizationManagementClasses.SearchWebServiceAuditReportAMPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WebServiceAuditReportUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("WebServiceAuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void webServiceAuditReport(String TestCases, String RunMode, String SBU, String SBUCode, String UserID, 
			String RequestType, String RequestDateFrom, String MessageType, String RequestDateTo, String Status, String ReferanceNo, String AuditID) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchWebServiceAuditReportAMPage search = new SearchWebServiceAuditReportAMPage(driver, test);
		ResultWebServiceAuditReportAMPage report = new ResultWebServiceAuditReportAMPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_WebServiceAudit();
					search.searchbyParameters(SBUCode, UserID, RequestType, RequestDateFrom, MessageType, RequestDateTo, 
							Status, ReferanceNo, AuditID);
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
					HGExport.return_ExportHome();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			HGExport.return_ExportHome();
			testFail();
		}
	}
}
