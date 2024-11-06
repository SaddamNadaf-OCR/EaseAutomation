package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateInvoicePage extends GenericMethods {
	
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	
	public static final String OCR_CreateInvoicePage_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_CreateInvoicePage_CreateInvoiceBtn = "//button[@class='primary-btn ocr-cache-search-dynamic-class']";
	public static final String OCR_CreateInvoicePage_SelectTemplateOption = "(//input[@name='selectedCreateOption'])[2]";
	public static final String OCR_CreateInvoicePage_SelectTemplatefromDropdown = "//select[@id='createNewInvoice_selectedTemplate']";
	public static final String OCR_CreateInvoicePage_SelectAuthOption = "(//input[@name='selectedCreateOption'])[3]";
	public static final String OCR_CreateInvoicePage_ClickAuthLink = "//a[contains(text(),'Authorization No')]";
	public static final String OCR_CreateInvoicePage_EnterAuthNo = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_CreateInvoicePage_AuthSearchBtn = "//button[@id='searchAuth']";
	public static final String OCR_CreateInvoicePage_AuthSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateInvoicePage_AuthPopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	
	/* ******************************* Constructor ****************************** */

	public CreateInvoicePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Clicking the Create Invoice Button action
	
	public void select_SBUCode(String SBUCode) {
		scrollToElement(driver, OCR_CreateInvoicePage_SBUCode);
		selectByVisibleText(driver, test, OCR_CreateInvoicePage_SBUCode, "Select SBU Code : ", SBUCode);
		clickElement(driver, test, OCR_CreateInvoicePage_CreateInvoiceBtn, "Click on Create Invoice Button ");
}
	
	public void selectFromTemplate(String SBUCode, String Template) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateInvoicePage_SBUCode, "Select SBU Code : ", SBUCode);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateInvoicePage_SelectTemplateOption, "Select option 2 :");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateInvoicePage_SelectTemplatefromDropdown, "Select template name : ", Template);
		clickElement(driver, test, OCR_CreateInvoicePage_CreateInvoiceBtn, "Click on Create Invoice Button ");
	}
	
	public void selectFromAuth(String SBUCode, String AuthLink) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateInvoicePage_SBUCode, "Select SBU Code : ", SBUCode);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateInvoicePage_SelectAuthOption, "Select option 3 :");
		Wait.waitfor(2);
		
		try {
		if(AuthLink.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateInvoicePage_ClickAuthLink, "Click on Authorization link :");
			Wait.waitfor(3);
			typeText(driver, test, OCR_CreateInvoicePage_EnterAuthNo, "Enter Authorization number : ", AuthLink);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateInvoicePage_AuthSearchBtn, "Click on Search button :");
			Wait.waitfor(2);
			clickElement(driver, test, "//td[contains(text(),'"+AuthLink+"')]", "Click on Authorization Number : " +AuthLink);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateInvoicePage_AuthSelectBtn, "Select Authorization Number");
		}
		}
		catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateInvoicePage_AuthPopUpCloseBtn, "Click on Pop up Close button");
		}
		clickElement(driver, test, OCR_CreateInvoicePage_CreateInvoiceBtn, "Click on Create Invoice Button ");
	}
	

}
