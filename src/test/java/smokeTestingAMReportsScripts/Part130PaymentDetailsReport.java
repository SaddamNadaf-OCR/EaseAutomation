package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.PART130PAYMENTDETAILSPage;
import authorizationManagementClasses.SearchPart130PaymentDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Part130PaymentDetailsReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("Part130PaymentDetailsReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void part130PaymentDetailsReport(String TestCases, String RunMode, String SBU, String SBUCode, String Part130RefID, 
			String Status, String POA, String ContactNo, String Recipient, String AgreementNo, String Country, String ReportYes, 
			String ReportNo, String SubmittedDateFrom, String SubmittedDateTo, String Programme, String Segment, String Site, 
			String Department, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchPart130PaymentDetailsPage search = new SearchPart130PaymentDetailsPage(driver, test);
		PART130PAYMENTDETAILSPage report = new PART130PAYMENTDETAILSPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_Part130PaymentDetailsReports();
					search.searchByAllParameters(SBUCode, Part130RefID, Status, POA, ContactNo, Recipient, AgreementNo, 
							Country, ReportYes, ReportNo, SubmittedDateFrom, SubmittedDateTo, Programme, Segment, Site, 
							Department, SortBy, Direction);
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