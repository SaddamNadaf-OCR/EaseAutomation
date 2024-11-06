package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationActivityAndBalancePage;
import authorizationManagementClasses.SearchAuthorizationActivityAndBalancePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationActivityAndBalance extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizationActivityAndBalance", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationActivityAndBalance(String TestCases, String RunMode, String SBU, String SBUCode, 
			String AuthorizationType, String AuthorizationNo, String Status, String ActivityType, String UltimateConsignee, 
			String ContractNo, String Country, String ReferanceNo, String TECC) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationActivityAndBalancePage search = new SearchAuthorizationActivityAndBalancePage(driver, test);
		ResultAuthorizationActivityAndBalancePage report = new ResultAuthorizationActivityAndBalancePage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationActivityReports();
					search.searchByParameters(SBUCode, AuthorizationType, AuthorizationNo, Status, ActivityType, UltimateConsignee, 
							ContractNo, Country, ReferanceNo, TECC);
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