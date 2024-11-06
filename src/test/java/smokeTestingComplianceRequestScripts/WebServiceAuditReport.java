package smokeTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ResultWebServiceAuditReportPage;
import crsClasses.SearchWebServiceAuditReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WebServiceAuditReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("WebServiceAuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void webServiceAuditReport(String TestCases, String RunMode, String SBUCode, String UserID, 
			String RequestType, String RequestDateFrom, String MessageType, String RequestDateTo, String Status, 
			String ReferanceNo, String AuditID) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		SearchWebServiceAuditReportPage search = new SearchWebServiceAuditReportPage(driver, test);
		ResultWebServiceAuditReportPage report = new ResultWebServiceAuditReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.webServiceAuditReport();
					search.searchbyParameters(SBUCode, UserID, RequestType, RequestDateFrom, MessageType, 
							RequestDateTo, Status, ReferanceNo, AuditID);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					Wait.waitfor(3);
					homePage.returnToCRPage();
					Wait.waitfor(3);
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnToCRPage();
			testFail();
		}
	}
}
