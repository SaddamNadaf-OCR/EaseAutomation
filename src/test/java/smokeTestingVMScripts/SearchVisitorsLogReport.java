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
import vmsClasses.SearchVisitorsLogReportPage;

public class SearchVisitorsLogReport extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchVisitorsLogReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchVisitorsLogReport(String TestCases, String RunMode, String SBU,String SBUCode,String RequestID,String VisitorName, String VisitPurpose,
			String ClassificationLevel ,String TypeOfPerson,String VisitorCategory, String site,String AFromDate,String AToDate, String SToDate, String SFromDate,
			String SortBy,String Direction) {
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				searchReport =new SearchReportsPage(driver, test);
		SearchVisitorsLogReportPage    VisitorLog  =new 	SearchVisitorsLogReportPage(driver, test);
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
					searchReport.click_VisitorLogReport();
					VisitorLog.searchParameters(SBUCode, RequestID, VisitorName, VisitPurpose, ClassificationLevel,
							TypeOfPerson, VisitorCategory, site, AFromDate, AToDate, SToDate, SFromDate, SortBy, Direction);
					Wait.waitfor(3);
					VisitorLog.clickSearchbutton();
					result.titleIsDisplayedVisitorLog();
					Wait.waitfor(3);
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


