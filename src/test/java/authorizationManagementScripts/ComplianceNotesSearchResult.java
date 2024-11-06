package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultComplianceNotesPage;
import authorizationManagementClasses.SearchComplianceNotesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ComplianceNotesSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ComplianceNotesSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationReview(String TestCases,String RunMode, String SBU, String Sbu, String ContractType,
			String notesID, String referanceNo, String Purpose, String AuthorizationType, String AuthorizationNo, String POC,
			String USAgency, String Startdate, String Enddate, String BroeringActivity, String SortBy, String Direction,
			String IssueSummary, String Description) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchComplianceNotesPage search = new SearchComplianceNotesPage(driver, test);
		ResultComplianceNotesPage result = new ResultComplianceNotesPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonComplianceNotes();
					search.searchByParameters(Sbu, ContractType, notesID, referanceNo, Purpose, AuthorizationType, AuthorizationNo, POC, 
							USAgency, Startdate, Enddate, BroeringActivity, SortBy, Direction, IssueSummary, Description);
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
