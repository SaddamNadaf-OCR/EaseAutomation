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

import utilities.GenericMethods;
import utilities.Wait;

public class ToolsPage extends GenericMethods {
		public WebDriver driver;
		public ExtentTest test;

		/* ******************************** LOCATORS ******************************** */

		public static final String OCR_Tools_ChangePassword= "//a[contains(text(),'Change Password')]";
		public static final String OCR_Tools_User = "(//a[contains(text(),'User')])[4]";
		public static final String OCR_Tools_CreateViewUser = "//a[contains(text(),'Create/View User')]";
		public static final String OCR_Tools_EmailEaseUsers ="//a[contains(text(),'Email EASE Users')]";
		public static final String OCR_Tools_ListModuleDefaultPages="//a[contains(text(),'List Module Default Pages')]";
		public static final String OCR_Tools_UserSettings="//a[contains(text(),'User Settings')]";
		public static final String OCR_Tools_Themes="//a[contains(text(),'Themes')]";
		public static final String OCR_Tools_ExtendUser = "//a[contains(text(),'User Control Attributes Detail')]";
		
		
		/* ******************** Constructor ***************************** */

		public ToolsPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}

	/*****************************creating Methods****************************************************/
		
		
		
		
		// clicking on VMCT
	    public void click_ExtendUser() {
	        String scroll = "//a[contains(text(),'Watch List Screening Defaults')]";
	        GenericMethods.scrollToElement(driver, scroll);
	        clickElement(driver, test, OCR_Tools_User, "Clicking on Extend User");
	    }
	    
		public void click_User() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_User, "Clicking on User");
		}
		public void click_ChangePassword() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_ChangePassword, "Clicking on Change Password");
		}
		
		public void click_createUser() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_CreateViewUser, "Clicking on create/view User");
		}
		
		public void click_EmailEaseUsers() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_EmailEaseUsers, "Clicking on Email Ease Users");
		}
		
		public void click_ListModuleDefaultPages() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_ListModuleDefaultPages, "Clicking on  ListModuleDefaultPages");
		}
		
		public void click_UserSettings() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_UserSettings, "Clicking on UserSettings");
		}
		
		public void click_Themes() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Tools_Themes, "Clicking on Themes");
		}
		
		
}
