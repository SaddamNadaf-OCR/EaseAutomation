package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationExpiringReportPage;
import authorizationManagementClasses.SearchAuthorizationExpiringReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationExpiringReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizationExpiringReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationExpiringReport(String TestCases, String RunMode, String SBU, String SBUCode, String AuthorizationType, 
			String AuthorizationNo, String Country, String Program, String Segment, String Site, String Department, String ExpiryDateFrom, 
			String ExpiryDateTo, String CreatedBy) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationExpiringReportPage search = new SearchAuthorizationExpiringReportPage(driver, test);
		ResultAuthorizationExpiringReportPage report = new ResultAuthorizationExpiringReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationExpiryReports();
					search.searchByParameters(SBUCode, AuthorizationType, AuthorizationNo, Country, Program, Segment, 
							Site, Department, ExpiryDateFrom, ExpiryDateTo, CreatedBy);
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