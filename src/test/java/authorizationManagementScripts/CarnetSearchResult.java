package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultCarnetPage;
import authorizationManagementClasses.SearchCarnetPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CarnetSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CarnetSearchResult", excel);
	}
	
	@Test(dataProvider="getData")
	public void carnetSearchResult(String TestCases,String RunMode, String SBU, String carnetNo, String issuedate, 
			String expirydate, String sbu, String CreatedBy, String sortBy, String direction, String CarnetItemNo, 
			String InitialQuantity, String InitialValue, String BalanceQuantity, String BalanceValue, String sbuCode, 
			String CreatedBy1, String sortBy1, String direction1) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchCarnetPage search = new SearchCarnetPage(driver, test);
		ResultCarnetPage result = new ResultCarnetPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_on_Carnet();
					search.searchByParameters(carnetNo, issuedate, expirydate, sbu, CreatedBy, sortBy, direction,
							CarnetItemNo, InitialQuantity, InitialValue, BalanceQuantity, BalanceValue, sbuCode, CreatedBy1, sortBy1, direction1);
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
