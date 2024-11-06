package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ProvisoActionRequiredReportPage;
import authorizationManagementClasses.SearchProvisoActionRequiredReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ProvisoActionRequiredReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ProvisoActionRequiredReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void provisoActionRequiredReport(String TestCases, String RunMode, String SBU, String AuthorizationNo, 
			String SBUCode, String ProvisoNo, String ProvisoDescription, String FromReqCompletionDate, String ToReqCompletionDate, 
			String CompletionDateFrom, String CompletionDateTo, String Status) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchProvisoActionRequiredReportPage search = new SearchProvisoActionRequiredReportPage(driver, test);
		ProvisoActionRequiredReportPage report = new ProvisoActionRequiredReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ProvisoActionRequiredReports();
					search.searchByParameters(AuthorizationNo, SBUCode, ProvisoNo, ProvisoDescription, FromReqCompletionDate, 
							ToReqCompletionDate, CompletionDateFrom, CompletionDateTo, Status);
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