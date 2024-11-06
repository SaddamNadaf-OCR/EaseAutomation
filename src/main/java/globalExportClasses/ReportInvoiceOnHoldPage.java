package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ReportInvoiceOnHoldPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH  ="(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RESET  ="(//button[@type='reset'])[1]";
	public static final String OCR_SBUCODE ="//select[@name='selectSbu']";
	public static final String OCR_InvoiceNo ="//input[@name='invoice.invoiceNo']";
	public static final String OCR_ShipmentNo ="//input[@name='invoice.shipmentNo']";
	public static final String OCR_CountryofUltDest ="//input[@name='invoice.countryOfUltDest']";

	/* ******************************** LOCATORS  Search 2******************************** */
	public static final String OCR_Domestic  ="(//input[@name='invoiceItem.domesticForeign'])[1]";
	public static final String OCR_Foreign  ="(//input[@name='invoiceItem.domesticForeign'])[2]";
	public static final String OCR_PartNo  = "//input[@name='invoiceItem.partNo']";
	
	//* ******************************* Constructor ****************************** *//

		public ReportInvoiceOnHoldPage(WebDriver driver, ExtentTest test) {
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
				String ShipmentNo, String CountryofultDest , String PartNo ,String partytype) {
			
			selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
			typeText(driver, test, OCR_InvoiceNo, "Enter Invoice No", InvoiceNo);
			typeText(driver, test, OCR_ShipmentNo, "Enter Shipment No", ShipmentNo);
			typeText(driver, test, OCR_CountryofUltDest, "Enter country of ult dest.", CountryofultDest);
			scrollToElement(driver, OCR_PartNo);
			typeText(driver, test, OCR_PartNo, "enter Part no", PartNo);
			
			if (partytype.equalsIgnoreCase("Domestic")) {
				clickElement(driver, test, OCR_Domestic, "CLick on Domestic");
			}
			else if(partytype.equalsIgnoreCase("Foreign")){
				clickElement(driver, test, OCR_Foreign, "Click on Foreign");
			}
			scrollToElement(driver, OCR_SEARCH);
			}


}
