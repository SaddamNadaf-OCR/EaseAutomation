package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ProvisoAcknowledgmentReportPage;
import authorizationManagementClasses.SearchProvisoAcknowledgmentReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LetterOfAssuranceDiscrepancyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("LOADiscrepancyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void letterOfAssuranceDiscrepancyReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String LicenseNo, String TransactionID, String NotificationDateFrom, String NotificationDateTo, 
			String AuthorizationOwner, String LicensePOC, String ProductLine, String ProductFamily, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchProvisoAcknowledgmentReportPage search = new SearchProvisoAcknowledgmentReportPage(driver, test);
		ProvisoAcknowledgmentReportPage report = new ProvisoAcknowledgmentReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_DOCProvisoAcknowledgmentReports();
					search.searchByParameters(SBUCode, LicenseNo, TransactionID, NotificationDateFrom, 
							NotificationDateTo, AuthorizationOwner, LicensePOC, ProductLine, ProductFamily, SortBy, Direction);
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
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