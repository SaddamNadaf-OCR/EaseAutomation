package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ReportShipmentAESPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "(//button[contains(text(),'Search')])";
	public static final String OCR_RESET = "(//button[@type='reset'])";
	public static final String OCR_SBUCODE = "//select[@name='shipmentValue.sbuCode']";
	public static final String OCR_ShipmentNo = "//input[@name='shipmentValue.shipmentNo']";
	public static final String OCR_FromDateOfExport = "//input[@name='fromDateOfExport']";
	public static final String OCR_ToDateOfExport = "//input[@name='toDateOfExport']";
	public static final String OCR_ExporterCode = "//input[@name='shipmentValue.exporterCode']";
	public static final String OCR_UltConsName = "//input[@name='shipmentValue.ultConsName']";
	public static final String OCR_AES_Status = "//select[@name='shipmentValue.shipmentCustomFilingStatus']";
	public static final String OCR_AES_Option = "//select[@name='shipmentValue.aesOption']";
	public static final String OCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_Direction = "//select[@name='direction']";
	public static final String OCR_Today = "//button[contains(text(),'Today')]";

	// * ************************** Constructor *****************************//

	public ReportShipmentAESPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}

	// Search by parameter
	public void parameter(String Sbu, String ShipmentNo, String ExportFromDate, String ExportToDate,
			String status, String Options, String SortBy, String Direction) {
		selectByVisibleText(driver, test, OCR_SBUCODE, "Enter Sbu code", Sbu);
		typeText(driver, test, OCR_ShipmentNo, "Enter shipment No", ShipmentNo);
		if(ExportFromDate.length() > 0) {
			clickElement(driver, test, OCR_FromDateOfExport, "Clicking on Export From Date :");
			try {
				if(ExportFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					date(driver, test, "Selecting the Export From Date :", ExportFromDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enabled to select the Date :");
			}
		}
		if(ExportToDate.length() > 0) {
			clickElement(driver, test, OCR_ToDateOfExport, "Clicking on Export To Date :");
			try {
				if(ExportToDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					date(driver, test, "Selecting the Export To Date :", ExportToDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enabled to select the Date :");
			}
		}
		selectByVisibleText(driver, test, OCR_AES_Status, "AES STATUS", status);
		selectByVisibleText(driver, test, OCR_AES_Option, "AES OPTIONS", Options);
		selectByVisibleText(driver, test, OCR_SortBy, "Selecting Sort by :", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Selecting Direction :", Direction);
		scrollToElement(driver, OCR_SEARCH);
	}
}
