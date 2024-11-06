package vmsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.VisitorSummaryReportByCitizenshipPage;
import vmsClasses.ResultReportPage;
import vmsClasses.SearchReportsPage;
import vmsClasses.SearchVisitorRequestPage;

public class SearchMetrixByCitizenship extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchMetrixByCitizenship", excel);
	}
	
	@Test(dataProvider="getData")
	
		public void searchMetrixByCitizenship(String TestCases, String RunMode, String SBU,String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
				String VisitRequestTo, String VisitorCategory, String site,
				String FromDate, String ToDate,  String SFromDate, String SToDate, String AFromDate, String AToDate)
		{
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				saarchReport =new SearchReportsPage(driver, test);
		VisitorSummaryReportByCitizenshipPage   metrixByCitizenship =new VisitorSummaryReportByCitizenshipPage(driver, test);
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
					saarchReport.click_MetricsReport();
					saarchReport.click_ByCitizenship();
					metrixByCitizenship.searchParameters(SBUCode, RequestID, VisitorName, VisitRequestFrom,
							VisitRequestTo, VisitorCategory,  site, FromDate, ToDate, SToDate, SFromDate, AFromDate, AToDate);
					
					metrixByCitizenship.clickSearchbutton();
					Wait.waitfor(10);
					result.titleIsDisplayedByCitizenship();
					
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
