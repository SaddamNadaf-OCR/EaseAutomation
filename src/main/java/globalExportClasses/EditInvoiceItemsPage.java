package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditInvoiceItemsPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_EditInvoiceItemsPage_AddItemsBtn = "//button[contains(text(),'Add Item')]";
	public static final String OCR_EditInvoiceItemsPage_EditSOItems_CloseBtn = "//button[@id='cancelInvoice']";
	public static final String OCR_EditInvoiceItemsPage_EditSOItems_Regres_AdditionalTransBtn = "//i[@class='fa fa-th']";
	public static final String OCR_EditInvoiceItemsPage_EditSOItems_Regres_MiscellaneousDetails = "//a[contains(text(),'Miscellaneous Details')]";
	public static final String OCR_EditInvoiceItemsPage_EditSOItems_Regres_AdditionalDetails = "//i[@class='fa fa-th']";
	public static final String OCR_EditInvoiceItemsPage_EditSOItems_Regres_CanadianDetails = "//a[contains(text(),'Canadian Customs Details')]";
	public static final String OCR_EditInvoiceItemsPage_EditSOItems_Regres_InvoiceOrderForm = "//a[contains(text(),'Order Form')]";
	/* ******************************* Constructor ****************************** */

	public EditInvoiceItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
 public void addOrder_Items() {
	 clickElement(driver, test, OCR_EditInvoiceItemsPage_AddItemsBtn, "Click on Add Items Button");
	 
 }
 
 // click on Additional transaction details on Edit Invoice Items page for Regression US
 public void additionalTransBtn() {
	 clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_Regres_AdditionalTransBtn, "Click on Additional Transaction Button : ");
	 Wait.waitfor(2);
	 clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_Regres_MiscellaneousDetails, "Click on Miscellaneous Details :");
 }
 
//click on Additional transaction details on Edit Invoice Items page to go to Invoice Order Form for Regression US
public void goToInvoiceOrderForm() {
	 clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_Regres_AdditionalTransBtn, "Click on Additional Transaction Button : ");
	 Wait.waitfor(2);
	 clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_Regres_InvoiceOrderForm, "Click on Order Form :");
}
 
 
 //click on Additional transaction details to go directly to Canadian customs Details for Regression US
 public void canadianCustoms() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_Regres_AdditionalTransBtn, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_Regres_CanadianDetails, "Click on Canadian Customs Details :");
	}
 
 
 //click on invoice item number displayed in the list for Authorization for Regression US
 public void clickInvoiceItem(String InvoiceItem) {
	 Wait.waitfor(2);
	 if(InvoiceItem.length() > 0) {
	 clickElement(driver, test, "//a[contains(text(),'"+InvoiceItem+"')]", "Click on Invoice Item Number : " +InvoiceItem);
 }
 }
 
	
	public void closeBtn() {
		clickElement(driver, test, OCR_EditInvoiceItemsPage_EditSOItems_CloseBtn, "Click on Close button of Edit Sales Order - Items page");
	}
	
	//validation for item stored in grid
	public void validateItemGrid(String InvOrderNo) {
		try {
			if(isDisplayed(driver, "//a[contains(text(), '"+InvOrderNo+"')]")) {
				test.log(LogStatus.PASS, "Invoice Number is displayed in Item Grid :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Invoice Number is not displayed in Item Grid :");
		}
	}
	
	

}
