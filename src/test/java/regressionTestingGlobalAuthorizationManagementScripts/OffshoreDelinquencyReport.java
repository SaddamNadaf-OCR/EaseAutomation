package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.OffshoreDelinquencyReportPage;
import authorizationManagementClasses.SearchOffshoreDelinquencyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class OffshoreDelinquencyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("OffshoreDelinquencyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void offshoreDelinquencyReport(String TestCases, String RunMode, String SBU, String SBUCode, String TransactionID, 
			String AuthorizationType, String AuthorizationNo, String Owner, String Program, String Segment, String Site, 
			String ProductLine, String ProductFamily, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchOffshoreDelinquencyReportPage search = new SearchOffshoreDelinquencyReportPage(driver, test);
		OffshoreDelinquencyReportPage report = new OffshoreDelinquencyReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_OffshoreProcurementDelinquencyReports();
					search.searchByAllParameters(SBUCode, TransactionID, AuthorizationType, AuthorizationNo, Owner, Program, 
							Segment, Site, ProductLine, ProductFamily, SortBy, direction);
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