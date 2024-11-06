package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationReviewPage;
import authorizationManagementClasses.SearchAuthorizationReviewPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationReviewSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthOReviewSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationReview(String TestCases,String RunMode, String SBU, String sbu, String activityType, 
			String authorizationType, String transactionID, String authorizationNo, String caseNo, String AuthoOwner,
			String CreatedBy, String PrepairedBy, String IssueDateFrom, String IssueDateTo, String AuthoExpiry, 
			String ExpiryDateFrom, String ExpiryDateTo, String Status, String InternalStatus, String ApproverName,
			String Segment, String Program, String ProductLine, String ProductFamily, String EmpoweredOfficial, 
			String ECCN_USML, String CPID, String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchAuthorizationReviewPage search = new SearchAuthorizationReviewPage(driver, test);
		ResultAuthorizationReviewPage result = new ResultAuthorizationReviewPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_on_AutorizationReview();
					search.searchBYParameters(sbu, activityType, authorizationType, transactionID, authorizationNo, caseNo, 
							AuthoOwner, CreatedBy, PrepairedBy, IssueDateFrom, IssueDateTo, AuthoExpiry, ExpiryDateFrom, 
							ExpiryDateTo, Status, InternalStatus, ApproverName, Segment, Program, 
							ProductLine, ProductFamily, EmpoweredOfficial, ECCN_USML, CPID, SortBy, Direction);
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
