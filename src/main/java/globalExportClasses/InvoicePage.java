package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class InvoicePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	// Search Criteria based on Invoice Item
	public static final String OCR_InvoicePage_AddInvoiceBtn = "//button[contains(text(),'Add Invoice')]";
	public static final String OCR_InvoicePage_InvoiceOrderNoInput = "//input[@id='searchInvoice_invoice_invoiceNo']";
	public static final String OCR_InvoicePage_InvoiceOrderNoSearch = "//button[@id='searchInvoiceBtn']";
	public static final String OCR_InvoicePage_InvoiceNo = "//input[@id='searchInvoice_invoice_invoiceNo']";
	public static final String OCR_InvoicePage_WorkStatus = "//select[@id='searchInvoice_invoice_workStatus']";
	public static final String OCR_InvoicePage_ShipmentNo = "//input[@id='searchInvoice_invoice_shipment_shipmentNo']";
	public static final String OCR_InvoicePage_LSStatus = "//select[@id='searchInvoice_invoice_eldsStatus']";
	public static final String OCR_InvoicePage_InvoiceItemLabel = "//font[contains(text(),'Search Criteria based on Invoice Item')]";
	public static final String OCR_InvoicePage_PartNo = "//input[@id='searchInvoice_invoiceItem_partNo']";
	public static final String OCR_InvoicePage_Description = "//textarea[@id='searchInvoice_invoiceItem_description']";
	public static final String OCR_InvoicePage_EClabel = "//font[contains(text(),'Export Control')]";
	public static final String OCR_InvoicePage_ExportClassification = "//input[@id='searchInvoice_invoiceItem_productClassification']";
	public static final String OCR_InvoicePage_AuthorisationNo = "//input[@id='searchInvoice_invoiceItem_licenseNo']";
	
	public static final String OCR_InvoicePage_Regres_SelectSBU = "//select[@id='invoice.sbuCode']";
	public static final String OCR_InvoicePage_Regres_SelectWorkStatus = "//select[@id='searchInvoice_invoice_workStatus']";
	public static final String OCR_InvoicePage_Regres_SearchCriteriaOnInvItem = "//font[contains(text(),'Search Criteria based on Invoice Item')]";
	public static final String OCR_InvoicePage_Regres_SelectDomesticRadioBtn = "(//input[@name='invoiceItem.domesticForeign'])[1]";
	public static final String OCR_InvoicePage_Regres_EnterPartNo = "//input[@id='searchInvoice_invoiceItem_partNo']";
	public static final String OCR_InvoicePage_Regres_EnterUnitPrice = "//input[@id='searchInvoice_invoiceItem_unitPrice']";
	public static final String OCR_InvoicePage_Regres_EnterUltDest = "//input[@id='searchInvoice_invoice_countryOfUltDest']";
	
	/* ******************************* Constructor ****************************** */

	public InvoicePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Add Invoice Order Button action
	public void click_AddInvoiceBtn() {
		clickElement(driver, test, OCR_InvoicePage_AddInvoiceBtn, "Click on Add Invoice Button");
	}

	// Enter the Invoice NO
	public void enter_InvoiceOrderNo(String InvOrderNo) {
		Wait.waitfor(5);
		typeText(driver, test, OCR_InvoicePage_InvoiceOrderNoInput, "Enter Invoice Order number : ", InvOrderNo);
	}

	// CLick on Search Button
	public void click_SearchButton() {
		scrollToElement(driver, OCR_InvoicePage_InvoiceOrderNoSearch);
		clickElement(driver, test, OCR_InvoicePage_InvoiceOrderNoSearch,
				"Click on Search Button to search for an existing invoice order");
		Wait.waitfor(2);
	}

	// Search the Criteria based on Invoice Header
	public void search_InvNo(String InvoiceNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoicePage_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
	}
	public void search_WorkStatus(String WorkStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoicePage_WorkStatus, "Select the Work Status : ", WorkStatus);
	}
	
	public void search_ShipNo(String ShipmentNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoicePage_ShipmentNo, "Enter the Shipment No : ", ShipmentNo);
	}
	
	public void search_LSStatus(String LSStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoicePage_LSStatus, "Select the LS Status : ", LSStatus);
	}
	
	//Enter Approved invoice for Regression US
	public void approvedInvoice(String InvoiceNo, String workStatus) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoicePage_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoicePage_Regres_SelectWorkStatus, "Select Work Status : ", workStatus);
		
	}
	

	// Search Criteria based on Invoice Item
	public void searchInvoiceItem(String PartNo, String Description) {
		scrollToElement(driver, OCR_InvoicePage_InvoiceItemLabel);
		clickElement(driver, test, OCR_InvoicePage_InvoiceItemLabel, "Click on Invoice Item Label");
		typeText(driver, test, OCR_InvoicePage_PartNo, "Enter the Part NO : ", PartNo);
		typeText(driver, test, OCR_InvoicePage_Description, "Enter the Description : ", Description);
	}

	// Search Export Control
	public void searchEC(String ExportClassification, String AuthorisationNo) {
		scrollToElement(driver, OCR_InvoicePage_EClabel);
		clickElement(driver, test, OCR_InvoicePage_EClabel, "Click on Export Control Label");
		typeText(driver, test, OCR_InvoicePage_ExportClassification, "Enter the Export Classification : ",
				ExportClassification);
		typeText(driver, test, OCR_InvoicePage_AuthorisationNo, "Enter the Authorisation No : ", AuthorisationNo);
	}
	
	public void selectSBU(String SBUCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoicePage_Regres_SelectSBU, "Select SBU Code : ", SBUCode);
	}
	
	public void criteriaBasedOnInvItem() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoicePage_Regres_SearchCriteriaOnInvItem);
		clickElement(driver, test, OCR_InvoicePage_Regres_SearchCriteriaOnInvItem, "Click on 'Search Criteria based on Invoice Item :'");
		
	}
	
	public void selectDomesticSBUCode(String SbuCode) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoicePage_Regres_SelectDomesticRadioBtn, "Select Domestic radio button :");
		scrollToElement(driver, OCR_InvoicePage_Regres_SelectSBU);
		selectByVisibleText(driver, test, OCR_InvoicePage_Regres_SelectSBU, "Select SBU Code : ", SbuCode);
	}
	
	public void selectDomesticPartNo(String PartNo) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoicePage_Regres_SelectDomesticRadioBtn, "Select Domestic radio button :");
		scrollToElement(driver, OCR_InvoicePage_Regres_EnterPartNo);
		typeText(driver, test, OCR_InvoicePage_Regres_EnterPartNo, "Enter Part number : ", PartNo);
	}
	
	public void selectUnitPricePartNo(String PartNum, String UnitPrice) {
		Wait.waitfor(2);
//		clickElement(driver, test, OCR_InvoicePage_Regres_SelectDomesticRadioBtn, "Select Domestic radio button :");
		scrollToElement(driver, OCR_InvoicePage_Regres_EnterPartNo);
		typeText(driver, test, OCR_InvoicePage_Regres_EnterPartNo, "Enter Part number : ", PartNum);
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoicePage_Regres_EnterUnitPrice, "Enter Unit Price : ", UnitPrice);
	}
	
	//enter ult destination
	public void enterUltDestination(String UltDestination) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoicePage_Regres_EnterUltDest);
		typeText(driver, test, OCR_InvoicePage_Regres_EnterUltDest, "Enter Ult Destiantion : ", UltDestination);
	}
	
	//Search with Parameters
	public void searchWithParameters(String InvoiceNo, String workStatus, String ShipmentNo, String LSStatus, 
			String PartNo, String Description) {
		if(InvoiceNo.length() > 0) {
			typeText(driver, test, OCR_InvoicePage_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
		}
		if(workStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_InvoicePage_Regres_SelectWorkStatus, "Select Work Status : ", workStatus);
		}
		if(ShipmentNo.length() > 0) {
			typeText(driver, test, OCR_InvoicePage_ShipmentNo, "Enter the Shipment No : ", ShipmentNo);
		}
		if(LSStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_InvoicePage_LSStatus, "Select the LS Status : ", LSStatus);
		}
		if(PartNo.length() > 0) {
			typeText(driver, test, OCR_InvoicePage_PartNo, "Enter the Part NO : ", PartNo);
		}
		if(Description.length() > 0) {
			typeText(driver, test, OCR_InvoicePage_Description, "Enter the Description : ", Description);
		}
	}
}
