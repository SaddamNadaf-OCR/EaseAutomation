package userClasses;
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
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewUserProfilePage extends GenericMethods{
	
	
	public WebDriver driver;
	public ExtentTest test;
	public Object createUserPage;

	
	/************************Locators****************************************/
	public static final String OCR_NewUser_Save="(//button[contains(text(),'Save')])[1]";
	public static final String OCR_NewUser_SaveReturn="//button[contains(text(),'Save & Return')]";
	public static final String OCR_NewUser_Cancel="//button[@class='ocr-cache-search-dynamic-class']";
	public static final String OCR_NewUser_Userid="//input[@id='editUserProfileForm_userProfile_username']";
	public static final String OCR_NewUser_LastName="//input[@id='editUserProfileForm_userProfile_userLastname']";
	public static final String OCR_NewUser_Firstname="//input[@id='editUserProfileForm_userProfile_userFirstname']";
	public static final String OCR_NewUser_UserTitle="//input[@id='editUserProfileForm_userProfile_userTitle']";
	public static final String OCR_NewUser_UserGroup ="//select[@id='groupNameDropBoxId']";
	public static final String OCR_NewUser_PrimarySBU="//select[@id='sbuId']";
	public static final String OCR_NewUser_Date="//select[@id='editUserProfileForm_userProfile_dateFormat']";
	public static final String OCR_NewUser_NumberFormat="//select[@id='editUserProfileForm_userProfile_numberFormat']";
	public static final String OCR_NewUser_EmailAddress="//input[@id='editUserProfileForm_userProfile_emailId']";
	public static final String OCR_NewUser_AddAllModuleList="//button[@name='move-all-right-mod']";
	public static final String OCR_NewUser_SaveModuleList="(//button[contains(text(),'Save')])[3]";
	public static final String OCR_NewUser_AddAllPermissionList="//button[@name='move-all-right-permission']";
	public static final String OCR_NewUser_SavePermissionList="(//button[contains(text(),'Save')])[4]";
	public static final String OCR_NewUSer_Password="//input[@id='editUserProfileForm_userProfile_password']";
	public static final String OCR_NewUSer_PortalUser="//select[@id='mySelect']";
	public static final String OCR_NewUSer_PortalDomain="//textarea[@id='editUserProfileForm_userProfile_portalDomain']";
	
	public static final String OCR_NewUSer_AssignSBU="//button[@name='move-all-right']";
	public static final String OCR_NewUser_AvailableSBUList="//select[@id='sbuCodeInCombo']";
	public static final String OCR_NewUser_SelectedSBUList="//select[@id='selectedSbu']";
	public static final String OCR_NewUSer_SaveSBU="(//button[contains(text(),'Save')])[5]";
	public static final String OCR_NewUSer_AddrightSBU="//button[@name='move-right']";
	
	
	
	public static final String OCR_NewUSer_modifyuserinterface="//button[@id='modifyUserInter']";
	public static final String OCR_NewUSer_Assign="//button[@name='assignUser']";
	public static final String OCR_NewUser_Editprofiletitle ="//h3[contains(text(), 'Edit User Profile')]";
	public static final String OCR_NewUser_Copyprofiletitle ="//h3[contains(text(), 'Copy User Profile')]";
	
	//******************************Confirm VM User Type*************************************
	
	public static final String OCR_NewUser_ConfirmVMUserType_modal="//h4[contains(text(),'Confirm VM User Type')]";
	public static final String OCR_NewUser_ConfirmVMUserType_FullVMUser="//button[contains(text(),'Full VM User')]";
	public static final String OCR_NewUser_ConfirmVMUserType_FrontDeskUser="//button[contains(text(),'	Front Desk User')]";
	
	
	
	
	
	
	/* ******************** Constructor ***************************** */

	public CreateNewUserProfilePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

/*****************************creating Methods****************************************************/
	

	
	
	public String get_Userid() {
		scrollToTop(driver);
		Wait.wait(driver, OCR_NewUser_Userid);
		return  getAttribute(driver, test, OCR_NewUser_Userid, "value", "Get the UserId : ");
		
	}	

	public void click_Save(){
		Wait.waitfor(2);
		 scrollToElement(driver, OCR_NewUser_Save);

	     clickElement(driver, test, OCR_NewUser_Save, "Clicking on Save button");
	}

	
	public void click_SaveReturn(){
		Wait.waitfor(2);
	    scrollToElement(driver, OCR_NewUser_NumberFormat);
		Wait.waitfor(10);
		clickElement(driver, test, OCR_NewUser_SaveReturn, "Clicking on SaveReturn button");
		
	}

	public void click_Cancel(){
		Wait.waitfor(2);
		clickElement(driver, test, OCR_NewUser_Cancel, "Clicking on Cancel button");
	}
	
	public void click_Usertitle()
	{
		clickElement(driver, test, OCR_NewUser_UserTitle, "Clicking on usertitle ");
	}
	
	 public void AddNewUser(String UserId,String firstname,String lastname,String UserTitle,String UserGroup,String PrimarySBU,String Dateformat,String Numberformat,String Email)
	 {

		typeText(driver, test, OCR_NewUser_Userid, "Enter User id : ", UserId+randomnumbers());
		
		typeText(driver, test, OCR_NewUser_Firstname, "Enter First Name : ", firstname);
	
		typeText(driver, test, OCR_NewUser_LastName, "Enter last Name : ", lastname);
	
		typeText(driver, test, OCR_NewUser_UserTitle, "Enter User Title : ", UserTitle);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_NewUser_UserGroup, "enter user group :", UserGroup);
	
		selectByVisibleText(driver, test, OCR_NewUser_PrimarySBU,"Select Primary SBU : ", PrimarySBU);

    	selectByVisibleText(driver, test, OCR_NewUser_Date,"Select Date format : ",Dateformat);
    	Wait.waitfor(2);
    	selectByVisibleText(driver, test, OCR_NewUser_NumberFormat,"Select Numberformat : ",Numberformat);
 
		typeText(driver, test, OCR_NewUser_EmailAddress, "Enter User Email : ", Email);
	}
	
	 public void EditNewUser(String UserId1,String firstname1,String lastname1,String UserTitle1,String UserGroup1,String PrimarySBU1,String Dateformat1,String Numberformat1,String Email1)
	 {

		typeText(driver, test, OCR_NewUser_Userid, "Enter User id : ", UserId1+randomnumbers());
		clearText(driver, test, OCR_NewUser_Firstname, "clear text");
		
		typeText(driver, test, OCR_NewUser_Firstname, "Enter First Name : ", firstname1);
		clearText(driver, test, OCR_NewUser_LastName, "clear text");
		typeText(driver, test, OCR_NewUser_LastName, "Enter last Name : ", lastname1);
		clearText(driver, test, OCR_NewUser_UserTitle, "clear text");
		typeText(driver, test, OCR_NewUser_UserTitle, "Enter User Title : ", UserTitle1);
		Wait.waitfor(2);
		//clearText(driver, test, OCR_NewUser_UserGroup, "clear text");
		selectByVisibleText(driver, test, OCR_NewUser_UserGroup, "enter user group :", UserGroup1);
	
		//clearText(driver, test, OCR_NewUser_PrimarySBU, "clear text");
		selectByVisibleText(driver, test, OCR_NewUser_PrimarySBU,"Select Primary SBU : ", PrimarySBU1);

    	selectByVisibleText(driver, test, OCR_NewUser_Date,"Select Date format : ",Dateformat1);
    	Wait.waitfor(2);
    	selectByVisibleText(driver, test, OCR_NewUser_NumberFormat,"Select Numberformat : ",Numberformat1);
 
		typeText(driver, test, OCR_NewUser_EmailAddress, "Enter User Email : ", Email1);
	}
	 
	 
	 
	 
	 
	 public void AddPortalUser(String UserId,String firstname,String lastname,String UserTitle,String UserGroup,String PrimarySBU,String Dateformat,String Numberformat,String PortalUser,String Email,String PortalDomain)
	 {
		 
		typeText(driver, test, OCR_NewUser_Userid, "Enter User id : ", UserId+randomnumbers());
		
		typeText(driver, test, OCR_NewUser_Firstname, "Enter First Name : ", firstname);
	
	
		typeText(driver, test, OCR_NewUser_LastName, "Enter last Name : ", lastname);
		
		
		typeText(driver, test, OCR_NewUser_UserTitle, "Enter User Title : ", UserTitle);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_NewUser_UserGroup, "enter user group :", UserGroup);
	
		selectByVisibleText(driver, test, OCR_NewUser_PrimarySBU,"Select Primary SBU : ", PrimarySBU);
		
    	selectByVisibleText(driver, test, OCR_NewUser_Date,"Select Date format : ",Dateformat);
    	Wait.waitfor(2);
    	selectByVisibleText(driver, test, OCR_NewUser_NumberFormat,"Select Numberformat : ",Numberformat);
    	Wait.waitfor(2);
    	selectByVisibleText(driver, test, OCR_NewUSer_PortalUser,"Select Portal USer  : ",PortalUser);
    	Wait.waitfor(2);
 
		typeText(driver, test, OCR_NewUser_EmailAddress, "Enter User Email : ", Email);
		Wait.waitfor(2);
		typeText(driver, test, OCR_NewUSer_PortalDomain, "enter Portal Domain  :", PortalDomain);
    	Wait.waitfor(2);
	}
 
	
	 public void AddAllModulelist() {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_NewUser_AddAllModuleList);
		clickElement(driver, test, OCR_NewUser_AddAllModuleList, "Clicking on Add All  button of module list");
		
	 }
	 public void SaveModulelist() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_NewUser_SaveModuleList);
		clickElement(driver, test, OCR_NewUser_SaveModuleList, "Clicking on Save button of module list");
		//AlertPopUp(driver, test, "OK");
		 
	 
	 
	 }

	 public void AddAllPermissionList() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_NewUser_AddAllPermissionList);
		clickElement(driver, test, OCR_NewUser_AddAllPermissionList, "Clicking on Add All  button of permission list");
		
	 }
		
		
		
	/*	 public void click_SelectList(String ModuleList)
		 {
			 Wait.waitfor(2);
			 scrollToElement(driver,OCR_NewUser_AddAllPermissionList);	
			 Wait.waitfor(2);
			 try {
					if(isDisplayed(driver, OCR_NewUser_AddAllPermissionList)) {
						test.log(LogStatus.PASS, "ModuleList is Displayed :  ModuleList is displayed");
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, " ModuleList is not Displayed :  ModuleList is not displayed");
				}
			 
		 }
*/
	 public void SavePermissionlist() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_NewUser_SavePermissionList);
			clickElement(driver, test, OCR_NewUser_SavePermissionList, "Clicking on Save button of Permission list");
			//AlertPopUp(driver, test, "OK");
		 
		 
		 }
	 public void EnterPassword(String Password) {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_NewUSer_Password);
			clearText(driver, test, OCR_NewUSer_Password, "clear text");
			Wait.waitfor(2);
			typeText(driver, test, OCR_NewUSer_Password, "Enter password : ",Password);
			
	 }
		 
	 
	 public void Click_modifyportalinterface() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_NewUSer_modifyuserinterface);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_NewUSer_modifyuserinterface, "Clicking on modifyportalinterface");
			Wait.waitfor(2);
			
			
			/* {
				 try {
						if(isDisplayed(driver, OCR_NewUSer_modifyuserinterface)) {
							clickElement(driver, test, OCR_NewUSer_modifyuserinterface, "Clicking on modifyportalinterface");
						}
					} catch (Exception e) {
						testFailSshot(driver, test);
						test.log(LogStatus.FAIL, "Title is not Displayed : Edit User Profile Title is not displayed");
					}}*/

		 
		 }
	 
	 
	 
	 public void title_isDisplayed()
	 {
		 try {
				if(isDisplayed(driver, OCR_NewUser_Editprofiletitle)) {
					test.log(LogStatus.PASS, "Title  is Displayed : Edit User Profile Title is displayed");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Title is not Displayed : Edit User Profile Title is not displayed");
			}

		 
	 
	 
	 }
	 public void title_isDisplayedCopyUserProfile()
	 {
		 try {
				if(isDisplayed(driver, OCR_NewUser_Copyprofiletitle)) {
					test.log(LogStatus.PASS, "Title  is Displayed : Edit User Profile Title is displayed");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Title is not Displayed : Edit User Profile Title is not displayed");
			}

		 
	 
	 
	 }
	 
	 
	 
	 
	 
	        public void assignSBU(String SBUname)
	      
	        {
	        	scrollToElement(driver,OCR_NewUser_AvailableSBUList);	
				Wait.waitfor(2);
				try{
					if(isDisplayed(driver, OCR_NewUser_AvailableSBUList)) 
					{
					test.log(LogStatus.PASS, "SBU  is Displayed : SBUNAME is displayed");
					Wait.waitfor(2);
					clickElement(driver, test, "(//option[contains(text(),'" + SBUname + "')])[2]", "Selecting SBU from Available SBU List");
					Wait.waitfor(2);
					scrollToElement(driver, OCR_NewUSer_AddrightSBU);
					clickElement(driver, test, OCR_NewUSer_AddrightSBU, "Clicking on Move right button of SBU list  to Selected SBU list");
					Wait.waitfor(2);
					scrollToElement(driver,OCR_NewUser_SelectedSBUList);	
				    Wait.waitfor(2);
				    
				    if(isDisplayed(driver,OCR_NewUser_SelectedSBUList)) {
				    // testFailSshot(driver, test);
				     test.log(LogStatus.PASS, "SBU is  Displayed : SBUNAME is  displayed");
			         }
				    
				    else {
							test.log(LogStatus.FAIL, "SBU is not Displayed in available list");
						
				    	}
					}
					   Wait.waitfor(2);
						scrollToElement(driver, OCR_NewUSer_SaveSBU);
						 Wait.waitfor(5);
						clickElement(driver, test, OCR_NewUSer_SaveSBU, "Clicking on Save button of SBU list");				    
					}
				catch(Exception e) {
					test.log(LogStatus.INFO, "Selected SBU is not available");
				}
				}
	        
	        
/*				 
	        public void click_SBUAvailablelist(String SBUname){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_NewUser_AvailableSBUList);	
			Wait.waitfor(2);
			try {
			clickElement(driver, test, "(//option[contains(text(),'" + SBUname + "')])[2]", "Selecting SBU from Available SBU List");
			}
			 catch (Exception e) {
				//testFailSshot(driver, test);
				test.log(LogStatus.INFO, "SBU is not Displayed : SBUNAME is not displayed");
			}
		  
			//selectByVisibleText(driver, test, OCR_NewUser_AvailableSBUList, "Select SBU list", SBUname);
			//clickElement(driver, test, OCR_NewUSer_AddrightSBU, "Clicking on Move right button of SBU list  to Selected SBU list");
			
			
		}
	
	 public void click_SelectedList(String SBUname)
	 {
		 Wait.waitfor(2);
		 scrollToElement(driver,OCR_NewUser_SelectedSBUList);	
		 Wait.waitfor(2);
		 try {
				
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "SBU is not Displayed : SBUNAME is not displayed");
			}
		 
	 }
	 
	 public void AddSBUlist() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_NewUSer_AddrightSBU);
			clickElement(driver, test, OCR_NewUSer_AddrightSBU, "Clicking on Move right button of SBU list  to Selected SBU list");
			
		 }
	 
	  
	 public void click_SaveSBU()
	 {
		 Wait.waitfor(2);
			scrollToElement(driver, OCR_NewUSer_SaveSBU);
			clickElement(driver, test, OCR_NewUSer_SaveSBU, "Clicking on Save button of SBU list");
			
	 }
	 */
	 
//*************************************	 VM USER TYPE*********************************
	
	 
	 public void selectVMUSERTYPE()
	 {
		 try
		 {
			 if(isDisplayed(driver, OCR_NewUser_ConfirmVMUserType_modal));
			 Wait.waitfor(2);
				 clickElement(driver, test, OCR_NewUser_ConfirmVMUserType_FullVMUser,"Clicking on Full VM USER button");
			} catch (Exception e) {
				
				test.log(LogStatus.INFO, "Confirm VMS USER Modal Not dispalyed");
				Wait.waitfor(3);
				
		 }
	 }
	 
	 
	 
	 public void click_FullUSERVM()
	 {
		 Wait.waitfor(2);
			scrollToElement(driver,OCR_NewUser_ConfirmVMUserType_FullVMUser );
			clickElement(driver, test,OCR_NewUser_ConfirmVMUserType_FullVMUser, "Clicking on Full VM USER button");
			
	 }
	 
	 public void click_FrontDeskUSERVM()
	 {
	 
		 Wait.waitfor(2);
			scrollToElement(driver, OCR_NewUser_ConfirmVMUserType_FrontDeskUser);
			clickElement(driver, test, OCR_NewUser_ConfirmVMUserType_FrontDeskUser, "Clicking on FrontDeskUser button");
			
	 }
	 
	 
	 
	 
	 
}
