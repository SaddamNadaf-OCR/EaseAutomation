package smokeTestUserScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import userClasses.CreateNewUserProfilePage;
import userClasses.HomePage;
import userClasses.SearchUserProfilePage;
import userClasses.ToolsPage;
import utilities.Utility;
import utilities.Wait;

public class searchUserProfile extends  SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("searchUserProfile", excel);
	}
	
	@Test(dataProvider = "getData")
	public void SearchUserProfile(String Testcase, String RunMode, String SBU ,String UserId, String firstname, String lastname, String EmailId, String UserGroup, String SBUcode) throws Exception {
		//Object Creation
	    HomePage homePage=new HomePage(driver,test);
		ToolsPage toolPage=new ToolsPage(driver,test);
		SearchUserProfilePage searchPage=new SearchUserProfilePage(driver,test);
		
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_Tools();
					toolPage.click_ExtendUser();
					Wait.waitfor(5);
					toolPage.click_createUser();
					Wait.waitfor(5);	
//					searchPage.type_Combination(UserId, firstname, lastname, EmailId, UserGroup, SBUcode);
					Wait.waitfor(5);
					searchPage.click_search();
					Wait.waitfor(5);
				
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

}

	
