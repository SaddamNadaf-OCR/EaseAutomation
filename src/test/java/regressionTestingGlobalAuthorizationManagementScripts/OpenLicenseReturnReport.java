package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.OpenLicenseReturnReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class OpenLicenseReturnReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("OpenLicenseReturnReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void openLicenseReturnReport(String TestCases, String RunMode, String SBU, String SBUCode, String TransactionDateFrom, 
			String TransactionDateTo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		OpenLicenseReturnReportPage search = new OpenLicenseReturnReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_OpenlicenceReturnReports();
					search.searchByAllParameters(SBUCode, TransactionDateFrom, TransactionDateTo);
					search.excelsheet();
					Wait.waitfor(5);
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