package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipmentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GEShipment_AddShipment = "//button[contains(text(),'Shipment')]";
	public static final String OCR_GEShipment_ShipmentNo = "//input[@id='searchShipment_shipment_shipmentNo']";
	public static final String OCR_GEShipment_ShipmentWorkStatus = "//select[@id='searchShipment_shipment_shipmentWorkStatus']";
	public static final String OCR_GEShipment_ExporterCountry = "//input[@id='searchShipment_shipment_expCountryName']";
	public static final String OCR_GEShipment_UltDestination = "//input[@id='searchShipment_shipment_countryOfUltDest']";
	public static final String OCR_GEShipment_DateOfExportFrom = "//input[@id='searchShipment_fromDateOfExport']";
	public static final String OCR_GEShipment_DateOfExportTo = "//input[@id='searchShipment_toDateOfExport']";
	public static final String OCR_GEShipment_ModeofTransport = "//input[@id='searchShipment_shipment_modeOfTransport']";
	public static final String OCR_GEShipment_LSStatus = "//select[@id='searchShipment_eldsStatus']";
	public static final String OCR_GEShipment_OrderNo = "//input[@id='searchShipment_invoice_invoiceNo']";
	public static final String OCR_GEShipment_SalesOrderNo = "//input[@id='searchShipment_invoice_orderNo']";
	public static final String OCR_GEShipment_PartNo = "//input[@id='searchShipment_invoiceItem_partNo']";
	public static final String OCR_GEShipment_AuthorisationNo = "//input[@id='searchShipment_invoiceItem_licenseNo']";
	public static final String OCR_GEShipment_ExportClassification = "//input[@id='searchShipment_invoiceItem_exportClassEccnUsml']";
	public static final String OCR_GEShipment_Search = "//button[@id='shipment-submit']";
	public static final String OCR_GEShipment_SearchAssociatedLabel = "(//a//font[contains(text(),'Search')])[3]";
	public static final String OCR_GEShipment_SearchLinkOrder = "(//a//font[contains(text(),'Search')])[4]";
	//click on search button to search a shipment number for creating a packing list
	public static final String OCR_PackingListShipment_ShipNo = "//input[@id='searchShipmentForPackingList_shipment_shipmentNo']";
	public static final String OCR_PackingListShipment_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_SBUCODEselect="//select[@id='shipment.sbuCode']";
	public static final String OCR_ShipWorkStatus = "//select[@id='searchShipmentForPackingList_shipment_shipmentWorkStatus']";

	/* ******************************* Constructor ****************************** */

	public ShipmentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Add Shipment Button
	public void click_AddShipment() {
		clickElement(driver, test, OCR_GEShipment_AddShipment, "click on Add Shipment Button");
	}
	
	public void enter_ShpNo(String shipNum) {
		typeText(driver, test, OCR_GEShipment_ShipmentNo, "Enter Shipment number : ", shipNum);
	}
	
	// Click on Search btn
	public void click_Search() {
		scrollToElement(driver, OCR_GEShipment_Search);
		scrollToTop(driver);
		clickElement(driver, test, OCR_GEShipment_Search, "click on Search");
	}
	
	//enter shipment no for packing list
	public void enterShipNo(String ShipNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_PackingListShipment_ShipNo, "Enter Shipment Number : ", ShipNo);
	}
	
	//click on Search button of Packing List Shipment page----Pooja
	public void shipment_SearchBtn() {
		clickElement(driver, test, OCR_PackingListShipment_Search, "Click on Search button");
	}

	// Search shipment
	public void searchShipmentDetails(String ShipmentNo, String ExporterCountry, String ShipmentWorkStatus,
			String UltDestination, String DateOfExportFrom, String ModeofTransport, String LSStatus) {
		typeText(driver, test, OCR_GEShipment_ShipmentNo, "Enter the ShipmentNo : ", ShipmentNo);
		typeText(driver, test, OCR_GEShipment_ExporterCountry, "Enter the Exporter Country : ", ExporterCountry);
		selectByVisibleText(driver, test, OCR_GEShipment_ShipmentWorkStatus, "Select the Shipment Work Status : ",
				ShipmentWorkStatus);
		typeText(driver, test, OCR_GEShipment_UltDestination, "Enter the Ult.Destination : ", UltDestination);
		scrollToElement(driver, OCR_GEShipment_DateOfExportFrom);
		clickElement(driver, test, OCR_GEShipment_DateOfExportFrom, "Click on Date of Export From ");
		date(driver, test, "Select the Date : ", DateOfExportFrom);
		typeText(driver, test, OCR_GEShipment_ModeofTransport, "Enter the Mode of Transport : ", ModeofTransport);
		selectByVisibleText(driver, test, OCR_GEShipment_LSStatus, "Select the LS Status : ", LSStatus);
	}

	// Search Associated/ Linked Orders
	public void SearchAssociatedLinkedOrders(String OrderNo, String SalesOrderNo) {
		scrollToElement(driver, OCR_GEShipment_SearchAssociatedLabel);
		clickElement(driver, test, OCR_GEShipment_SearchAssociatedLabel,
				"Click on Search Associated/ Linked Orders Label");
		Wait.waitfor(3);
		typeText(driver, test, OCR_GEShipment_OrderNo, "Enter the Order No : ", OrderNo);
		typeText(driver, test, OCR_GEShipment_SalesOrderNo, "Enter the Sales Order No : ", SalesOrderNo);
	}

	// Search Associated/ Linked Orders Items
	public void SearchAssociatedLinkedOrdersItems(String PartNo, String AuthorisationNo, String ExportClassification) {
		scrollToElement(driver, OCR_GEShipment_SearchLinkOrder);
		clickElement(driver, test, OCR_GEShipment_SearchLinkOrder,
				"Click on Search Associated/ Linked Orders Items label");
		typeText(driver, test, OCR_GEShipment_PartNo, "Enter the Part No : ", PartNo);
		typeText(driver, test, OCR_GEShipment_AuthorisationNo, "Enter the Authorisation No : ", AuthorisationNo);
		typeText(driver, test, OCR_GEShipment_ExportClassification, "Enter the Export Classification : ",
				ExportClassification);

	}
	public void sbu_code(String SBUcode)
	{
		selectByVisibleText(driver, test, OCR_SBUCODEselect, "select sbu code", SBUcode);
	}
	
	public void workStatus(String ShipmentWorkStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_GEShipment_ShipmentWorkStatus, "Select the Shipment Work Status : ",
				ShipmentWorkStatus);
	}
	
	public void shipworkStatus(String ShipWorkStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_ShipWorkStatus, "Select the Shipment Work Status : ",ShipWorkStatus);
	}
}
