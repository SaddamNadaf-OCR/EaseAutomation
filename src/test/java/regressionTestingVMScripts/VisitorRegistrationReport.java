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
import vmsClasses.SearchVisitorRegistrationReportPage;
import vmsClasses.SearchVisitorRequestPage;
public class VisitorRegistrationReport extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("VisitorRegistrationReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void visitorRegistrationReport(String TestCases, String RunMode, String SBU,String SBUCode,String RequestID,String FirstName, String LastName,
			String EmailID ,String Phone,String DateRegisteredFrom, String DateRegisteredTo, String LastUpdatedFrom,String LastUpdatedTo,
			String SortBy,String Direction) 
	{
		
		HomePage						homePage  = new HomePage(driver, test);	
		SearchVisitorRequestPage		searchVR  = new SearchVisitorRequestPage(driver, test);
		SearchReportsPage				searchReport =new SearchReportsPage(driver, test);
		SearchVisitorRegistrationReportPage RegisteredVisitor = new SearchVisitorRegistrationReportPage(driver, test);
		ResultReportPage				result	= new ResultReportPage(driver, test);
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}
			else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Reports();
					searchReport.click_VisitorRegistration();
					RegisteredVisitor.searchParameters(SBUCode, RequestID, FirstName, LastName, EmailID, Phone, DateRegisteredFrom, DateRegisteredTo, LastUpdatedFrom, LastUpdatedTo, SortBy, Direction);
					RegisteredVisitor.clickSearchbutton();
					result.titleIsDisplayedVisitorRegistration();
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


