package globalExportClasses;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;


public class SalesOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SalesOrderPage_AddSalesOrderBtn = "//button[contains(text(),'Add Sales Order')]";
	public static final String OCR_SalesOrderPage_SalesorderNoInput = "//input[@id='searchSalesOrder_invoice_invoiceNo']";
	public static final String OCR_SalesOrderPage_SalesOrderNoSearch = "//button[@id='searchInvoiceBtn']";
	public static final String OCR_Sales_SalesOrderNo = "//input[@id='searchSalesOrder_invoice_invoiceNo']";
	public static final String OCR_Sales_WorkStatus = "//select[@id='searchSalesOrder_invoice_workStatus']";
	public static final String OCR_Sales_ShipmentNo = "//input[@id='searchSalesOrder_invoice_shipment_shipmentNo']";
	public static final String OCR_Sales_ECStatus = "//input[@id='invoiceEcStatus-selectized']";
	public static final String OCR_Sales_CountryofUltDestination = "//input[@id='searchSalesOrder_invoice_countryOfUltDest']";
	public static final String OCR_Sales_WLSStatus = "//select[@id='searchSalesOrder_invoice_screeningStatus']";
	public static final String OCR_Sales_InvoiceItemLabel = "//font[contains(text(),'Search Criteria based on Invoice Item')]";
	public static final String OCR_Sales_PartNo = "//input[@id='searchSalesOrder_invoiceItem_partNo']";
	public static final String OCR_Sales_Description = "//textarea[@id='searchSalesOrder_invoiceItem_description']";
	public static final String OCR_Sales_ExportLabel = "//font[contains(text(),'Export Control')]";
	public static final String OCR_Sales_ExportClassification = "//input[@id='searchSalesOrder_invoiceItem_exportClassEccnUsml']";
	public static final String OCR_Sales_AuthorisationNo = "//input[@id='searchSalesOrder_invoiceItem_licenseNo']";
	public static final String OCR_Sales_AuthorisationType = "//input[@id='searchSalesOrder_invoiceItem_licenseException']";
	public static final String OCR_Sales_Search = "//button[@id='searchInvoiceBtn']";

	/* ******************************* Constructor ****************************** */

	public SalesOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Add SalesOrder Button action

	public void click_AddSalesOrderBtn() {
		clickElement(driver, test, OCR_SalesOrderPage_AddSalesOrderBtn, "Click on Add Sales Order Button");
	}

	public void enter_SalesOrderNo(String SalesOrderNo) {
		typeText(driver, test, OCR_SalesOrderPage_SalesorderNoInput, "Enter Sales Order number : ", SalesOrderNo);
	}

	// Search Criteria based on Sales Header
	public void search_SalesorderNo(String SalesOrderNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Sales_SalesOrderNo, "Enter the Sales Order No :  ", SalesOrderNo);
		
	}
	public void search_WorkStatus(String WorkStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_Sales_WorkStatus, "Select the Work Status : ", WorkStatus);
		
	}
	/*public void search_ShipNo(String ShipmentNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Sales_ShipmentNo, "Enter the Shipment No : ", ShipmentNo);
		
	}*/
	/*public void search_ECStatus(String ECStatus) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Sales_ECStatus, "Enter the ECStatus : ", ECStatus);
		
	}*/
	public void search_WLStatus(String WLSStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_Sales_WLSStatus, "Select the WLS Status : ", WLSStatus);
		
	}
	public void searchSalesHeader(String SalesOrderNo, String WorkStatus, String ShipmentNo, String ECStatus,
			String WLSStatus) {
		if(SalesOrderNo.length() > 0) {
			typeText(driver, test, OCR_Sales_SalesOrderNo, "Enter the Sales Order No :  ", SalesOrderNo);
		}
		if(WorkStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_Sales_WorkStatus, "Select the Work Status : ", WorkStatus);
		}
		if(ShipmentNo.length() > 0) {
			typeText(driver, test, OCR_Sales_ShipmentNo, "Enter the Shipment No : ", ShipmentNo);
		}
		if(ECStatus.length() > 0) {
			typeText(driver, test, OCR_Sales_ECStatus, "Enter the ECStatus : ", ECStatus);
		}
		if(WLSStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_Sales_WLSStatus, "Select the WLS Status : ", WLSStatus);
		}
	}

	// Search Criteria based on Invoice Item
	public void searchInvoiceItem(String PartNo, String Description) {
		scrollToElement(driver, OCR_Sales_InvoiceItemLabel);
		clickElement(driver, test, OCR_Sales_InvoiceItemLabel, " click on Invoice Item Label");
		if(PartNo.length() > 0) {
			typeText(driver, test, OCR_Sales_PartNo, "Enter the Part no :", PartNo);
		}
		if(Description.length() > 0) {
			typeText(driver, test, OCR_Sales_Description, "Enter the Description : ", Description);
		}
	}

	// Search by Export Control
	public void searchExport(String ExportClassification, String AuthorisationNo, String AuthorisationType) {
		if(ExportClassification.length() > 0 || AuthorisationNo.length() > 0 || AuthorisationType.length() > 0)
		scrollToElement(driver, OCR_Sales_ExportLabel);
		clickElement(driver, test, OCR_Sales_ExportLabel, "Click on Export Control Label");
		if(ExportClassification.length() > 0) {
			typeText(driver, test, OCR_Sales_ExportClassification, "Enter the Export Classification : ", ExportClassification);
		}
		if(AuthorisationNo.length() > 0) {
			typeText(driver, test, OCR_Sales_AuthorisationNo, "Enter the Authorisation No : ", AuthorisationNo);
		}
		if(AuthorisationType.length() > 0) {
			typeText(driver, test, OCR_Sales_AuthorisationType, "Enter the Authorisation Type : ", AuthorisationType);
		}
	}


	public void click_SearchButton() {
		scrollToElement(driver, OCR_SalesOrderPage_SalesOrderNoSearch);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SalesOrderPage_SalesOrderNoSearch,
				"Click on Search Button to search for an existing Sales order");
	}

}
