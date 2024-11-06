package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultOwnerDiscrepancyReportPage;
import authorizationManagementClasses.SearchOwnerDiscrepancyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthOwnerDiscrepancyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthOwnerDiscrepancyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void authOwnerDiscrepancyReport(String TestCases, String RunMode, String SBU, String SBUCode, String AuthorizationType, 
			String TransactionID, String AuthorizationNo, String Status, String Owner, String POC, String Purpose, String ProductLine, 
			String ProductFamily, String NotifyDateFrom, String NotifyDateTo, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchOwnerDiscrepancyReportPage search = new SearchOwnerDiscrepancyReportPage(driver, test);
		ResultOwnerDiscrepancyReportPage report = new ResultOwnerDiscrepancyReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationOwnerDiscrepancyReports();
					search.searchByParameters(SBUCode, AuthorizationType, TransactionID, AuthorizationNo, Status, Owner, 
							POC, Purpose, ProductLine, ProductFamily, NotifyDateFrom, NotifyDateTo, SortBy, Direction);
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