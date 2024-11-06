package userClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ListUserProfilesPage extends GenericMethods{
	
	
	public WebDriver driver;
	public ExtentTest test;
	
	
	/************************Locators****************************************/
	
	public static final String OCR_ListUserProfiles_NewSearch="//button[contains(text(),'New Search')]";
	public static final String OCR_ListUserProfiles_AddUserProfile="//button[contains(text(),'Add User Profile')]";
	public static final String OCR_ListUserProfiles_BulkUpdate="//button[contains(text(),'Bulk Update')]";
	public static final String OCR_ListUserProfiles_Copyicon="//i[@class='fa fa-copy']";
	public static final String OCR_ListUserProfiles_Status="//i[@title='Status']";
	public static final String OCR_ListUserProfiletitle="//h3[contains(text(),'List User Profiles')]";
	public static final String OCR_ListUserProfileTotalnoOfRecords="//label[contains(text(),'Total Number of Records Found: 1')]";
	
	public static final String OCR_ListUserProfiles_ViewLicenceUsageSummary="//button[@id='auditReport']";
	public static final String OCR_ListUserProfiles_ViewLicenceUsageSummaryClose="//button[@class='btn-close']";
	public static final String OCR_ListUserProfiles_ViewLicenceUsageSummarytitle="//h4[@id='myModalLabel']";
	public static final String OCR_ListUserProfiles_ViewLicenceUsageSummaryPdf="//img [@title='Export to pdf']";
	
	//****************************Grid******************************//
	public static final String OCR_ListUserProfiles_Userid="//a[contains(text(),'Afsha')]";
	public static final String OCR_ListUserProfiles_SelectAllCheckbox="//input[@id='cb_grid']";
	public static final String OCR_ListUserProfiles_SelectCheckbox="//input[@id='jqg_grid_1']";
	public static final String OCR_ListUserProfiles_ExportToExcel="(//span[@class='ui-icon ui-icon-document'])[1]";
	public static final String OCR_ListUserProfiles_Refresh="//span[@class='ui-icon ui-icon-refresh']";
	
	//****************************Pagination******************************//
	public static final String OCR_ListUserProfiles_Recordsperpage="//select[@title='Records per Page']";
	public static final String OCR_ListUserProfiles_NextPage="(//span[@class='ui-icon ui-icon-seek-next'])[1]";
	public static final String OCR_ListUserProfiles_EndPage="(//span[@class='ui-icon ui-icon-seek-end'])[1]";
	public static final String OCR_ListUserProfiles_PreviousPage="(//span[@class='ui-icon ui-icon-seek-prev'])[1]";
	public static final String OCR_ListUserProfiles_FirstPage="//td[@id='first_t_grid_toppager']";
	
	
	//****************************BulkUpdate SBU******************************//
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBU ="//a[contains(text(),'User SBUs')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUTitle ="//h4[contains(text(),'Bulk Update - User SBUs')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUUpdate ="//button[@id='updateButton']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUcancel ="//button[contains(text(),'Cancel')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUStatus="//select[@id='status']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUAction="//select[@id='action']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUSelectAvailable="//option[contains(text(),'DMUS-US (Active)')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUMoveRightButton="//button[@name='move-right']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUMoveLeftButton="//button[@name='move-left']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUMoveAllRighttButton="//button[@name='move-all-right']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUMoveAllLeftButton="//button[@name='move-all-left']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUclose="//button[@class='btn-close']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserSBUSucesssValidation="//li[contains(text(),'Successfully completed updating User profile(s).')]";
	
	//****************************BulkupdateUsermodules******************************//
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModules="//a[contains(text(),'User Modules')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulestitle="//h4[@id='myModalLabel']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesupdate="//button[@name='update']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulescancel="//button[@id='cancel']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesAvailablelist="//select[@class='form-control']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesMoveRightButton="(//button[@class='ms-btn ms-btn-single'])[1]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesMoveLeftButton="(//button[@class='ms-btn ms-btn-single'])[2]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesMoveAllRightButton="//button[@name='move-all-right']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesMoveAllLeftButton="//button[@name='move-all-left']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserModulesclose="//button[@id='closeTop']";
	
	
	//****************************User permissions******************************//
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissions="//a[contains(text(),'User Permissions')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionstitle="//h4[@id='myModalLabel']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsupdate="//button[@name='update']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsaction="//select[@id='actionPerform']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsModuleId="//select[@id='userModuleList']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionscountries="//select[@id='licCountrybasedOnModule']";	
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsAvailablelist="//select[@id='licCountrybasedOnModule']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsMoveRightButton="//select[@id='licCountrybasedOnModule']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsMoveLeftbutton="//select[@id='licCountrybasedOnModule']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsMoveAllRightbutton="//select[@id='licCountrybasedOnModule']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsMoveAllLeftbutton="//select[@id='licCountrybasedOnModule']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserPermissionsclose="//button[@id='closeTop']";
	
	
	//****************************UseracesssPrivilege******************************
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilege="//a[contains(text(),'User Access Privileges')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegetitle="//h4[@id='myModalLabel']";	
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeupdate="//button[@name='update']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegecancel="//button[@id='cancel']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegemoduleId="//select[@id='mod']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeAccesstype="//select[@id='accessType']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeChangedAllto="//select[@id='status']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeAvailableInterfacelist="//select[@id='interfaceList']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeSelectedInterfacelist="//div[@id='columnNameDiv']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeMoveRight="//button[@name='move-right']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeMoveLeft="//button[@name='move-left']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeMoveAllRight="//button[@name='move-all-right']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeMoveAllLeft="//button[@name='move-all-left']";
	public static final String OCR_ListUserProfiles_Bulkupdate_UserAccesPrivilegeClose="//button[@id='closeTop']";
	
	
	//****************************Profile status******************************
	
	public static final String OCR_ListUserProfiles_Bulkupdate_ProfileStatus="//a[contains(text(),'Profile Status')]";
	public static final String OCR_ListUserProfiles_Bulkupdate_ProfileStatustitle="//h4[@id='myModalLabel']";
	public static final String OCR_ListUserProfiles_Bulkupdate_ProfileStatusupdate="//button[@id='updateButton']";
	public static final String OCR_ListUserProfiles_Bulkupdate_ProfileStatuscancel="//button[@id='cancel']";
	public static final String OCR_ListUserProfiles_Bulkupdate_ProfileStatusSetStatusto="//select[@id='statusPerform']";
	public static final String OCR_ListUserProfiles_Bulkupdate_ProfileStatusclose="//button[@id='closeTop']";
	
	
	
	
	//***************************Constructor*****************************
	

	
	public ListUserProfilesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	
	//************************Methods**********************
	
                                                  //*********** Top Buttons**********
	public void click_Newsearch(){
		Wait.waitfor(2);
		scrollToElement(driver, OCR_ListUserProfiles_NewSearch);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_NewSearch, "Clicking on New Search button");
	}
	public void click_AddUserProfile(){
		Wait.waitfor(2);
		scrollToElement(driver, OCR_ListUserProfiles_AddUserProfile);	
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_AddUserProfile, "Clicking on Adduserprofile button");
		
	}

	public void click_Bulkupdate(){
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_BulkUpdate, "Clicking on BulkUpdate button");
	}
                                   //********Title*****************************
	
	public void titleIsDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ListUserProfiletitle)) {
				test.log(LogStatus.PASS, "Title  is Displayed : List User Profiles is displayed");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed :List User Profiles is not displayed");
		}
	
		
	}
                             //**************Total no Records**************
	public void TotalRecordIsDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ListUserProfileTotalnoOfRecords)) {
				test.log(LogStatus.PASS, "Total no of Record  is Displayed :Total no of Record  is displayed");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Total no of record is not Displayed :Total no of Record  is not displayed");
		}
	
		
	}
	
	//*************************** Grid elements**************************
	
	public void click_Copy(){
		Wait.waitfor(2);
		scrollToElement(driver, OCR_ListUserProfiles_Copyicon);	
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_Copyicon, "Clicking on Copy iCon on Grid");
		
	}	
	
	public void click_Status(){
		Wait.waitfor(2);
		scrollToElement(driver, OCR_ListUserProfiles_Status);	
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_Status, "Clicking on Status iCon on Grid");
		
	}	
	public void click_SelectAllCheckbox(){
		Wait.waitfor(2);
		scrollToElement(driver,OCR_ListUserProfiles_SelectAllCheckbox);	
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_SelectAllCheckbox, "Clicking on AllCheckbox on Grid");
		
	}	
	public void click_Checkbox(){
		Wait.waitfor(2);
		scrollToElement(driver,OCR_ListUserProfiles_SelectCheckbox);	
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_SelectCheckbox, "Clicking on Status iCon on Grid");
	}
	
	
	
	
	
	public void ClickUserId(){
		scrollToElement(driver,OCR_ListUserProfiles_Userid);	
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListUserProfiles_Userid, "Clicking on UserId on Grid");
		
	
	
		
	}

	
	public void userIsDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ListUserProfiles_Userid)) {
				test.log(LogStatus.PASS, "User is Displayed : Afsha  is displayed");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "User is not Displayed : Afsha  is not displayed");
		}
		
	}
		
		//****************************************** BULKUPDATESBU****************************

		public void BUSBUTitle() {
		
	try {
		if(isDisplayed(driver, OCR_ListUserProfiles_Bulkupdate_UserSBUTitle)) {
			test.log(LogStatus.PASS, "Title is Displayed : Bulk Update - User SBUs is displayed");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Bulk Update - User SBUs is not displayed");
	}


		}
	


	   public void clickBulkSBU() {
		   scrollToElement(driver,OCR_ListUserProfiles_Bulkupdate_UserSBU);	
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBU, "Clicking on User SBU Option  on Grid");
		   
	   }
	   
	   
	   
		public void click_BSBUUpdateButton(){
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUUpdate, "Clicking on BulkUpdateUserSBU Update button");
		}
		
		public void click_BSBUCancel(){
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUcancel, "Clicking on BulkUpdateUserSBU Cancel button");
		}
		public void click_BSBUStatus(){
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUStatus, "Clicking on BulkUpdateUserSBU Status button");
		}
		public void click_BSBUSClosepopup(){
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUclose, "Clicking on BulkUpdateUserSBU Close button");
		}
		
		public void click_BSBUActionButton(){
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUAction, "Clicking on BulkUpdateUserSBU Action button");
		}
		public void click_BSBUSStatus(){
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUStatus, "Clicking on BulkUpdateUserSBU Status button");
		}
		
		public void click_BSBUAvailable(String InterfaceAvailablelist)
		{
				Wait.waitfor(2);
				scrollToElement(driver, OCR_ListUserProfiles_Bulkupdate_UserSBUSelectAvailable);	
				Wait.waitfor(2);
				selectByVisibleText(driver, test,  OCR_ListUserProfiles_Bulkupdate_UserSBUSelectAvailable, "Select Module list", InterfaceAvailablelist);			
			
		}
		public void click_BSBUmoveright()
		{
			clickElement(driver, test, OCR_ListUserProfiles_Bulkupdate_UserSBUMoveRightButton,"Clicking on Move right button");
		}
		
		
		
		
		
}

