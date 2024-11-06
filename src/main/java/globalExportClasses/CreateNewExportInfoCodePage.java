package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewExportInfoCodePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewExportInfoCodePage_ExportInfoCode  ="//input[@name='exportInfoCodes.exportInfoCode']";
	public static final String OCR_CreateNewExportInfoCodePage_Country = "//input[@id='editExportInfoCodes_country']";
	public static final String OCR_CreateNewExportInfoCodePage_Description = "//textarea[@id='expDescription']";
	public static final String OCR_CreateNewExportInfoCodePage_SaveBtn = "(//input[@class='primary-btn ocr-cache-search-dynamic-class'])[1]";
	public static final String OCR_CreateNewExportInfoCodePage_SaveReturnBtn = "(//input[@class='primary-btn ocr-cache-search-dynamic-class'])[2]";
	public static final String OCR_CreateNewExportInfoCodePage_CancelBtn = "//input[@class='ocr-cache-search-dynamic-class']";
	
	

	/* ******************************* Constructor ****************************** */

	public CreateNewExportInfoCodePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void enter_ExporterInfoCode(String ExportInfoCode) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "Enter Export Info Code : ", ExportInfoCode + randomnumbersbetween1_100());
	
	}
	
	//enter Export info code for duplicate error message
	public void ExportInfoCode(String ExportCode) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "Enter Export Info Code : ", ExportCode);
	}
	
	
	public void enter_Country(String Country) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewExportInfoCodePage_Country, "Enter Country : ", Country);
	}
	
	public void enter_Description(String Description) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewExportInfoCodePage_Description, "Enter Description : ", Description + randomnumbers());
	}
	
	public void click_Save() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewExportInfoCodePage_SaveBtn, "CLick on Save button :");
	}
	
	public void click_SaveReturn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewExportInfoCodePage_SaveReturnBtn, "CLick on Save & Return button :");
	}
	
	public void click_Cancel() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewExportInfoCodePage_CancelBtn, "CLick on Cancel button :");
	}
	
	public String getExportInfoCode() {
		Wait.waitfor(2);
		return getTextfromTextbox(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "Getting the Export Info Code : ");
		//return getText(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "Getting the Export Info Code : ");
	//	return getAttribute(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "value", "Getting the Export Info Code: ");
	}
	
	public void validateMandatoryChecks() {
		Wait.waitfor(2);
		 try {
			 if(isDisplayed(driver, "//li[contains(text(),'Export Info Code is required.')]")) {
				test.log(LogStatus.PASS, "Error message is displayed"); 
			 } 
			 if(isDisplayed(driver, "//li[contains(text(),'Country is required.')]")) {
				 test.log(LogStatus.PASS, "Error message is displayed");
			 }
			 if(isDisplayed(driver, "//li[contains(text(),'Export Info Code Description is required.')]")) {
				 test.log(LogStatus.PASS, "Error message is displayed");
			 }
		 }catch(Exception e) {
			 testFailSshot(driver, test);
			 test.log(LogStatus.FAIL, "Error message is not displayed");
		 }
	}
		
		 public void validateDupErrorMsg() {
			 Wait.waitfor(2);
			 try {
				 if(isDisplayed(driver, "//li[contains(text(),'Export Info Code already exists.')]")) {
					 test.log(LogStatus.PASS, "Error message for duplicate Export Info Code displays :");
				 }
			 }catch(Exception e) {
				 testFailSshot(driver, test);
				 test.log(LogStatus.FAIL, "Error message for duplicate Export Info Code does not display :");
			 }
		 }
		
	
	
	

}
