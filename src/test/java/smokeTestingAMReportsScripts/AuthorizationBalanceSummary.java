package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationBalanceSummaryReportPage;
import authorizationManagementClasses.SearchAuthorizationBalanceSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationBalanceSummary extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizationBalanceSummary", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationBalanceSummary(String TestCases, String RunMode, String SBU, String SBUCode, String AuthorizationType, 
			String AuthorizationNo, String Site, String ActivityType, String Status, String Owner, String Program, String ContractNo, 
			String Agency, String ReferanceNo, String UltimateConsignee, String IssueDateFrom, String IssueDateTo, String Country, 
			String TECC, String AuthWillExpiry, String Segment, String ExpiryDateFrom, String ExpiryDateTo, String Originator, 
			String CreatedBy1, String SalesOrderNo1, String CaseNo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationBalanceSummaryPage search = new SearchAuthorizationBalanceSummaryPage(driver, test);
		ResultAuthorizationBalanceSummaryReportPage report = new ResultAuthorizationBalanceSummaryReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationBalanceSummaryReports();
					search.searchByParameters(SBUCode, AuthorizationType, AuthorizationNo, Site, ActivityType, Status,
							Owner, Program, ContractNo, Agency, ReferanceNo, UltimateConsignee, IssueDateFrom, IssueDateTo,
							Country, TECC, AuthWillExpiry, Segment, ExpiryDateFrom, ExpiryDateTo, Originator, CreatedBy1, SalesOrderNo1, CaseNo);
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
