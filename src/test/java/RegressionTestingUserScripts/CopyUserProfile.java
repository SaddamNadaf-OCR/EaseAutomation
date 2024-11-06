package RegressionTestingUserScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import userClasses.CreateNewUserProfilePage;
import userClasses.HomePage;
import userClasses.ListUserProfilesPage;
import userClasses.SearchUserProfilePage;
import userClasses.ToolsPage;
import utilities.Utility;
import utilities.Wait;

public class CopyUserProfile extends  SeleniumTestBase{
			@DataProvider
			public Object[][] getData() {
				return Utility.getData("copyUserProfile", excel);
			}
			
			@Test(dataProvider = "getData")
			public void copyUserProfile(String Testcase, String RunMode, String SBU ,String UserId, String firstname, String lastname, String EmailId, String UserGroup, String SBUcode,
					String AccountNo,String Directuser,String Portaluser,String EmployeeId,String ModuleList,String Permission,String Interface,
					String UserId1,String firstname1,String lastname1,String UserTitle1,String UserGroup1,String PrimarySBU1,String Dateformat1,String Numberformat1,String Email1,String Password) throws Exception {
				//Object Creation
			    HomePage homePage=new HomePage(driver,test);
				ToolsPage toolPage=new ToolsPage(driver,test);
				ListUserProfilesPage userprofilepage=new ListUserProfilesPage(driver,test);
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
							searchPage.type_Combination(UserId, firstname, lastname, EmailId, UserGroup, SBUcode,AccountNo,Directuser,Portaluser,EmployeeId,ModuleList,Permission,Interface);
							Wait.waitfor(5);
							searchPage.click_search();
							Wait.waitfor(5);
							userprofilepage.userIsDisplayed();
							Wait.waitfor(2);
							userprofilepage.click_Copy();
							Wait.waitfor(2);
							createUserPage.title_isDisplayedCopyUserProfile();
							Wait.waitfor(2);
							createUserPage.EditNewUser(UserId1, firstname1, lastname1, UserTitle1, UserGroup1, PrimarySBU1, Dateformat1, Numberformat1, Email1);
							Wait.waitfor(2);
							createUserPage.click_Save();
							Wait.waitfor(2);
							createUserPage.selectVMUSERTYPE();
							Wait.waitfor(2);
							String ActualuserId=createUserPage.get_Userid();
							System.out.println(ActualuserId);
							createUserPage.EnterPassword(Password);
							Wait.waitfor(2);
							createUserPage.click_Save();
							createUserPage.selectVMUSERTYPE();
							Wait.waitfor(2);
							createUserPage.click_SaveReturn();
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


