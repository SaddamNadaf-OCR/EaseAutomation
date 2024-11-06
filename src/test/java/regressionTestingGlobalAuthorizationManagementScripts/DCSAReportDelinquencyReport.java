package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.DCSAReportDelinquencyReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchDCSAReportDelinquencyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class DCSAReportDelinquencyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("DCSAReportDelinquencyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void dCSAReportDelinquencyReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String AuthorizationType, String AgreementNo, String TransactionID, String AthorizationOwner, 
			String LicensePOC, String ForeignParty, String USGAppDateFrom, String USGAppDateTo, String ClassifiedLevel, 
			String ProductLine, String ProductLFamily, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchDCSAReportDelinquencyReportPage search = new SearchDCSAReportDelinquencyReportPage(driver, test);
		DCSAReportDelinquencyReportPage report = new DCSAReportDelinquencyReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_DSSReportDelinquencyReports();
					search.searchByAllParameters(SBUCode, AuthorizationType, AgreementNo, TransactionID, 
							AthorizationOwner, LicensePOC, ForeignParty, USGAppDateFrom, USGAppDateTo, ClassifiedLevel, 
							ProductLine, ProductLFamily, SortBy, direction);
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