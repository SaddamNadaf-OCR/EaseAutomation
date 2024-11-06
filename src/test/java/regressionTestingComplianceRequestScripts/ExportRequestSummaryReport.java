package regressionTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import crsClasses.ExportRequestSummaryReportPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultExportRequestSummaryReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ExportReqSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void exportRequestSummaryReport(String TestCases, String RunMode, String SBUCode, String Purpose, 
			String RequestID, String AuthorizationID, String Status, String Determination, String RequesterName, 
			String ExportFocalPoint, String Department, String RequestType, String RequestDateFrom, String RequestDateTo, 
			String FinalActionDateFrom, String FinalActionDateTo, String Segment, String Site, String ProductLine, 
			String ProductFamily, String Program, String Country, String Consignee, String ExportAuthority, String ReasonForReturn, 
			String TachnicalFocalPoint, String SortBy, String Direction, String SubmitDateFrom, String SubmitDateTo, String ProductDecription) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		ExportRequestSummaryReportPage search = new ExportRequestSummaryReportPage(driver, test);
		ResultExportRequestSummaryReportPage report = new ResultExportRequestSummaryReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.exportRequestSummaryReport();
					search.searchByParameters(SBUCode, Purpose, RequestID, AuthorizationID, Status, Determination, RequesterName, 
							ExportFocalPoint, Department, RequestType, RequestDateFrom, RequestDateTo, FinalActionDateFrom, 
							FinalActionDateTo, Segment, Site, ProductLine, ProductFamily, Program, Country, Consignee, ExportAuthority, 
							ReasonForReturn, TachnicalFocalPoint, SortBy, Direction, SubmitDateFrom, SubmitDateTo, ProductDecription);
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
