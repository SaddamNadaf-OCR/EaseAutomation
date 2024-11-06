package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import utilities.GenericMethods;
import utilities.Wait;

public class ShipmentWLSAuditReportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ShipmentWLSAuditReportPage_SBU = "//select[@id='shipment.sbuCode']";
	public static final String OCR_ShipmentWLSAuditReportPage_ShipNo = "//input[@id='resultShipmentWlsAuditReport_shipment_shipmentNo']";
	public static final String OCR_ShipmentWLSAuditReportPage_InvNo = "//input[@id='resultShipmentWlsAuditReport_invoiceNumber']";
	public static final String OCR_ShipmentWLSAuditReportPage_ExportCode ="//input[@name='shipment.exporterCode']";
	public static final String OCR_ShipmentWLSAuditReportPage_deliveryOrderNo ="//input[@name='deliveryOrderNo']";
	public static final String OCR_ShipmentWLSAuditReportPage_CountryOfUltDest = "//input[@name='shipment.countryOfUltDest']";
	public static final String OCR_ShipmentWLSAuditReportPage_CreatedOnFrom ="//input[@name='createdFrom']";
	public static final String OCR_ShipmentWLSAuditReportPage_CreatedOnEnd = "//input[@name='createdTo']";
	public static final String OCR_ShipmentWLSAuditReportPage_DateOfExportFrom  ="//input[@name='dateOfExportFrom']";
	public static final String OCR_ShipmentWLSAuditReportPage_dateOfExportTo = "//input[@name='dateOfExportTo']";
	public static final String OCR_Today = "//button[@data-handler='today']";
	public static final String OCR_ShipmentWLSAuditReportPage_countryShippedFrom="//input[@name='shipment.countryShippedFrom']";
	public static final String OCR_ShipmentWLSAuditReportPage_Searchbtn = "//button[contains(text(),'Search')]";
	public static final String OCR_ShipmentWLSAuditReportPage_ValidateHeading = "//h3[contains(text(),'Shipment WLS Audit Report')]";
	/* ******************************* Constructor ****************************** */

	public ShipmentWLSAuditReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_ShipmentWLSAuditReportPage_SBU, "Select SBU Code : ", sbu);
		
	}
	
	public void enterShpNo(String ShpNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_ShipNo, "Enter Shipment Number : ", ShpNo);
		
	}
	
	public void searchbyparametere (String ShpNo, String InvNo, String DeliveryNo, String Exportcode, String CountryOfUltDest, 
			String FromDate, String EndDate, String ExportFrom, String ExportTo, String countryShippedFrom) {
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_ShipNo, "Enter Shipment Number : ", ShpNo);
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_InvNo , "Enter Invoice No : ", InvNo);
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_deliveryOrderNo, "Enter DeliveryNo : ", DeliveryNo); 
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_ExportCode, "Enter Export code :", Exportcode);
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_CountryOfUltDest, "Enter CountryOfUltDest ", CountryOfUltDest);
		if (FromDate.length() > 0) {
			clickElement(driver, test,OCR_ShipmentWLSAuditReportPage_CreatedOnFrom , "Click on From date");
			if (FromDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", FromDate);
			}
		}
		if (EndDate.length() > 0) {
			clickElement(driver, test, OCR_ShipmentWLSAuditReportPage_CreatedOnEnd, "Click on End date");
			if (EndDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", EndDate);
			}
		}
		if (ExportFrom.length() > 0) {
			clickElement(driver, test, OCR_ShipmentWLSAuditReportPage_DateOfExportFrom, "Click on From date");
			if (ExportFrom.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", ExportFrom);
			}
		}
		if (ExportTo.length() > 0) {
			clickElement(driver, test, OCR_ShipmentWLSAuditReportPage_dateOfExportTo, "Click on End date");
			if (ExportTo.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", ExportTo);
			}
		}
		typeText(driver, test, OCR_ShipmentWLSAuditReportPage_countryShippedFrom, "Enter countryShippedFrom : ", countryShippedFrom);
	}
	
	
	
	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ShipmentWLSAuditReportPage_Searchbtn, "Click on Search Button");
	}

		public void validateHeading() {
			Wait.waitfor(3);
			isDisplayed(driver, OCR_ShipmentWLSAuditReportPage_ValidateHeading);
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "Shipment WLS Audit Report page is Displayed");
			Wait.waitfor(3);
		}
		



}
