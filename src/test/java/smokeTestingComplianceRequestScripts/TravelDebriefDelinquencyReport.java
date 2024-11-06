package smokeTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ResultSearchTravelDebriefDelinquencyReportPage;
import crsClasses.TravelDebriefDelinquencyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class TravelDebriefDelinquencyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("TravelDebriefDelinReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void travelDebriefDelinquencyReport(String TestCases, String RunMode, String SBUCode, String ForeignTravelID, 
			String TravelDateFrom, String TravelDateTo, String RequesterName, String ExportReviewer, String SecurityReviewer, 
			String ManagerReviewer, String DirectorReviewer, String Country, String Company, String CitiesVisiting, 
			String DepartureCity, String AuthNoAgreeNo, String ActivityType, String AuthorizationType, String TravelSecurityName, 
			String ManagerName, String Trip, String InitiatedDateFrom, String InitiatedDateTo, String SortBy, 
			String PrimaryPurpose, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		TravelDebriefDelinquencyReportPage search = new TravelDebriefDelinquencyReportPage(driver, test);
		ResultSearchTravelDebriefDelinquencyReportPage report = new ResultSearchTravelDebriefDelinquencyReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.travelDebriefDelinquencyReport();
					search.searchByParameters(SBUCode, ForeignTravelID, TravelDateFrom, TravelDateTo, RequesterName, ExportReviewer, 
							SecurityReviewer, ManagerReviewer, DirectorReviewer, Country, Company, CitiesVisiting, DepartureCity, 
							AuthNoAgreeNo, ActivityType, AuthorizationType, TravelSecurityName, ManagerName, Trip, InitiatedDateFrom,
							InitiatedDateTo, SortBy, PrimaryPurpose, Direction);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					Wait.waitfor(3);
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
