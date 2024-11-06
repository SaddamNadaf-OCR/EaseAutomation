package regressionTestingVMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.ResultReportPage;
import vmsClasses.SearchReportsPage;
import vmsClasses.SearchStatusChangeAuditReportPage;
import vmsClasses.SearchVisitorRequestPage;

public class SearchStatusChangeReport extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchStatusChangeReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchStatusChangeReport(String TestCases, String RunMode, String SBU, String SBUCode, String VisitorCategory, 
			String RequestID, String site, String SortBy,String Direction) {
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				saarchReport =new SearchReportsPage(driver, test);
		SearchStatusChangeAuditReportPage statusChangeReport	=new SearchStatusChangeAuditReportPage(driver, test);
		ResultReportPage				result	= new ResultReportPage(driver, test);
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Reports();
					saarchReport.click_StatusChangeReport();
					statusChangeReport.searchParameters(SBUCode, VisitorCategory, RequestID, site, SortBy, Direction);
					statusChangeReport.clickSearchbutton();
					Wait.waitfor(3);
					result.titleIsDisplayedStatusChangedAudit();
					homePage.returnPage();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnPage();
			testFail();
		}
	}
}

		


