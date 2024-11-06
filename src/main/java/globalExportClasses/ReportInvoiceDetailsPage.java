package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ReportInvoiceDetailsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH  ="(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RESET  ="(//button[@type='reset'])[1]";
	public static final String OCR_SBUCODE ="//select[@name='shipment.sbuCode']";
	public static final String OCR_InvoiceNo ="//input[@name='invoice.invoiceNo']";
	public static final String OCR_ShipmentNo ="//input[@name='invoice.shipmentNo']";
	public static final String OCR_WorkStatus ="//select[@name='invoice.workStatus']";
	public static final String OCR_shipTO="//input[@id='searchInvoiceReport_invoice_shipToName']";
	public static final String OCR_BillTo="//input[@id='searchInvoiceReport_invoice_shipToName']";
	public static final String OCR_EEIValue="//input[@id='searchInvoiceReport_sedValue']";
	public static final String OCR_UnitPrice="//input[@id='searchInvoiceReport_unitPrice']";

	/* ******************************** LOCATORS  Search 2******************************** */
	public static final String OCR_Domestic  ="(//input[@name='invoiceItem.domesticForeign'])[1]";
	public static final String OCR_Foreign  ="(//input[@name='invoiceItem.domesticForeign'])[2]";
	public static final String OCR_PartNo  = "//input[@name='invoiceItem.partNo']";

	//* ******************************* Constructor ****************************** *//

	public ReportInvoiceDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
	}
	/* ******************************* Action ****************************** */

	//clicking on Search 
	public void search () {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}
	//Click on Reset
	public void reset () {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}
	//Search by parameter
	public void parameter (String Sbu, String InvoiceNo, String Status, String ShipmentNo, String PartNo,
			String partytype, String ShipTO, String BillTO, String EEIValue, String UnitPrice) {
		
		if(Sbu.length() > 0) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Select SBU", Sbu);
		}
		if(InvoiceNo.length() > 0) {
			typeText(driver, test, OCR_InvoiceNo, "Enter Invoice No", InvoiceNo);
		}
		if(Status.length() > 0) {
			selectByVisibleText(driver, test, OCR_WorkStatus, "Selecting Work Status", Status);
		}
		if(ShipmentNo.length() > 0) {
			typeText(driver, test, OCR_ShipmentNo, "Enter Shipment No", ShipmentNo);
		}
		scrollToElement(driver, OCR_PartNo);
		if(ShipTO.length() > 0) {
			typeText(driver, test, OCR_shipTO, "enter shipto ", ShipTO);
		}
		if(BillTO.length() > 0) {
			typeText(driver, test, OCR_BillTo, "enter Bill to", BillTO);
		}
		if(EEIValue.length() > 0) {
			typeText(driver, test, OCR_EEIValue, "enter EEI value", EEIValue);
		}
		if(UnitPrice.length() > 0) {
			typeText(driver, test, OCR_UnitPrice, "enter uit price", UnitPrice);
		}	
		if (partytype.equalsIgnoreCase("Domestic")) {
			clickElement(driver, test, OCR_Domestic, "CLick on Domestic");
		}
		else if(partytype.equalsIgnoreCase("Foreign")){
			clickElement(driver, test, OCR_Foreign, "Click on Foreign");
		}
		scrollToElement(driver, OCR_SEARCH);
		}
		
	}

