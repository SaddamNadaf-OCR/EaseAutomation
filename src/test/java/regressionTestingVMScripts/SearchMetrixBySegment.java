/* 
 * Module : VMS
 * Author  : Ajit Sharma
 * created date : May 2024
 * Descriptions :SearchMetrixBySegment
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */

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
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorSummaryReportBySegmentPage;


public class SearchMetrixBySegment extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchMetrixBySegment", excel);
	}
	
	@Test(dataProvider="getData")
	
		public void searchMetrixBySegment(String TestCases, String RunMode, String SBU,String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
				String VisitRequestTo, String VisitorCategory, String site,
				String FromDate, String ToDate,  String SFromDate, String SToDate, String AFromDate, String AToDate)
		{
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				saarchReport =new SearchReportsPage(driver, test);
		VisitorSummaryReportBySegmentPage   metrixBySegment =new VisitorSummaryReportBySegmentPage(driver, test);
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
					Wait.waitfor(3);
					saarchReport.click_BySegment();
					metrixBySegment.searchParameters(SBUCode, RequestID, VisitorName, VisitRequestFrom,
							VisitRequestTo, VisitorCategory,  site, FromDate, ToDate, SToDate, SFromDate, AFromDate, AToDate);
					
					metrixBySegment.clickSearchbutton();
					Wait.waitfor(10);
					result.titleIsDisplayedBySegment();
					
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
