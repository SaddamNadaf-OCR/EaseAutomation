package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultWebServiceAuditReportAMPage;
import authorizationManagementClasses.SearchWebServiceAuditReportAMPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WebServiceAuditReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("WebServiceAuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void webServiceAuditReport(String TestCases, String RunMode, String SBU, String SBUCode, String UserID, 
			String RequestType, String RequestDateFrom, String MessageType, String RequestDateTo, String Status, String ReferanceNo, String AuditID) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchWebServiceAuditReportAMPage search = new SearchWebServiceAuditReportAMPage(driver, test);
		ResultWebServiceAuditReportAMPage report = new ResultWebServiceAuditReportAMPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_WebServiceAudit();
					search.searchbyParameters(SBUCode, UserID, RequestType, RequestDateFrom, MessageType, RequestDateTo, 
							Status, ReferanceNo, AuditID);
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
					homePage.returnTomoduleSelection();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnTomoduleSelection();
			testFail();
		}
	}
}
