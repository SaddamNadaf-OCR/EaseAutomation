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
import vmsClasses.SearchVisitorComprehensiveReportPage;
import vmsClasses.SearchVisitorRequestPage;

public class SearchVisitorComprehensiveReport extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("VisitorComprehensiveReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchVisitorComprehensiveReport(String TestCases, String RunMode, String SBU,String SBUCode,String RequestID,String VisitorName,String VisitRequestFrom ,String VisitRequestTo ,String VisitPurpose,
			String ClassificationLevel ,String TypeOfPerson,String VisitorCategory, String site,String FromDate,String ToDate,String SToDate, String SFromDate,
			String AFromDate,String AToDate,String SortBy,String Direction) {
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				saarchReport =new SearchReportsPage(driver, test);
		SearchVisitorComprehensiveReportPage VisitorComprehensiveReport	=new SearchVisitorComprehensiveReportPage(driver, test);
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
					saarchReport.click_VisitorComprehensiveReport();
					VisitorComprehensiveReport.searchParameters(SBUCode, RequestID, VisitorName, VisitRequestFrom,
							VisitRequestTo, VisitPurpose, ClassificationLevel, TypeOfPerson, VisitorCategory,
							site, FromDate, ToDate, SToDate, SFromDate, AFromDate, AToDate, SortBy, Direction);
					VisitorComprehensiveReport.clickSearchbutton();
					Wait.waitfor(3);
					result.titleIsDisplayedVisitorComprehensive();
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
