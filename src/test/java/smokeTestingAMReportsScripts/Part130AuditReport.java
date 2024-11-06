package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.PART130AUDITREPORTPage;
import authorizationManagementClasses.SearchPart130AuditReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Part130AuditReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("Part130AuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void part130AuditReport(String TestCases, String RunMode, String SBU, String SBUCode, String Part130RefID, 
			String POA, String ContactNo, String AgreementNo, String SubmittedDateFrom, String SubmittedDateTo, 
			String Programme, String Segment, String Site, String Department, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchPart130AuditReportPage search = new SearchPart130AuditReportPage(driver, test);
		PART130AUDITREPORTPage report = new PART130AUDITREPORTPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_Part_130Reports();
					search.searchByAllParameters(SBUCode, Part130RefID, POA, ContactNo, AgreementNo, SubmittedDateFrom, 
							SubmittedDateTo, Programme, Segment, Site, Department, SortBy, Direction);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					Wait.waitfor(3);
					homePage.returnTomoduleSelection();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnTomoduleSelection();
			testFail();
		}
	}
}