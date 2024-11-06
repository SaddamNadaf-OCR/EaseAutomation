package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationInformationReportPage;
import authorizationManagementClasses.SearchAuthorizationInformationReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationInformationReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizationInformationReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationInformationReport(String TestCases, String RunMode, String SBU, String AuthorizationNo, 
			String AuthorizationType, String Status, String Agency, String Program, String ReferanceNo, String ContractNo, 
			String ExpiryDateFrom, String ExpiryDateTo, String UltimateConsignee, String Country, String EndUser) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationInformationReportPage search = new SearchAuthorizationInformationReportPage(driver, test);
		ResultAuthorizationInformationReportPage report = new ResultAuthorizationInformationReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationInformationReports();
					search.searchByParameters(AuthorizationNo, AuthorizationType, Status, Agency, Program, ReferanceNo, 
							ContractNo, ExpiryDateFrom, ExpiryDateTo, UltimateConsignee, Country, EndUser);
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