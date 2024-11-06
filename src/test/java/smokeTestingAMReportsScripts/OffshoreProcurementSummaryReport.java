package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.OffshoreProcurementSummaryReportPage;
import authorizationManagementClasses.SearchOffshoreProcurementSummaryReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class OffshoreProcurementSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("OffProSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void offshoreProcurementSummaryReport(String TestCases, String RunMode, String SBU, String SBUCode, String AuthorizationType,
			String TransactionID, String AuthorizationNo, String Owner, String POC, String Status, String ReportDateFrom, 
			String ReportDateTo, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchOffshoreProcurementSummaryReportPage search = new SearchOffshoreProcurementSummaryReportPage(driver, test);
		OffshoreProcurementSummaryReportPage report = new OffshoreProcurementSummaryReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_OffshoreProcurementSummaryReports();
					search.searchByAllParameters(SBUCode, AuthorizationType, TransactionID, AuthorizationNo, Owner,
							POC, Status, ReportDateFrom, ReportDateTo, SortBy, direction);
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