package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class PackingListPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_PackingListPage_AddPackingListBtn = "(//button[@data-ocr-role='ajax-link'])[1]";
	public static final String OCR_CreatePackingListPage_SearchPackingListBtn = "//button[@name='Search']";
	public static final String OCR_CreatePackingListPage_SearchPackingListRecord = "//input[@id='searchPackinglist_packinglist_packinglistNo']";
	public static final String OCR_CreatePackingListPage_EnterPackingListNo = "//input[@id='searchPackinglist_packinglist_packinglistNo']";
	public static final String OCR_PackingListPage_AddPackingListFromShipmentBtn = "//button[contains(text(),'Add Packing List From Shipment')]";
	public static final String OCR_PackingListPage_SbuCode = "//select[@id='searchPackinglist_packinglist_sbuCode']";
	public static final String OCR_PackingListPage_Exporter = "(//a[contains(text(),'Exporter')])[2]";
	public static final String OCR_PackingListPage_DateOfExport = "//input[@id='searchPackinglist_dateOfExport']";
	public static final String OCR_PackingListPage_Consigneename = "//input[@id='searchPackinglist_packinglist_ultimateConsigneeName']";
	public static final String OCR_PackingListPage_DateofArrival = "//input[@id='searchPackinglist_dateOfArrival']";
	public static final String OCR_PackingListPage_ShipmentNo = "//input[@id='searchPackinglist_packinglist_shipmentNo']";
	public static final String OCR_PackingListPage_Status = "//select[@id='searchPackinglist_packinglist_status']";
	public static final String OCR_PackingListPage_CreatedBy = "//select[@id='searchPackinglist_packinglist_createdBy']";
	public static final String OCR_PackingListPage_Resetbtn = "//button[contains(text(),'Reset')]";
	public static final String OCR_PackingListPage_Today = "(//button[contains(text(),'Today')])[1]";

	/* ******************************* Constructor ****************************** */

	public PackingListPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void addPackingList() {

		Wait.waitfor(3);
		clickElement(driver, test, OCR_PackingListPage_AddPackingListBtn, "Click on Add Packing List button");

	}

	// perform general search operation
	public void searchBtn() {
		clickElement(driver, test, OCR_CreatePackingListPage_SearchPackingListBtn, "Click on Search Button");
	}

	// enter packing list number
	public void enter_PackingListNo(String packListNo) {
		typeText(driver, test, OCR_CreatePackingListPage_EnterPackingListNo, "Enter packing List Number : ",
				packListNo);
	}

	// search packing list number
	public void search() {
		clickElement(driver, test, OCR_CreatePackingListPage_SearchPackingListBtn,
				"Click on Search Button to search for a specific packing list");
	}

	// click on Add packing list from shipment
	public void addPLFromShipment() {
		clickElement(driver, test, OCR_PackingListPage_AddPackingListFromShipmentBtn,
				"Click on Add Packing List From Shipment button");
	}

	public void searchByParameter(String SbuCode, String plNum, String exporter, String DateOfExport,
			String consigneeName, String DateOfArrival, String shipmentNum, String Status, String createdBy) {
		Wait.waitfor(2);
		if (SbuCode.length() > 0) {
			selectByVisibleText(driver, test, OCR_PackingListPage_SbuCode, "Select SBU Code : ", SbuCode);
		}
		if (plNum.length() > 0) {
			typeText(driver, test, OCR_CreatePackingListPage_EnterPackingListNo, "Enter packing List Number : ",
					plNum);
		}
		try {
			if (exporter.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_PackingListPage_Exporter, "CLick on Exporter link :");
				typeText(driver, test, "//input[@id='searchForm_exporter_expCode']", "ENter Exporter Code : ",
						exporter);
				clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']",
						"Click on Search button :");
				clickElement(driver, test, "//td[contains(text(),'" + exporter + "')]", exporter);
				clickElement(driver, test, "(//button[@name='Ok'])[1]", "Click on Select button :");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Click on Close popup icon");
		}
		if(DateOfExport.length() > 0) {
			clickElement(driver, test, OCR_PackingListPage_DateOfExport, "Clicking on Date Of Export :");
			if(DateOfExport.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_PackingListPage_Today, "Clicking on Today :");
			}else {
				dateOfMonthName(driver, test, "Selecting Date Of Export :", DateOfExport);
			}
		}
		if (consigneeName.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, OCR_PackingListPage_Consigneename, "Click on Consignee name : ", consigneeName);

		}
		if(DateOfArrival.length() > 0) {
			clickElement(driver, test, OCR_PackingListPage_DateofArrival, "Clicking on Date Of Arrival :");
			if(DateOfArrival.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_PackingListPage_Today, "Clicking on Today :");
			}else {
				dateOfMonthName(driver, test, "Selecting Date Of Arrival :", DateOfArrival);
			}
		}
		if (shipmentNum.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, OCR_PackingListPage_ShipmentNo, "Enter SHipment Number : ", shipmentNum);
		}
		if (Status.length() > 0) {
			selectByVisibleText(driver, test, OCR_PackingListPage_Status, "Select Status : ", Status);
		}
		if (createdBy.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_PackingListPage_CreatedBy, "Select Created By :", createdBy);
		}
	}
	
	public void resetBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_PackingListPage_Resetbtn, "Click on Reset Button :");
	}

	public void shipNum(String shipmentNum) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_PackingListPage_ShipmentNo, "Enter SHipment Number : ", shipmentNum);
	}
	
	public void sbu(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//select[@id='searchPackinglist_packinglist_sbuCode']", "Select sbu code : ", SbuCode);
	}
	
	public void exporter(String Exporter) {
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='searchPackinglist_packinglist_exporterCode']", "Enter Exporter : ", Exporter);
	}
}
