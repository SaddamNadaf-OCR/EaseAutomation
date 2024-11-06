package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class UserHoldTypesPage extends GenericMethods {
	

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_UserHoldTypesPage_AddHoldTypesButton  = "//button[@id='add']";
	public static final String OCR_UserHoldTypesPage_SelectSBUCode = "//select[@id='sbuCode']";
	public static final String OCR_UserHoldTypesPage_CopyHoldType = "(//i[@class='fa fa-copy'])[1]";

	/* ******************************* Constructor ****************************** */

	public UserHoldTypesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void click_AddHoldType() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_UserHoldTypesPage_AddHoldTypesButton, "CLick on Add Hold Types button : ");
	}
	
	public void select_SBUCode(String SBUCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_UserHoldTypesPage_SelectSBUCode, "Select sbu code : ", SBUCode);
	}
	
	public void copy() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_UserHoldTypesPage_CopyHoldType, "CLick on Copy icon : ");
	}
	
}
