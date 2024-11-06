package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DeliveryOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DO_AddDeliveryOrder = "//button[contains(text(),'Add Delivery Order')]";
	public static final String OCR_DO_Search = "//button[@id='invoice-search']";
	public static final String OCR_DO_InvoiceNo ="//input[@id='searchDeliveryOrder_invoice_invoiceNo']";
	public static final String OCR_DO_WorkStatus = "//select[@id='searchDeliveryOrder_invoice_workStatus']";
	public static final String OCR_DO_ShipmentNo = "//input[@id='searchDeliveryOrder_invoice_shipment_shipmentNo']";
	public static final String OCR_DO_LSStatus ="//select[@id='searchDeliveryOrder_invoice_eldsStatus']";
	public static final String OCR_DO_InvoiceItemLabel = "//font[contains(text(),'Search Criteria based on Invoice Item')]";
	public static final String OCR_DO_PartNo = "//input[@id='searchDeliveryOrder_invoiceItem_partNo']";
	public static final String OCR_DO_Description ="//textarea[@id='searchDeliveryOrder_invoiceItem_description']";
	public static final String OCR_DO_ExportControlLabel = "//font[contains(text(),'Export Control')]";
	public static final String OCR_DO_ExportClassification ="//input[@id='searchDeliveryOrder_invoiceItem_productClassification']";
	public static final String OCR_DO_AuthorisationNo = "//input[@id='searchDeliveryOrder_invoiceItem_licenseNo']";

	/* ******************************* Constructor ****************************** */

	public DeliveryOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Delivery order
	public void clickAddDeliveryOrder() {
		clickElement(driver, test, OCR_DO_AddDeliveryOrder, "Click on Delivery Order");
	}
	
	//Click on Search button
	public void clickSearch() {
		scrollToElement(driver, OCR_DO_Search);
		clickElement(driver, test, OCR_DO_Search, "click on Search");
	}
	
	// Search Criteria based on Delivery Order Header
	public void search_InvNo(String InvoiceNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_DO_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
	}
	
	//Select Work Status
	public void search_WorkStatus(String WorkStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_DO_WorkStatus, "Select the Work Status : ", WorkStatus);	
	}
	
	//Enter Shipment No
	public void search_ShipmentNo(String ShipmentNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_DO_ShipmentNo, "Enter the Shipment No : ", ShipmentNo);
	}
	
	//Select LS Status
	public void search_LSStatus(String LSStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_DO_LSStatus, "Select the LSStatus : ", LSStatus);
	}
	
	// Search Criteria based on Invoice Item
	public void search_PartNo(String PartNo) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_DO_InvoiceItemLabel);
		clickElement(driver, test, OCR_DO_InvoiceItemLabel, "Click on Invoice Item Label");
		Wait.waitfor(2);
		typeText(driver, test, OCR_DO_PartNo, "Enter the Part no : ", PartNo);
	}
	
	//Enter Description
	public void search_PartDesc(String Description) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_DO_InvoiceItemLabel);
		clickElement(driver, test, OCR_DO_InvoiceItemLabel, "Click on Invoice Item Label");
		Wait.waitfor(2);
		typeText(driver, test, OCR_DO_Description, "Enter the Description : ", Description);
	}
	
	//Search Export Control
	public void searchExportControl(String ExportClassification, String AuthorisationNo) {
		scrollToElement(driver, OCR_DO_ExportControlLabel);
		clickElement(driver, test, OCR_DO_ExportControlLabel, "Click on Export Control Label");
		typeText(driver, test, OCR_DO_ExportClassification, "Enter the Export Classification : ", ExportClassification);
		typeText(driver, test, OCR_DO_AuthorisationNo, "Enter the Authorisation No : ", AuthorisationNo);
	}
	
	//Search Parameters
	public void searchWithParameters(String InvoiceNo, String WorkStatus, String LSStatus, String PartNo, String Description,
			String ExportClassification, String AuthorisationNo) {
		if(InvoiceNo.length() > 0) {
			typeText(driver, test, OCR_DO_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
		}
		if(WorkStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_DO_WorkStatus, "Select the Work Status : ", WorkStatus);
		}
		if(LSStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_DO_LSStatus, "Select the LSStatus : ", LSStatus);
		}
		if(PartNo.length() > 0) {
			typeText(driver, test, OCR_DO_PartNo, "Enter the Part no : ", PartNo);
		}
		if(Description.length() > 0) {
			typeText(driver, test, OCR_DO_Description, "Enter the Description : ", Description);
		}
		if(ExportClassification.length() > 0) {
			typeText(driver, test, OCR_DO_ExportClassification, "Enter the Export Classification : ", ExportClassification);
		}
		if(AuthorisationNo.length() > 0) {
			typeText(driver, test, OCR_DO_AuthorisationNo, "Enter the Authorisation No : ", AuthorisationNo);
		}
	}
}
