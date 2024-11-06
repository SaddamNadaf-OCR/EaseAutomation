package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationCloseOutPage;
import authorizationManagementClasses.SearchAuthorizationCloseOutPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class AuthorizationCloseOutSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthoCloseOutSerachResult", excel);
	}
	
	@Test(dataProvider="getData")
	public void authCloseOut(String TestCases,String RunMode, String SBU, String sbu, String closeOutID, String transactionID,
			String AuthorizationNo, String ActivityType, String AuthorizationType, String Status, String ExpiryDateFrom, 
			String ExpiryDateTo, String USGSubmittedDateFrom, String USGSubmittedDateTo, String LicenseClosure, String Owner,
			String Manager, String Requester, String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchAuthorizationCloseOutPage search = new SearchAuthorizationCloseOutPage(driver, test);
		ResultAuthorizationCloseOutPage result = new ResultAuthorizationCloseOutPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_on_AutorizationCloseOut();
					search.searchByParameters(sbu, closeOutID, transactionID, AuthorizationNo, ActivityType, AuthorizationType,
							Status, ExpiryDateFrom, ExpiryDateTo, USGSubmittedDateFrom, USGSubmittedDateTo, LicenseClosure, Owner,
							Manager, Requester, SortBy, Direction);
					search.search();
					result.titleIsDisplayed();
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
