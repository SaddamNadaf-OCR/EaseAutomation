package smokeTestUserScripts;
/* 
 * Module : User
 * Author  : Afsha Hamid
 * created date : April 2024
 * Descriptions : Create View/User 
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
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


public class createUserProfile extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("createUserProfile", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateUserProfile(String Testcase, String RunMode, String SBU ,String UserId, String firstname, String lastname, 
			String UserTitle, String UserGroup, String PrimarySBU, String Dateformat, String Numberformat, String Email , String Password) throws Exception {
		//Object Creation
	    HomePage homePage=new HomePage(driver,test);
		ToolsPage toolPage=new ToolsPage(driver,test);
		SearchUserProfilePage searchPage=new SearchUserProfilePage(driver,test);
		CreateNewUserProfilePage createUserPage=new CreateNewUserProfilePage(driver,test);
		
		
		
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
					searchPage.click_addUserProfile();
					Wait.waitfor(5);
					createUserPage.AddNewUser(UserId, firstname, lastname, UserTitle, UserGroup,PrimarySBU, Dateformat, Numberformat, Email);
					Wait.waitfor(3);
					createUserPage.click_Save();
					Wait.waitfor(5);
					createUserPage.AddAllModulelist();
					Wait.waitfor(5);
					createUserPage.SaveModulelist();
					Wait.waitfor(5);
					createUserPage.AddAllPermissionList();
					Wait.waitfor(5);
					createUserPage.SavePermissionlist();
					Wait.waitfor(5);
					createUserPage.EnterPassword(Password);
					Wait.waitfor(4);
					/*createUserPage.click_Save();
					Wait.waitfor(3);*/
					createUserPage.click_SaveReturn();
					Wait.waitfor(2);
				
					
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

	
	