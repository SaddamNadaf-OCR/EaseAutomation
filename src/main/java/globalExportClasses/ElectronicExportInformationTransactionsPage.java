package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ElectronicExportInformationTransactionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EEIT_SBU = "//select[@id='searchSed_shipment_sbuCode']";
	public static final String OCR_EEIT_Search = "//button[@id='shipment-submit']";
	public static final String OCR_EEIT_ExporterCode = "//input[@id='searchSed_shipment_exporterCode']";
	public static final String OCR_EEIT_ShipmentWorkStatus = "//select[@id='searchSed_shipment_shipmentWorkStatus']";
	public static final String OCR_EEIT_OrderNo = "//input[@id='searchSed_invoice_invoiceNo']";
	public static final String OCR_EEIT_SalesOrderNo = "//input[@id='searchSed_invoice_orderNo']";
	public static final String OCR_EEIT_PartNo = "//input[@id='searchSed_invoiceItem_partNo']";
	public static final String OCR_EEIT_AuthorizationNo = "//input[@id='searchSed_invoiceItem_licenseNo']";
	public static final String OCR_EEIT_AddEEIBtn = "(//button[@class='primary-btn ocr-cache-search-dynamic-class'])[2]";
	public static final String OCR_EEIT_ExporterCodeHyperlink = "//a[contains(text(),'Exporter Code')]";
	public static final String OCR_EEIT_ExporterCodePopupTextbox= "//input[@name='exporter.expCode']";
	public static final String OCR_EEIT_SearchPopupButton = "(//button[@name='Search'])[4]";
	public static final String OCR_EEIT_SelectPopupButton = "//button[@name='Ok']";

	// * ************************ Constructor ***************************** */

	public ElectronicExportInformationTransactionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Action ****************************** */

	// Serch the E E I T
	public void searchEEIT(String SBU, String ExportCode, String ShipmentWorkStatus, String OrderNo,
			String SalesOrderNo, String PartNo, String AuthorizationNo) {
		selectByVisibleText(driver, test, OCR_EEIT_SBU, "Select the SBU : ", SBU);
		typeText(driver, test, OCR_EEIT_ExporterCode, "Enter the Export code : ", ExportCode);
		selectByVisibleText(driver, test, OCR_EEIT_ShipmentWorkStatus, "Select the Shipment Work Status : ",
				ShipmentWorkStatus);
		scrollToElement(driver, OCR_EEIT_OrderNo);
		typeText(driver, test, OCR_EEIT_OrderNo, "Enter the Order No : ", OrderNo);
		typeText(driver, test, OCR_EEIT_SalesOrderNo, "Enter the Sales Order No : ", SalesOrderNo);
		typeText(driver, test, OCR_EEIT_PartNo, "Enter the Part No : ", PartNo);
		typeText(driver, test, OCR_EEIT_AuthorizationNo, "Enter the Authorization No : ", AuthorizationNo);
	}

	// Click on Search button
	public void clickSearch() {
		scrollToElement(driver, OCR_EEIT_Search);
		scrollToTop(driver);
		clickElement(driver, test, OCR_EEIT_Search, "Click on Search ");
	}
	
	public void clickAddEEI() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_EEIT_AddEEIBtn, "Click on Add EEI button :");
	}
	
	//Click on Exporter Code Hyper Link
	public void exporterLink(String ExporterCode) {
		clickElement(driver, test, OCR_EEIT_ExporterCodeHyperlink, "Clicking on Exporter Code hyperlink :");
		try {
			typeText(driver, test, OCR_EEIT_ExporterCodePopupTextbox, "Entering Exporter Code :", ExporterCode);
			clickElement(driver, test, OCR_EEIT_SearchPopupButton, "Clicking on Search Button :");
			clickElement(driver, test, "//td[contains(text(),'"+ExporterCode+"')]", "Selecting Exporter Code :");
			clickElement(driver, test, OCR_EEIT_SelectPopupButton, "Clicking on Select Button :");
			if(ExporterCode.length() > 50) {
				clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Clicking on Close Popup Icon :");				
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enabled to Add Exporter Code :");
		}
	}
	
	// Serch the E E I T
	public void searchShipmentStatus(String ShipmentWorkStatus) {
		selectByVisibleText(driver, test, OCR_EEIT_ShipmentWorkStatus, "Select the Shipment Work Status : ",ShipmentWorkStatus);
	}
	
	public void shipmentNo(String ShipNumber) {
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='searchSed_shipment_shipmentNo']", "Enter Shipment number : ", ShipNumber);
	}

}
