package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ReportInvoiceSummaryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH  ="(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RESET  ="(//button[@type='reset'])[1]";
	public static final String OCR_SBUCODE ="//select[@name='shipment.sbuCode']";
	public static final String OCR_InvoiceNo ="//input[@name='invoice.invoiceNo']";
	public static final String OCR_ShipmentNo ="//input[@name='invoice.shipmentNo']";
	public static final String OCR_CountryofUltDest ="//input[@name='invoice.countryOfUltDest']";
	public static final String OCR_ShipTo="//input[@id='searchInvoiceReportSummary_invoice_shipToName']";
	public static final String OCR_BillTo="//input[@id='searchInvoiceReportSummary_invoice_billToName']";
	public static final String OCR_UnitPrice="//input[@id='searchInvoiceReportSummary_unitPrice']";
	public static final String OCR_ECCN="//input[@id='searchInvoiceReportSummary_invoiceItem_productClassification']";
	public static final String OCR_AuthNo="//input[@id='searchInvoiceReportSummary_invoiceItem_licenseNo']";

	/* ******************************** LOCATORS  Search 2******************************** */
	public static final String OCR_Domestic  ="(//input[@name='invoiceItem.domesticForeign'])[1]";
	public static final String OCR_Foreign  ="(//input[@name='invoiceItem.domesticForeign'])[2]";
	public static final String OCR_PartNo  = "//input[@name='invoiceItem.partNo']";
	public static final String OCR_CountryOfOrigin  = "//input[@name='invoiceItem.countryOfOriginName']";
	
	//* ******************************* Constructor ****************************** *//

		public ReportInvoiceSummaryPage(WebDriver driver, ExtentTest test) {
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
		public void parameter (String Sbu, String InvoiceNo, 
				String ShipmentNo, String CountryofultDest , String PartNo ,String CountryOfOrigin,String partytype, String ShipTo, String BillTo, String UnitPrice, String ECCN, String AuthNo) {
			
			selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
			typeText(driver, test, OCR_InvoiceNo, "Enter Invoice No", InvoiceNo);
			typeText(driver, test, OCR_ShipmentNo, "Enter Shipment No", ShipmentNo);
			typeText(driver, test, OCR_CountryofUltDest, "Enter country of ult dest.", CountryofultDest);
			scrollToElement(driver, OCR_PartNo);
			typeText(driver, test, OCR_PartNo, "enter Part no", PartNo);
			Wait.waitfor(1);
			typeText(driver, test, OCR_CountryOfOrigin, "Enter Country Of Origin", CountryOfOrigin);
			Wait.waitfor(1);
			typeText(driver, test, OCR_ShipTo, "enter Part no", ShipTo);
			Wait.waitfor(1);
			typeText(driver, test, OCR_BillTo, "enter Part no", BillTo);
			Wait.waitfor(1);
			typeText(driver, test, OCR_UnitPrice, "enter Part no", UnitPrice);
			Wait.waitfor(1);
			typeText(driver, test, OCR_ECCN, "enter Part no", ECCN);
			Wait.waitfor(1);
			typeText(driver, test, OCR_AuthNo, "enter Part no", AuthNo);
			Wait.waitfor(1);
			
			if (partytype.equalsIgnoreCase("Domestic")) {
				clickElement(driver, test, OCR_Domestic, "CLick on Domestic");
			}
			else if(partytype.equalsIgnoreCase("Foreign")){
				clickElement(driver, test, OCR_Foreign, "Click on Foreign");
			}
			scrollToElement(driver, OCR_SEARCH);
			}

}
