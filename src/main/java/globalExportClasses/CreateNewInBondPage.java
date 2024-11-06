package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import javassist.bytecode.stackmap.TypeTag;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewInBondPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewInBondPage_EnterInbondCode = "//input[@name='bond.inBondCode']";
	public static final String OCR_CreateNewInBondPage_InbondDescription = "//textarea[@id='bondDescription']";
	public static final String OCR_CreateNewInBondPage_SaveBtn = "(//input[@class='primary-btn ocr-cache-search-dynamic-class'])[1]";
	public static final String OCR_CreateNewInBondPage_SaveReturnBtn = "(//input[@class='primary-btn ocr-cache-search-dynamic-class'])[2]";
	public static final String OCR_CreateNewInBondPage_CancelBtn = "//input[@class='ocr-cache-search-dynamic-class']";
	
	/* ******************************* Constructor ****************************** */

	public CreateNewInBondPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
 public void enter_InbondCode(String InBondCode) {
	 Wait.waitfor(2);
	 typeText(driver, test, OCR_CreateNewInBondPage_EnterInbondCode, "Enter InBond Code : ", InBondCode + randomnumbersbetween1_100());
 }
 
 //entering inbond code for verifying duplicate inbond code
 public void InBondCode(String InBondCode) {
	 Wait.waitfor(2);
	 typeText(driver, test, OCR_CreateNewInBondPage_EnterInbondCode, "Enter InBond Code : ", InBondCode);
 }
 
 public void enter_InbondDesc(String InBondDesc) {
	 Wait.waitfor(2);
	 typeText(driver, test, OCR_CreateNewInBondPage_InbondDescription, "Enter Inbond Description : ", InBondDesc + randomnumbers());
 }
 
 public void click_Save() {
	 Wait.waitfor(2);
	 clickElement(driver, test, OCR_CreateNewInBondPage_SaveBtn, "Click on Save button : ");
 }
 
 public void click_SaveReturn() {
	 Wait.waitfor(2);
	 clickElement(driver, test, OCR_CreateNewInBondPage_SaveReturnBtn, "Click on Save & Return button : ");
 }
 
 public void click_Cancel() {
	 Wait.waitfor(2);
	 clickElement(driver, test, OCR_CreateNewInBondPage_CancelBtn, "Click on Cancel button : ");
 }
 
 public String getInBondCode() {
		Wait.waitfor(2);
		return getTextfromTextbox(driver, test, OCR_CreateNewInBondPage_EnterInbondCode, "Getting the InBond Code : ");
		//return getText(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "Getting the Export Info Code : ");
	//	return getAttribute(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "value", "Getting the Export Info Code: ");
	}
 
 public void validateDupErrorMsg() {
	 Wait.waitfor(2);
	 try {
		 if(isDisplayed(driver, "//li[contains(text(),'This InBond Code already exists. Enter unique InBond Code.')]")) {
			 test.log(LogStatus.PASS, "Error message for duplicate InBond Code displays :");
		 }
	 }catch(Exception e) {
		 testFailSshot(driver, test);
		 test.log(LogStatus.FAIL, "Error message for duplicate InBond Code does not display :");
	 }
 }
 
 public void validateMandatoryChecks() {
		Wait.waitfor(2);
		 try {
			 if(isDisplayed(driver, "//li[contains(text(),'InBond Code is required.')]")) {
				test.log(LogStatus.PASS, "Error message is displayed"); 
			 } 
			 if(isDisplayed(driver, "//li[contains(text(),'InBond Desc is required.')]")) {
				 test.log(LogStatus.PASS, "Error message is displayed");
			 }
			
		 }catch(Exception e) {
			 testFailSshot(driver, test);
			 test.log(LogStatus.FAIL, "Error message is not displayed");
		 }
	}

}
