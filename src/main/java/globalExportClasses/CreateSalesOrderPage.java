package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CreateSalesOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	
	public static final String OCR_CreatSalesOrderPage_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_CreateSalesOrderPage_CreateSalesOrderBtn = "//button[@class='primary-btn ocr-cache-search-dynamic-class']";
	
	
	/* ******************************* Constructor ****************************** */

	public CreateSalesOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Add Sales Order Button action
	
	public void select_SBUCode(String SBUCode) {
		selectByVisibleText(driver, test, OCR_CreatSalesOrderPage_SBUCode, "Select SBU Code : ", SBUCode);
		clickElement(driver, test, OCR_CreateSalesOrderPage_CreateSalesOrderBtn, "Click on Create Sales Order Button ");

	
}
	
}
