package userClasses;
/* 
 * Module : User
 * Author  : Afsha Hamid
 * searchd date : April 2024
 * Descriptions : search View/User 
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchUserProfilePage extends GenericMethods {
	
	
		public WebDriver driver;
		public ExtentTest test;

		
		/************************Locators****************************************/
		public static final String OCR_searchuser_searchbutton="//button[contains(text(),'Search')]";
		public static final String OCR_searchuser_reset="//button[contains(text(),'Reset')]";
		public static final String OCR_searchuser_adduserprofile="//button[contains(text(),'Add User Profile')]";
		public static final String OCR_searchuser_userid="//input[@id='searchUserProfile_userProfile_username']";
		public static final String OCR_search_firstname="//input[@id='searchUserProfile_userProfile_userFirstname']";
		public static final String OCR_search_lastname="//input[@id='searchUserProfile_userProfile_userLastname']";
		public static final String OCR_search_Emailid="//input[@id='searchUserProfile_userProfile_emailId']";
		public static final String OCR_search_Usergroup="//select[@ id='searchUserProfile_userProfile_groupId']";
		public static final String OCR_search_SBUcode="//select[@id='searchUserProfile_userSbu_sbuCode']";
		public static final String OCR_search_AccountNo="//input[@name='accountNum']";
		public static final String OCR_search_Directuser="//select[@name='directUser']";
		public static final String OCR_search_portalUser="//select[@name='portalUserCheck']";
		public static final String OCR_search_EmployeeID="//input[@name='userProfile.employeeId']";
		public static final String OCR_search_ModuleList="//select[@id='userProfileModuleList']";
		public static final String OCR_search_permission="//select[@id='searchUserProfile_permissions']";
		public static final String OCR_search_interface="//select[@id='interfaceList']";

		
			
			
		
		/* ******************** Constructor ***************************** */

		public SearchUserProfilePage(WebDriver driver, ExtentTest test) 
		{
			this.driver = driver;
			this.test = test;
		}

	/*****************************creating Methods****************************************************/
		
		
		public void click_search() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_searchuser_searchbutton, "Clicking on search button");
		}
				
		public void click_reset() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_searchuser_reset, "Clicking on reset button");
		}
				
		
		public void click_addUserProfile() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_searchuser_adduserprofile, "Clicking on Add user profile button");
		}
				
		public void type_Combination(String UserId,String firstname,String lastname,String EmailId,String UserGroup,String SBUcode,String AccountNo,String Directuser,String Portaluser,String EmployeeId,String ModuleList,String Permission1,String Interface)
		{
			
		       if (UserId.length()>0){
		    	   typeText(driver, test, OCR_searchuser_userid, "Enter User id : ", UserId);
		       }
				if (firstname.length()>0) {
				typeText(driver, test, OCR_search_firstname, "Enter First Name : ", firstname);
			
				}
				if (lastname.length()>0) {
				typeText(driver, test, OCR_search_lastname, "Enter last Name : ", lastname);
				}
				if (EmailId.length()>0)
				typeText(driver, test, OCR_search_Emailid, "Enter email id  : ", EmailId);
			
		         if (UserGroup.length()>0) {
				selectByVisibleText(driver, test, OCR_search_Usergroup,"Select Category : ", UserGroup);
			     }
			
		         if  (SBUcode.length()>0){
				selectByVisibleText(driver, test, OCR_search_SBUcode,"Select Category : ", SBUcode);
				
				if(AccountNo.length()>0) {
					typeText(driver, test, OCR_search_AccountNo,"Enter Account No", AccountNo);
				}
				if(Directuser.length()>0) {
					selectByVisibleText(driver, test, OCR_search_Directuser,"Enter Account No",Directuser );
				}
				
				if(Portaluser.length()>0) {
					selectByVisibleText(driver, test, OCR_search_portalUser,"Enter Account No",Portaluser );
				}
				
				if(EmployeeId.length()>0) {
					typeText(driver, test, OCR_search_EmployeeID,"Enter Account No", EmployeeId);
				}
				if(ModuleList.length()>0) {
					selectByVisibleText(driver, test, OCR_search_ModuleList,"Enter Account No",ModuleList );
				}
				if(Permission1.length()>0) {
					selectByVisibleText(driver, test, OCR_search_permission,"Enter Account No",Permission1 );
					
					/*  String Permission11 = "//div[contains(text(),'" + Permission1.trim() + "')]";
				 		Wait.waitfor(5);
				 		ClickElement(driver, test, permission1 , "Select the permission : " + permission1);
				 		selectByVisibleText(driver, test, "//div[contains(text(),'" + Permission1.trim() + "')]" , "Select the permission", Permission1);
				 	   */
				}
				if(Interface.length()>0) {
					selectByVisibleText(driver, test, OCR_search_interface,"Enter Account No",Interface );
				}
				
				
				
			}
		      
		         
		         }
		         

		         
		   /*public void Select_onUserPermission() {
		     	
		         String permission1 = "//div[contains(text(),'" + permission1.trim() + "')]";
		 		Wait.waitfor(5);
		 		ClickElement(driver, test, permission1 , "Select the permission : " + permission1);
		 		selectByVisibleText(driver, test, "//div[contains(text(),'" + permission1.trim() + "')]" , "Select the permission", permission1);
		 	  } */
		 		
		 		

		


}



