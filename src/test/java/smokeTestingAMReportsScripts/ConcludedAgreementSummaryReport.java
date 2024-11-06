package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.ConcludedAgreementSummaryReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchConcludedAgreementSummaryReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ConcludedAgreementSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ConcludedAgreementSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualStatusDelinquencyReportScripts(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String AgreementNumber, String FormType, String Status, String Programme, String Segment, 
			String ProductLine, String ProductFamily, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchConcludedAgreementSummaryReportPage search = new SearchConcludedAgreementSummaryReportPage(driver, test);
		ConcludedAgreementSummaryReportPage report = new ConcludedAgreementSummaryReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ConcludedAgreementSummaryReports();
					search.searchBYParameters(SBUCode, TransactionID, AgreementNumber, FormType, Status, Programme, Segment, 
							ProductLine, ProductFamily, SortBy, direction);
					search.search();
					Wait.waitfor(3);
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
