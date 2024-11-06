package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.OpenForeignTravelRequestsReportPage;
import crsClasses.ResultOpenForeignTravelRequestsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class OpenForeignTravelRequestsReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("OpenForeignTravelRequestsReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void openForeignTravelRequestsReport(String TestCases, String RunMode, String SBUCode, String ForeignTravelID, 
			String TravelDateFrom, String TravelDateTo, String RequesterName, String ExportReviewer, String SecurityReviewer, 
			String ManagerReviewer, String DirectorReviewer, String Country, String Company, String CitiesVisiting, 
			String DepartureCity, String AuthNoAgreeNo, String ActivityType, String AuthorizationType, String TravelSecurityName, 
			String ManagerName, String Trip, String InitiatedDateFrom, String InitiatedDateTo, String SortBy, 
			String PrimaryPurpose, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		OpenForeignTravelRequestsReportPage search = new OpenForeignTravelRequestsReportPage(driver, test);
		ResultOpenForeignTravelRequestsReportPage report = new ResultOpenForeignTravelRequestsReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.openForeignTravelRequests();
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
