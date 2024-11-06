package smokeTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import crsClasses.HomePageCRs;
import crsClasses.ResultEXPORTAUDITREPORTPage;
import crsClasses.SearchExportImportAuditReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportAuditReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ExportAuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualStatusDelinquencyReportScripts(String TestCases, String RunMode, String RequestID, 
			String ExportFocalPoint, String TechnicalFocalPoint, String ReasonForReturn, String SortBy, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		SearchExportImportAuditReportPage search = new SearchExportImportAuditReportPage(driver, test);
		ResultEXPORTAUDITREPORTPage report = new ResultEXPORTAUDITREPORTPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.exportAuditRequest();
					search.searchByParameters(RequestID, ExportFocalPoint, TechnicalFocalPoint, ReasonForReturn, SortBy, Direction);
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
