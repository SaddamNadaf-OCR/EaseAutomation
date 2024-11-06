package regressionTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import crsClasses.ForeignTravelSummaryReportPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelSummaryReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ForeignTravelSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ForeignTravelSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void foreignTravelSummaryReport(String TestCases, String RunMode, String SBUCode, String ForeignTravelID, 
			String Status, String Determination, String RequesterName, String ExportReviewer, String SecurityReviewer, 
			String ManagerReviewer, String DirectorReviewer, String InitialDateFrom, String InitialDateTo, String FinalActionDateFrom, 
			String FinalActionDateTo, String TravelDateFrom, String TravelDateTo, String Segment, String Site, String ProductLine, 
			String ProductFamily, String Program, String Country, String CitiesVisiting, String DepartureCity, String Company, 
			String ExportAuthority, String SortBy, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		ForeignTravelSummaryReportPage search = new ForeignTravelSummaryReportPage(driver, test);
		ResultForeignTravelSummaryReportPage report = new ResultForeignTravelSummaryReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.foreignTravelSummaryReport();
					search.searchByParameters(SBUCode, ForeignTravelID, Status, Determination, RequesterName, ExportReviewer, 
							SecurityReviewer, ManagerReviewer, DirectorReviewer, InitialDateFrom, InitialDateTo, FinalActionDateFrom, 
							FinalActionDateTo, TravelDateFrom, TravelDateTo, Segment, Site, ProductLine, ProductFamily, Program, 
							Country, CitiesVisiting, DepartureCity, Company, ExportAuthority, SortBy, Direction);
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
