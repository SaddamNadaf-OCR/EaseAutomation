package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CountriesReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class COUNTRYLIST extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("COUNTRYLIST", excel);
	}
	
	@Test(dataProvider="getData")
	public void authOwnerDiscrepancyReport(String TestCases, String RunMode, String SBU) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		CountriesReportPage report = new CountriesReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_CountriesReports();
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