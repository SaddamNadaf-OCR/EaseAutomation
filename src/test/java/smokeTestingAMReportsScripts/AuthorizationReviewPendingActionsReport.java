package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizationReviewPendingActionsReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizationReviewPendingActionsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationReviewPendingActionsReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthReviewPendingActReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationReviewPendingActionsReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String ActivityType, String AuthorizationType, String TransactionID, String LicenseNo, String ApproverName, 
			String LicensePOC, String Program, String Segment, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationReviewPendingActionsReportPage search = new SearchAuthorizationReviewPendingActionsReportPage(driver, test);
		AuthorizationReviewPendingActionsReportPage report = new AuthorizationReviewPendingActionsReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_PendingActionReports();
					search.searchByParameters(SBUCode, ActivityType, AuthorizationType, TransactionID, LicenseNo, ApproverName, 
							LicensePOC, Program, Segment, SortBy, Direction);
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