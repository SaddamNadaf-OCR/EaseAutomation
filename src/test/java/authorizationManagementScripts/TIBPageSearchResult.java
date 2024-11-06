package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultTIBPage;
import authorizationManagementClasses.SearchTIBPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class TIBPageSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("TIBSearchResult", excel);
	}
	
	@Test(dataProvider="getData")
	public void tibPageSearch(String TestCases,String RunMode, String SBU, String TIBNumber, String TIBIIssuedate, 
			String packegingNumber, String ExpirationDate, String sbu, String CreatedBy, String sortBy, String direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchTIBPage search = new SearchTIBPage(driver, test);
		ResultTIBPage result = new ResultTIBPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_on_TIB();
					search.searchByParameters(TIBNumber, TIBIIssuedate, packegingNumber, ExpirationDate, sbu, CreatedBy, sortBy, direction);
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
