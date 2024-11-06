package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultCongressionalNotificationPage;
import authorizationManagementClasses.SearchCongressionalNotificationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CongressionalNotificationSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CongNotificationalSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void ds4071TechData(String TestCases,String RunMode, String SBU, String Sbu, String referenceNo, 
			String congressionalNo, String CaseNo, String Status, String Submitdate, String Segment, 
			String Commodity, String Country, String Value, String DateOfHill, String CreatedBy, String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchCongressionalNotificationPage search = new SearchCongressionalNotificationPage(driver, test);
		ResultCongressionalNotificationPage result = new ResultCongressionalNotificationPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonCongNotification();
					search.searchByParameters(Sbu, referenceNo, congressionalNo, CaseNo, Status, Submitdate, Segment, 
							Commodity, Country, Value, DateOfHill, CreatedBy, SortBy, Direction);
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
