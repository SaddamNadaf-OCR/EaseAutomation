package RegressionTestingUserScripts;
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
import userClasses.ModifyPortalInterfacePage;
import userClasses.SearchUserProfilePage;
import userClasses.ToolsPage;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.LoginPage;


public class createUserProfile extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("createUserProfile", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateUserProfile(String Testcase, String RunMode, String SBU ,String UserId, String firstname, String lastname, 
			String UserTitle, String UserGroup, String PrimarySBU, String Dateformat, String Numberformat, String Email ,String SBUname,
			String Modulename,String InterfaceAvailablelist, String Password) throws Exception {
		//Object Creation
	    HomePage homePage=new HomePage(driver,test);
		ToolsPage toolPage=new ToolsPage(driver,test);
		SearchUserProfilePage searchPage=new SearchUserProfilePage(driver,test);
		CreateNewUserProfilePage createUserPage=new CreateNewUserProfilePage(driver,test);
		
		ModifyPortalInterfacePage modifyprivilegesPage=new ModifyPortalInterfacePage(driver,test);
		LoginPage loginpagex= new LoginPage(driver,test);
		
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
				    //homePage.moveTo_SBUSelection(SBU);
					homePage.click_Tools();
					toolPage.click_ExtendUser();
					Wait.waitfor(5);
					toolPage.click_createUser();
					Wait.waitfor(5);	
					searchPage.click_addUserProfile();
					Wait.waitfor(5);
					createUserPage.AddNewUser(UserId, firstname, lastname, UserTitle, UserGroup, PrimarySBU, Dateformat, Numberformat, Email);
					Wait.waitfor(3);
					createUserPage.click_Save();
					Wait.waitfor(5);
					createUserPage.selectVMUSERTYPE();
					Wait.waitfor(4);
                  	createUserPage.AddAllModulelist();
					Wait.waitfor(5);
					createUserPage.SaveModulelist();
					createUserPage.Click_modifyportalinterface();
					modifyprivilegesPage.MPtitleIsDisplayed();
					Wait.waitfor(2);
					modifyprivilegesPage.click_modulelist(Modulename);
					Wait.waitfor(2);
					modifyprivilegesPage.click_Availablemodulelist(InterfaceAvailablelist);
					Wait.waitfor(2);
					modifyprivilegesPage.click_MoveRight();
					Wait.waitfor(2);
					modifyprivilegesPage.IsInterfaceDisplayed();
					Wait.waitfor(2);
					/*modifyprivilegesPage.click_Save();
					Wait.waitfor(2);
					createUserPage.selectVMUSERTYPE();
					Wait.waitfor(2);*/
					modifyprivilegesPage.click_modulelist1();
					Wait.waitfor(2);
					modifyprivilegesPage.click_SaveReturn();
					Wait.waitfor(2);
					createUserPage.selectVMUSERTYPE();
					Wait.waitfor(5);
					createUserPage.AddAllPermissionList();
					Wait.waitfor(5);
					createUserPage.SavePermissionlist();
					Wait.waitfor(2);
					createUserPage.selectVMUSERTYPE();
					Wait.waitfor(2);
					createUserPage.assignSBU(SBUname);
					createUserPage.EnterPassword(Password);
					Wait.waitfor(3);
					createUserPage.click_Usertitle();
					createUserPage.click_Save();
					//createUserPage.selectVMUSERTYPE();
					String ActualuserId=createUserPage.get_Userid();
					System.out.println(ActualuserId);
					//createUserPage.click_Usertitle();
					//createUserPage.click_Save();
					/*Wait.waitfor(3);
					createUserPage.click_Cancel();
					Wait.waitfor(2);*/
					homePage.clickLogOut();
					Wait.waitfor(5);
					loginpagex.loginNewUser(ActualuserId, Password);
				    Wait.waitfor(3);
				    homePage.SelectCommodityClassification();
				    Wait.waitfor(2);
				    homePage.titleValidation();
				    homePage.click_help();
				    Wait.waitfor(2);
				    homePage.click_WhoAMI();
				    Wait.waitfor(2);
				    String Firstname=homePage.get_UserFirstname();
				    String Lastname=homePage.get_UserLastname();
				    
				    try {
				    	if(ActualuserId.equals(UserId))
				    	{
				    		test.log(LogStatus.PASS, "Userid is displayed in Who am I");
				    	}
				    	if(Firstname.equals(firstname))
				    	{
				    		test.log(LogStatus.PASS, "firstanme is displayed in Who am I");
				    	}
				    	if(Lastname.equals(lastname))
				    	{
				    		test.log(LogStatus.PASS, "lastname is displayed in Who am I");
				    	}
				    	homePage.click_CancelIcon();
				    	Wait.waitfor(3);
				    	homePage.click_LogOutPortal();
				    	loginpagex.login(prop.getProperty("Username"), prop.getProperty("Password"));
				    }
				     
				    
				    catch(Exception e)
				    {
				    	testFail();
				    	test.log(LogStatus.FAIL, "Userdetails are not matched with created user");
				    	Wait.waitfor(3);
						
				    }
				    
					
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

	
	