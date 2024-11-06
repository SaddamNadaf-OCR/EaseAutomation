package userClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ModifyPortalInterfacePage extends GenericMethods{
	
	
	public WebDriver driver;
	public ExtentTest test;
	
		/************************Locators****************************************/
		
		public static final String OCR_User_ModifyPortalInterfacetitle ="//h3[contains(text(),'Modify User Interface')]";
		public static final String OCR_User_ModifyPortalInterfaceSave="//button[@name='save']";
		public static final String OCR_User_ModifyPortalInterfaceSaveReturn="//button[@name='save-return']";
		public static final String OCR_User_ModifyPortalInterfaceCancel="//button[contains(text(),'Cancel')]";
		public static final String OCR_User_ModifyPortalInterfaceModulelist="//select[@id='mod']";
		public static final String OCR_User_ModifyPortalInterfaceAvailableList="//select[@id='groupInterCombo']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedList="//div[@id='columnNameDiv']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListmoveright="//button[@name='move-right']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListmoveleft="//button[@name='move-left']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListmoveallright="//button[@name='move-all-right']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListmoveallleft="//button[@name='move-all-left']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListModifyPrivileges="//button[@id='modify-privilege']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivileges="//h4[@id='myModalLabel']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesRadioRead="//input[@id='read_perR']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesRadioWrite="//input[@id='write_perW']";
		public static final String OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesSave="//button[@class='primary-btn']";
		
		public static final String OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesClose="//button[@class='btn-close']";
		
	   /***************************************Constructor**************************************/
		
		
		
		public ModifyPortalInterfacePage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
		
		/**************************Methods************************/
		
		public void MPtitleIsDisplayed() {
			try {
				if(isDisplayed(driver, OCR_User_ModifyPortalInterfacetitle)) {
					test.log(LogStatus.PASS, "Title  is Displayed : Modify User Interface is displayed");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Title is not Displayed : Modify User Interface is not displayed");
			}
		
			
		}
	        
		public void click_Save(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceSave);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_User_ModifyPortalInterfaceSave, "Clicking on Save button");
			Wait.waitfor(4);
			AlertPopUp(driver, test, "Please Notify the user to re-login to observe the saved user interface changes");
			Wait.waitfor(5);
			
		}
		public void click_SaveReturn(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceSaveReturn);	
			Wait.waitfor(2);
			clickElement(driver, test, OCR_User_ModifyPortalInterfaceSaveReturn, "Clicking on Save & Return button");
			
		}
		public void click_Cancel(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceCancel);	
			Wait.waitfor(2);
			clickElement(driver, test, OCR_User_ModifyPortalInterfaceCancel, "Clicking on Cancel button");
			
		}
		public void click_modulelist(String Modulename){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceModulelist);	
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_User_ModifyPortalInterfaceModulelist, "Select Module list", Modulename);
			
			
		}
		
		
		
		public void click_modulelist1(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceModulelist);	
			Wait.waitfor(2);
			clickElement(driver, test, OCR_User_ModifyPortalInterfaceModulelist, "");
			
			
		}
		
		public void click_Availablemodulelist(String InterfaceAvailablelist){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceAvailableList);	
			Wait.waitfor(2);
			selectByVisibleText(driver, test,  OCR_User_ModifyPortalInterfaceAvailableList, "Select Module list", InterfaceAvailablelist);
			
			
		}
		
		public void IsInterfaceDisplayed() {
			
		
			try {
				if(isDisplayed(driver, OCR_User_ModifyPortalInterfaceSelectedList)) {
					test.log(LogStatus.PASS, "Interface is Displayed : [ Interface name]is displayed");
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, "Interface is not Displayed : [ Interface name] is not displayed");
			}
		
		}
		
		
		public void click_Selectedmodulelist(String Interfaceselectedlist){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceAvailableList);	
			Wait.waitfor(2);
			selectByVisibleText(driver, test,  OCR_User_ModifyPortalInterfaceAvailableList, "Select Module list",Interfaceselectedlist);
			
			
		}
		
		public void click_MoveRight(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceSelectedListmoveright);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_User_ModifyPortalInterfaceSelectedListmoveright, "Clicking on Move Right button");
		}
		public void click_MoveLeft(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceSelectedListmoveleft);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_User_ModifyPortalInterfaceSelectedListmoveleft, "Clicking on  Move Left button");
		}
		public void click_MoveAllRight(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_User_ModifyPortalInterfaceSelectedListmoveallright);
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListmoveallright, "Clicking on MoveAllRight button");
		}
		public void click_MoveAllLeft(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceSelectedListmoveallright);
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListmoveallright, "Clicking on MoveAllLeft button");
		}
		
		public void click_ModifyViewPrvileges(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivileges);
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivileges, "Clicking on Modify/View privilege button");
		}
		
		public void click_ReadRadio(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesRadioRead);
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesRadioRead, "Clicking on Read radio button");
		}
		public void click_WriteRadio(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesRadioWrite);
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesRadioWrite, "Clicking on Write radio button");
		}
		
		public void click_SavemodifyPrivileges(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesSave);
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesSave, "Clicking on Save button of Modify/view Privileges");
		}
		
		public void click_Close(){
			Wait.waitfor(2);
			scrollToElement(driver,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesClose);	
			Wait.waitfor(2);
			clickElement(driver, test,OCR_User_ModifyPortalInterfaceSelectedListViewmodifyPrivilegesClose, "Clicking on Close button of Modify/view Privilege");
			
		}
		
}
