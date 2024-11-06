package globalExportClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.python.antlr.PythonParser.testlist1_return;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewAESCorrectionCodePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewAESCorrectionCodePage_AESCorrectionCode = "//input[@id='editAesCorrectionCode_aesCorrectionCode_correctionCode']";
	public static final String OCR_CreateNewAESCorrectionCodePage_Description = "//textarea[@id='editAesCorrectionCode_aesCorrectionCode_correctionCodeDescription']";
	public static final String OCR_CreateNewAESCorrectionCodePage_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_CreateNewAESCorrectionCodePage_SaveReturn = "(//button[contains(text(),'Save & Return')])[1]";
	public static final String OCR_CreateNewAESCorrectionCodePage_Cancel = "(//button[contains(text(),'Cancel')])[1]";

	/* ******************************* Constructor ****************************** */

	public CreateNewAESCorrectionCodePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void enter_AESCorrectionCode(String AESCode) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewAESCorrectionCodePage_AESCorrectionCode, "Enter AES Correction Code : ",
				AESCode);
	}

	public void enter_Description(String Desc) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewAESCorrectionCodePage_Description, "Enter Description : ", Desc);
	}

	public void getAESCode() {
		Wait.waitfor(2);
		String getAESCode = getText(driver, test, OCR_CreateNewAESCorrectionCodePage_AESCorrectionCode,
				"Fetch the AES Code :");
	}

	public void click_Save() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewAESCorrectionCodePage_Save, "Click on Save button : ");
	}

	public void click_SaveReturn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewAESCorrectionCodePage_SaveReturn, "Click on Save & Return button : ");
	}

	public void click_Cancel() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewAESCorrectionCodePage_Cancel, "Click on Cancel button : ");
	}

	public void validateMandatoryCheckErrorMsg() {
		Wait.waitfor(2);
		String errorMsg = getText(driver, test, "//h4[contains(text(),'Error!')]", "Error message is displayed");

		try {
			if (errorMsg.equalsIgnoreCase("Error!")) {
				test.log(LogStatus.PASS, "Error message displays to enter mandatory fields before saving a record.");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error message is not displayed.");
		}
	}

	public void validateDupErrorMsg() {
		Wait.waitfor(2);
		String getErrorMsg = getText(driver, test,
				"//span[contains(text(),'This AES Correction Code  already exists. Enter another AES Correction Code.')]",
				"Duplicate Error message displays");
		try {
			if (getErrorMsg
					.equalsIgnoreCase("This AES Correction Code  already exists. Enter another AES Correction Code.")) {
				test.log(LogStatus.PASS, "Duplicate Error message displays :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Duplicate Error message does not display :");
		}
	}

}
