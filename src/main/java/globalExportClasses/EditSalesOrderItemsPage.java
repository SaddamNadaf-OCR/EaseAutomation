package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class EditSalesOrderItemsPage extends GenericMethods {
	

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_CreateNewSalesOrderPage_AddItemsBtn = "//button[contains(text(),'Add Item')]";
	public static final String OCR_CreateNewSalesOrderPage_EditSOItems_CloseBtn = "//button[@id='cancelInvoice']";
	
	/* ******************************* Constructor ****************************** */

	public EditSalesOrderItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
 public void addOrder_Items() {
	 clickElement(driver, test, OCR_CreateNewSalesOrderPage_AddItemsBtn, "Click on Add Items Button");
	 
 }
	
	public void closeBtn() {
		clickElement(driver, test, OCR_CreateNewSalesOrderPage_EditSOItems_CloseBtn, "Click on Close button of Edit Sales Order - Items page");
	}
	
	

}
