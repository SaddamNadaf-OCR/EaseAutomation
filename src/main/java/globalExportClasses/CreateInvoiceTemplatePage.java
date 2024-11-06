package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateInvoiceTemplatePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateInvoiceTemplatePage_SelectSBUCode  = "//select[@id='selectedSbuCode']";
	public static final String OCR_CreateInvoiceTemplatePage_CreateInvoiceTemplateBtn = "//button[@class='primary-btn ocr-cache-search-dynamic-class']";
	public static final String OCR_CreateInvoiceTemplatePage_CancelBtn = "//button[@id='cancelAddInvoice']";
	
	
	/* ******************************* Constructor ****************************** */

	public CreateInvoiceTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
		public void selectSBU(String SBUCode) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_CreateInvoiceTemplatePage_SelectSBUCode, "Select SBu code : ", SBUCode);
		}
		
		public void cancelBtn() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateInvoiceTemplatePage_CancelBtn, "Click on Cancel button : ");
		}
		
		public void createInvTemp() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateInvoiceTemplatePage_CreateInvoiceTemplateBtn, "Click on Create Invoice Template button to create a template : ");
		}

}
