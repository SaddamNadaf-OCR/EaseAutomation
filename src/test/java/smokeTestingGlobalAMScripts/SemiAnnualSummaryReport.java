package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchSemiAnnualSummaryReportPage;
import authorizationManagementClasses.SemiAnnualSummaryReport2023Page;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SemiAnnualSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SemiAnnualSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void semiAnnualSummaryReport(String TestCases, String RunMode, String SBU, String SBUCode, String TransactionID, 
			String AgreementNumber, String FormType, String Status, String Programme, String Segment, String ProductLine, 
			String ProductFamily, String reportYear, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchSemiAnnualSummaryReportPage search = new SearchSemiAnnualSummaryReportPage(driver, test);
		SemiAnnualSummaryReport2023Page report = new SemiAnnualSummaryReport2023Page(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_SemiAnnualSummaryReports();
					search.searchByAllParameters(SBUCode, TransactionID, AgreementNumber, FormType, Status,
							Programme, Segment, ProductLine, ProductFamily, reportYear, SortBy, direction);
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