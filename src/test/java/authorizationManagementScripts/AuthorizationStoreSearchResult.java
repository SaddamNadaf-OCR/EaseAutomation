package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationStorePage;
import authorizationManagementClasses.SearchAuthorizationStorePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationStoreSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizationStoreSeachR", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationStore(String TestCases,String RunMode, String SBU, String sbu, String type, 
			String TransactionID, String authorizationNo, String caseNo, String status, String Segment, 
			String Program, String ProductLine, String ProductFamily, String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchAuthorizationStorePage search = new SearchAuthorizationStorePage(driver, test);
		ResultAuthorizationStorePage result = new ResultAuthorizationStorePage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_on_AuthorizationStore();
					search.searchBYParameters(sbu, type, TransactionID, authorizationNo, caseNo, status,
							Segment, Program, ProductLine, ProductFamily, SortBy, Direction);
					search.search();
					result.titleIsDisplayed();
					Wait.waitfor(3);
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
