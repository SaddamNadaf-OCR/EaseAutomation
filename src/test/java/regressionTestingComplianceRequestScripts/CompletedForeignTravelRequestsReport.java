package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Dec 2023
 * Descriptions : Search Complete Foreign Travel Request Report
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.CompletedForeignTravelRequestsReportPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultCompletedForeignTravelRequestsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CompletedForeignTravelRequestsReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CompletedForeTraReqRep", excel);
	}
	
	@Test(dataProvider="getData")
	public void completedForeignTravelRequestsReport(String TestCases, String RunMode, String SBUCode, String ForeignTravelID, 
			String TravelDateFrom, String TravelDateTo, String RequesterName, String ExportReviewer, String SecurityReviewer, 
			String ManagerReviewer, String DirectorReviewer, String Country, String Company, String CitiesVisiting, 
			String DepartureCity, String AuthNoAgreeNo, String ActivityType, String AuthorizationType, String TravelSecurityName, 
			String ManagerName, String Trip, String InitiatedDateFrom, String InitiatedDateTo, String SortBy, 
			String PrimaryPurpose, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		CompletedForeignTravelRequestsReportPage search = new CompletedForeignTravelRequestsReportPage(driver, test);
		ResultCompletedForeignTravelRequestsReportPage report = new ResultCompletedForeignTravelRequestsReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.completedForeignTravelRequests();
					search.searchByParameters(SBUCode, ForeignTravelID, TravelDateFrom, TravelDateTo, RequesterName, 
							ExportReviewer, SecurityReviewer, ManagerReviewer, DirectorReviewer, Country, Company, 
							CitiesVisiting, DepartureCity, AuthNoAgreeNo, ActivityType, AuthorizationType, TravelSecurityName, 
							ManagerName, Trip, InitiatedDateFrom, InitiatedDateTo, SortBy, PrimaryPurpose, Direction);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					homePage.returnToCRPage();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnToCRPage();
			testFail();
		}
	}
}
