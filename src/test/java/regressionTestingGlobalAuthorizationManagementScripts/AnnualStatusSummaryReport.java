package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AnnualStatusSummaryReport2023Page;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAnnualStatusSummaryReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AnnualStatusSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AnnualStatusSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualStatusDelinquencyReportScripts(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String AgreementNumber, String FormType, String Status, String ExpirationdateFrom, 
			String ExpirationdateTo, String Programme, String Segment, String ProductLine, String ProductFamily, 
			String reportYear, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAnnualStatusSummaryReportPage search = new SearchAnnualStatusSummaryReportPage(driver, test);
		AnnualStatusSummaryReport2023Page report = new AnnualStatusSummaryReport2023Page(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AnnualStatusSummaryReport();
					search.searchBYParaeters(SBUCode, TransactionID, AgreementNumber, FormType, Status, ExpirationdateFrom, 
							ExpirationdateTo, Programme, Segment, ProductLine, ProductFamily, reportYear, SortBy, direction);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					homePage.returnTomoduleSelection();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnTomoduleSelection();
			testFail();
		}
	}
}
