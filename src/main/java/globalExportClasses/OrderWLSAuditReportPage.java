package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class OrderWLSAuditReportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	
	public static final String OCR_OrderWLSAuditReportPage_SBUCode = "//select[@id='shipment.sbuCode']";
	public static final String OCR_OrderWLSAuditReportPage_INVNo = "//input[@id='resultOrderWlsAuditReport_invoiceNumber']";
	public static final String OCR_OrderWLSAuditReportPage_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_OrderWLSAuditReportPage_ValidateHeading = "//h3[contains(text(),'Order WLS Audit Report')]";
	public static final String OCR_OrderWLSAuditReportPage_ShipmentNo = "//input[@name='shipment.shipmentNo']";
	public static final String OCR_OrderWLSAuditReportPage_DeliveryOrder ="//input[@name='deliveryOrderNo']";
	public static final String OCR_OrderWLSAuditReportPage_CountryUltDest ="//input[@name='shipment.countryOfUltDest']";
	public static final String OCR_OrderWLSAuditReportPage_ShippedFrom = "//input[@name='shipment.countryShippedFrom']";
	public static final String OCR_OrderWLSAuditReportPage_Cr_FromDate = "//input[@id='resultOrderWlsAuditReport_createdFrom']";
	public static final String OCR_OrderWLSAuditReportPage_Cr_ToDate ="//input[@id='resultOrderWlsAuditReport_createdTo']";
	public static final String OCR_OrderWLSAuditReportPage_Exp_FromDate ="//input[@id='resultOrderWlsAuditReport_dateOfExportFrom']";
	public static final String OCR_OrderWLSAuditReportPage_Exp_ToDate= "//input[@id='resultOrderWlsAuditReport_dateOfExportTo']";
	public static final String OCR_OrderWLSAuditReportPage_Expor_Code= "//input[@name='shipment.exporterCode']";
	public static final String OCR_Today = "//button[@data-handler='today']";
	
	
	
	/* ******************************* Constructor ****************************** */

	public OrderWLSAuditReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBUCode(String SBUcode) {
		selectByVisibleText(driver, test, OCR_OrderWLSAuditReportPage_SBUCode, "Select SBU Code : ", SBUcode);
		Wait.waitfor(2);
	}
	
	public void enterInvNo(String INVNo) {
		typeText(driver, test, OCR_OrderWLSAuditReportPage_INVNo, "Enter Invoice Number : ", INVNo);
		Wait.waitfor(2);
	}
	public void searchbyparameter (String SBUcode, String ShipmentNo, String InvoiceNo, String DeliveryNo,
			String ExportCode, String CountryUltDest, String FromDate, String EndDate, String ExpoDatefrom, 
			String ExpoDateTo, String CountryShippedFrom) {
		if(SBUcode.length() > 0) {
			selectByVisibleText(driver, test, OCR_OrderWLSAuditReportPage_SBUCode, "Select SBU Code", SBUcode);
		}
		if(ShipmentNo.length() > 0) {
			typeText(driver, test, OCR_OrderWLSAuditReportPage_ShipmentNo, "Enter Shipment No", ShipmentNo);
		}
		if(InvoiceNo.length() > 0) {
			typeText(driver, test, OCR_OrderWLSAuditReportPage_INVNo, "Enter INVNo", InvoiceNo);
		}
		if(DeliveryNo.length() > 0) {
			typeText(driver, test, OCR_OrderWLSAuditReportPage_DeliveryOrder, "Enter DO", DeliveryNo);
		}
		if(ExportCode.length() > 0) {
			typeText(driver, test, OCR_OrderWLSAuditReportPage_Expor_Code, "Enter Exporter Code", ExportCode);
		}
		if(CountryUltDest.length() > 0) {
			typeText(driver, test,OCR_OrderWLSAuditReportPage_CountryUltDest, "Country of ult.Dest", CountryUltDest);
		}
		if (FromDate.length() > 0) {
			clickElement(driver, test,OCR_OrderWLSAuditReportPage_Cr_FromDate, "Click on From date");
			if (FromDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", FromDate);
			}
		}
		if (EndDate.length() > 0) {
			clickElement(driver, test, OCR_OrderWLSAuditReportPage_Cr_ToDate, "Click on End date");
			if (EndDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", EndDate);
			}
		}
		if (ExpoDatefrom.length() > 0) {
			clickElement(driver, test,OCR_OrderWLSAuditReportPage_Exp_FromDate, "Click on From date");
			if (ExpoDatefrom.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
				} else {
					dateOfMonthName(driver, test, "Select date", ExpoDatefrom);
				}
			}
		if (ExpoDateTo.length() > 0) {
			clickElement(driver, test, OCR_OrderWLSAuditReportPage_Exp_ToDate, "Click on End date");
			if (ExpoDateTo.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
				} else {
					dateOfMonthName(driver, test, "Select date", ExpoDateTo);
				}
			}
		if(CountryShippedFrom.length() > 0) {
			typeText(driver, test, OCR_OrderWLSAuditReportPage_ShippedFrom, "Enter Countrey Shipped From", CountryShippedFrom);
		}
	}
	
	public void searchbtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_OrderWLSAuditReportPage_SearchBtn, "Click on Search Button");
	}
	
	public void validateHeading() {
		isDisplayed(driver, OCR_OrderWLSAuditReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Order WLS Audit Report page is Displayed");
		Wait.waitfor(3);
	}

}
