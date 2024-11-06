package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.ExportConsigneeByCountryReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchExportConsigneeByCountryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportConsigneeByCountry extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ExportConsigneeByCountry", excel);
	}
	
	@Test(dataProvider="getData")
	public void exportConsigneeByCountry(String TestCases, String RunMode, String SBU, String SBUCode, String LicenseNo, 
			String ExpiryDateFrom, String ExpiryDateTo, String LicenseType, String ProductClass, String Purpose, 
			String Country, String UltimateConsignee, String CreatedBy) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchExportConsigneeByCountryPage search = new SearchExportConsigneeByCountryPage(driver, test);
		ExportConsigneeByCountryReportPage report = new ExportConsigneeByCountryReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ExportConsigneebyCountryReports();
					search.searchByParameters(SBUCode, LicenseNo, ExpiryDateFrom, ExpiryDateTo, LicenseType, 
							ProductClass, Purpose, Country, UltimateConsignee, CreatedBy);
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