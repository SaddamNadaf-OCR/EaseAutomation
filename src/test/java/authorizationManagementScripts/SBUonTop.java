package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateComplianceNotesPage;
import authorizationManagementClasses.CreateNewAuthorisationPage;
import authorizationManagementClasses.CreateNewAuthorizationActivityPage;
import authorizationManagementClasses.CreateNewCarnetPage;
import authorizationManagementClasses.CreateNewCongressionalNotificationPage;
import authorizationManagementClasses.DS_4071TechDataUSGReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorisationPage;
import authorizationManagementClasses.SearchAuthorizationActivityPage;
import authorizationManagementClasses.SearchCongressionalNotificationPage;
import authorizationManagementClasses.SearchPart130ReportsPage;
import authorizationManagementClasses.TempAuthorizationCloseOUTPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SBUonTop extends SeleniumTestBase{
	
	@DataProvider
	public Object [][] getData(){
		return Utility.getData("SBUonTOP", excel);
	}
	
	@Test(dataProvider="getData")
	public void sbuonTOP(String TestCases,String RunMode, String SBU) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchAuthorisationPage searchAuth= new SearchAuthorisationPage(driver, test);
		CreateNewAuthorisationPage createNewAuth = new CreateNewAuthorisationPage(driver, test);
		SearchAuthorizationActivityPage searchAuthAct = new SearchAuthorizationActivityPage(driver, test);
		CreateNewAuthorizationActivityPage createAuth= new CreateNewAuthorizationActivityPage(driver, test);
		TempAuthorizationCloseOUTPage tempClose = new TempAuthorizationCloseOUTPage(driver, test);
		SearchPart130ReportsPage searchPart130 = new SearchPart130ReportsPage(driver, test);
		SearchCongressionalNotificationPage searchCong = new SearchCongressionalNotificationPage(driver, test);
		CreateNewCongressionalNotificationPage createCong = new CreateNewCongressionalNotificationPage(driver, test);
		CreateComplianceNotesPage createCompl=new CreateComplianceNotesPage(driver, test);
		DS_4071TechDataUSGReportPage ds4071 = new DS_4071TechDataUSGReportPage(driver, test);
		CreateNewCarnetPage createCarnet=new CreateNewCarnetPage(driver, test);
		
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonAddViewEdit();
					searchAuth.countryFirstValue();
					homePage.returnTomoduleSelection();
					homePage.clickonAddViewEdit();
					searchAuth.addAuthorization();
					createNewAuth.countryFirstValue();
					homePage.returnTomoduleSelection();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		}
		catch(Exception e) {
			testFail();
			homePage.returnTomoduleSelection();
			e.printStackTrace();
		}
	}
}