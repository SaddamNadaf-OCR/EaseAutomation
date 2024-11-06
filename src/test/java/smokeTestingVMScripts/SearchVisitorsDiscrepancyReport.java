package smokeTestingVMScripts;

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
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.SearchVisitorsDiscrepancyReportPage;

public class SearchVisitorsDiscrepancyReport extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchVisitorsDiscrepancyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchVisitorsDiscrepancyReport(String TestCases, String RunMode, String SBU,String SBUCode,String VisitRequestFrom, String VisitRequestTo,
			String RequestID, String VisitorName, String VisitorCategory, String site, String SortBy,String Direction) {
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				saarchReport =new SearchReportsPage(driver, test);
		SearchVisitorsDiscrepancyReportPage VisitorDiscrepancyReport	=new SearchVisitorsDiscrepancyReportPage(driver, test);
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
					saarchReport.click_VisitorDiscrepancyReport();
					VisitorDiscrepancyReport.searchParameters(SBUCode, VisitRequestFrom, VisitRequestTo, RequestID, VisitorName, VisitorCategory,
							site, SortBy, Direction);
					Wait.waitfor(3);
					VisitorDiscrepancyReport.clickSearchbutton();
					Wait.waitfor(3);
					
					result.titleIsDisplayedVisitorDiscrepancy();
					
					Wait.waitfor(3);
					homePage.returnPage();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			//homePage.returnPage();
			testFail();
		}
	}
}

