package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewHoldTypesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewHoldTypesPage_SelectSBUCode  = "//select[@id='sbuCode']";
	public static final String OCR_CreateNewHoldTypesPage_Input_Holdname = "//input[@id='editUserHoldType_userHoldType_holdName']";
	public static final String OCR_CreateNewHoldTypesPage_Description = "//textarea[@id='editUserHoldType_userHoldType_description']";
	public static final String OCR_CreateNewHoldTypesPage_SaveBtn = "//button[@name='save.x']";
	public static final String OCR_CreateNewHoldTypesPage_SaveReturnBtn = "//button[@name='ok']";
	public static final String OCR_CreateNewHoldTypesPage_CancelBtn = "//button[@name='cancel']";
	
	/* ******************************* Constructor ****************************** */

	public CreateNewHoldTypesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void enter_HoldName(String HoldName) {
		Wait.waitfor(2);
		clearText(driver, test, OCR_CreateNewHoldTypesPage_Input_Holdname, "");
		typeText(driver, test, OCR_CreateNewHoldTypesPage_Input_Holdname, "Enter Hold Name : ", HoldName);
	}

	public void enter_Description(String Description) {
		Wait.waitfor(2);
		clearText(driver, test, OCR_CreateNewHoldTypesPage_Description, "");
		typeText(driver, test, OCR_CreateNewHoldTypesPage_Description, "Enter Description : ", Description);
	}
	
	public void click_Save() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewHoldTypesPage_SaveBtn, "Click on Save button : ");
	}
	
	public void click_SaveReturn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewHoldTypesPage_SaveReturnBtn, "Click on Save & Return button : ");
	}
	
	public void click_Cancel() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewHoldTypesPage_CancelBtn, "Click on Cancel button : ");
	}
	
	public void validateMandatoryChecks() {
		
		Wait.waitfor(2);
		String errorMsg = getText(driver, test, "//h4[contains(text(),'Error!')]", "Error message is displayed");
		
		try {
			if(errorMsg.equalsIgnoreCase("Error!")) {
				test.log(LogStatus.PASS, "Error message displays to enter mandatory fields before saving a record.");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error message is not displayed.");
		}
	}
		
	}

