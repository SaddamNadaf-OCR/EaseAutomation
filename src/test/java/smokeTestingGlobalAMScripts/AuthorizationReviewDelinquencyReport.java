package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizationReviewDelinquencyReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizationReviewDelinquencyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationReviewDelinquencyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthReviewDelinquencyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationReviewDelinquencyReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String ActivityType, String AuthorizationType, String TransactionID, String LicenseNo, String Owner, 
			String Manager, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationReviewDelinquencyReportPage search = new SearchAuthorizationReviewDelinquencyReportPage(driver, test);
		AuthorizationReviewDelinquencyReportPage report = new AuthorizationReviewDelinquencyReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_DelinquencyReports();
					search.searchByParameters(SBUCode, ActivityType, AuthorizationType, TransactionID, LicenseNo, Owner, Manager, SortBy, Direction);
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