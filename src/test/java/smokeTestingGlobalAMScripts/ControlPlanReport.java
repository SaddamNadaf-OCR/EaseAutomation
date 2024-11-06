package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.ControlPlanReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchControlPlanPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ControlPlanReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ControlPlanReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void controlPlanReport(String TestCases, String RunMode, String SBU, String SBUCode, String CPType, 
			String BusinessSystem, String AuthorizationNo, String AuthorizationType, String CPID, String Trainer,
			String Trainee, String CPDescription, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchControlPlanPage search = new SearchControlPlanPage(driver, test);
		ControlPlanReportPage report = new ControlPlanReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ControlPlanReports();
					search.searchByParameters(SBUCode, CPType, BusinessSystem, AuthorizationNo, AuthorizationType, 
							CPID, Trainer, Trainee, CPDescription, SortBy, Direction);
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