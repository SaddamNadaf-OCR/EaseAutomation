package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizedExceptionReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizedExceptionReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizedExceptionReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizedExceptionReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizedExceptionReport(String TestCases, String RunMode, String SBU, String SBUCode, String AuthorizationNo, 
			String Exception, String Program, String EndUser, String Country, String ECCNUSML, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizedExceptionReportPage search = new SearchAuthorizedExceptionReportPage(driver, test);
		AuthorizedExceptionReportPage report = new AuthorizedExceptionReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_DOCExceptionReports();
					search.searchByAllParameters(SBUCode, AuthorizationNo, Exception, Program, EndUser, Country, ECCNUSML, SortBy, direction);
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